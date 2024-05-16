package com.kittehmod.ceilands.worldgen.features.trees;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.registry.CeilandsFeatures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CeiltrunkTreeGrower extends AbstractMegaTreeGrower 
{
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
		return CeilandsFeatures.CEILTRUNK_TREE_REGULAR;
	}
	
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
		return CeilandsFeatures.CEILTRUNK_TREE_LARGE;
	}
}
