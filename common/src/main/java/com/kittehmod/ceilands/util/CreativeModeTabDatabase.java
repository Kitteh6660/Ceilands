package com.kittehmod.ceilands.util;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import oshi.util.tuples.Quartet;

public class CreativeModeTabDatabase 
{
	public static final List<Quartet<Item, Item, TabVisibility, Boolean>> BUILDING_BLOCKS = new ArrayList();
	public static final List<Quartet<Item, Item, TabVisibility, Boolean>> NATURAL_BLOCKS = new ArrayList();
	public static final List<Quartet<Item, Item, TabVisibility, Boolean>> FUNCTIONAL_BLOCKS = new ArrayList();
	public static final List<Quartet<Item, Item, TabVisibility, Boolean>> REDSTONE_BLOCKS = new ArrayList();
	public static final List<Quartet<Item, Item, TabVisibility, Boolean>> TOOLS_AND_UTILITIES = new ArrayList();
	public static final List<Quartet<Item, Item, TabVisibility, Boolean>> COMBAT = new ArrayList();
	public static final List<Quartet<Item, Item, TabVisibility, Boolean>> INGREDIENTS = new ArrayList();
	public static final List<Quartet<Item, Item, TabVisibility, Boolean>> SPAWN_EGGS = new ArrayList();
	
