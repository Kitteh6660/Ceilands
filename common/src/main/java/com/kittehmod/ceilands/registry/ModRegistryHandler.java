package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import oshi.util.tuples.Pair;

public class ModRegistryHandler 
{
	public static final List<Pair<ResourceLocation, Block>> BLOCKS = new ArrayList<Pair<ResourceLocation, Block>>();
	public static final List<Pair<ResourceLocation, Item>> ITEMS = new ArrayList<Pair<ResourceLocation, Item>>();
	public static final List<Pair<ResourceLocation, EntityType<?>>> ENTITIES = new ArrayList<Pair<ResourceLocation, EntityType<?>>>();
	public static final List<Pair<ResourceLocation, BlockEntityType<?>>> BLOCK_ENTITIES = new ArrayList<Pair<ResourceLocation, BlockEntityType<?>>>();
	public static final List<Pair<ResourceLocation, Feature<?>>> FEATURES = new ArrayList<Pair<ResourceLocation, Feature<?>>>();
	public static final List<Pair<ResourceLocation, TrunkPlacerType<?>>> TRUNK_PLACERS = new ArrayList<Pair<ResourceLocation, TrunkPlacerType<?>>>();
	public static final List<Pair<ResourceKey, PoiType>> POI_TYPES = new ArrayList<Pair<ResourceKey, PoiType>>();
	
