package com.kittehmod.ceilands.worldgen.features.trunkplacers;

import java.util.List;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.kittehmod.ceilands.registry.CeilandsTrunkPlacerType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class LargeCeiltrunkTrunkPlacer extends TrunkPlacer
{
	public static final Codec<LargeCeiltrunkTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70261_) -> { return trunkPlacerParts(p_70261_).apply(p_70261_, LargeCeiltrunkTrunkPlacer::new); });
	public static final Direction[] STARTING_BRANCH_DIRECTION = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
	
	public LargeCeiltrunkTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
		super(p_70268_, p_70269_, p_70270_);
	}

	protected TrunkPlacerType<?> type() {
		return CeilandsTrunkPlacerType.LARGE_CEILTRUNK_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, RandomSource random, int height, BlockPos pos, TreeConfiguration config) {
		BlockPos blockpos = pos.above();
		if (reader.isStateAtPosition(blockpos, (blockstate) -> blockstate.getBlock() != Blocks.GRASS_BLOCK)) {
			setDirtAt(reader, consumer, random, blockpos, config);
			setDirtAt(reader, consumer, random, blockpos.east(), config);
			setDirtAt(reader, consumer, random, blockpos.south(), config);
			setDirtAt(reader, consumer, random, blockpos.south().east(), config);
		}
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
		boolean spiralRotation = random.nextFloat() < 0.5; // Determine if it should rotate counter-clockwise or clockwise. If true, clockwise.
		int branchLength = 3 + random.nextInt(4);
		boolean branchOrientation = false;
		Direction dir = STARTING_BRANCH_DIRECTION[random.nextInt(4)];
		for (int i = 0; i < height; ++i) {
			this.placeLogIfFreeWithOffset(reader, consumer, random, blockpos$mutableblockpos, config, pos, 0, -i, 0);
			if (i < height - 1) {
				this.placeLogIfFreeWithOffset(reader, consumer, random, blockpos$mutableblockpos, config, pos, 1, -i, 0);
				this.placeLogIfFreeWithOffset(reader, consumer, random, blockpos$mutableblockpos, config, pos, 1, -i, 1);
				this.placeLogIfFreeWithOffset(reader, consumer, random, blockpos$mutableblockpos, config, pos, 0, -i, 1);
			}
			if (i < height - 4) {
				branchOrientation = random.nextFloat() < 0.5;
				generateBranches(reader, consumer, random, blockpos$mutableblockpos, config, pos.below(i), dir, branchLength - 1, branchOrientation ? 0 : 1, dir == Direction.SOUTH || dir == Direction.EAST ? 1 : 0);
				if (spiralRotation) {
					dir = dir.getClockWise();
				}
				else {
					dir = dir.getCounterClockWise();
				}
			}
			// Add the branches at the bottom of Ceiltrunk.
			if (i == height - 2) {
				branchOrientation = false;
				// Branches running along X axis.
				branchOrientation = random.nextFloat() < 0.5;
				generateBranches(reader, consumer, random, blockpos$mutableblockpos, config, pos.below(i), Direction.NORTH, branchLength, branchOrientation ? 0 : 1, 0);
				branchOrientation = random.nextFloat() < 0.5;
				generateBranches(reader, consumer, random, blockpos$mutableblockpos, config, pos.below(i), Direction.SOUTH, branchLength, branchOrientation ? 0 : 1, 1);

				// Branches running along Z axis.
				branchOrientation = random.nextFloat() < 0.5;
				generateBranches(reader, consumer, random, blockpos$mutableblockpos, config, pos.below(i), Direction.WEST, branchLength, branchOrientation ? 0 : 1, 0);
				branchOrientation = random.nextFloat() < 0.5;
				generateBranches(reader, consumer, random, blockpos$mutableblockpos, config, pos.below(i), Direction.EAST, branchLength, branchOrientation ? 0 : 1, 1);
			}
		}

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.below(height), -1, true));
	}

	private void placeLogIfFreeWithOffset(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, RandomSource random, BlockPos.MutableBlockPos pos$mutable, TreeConfiguration config, BlockPos pos, int x, int y, int z) {
		pos$mutable.setWithOffset(pos, x, y, z);
		this.placeLogIfFree(reader, consumer, random, pos$mutable, config);
	}

	private void generateBranches(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, RandomSource random, BlockPos.MutableBlockPos pos$mutable, TreeConfiguration config, BlockPos pos, Direction direction, int branchLength, int offset1, int offset2) {
		for (int bl = 1; bl <= branchLength; ++bl) {
			pos$mutable.set(pos); //Resets position.
			BlockPos finalizedPos = pos$mutable.relative(direction, bl + offset2).relative(Direction.UP, bl >= Math.abs(branchLength) ? 1 : 0).relative(direction == Direction.NORTH || direction == Direction.SOUTH ? Direction.EAST : Direction.SOUTH, offset1).immutable();
			if (this.isFree(reader, finalizedPos)) {
				this.placeLog(reader, consumer, random, finalizedPos, config, (blockstate) -> { return blockstate.setValue(RotatedPillarBlock.AXIS, this.getLogAxis(pos$mutable, finalizedPos)); });
			}
		}
	}

	private Direction.Axis getLogAxis(BlockPos p_70130_, BlockPos p_70131_) {
		Direction.Axis direction$axis = Direction.Axis.Y;
		int i = Math.abs(p_70131_.getX() - p_70130_.getX());
		int j = Math.abs(p_70131_.getZ() - p_70130_.getZ());
		int k = Math.max(i, j);
		if (k > 0) {
			if (i == k) {
				direction$axis = Direction.Axis.X;
			} else {
				direction$axis = Direction.Axis.Z;
			}
		}

		return direction$axis;
	}

}
