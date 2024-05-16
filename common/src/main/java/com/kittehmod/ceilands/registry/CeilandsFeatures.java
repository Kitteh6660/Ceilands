package com.kittehmod.ceilands.registry;

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

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class CeilandsFeatures
{
	public static final Feature<TreeConfiguration> CEILTRUNK_TREE = new CeiltrunkTreeFeature(TreeConfiguration.CODEC);
	public static final Feature<TreeConfiguration> LUZAWOOD_TREE = new TreeFeature(TreeConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> ARCH_BRIDGE = new NaturalBridgeFeature(BlockStateConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> CEILING_MOSS_PATCH = new CeilingPatchFeature(BlockStateConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> CEILING_SNOW_PATCH = new CeilingPatchFeature(BlockStateConfiguration.CODEC);
	public static final Feature<NoneFeatureConfiguration> CEILANDS_KELP = new CeilandsKelpFeature(NoneFeatureConfiguration.CODEC);
	public static final Feature<ProbabilityFeatureConfiguration> CEILANDS_SEAGRASS = new CeilandsSeagrassFeature(ProbabilityFeatureConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> CEILSHROOM = new ColossalCeilshroom(BlockStateConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> COLOSSAL_CEILTRUNK = new ColossalCeiltrunkTree(BlockStateConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> HUGE_ICICLE = new HugeIcicleFeature(BlockStateConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> WATER_ORB = new WaterOrbFeature(BlockStateConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> FLOATING_ISLAND = new SmallFloatingIslandFeature(BlockStateConfiguration.CODEC);
	public static final Feature<BlockStateConfiguration> FLOATING_ISLAND_LARGE = new LargeFloatingIslandFeature(BlockStateConfiguration.CODEC);
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_REGULAR = FeatureUtils.createKey("ceilands:ceiltrunk_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_BEES = FeatureUtils.createKey("ceilands:ceiltrunk_tree_bees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_LARGE = FeatureUtils.createKey("ceilands:ceiltrunk_tree_large");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_SINGLE = FeatureUtils.createKey("ceilands:luzawood_tree_single");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_SINGLE_BEES = FeatureUtils.createKey("ceilands:luzawood_tree_single_bees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_DOUBLE = FeatureUtils.createKey("ceilands:luzawood_tree_double");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_DOUBLE_BEES = FeatureUtils.createKey("ceilands:luzawood_tree_double_bees");
}
