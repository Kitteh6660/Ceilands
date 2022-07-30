package kittehmod.ceilands.worldgen.features;

import java.util.List;

import com.mojang.serialization.Codec;

import kittehmod.ceilands.util.MathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class NaturalBridgeFeature extends Feature<BlockStateConfiguration>
{
	// Currently disabled.
	public NaturalBridgeFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		List<Direction> startingDirections = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
		BlockState state = context.config().state;
		BlockPos blockpos = context.origin();
		RandomSource randomsource = context.random();
		WorldGenLevel worldgenlevel = context.level();
		BlockPos pointA = null;
		BlockPos pointB = null;
		Block refBlock;
		int diffX;
		int diffY;
		int diffZ;
		// Cancel generation if it doesn't pick an empty block.
		if (worldgenlevel.getBlockState(blockpos).getBlock() != Blocks.AIR) {
			return false;
		}
		// Search for solid land for Point A.
		int dirChooser = randomsource.nextInt(startingDirections.size());
		Direction dir = startingDirections.get(dirChooser);
		for (int fwd = 0; fwd < 12; fwd++) {
			for (int hgt = 6; hgt > -6; hgt--) {
				for (int wdth = -5; wdth <= 5; wdth++) {
					refBlock = worldgenlevel.getBlockState(blockpos.relative(dir, fwd).relative(dir.getClockWise(), wdth).above(hgt)).getBlock();
					if (refBlock != Blocks.AIR && refBlock == state.getBlock()) {
						pointA = blockpos.relative(dir, fwd).relative(dir.getClockWise(), wdth).above(hgt);
						break;
					}
				}
				if (pointA != null) {
					break;
				}
			}
			if (pointA != null) {
				break;
			}
		}
		// Search for solid land for Point B.
		for (int attempt = 0; attempt < 3; attempt++) {
			dir = dir.getClockWise();
			for (int fwd = 0; fwd < 12; fwd++) {
				for (int hgt = 6; hgt > -6; hgt--) {
					refBlock = worldgenlevel.getBlockState(blockpos.relative(dir, fwd).above(hgt)).getBlock();
					if (refBlock != Blocks.AIR && refBlock == state.getBlock()) {
						pointB = blockpos.relative(dir, fwd).above(hgt);
						break;
					}
				}
				if (pointB != null) {
					break;
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
		int radiusSize = 1 + Math.max((int)Math.floor(Math.sqrt(dist)), 2);
		if (radiusSize > 3) {
			radiusSize = 3;
		}
		int archHeight = 2 + randomsource.nextInt(Math.max(8 - diffY, 1));
		for (int i = 0; i < dist; i++) {
			BlockPos posToSet = MathHelper.getInterpolatedBlockPos(pointA, pointB, ((float)i / dist));
			makeSphereAt(worldgenlevel, posToSet.above((int)Math.floor(Math.sin(((float)i / dist) * Math.PI) * archHeight)), state, radiusSize);
		}
		return true;
	}
	
	private void makeSphereAt(WorldGenLevel level, BlockPos pos, BlockState state, int radius) {
		for (int i = -radius; i < radius; i++) {
			for (int j = -radius; j < radius; j++) {
				for (int k = -radius; k < radius; k++) {
					if (MathHelper.isPlotInSphere(i, j, k, radius)) {
						this.setBlock(level, pos.above(i).south(j).east(k), state);
					}
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
