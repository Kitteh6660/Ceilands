package com.kittehmod.ceilands.forge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.kittehmod.ceilands.tags.CeilandsBiomeTags;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.LevelAccessor;

@Mixin(Animal.class)
public class AnimalMixin 
{
	@Inject(method = "checkAnimalSpawnRules(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/util/RandomSource;)Z", at = @At(value = "HEAD"), cancellable = true)
	private static void injectSpawnRules(EntityType<? extends Animal> entityType, LevelAccessor accessor, MobSpawnType spawnType, BlockPos pos, RandomSource randomSource, CallbackInfoReturnable<Boolean> cir) {
		if (accessor.getBiome(pos).is(CeilandsBiomeTags.IS_CEILANDS) && cir.isCancellable()) {
			cir.setReturnValue(accessor.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON));
		}
	}
}
