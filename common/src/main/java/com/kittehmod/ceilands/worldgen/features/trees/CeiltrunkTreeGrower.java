package com.kittehmod.ceilands.worldgen.features.trees;

import com.kittehmod.ceilands.registry.CeilandsFeatures;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class CeiltrunkTreeGrower extends AbstractMegaTreeGrower 
{
	@Override
	protected Holder<ConfiguredFeature<TreeConfiguration, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
		return bees ? CeilandsFeatures.CEILTRUNK_TREE_BEES : CeilandsFeatures.CEILTRUNK_TREE_REGULAR;
	}
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
		return CeilandsFeatures.CEILTRUNK_TREE_LARGE;
	}

}
