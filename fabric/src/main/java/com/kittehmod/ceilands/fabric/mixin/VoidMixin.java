package com.kittehmod.ceilands.fabric.mixin;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.kittehmod.ceilands.registry.CeilandsDimension;
import com.kittehmod.ceilands.registry.CeilandsGameRules;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.server.commands.TeleportCommand;

@Mixin(LivingEntity.class)
public class VoidMixin 
{
	@Inject(method = "onBelowWorld()V", at = @At(value = "HEAD"), cancellable = true) 
	private void injectOutOfWorld(CallbackInfo callback) {
		Entity entity = ((Entity)(Object)this);
		if (!entity.level().getGameRules().getBoolean(CeilandsGameRules.CEILANDS_VOID_TELEPORT)) {
			return;
		}
		if ((!entity.level().isClientSide()) && entity.level().dimension() == CeilandsDimension.CEILANDS && entity.canChangeDimensions()) {
			MinecraftServer minecraftserver = ((ServerLevel)entity.level()).getServer();
			ServerLevel destinationLevel = minecraftserver.getLevel(Level.OVERWORLD);
			int x = (int)entity.position().x();
			int z = (int)entity.position().z();
			entity.teleportTo(destinationLevel, entity.getX(), destinationLevel.getMaxBuildHeight(), entity.getZ(), null, entity.getYRot(), entity.getXRot());
			callback.cancel();
		}
	}
}
