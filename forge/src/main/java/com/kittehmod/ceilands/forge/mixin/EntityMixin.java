package com.kittehmod.ceilands.forge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.util.CeilandsPortalHelper;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

// All the disgusting workaround just to get the goddamn Ceilands portals working right in 1.19.2.
@Mixin(Entity.class)
public class EntityMixin 
{
	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;getLevel(Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/server/level/ServerLevel;", shift = Shift.BEFORE), method = "handleNetherPortal()V", cancellable = true)
	private void injectHandleNetherPortal(CallbackInfo callback) {
		Entity entity = ((Entity)(Object)this);
		ServerLevel level = (ServerLevel)entity.getLevel();
		if (level.getBlockState(entity.blockPosition()).getBlock() == CeilandsBlocks.CEILANDS_PORTAL) {
			if (entity.portalTime++ >= entity.getPortalWaitTime() - 1 && !entity.isOnPortalCooldown()) {
				entity.portalTime = 0;
				CeilandsPortalHelper.handleCeilandsPortal(level, entity);
			}
			callback.cancel();
		}
	}
}
