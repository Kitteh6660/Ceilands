package com.kittehmod.ceilands.worldgen.features;

import com.kittehmod.ceilands.block.CeilandsBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

// NOT YET IMPLEMENENTED
public class SurrealFloatingIslandFeature extends Feature<BlockStateConfiguration>
{
	public SurrealFloatingIslandFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	private static final float VEININESS_THRESHOLD = 0.4F;
	private static final int EDGE_ROUNDOFF_BEGIN = 20;
	private static final double MAX_EDGE_ROUNDOFF = 0.2D;
	private static final float VEIN_SOLIDNESS = 0.7F;

	protected static NoiseChunk.BlockStateFiller create(DensityFunction densFnc1, DensityFunction densFnc2, DensityFunction densFnc3, PositionalRandomFactory factory) {
		BlockState blockstate = null;
		return (context) -> {
			double d0 = densFnc1.compute(context);
			int i = context.blockY();
			double d1 = Math.abs(d0);
			int j = 60 - i;
			int k = i - 50;
			if (k >= 0 && j >= 0) {
				int l = Math.min(j, k);
				double d2 = Mth.clampedMap((double) l, 0.0D, EDGE_ROUNDOFF_BEGIN, -MAX_EDGE_ROUNDOFF, 0.0D);
				if (d1 + d2 < (double) VEININESS_THRESHOLD) {
					return blockstate;
				} else {
					RandomSource randomsource = factory.at(context.blockX(), i, context.blockZ());
					if (randomsource.nextFloat() > VEIN_SOLIDNESS) {
						return blockstate;
					} else if (densFnc2.compute(context) >= 0.0D) {
						return blockstate;
					} else {
						double d3 = Mth.clampedMap(d1, (double) 0.4F, (double) 0.6F, (double) 0.1F, (double) 0.3F);
						if ((double) randomsource.nextFloat() < d3 && densFnc3.compute(context) > (double) -0.3F) {
							return Blocks.DIRT.defaultBlockState();
						} else {
							return CeilandsBlocks.CEILINGNEOUS.get().defaultBlockState();
						}
					}
				}
			} else {
				return blockstate;
			}
		};
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		// TODO Auto-generated method stub
		return true;
	}

}
