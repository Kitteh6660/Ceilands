package com.kittehmod.ceilands.mixin;

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

import com.kittehmod.ceilands.worldgen.dimension.CeilandsDimension;
import com.kittehmod.ceilands.worldgen.dimension.CeilandsTeleporter;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public class VoidMixin 
{
	@Inject(method = "checkBelowWorld()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;onBelowWorld()V", shift = Shift.BEFORE), cancellable = true) 
	private void injectCheckBelowWorld(CallbackInfo callback) {
		Entity entity = ((Entity)(Object)this);
		if ((!entity.level().isClientSide()) && entity.level().dimension() == CeilandsDimension.CEILANDS && entity.canChangeDimensions()) {
			MinecraftServer minecraftserver = ((ServerLevel)entity.level()).getServer();
			ServerLevel destinationLevel = minecraftserver.getLevel(Level.OVERWORLD);
			int x = (int)entity.position().x();
			int z = (int)entity.position().z();
			entity.setPos(x, destinationLevel.getMaxBuildHeight() + 1, z);
			entity.portalEntrancePos = new BlockPos(x, destinationLevel.getMaxBuildHeight(), z);
			entity.setPortalCooldown();
			entity.changeDimension(destinationLevel, new CeilandsTeleporter(destinationLevel));
		}
	}
}
