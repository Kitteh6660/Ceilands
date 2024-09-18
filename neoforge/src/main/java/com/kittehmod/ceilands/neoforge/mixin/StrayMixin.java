package com.kittehmod.ceilands.neoforge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.kittehmod.ceilands.registry.CeilandsBiomes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.level.ServerLevelAccessor;

@Mixin(Stray.class)
public class StrayMixin 
{
	@Inject(method = "checkStraySpawnRules(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/util/RandomSource;)Z", at = @At(value = "RETURN"), cancellable = true)
	private static void injectSpawnRules(EntityType<Stray> entity, ServerLevelAccessor accessor, MobSpawnType spawntype, BlockPos pos, RandomSource random, CallbackInfoReturnable<Boolean> callback) {
		if (accessor.getBiome(pos).is(CeilandsBiomes.SNOW_ROOF)) {
			callback.setReturnValue(Monster.checkMonsterSpawnRules(entity, accessor, spawntype, pos, random) || spawntype == MobSpawnType.SPAWNER);
		}
	}
}
