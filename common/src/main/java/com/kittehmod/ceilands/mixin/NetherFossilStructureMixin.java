package com.kittehmod.ceilands.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.EmptyBlockGetter;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.structures.NetherFossilPieces;
import net.minecraft.world.level.levelgen.structure.structures.NetherFossilStructure;

@Mixin(NetherFossilStructure.class)
public class NetherFossilStructureMixin 
{
	@Inject(at = @At(value = "RETURN"), method = "findGenerationPoint(Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationContext;)Ljava/util/Optional;", cancellable = true)
	private void injectFindGenerationPoint(Structure.GenerationContext context, CallbackInfoReturnable<Optional<Structure.GenerationStub>> ci) {
		boolean shouldOverride = false;
		WorldgenRandom random = context.random();
        int x = context.chunkPos().getMinBlockX() + random.nextInt(16);
        int z = context.chunkPos().getMinBlockZ() + random.nextInt(16);
        WorldGenerationContext worldGenContext = new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor());
        int y = ((NetherFossilStructure)(Object)this).height.sample(random, worldGenContext);
        NoiseColumn noiseCol = context.chunkGenerator().getBaseColumn(x, z, context.heightAccessor(), context.randomState());
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos(x, context.heightAccessor().getHeight(), z);
        while (y > context.heightAccessor().getMinBuildHeight() + 8) {
            BlockState emptyState = noiseCol.getBlock(y);
            BlockState solidState = noiseCol.getBlock(--y);
            if (solidState.is(Blocks.NETHERRACK)) {
            	break;
            }
            if (emptyState.isAir() && (solidState.is(BlockTags.SAND) || solidState.isFaceSturdy(EmptyBlockGetter.INSTANCE, mutablePos.setY(y), Direction.UP))) {
            	shouldOverride = true;
                break;
            }
        }
        if (shouldOverride) {
            BlockPos pos = new BlockPos(x, y, z);
        	ci.setReturnValue(Optional.of(new Structure.GenerationStub(pos, $$3x -> NetherFossilPieces.addPieces(context.structureTemplateManager(), $$3x, random, pos))));
        }
	}
}
