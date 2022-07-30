package kittehmod.ceilands.worldgen.features;

import com.mojang.serialization.Codec;

import kittehmod.ceilands.util.MathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class CeilingPatchFeature extends Feature<BlockStateConfiguration>
{
	public CeilingPatchFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		BlockPos blockpos = context.origin();
		RandomSource randomsource = context.random();
		WorldGenLevel worldgenlevel = context.level();
		// Push the moss towards the ceiling.
		for (int i = 1; i < 48; i++) {
			if (worldgenlevel.getBlockState(blockpos.above(i)).getBlock() != Blocks.AIR) {
				blockpos = blockpos.above(i);
				break;
			}
		}
		BlockState state = context.config().state;
		int radius = 5 + randomsource.nextInt(11);
		for (int posY = 0; posY < 3; posY++) {
			for (int posX = -radius; posX < radius; posX++) {
				for (int posZ = -radius; posZ < radius; posZ++) {
					if (MathHelper.isPlotInCircle(posX, posZ, radius) && worldgenlevel.getBlockState(blockpos.below(posY).east(posX).south(posZ)).is(BlockTags.MOSS_REPLACEABLE) && worldgenlevel.getBlockState(blockpos.below(posY+1).east(posX).south(posZ)).getBlock() == Blocks.AIR) {
						this.setBlock(worldgenlevel, blockpos.below(posY).east(posX).south(posZ), state);
					}
				}
			}
		}
		return true;
	}
}
