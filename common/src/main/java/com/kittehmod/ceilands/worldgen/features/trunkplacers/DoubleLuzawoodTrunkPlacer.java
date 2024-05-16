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
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class DoubleLuzawoodTrunkPlacer extends TrunkPlacer
{
	public static final Codec<DoubleLuzawoodTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70261_) -> {
		return trunkPlacerParts(p_70261_).apply(p_70261_, DoubleLuzawoodTrunkPlacer::new);
	});
	
	public DoubleLuzawoodTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
		super(p_70268_, p_70269_, p_70270_);
	}

	protected TrunkPlacerType<?> type() {
		return CeilandsTrunkPlacerType.DOUBLE_LUZAWOOD_TRUNK_PLACER;
	}

	@Override
	public List<FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, RandomSource random, int height, BlockPos pos, TreeConfiguration config) {
		setDirtAt(reader, consumer, random, pos.below(), config);
		int i = 0;
		for(i = 0; i < height; ++i) {
			this.placeLog(reader, consumer, random, pos.above(i), config);
		}
		int branchOutwardLength = 2 + random.nextInt(4);
		int branchOutwardHeight = 3 + random.nextInt(3);
		this.placeLog(reader, consumer, random, pos.above(height), config, (state) -> { return state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z); });
		// Make the four forking branches.
		for (i = 1; i <= branchOutwardLength; i++) {
			this.placeLog(reader, consumer, random, pos.above(height).north(i), config, (state) -> { return state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z); });
			this.placeLog(reader, consumer, random, pos.above(height).south(i), config, (state) -> { return state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z); });
			this.placeLog(reader, consumer, random, pos.above(height).east(i), config, (state) -> { return state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.X); } );
			this.placeLog(reader, consumer, random, pos.above(height).west(i), config, (state) -> { return state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.X); });
		}
		// Make the branches curve upwards.
		for(i = 1; i <= branchOutwardHeight; i++) {
			this.placeLog(reader, consumer, random, pos.above(height + i).north(branchOutwardLength), config);
			this.placeLog(reader, consumer, random, pos.above(height + i).south(branchOutwardLength), config);
			this.placeLog(reader, consumer, random, pos.above(height + i).east(branchOutwardLength), config);
			this.placeLog(reader, consumer, random, pos.above(height + i).west(branchOutwardLength), config);
		}
		
		// Return foliage attachments.
		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(height + branchOutwardHeight + 1).north(branchOutwardLength), 2, false), new FoliagePlacer.FoliageAttachment(pos.above(height + branchOutwardHeight + 1).south(branchOutwardLength), 2, false), new FoliagePlacer.FoliageAttachment(pos.above(height + branchOutwardHeight + 1).west(branchOutwardLength), 2, false), new FoliagePlacer.FoliageAttachment(pos.above(height + branchOutwardHeight + 1).east(branchOutwardLength), 2, false));
		
	}

}
