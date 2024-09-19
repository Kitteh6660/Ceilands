package com.kittehmod.ceilands.fabric.mixin;

import java.util.function.BooleanSupplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.kittehmod.ceilands.registry.CeilandsDimension;

import net.minecraft.server.level.ServerLevel;

@Mixin(ServerLevel.class)
public class ServerLevelMixin
{
	@Inject(method = "tick(Ljava/util/function/BooleanSupplier;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;setDayTime(J)V", shift = At.Shift.BEFORE))
	private void injectTick(BooleanSupplier supplier, CallbackInfo ci) {
		if (((ServerLevel)(Object)this).dimension().equals(CeilandsDimension.CEILANDS)) {
			long dayTimeCeilands = ((ServerLevel)(Object)this).getLevelData().getDayTime() + 24000L;
			((ServerLevel)(Object)this).getServer().overworld().setDayTime(dayTimeCeilands - dayTimeCeilands % 24000L);
		}
	}
}
