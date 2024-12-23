package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.worldgen.features.CeilandsKelpFeature;
import com.kittehmod.ceilands.worldgen.features.CeilandsSeagrassFeature;
import com.kittehmod.ceilands.worldgen.features.CeilingPatchFeature;
import com.kittehmod.ceilands.worldgen.features.ColossalCeilshroom;
import com.kittehmod.ceilands.worldgen.features.ColossalCeiltrunkTree;
import com.kittehmod.ceilands.worldgen.features.HugeIcicleFeature;
import com.kittehmod.ceilands.worldgen.features.LargeFloatingIslandFeature;
import com.kittehmod.ceilands.worldgen.features.NaturalBridgeFeature;
import com.kittehmod.ceilands.worldgen.features.SmallFloatingIslandFeature;
import com.kittehmod.ceilands.worldgen.features.WaterOrbFeature;
import com.kittehmod.ceilands.worldgen.features.trees.CeiltrunkTreeFeature;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.CeiltrunkTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.DoubleLuzawoodTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.LargeCeiltrunkTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.LuzawoodTrunkPlacer;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import oshi.util.tuples.Pair;

public class CeilandsFeatures
{
	public static void init() {};
	
	/** Creates and registers feature. */
	private static Feature registerFeature(String name, Feature feature) {
		FEATURES.add(new Pair<ResourceLocation, Feature<?>>(new ResourceLocation(Ceilands.MOD_ID, name), feature));
		return feature;
	}

	public static final List<Pair<ResourceLocation, Feature<?>>> FEATURES = new ArrayList<Pair<ResourceLocation, Feature<?>>>();
	
	public static final Feature<TreeConfiguration> CEILTRUNK_TREE = registerFeature("ceiltrunk_tree", new CeiltrunkTreeFeature(TreeConfiguration.CODEC));
	public static final Feature<TreeConfiguration> LUZAWOOD_TREE = registerFeature("luzawood_tree", new TreeFeature(TreeConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> ARCH_BRIDGE = registerFeature("arch_bridge", new NaturalBridgeFeature(BlockStateConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> CEILING_MOSS_PATCH = registerFeature("ceiling_moss_patch", new CeilingPatchFeature(BlockStateConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> CEILING_SNOW_PATCH = registerFeature("ceiling_snow_patch", new CeilingPatchFeature(BlockStateConfiguration.CODEC));
	public static final Feature<NoneFeatureConfiguration> CEILANDS_KELP = registerFeature("ceilands_kelp", new CeilandsKelpFeature(NoneFeatureConfiguration.CODEC));
	public static final Feature<ProbabilityFeatureConfiguration> CEILANDS_SEAGRASS = registerFeature("ceilands_seagrass", new CeilandsSeagrassFeature(ProbabilityFeatureConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> CEILSHROOM = registerFeature("colossal_ceilshroom", new ColossalCeilshroom(BlockStateConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> COLOSSAL_CEILTRUNK = registerFeature("colossal_ceiltrunk", new ColossalCeiltrunkTree(BlockStateConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> HUGE_ICICLE = registerFeature("huge_icicle", new HugeIcicleFeature(BlockStateConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> WATER_ORB = registerFeature("water_orb", new WaterOrbFeature(BlockStateConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> FLOATING_ISLAND = registerFeature("floating_island", new SmallFloatingIslandFeature(BlockStateConfiguration.CODEC));
	public static final Feature<BlockStateConfiguration> FLOATING_ISLAND_LARGE = registerFeature("large_floating_island", new LargeFloatingIslandFeature(BlockStateConfiguration.CODEC));
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_REGULAR = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.tryParse("ceilands:ceiltrunk_tree"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_BEES = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.tryParse("ceilands:ceiltrunk_tree_bees"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_LARGE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.tryParse("ceilands:ceiltrunk_tree_large"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_SINGLE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.tryParse("ceilands:luzawood_tree_single"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_SINGLE_BEES = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.tryParse("ceilands:luzawood_tree_single_bees"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_DOUBLE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.tryParse("ceilands:luzawood_tree_double"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_DOUBLE_BEES = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.tryParse("ceilands:luzawood_tree_double_bees"));
}
