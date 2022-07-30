package kittehmod.ceilands.worldgen.features;

import com.mojang.serialization.Codec;

import kittehmod.ceilands.util.MathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class WaterOrbFeature extends Feature<BlockStateConfiguration>
{
	public WaterOrbFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		BlockPos blockpos = context.origin();
		RandomSource randomsource = context.random();
		WorldGenLevel worldgenlevel = context.level();
		int radius = 12 + randomsource.nextInt(5);
		BlockState state = context.config().state;
		// Stage 1: Create a hollow half-sphere.
		for (int posY = 0; posY < radius; posY++) {
			for (int posX = -radius; posX < radius; posX++) {
				for (int posZ = -radius; posZ < radius; posZ++) {
					if (MathHelper.isPlotInSphere(posX, posY, posZ, radius) && !worldgenlevel.getBlockState(blockpos.below(posY).east(posX).south(posZ)).getFluidState().is(FluidTags.WATER)) {
						this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), state);
					}
				}
			}
		}
		radius--;
		// Stage 2: Fill it with water.
		for (int posY = 0; posY < radius; posY++) {
			for (int posX = -radius; posX < radius; posX++) {
				for (int posZ = -radius; posZ < radius; posZ++) {
					if (MathHelper.isPlotInSphere(posX, posY, posZ, radius)) {
						this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), Blocks.WATER.defaultBlockState());
					}
				}
			}
		}
		// Stage 3: Biomeify.
		int biometype = randomsource.nextInt(3);
		Block block;
		switch(biometype) {
			default:
			case 0:
				block = Blocks.DIRT;
				break;
			case 1:
				block = Blocks.SAND;
				break;
			case 2:
				block = Blocks.GRAVEL;
				break;
		}
		for (int posY = radius - 3; posY < radius; posY++) {
			for (int posX = -radius; posX < radius; posX++) {
				for (int posZ = -radius; posZ < radius; posZ++) {
					if (MathHelper.isPlotInSphere(posX, posY, posZ, radius)) {
						this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), block.defaultBlockState());
						if (posX == 0 && posZ == 0) {
							this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), Blocks.GLOWSTONE.defaultBlockState());
						}
					}
				}
			}
		}
		return true;
	}
	
}
