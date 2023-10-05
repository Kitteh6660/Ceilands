package kittehmod.ceilands.worldgen.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class ChainProcessor extends StructureProcessor
{
	public static final Codec<ChainProcessor> CODEC = RecordCodecBuilder.create((instance) -> instance.group(Codec.INT.fieldOf("max_height").forGetter(config -> config.maxHeight)).apply(instance, instance.stable(ChainProcessor::new)));

	private final int maxHeight;
	
	private ChainProcessor(int maxHeight) { this.maxHeight = maxHeight; }
	
	@Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader worldView, BlockPos pos, BlockPos blockPos, StructureTemplate.StructureBlockInfo structureBlockInfoLocal, StructureTemplate.StructureBlockInfo structureBlockInfoWorld, StructurePlaceSettings structurePlacementData) {
        BlockState blockState = structureBlockInfoWorld.state();
        BlockPos worldPos = structureBlockInfoWorld.pos();
        RandomSource random = new WorldgenRandom(new LegacyRandomSource(0));
        random.setSeed(worldPos.asLong() * worldPos.getY());
        CompoundTag nbt = structureBlockInfoWorld.nbt();
        
		return new StructureTemplate.StructureBlockInfo(worldPos, blockState, nbt);
	}
	
	@Override
	protected StructureProcessorType<?> getType() {
		return CeilandsProcessors.HANGING_CHAINS.get();
	}
}
