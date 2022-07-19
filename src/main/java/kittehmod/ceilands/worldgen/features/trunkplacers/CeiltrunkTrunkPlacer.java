package kittehmod.ceilands.worldgen.features.trunkplacers;

import java.util.List;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class CeiltrunkTrunkPlacer extends TrunkPlacer
{
	public static final Codec<CeiltrunkTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70261_) -> {
		return trunkPlacerParts(p_70261_).apply(p_70261_, CeiltrunkTrunkPlacer::new);
	});

	public CeiltrunkTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
		super(p_70268_, p_70269_, p_70270_);
	}

	protected TrunkPlacerType<?> type() {
		return CeilandsTrunkPlacerType.CEILTRUNK_TRUNK_PLACER.get();
	}
	
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, RandomSource random, int height, BlockPos pos, TreeConfiguration config) {
		setDirtAt(reader, consumer, random, pos.above(), config);

		for(int i = 0; i < height; ++i) {
			this.placeLog(reader, consumer, random, pos.below(i), config);
		}

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.below(height - 2), 1, false));
   }
}
