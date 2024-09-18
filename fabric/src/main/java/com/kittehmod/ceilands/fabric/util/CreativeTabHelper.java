package com.kittehmod.ceilands.fabric.util;

import com.kittehmod.ceilands.registry.CeilandsItems;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class CreativeTabHelper 
{
	public static void assignItemsToTabs() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(CreativeTabHelper::addItemsToBuildingBlocks);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(CreativeTabHelper::addItemsToNaturalBlocks);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(CreativeTabHelper::addItemsToFunctionalBlocks);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(CreativeTabHelper::addItemsToToolsUtilities);
	}
	
	private static void addItemsToBuildingBlocks(FabricItemGroupEntries entries) {
		entries.addAfter(Items.PURPUR_SLAB, CeilandsItems.CEILINGNEOUS.getDefaultInstance());
		entries.addAfter(CeilandsItems.CEILINGNEOUS, CeilandsItems.CEILINGNEOUS_STAIRS);
		entries.addAfter(CeilandsItems.CEILINGNEOUS_STAIRS, CeilandsItems.CEILINGNEOUS_SLAB);
		entries.addAfter(CeilandsItems.CEILINGNEOUS_SLAB, CeilandsItems.CEILINGNEOUS_WALL);
		entries.addAfter(CeilandsItems.CEILINGNEOUS_WALL, CeilandsItems.CHISELED_CEILINGNEOUS);
		entries.addAfter(CeilandsItems.CHISELED_CEILINGNEOUS, CeilandsItems.POLISHED_CEILINGNEOUS);
		entries.addAfter(CeilandsItems.POLISHED_CEILINGNEOUS, CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS);
		entries.addAfter(CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS, CeilandsItems.POLISHED_CEILINGNEOUS_SLAB);
		entries.addAfter(CeilandsItems.POLISHED_CEILINGNEOUS_SLAB, CeilandsItems.POLISHED_CEILINGNEOUS_WALL);
		entries.addAfter(CeilandsItems.POLISHED_CEILINGNEOUS_WALL, CeilandsItems.CEILINGNEOUS_BRICKS);
		entries.addAfter(CeilandsItems.CEILINGNEOUS_BRICKS, CeilandsItems.CEILINGNEOUS_BRICK_STAIRS);
		entries.addAfter(CeilandsItems.CEILINGNEOUS_BRICK_STAIRS, CeilandsItems.CEILINGNEOUS_BRICK_SLAB);
		entries.addAfter(CeilandsItems.CEILINGNEOUS_BRICK_SLAB, CeilandsItems.CEILINGNEOUS_BRICK_WALL);
		entries.addAfter(CeilandsItems.CEILINGNEOUS_BRICK_WALL, CeilandsItems.CRACKED_CEILINGNEOUS_BRICKS);
		
		entries.addAfter(Items.WARPED_BUTTON, CeilandsItems.CEILTRUNK_LOG);
		entries.addAfter(CeilandsItems.CEILTRUNK_LOG, CeilandsItems.CEILTRUNK_WOOD);
		entries.addAfter(CeilandsItems.CEILTRUNK_WOOD, CeilandsItems.STRIPPED_CEILTRUNK_LOG);
		entries.addAfter(CeilandsItems.STRIPPED_CEILTRUNK_LOG, CeilandsItems.STRIPPED_CEILTRUNK_WOOD);
		entries.addAfter(CeilandsItems.STRIPPED_CEILTRUNK_WOOD, CeilandsItems.CEILTRUNK_PLANKS);
		entries.addAfter(CeilandsItems.CEILTRUNK_PLANKS, CeilandsItems.CEILTRUNK_STAIRS);
		entries.addAfter(CeilandsItems.CEILTRUNK_STAIRS, CeilandsItems.CEILTRUNK_SLAB);
		entries.addAfter(CeilandsItems.CEILTRUNK_SLAB, CeilandsItems.CEILTRUNK_FENCE);
		entries.addAfter(CeilandsItems.CEILTRUNK_FENCE, CeilandsItems.CEILTRUNK_FENCE_GATE);
		entries.addAfter(CeilandsItems.CEILTRUNK_FENCE_GATE, CeilandsItems.CEILTRUNK_DOOR);
		entries.addAfter(CeilandsItems.CEILTRUNK_DOOR, CeilandsItems.CEILTRUNK_TRAPDOOR);
		entries.addAfter(CeilandsItems.CEILTRUNK_TRAPDOOR, CeilandsItems.CEILTRUNK_PRESSURE_PLATE);
		entries.addAfter(CeilandsItems.CEILTRUNK_PRESSURE_PLATE, CeilandsItems.CEILTRUNK_BUTTON);
		
		entries.addAfter(CeilandsItems.CEILTRUNK_BUTTON, CeilandsItems.LUZAWOOD_LOG);
		entries.addAfter(CeilandsItems.LUZAWOOD_LOG, CeilandsItems.LUZAWOOD_WOOD);
		entries.addAfter(CeilandsItems.LUZAWOOD_WOOD, CeilandsItems.STRIPPED_LUZAWOOD_LOG);
		entries.addAfter(CeilandsItems.STRIPPED_LUZAWOOD_LOG, CeilandsItems.STRIPPED_LUZAWOOD_WOOD);
		entries.addAfter(CeilandsItems.STRIPPED_LUZAWOOD_WOOD, CeilandsItems.LUZAWOOD_PLANKS);
		entries.addAfter(CeilandsItems.LUZAWOOD_PLANKS, CeilandsItems.LUZAWOOD_STAIRS);
		entries.addAfter(CeilandsItems.LUZAWOOD_STAIRS, CeilandsItems.LUZAWOOD_SLAB);
		entries.addAfter(CeilandsItems.LUZAWOOD_SLAB, CeilandsItems.LUZAWOOD_FENCE);
		entries.addAfter(CeilandsItems.LUZAWOOD_FENCE, CeilandsItems.LUZAWOOD_FENCE_GATE);
		entries.addAfter(CeilandsItems.LUZAWOOD_FENCE_GATE, CeilandsItems.LUZAWOOD_DOOR);
		entries.addAfter(CeilandsItems.LUZAWOOD_DOOR, CeilandsItems.LUZAWOOD_TRAPDOOR);
		entries.addAfter(CeilandsItems.LUZAWOOD_TRAPDOOR, CeilandsItems.LUZAWOOD_PRESSURE_PLATE);
		entries.addAfter(CeilandsItems.LUZAWOOD_PRESSURE_PLATE, CeilandsItems.LUZAWOOD_BUTTON);
	}
	
	private static void addItemsToNaturalBlocks(FabricItemGroupEntries entries) {
		entries.addAfter(Items.END_STONE, CeilandsItems.CEILINGNEOUS);

		entries.addAfter(Items.DEEPSLATE_COAL_ORE, CeilandsItems.CEILINGNEOUS_COAL_ORE);
		entries.addAfter(Items.DEEPSLATE_COPPER_ORE, CeilandsItems.CEILINGNEOUS_COPPER_ORE);
		entries.addAfter(Items.DEEPSLATE_IRON_ORE, CeilandsItems.CEILINGNEOUS_IRON_ORE);
		entries.addAfter(Items.DEEPSLATE_GOLD_ORE, CeilandsItems.CEILINGNEOUS_GOLD_ORE);
		entries.addAfter(Items.DEEPSLATE_DIAMOND_ORE, CeilandsItems.CEILINGNEOUS_DIAMOND_ORE);
		entries.addAfter(Items.DEEPSLATE_EMERALD_ORE, CeilandsItems.CEILINGNEOUS_EMERALD_ORE);
		entries.addAfter(Items.DEEPSLATE_LAPIS_ORE, CeilandsItems.CEILINGNEOUS_LAPIS_ORE);
		entries.addAfter(Items.DEEPSLATE_REDSTONE_ORE, CeilandsItems.CEILINGNEOUS_REDSTONE_ORE);
		
		entries.addAfter(Items.WARPED_STEM, CeilandsItems.CEILTRUNK_LOG);
		entries.addAfter(CeilandsItems.CEILTRUNK_LOG, CeilandsItems.LUZAWOOD_LOG);
		entries.addAfter(Items.FLOWERING_AZALEA_LEAVES, CeilandsItems.CEILTRUNK_LEAVES);
		entries.addAfter(CeilandsItems.CEILTRUNK_LEAVES, CeilandsItems.LUZAWOOD_LEAVES);
		entries.addAfter(Items.CHERRY_SAPLING, CeilandsItems.CEILTRUNK_SAPLING);
		entries.addAfter(CeilandsItems.CEILTRUNK_SAPLING, CeilandsItems.LUZAWOOD_SAPLING);
	}
	
	private static void addItemsToFunctionalBlocks(FabricItemGroupEntries entries) {
		entries.addAfter(Items.WARPED_HANGING_SIGN, CeilandsItems.CEILTRUNK_SIGN);
		entries.addAfter(CeilandsItems.CEILTRUNK_SIGN, CeilandsItems.CEILTRUNK_HANGING_SIGN);
		entries.addAfter(CeilandsItems.CEILTRUNK_HANGING_SIGN, CeilandsItems.LUZAWOOD_SIGN);
		entries.addAfter(CeilandsItems.LUZAWOOD_SIGN, CeilandsItems.LUZAWOOD_HANGING_SIGN);
	}
	
	private static void addItemsToToolsUtilities(FabricItemGroupEntries entries) {
		entries.addAfter(Items.CHERRY_CHEST_BOAT, CeilandsItems.CEILTRUNK_BOAT);
		entries.addAfter(CeilandsItems.CEILTRUNK_BOAT, CeilandsItems.CEILTRUNK_CHEST_BOAT);
		entries.addAfter(CeilandsItems.CEILTRUNK_CHEST_BOAT, CeilandsItems.LUZAWOOD_BOAT);
		entries.addAfter(CeilandsItems.LUZAWOOD_BOAT, CeilandsItems.LUZAWOOD_CHEST_BOAT);
		entries.accept(CeilandsItems.CEILANDS_PORTAL_ACTIVATOR);
	}
}
