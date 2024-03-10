package com.kittehmod.ceilands.worldgen.features;

import com.kittehmod.ceilands.block.CeilandsBlocks;
import com.kittehmod.ceilands.util.MathHelper;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class HugeIcicleFeature extends Feature<BlockStateConfiguration>
{

	public HugeIcicleFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		BlockPos blockpos = context.origin();
		RandomSource randomsource = context.random();
		WorldGenLevel worldgenlevel = context.level();
		// Push the icicle to the ceiling.
		for (int i = 1; i < 96; i++) {
			if (worldgenlevel.getBlockState(blockpos.above(i)).getBlock() != Blocks.AIR && worldgenlevel.getBlockState(blockpos.above(i)).getBlock() != Blocks.SNOW_BLOCK) {
				blockpos = blockpos.above(i);
				break;
			}
		}
		// Make the icicle.
		BlockState state = context.config().state;
		int width = 2 + randomsource.nextInt(8);
		int narrowenIntervals = 4 + randomsource.nextInt(6);
		if (state.getBlock() == CeilandsBlocks.CEILINGNEOUS.get()) {
			width += randomsource.nextInt(24);
			narrowenIntervals += randomsource.nextInt(8);
			if (width > 16) width = 16; // Clamp it to a maximum width.
			if (narrowenIntervals > 10) narrowenIntervals = 12;
		}
		int height = width * narrowenIntervals;
		if (height > 220) {
			height = 220;
		}
		for (int ht = 0; ht < height; ht++) {
			for (int x = -width; x <= width; ++x) {
				for (int z = -width; z <= width; ++z) {
					if (MathHelper.isPlotInCircle(x, z, width) && worldgenlevel.getBlockState(blockpos.below(ht).east(x).south(z)).getBlock() == Blocks.AIR) {
						if (blockpos.below(ht).getY() >= worldgenlevel.getMinBuildHeight()) {
							worldgenlevel.setBlock(blockpos.below(ht).east(x).south(z), state, 11);
						}
					}
				}
			}
			if (ht % narrowenIntervals == 0) {
				width--;
			}
			if (width <= 0) {
				break;
			}
		}
		return true;
	}

}
