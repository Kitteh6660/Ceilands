package com.kittehmod.ceilands.worldgen.features.trunkplacers;

import java.util.List;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.kittehmod.ceilands.registry.CeilandsTrunkPlacerType;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class CeiltrunkTrunkPlacer extends TrunkPlacer
{
	public static final MapCodec<CeiltrunkTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((func) -> { return trunkPlacerParts(func).apply(func, CeiltrunkTrunkPlacer::new); });

	public CeiltrunkTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
		super(p_70268_, p_70269_, p_70270_);
	}

	protected TrunkPlacerType<?> type() {
		return CeilandsTrunkPlacerType.CEILTRUNK_TRUNK_PLACER;
	}
	
	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, RandomSource random, int height, BlockPos pos, TreeConfiguration config) {
		if (reader.isStateAtPosition(pos.above(), (blockstate) -> blockstate.getBlock() != Blocks.GRASS_BLOCK)) {
			setDirtAt(reader, consumer, random, pos.above(), config);
		}
		for(int i = 0; i < height; ++i) {
			this.placeLog(reader, consumer, random, pos.below(i), config);
		}

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.below(height - 2), 1, false));
   }
}
