package com.kittehmod.ceilands.fabric;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.entity.mob.CastleLord;
import com.kittehmod.ceilands.entity.mob.SpiderMonarch;
import com.kittehmod.ceilands.item.CeilandsFuels;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsFeatures;
import com.kittehmod.ceilands.registry.CeilandsGameRules;
import com.kittehmod.ceilands.registry.CeilandsItems;
import com.kittehmod.ceilands.registry.CeilandsSoundEvents;
import com.kittehmod.ceilands.registry.CeilandsTrunkPlacerType;
import com.kittehmod.ceilands.util.CreativeModeTabDatabase;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Quintet;
import oshi.util.tuples.Triplet;

public class CeilandsRegistry 
{
	public static void initializeRegistry() {
		// Set up primary registries.
		registerModContent();
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
		FabricDefaultAttributeRegistry.register(CeilandsEntities.SPIDER_MONARCH, SpiderMonarch.createAttributes());
	}
	
	private static void initializeModContent() {
		CeilandsBlocks.init();
		CeilandsItems.init();
		CeilandsEntities.init();
		CeilandsBlockEntities.init();
		CeilandsFeatures.init();
		CeilandsTrunkPlacerType.init();
		CeilandsSoundEvents.init();
	}
	
	public static void registerModContent() {
		initializeModContent();
		for (Pair<ResourceLocation, Block> pair : CeilandsBlocks.BLOCKS) {
			Registry.register(BuiltInRegistries.BLOCK, pair.getA(), pair.getB());
		}
		for (Pair<ResourceLocation, Item> pair : CeilandsItems.ITEMS) {
			Registry.register(BuiltInRegistries.ITEM, pair.getA(), pair.getB());
		}
		for (Pair<ResourceLocation, EntityType<?>> pair : CeilandsEntities.ENTITIES) {
			Registry.register(BuiltInRegistries.ENTITY_TYPE, pair.getA(), pair.getB());
		}
		for (Pair<ResourceLocation, BlockEntityType<?>> pair : CeilandsBlockEntities.BLOCK_ENTITIES) {
			Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, pair.getA(), pair.getB());
		}
		for (Pair<ResourceLocation, Feature<?>> pair : CeilandsFeatures.FEATURES) {
			Registry.register(BuiltInRegistries.FEATURE, pair.getA(), pair.getB());
		}
		for (Pair<ResourceLocation, TrunkPlacerType<?>> pair : CeilandsTrunkPlacerType.TRUNK_PLACERS) {
			Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, pair.getA(), pair.getB());
		}
		for (Pair<ResourceLocation, SoundEvent> pair : CeilandsSoundEvents.SOUND_EVENTS) {
			Registry.register(BuiltInRegistries.SOUND_EVENT, pair.getA(), pair.getB());
		}
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
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> CeilandsRegistry.addItemsToTab(entries, CreativeModeTabs.BUILDING_BLOCKS));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> CeilandsRegistry.addItemsToTab(entries, CreativeModeTabs.NATURAL_BLOCKS));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> CeilandsRegistry.addItemsToTab(entries, CreativeModeTabs.FUNCTIONAL_BLOCKS));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> CeilandsRegistry.addItemsToTab(entries, CreativeModeTabs.TOOLS_AND_UTILITIES));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> CeilandsRegistry.addItemsToTab(entries, CreativeModeTabs.COMBAT));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> CeilandsRegistry.addItemsToTab(entries, CreativeModeTabs.INGREDIENTS));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(entries -> CeilandsRegistry.addItemsToTab(entries, CreativeModeTabs.SPAWN_EGGS));
	}
	
	private static void addItemsToTab(FabricItemGroupEntries entries, ResourceKey<CreativeModeTab> tab) {
		for (Quintet<Item, Item, TabVisibility, Boolean, ResourceKey<CreativeModeTab>> quint : CreativeModeTabDatabase.ITEM_ENTRIES) {
			if (quint.getE() != tab) {
				continue;
			}
			if (quint.getA() == null) {
				entries.accept(quint.getB().getDefaultInstance());
				continue;
			}
			if (quint.getD()) { 
				entries.addAfter(quint.getA(), quint.getB().getDefaultInstance());
			}
			else {
				entries.addBefore(quint.getA(), quint.getB().getDefaultInstance());
			}
		}
		if (CompatsFabric.DRAMATIC_DOORS_INSTALLED && tab == CreativeModeTabs.BUILDING_BLOCKS) {
			entries.addBefore(CeilandsItems.CEILTRUNK_DOOR, BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "short_ceiltrunk_door")));
			entries.addAfter(CeilandsItems.CEILTRUNK_DOOR, BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "tall_ceiltrunk_door")));
			entries.addBefore(CeilandsItems.LUZAWOOD_DOOR, BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "short_luzawood_door")));
			entries.addAfter(CeilandsItems.LUZAWOOD_DOOR, BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "tall_luzawood_door")));
		}
	}
}
