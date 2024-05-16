package com.kittehmod.ceilands.worldgen.features.trees;

import com.kittehmod.ceilands.registry.CeilandsFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class LuzawoodTreeGrower extends AbstractTreeGrower 
{
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
		if (random.nextFloat() < 0.2) {
			return bees ? CeilandsFeatures.LUZAWOOD_TREE_DOUBLE_BEES : CeilandsFeatures.LUZAWOOD_TREE_DOUBLE;
		}
		else {
			return bees ? CeilandsFeatures.LUZAWOOD_TREE_SINGLE_BEES : CeilandsFeatures.LUZAWOOD_TREE_SINGLE;
		}
	}

}
