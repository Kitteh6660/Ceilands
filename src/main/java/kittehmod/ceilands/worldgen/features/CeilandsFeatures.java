package kittehmod.ceilands.worldgen.features;

import java.util.List;

import kittehmod.ceilands.CeilandsMod;
import kittehmod.ceilands.block.CeilandsBlocks;
import kittehmod.ceilands.worldgen.features.trees.CeiltrunkTreeFeature;
import kittehmod.ceilands.worldgen.features.trunkplacers.CeiltrunkTrunkPlacer;
import kittehmod.ceilands.worldgen.features.trunkplacers.DoubleLuzawoodTrunkPlacer;
import kittehmod.ceilands.worldgen.features.trunkplacers.LargeCeiltrunkTrunkPlacer;
import kittehmod.ceilands.worldgen.features.trunkplacers.LuzawoodTrunkPlacer;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CeilandsFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CeilandsMod.MODID);

	public static final RegistryObject<Feature<TreeConfiguration>> CEILTRUNK_TREE = FEATURES.register("ceiltrunk_tree", () -> new CeiltrunkTreeFeature(TreeConfiguration.CODEC));
	public static final RegistryObject<Feature<TreeConfiguration>> LUZAWOOD_TREE = FEATURES.register("luzawood_tree", () -> new TreeFeature(TreeConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> ARCH_BRIDGE = FEATURES.register("arch_bridge", () -> new NaturalBridgeFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> CEILING_MOSS_PATCH = FEATURES.register("ceiling_moss_patch", () -> new CeilingPatchFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> CEILING_SNOW_PATCH = FEATURES.register("ceiling_snow_patch", () -> new CeilingPatchFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> CEILANDS_KELP = FEATURES.register("ceilands_kelp", () -> new CeilandsKelpFeature(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> CEILANDS_SEAGRASS = FEATURES.register("ceilands_seagrass", () -> new CeilandsSeagrassFeature(ProbabilityFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> CEILSHROOM = FEATURES.register("colossal_ceilshroom", () -> new ColossalCeilshroom(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> COLOSSAL_CEILTRUNK = FEATURES.register("colossal_ceiltrunk", () -> new ColossalCeiltrunkTree(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> HUGE_ICICLE = FEATURES.register("huge_icicle", () -> new HugeIcicleFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> WATER_ORB = FEATURES.register("water_orb", () -> new WaterOrbFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> FLOATING_ISLAND = FEATURES.register("floating_island", () -> new SmallFloatingIslandFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> FLOATING_ISLAND_LARGE = FEATURES.register("large_floating_island", () -> new LargeFloatingIslandFeature(BlockStateConfiguration.CODEC));
	
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> CEILTRUNK_TREE_REGULAR;
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> CEILTRUNK_TREE_BEES;
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> CEILTRUNK_TREE_LARGE;
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> LUZAWOOD_TREE_SINGLE;
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> LUZAWOOD_TREE_SINGLE_BEES;
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> LUZAWOOD_TREE_DOUBLE;
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> LUZAWOOD_TREE_DOUBLE_BEES;
	
	public static void setupFeatures() {
		CEILTRUNK_TREE_REGULAR = FeatureUtils.register("ceilands:ceiltrunk_tree_regular", CEILTRUNK_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LOG.get()), new CeiltrunkTrunkPlacer(6, 6, 2), BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LEAVES.get()), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
		CEILTRUNK_TREE_BEES = FeatureUtils.register("ceilands:ceiltrunk_tree_bees", CEILTRUNK_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LOG.get()), new CeiltrunkTrunkPlacer(6, 6, 2), BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LEAVES.get()), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(List.of(new BeehiveDecorator(0.1F))).build());
		CEILTRUNK_TREE_LARGE = FeatureUtils.register("ceilands:ceiltrunk_tree_large", CEILTRUNK_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LOG.get()), new LargeCeiltrunkTrunkPlacer(7, 18, 2), BlockStateProvider.simple(CeilandsBlocks.CEILTRUNK_LEAVES.get()), new DarkOakFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
		LUZAWOOD_TREE_SINGLE = FeatureUtils.register("ceilands:luzawood_tree_single", LUZAWOOD_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LOG.get()), new LuzawoodTrunkPlacer(3, 4, 2), BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
		LUZAWOOD_TREE_SINGLE_BEES = FeatureUtils.register("ceilands:luzawood_tree_single_bees", LUZAWOOD_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LOG.get()), new LuzawoodTrunkPlacer(3, 4, 2), BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(0.1F))).ignoreVines().build());
		LUZAWOOD_TREE_DOUBLE = FeatureUtils.register("ceilands:luzawood_tree_double", LUZAWOOD_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LOG.get()), new DoubleLuzawoodTrunkPlacer(3, 4, 2), BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
		LUZAWOOD_TREE_DOUBLE_BEES = FeatureUtils.register("ceilands:luzawood_tree_double_bees", LUZAWOOD_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LOG.get()), new DoubleLuzawoodTrunkPlacer(3, 4, 2), BlockStateProvider.simple(CeilandsBlocks.LUZAWOOD_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(1.0F))).ignoreVines().build());
	}

}
