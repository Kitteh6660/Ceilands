package com.kittehmod.ceilands.neoforge;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.neoforge.compat.FarmersDelightCompat;
import com.kittehmod.ceilands.neoforge.compat.TwilightForestCompat;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsFeatures;
import com.kittehmod.ceilands.registry.CeilandsItems;
import com.kittehmod.ceilands.registry.CeilandsPOIType;
import com.kittehmod.ceilands.registry.CeilandsTrunkPlacerType;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.RegisterEvent;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

public class CeilandsRegistry 
{
	public static final List<Pair<ResourceLocation, Block>> COMPAT_BLOCKS = new ArrayList();
	public static final List<Pair<ResourceLocation, Item>> COMPAT_ITEMS = new ArrayList();
	
	private static boolean initializedTrunkPlacerTypes = false;
	
	@SubscribeEvent
	public static void register(RegisterEvent event) {
		event.register(Registries.BLOCK, registry -> {
			CeilandsRegistry.registerCompats();
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_portal"), CeilandsBlocks.CEILANDS_PORTAL);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous"), CeilandsBlocks.CEILINGNEOUS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_stairs"), CeilandsBlocks.CEILINGNEOUS_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_slab"), CeilandsBlocks.CEILINGNEOUS_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_wall"), CeilandsBlocks.CEILINGNEOUS_WALL);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous"), CeilandsBlocks.POLISHED_CEILINGNEOUS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_stairs"), CeilandsBlocks.POLISHED_CEILINGNEOUS_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_slab"), CeilandsBlocks.POLISHED_CEILINGNEOUS_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_wall"), CeilandsBlocks.POLISHED_CEILINGNEOUS_WALL);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_bricks"), CeilandsBlocks.CEILINGNEOUS_BRICKS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_stairs"), CeilandsBlocks.CEILINGNEOUS_BRICK_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_slab"), CeilandsBlocks.CEILINGNEOUS_BRICK_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_wall"), CeilandsBlocks.CEILINGNEOUS_BRICK_WALL);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "cracked_ceilingneous_bricks"), CeilandsBlocks.CRACKED_CEILINGNEOUS_BRICKS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "chiseled_ceilingneous"), CeilandsBlocks.CHISELED_CEILINGNEOUS);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_button"), CeilandsBlocks.CEILINGNEOUS_BUTTON);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_pressure_plate"), CeilandsBlocks.CEILINGNEOUS_PRESSURE_PLATE);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_coal_ore"), CeilandsBlocks.CEILINGNEOUS_COAL_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_copper_ore"), CeilandsBlocks.CEILINGNEOUS_COPPER_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_iron_ore"), CeilandsBlocks.CEILINGNEOUS_IRON_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_gold_ore"), CeilandsBlocks.CEILINGNEOUS_GOLD_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_diamond_ore"), CeilandsBlocks.CEILINGNEOUS_DIAMOND_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_redstone_ore"), CeilandsBlocks.CEILINGNEOUS_REDSTONE_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_lapis_ore"), CeilandsBlocks.CEILINGNEOUS_LAPIS_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_emerald_ore"), CeilandsBlocks.CEILINGNEOUS_EMERALD_ORE);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_log"), CeilandsBlocks.CEILTRUNK_LOG);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_wood"), CeilandsBlocks.CEILTRUNK_WOOD);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_ceiltrunk_log"), CeilandsBlocks.STRIPPED_CEILTRUNK_LOG);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_ceiltrunk_wood"), CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_leaves"), CeilandsBlocks.CEILTRUNK_LEAVES);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_sapling"), CeilandsBlocks.CEILTRUNK_SAPLING);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_planks"), CeilandsBlocks.CEILTRUNK_PLANKS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_stairs"), CeilandsBlocks.CEILTRUNK_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_slab"), CeilandsBlocks.CEILTRUNK_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_fence"), CeilandsBlocks.CEILTRUNK_FENCE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_button"), CeilandsBlocks.CEILTRUNK_BUTTON);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_pressure_plate"), CeilandsBlocks.CEILTRUNK_PRESSURE_PLATE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_door"), CeilandsBlocks.CEILTRUNK_DOOR);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_trapdoor"), CeilandsBlocks.CEILTRUNK_TRAPDOOR);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_fence_gate"), CeilandsBlocks.CEILTRUNK_FENCE_GATE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_sign"), CeilandsBlocks.CEILTRUNK_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_wall_sign"), CeilandsBlocks.CEILTRUNK_WALL_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_hanging_sign"), CeilandsBlocks.CEILTRUNK_HANGING_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_wall_hanging_sign"), CeilandsBlocks.CEILTRUNK_WALL_HANGING_SIGN);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_log"), CeilandsBlocks.LUZAWOOD_LOG);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_wood"), CeilandsBlocks.LUZAWOOD_WOOD);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_luzawood_log"), CeilandsBlocks.STRIPPED_LUZAWOOD_LOG);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_luzawood_wood"), CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_leaves"), CeilandsBlocks.LUZAWOOD_LEAVES);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sapling"), CeilandsBlocks.LUZAWOOD_SAPLING);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_planks"), CeilandsBlocks.LUZAWOOD_PLANKS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_stairs"), CeilandsBlocks.LUZAWOOD_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_slab"), CeilandsBlocks.LUZAWOOD_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_fence"), CeilandsBlocks.LUZAWOOD_FENCE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_button"), CeilandsBlocks.LUZAWOOD_BUTTON);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_pressure_plate"), CeilandsBlocks.LUZAWOOD_PRESSURE_PLATE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_door"), CeilandsBlocks.LUZAWOOD_DOOR);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_trapdoor"), CeilandsBlocks.LUZAWOOD_TRAPDOOR);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_fence_gate"), CeilandsBlocks.LUZAWOOD_FENCE_GATE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sign"), CeilandsBlocks.LUZAWOOD_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_wall_sign"), CeilandsBlocks.LUZAWOOD_WALL_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_hanging_sign"), CeilandsBlocks.LUZAWOOD_HANGING_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_wall_hanging_sign"), CeilandsBlocks.LUZAWOOD_WALL_HANGING_SIGN);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "potted_luzawood_sapling"), CeilandsBlocks.POTTED_LUZAWOOD_SAPLING);
			for (Pair<ResourceLocation, Block> pair : COMPAT_BLOCKS) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.ITEM, registry -> {
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_portal_activator"), CeilandsItems.CEILANDS_PORTAL_ACTIVATOR);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous"), CeilandsItems.CEILINGNEOUS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_slab"), CeilandsItems.CEILINGNEOUS_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_stairs"), CeilandsItems.CEILINGNEOUS_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_wall"), CeilandsItems.CEILINGNEOUS_WALL);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous"), CeilandsItems.POLISHED_CEILINGNEOUS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_slab"), CeilandsItems.POLISHED_CEILINGNEOUS_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_stairs"), CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "polished_ceilingneous_wall"), CeilandsItems.POLISHED_CEILINGNEOUS_WALL);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_bricks"), CeilandsItems.CEILINGNEOUS_BRICKS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_slab"), CeilandsItems.CEILINGNEOUS_BRICK_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_stairs"), CeilandsItems.CEILINGNEOUS_BRICK_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_brick_wall"), CeilandsItems.CEILINGNEOUS_BRICK_WALL);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "cracked_ceilingneous_bricks"), CeilandsItems.CRACKED_CEILINGNEOUS_BRICKS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "chiseled_ceilingneous"), CeilandsItems.CHISELED_CEILINGNEOUS);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_button"), CeilandsItems.CEILINGNEOUS_BUTTON);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_pressure_plate"), CeilandsItems.CEILINGNEOUS_PRESSURE_PLATE);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_coal_ore"), CeilandsItems.CEILINGNEOUS_COAL_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_copper_ore"), CeilandsItems.CEILINGNEOUS_COPPER_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_iron_ore"), CeilandsItems.CEILINGNEOUS_IRON_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_gold_ore"), CeilandsItems.CEILINGNEOUS_GOLD_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_diamond_ore"), CeilandsItems.CEILINGNEOUS_DIAMOND_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_redstone_ore"), CeilandsItems.CEILINGNEOUS_REDSTONE_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_lapis_ore"), CeilandsItems.CEILINGNEOUS_LAPIS_ORE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilingneous_emerald_ore"), CeilandsItems.CEILINGNEOUS_EMERALD_ORE);
			
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_log"), CeilandsItems.CEILTRUNK_LOG);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_wood"), CeilandsItems.CEILTRUNK_WOOD);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_ceiltrunk_log"), CeilandsItems.STRIPPED_CEILTRUNK_LOG);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_ceiltrunk_wood"), CeilandsItems.STRIPPED_CEILTRUNK_WOOD);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_leaves"), CeilandsItems.CEILTRUNK_LEAVES);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_sapling"), CeilandsItems.CEILTRUNK_SAPLING);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_planks"), CeilandsItems.CEILTRUNK_PLANKS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_stairs"), CeilandsItems.CEILTRUNK_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_slab"), CeilandsItems.CEILTRUNK_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_fence"), CeilandsItems.CEILTRUNK_FENCE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_button"), CeilandsItems.CEILTRUNK_BUTTON);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_pressure_plate"), CeilandsItems.CEILTRUNK_PRESSURE_PLATE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_door"), CeilandsItems.CEILTRUNK_DOOR);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_trapdoor"), CeilandsItems.CEILTRUNK_TRAPDOOR);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_fence_gate"), CeilandsItems.CEILTRUNK_FENCE_GATE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_sign"), CeilandsItems.CEILTRUNK_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_hanging_sign"), CeilandsItems.CEILTRUNK_HANGING_SIGN);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_log"), CeilandsItems.LUZAWOOD_LOG);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_wood"), CeilandsItems.LUZAWOOD_WOOD);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_luzawood_log"), CeilandsItems.STRIPPED_LUZAWOOD_LOG);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "stripped_luzawood_wood"), CeilandsItems.STRIPPED_LUZAWOOD_WOOD);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_leaves"), CeilandsItems.LUZAWOOD_LEAVES);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sapling"), CeilandsItems.LUZAWOOD_SAPLING);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_planks"), CeilandsItems.LUZAWOOD_PLANKS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_stairs"), CeilandsItems.LUZAWOOD_STAIRS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_slab"), CeilandsItems.LUZAWOOD_SLAB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_fence"), CeilandsItems.LUZAWOOD_FENCE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_button"), CeilandsItems.LUZAWOOD_BUTTON);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_pressure_plate"), CeilandsItems.LUZAWOOD_PRESSURE_PLATE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_door"), CeilandsItems.LUZAWOOD_DOOR);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_trapdoor"), CeilandsItems.LUZAWOOD_TRAPDOOR);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_fence_gate"), CeilandsItems.LUZAWOOD_FENCE_GATE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sign"), CeilandsItems.LUZAWOOD_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_hanging_sign"), CeilandsItems.LUZAWOOD_HANGING_SIGN);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_boat"), CeilandsItems.CEILTRUNK_BOAT);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_chest_boat"), CeilandsItems.CEILTRUNK_CHEST_BOAT);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_boat"), CeilandsItems.LUZAWOOD_BOAT);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_chest_boat"), CeilandsItems.LUZAWOOD_CHEST_BOAT);
			for (Pair<ResourceLocation, Item> pair : COMPAT_ITEMS) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.ENTITY_TYPE, registry -> {
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_boat"), CeilandsEntities.CEILANDS_BOAT);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_chest_boat"), CeilandsEntities.CEILANDS_CHEST_BOAT);
		});
		event.register(Registries.BLOCK_ENTITY_TYPE, registry -> {
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_sign"), CeilandsBlockEntities.CEILANDS_SIGN);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_hanging_sign"), CeilandsBlockEntities.CEILANDS_HANGING_SIGN);
		});
		event.register(Registries.FEATURE, registry -> {
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_tree"), CeilandsFeatures.CEILTRUNK_TREE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_tree"), CeilandsFeatures.LUZAWOOD_TREE);

			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiling_moss_patch"), CeilandsFeatures.CEILING_MOSS_PATCH);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiling_snow_patch"), CeilandsFeatures.CEILING_SNOW_PATCH);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_kelp"), CeilandsFeatures.CEILANDS_KELP);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_seagrass"), CeilandsFeatures.CEILANDS_SEAGRASS);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "colossal_ceilshroom"), CeilandsFeatures.CEILSHROOM);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "colossal_ceiltrunk"), CeilandsFeatures.COLOSSAL_CEILTRUNK);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "huge_icicle"), CeilandsFeatures.HUGE_ICICLE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "water_orb"), CeilandsFeatures.WATER_ORB);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "arch_bridge"), CeilandsFeatures.ARCH_BRIDGE);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "floating_island"), CeilandsFeatures.FLOATING_ISLAND);
			registry.register(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "large_floating_island"), CeilandsFeatures.FLOATING_ISLAND_LARGE);
		});
		event.register(Registries.POINT_OF_INTEREST_TYPE, registry -> {
			registry.register(CeilandsPOIType.CEILANDS_PORTAL, CeilandsPOIType.CEILANDS_PORTAL_POI);
		});
		if (!initializedTrunkPlacerTypes) {
			initializedTrunkPlacerTypes = true;
			CeilandsRegistry.registerTrunkPlacerTypes();
		}
	}
	
	protected static void registerTrunkPlacerTypes() {
		Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_trunk_placer"), CeilandsTrunkPlacerType.CEILTRUNK_TRUNK_PLACER);
		Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "large_ceiltrunk_trunk_placer"), CeilandsTrunkPlacerType.LARGE_CEILTRUNK_TRUNK_PLACER);
		Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_trunk_placer"), CeilandsTrunkPlacerType.LUZAWOOD_TRUNK_PLACER);
		Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "double_luzawood_trunk_placer"), CeilandsTrunkPlacerType.DOUBLE_LUZAWOOD_TRUNK_PLACER);
	}
	
    protected static void registerCompats() {
    	if (ModList.get().isLoaded("farmersdelight")) {
    		new FarmersDelightCompat(true);
    	}
    	if (ModList.get().isLoaded("twilightforest")) {
    		new TwilightForestCompat(true);
    	}
    	/*if (ModList.get().isLoaded("woodworks")) {
    		new WoodworksCompat(true);
    	}
    	if (ModList.get().isLoaded("boatload")) {
    		new BoatloadCompat(true);
    	}*/
    }
    
    protected static void registerFlammable() {
    	for (Triplet<Block, Integer, Integer> entry : CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS) {
    		((FireBlock)Blocks.FIRE).setFlammable(entry.getA(), entry.getB(), entry.getC());
    	}
    }
    
    protected static void registerFlowerPots() {
    	((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sapling"), () -> CeilandsBlocks.POTTED_LUZAWOOD_SAPLING);
    }
}
