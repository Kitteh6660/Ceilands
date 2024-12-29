package com.kittehmod.ceilands.worldgen.features;

import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class ColossalCeiltrunkTree extends Feature<BlockStateConfiguration>
{
	public ColossalCeiltrunkTree(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		BlockPos blockpos = context.origin();
		RandomSource randomsource = context.random();
		WorldGenLevel worldgenlevel = context.level();
		boolean foundSpace = false;
		boolean isOKToPutLog = false;
		// Push the huge Ceiltrunk tree down to find space.
		for (int i = 1; i < 6; i++) {
			if (worldgenlevel.getBlockState(blockpos.below(i)).getBlock() != Blocks.AIR && !worldgenlevel.getBlockState(blockpos.below(i)).is(BlockTags.CAVE_VINES)) {
				blockpos = blockpos.below(i);
				foundSpace = true;
				break;
			}
		}
		// Push the huge Ceiltrunk tree towards the ceiling if it would have generated in midair.
		for (int i = 1; i < 6; i++) {
			if (foundSpace) {
				break;
			}
			if (worldgenlevel.getBlockState(blockpos.above(i)).getBlock() != Blocks.AIR && !worldgenlevel.getBlockState(blockpos.above(i)).is(BlockTags.CAVE_VINES)) {
				blockpos = blockpos.above(i);
				foundSpace = true;
				break;
			}
		}
		if (!foundSpace) {
			return false; // Cancel generation if the tree cannot be generated.
		}
		int trunkRadius = 2 + randomsource.nextInt(3);
		int trunkHeight = 4 + trunkRadius * (3 + randomsource.nextInt(7));
		int branchLength = 2 + trunkRadius + randomsource.nextInt(3);
		// Create moss block if it's air.
		for (int trunkX = -trunkRadius; trunkX < trunkRadius; trunkX++) {
			for (int trunkZ = -trunkRadius; trunkZ < trunkRadius; trunkZ++) {
				if ((trunkX > -trunkRadius && trunkX < trunkRadius - 1) || (trunkZ > -trunkRadius && trunkZ < trunkRadius - 1)) {
					if (worldgenlevel.getBlockState(blockpos.above(1).east(trunkX).south(trunkZ)).getBlock() == Blocks.AIR || worldgenlevel.getBlockState(blockpos.below(0).east(trunkX).south(trunkZ)).is(BlockTags.CAVE_VINES) || worldgenlevel.getBlockState(blockpos.below(0).east(trunkX).south(trunkZ)).is(CeilandsBlocks.CEILTRUNK_LEAVES)) {
						this.setBlock(worldgenlevel, blockpos.above(1).east(trunkX).south(trunkZ), Blocks.MOSS_BLOCK.defaultBlockState());							
					}
				}
			}
		}
		// Create the trunk.
		for (int trunkY = 0; trunkY < trunkHeight; trunkY++) {
			for (int trunkX = -trunkRadius; trunkX < trunkRadius; trunkX++) {
				for (int trunkZ = -trunkRadius; trunkZ < trunkRadius; trunkZ++) {
					isOKToPutLog = false;
					// Round out the corners.
					if ((trunkX == -trunkRadius + 1 || trunkX == trunkRadius - 2) && (trunkZ == -trunkRadius + 1 || trunkZ == trunkRadius - 2)) {
						isOKToPutLog = true;
					}
					else {
						isOKToPutLog = trunkRadius <= 3;
					}
					if ((trunkX > -trunkRadius + 1 && trunkX < trunkRadius - 2) || (trunkZ > -trunkRadius + 1 && trunkZ < trunkRadius - 2)) {
						isOKToPutLog = true;
					}
					if (!isOKToPutLog) {
						continue;
					}
					// Put the trunk.
					if (worldgenlevel.getBlockState(blockpos.below(trunkY).east(trunkX).south(trunkZ)).getBlock() == Blocks.AIR || worldgenlevel.getBlockState(blockpos.below(trunkY).east(trunkX).south(trunkZ)).is(BlockTags.CAVE_VINES) || worldgenlevel.getBlockState(blockpos.below(trunkY).east(trunkX).south(trunkZ)).is(CeilandsBlocks.CEILTRUNK_LEAVES)) {
						this.setBlock(worldgenlevel, blockpos.below(trunkY).east(trunkX).south(trunkZ), CeilandsBlocks.CEILTRUNK_LOG.defaultBlockState());							
					}
				}
			}
		}
		Direction dir = Direction.NORTH;
		boolean clockwise = randomsource.nextFloat() >= 0.5;
		for (int i = 2; i < trunkHeight - 2; i++) {
			generateBranches(worldgenlevel, randomsource, blockpos.below(i), dir, branchLength, dir.getAxis() == Axis.X ? (dir == Direction.EAST ? trunkRadius - 1 : -trunkRadius) : 0, dir.getAxis() == Axis.Z ? (dir == Direction.SOUTH ? trunkRadius - 1 : -trunkRadius) : 0, 1);
			dir = clockwise ? dir.getClockWise() : dir.getCounterClockWise();
		}
		// Create the branches at the bottom.
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.NORTH, branchLength, -2, -trunkRadius + 1, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.NORTH, branchLength, -1, -trunkRadius + 1, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.NORTH, branchLength, 1, -trunkRadius + 1 , 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.NORTH, branchLength, 2, -trunkRadius + 1, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.EAST, branchLength, trunkRadius - 2, -2, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.EAST, branchLength, trunkRadius - 2, -1, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.EAST, branchLength, trunkRadius - 2, 1, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.EAST, branchLength, trunkRadius - 2, 2, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.SOUTH, branchLength, -2, trunkRadius - 2, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.SOUTH, branchLength, -1, trunkRadius - 2, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.SOUTH, branchLength, 1, trunkRadius - 2, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.SOUTH, branchLength, 2, trunkRadius - 2, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.WEST, branchLength, -trunkRadius + 1, -2, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.WEST, branchLength, -trunkRadius + 1, -1, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.WEST, branchLength, -trunkRadius + 1, 1, 2);
		generateBranches(worldgenlevel, randomsource, blockpos.below(trunkHeight), Direction.WEST, branchLength, -trunkRadius + 1, 2, 2);
		return true;
	}

	private void generateBranches(WorldGenLevel level, RandomSource random, BlockPos pos, Direction direction, int branchLength, int offsetX, int offsetZ, int foliageRadius) {
		for (int bl = 1; bl <= branchLength; ++bl) {
			this.setBlock(level, pos.relative(direction, bl).east(offsetX).south(offsetZ), CeilandsBlocks.CEILTRUNK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, direction.getAxis()));
			if (bl == branchLength - 1) {
				this.setBlock(level, pos.relative(direction, bl).east(offsetX).south(offsetZ).above(1), CeilandsBlocks.CEILTRUNK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Axis.Y));
			}
			this.setSurroundingBlocks(level, pos.relative(direction, bl).east(offsetX).south(offsetZ), CeilandsBlocks.CEILTRUNK_LEAVES.defaultBlockState(), foliageRadius);
		}
	}
	
	private void setSurroundingBlocks(WorldGenLevel level, BlockPos pos, BlockState state, int radius) {
		for (Direction dir : Direction.values()) {
			for (int i = 0; i <= radius; ++i) {
				if (level.getBlockState(pos.relative(dir, i)).getBlock() == Blocks.AIR && state.getBlock() instanceof LeavesBlock) {
					this.setBlock(level, pos.relative(dir, i), state.setValue(LeavesBlock.DISTANCE, i + 1));
				}
			}
		}
	}
	
}
