package com.kittehmod.ceilands.worldgen.features.trees;

import com.kittehmod.ceilands.worldgen.features.CeilandsFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CeiltrunkTreeGrower extends AbstractMegaTreeGrower 
{
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
		return bees ? CeilandsFeatures.CEILTRUNK_TREE_BEES : CeilandsFeatures.CEILTRUNK_TREE_REGULAR;
	}
	
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
		return CeilandsFeatures.CEILTRUNK_TREE_LARGE;
	}

}
