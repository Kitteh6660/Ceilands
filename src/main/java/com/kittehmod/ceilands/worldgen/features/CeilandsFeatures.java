package com.kittehmod.ceilands.worldgen.features;

import com.kittehmod.ceilands.CeilandsMod;
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
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_REGULAR = FeatureUtils.createKey("ceilands:ceiltrunk_tree_regular");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_BEES = FeatureUtils.createKey("ceilands:ceiltrunk_tree_bees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CEILTRUNK_TREE_LARGE = FeatureUtils.createKey("ceilands:ceiltrunk_tree_large");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_SINGLE = FeatureUtils.createKey("ceilands:luzawood_tree_single");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_SINGLE_BEES = FeatureUtils.createKey("ceilands:luzawood_tree_single_bees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_DOUBLE = FeatureUtils.createKey("ceilands:luzawood_tree_double");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUZAWOOD_TREE_DOUBLE_BEES = FeatureUtils.createKey("ceilands:luzawood_tree_double_bees");
}
