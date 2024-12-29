package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.entity.vehicle.ModBoat;
import com.kittehmod.ceilands.item.CastleLordArmorItem;
import com.kittehmod.ceilands.item.CeilandsPortalActivatorItem;
import com.kittehmod.ceilands.item.ModBoatItem;
import com.kittehmod.ceilands.item.VenomousSpearItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SpawnEggItem;
import oshi.util.tuples.Pair;

public class CeilandsItems
{
	public static void init() {};
	
	/** Creates and registers item. */
	private static Item registerItem(String name, Item item) {
		ITEMS.add(new Pair<ResourceLocation, Item>(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, name), item));
		return item;
	}

	public static final List<Pair<ResourceLocation, Item>> ITEMS = new ArrayList<Pair<ResourceLocation, Item>>();
	
    public static final Item CEILANDS_PORTAL_ACTIVATOR = registerItem("ceilands_portal_activator", new CeilandsPortalActivatorItem(new Item.Properties().stacksTo(1)));
    public static final Item VENOMOUS_SPEAR = registerItem("venomous_spear", new VenomousSpearItem(new Item.Properties().durability(250).rarity(Rarity.RARE)));
	
    public static final Item CASTLE_LORD_REGALIA_FRAGMENTS = registerItem("castle_lord_regalia_fragments", new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final Item SPIDER_MONARCH_FANG = registerItem("spider_monarch_fang", new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final Item CASTLE_LORD_CROWN = registerItem("castle_lord_crown", new CastleLordArmorItem(Type.HELMET, new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item CASTLE_LORD_CHESTPLATE = registerItem("castle_lord_chestplate", new CastleLordArmorItem(Type.CHESTPLATE, new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item CASTLE_LORD_LEGGINGS = registerItem("castle_lord_leggings", new CastleLordArmorItem(Type.LEGGINGS, new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item CASTLE_LORD_BOOTS = registerItem("castle_lord_boots", new CastleLordArmorItem(Type.BOOTS, new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static final Item CASTLE_LORD_SPAWN_EGG = registerItem("castle_lord_spawn_egg", new SpawnEggItem(CeilandsEntities.CASTLE_LORD, 0x808080, 0x7DD880, new Item.Properties()));
    public static final Item SPIDER_MONARCH_SPAWN_EGG = registerItem("spider_monarch_spawn_egg", new SpawnEggItem(CeilandsEntities.SPIDER_MONARCH, 0x5C322F, 11013646, new Item.Properties()));
    
	public static final Item CEILINGNEOUS = registerItem("ceilingneous", new BlockItem(CeilandsBlocks.CEILINGNEOUS, new Item.Properties()));
	public static final Item CEILINGNEOUS_STAIRS = registerItem("ceilingneous_stairs", new BlockItem(CeilandsBlocks.CEILINGNEOUS_STAIRS, new Item.Properties()));
	public static final Item CEILINGNEOUS_SLAB = registerItem("ceilingneous_slab", new BlockItem(CeilandsBlocks.CEILINGNEOUS_SLAB, new Item.Properties()));
	public static final Item CEILINGNEOUS_WALL = registerItem("ceilingneous_wall", new BlockItem(CeilandsBlocks.CEILINGNEOUS_WALL, new Item.Properties()));

	public static final Item POLISHED_CEILINGNEOUS = registerItem("polished_ceilingneous", new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS, new Item.Properties()));
	public static final Item POLISHED_CEILINGNEOUS_STAIRS = registerItem("polished_ceilingneous_stairs", new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_STAIRS, new Item.Properties()));
	public static final Item POLISHED_CEILINGNEOUS_SLAB = registerItem("polished_ceilingneous_slab", new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_SLAB, new Item.Properties()));
	public static final Item POLISHED_CEILINGNEOUS_WALL = registerItem("polished_ceilingneous_wall", new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_WALL, new Item.Properties()));

	public static final Item CEILINGNEOUS_BRICKS = registerItem("ceilingneous_bricks", new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICKS, new Item.Properties()));
	public static final Item CEILINGNEOUS_BRICK_STAIRS = registerItem("ceilingneous_brick_stairs", new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_STAIRS, new Item.Properties()));
	public static final Item CEILINGNEOUS_BRICK_SLAB = registerItem("ceilingneous_brick_slab", new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_SLAB, new Item.Properties()));
	public static final Item CEILINGNEOUS_BRICK_WALL = registerItem("ceilingneous_brick_wall", new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_WALL, new Item.Properties()));

	public static final Item CRACKED_CEILINGNEOUS_BRICKS = registerItem("cracked_ceilingneous_bricks", new BlockItem(CeilandsBlocks.CRACKED_CEILINGNEOUS_BRICKS, new Item.Properties()));
	public static final Item CHISELED_CEILINGNEOUS = registerItem("chiseled_ceilingneous", new BlockItem(CeilandsBlocks.CHISELED_CEILINGNEOUS, new Item.Properties()));

	public static final Item CEILINGNEOUS_BUTTON = registerItem("ceilingneous_button", new BlockItem(CeilandsBlocks.CEILINGNEOUS_BUTTON, new Item.Properties()));
	public static final Item CEILINGNEOUS_PRESSURE_PLATE = registerItem("ceilingneous_pressure_plate", new BlockItem(CeilandsBlocks.CEILINGNEOUS_PRESSURE_PLATE, new Item.Properties()));

	public static final Item ROOFSHALE = registerItem("roofshale", new BlockItem(CeilandsBlocks.ROOFSHALE, new Item.Properties()));
	public static final Item ROOFSHALE_STAIRS = registerItem("roofshale_stairs", new BlockItem(CeilandsBlocks.ROOFSHALE_STAIRS, new Item.Properties()));
	public static final Item ROOFSHALE_SLAB = registerItem("roofshale_slab", new BlockItem(CeilandsBlocks.ROOFSHALE_SLAB, new Item.Properties()));
	public static final Item ROOFSHALE_WALL = registerItem("roofshale_wall", new BlockItem(CeilandsBlocks.ROOFSHALE_WALL, new Item.Properties()));

	public static final Item POLISHED_ROOFSHALE = registerItem("polished_roofshale", new BlockItem(CeilandsBlocks.POLISHED_ROOFSHALE, new Item.Properties()));
	public static final Item POLISHED_ROOFSHALE_STAIRS = registerItem("polished_roofshale_stairs", new BlockItem(CeilandsBlocks.POLISHED_ROOFSHALE_STAIRS, new Item.Properties()));
	public static final Item POLISHED_ROOFSHALE_SLAB = registerItem("polished_roofshale_slab", new BlockItem(CeilandsBlocks.POLISHED_ROOFSHALE_SLAB, new Item.Properties()));
	public static final Item POLISHED_ROOFSHALE_WALL = registerItem("polished_roofshale_wall", new BlockItem(CeilandsBlocks.POLISHED_ROOFSHALE_WALL, new Item.Properties()));

	public static final Item ROOFSHALE_BRICKS = registerItem("roofshale_bricks", new BlockItem(CeilandsBlocks.ROOFSHALE_BRICKS, new Item.Properties()));
	public static final Item ROOFSHALE_BRICK_STAIRS = registerItem("roofshale_brick_stairs", new BlockItem(CeilandsBlocks.ROOFSHALE_BRICK_STAIRS, new Item.Properties()));
	public static final Item ROOFSHALE_BRICK_SLAB = registerItem("roofshale_brick_slab", new BlockItem(CeilandsBlocks.ROOFSHALE_BRICK_SLAB, new Item.Properties()));
	public static final Item ROOFSHALE_BRICK_WALL = registerItem("roofshale_brick_wall", new BlockItem(CeilandsBlocks.ROOFSHALE_BRICK_WALL, new Item.Properties()));
	
	public static final Item CHISELED_ROOFSHALE = registerItem("chiseled_roofshale", new BlockItem(CeilandsBlocks.CHISELED_ROOFSHALE, new Item.Properties()));
	public static final Item CHISELED_ROOFSHALE_BRICKS = registerItem("chiseled_roofshale_bricks", new BlockItem(CeilandsBlocks.CHISELED_ROOFSHALE_BRICKS, new Item.Properties()));
	
	public static final Item CEILINGNEOUS_COAL_ORE = registerItem("ceilingneous_coal_ore", new BlockItem(CeilandsBlocks.CEILINGNEOUS_COAL_ORE, new Item.Properties()));
	public static final Item CEILINGNEOUS_COPPER_ORE = registerItem("ceilingneous_copper_ore", new BlockItem(CeilandsBlocks.CEILINGNEOUS_COPPER_ORE, new Item.Properties()));
	public static final Item CEILINGNEOUS_IRON_ORE = registerItem("ceilingneous_iron_ore", new BlockItem(CeilandsBlocks.CEILINGNEOUS_IRON_ORE, new Item.Properties()));
	public static final Item CEILINGNEOUS_GOLD_ORE = registerItem("ceilingneous_gold_ore", new BlockItem(CeilandsBlocks.CEILINGNEOUS_GOLD_ORE, new Item.Properties()));
	public static final Item CEILINGNEOUS_DIAMOND_ORE = registerItem("ceilingneous_diamond_ore", new BlockItem(CeilandsBlocks.CEILINGNEOUS_DIAMOND_ORE, new Item.Properties()));
	public static final Item CEILINGNEOUS_REDSTONE_ORE = registerItem("ceilingneous_redstone_ore", new BlockItem(CeilandsBlocks.CEILINGNEOUS_REDSTONE_ORE, new Item.Properties()));
	public static final Item CEILINGNEOUS_LAPIS_ORE = registerItem("ceilingneous_lapis_ore", new BlockItem(CeilandsBlocks.CEILINGNEOUS_LAPIS_ORE, new Item.Properties()));
	public static final Item CEILINGNEOUS_EMERALD_ORE = registerItem("ceilingneous_emerald_ore", new BlockItem(CeilandsBlocks.CEILINGNEOUS_EMERALD_ORE, new Item.Properties()));

	public static final Item CEILINUM_ORE = registerItem("ceilinum_ore", new BlockItem(CeilandsBlocks.CEILINUM_ORE, new Item.Properties()));
	public static final Item RAW_CEILINUM_BLOCK = registerItem("raw_ceilinum_block", new BlockItem(CeilandsBlocks.RAW_CEILINUM_BLOCK, new Item.Properties()));
	public static final Item CEILINUM_BLOCK = registerItem("ceilinum_block", new BlockItem(CeilandsBlocks.CEILINUM_BLOCK, new Item.Properties()));

	public static final Item CUT_CEILINUM = registerItem("cut_ceilinum", new BlockItem(CeilandsBlocks.CUT_CEILINUM, new Item.Properties()));
	public static final Item CUT_CEILINUM_STAIRS = registerItem("cut_ceilinum_stairs", new BlockItem(CeilandsBlocks.CUT_CEILINUM_STAIRS, new Item.Properties()));
	public static final Item CUT_CEILINUM_SLAB = registerItem("cut_ceilinum_slab", new BlockItem(CeilandsBlocks.CUT_CEILINUM_SLAB, new Item.Properties()));
	public static final Item CHISELED_CEILINUM = registerItem("chiseled_ceilinum", new BlockItem(CeilandsBlocks.CHISELED_CEILINUM, new Item.Properties()));
	public static final Item CEILINUM_BARS = registerItem("ceilinum_bars", new BlockItem(CeilandsBlocks.CEILINUM_BARS, new Item.Properties()));

	public static final Item CEILINUM_DOOR = registerItem("ceilinum_door", new BlockItem(CeilandsBlocks.CEILINUM_DOOR, new Item.Properties()));
	public static final Item CEILINUM_TRAPDOOR = registerItem("ceilinum_trapdoor", new BlockItem(CeilandsBlocks.CEILINUM_TRAPDOOR, new Item.Properties()));
	
	public static final Item RAW_CEILINUM = registerItem("raw_ceilinum", new Item(new Item.Properties()));
	public static final Item CEILINUM_INGOT = registerItem("ceilinum_ingot", new Item(new Item.Properties()));
	public static final Item CEILINUM_NUGGET = registerItem("ceilinum_nugget", new Item(new Item.Properties()));

	public static final Item CEILTRUNK_LOG = registerItem("ceiltrunk_log", new BlockItem(CeilandsBlocks.CEILTRUNK_LOG, new Item.Properties()));
	public static final Item STRIPPED_CEILTRUNK_LOG = registerItem("stripped_ceiltrunk_log", new BlockItem(CeilandsBlocks.STRIPPED_CEILTRUNK_LOG, new Item.Properties()));
	public static final Item CEILTRUNK_WOOD = registerItem("ceiltrunk_wood", new BlockItem(CeilandsBlocks.CEILTRUNK_WOOD, new Item.Properties()));
	public static final Item STRIPPED_CEILTRUNK_WOOD = registerItem("stripped_ceiltrunk_wood", new BlockItem(CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD, new Item.Properties()));
	public static final Item CEILTRUNK_LEAVES = registerItem("ceiltrunk_leaves", new BlockItem(CeilandsBlocks.CEILTRUNK_LEAVES, new Item.Properties()));
	public static final Item CEILTRUNK_SAPLING = registerItem("ceiltrunk_sapling", new BlockItem(CeilandsBlocks.CEILTRUNK_SAPLING, new Item.Properties()));
	public static final Item CEILTRUNK_PLANKS = registerItem("ceiltrunk_planks", new BlockItem(CeilandsBlocks.CEILTRUNK_PLANKS, new Item.Properties()));
	public static final Item CEILTRUNK_STAIRS = registerItem("ceiltrunk_stairs", new BlockItem(CeilandsBlocks.CEILTRUNK_STAIRS, new Item.Properties()));
	public static final Item CEILTRUNK_SLAB = registerItem("ceiltrunk_slab", new BlockItem(CeilandsBlocks.CEILTRUNK_SLAB, new Item.Properties()));
	public static final Item CEILTRUNK_FENCE = registerItem("ceiltrunk_fence", new BlockItem(CeilandsBlocks.CEILTRUNK_FENCE, new Item.Properties()));
	public static final Item CEILTRUNK_FENCE_GATE = registerItem("ceiltrunk_fence_gate", new BlockItem(CeilandsBlocks.CEILTRUNK_FENCE_GATE, new Item.Properties()));
	public static final Item CEILTRUNK_DOOR = registerItem("ceiltrunk_door", new BlockItem(CeilandsBlocks.CEILTRUNK_DOOR, new Item.Properties()));
	public static final Item CEILTRUNK_TRAPDOOR = registerItem("ceiltrunk_trapdoor", new BlockItem(CeilandsBlocks.CEILTRUNK_TRAPDOOR, new Item.Properties()));
	public static final Item CEILTRUNK_BUTTON = registerItem("ceiltrunk_button", new BlockItem(CeilandsBlocks.CEILTRUNK_BUTTON, new Item.Properties()));
	public static final Item CEILTRUNK_PRESSURE_PLATE = registerItem("ceiltrunk_pressure_plate", new BlockItem(CeilandsBlocks.CEILTRUNK_PRESSURE_PLATE, new Item.Properties()));
	public static final Item CEILTRUNK_SIGN = registerItem("ceiltrunk_sign", new SignItem(new Item.Properties().stacksTo(16), CeilandsBlocks.CEILTRUNK_SIGN, CeilandsBlocks.CEILTRUNK_WALL_SIGN));
	public static final Item CEILTRUNK_HANGING_SIGN = registerItem("ceiltrunk_hanging_sign", new HangingSignItem(CeilandsBlocks.CEILTRUNK_HANGING_SIGN, CeilandsBlocks.CEILTRUNK_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
	public static final Item CEILTRUNK_BOAT = registerItem("ceiltrunk_boat", new ModBoatItem(false, ModBoat.Type.CEILTRUNK, new Item.Properties().stacksTo(1)));
	public static final Item CEILTRUNK_CHEST_BOAT = registerItem("ceiltrunk_chest_boat", new ModBoatItem(true, ModBoat.Type.CEILTRUNK, new Item.Properties().stacksTo(1)));
	
	public static final Item LUZAWOOD_LOG = registerItem("luzawood_log", new BlockItem(CeilandsBlocks.LUZAWOOD_LOG, new Item.Properties()));
	public static final Item STRIPPED_LUZAWOOD_LOG = registerItem("stripped_luzawood_log", new BlockItem(CeilandsBlocks.STRIPPED_LUZAWOOD_LOG, new Item.Properties()));
	public static final Item LUZAWOOD_WOOD = registerItem("luzawood_wood", new BlockItem(CeilandsBlocks.LUZAWOOD_WOOD, new Item.Properties()));
	public static final Item STRIPPED_LUZAWOOD_WOOD = registerItem("stripped_luzawood_wood", new BlockItem(CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD, new Item.Properties()));
	public static final Item LUZAWOOD_LEAVES = registerItem("luzawood_leaves", new BlockItem(CeilandsBlocks.LUZAWOOD_LEAVES, new Item.Properties()));
	public static final Item LUZAWOOD_SAPLING = registerItem("luzawood_sapling", new BlockItem(CeilandsBlocks.LUZAWOOD_SAPLING, new Item.Properties()));
	public static final Item LUZAWOOD_PLANKS = registerItem("luzawood_planks", new BlockItem(CeilandsBlocks.LUZAWOOD_PLANKS, new Item.Properties()));
	public static final Item LUZAWOOD_STAIRS = registerItem("luzawood_stairs", new BlockItem(CeilandsBlocks.LUZAWOOD_STAIRS, new Item.Properties()));
	public static final Item LUZAWOOD_SLAB = registerItem("luzawood_slab", new BlockItem(CeilandsBlocks.LUZAWOOD_SLAB, new Item.Properties()));
	public static final Item LUZAWOOD_FENCE = registerItem("luzawood_fence", new BlockItem(CeilandsBlocks.LUZAWOOD_FENCE, new Item.Properties()));
	public static final Item LUZAWOOD_FENCE_GATE = registerItem("luzawood_fence_gate", new BlockItem(CeilandsBlocks.LUZAWOOD_FENCE_GATE, new Item.Properties()));
	public static final Item LUZAWOOD_DOOR = registerItem("luzawood_door", new BlockItem(CeilandsBlocks.LUZAWOOD_DOOR, new Item.Properties()));
	public static final Item LUZAWOOD_TRAPDOOR = registerItem("luzawood_trapdoor", new BlockItem(CeilandsBlocks.LUZAWOOD_TRAPDOOR, new Item.Properties()));
	public static final Item LUZAWOOD_BUTTON = registerItem("luzawood_button", new BlockItem(CeilandsBlocks.LUZAWOOD_BUTTON, new Item.Properties()));
	public static final Item LUZAWOOD_PRESSURE_PLATE = registerItem("luzawood_pressure_plate", new BlockItem(CeilandsBlocks.LUZAWOOD_PRESSURE_PLATE, new Item.Properties()));
	public static final Item LUZAWOOD_SIGN = registerItem("luzawood_sign", new SignItem(new Item.Properties().stacksTo(16), CeilandsBlocks.LUZAWOOD_SIGN, CeilandsBlocks.LUZAWOOD_WALL_SIGN));
	public static final Item LUZAWOOD_HANGING_SIGN = registerItem("luzawood_hanging_sign", new HangingSignItem(CeilandsBlocks.LUZAWOOD_HANGING_SIGN, CeilandsBlocks.LUZAWOOD_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
	public static final Item LUZAWOOD_BOAT = registerItem("luzawood_boat", new ModBoatItem(false, ModBoat.Type.LUZAWOOD, new Item.Properties().stacksTo(1)));
	public static final Item LUZAWOOD_CHEST_BOAT = registerItem("luzawood_chest_boat", new ModBoatItem(true, ModBoat.Type.LUZAWOOD, new Item.Properties().stacksTo(1)));
	
	public static final Item SPIDER_SILK = registerItem("spider_silk", new Item(new Item.Properties()));
	public static final Item SPIDER_SILK_BLOCK = registerItem("spider_silk_block", new BlockItem(CeilandsBlocks.SPIDER_SILK_BLOCK, new Item.Properties()));
	public static final Item SPIDER_SILK_CARPET = registerItem("spider_silk_carpet", new BlockItem(CeilandsBlocks.SPIDER_SILK_CARPET, new Item.Properties()));
	// public static final Item SPIDER_SILK_BED = registerItem("spider_silk_bed", new BedItem(CeilandsBlocks.SPIDER_SILK_BED, new Item.Properties()));
}