	public static void registerModContent(boolean registerImmediately) {
		registerBlocks();
		registerItems();
		registerEntities();
		registerBlockEntities();
		registerFeatures();
		registerTrunkPlacerTypes();
		// Don't use the below code on Forge. Only do this on Fabric.
		if (registerImmediately) {
			for (Pair<ResourceLocation, Block> pair : BLOCKS) {
				Registry.register(Registry.BLOCK, pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, Item> pair : ITEMS) {
				Registry.register(Registry.ITEM, pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, EntityType<?>> pair : ENTITIES) {
				Registry.register(Registry.ENTITY_TYPE, pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, BlockEntityType<?>> pair : BLOCK_ENTITIES) {
				Registry.register(Registry.BLOCK_ENTITY_TYPE, pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, Feature<?>> pair : FEATURES) {
				Registry.register(Registry.FEATURE, pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, TrunkPlacerType<?>> pair : TRUNK_PLACERS) {
				Registry.register(Registry.TRUNK_PLACER_TYPES, pair.getA(), pair.getB());
			}
		}
	}
	
	public static void registerBlocks() {
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilands_portal"), CeilandsBlocks.CEILANDS_PORTAL);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous"), CeilandsBlocks.CEILINGNEOUS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_slab"), CeilandsBlocks.CEILINGNEOUS_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_stairs"), CeilandsBlocks.CEILINGNEOUS_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_wall"), CeilandsBlocks.CEILINGNEOUS_WALL);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_ceilingneous"), CeilandsBlocks.POLISHED_CEILINGNEOUS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_ceilingneous_slab"), CeilandsBlocks.POLISHED_CEILINGNEOUS_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_ceilingneous_stairs"), CeilandsBlocks.POLISHED_CEILINGNEOUS_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_ceilingneous_wall"), CeilandsBlocks.POLISHED_CEILINGNEOUS_WALL);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_bricks"), CeilandsBlocks.CEILINGNEOUS_BRICKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_brick_slab"), CeilandsBlocks.CEILINGNEOUS_BRICK_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_brick_stairs"), CeilandsBlocks.CEILINGNEOUS_BRICK_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_brick_wall"), CeilandsBlocks.CEILINGNEOUS_BRICK_WALL);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "cracked_ceilingneous_bricks"), CeilandsBlocks.CRACKED_CEILINGNEOUS_BRICKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "chiseled_ceilingneous"), CeilandsBlocks.CHISELED_CEILINGNEOUS);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_button"), CeilandsBlocks.CEILINGNEOUS_BUTTON);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_pressure_plate"), CeilandsBlocks.CEILINGNEOUS_PRESSURE_PLATE);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale"), CeilandsBlocks.ROOFSHALE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_slab"), CeilandsBlocks.ROOFSHALE_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_stairs"), CeilandsBlocks.ROOFSHALE_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_wall"), CeilandsBlocks.ROOFSHALE_WALL);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_roofshale"), CeilandsBlocks.POLISHED_ROOFSHALE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_roofshale_slab"), CeilandsBlocks.POLISHED_ROOFSHALE_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_roofshale_stairs"), CeilandsBlocks.POLISHED_ROOFSHALE_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_roofshale_wall"), CeilandsBlocks.POLISHED_ROOFSHALE_WALL);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_bricks"), CeilandsBlocks.ROOFSHALE_BRICKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_brick_slab"), CeilandsBlocks.ROOFSHALE_BRICK_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_brick_stairs"), CeilandsBlocks.ROOFSHALE_BRICK_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_brick_wall"), CeilandsBlocks.ROOFSHALE_BRICK_WALL);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "chiseled_roofshale"), CeilandsBlocks.CHISELED_ROOFSHALE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "chiseled_roofshale_bricks"), CeilandsBlocks.CHISELED_ROOFSHALE_BRICKS);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_coal_ore"), CeilandsBlocks.CEILINGNEOUS_COAL_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_copper_ore"), CeilandsBlocks.CEILINGNEOUS_COPPER_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_iron_ore"), CeilandsBlocks.CEILINGNEOUS_IRON_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_gold_ore"), CeilandsBlocks.CEILINGNEOUS_GOLD_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_diamond_ore"), CeilandsBlocks.CEILINGNEOUS_DIAMOND_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_redstone_ore"), CeilandsBlocks.CEILINGNEOUS_REDSTONE_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_lapis_ore"), CeilandsBlocks.CEILINGNEOUS_LAPIS_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_emerald_ore"), CeilandsBlocks.CEILINGNEOUS_EMERALD_ORE);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_ore"), CeilandsBlocks.CEILINUM_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "raw_ceilinum_block"), CeilandsBlocks.RAW_CEILINUM_BLOCK);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_block"), CeilandsBlocks.CEILINUM_BLOCK);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "cut_ceilinum"), CeilandsBlocks.CUT_CEILINUM);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "cut_ceilinum_stairs"), CeilandsBlocks.CUT_CEILINUM_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "cut_ceilinum_slab"), CeilandsBlocks.CUT_CEILINUM_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "chiseled_ceilinum"), CeilandsBlocks.CHISELED_CEILINUM);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_bars"), CeilandsBlocks.CEILINUM_BARS);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_door"), CeilandsBlocks.CEILINUM_DOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_trapdoor"), CeilandsBlocks.CEILINUM_TRAPDOOR);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_log"), CeilandsBlocks.CEILTRUNK_LOG);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_wood"), CeilandsBlocks.CEILTRUNK_WOOD);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "stripped_ceiltrunk_log"), CeilandsBlocks.STRIPPED_CEILTRUNK_LOG);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "stripped_ceiltrunk_wood"), CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_leaves"), CeilandsBlocks.CEILTRUNK_LEAVES);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_sapling"), CeilandsBlocks.CEILTRUNK_SAPLING);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_planks"), CeilandsBlocks.CEILTRUNK_PLANKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_stairs"), CeilandsBlocks.CEILTRUNK_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_slab"), CeilandsBlocks.CEILTRUNK_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_fence"), CeilandsBlocks.CEILTRUNK_FENCE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_button"), CeilandsBlocks.CEILTRUNK_BUTTON);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_pressure_plate"), CeilandsBlocks.CEILTRUNK_PRESSURE_PLATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_door"), CeilandsBlocks.CEILTRUNK_DOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_trapdoor"), CeilandsBlocks.CEILTRUNK_TRAPDOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_fence_gate"), CeilandsBlocks.CEILTRUNK_FENCE_GATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_sign"), CeilandsBlocks.CEILTRUNK_SIGN);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_wall_sign"), CeilandsBlocks.CEILTRUNK_WALL_SIGN);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_log"), CeilandsBlocks.LUZAWOOD_LOG);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_wood"), CeilandsBlocks.LUZAWOOD_WOOD);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "stripped_luzawood_log"), CeilandsBlocks.STRIPPED_LUZAWOOD_LOG);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "stripped_luzawood_wood"), CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_leaves"), CeilandsBlocks.LUZAWOOD_LEAVES);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_sapling"), CeilandsBlocks.LUZAWOOD_SAPLING);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_planks"), CeilandsBlocks.LUZAWOOD_PLANKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_stairs"), CeilandsBlocks.LUZAWOOD_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_slab"), CeilandsBlocks.LUZAWOOD_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_fence"), CeilandsBlocks.LUZAWOOD_FENCE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_button"), CeilandsBlocks.LUZAWOOD_BUTTON);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_pressure_plate"), CeilandsBlocks.LUZAWOOD_PRESSURE_PLATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_door"), CeilandsBlocks.LUZAWOOD_DOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_trapdoor"), CeilandsBlocks.LUZAWOOD_TRAPDOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_fence_gate"), CeilandsBlocks.LUZAWOOD_FENCE_GATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_sign"), CeilandsBlocks.LUZAWOOD_SIGN);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_wall_sign"), CeilandsBlocks.LUZAWOOD_WALL_SIGN);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "potted_luzawood_sapling"), CeilandsBlocks.POTTED_LUZAWOOD_SAPLING);
	}
	
	public static void registerItems() {
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilands_portal_activator"), CeilandsItems.CEILANDS_PORTAL_ACTIVATOR);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "castle_lord_regalia_fragments"), CeilandsItems.CASTLE_LORD_REGALIA_FRAGMENTS);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "castle_lord_crown"), CeilandsItems.CASTLE_LORD_CROWN);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "castle_lord_chestplate"), CeilandsItems.CASTLE_LORD_CHESTPLATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "castle_lord_leggings"), CeilandsItems.CASTLE_LORD_LEGGINGS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "castle_lord_boots"), CeilandsItems.CASTLE_LORD_BOOTS);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "castle_lord_spawn_egg"), CeilandsItems.CASTLE_LORD_SPAWN_EGG);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous"), CeilandsItems.CEILINGNEOUS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_slab"), CeilandsItems.CEILINGNEOUS_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_stairs"), CeilandsItems.CEILINGNEOUS_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_wall"), CeilandsItems.CEILINGNEOUS_WALL);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_ceilingneous"), CeilandsItems.POLISHED_CEILINGNEOUS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_ceilingneous_slab"), CeilandsItems.POLISHED_CEILINGNEOUS_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_ceilingneous_stairs"), CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_ceilingneous_wall"), CeilandsItems.POLISHED_CEILINGNEOUS_WALL);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_bricks"), CeilandsItems.CEILINGNEOUS_BRICKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_brick_slab"), CeilandsItems.CEILINGNEOUS_BRICK_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_brick_stairs"), CeilandsItems.CEILINGNEOUS_BRICK_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_brick_wall"), CeilandsItems.CEILINGNEOUS_BRICK_WALL);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "cracked_ceilingneous_bricks"), CeilandsItems.CRACKED_CEILINGNEOUS_BRICKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "chiseled_ceilingneous"), CeilandsItems.CHISELED_CEILINGNEOUS);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_button"), CeilandsItems.CEILINGNEOUS_BUTTON);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_pressure_plate"), CeilandsItems.CEILINGNEOUS_PRESSURE_PLATE);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale"), CeilandsItems.ROOFSHALE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_slab"), CeilandsItems.ROOFSHALE_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_stairs"), CeilandsItems.ROOFSHALE_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_wall"), CeilandsItems.ROOFSHALE_WALL);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_roofshale"), CeilandsItems.POLISHED_ROOFSHALE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_roofshale_slab"), CeilandsItems.POLISHED_ROOFSHALE_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_roofshale_stairs"), CeilandsItems.POLISHED_ROOFSHALE_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "polished_roofshale_wall"), CeilandsItems.POLISHED_ROOFSHALE_WALL);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_bricks"), CeilandsItems.ROOFSHALE_BRICKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_brick_slab"), CeilandsItems.ROOFSHALE_BRICK_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_brick_stairs"), CeilandsItems.ROOFSHALE_BRICK_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "roofshale_brick_wall"), CeilandsItems.ROOFSHALE_BRICK_WALL);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "chiseled_roofshale"), CeilandsItems.CHISELED_ROOFSHALE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "chiseled_roofshale_bricks"), CeilandsItems.CHISELED_ROOFSHALE_BRICKS);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_coal_ore"), CeilandsItems.CEILINGNEOUS_COAL_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_copper_ore"), CeilandsItems.CEILINGNEOUS_COPPER_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_iron_ore"), CeilandsItems.CEILINGNEOUS_IRON_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_gold_ore"), CeilandsItems.CEILINGNEOUS_GOLD_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_diamond_ore"), CeilandsItems.CEILINGNEOUS_DIAMOND_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_redstone_ore"), CeilandsItems.CEILINGNEOUS_REDSTONE_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_lapis_ore"), CeilandsItems.CEILINGNEOUS_LAPIS_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilingneous_emerald_ore"), CeilandsItems.CEILINGNEOUS_EMERALD_ORE);
		
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_ore"), CeilandsItems.CEILINUM_ORE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "raw_ceilinum_block"), CeilandsItems.RAW_CEILINUM_BLOCK);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_block"), CeilandsItems.CEILINUM_BLOCK);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "cut_ceilinum"), CeilandsItems.CUT_CEILINUM);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "cut_ceilinum_stairs"), CeilandsItems.CUT_CEILINUM_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "cut_ceilinum_slab"), CeilandsItems.CUT_CEILINUM_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "chiseled_ceilinum"), CeilandsItems.CHISELED_CEILINUM);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_bars"), CeilandsItems.CEILINUM_BARS);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_door"), CeilandsItems.CEILINUM_DOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_trapdoor"), CeilandsItems.CEILINUM_TRAPDOOR);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "raw_ceilinum"), CeilandsItems.RAW_CEILINUM);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_ingot"), CeilandsItems.CEILINUM_INGOT);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilinum_nugget"), CeilandsItems.CEILINUM_NUGGET);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_log"), CeilandsItems.CEILTRUNK_LOG);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_wood"), CeilandsItems.CEILTRUNK_WOOD);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "stripped_ceiltrunk_log"), CeilandsItems.STRIPPED_CEILTRUNK_LOG);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "stripped_ceiltrunk_wood"), CeilandsItems.STRIPPED_CEILTRUNK_WOOD);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_leaves"), CeilandsItems.CEILTRUNK_LEAVES);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_sapling"), CeilandsItems.CEILTRUNK_SAPLING);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_planks"), CeilandsItems.CEILTRUNK_PLANKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_stairs"), CeilandsItems.CEILTRUNK_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_slab"), CeilandsItems.CEILTRUNK_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_fence"), CeilandsItems.CEILTRUNK_FENCE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_button"), CeilandsItems.CEILTRUNK_BUTTON);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_pressure_plate"), CeilandsItems.CEILTRUNK_PRESSURE_PLATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_door"), CeilandsItems.CEILTRUNK_DOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_trapdoor"), CeilandsItems.CEILTRUNK_TRAPDOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_fence_gate"), CeilandsItems.CEILTRUNK_FENCE_GATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_sign"), CeilandsItems.CEILTRUNK_SIGN);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_log"), CeilandsItems.LUZAWOOD_LOG);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_wood"), CeilandsItems.LUZAWOOD_WOOD);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "stripped_luzawood_log"), CeilandsItems.STRIPPED_LUZAWOOD_LOG);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "stripped_luzawood_wood"), CeilandsItems.STRIPPED_LUZAWOOD_WOOD);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_leaves"), CeilandsItems.LUZAWOOD_LEAVES);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_sapling"), CeilandsItems.LUZAWOOD_SAPLING);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_planks"), CeilandsItems.LUZAWOOD_PLANKS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_stairs"), CeilandsItems.LUZAWOOD_STAIRS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_slab"), CeilandsItems.LUZAWOOD_SLAB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_fence"), CeilandsItems.LUZAWOOD_FENCE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_button"), CeilandsItems.LUZAWOOD_BUTTON);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_pressure_plate"), CeilandsItems.LUZAWOOD_PRESSURE_PLATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_door"), CeilandsItems.LUZAWOOD_DOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_trapdoor"), CeilandsItems.LUZAWOOD_TRAPDOOR);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_fence_gate"), CeilandsItems.LUZAWOOD_FENCE_GATE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_sign"), CeilandsItems.LUZAWOOD_SIGN);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_boat"), CeilandsItems.CEILTRUNK_BOAT);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_chest_boat"), CeilandsItems.CEILTRUNK_CHEST_BOAT);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_boat"), CeilandsItems.LUZAWOOD_BOAT);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_chest_boat"), CeilandsItems.LUZAWOOD_CHEST_BOAT);
	}
	
	public static void registerEntities() {
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "castle_lord"), CeilandsEntities.CASTLE_LORD);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilands_boat"), CeilandsEntities.CEILANDS_BOAT);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilands_chest_boat"), CeilandsEntities.CEILANDS_CHEST_BOAT);
	}

	public static void registerBlockEntities() {
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilands_sign"), CeilandsBlockEntities.CEILANDS_SIGN);
	}
	
	public static void registerFeatures() {
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_tree"), CeilandsFeatures.CEILTRUNK_TREE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_tree"), CeilandsFeatures.LUZAWOOD_TREE);

		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiling_moss_patch"), CeilandsFeatures.CEILING_MOSS_PATCH);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiling_snow_patch"), CeilandsFeatures.CEILING_SNOW_PATCH);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilands_kelp"), CeilandsFeatures.CEILANDS_KELP);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceilands_seagrass"), CeilandsFeatures.CEILANDS_SEAGRASS);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "colossal_ceilshroom"), CeilandsFeatures.CEILSHROOM);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "colossal_ceiltrunk"), CeilandsFeatures.COLOSSAL_CEILTRUNK);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "huge_icicle"), CeilandsFeatures.HUGE_ICICLE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "water_orb"), CeilandsFeatures.WATER_ORB);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "arch_bridge"), CeilandsFeatures.ARCH_BRIDGE);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "floating_island"), CeilandsFeatures.FLOATING_ISLAND);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "large_floating_island"), CeilandsFeatures.FLOATING_ISLAND_LARGE);
	}
	
	public static void registerTrunkPlacerTypes() {
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_trunk_placer"), CeilandsTrunkPlacerType.CEILTRUNK_TRUNK_PLACER);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "large_ceiltrunk_trunk_placer"), CeilandsTrunkPlacerType.LARGE_CEILTRUNK_TRUNK_PLACER);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "luzawood_trunk_placer"), CeilandsTrunkPlacerType.LUZAWOOD_TRUNK_PLACER);
		addToRegisterable(new ResourceLocation(Ceilands.MOD_ID, "double_luzawood_trunk_placer"), CeilandsTrunkPlacerType.DOUBLE_LUZAWOOD_TRUNK_PLACER);
	}
	
	// All those disgusting jank just so I can register on Forge side.
	public static void addToRegisterable(ResourceLocation resourceLocation, Object obj) {
		List list = null;
		if (obj instanceof Block) {
			list = BLOCKS;
		}
		else if (obj instanceof Item) {
			list = ITEMS;
		}
		else if (obj instanceof EntityType) {
			list = ENTITIES;
		}
		else if (obj instanceof BlockEntityType) {
			list = BLOCK_ENTITIES;
		}
		else if (obj instanceof Feature) {
			list = FEATURES;
		}
		else if (obj instanceof TrunkPlacerType) {
			list = TRUNK_PLACERS;
		}
		if (list == null) {
			throw new NullPointerException("No matching list found for associated object!");
		}
		list.add(new Pair(resourceLocation, obj));
	}
}
