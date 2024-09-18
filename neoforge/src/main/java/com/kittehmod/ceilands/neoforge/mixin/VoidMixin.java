package com.kittehmod.ceilands.neoforge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.kittehmod.ceilands.registry.CeilandsDimension;
import com.kittehmod.ceilands.registry.CeilandsGameRules;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

@Mixin(LivingEntity.class)
public class VoidMixin 
{
	@Inject(method = "onBelowWorld()V", at = @At(value = "HEAD"), cancellable = true) 
	private void injectOutOfWorld(CallbackInfo callback) {
		Entity entity = ((Entity)(Object)this);
		if (!entity.level().getGameRules().getBoolean(CeilandsGameRules.CEILANDS_VOID_TELEPORT)) {
			return;
		}
		MinecraftServer minecraftserver = ((ServerLevel)entity.level()).getServer();
		ServerLevel destinationLevel = minecraftserver.getLevel(Level.OVERWORLD);
		if ((!entity.level().isClientSide()) && entity.level().dimension() == CeilandsDimension.CEILANDS && entity.canChangeDimensions(entity.level(), destinationLevel)) {
			int x = (int)entity.position().x();
			int z = (int)entity.position().z();
			entity.teleportTo(destinationLevel, entity.getX(), destinationLevel.getMaxBuildHeight(), entity.getZ(), null, entity.getYRot(), entity.getXRot());
			callback.cancel();
		}
	}
}
