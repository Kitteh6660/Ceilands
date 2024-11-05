package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.entity.vehicle.ModBoat;
import com.kittehmod.ceilands.item.CastleLordArmorItem;
import com.kittehmod.ceilands.item.CeilandsPortalActivatorItem;
import com.kittehmod.ceilands.item.ModBoatItem;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SpawnEggItem;

public class CeilandsItems
{
    public static final Item CEILANDS_PORTAL_ACTIVATOR = new CeilandsPortalActivatorItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TOOLS));

    public static final Item CASTLE_LORD_REGALIA_FRAGMENTS = new Item(new Item.Properties().rarity(Rarity.RARE).tab(CreativeModeTab.TAB_MISC));

    public static final Item CASTLE_LORD_CROWN = new CastleLordArmorItem(EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(CreativeModeTab.TAB_COMBAT));
    public static final Item CASTLE_LORD_CHESTPLATE = new CastleLordArmorItem(EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(CreativeModeTab.TAB_COMBAT));
    public static final Item CASTLE_LORD_LEGGINGS = new CastleLordArmorItem(EquipmentSlot.LEGS, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(CreativeModeTab.TAB_COMBAT));
    public static final Item CASTLE_LORD_BOOTS = new CastleLordArmorItem(EquipmentSlot.FEET, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(CreativeModeTab.TAB_COMBAT));

    public static final Item CASTLE_LORD_SPAWN_EGG = new SpawnEggItem(CeilandsEntities.CASTLE_LORD, 0x808080, 0x7DD880, new Item.Properties().tab(CreativeModeTab.TAB_MISC));
    
	public static final Item CEILINGNEOUS = new BlockItem(CeilandsBlocks.CEILINGNEOUS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_STAIRS = new BlockItem(CeilandsBlocks.CEILINGNEOUS_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_SLAB = new BlockItem(CeilandsBlocks.CEILINGNEOUS_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_WALL = new BlockItem(CeilandsBlocks.CEILINGNEOUS_WALL, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

	public static final Item POLISHED_CEILINGNEOUS = new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item POLISHED_CEILINGNEOUS_STAIRS = new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item POLISHED_CEILINGNEOUS_SLAB = new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item POLISHED_CEILINGNEOUS_WALL = new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_WALL, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

	public static final Item CEILINGNEOUS_BRICKS = new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_BRICK_STAIRS = new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_BRICK_SLAB = new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_BRICK_WALL = new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_WALL, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

	public static final Item CRACKED_CEILINGNEOUS_BRICKS = new BlockItem(CeilandsBlocks.CRACKED_CEILINGNEOUS_BRICKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CHISELED_CEILINGNEOUS = new BlockItem(CeilandsBlocks.CHISELED_CEILINGNEOUS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

	public static final Item CEILINGNEOUS_BUTTON = new BlockItem(CeilandsBlocks.CEILINGNEOUS_BUTTON, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item CEILINGNEOUS_PRESSURE_PLATE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_PRESSURE_PLATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));

	public static final Item ROOFSHALE = new BlockItem(CeilandsBlocks.ROOFSHALE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item ROOFSHALE_STAIRS = new BlockItem(CeilandsBlocks.ROOFSHALE_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item ROOFSHALE_SLAB = new BlockItem(CeilandsBlocks.ROOFSHALE_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item ROOFSHALE_WALL = new BlockItem(CeilandsBlocks.ROOFSHALE_WALL, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

	public static final Item POLISHED_ROOFSHALE = new BlockItem(CeilandsBlocks.POLISHED_ROOFSHALE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item POLISHED_ROOFSHALE_STAIRS = new BlockItem(CeilandsBlocks.POLISHED_ROOFSHALE_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item POLISHED_ROOFSHALE_SLAB = new BlockItem(CeilandsBlocks.POLISHED_ROOFSHALE_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item POLISHED_ROOFSHALE_WALL = new BlockItem(CeilandsBlocks.POLISHED_ROOFSHALE_WALL, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

	public static final Item ROOFSHALE_BRICKS = new BlockItem(CeilandsBlocks.ROOFSHALE_BRICKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item ROOFSHALE_BRICK_STAIRS = new BlockItem(CeilandsBlocks.ROOFSHALE_BRICK_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item ROOFSHALE_BRICK_SLAB = new BlockItem(CeilandsBlocks.ROOFSHALE_BRICK_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item ROOFSHALE_BRICK_WALL = new BlockItem(CeilandsBlocks.ROOFSHALE_BRICK_WALL, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
	
	public static final Item CHISELED_ROOFSHALE = new BlockItem(CeilandsBlocks.CHISELED_ROOFSHALE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CHISELED_ROOFSHALE_BRICKS = new BlockItem(CeilandsBlocks.CHISELED_ROOFSHALE_BRICKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	
	public static final Item CEILINGNEOUS_COAL_ORE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_COAL_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_COPPER_ORE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_COPPER_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_IRON_ORE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_IRON_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_GOLD_ORE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_GOLD_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_DIAMOND_ORE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_DIAMOND_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_REDSTONE_ORE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_REDSTONE_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_LAPIS_ORE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_LAPIS_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILINGNEOUS_EMERALD_ORE = new BlockItem(CeilandsBlocks.CEILINGNEOUS_EMERALD_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

	public static final Item CEILTRUNK_LOG = new BlockItem(CeilandsBlocks.CEILTRUNK_LOG, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item STRIPPED_CEILTRUNK_LOG = new BlockItem(CeilandsBlocks.STRIPPED_CEILTRUNK_LOG, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILTRUNK_WOOD = new BlockItem(CeilandsBlocks.CEILTRUNK_WOOD, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item STRIPPED_CEILTRUNK_WOOD = new BlockItem(CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILTRUNK_LEAVES = new BlockItem(CeilandsBlocks.CEILTRUNK_LEAVES, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
	public static final Item CEILTRUNK_SAPLING = new BlockItem(CeilandsBlocks.CEILTRUNK_SAPLING, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
	public static final Item CEILTRUNK_PLANKS = new BlockItem(CeilandsBlocks.CEILTRUNK_PLANKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILTRUNK_STAIRS = new BlockItem(CeilandsBlocks.CEILTRUNK_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILTRUNK_SLAB = new BlockItem(CeilandsBlocks.CEILTRUNK_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item CEILTRUNK_FENCE = new BlockItem(CeilandsBlocks.CEILTRUNK_FENCE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
	public static final Item CEILTRUNK_FENCE_GATE = new BlockItem(CeilandsBlocks.CEILTRUNK_FENCE_GATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item CEILTRUNK_DOOR = new BlockItem(CeilandsBlocks.CEILTRUNK_DOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item CEILTRUNK_TRAPDOOR = new BlockItem(CeilandsBlocks.CEILTRUNK_TRAPDOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item CEILTRUNK_BUTTON = new BlockItem(CeilandsBlocks.CEILTRUNK_BUTTON, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item CEILTRUNK_PRESSURE_PLATE = new BlockItem(CeilandsBlocks.CEILTRUNK_PRESSURE_PLATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item CEILTRUNK_SIGN = new SignItem(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), CeilandsBlocks.CEILTRUNK_SIGN, CeilandsBlocks.CEILTRUNK_WALL_SIGN);
	public static final Item CEILTRUNK_BOAT = new ModBoatItem(false, ModBoat.Type.CEILTRUNK, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION));
	public static final Item CEILTRUNK_CHEST_BOAT = new ModBoatItem(true, ModBoat.Type.CEILTRUNK, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION));
	
	public static final Item LUZAWOOD_LOG = new BlockItem(CeilandsBlocks.LUZAWOOD_LOG, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item STRIPPED_LUZAWOOD_LOG = new BlockItem(CeilandsBlocks.STRIPPED_LUZAWOOD_LOG, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item LUZAWOOD_WOOD = new BlockItem(CeilandsBlocks.LUZAWOOD_WOOD, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item STRIPPED_LUZAWOOD_WOOD = new BlockItem(CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item LUZAWOOD_LEAVES = new BlockItem(CeilandsBlocks.LUZAWOOD_LEAVES, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
	public static final Item LUZAWOOD_SAPLING = new BlockItem(CeilandsBlocks.LUZAWOOD_SAPLING, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
	public static final Item LUZAWOOD_PLANKS = new BlockItem(CeilandsBlocks.LUZAWOOD_PLANKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item LUZAWOOD_STAIRS = new BlockItem(CeilandsBlocks.LUZAWOOD_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item LUZAWOOD_SLAB = new BlockItem(CeilandsBlocks.LUZAWOOD_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static final Item LUZAWOOD_FENCE = new BlockItem(CeilandsBlocks.LUZAWOOD_FENCE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
	public static final Item LUZAWOOD_FENCE_GATE = new BlockItem(CeilandsBlocks.LUZAWOOD_FENCE_GATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item LUZAWOOD_DOOR = new BlockItem(CeilandsBlocks.LUZAWOOD_DOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item LUZAWOOD_TRAPDOOR = new BlockItem(CeilandsBlocks.LUZAWOOD_TRAPDOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item LUZAWOOD_BUTTON = new BlockItem(CeilandsBlocks.LUZAWOOD_BUTTON, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item LUZAWOOD_PRESSURE_PLATE = new BlockItem(CeilandsBlocks.LUZAWOOD_PRESSURE_PLATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
	public static final Item LUZAWOOD_SIGN = new SignItem(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), CeilandsBlocks.LUZAWOOD_SIGN, CeilandsBlocks.LUZAWOOD_WALL_SIGN);
	public static final Item LUZAWOOD_BOAT = new ModBoatItem(false, ModBoat.Type.LUZAWOOD, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION));
	public static final Item LUZAWOOD_CHEST_BOAT = new ModBoatItem(true, ModBoat.Type.LUZAWOOD, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION));
}
