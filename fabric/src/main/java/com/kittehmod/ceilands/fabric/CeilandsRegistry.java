package com.kittehmod.ceilands.fabric;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.entity.mob.CastleLord;
import com.kittehmod.ceilands.fabric.client.CeilandsSkyEffect;
import com.kittehmod.ceilands.item.CeilandsFuels;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsDimension;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsFeatures;
import com.kittehmod.ceilands.registry.CeilandsGameRules;
import com.kittehmod.ceilands.registry.CeilandsItems;
import com.kittehmod.ceilands.registry.CeilandsPOIType;
import com.kittehmod.ceilands.registry.CeilandsTrunkPlacerType;
import com.kittehmod.ceilands.registry.ModRegistryHandler;
import com.kittehmod.ceilands.util.CreativeModeTabDatabase;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Quartet;
import oshi.util.tuples.Triplet;

public class CeilandsRegistry 
{
	public static void initializeRegistry() {
		// Set up primary registries.
		ModRegistryHandler.registerModContent(true);
		CeilandsRegistry.registerPOITypes();

		// Set up secondary registries.
		CeilandsRegistry.registerWoodTypes();
		CeilandsRegistry.registerStrippables();
		CeilandsRegistry.registerFuels();
		CeilandsRegistry.registerFlammableBlocks();
		CeilandsGameRules.setup();
		
		// Set up tertiary registries.
		CreativeModeTabDatabase.populateContents();
		CeilandsRegistry.assignItemsToTabs();
		FabricDefaultAttributeRegistry.register(CeilandsEntities.CASTLE_LORD, CastleLord.createAttributes());
	}
	
	public static void registerPOITypes() {
		PointOfInterestHelper.register(new ResourceLocation(Ceilands.MOD_ID, "ceilands_portal"), 0, 1, CeilandsBlocks.CEILANDS_PORTAL);
	}
	
	public static void registerWoodTypes() {
		WoodType.register(ModWoodType.CEILTRUNK);
		WoodType.register(ModWoodType.LUZAWOOD);
	}

	public static void registerFlammableBlocks() {
		for (Triplet<Block, Integer, Integer> entry : CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS) {
			FlammableBlockRegistry.getDefaultInstance().add(entry.getA(), entry.getB(), entry.getC());
		}
	}
	
	public static void registerFuels() {
		for (Pair<Item, Integer> entry : CeilandsFuels.CEILANDS_FUELS) {
			FuelRegistry.INSTANCE.add(entry.getA(), entry.getB());
		}
	}
	
	public static void registerStrippables() {
		StrippableBlockRegistry.register(CeilandsBlocks.CEILTRUNK_LOG, CeilandsBlocks.STRIPPED_CEILTRUNK_LOG);
		StrippableBlockRegistry.register(CeilandsBlocks.CEILTRUNK_WOOD, CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD);
		StrippableBlockRegistry.register(CeilandsBlocks.LUZAWOOD_LOG, CeilandsBlocks.STRIPPED_LUZAWOOD_LOG);
		StrippableBlockRegistry.register(CeilandsBlocks.LUZAWOOD_WOOD, CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD);
	}
	
	public static void assignItemsToTabs() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(CeilandsRegistry::addItemsToBuildingBlocks);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(CeilandsRegistry::addItemsToNaturalBlocks);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(CeilandsRegistry::addItemsToFunctionalBlocks);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(CeilandsRegistry::addItemsToToolsUtilities);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(CeilandsRegistry::addItemsToCombat);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(CeilandsRegistry::addItemsToIngredients);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(CeilandsRegistry::addItemsToSpawnEggs);
	}
	
	private static void addItemsToBuildingBlocks(FabricItemGroupEntries entries) {
		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.BUILDING_BLOCKS) {
			if (quad.getA() == null) {
				entries.accept(quad.getB().getDefaultInstance());
				continue;
			}
			if (quad.getD()) {
				entries.addAfter(quad.getA(), quad.getB().getDefaultInstance());
			}
			else {
				entries.addBefore(quad.getA(), quad.getB().getDefaultInstance());    				
			}
		}
		if (CompatsFabric.DRAMATIC_DOORS_INSTALLED) {
			entries.addBefore(CeilandsItems.CEILTRUNK_DOOR, BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "short_ceiltrunk_door")));
			entries.addAfter(CeilandsItems.CEILTRUNK_DOOR, BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "tall_ceiltrunk_door")));
			entries.addBefore(CeilandsItems.LUZAWOOD_DOOR, BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "short_luzawood_door")));
			entries.addAfter(CeilandsItems.LUZAWOOD_DOOR, BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "tall_luzawood_door")));
		}
	}
	
	private static void addItemsToNaturalBlocks(FabricItemGroupEntries entries) {
		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.NATURAL_BLOCKS) {
			if (quad.getA() == null) {
				entries.accept(quad.getB().getDefaultInstance());
				continue;
			}
			if (quad.getD()) {
				entries.addAfter(quad.getA(), quad.getB().getDefaultInstance());
			}
			else {
				entries.addBefore(quad.getA(), quad.getB().getDefaultInstance());    				
			}
		}
	}
	
	private static void addItemsToFunctionalBlocks(FabricItemGroupEntries entries) {
		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.FUNCTIONAL_BLOCKS) {
			if (quad.getA() == null) {
				entries.accept(quad.getB().getDefaultInstance());
				continue;
			}
			if (quad.getD()) {
				entries.addAfter(quad.getA(), quad.getB().getDefaultInstance());
			}
			else {
				entries.addBefore(quad.getA(), quad.getB().getDefaultInstance());    				
			}
		}
	}
	
	private static void addItemsToToolsUtilities(FabricItemGroupEntries entries) {
		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.TOOLS_AND_UTILITIES) {
			if (quad.getA() == null) {
				entries.accept(quad.getB().getDefaultInstance());
				continue;
			}
			if (quad.getD()) {
				entries.addAfter(quad.getA(), quad.getB().getDefaultInstance());
			}
			else {
				entries.addBefore(quad.getA(), quad.getB().getDefaultInstance());    				
			}
		}
	}
	
	private static void addItemsToCombat(FabricItemGroupEntries entries) {
		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.COMBAT) {
			if (quad.getA() == null) {
				entries.accept(quad.getB().getDefaultInstance());
				continue;
			}
			if (quad.getD()) {
				entries.addAfter(quad.getA(), quad.getB().getDefaultInstance());
			}
			else {
				entries.addBefore(quad.getA(), quad.getB().getDefaultInstance());    				
			}
		}
	}
	
	private static void addItemsToIngredients(FabricItemGroupEntries entries) {
		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.INGREDIENTS) {
			if (quad.getA() == null) {
				entries.accept(quad.getB().getDefaultInstance());
				continue;
			}
			if (quad.getD()) {
				entries.addAfter(quad.getA(), quad.getB().getDefaultInstance());
			}
			else {
				entries.addBefore(quad.getA(), quad.getB().getDefaultInstance());    				
			}
		}
	}
	
	private static void addItemsToSpawnEggs(FabricItemGroupEntries entries) {
		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.SPAWN_EGGS) {
			if (quad.getA() == null) {
				entries.accept(quad.getB());
				continue;
			}
			if (quad.getD()) {
				entries.addAfter(quad.getA(), quad.getB().getDefaultInstance());
			}
			else {
				entries.addBefore(quad.getA(), quad.getB().getDefaultInstance());    				
			}
		}
	}
}
