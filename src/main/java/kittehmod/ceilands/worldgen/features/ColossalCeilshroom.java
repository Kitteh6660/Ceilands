package kittehmod.ceilands.worldgen.features;

import com.mojang.serialization.Codec;

import kittehmod.ceilands.util.CircleHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class ColossalCeilshroom extends Feature<BlockStateConfiguration>
{
	public ColossalCeilshroom(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		BlockPos blockpos = context.origin();
		RandomSource randomsource = context.random();
		WorldGenLevel worldgenlevel = context.level();
		// Push the huge mushroom towards the ceiling.
		for (int i = 1; i < 96; i++) {
			if (worldgenlevel.getBlockState(blockpos.above(i)).getBlock() != Blocks.AIR) {
				blockpos = blockpos.above(i);
				break;
			}
		}
		boolean genShroomlights = randomsource.nextFloat() < 0.1;
		boolean genLush = randomsource.nextFloat() < 0.25;
		int stemRadius = 2 + randomsource.nextInt(5);
		int stemHeight = stemRadius * (3 + randomsource.nextInt(7));
		int stemTaperThreshold = 3 + randomsource.nextInt(2);
		int stemTaperThreshold2 = randomsource.nextFloat() < 0.5 ? (stemTaperThreshold * 2) + randomsource.nextInt(4) : -1;
		// Create the stem.
		for (int stemY = 0; stemY < stemHeight; stemY++) {
			for (int stemX = -stemRadius; stemX < stemRadius; stemX++) {
				for (int stemZ = -stemRadius; stemZ < stemRadius; stemZ++) {
					if ((stemX > -stemRadius && stemX < stemRadius - 1) || (stemZ > -stemRadius && stemZ < stemRadius - 1)) {
						if (worldgenlevel.getBlockState(blockpos.below(stemY).east(stemX).south(stemZ)).getBlock() == Blocks.AIR) {
							this.setBlock(worldgenlevel, blockpos.below(stemY).east(stemX).south(stemZ), Blocks.MUSHROOM_STEM.defaultBlockState());							
						}
					}
				}
			}
			if (stemY == stemTaperThreshold) {
				stemRadius--;
			}
			if (stemTaperThreshold2 > 0 && stemY == stemTaperThreshold2) { // Narrow the stem again.
				stemRadius--;
			}
			if (stemRadius < 2) stemRadius = 2;
		}
		blockpos = blockpos.below(stemHeight);
		// Create the cap. The cap will have moss to allow flora to grow.
		Block capBlock = randomsource.nextFloat() < 0.5 ? Blocks.RED_MUSHROOM_BLOCK : Blocks.BROWN_MUSHROOM_BLOCK;
		Block lushBlock = randomsource.nextFloat() < 0.3 ? Blocks.MOSS_BLOCK : Blocks.GRASS_BLOCK;
		int capRadius = 5 + (stemRadius * 4) + randomsource.nextInt(5);
		int capThickness = 3 + (int)Math.floor(capRadius / 5 + randomsource.nextInt(8));
		if (capRadius > 16) {
			capRadius = 16;
		}
		for (int capY = 0; capY < capThickness; capY++) {
			for (int capX = -capRadius; capX < capRadius; capX++) {
				for (int capZ = -capRadius; capZ < capRadius; capZ++) { 
					if (CircleHelper.isPlotInCircle(capX, capZ, capRadius)) {
						if (worldgenlevel.getBlockState(blockpos.below(capY).east(capX).south(capZ)) == Blocks.AIR.defaultBlockState()) {
							this.setBlock(worldgenlevel, blockpos.below(capY).east(capX).south(capZ), capBlock.defaultBlockState());
							if (genLush && capY == 0 && capX > -capRadius + 2 && capX < capRadius - 2 && capZ > -capRadius + 2 && capZ < capRadius - 2 && CircleHelper.isPlotInCircle(capX, capZ, capRadius - 2) && !(worldgenlevel.getBlockState(blockpos.below(capY).east(capX).south(capZ)).getBlock() == Blocks.MUSHROOM_STEM)) {
								this.setBlock(worldgenlevel, blockpos.below(capY).east(capX).south(capZ), lushBlock.defaultBlockState());
							}
							if (genShroomlights && randomsource.nextFloat() < 0.02) {
								this.setBlock(worldgenlevel, blockpos.below(capY).east(capX).south(capZ), Blocks.SHROOMLIGHT.defaultBlockState());
							}
						}
					}
				}
			}
			if (capY >= 1) {
				if (capBlock == Blocks.RED_MUSHROOM_BLOCK) {
					capRadius -= Math.min(capY + 1, 5);
				}
				else {
					capRadius -= Math.max(capRadius * 0.15, 1);
				}
				
			}
		}
		return true;
	}
	

}
