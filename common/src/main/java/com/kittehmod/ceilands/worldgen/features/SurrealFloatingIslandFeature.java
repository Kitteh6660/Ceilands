package com.kittehmod.ceilands.worldgen.features;

import com.kittehmod.ceilands.registry.CeilandsBlocks;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;

// NOT YET IMPLEMENENTED
public class SurrealFloatingIslandFeature
{
	private static final float VEININESS_THRESHOLD = 0.4F;
	private static final int EDGE_ROUNDOFF_BEGIN = 20;
	private static final double MAX_EDGE_ROUNDOFF = 0.2D;
	private static final float VEIN_SOLIDNESS = 0.7F;

	protected static NoiseChunk.BlockStateFiller create(DensityFunction densFnc1, DensityFunction densFnc2, DensityFunction densFnc3, PositionalRandomFactory p_209671_) {
		BlockState blockstate = null;
		return (p_209666_) -> {
			double d0 = densFnc1.compute(p_209666_);
			int i = p_209666_.blockY();
			double d1 = Math.abs(d0);
			int j = 60 - i;
			int k = i - 50;
			if (k >= 0 && j >= 0) {
				int l = Math.min(j, k);
				double d2 = Mth.clampedMap((double) l, 0.0D, 20.0D, -0.2D, 0.0D);
				if (d1 + d2 < (double) 0.4F) {
					return blockstate;
				} else {
					RandomSource randomsource = p_209671_.at(p_209666_.blockX(), i, p_209666_.blockZ());
					if (randomsource.nextFloat() > 0.7F) {
						return blockstate;
					} else if (densFnc2.compute(p_209666_) >= 0.0D) {
						return blockstate;
					} else {
						double d3 = Mth.clampedMap(d1, (double) 0.4F, (double) 0.6F, (double) 0.1F, (double) 0.3F);
						if ((double) randomsource.nextFloat() < d3 && densFnc3.compute(p_209666_) > (double) -0.3F) {
							return Blocks.DIRT.defaultBlockState();
						} else {
							return CeilandsBlocks.CEILINGNEOUS.defaultBlockState();
						}
					}
				}
			} else {
				return blockstate;
			}
		};
	}

}
