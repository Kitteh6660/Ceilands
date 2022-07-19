package kittehmod.ceilands.worldgen.features;

import com.mojang.serialization.Codec;

import kittehmod.ceilands.block.CeilandsBlocks;
import kittehmod.ceilands.util.CircleHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class LargeFloatingIslandFeature extends Feature<BlockStateConfiguration>
{

	public LargeFloatingIslandFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		BlockPos blockpos = context.origin();
		RandomSource randomsource = context.random();
		WorldGenLevel worldgenlevel = context.level();
		int radius = 12 + randomsource.nextInt(5);
		int height = (radius / 2) + randomsource.nextInt(12);
		int taperingAmt = height > radius ? 2 : 1;
		int taperingSteps = height * 0.5 < radius ? 2 : 1;
		boolean hasPond = randomsource.nextFloat() < 0.2;
		int pondDepth = hasPond ? randomsource.nextInt(3) : 0;
		int pondWidth = hasPond ? pondDepth * 2 + randomsource.nextInt(4) : 0;
		for (int posY = 0; posY < height; posY++) {
			if (posY == 0) {
				radius--;
			}
			if (posY == 1) {
				radius++;
			}
			for (int posX = -radius; posX < radius; posX++) {
				for (int posZ = -radius; posZ < radius; posZ++) {
					if (CircleHelper.isPlotInCircle(posX, posZ, radius) && worldgenlevel.getBlockState(blockpos.below(posY).east(posX).south(posZ)).getBlock() == Blocks.AIR) {
						if (posY == 0) {
							this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), Blocks.GRASS_BLOCK.defaultBlockState());
						}
						else if (posY == 1) {
							this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), Blocks.DIRT.defaultBlockState());
						}
						else if (posY == 2 && randomsource.nextFloat() < 0.5) {
							this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), Blocks.DIRT.defaultBlockState());
						}
						else if (posY == 3 && randomsource.nextFloat() < 0.25) {
							this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), Blocks.DIRT.defaultBlockState());
						}
						else {
							this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), CeilandsBlocks.CEILINGNEOUS.get().defaultBlockState());
						}
					}
					if (hasPond && CircleHelper.isPlotInCircle(posX, posZ, pondWidth) && posY <= pondDepth) {
						this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), Blocks.WATER.defaultBlockState());
						this.setBlock(worldgenlevel, blockpos.below(posY + 1).east(posX).south(posZ), Blocks.SAND.defaultBlockState());
						pondWidth--;
					}
				}
			}
			if (posY % taperingSteps == 0) {
				radius -= taperingAmt;
			}
			if (radius <= 0) {
				break;
			}
		}
		return true;
	}
	

}