	public static void populateContents() {
		// Building Blocks
		insertAfter(Items.PURPUR_SLAB, CeilandsItems.CEILINGNEOUS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS, CeilandsItems.CEILINGNEOUS_STAIRS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS_STAIRS, CeilandsItems.CEILINGNEOUS_SLAB, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS_SLAB, CeilandsItems.CEILINGNEOUS_WALL, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS_WALL, CeilandsItems.CEILINGNEOUS_BUTTON, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS_BUTTON, CeilandsItems.CEILINGNEOUS_PRESSURE_PLATE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS_PRESSURE_PLATE, CeilandsItems.CHISELED_CEILINGNEOUS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CHISELED_CEILINGNEOUS, CeilandsItems.POLISHED_CEILINGNEOUS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.POLISHED_CEILINGNEOUS, CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS, CeilandsItems.POLISHED_CEILINGNEOUS_SLAB, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.POLISHED_CEILINGNEOUS_SLAB, CeilandsItems.POLISHED_CEILINGNEOUS_WALL, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.POLISHED_CEILINGNEOUS_WALL, CeilandsItems.CEILINGNEOUS_BRICKS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS_BRICKS, CeilandsItems.CRACKED_CEILINGNEOUS_BRICKS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CRACKED_CEILINGNEOUS_BRICKS, CeilandsItems.CEILINGNEOUS_BRICK_STAIRS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS_BRICK_STAIRS, CeilandsItems.CEILINGNEOUS_BRICK_SLAB, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS_BRICK_SLAB, CeilandsItems.CEILINGNEOUS_BRICK_WALL, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		
		insertAfter(CeilandsItems.CEILINGNEOUS_BRICK_WALL, CeilandsItems.ROOFSHALE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.ROOFSHALE, CeilandsItems.ROOFSHALE_STAIRS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.ROOFSHALE_STAIRS, CeilandsItems.ROOFSHALE_SLAB, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.ROOFSHALE_SLAB, CeilandsItems.ROOFSHALE_WALL, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.ROOFSHALE_WALL, CeilandsItems.CHISELED_ROOFSHALE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CHISELED_ROOFSHALE, CeilandsItems.POLISHED_ROOFSHALE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.POLISHED_ROOFSHALE, CeilandsItems.POLISHED_ROOFSHALE_STAIRS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.POLISHED_ROOFSHALE_STAIRS, CeilandsItems.POLISHED_ROOFSHALE_SLAB, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.POLISHED_ROOFSHALE_SLAB, CeilandsItems.POLISHED_ROOFSHALE_WALL, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.POLISHED_ROOFSHALE_WALL, CeilandsItems.ROOFSHALE_BRICKS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.ROOFSHALE_BRICKS, CeilandsItems.ROOFSHALE_BRICK_STAIRS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.ROOFSHALE_BRICK_STAIRS, CeilandsItems.ROOFSHALE_BRICK_SLAB, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.ROOFSHALE_BRICK_SLAB, CeilandsItems.ROOFSHALE_BRICK_WALL, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.ROOFSHALE_BRICK_WALL, CeilandsItems.CHISELED_ROOFSHALE_BRICKS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		
		insertAfter(Items.WARPED_BUTTON, CeilandsItems.CEILTRUNK_LOG, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_LOG, CeilandsItems.CEILTRUNK_WOOD, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_WOOD, CeilandsItems.STRIPPED_CEILTRUNK_LOG, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.STRIPPED_CEILTRUNK_LOG, CeilandsItems.STRIPPED_CEILTRUNK_WOOD, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.STRIPPED_CEILTRUNK_WOOD, CeilandsItems.CEILTRUNK_PLANKS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_PLANKS, CeilandsItems.CEILTRUNK_STAIRS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_STAIRS, CeilandsItems.CEILTRUNK_SLAB, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_SLAB, CeilandsItems.CEILTRUNK_FENCE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_FENCE, CeilandsItems.CEILTRUNK_FENCE_GATE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_FENCE_GATE, CeilandsItems.CEILTRUNK_DOOR, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_DOOR, CeilandsItems.CEILTRUNK_TRAPDOOR, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_TRAPDOOR, CeilandsItems.CEILTRUNK_PRESSURE_PLATE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_PRESSURE_PLATE, CeilandsItems.CEILTRUNK_BUTTON, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		
		insertAfter(CeilandsItems.CEILTRUNK_BUTTON, CeilandsItems.LUZAWOOD_LOG, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_LOG, CeilandsItems.LUZAWOOD_WOOD, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_WOOD, CeilandsItems.STRIPPED_LUZAWOOD_LOG, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.STRIPPED_LUZAWOOD_LOG, CeilandsItems.STRIPPED_LUZAWOOD_WOOD, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.STRIPPED_LUZAWOOD_WOOD, CeilandsItems.LUZAWOOD_PLANKS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_PLANKS, CeilandsItems.LUZAWOOD_STAIRS, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_STAIRS, CeilandsItems.LUZAWOOD_SLAB, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_SLAB, CeilandsItems.LUZAWOOD_FENCE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_FENCE, CeilandsItems.LUZAWOOD_FENCE_GATE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_FENCE_GATE, CeilandsItems.LUZAWOOD_DOOR, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_DOOR, CeilandsItems.LUZAWOOD_TRAPDOOR, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_TRAPDOOR, CeilandsItems.LUZAWOOD_PRESSURE_PLATE, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_PRESSURE_PLATE, CeilandsItems.LUZAWOOD_BUTTON, TabVisibility.PARENT_AND_SEARCH_TABS, BUILDING_BLOCKS);
		
		// Natural Blocks
		insertAfter(Items.END_STONE, CeilandsItems.CEILINGNEOUS, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(CeilandsItems.CEILINGNEOUS, CeilandsItems.ROOFSHALE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);

		insertAfter(Items.DEEPSLATE_COAL_ORE, CeilandsItems.CEILINGNEOUS_COAL_ORE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.DEEPSLATE_COPPER_ORE, CeilandsItems.CEILINGNEOUS_COPPER_ORE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.DEEPSLATE_IRON_ORE, CeilandsItems.CEILINGNEOUS_IRON_ORE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.DEEPSLATE_GOLD_ORE, CeilandsItems.CEILINGNEOUS_GOLD_ORE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.DEEPSLATE_DIAMOND_ORE, CeilandsItems.CEILINGNEOUS_DIAMOND_ORE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.DEEPSLATE_EMERALD_ORE, CeilandsItems.CEILINGNEOUS_EMERALD_ORE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.DEEPSLATE_LAPIS_ORE, CeilandsItems.CEILINGNEOUS_LAPIS_ORE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.DEEPSLATE_REDSTONE_ORE, CeilandsItems.CEILINGNEOUS_REDSTONE_ORE, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		
		insertAfter(Items.WARPED_STEM, CeilandsItems.CEILTRUNK_LOG, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_LOG, CeilandsItems.LUZAWOOD_LOG, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.FLOWERING_AZALEA_LEAVES, CeilandsItems.CEILTRUNK_LEAVES, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_LEAVES, CeilandsItems.LUZAWOOD_LEAVES, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(Items.CHERRY_SAPLING, CeilandsItems.CEILTRUNK_SAPLING, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_SAPLING, CeilandsItems.LUZAWOOD_SAPLING, TabVisibility.PARENT_AND_SEARCH_TABS, NATURAL_BLOCKS);
		
		// Functional Blocks
		insertAfter(Items.WARPED_HANGING_SIGN, CeilandsItems.CEILTRUNK_SIGN, TabVisibility.PARENT_AND_SEARCH_TABS, FUNCTIONAL_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_SIGN, CeilandsItems.CEILTRUNK_HANGING_SIGN, TabVisibility.PARENT_AND_SEARCH_TABS, FUNCTIONAL_BLOCKS);
		insertAfter(CeilandsItems.CEILTRUNK_HANGING_SIGN, CeilandsItems.LUZAWOOD_SIGN, TabVisibility.PARENT_AND_SEARCH_TABS, FUNCTIONAL_BLOCKS);
		insertAfter(CeilandsItems.LUZAWOOD_SIGN, CeilandsItems.LUZAWOOD_HANGING_SIGN, TabVisibility.PARENT_AND_SEARCH_TABS, FUNCTIONAL_BLOCKS);
		
		// Tools & Utilities
		insertAfter(Items.CHERRY_CHEST_BOAT, CeilandsItems.CEILTRUNK_BOAT, TabVisibility.PARENT_AND_SEARCH_TABS, TOOLS_AND_UTILITIES);
		insertAfter(CeilandsItems.CEILTRUNK_BOAT, CeilandsItems.CEILTRUNK_CHEST_BOAT, TabVisibility.PARENT_AND_SEARCH_TABS, TOOLS_AND_UTILITIES);
		insertAfter(CeilandsItems.CEILTRUNK_CHEST_BOAT, CeilandsItems.LUZAWOOD_BOAT, TabVisibility.PARENT_AND_SEARCH_TABS, TOOLS_AND_UTILITIES);
		insertAfter(CeilandsItems.LUZAWOOD_BOAT, CeilandsItems.LUZAWOOD_CHEST_BOAT, TabVisibility.PARENT_AND_SEARCH_TABS, TOOLS_AND_UTILITIES);
		insert(CeilandsItems.CEILANDS_PORTAL_ACTIVATOR, TabVisibility.PARENT_AND_SEARCH_TABS, TOOLS_AND_UTILITIES);
		
		// Combat
		insertAfter(Items.TURTLE_HELMET, CeilandsItems.CASTLE_LORD_CROWN, TabVisibility.PARENT_AND_SEARCH_TABS, COMBAT);
		insertAfter(CeilandsItems.CASTLE_LORD_CROWN, CeilandsItems.CASTLE_LORD_CHESTPLATE, TabVisibility.PARENT_AND_SEARCH_TABS, COMBAT);
		insertAfter(CeilandsItems.CASTLE_LORD_CHESTPLATE, CeilandsItems.CASTLE_LORD_LEGGINGS, TabVisibility.PARENT_AND_SEARCH_TABS, COMBAT);
		insertAfter(CeilandsItems.CASTLE_LORD_LEGGINGS, CeilandsItems.CASTLE_LORD_BOOTS, TabVisibility.PARENT_AND_SEARCH_TABS, COMBAT);
		
		// Ingredients
		insertAfter(Items.SCUTE, CeilandsItems.CASTLE_LORD_REGALIA_FRAGMENTS, TabVisibility.PARENT_AND_SEARCH_TABS, INGREDIENTS);
		
		// Spawn Eggs
		insert(CeilandsItems.CASTLE_LORD_SPAWN_EGG, TabVisibility.PARENT_AND_SEARCH_TABS, SPAWN_EGGS);		
	}

	// False for before, true for after.
	public static void insertBefore(Item itemToFind, Item itemToAdd, TabVisibility visibility, List<Quartet<Item, Item, TabVisibility, Boolean>> list) {
		list.add(new Quartet<Item, Item, TabVisibility, Boolean>(itemToFind, itemToAdd, visibility, false));
	}
	
	public static void insertAfter(Item itemToFind, Item itemToAdd, TabVisibility visibility, List<Quartet<Item, Item, TabVisibility, Boolean>> list) {
		list.add(new Quartet<Item, Item, TabVisibility, Boolean>(itemToFind, itemToAdd, visibility, true));
	}
	
	public static void insert(Item itemToAdd, TabVisibility visibility, List<Quartet<Item, Item, TabVisibility, Boolean>> list) {
		list.add(new Quartet<Item, Item, TabVisibility, Boolean>(null, itemToAdd, visibility, true));
	}
}
