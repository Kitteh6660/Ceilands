package com.kittehmod.ceilands.registry;

import java.util.List;

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
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
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
	
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CEILTRUNK_TREE_REGULAR = FeatureUtils.register("ceilands:ceiltrunk_tree", CEILTRUNK_TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LOG), new CeiltrunkTrunkPlacer(6, 6, 2), BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LEAVES), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CEILTRUNK_TREE_BEES = FeatureUtils.register("ceilands:ceiltrunk_tree_bees", CEILTRUNK_TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LOG), new CeiltrunkTrunkPlacer(6, 6, 2), BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LEAVES), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(List.of(new BeehiveDecorator(0.1F))).build());
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CEILTRUNK_TREE_LARGE = FeatureUtils.register("ceilands:ceiltrunk_tree_large", CEILTRUNK_TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LOG), new LargeCeiltrunkTrunkPlacer(7, 18, 2), BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LEAVES), new DarkOakFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> LUZAWOOD_TREE_SINGLE = FeatureUtils.register("ceilands:luzawood_tree_single", LUZAWOOD_TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LOG), new LuzawoodTrunkPlacer(3, 4, 2), BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> LUZAWOOD_TREE_SINGLE_BEES = FeatureUtils.register("ceilands:luzawood_tree_single_bees", LUZAWOOD_TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LOG), new LuzawoodTrunkPlacer(3, 4, 2), BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(0.1F))).ignoreVines().build());
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> LUZAWOOD_TREE_DOUBLE = FeatureUtils.register("ceilands:luzawood_tree_double", LUZAWOOD_TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LOG), new DoubleLuzawoodTrunkPlacer(3, 4, 2), BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> LUZAWOOD_TREE_DOUBLE_BEES = FeatureUtils.register("ceilands:luzawood_tree_double_bees", LUZAWOOD_TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LOG), new DoubleLuzawoodTrunkPlacer(3, 4, 2), BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(1.0F))).ignoreVines().build());
}
