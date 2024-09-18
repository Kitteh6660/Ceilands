package com.kittehmod.ceilands.fabric;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.item.CeilandsFuels;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsFeatures;
import com.kittehmod.ceilands.registry.CeilandsGameRules;
import com.kittehmod.ceilands.registry.CeilandsItems;
import com.kittehmod.ceilands.registry.CeilandsTrunkPlacerType;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

public class CeilandsRegistry 
{
	public static void registerPrimary() {
		CeilandsRegistry.registerBlocks();
		CeilandsRegistry.registerItems();
		CeilandsRegistry.registerEntities();
		CeilandsRegistry.registerBlockEntities();
		CeilandsRegistry.registerFeatures();
		CeilandsRegistry.registerPOITypes();
		CeilandsRegistry.registerTrunkPlacerTypes();
	}
	
	public static void registerSecondary() {
		CeilandsRegistry.registerWoodTypes();
		CeilandsRegistry.registerStrippables();
		CeilandsRegistry.registerFuels();
		CeilandsRegistry.registerFlammableBlocks();
		CeilandsGameRules.setup();
	}
	
	public static void registerBlocks() {
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_portal"), CeilandsBlocks.CEILANDS_PORTAL);

		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous"), CeilandsBlocks.CEILINGNEOUS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_slab"), CeilandsBlocks.CEILINGNEOUS_SLAB);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_stairs"), CeilandsBlocks.CEILINGNEOUS_STAIRS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_wall"), CeilandsBlocks.CEILINGNEOUS_WALL);
		
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous"), CeilandsBlocks.POLISHED_CEILINGNEOUS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_slab"), CeilandsBlocks.POLISHED_CEILINGNEOUS_SLAB);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_stairs"), CeilandsBlocks.POLISHED_CEILINGNEOUS_STAIRS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_wall"), CeilandsBlocks.POLISHED_CEILINGNEOUS_WALL);

		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_bricks"), CeilandsBlocks.CEILINGNEOUS_BRICKS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_slab"), CeilandsBlocks.CEILINGNEOUS_BRICK_SLAB);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_stairs"), CeilandsBlocks.CEILINGNEOUS_BRICK_STAIRS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_wall"), CeilandsBlocks.CEILINGNEOUS_BRICK_WALL);
		
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "cracked_ceilingneous_bricks"), CeilandsBlocks.CRACKED_CEILINGNEOUS_BRICKS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "chiseled_ceilingneous"), CeilandsBlocks.CHISELED_CEILINGNEOUS);

		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_button"), CeilandsBlocks.CEILINGNEOUS_BUTTON);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_pressure_plate"), CeilandsBlocks.CEILINGNEOUS_PRESSURE_PLATE);

		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_coal_ore"), CeilandsBlocks.CEILINGNEOUS_COAL_ORE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_copper_ore"), CeilandsBlocks.CEILINGNEOUS_COPPER_ORE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_iron_ore"), CeilandsBlocks.CEILINGNEOUS_IRON_ORE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_gold_ore"), CeilandsBlocks.CEILINGNEOUS_GOLD_ORE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_diamond_ore"), CeilandsBlocks.CEILINGNEOUS_DIAMOND_ORE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_redstone_ore"), CeilandsBlocks.CEILINGNEOUS_REDSTONE_ORE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_lapis_ore"), CeilandsBlocks.CEILINGNEOUS_LAPIS_ORE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_emerald_ore"), CeilandsBlocks.CEILINGNEOUS_EMERALD_ORE);
		
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_log"), CeilandsBlocks.CEILTRUNK_LOG);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_wood"), CeilandsBlocks.CEILTRUNK_WOOD);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_ceiltrunk_log"), CeilandsBlocks.STRIPPED_CEILTRUNK_LOG);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_ceiltrunk_wood"), CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_leaves"), CeilandsBlocks.CEILTRUNK_LEAVES);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_sapling"), CeilandsBlocks.CEILTRUNK_SAPLING);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_planks"), CeilandsBlocks.CEILTRUNK_PLANKS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_stairs"), CeilandsBlocks.CEILTRUNK_STAIRS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_slab"), CeilandsBlocks.CEILTRUNK_SLAB);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_fence"), CeilandsBlocks.CEILTRUNK_FENCE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_button"), CeilandsBlocks.CEILTRUNK_BUTTON);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_pressure_plate"), CeilandsBlocks.CEILTRUNK_PRESSURE_PLATE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_door"), CeilandsBlocks.CEILTRUNK_DOOR);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_trapdoor"), CeilandsBlocks.CEILTRUNK_TRAPDOOR);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_fence_gate"), CeilandsBlocks.CEILTRUNK_FENCE_GATE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_sign"), CeilandsBlocks.CEILTRUNK_SIGN);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_wall_sign"), CeilandsBlocks.CEILTRUNK_WALL_SIGN);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_hanging_sign"), CeilandsBlocks.CEILTRUNK_HANGING_SIGN);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_wall_hanging_sign"), CeilandsBlocks.CEILTRUNK_WALL_HANGING_SIGN);

		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_log"), CeilandsBlocks.LUZAWOOD_LOG);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_wood"), CeilandsBlocks.LUZAWOOD_WOOD);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_luzawood_log"), CeilandsBlocks.STRIPPED_LUZAWOOD_LOG);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_luzawood_wood"), CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_leaves"), CeilandsBlocks.LUZAWOOD_LEAVES);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sapling"), CeilandsBlocks.LUZAWOOD_SAPLING);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_planks"), CeilandsBlocks.LUZAWOOD_PLANKS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_stairs"), CeilandsBlocks.LUZAWOOD_STAIRS);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_slab"), CeilandsBlocks.LUZAWOOD_SLAB);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_fence"), CeilandsBlocks.LUZAWOOD_FENCE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_button"), CeilandsBlocks.LUZAWOOD_BUTTON);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_pressure_plate"), CeilandsBlocks.LUZAWOOD_PRESSURE_PLATE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_door"), CeilandsBlocks.LUZAWOOD_DOOR);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_trapdoor"), CeilandsBlocks.LUZAWOOD_TRAPDOOR);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_fence_gate"), CeilandsBlocks.LUZAWOOD_FENCE_GATE);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sign"), CeilandsBlocks.LUZAWOOD_SIGN);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_wall_sign"), CeilandsBlocks.LUZAWOOD_WALL_SIGN);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_hanging_sign"), CeilandsBlocks.LUZAWOOD_HANGING_SIGN);
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_wall_hanging_sign"), CeilandsBlocks.LUZAWOOD_WALL_HANGING_SIGN);
		
		Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "potted_luzawood_sapling"), CeilandsBlocks.POTTED_LUZAWOOD_SAPLING);
	}
	
	public static void registerItems() {
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_portal_activator"), CeilandsItems.CEILANDS_PORTAL_ACTIVATOR);

		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous"), CeilandsItems.CEILINGNEOUS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_slab"), CeilandsItems.CEILINGNEOUS_SLAB);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_stairs"), CeilandsItems.CEILINGNEOUS_STAIRS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_wall"), CeilandsItems.CEILINGNEOUS_WALL);
		
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous"), CeilandsItems.POLISHED_CEILINGNEOUS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_slab"), CeilandsItems.POLISHED_CEILINGNEOUS_SLAB);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_stairs"), CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_wall"), CeilandsItems.POLISHED_CEILINGNEOUS_WALL);

		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_bricks"), CeilandsItems.CEILINGNEOUS_BRICKS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_slab"), CeilandsItems.CEILINGNEOUS_BRICK_SLAB);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_stairs"), CeilandsItems.CEILINGNEOUS_BRICK_STAIRS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_wall"), CeilandsItems.CEILINGNEOUS_BRICK_WALL);
		
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "cracked_ceilingneous_bricks"), CeilandsItems.CRACKED_CEILINGNEOUS_BRICKS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "chiseled_ceilingneous"), CeilandsItems.CHISELED_CEILINGNEOUS);

		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_button"), CeilandsItems.CEILINGNEOUS_BUTTON);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_pressure_plate"), CeilandsItems.CEILINGNEOUS_PRESSURE_PLATE);

		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_coal_ore"), CeilandsItems.CEILINGNEOUS_COAL_ORE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_copper_ore"), CeilandsItems.CEILINGNEOUS_COPPER_ORE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_iron_ore"), CeilandsItems.CEILINGNEOUS_IRON_ORE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_gold_ore"), CeilandsItems.CEILINGNEOUS_GOLD_ORE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_diamond_ore"), CeilandsItems.CEILINGNEOUS_DIAMOND_ORE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_redstone_ore"), CeilandsItems.CEILINGNEOUS_REDSTONE_ORE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_lapis_ore"), CeilandsItems.CEILINGNEOUS_LAPIS_ORE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_emerald_ore"), CeilandsItems.CEILINGNEOUS_EMERALD_ORE);
		
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_log"), CeilandsItems.CEILTRUNK_LOG);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_wood"), CeilandsItems.CEILTRUNK_WOOD);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_ceiltrunk_log"), CeilandsItems.STRIPPED_CEILTRUNK_LOG);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_ceiltrunk_wood"), CeilandsItems.STRIPPED_CEILTRUNK_WOOD);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_leaves"), CeilandsItems.CEILTRUNK_LEAVES);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_sapling"), CeilandsItems.CEILTRUNK_SAPLING);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_planks"), CeilandsItems.CEILTRUNK_PLANKS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_stairs"), CeilandsItems.CEILTRUNK_STAIRS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_slab"), CeilandsItems.CEILTRUNK_SLAB);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_fence"), CeilandsItems.CEILTRUNK_FENCE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_button"), CeilandsItems.CEILTRUNK_BUTTON);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_pressure_plate"), CeilandsItems.CEILTRUNK_PRESSURE_PLATE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_door"), CeilandsItems.CEILTRUNK_DOOR);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_trapdoor"), CeilandsItems.CEILTRUNK_TRAPDOOR);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_fence_gate"), CeilandsItems.CEILTRUNK_FENCE_GATE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_sign"), CeilandsItems.CEILTRUNK_SIGN);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_hanging_sign"), CeilandsItems.CEILTRUNK_HANGING_SIGN);

		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_log"), CeilandsItems.LUZAWOOD_LOG);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_wood"), CeilandsItems.LUZAWOOD_WOOD);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_luzawood_log"), CeilandsItems.STRIPPED_LUZAWOOD_LOG);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_luzawood_wood"), CeilandsItems.STRIPPED_LUZAWOOD_WOOD);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_leaves"), CeilandsItems.LUZAWOOD_LEAVES);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sapling"), CeilandsItems.LUZAWOOD_SAPLING);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_planks"), CeilandsItems.LUZAWOOD_PLANKS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_stairs"), CeilandsItems.LUZAWOOD_STAIRS);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_slab"), CeilandsItems.LUZAWOOD_SLAB);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_fence"), CeilandsItems.LUZAWOOD_FENCE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_button"), CeilandsItems.LUZAWOOD_BUTTON);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_pressure_plate"), CeilandsItems.LUZAWOOD_PRESSURE_PLATE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_door"), CeilandsItems.LUZAWOOD_DOOR);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_trapdoor"), CeilandsItems.LUZAWOOD_TRAPDOOR);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_fence_gate"), CeilandsItems.LUZAWOOD_FENCE_GATE);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sign"), CeilandsItems.LUZAWOOD_SIGN);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_hanging_sign"), CeilandsItems.LUZAWOOD_HANGING_SIGN);

		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_boat"), CeilandsItems.CEILTRUNK_BOAT);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_chest_boat"), CeilandsItems.CEILTRUNK_CHEST_BOAT);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_boat"), CeilandsItems.LUZAWOOD_BOAT);
		Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_chest_boat"), CeilandsItems.LUZAWOOD_CHEST_BOAT);
	}
	
	public static void registerEntities() {
		Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_boat"), CeilandsEntities.CEILANDS_BOAT);
		Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_chest_boat"), CeilandsEntities.CEILANDS_CHEST_BOAT);
	}

	public static void registerBlockEntities() {
		Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_sign"), CeilandsBlockEntities.CEILANDS_SIGN);
		Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_hanging_sign"), CeilandsBlockEntities.CEILANDS_HANGING_SIGN);
	}
	
	public static void registerFeatures() {
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_tree"), CeilandsFeatures.CEILTRUNK_TREE);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_tree"), CeilandsFeatures.LUZAWOOD_TREE);

		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiling_moss_patch"), CeilandsFeatures.CEILING_MOSS_PATCH);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiling_snow_patch"), CeilandsFeatures.CEILING_SNOW_PATCH);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_kelp"), CeilandsFeatures.CEILANDS_KELP);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_seagrass"), CeilandsFeatures.CEILANDS_SEAGRASS);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "colossal_ceilshroom"), CeilandsFeatures.CEILSHROOM);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "colossal_ceiltrunk"), CeilandsFeatures.COLOSSAL_CEILTRUNK);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "huge_icicle"), CeilandsFeatures.HUGE_ICICLE);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "water_orb"), CeilandsFeatures.WATER_ORB);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "arch_bridge"), CeilandsFeatures.ARCH_BRIDGE);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "floating_island"), CeilandsFeatures.FLOATING_ISLAND);
		Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "large_floating_island"), CeilandsFeatures.FLOATING_ISLAND_LARGE);
	}
	
	public static void registerPOITypes() {
		PointOfInterestHelper.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_portal"), 0, 1, CeilandsBlocks.CEILANDS_PORTAL);
	}
	
	public static void registerTrunkPlacerTypes() {
		Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_trunk_placer"), CeilandsTrunkPlacerType.CEILTRUNK_TRUNK_PLACER);
		Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "large_ceiltrunk_trunk_placer"), CeilandsTrunkPlacerType.LARGE_CEILTRUNK_TRUNK_PLACER);
		Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_trunk_placer"), CeilandsTrunkPlacerType.LUZAWOOD_TRUNK_PLACER);
		Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "double_luzawood_trunk_placer"), CeilandsTrunkPlacerType.DOUBLE_LUZAWOOD_TRUNK_PLACER);
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
	
}
