package kittehmod.ceilands.worldgen.features;

import java.util.List;

import com.mojang.serialization.Codec;

import kittehmod.ceilands.CeilandsMod;
import kittehmod.ceilands.block.CeilandsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class NaturalBridgeFeature extends Feature<BlockStateConfiguration>
{
	
	public NaturalBridgeFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		List<Direction> startingDirections = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
		BlockPos blockpos = context.origin();
		RandomSource randomsource = context.random();
		WorldGenLevel worldgenlevel = context.level();
		BlockPos pointA = null;
		BlockPos pointB = null;
		Block refBlock;
		int archHeight = 2 + randomsource.nextInt(8);
		int diffX;
		int diffY;
		int diffZ;
		// Search for solid land for Point A.
		int dirChooser = randomsource.nextInt(startingDirections.size());
		Direction dir = startingDirections.get(dirChooser);
		for (int fwd = 0; fwd < 16; fwd++) {
			for (int hgt = 16; hgt > -16; hgt--) {
				refBlock = worldgenlevel.getBlockState(blockpos.relative(dir, fwd).above(hgt)).getBlock();
				if (refBlock != Blocks.AIR && !(refBlock instanceof LeavesBlock)) {
					pointA = blockpos.relative(dir, fwd).above(hgt);
				}
			}
		}
		// Search for solid land for Point B.
		/*dirChooser = randomsource.nextInt(startingDirections.size());
		if (randomsource.nextFloat() < 0.5) {
			dir = dir.getOpposite();
		}
		else {
			dir = randomsource.nextFloat() < 0.5 ? dir.getCounterClockWise() : dir.getClockWise();
		}*/
		dir = dir.getOpposite();
		for (int fwd = 0; fwd < 16; fwd++) {
			for (int hgt = 16; hgt > -16; hgt--) {
				refBlock = worldgenlevel.getBlockState(blockpos.relative(dir, fwd).above(hgt)).getBlock();
				if (refBlock != Blocks.AIR && !(refBlock instanceof LeavesBlock)) {
					pointB = blockpos.relative(dir, fwd).above(hgt);
				}
			}
		}
		if (pointA == null || pointB == null) {
			return false; // Cancel if either points are null.
		}
		diffX = Math.abs(pointA.getX() - pointB.getX());
		diffY = Math.abs(pointA.getY() - pointB.getY());
		diffZ = Math.abs(pointA.getZ() - pointB.getZ());
		int dist = calculateBiggestOfThree(diffX, diffY, diffZ);
		CeilandsMod.LOGGER.info("Working on placing blocks.");
		for (int i = 0; i < dist; i++) {
			CeilandsMod.LOGGER.info("Placing...");
			makeSphereAt(worldgenlevel, blockpos.above(pointA.getY() - pointB.getY() > 0 ? calcDistProgress(diffY, i, dist) : -calcDistProgress(diffY, i, dist)).north(calcDistProgress(diffX, i, dist)).east(calcDistProgress(diffZ, i, dist)), CeilandsBlocks.CEILINGNEOUS.get(), 3);
		}
		return true;
	}
	
	private int calcDistProgress(int dist, int currentProgress, int totalProgress) {
		return dist * (currentProgress / totalProgress);
	}
	
	private void makeSphereAt(WorldGenLevel level, BlockPos pos, Block block, int radius) {
		for (int i = -radius; i < radius; i++) {
			for (int j = -radius; j < radius; j++) {
				for (int k = -radius; k < radius; k++) {
					this.setBlock(level, pos.above(i).south(j).east(k), block.defaultBlockState());
				}
			}
		}
	}
	
	//private BlockPos searchForNearbySolidLand() {
	//	
	//}
	
	private int calculateBiggestOfThree(int par1, int par2, int par3) {
		int a = Math.max(Math.abs(par1), Math.abs(par2));
		int b = Math.max(Math.abs(par2), Math.abs(par3));
		return Math.max(a, b);
	}
}
