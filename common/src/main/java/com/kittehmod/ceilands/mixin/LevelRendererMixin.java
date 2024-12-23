package com.kittehmod.ceilands.mixin;

import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.kittehmod.ceilands.client.CeilandsSkyEffect;
import com.kittehmod.ceilands.registry.CeilandsDimension;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin 
{
	@Inject(method = "Lnet/minecraft/client/renderer/LevelRenderer;renderSky(Lcom/mojang/blaze3d/vertex/PoseStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/DimensionSpecialEffects;skyType()Lnet/minecraft/client/renderer/DimensionSpecialEffects$SkyType;", shift = Shift.BEFORE), cancellable = true)
	private void injectRenderSky(PoseStack poseStack, Matrix4f matrix4f, float f, Camera camera, boolean bl, Runnable runnable, CallbackInfo ci) {
		ClientLevel level = ((LevelRenderer)(Object)this).minecraft.level;
        if (level.dimension() == CeilandsDimension.CEILANDS) {
            CeilandsSkyEffect.CeilandsEffects.renderCeilandsSky(level, f, poseStack, camera, matrix4f, bl, runnable);
            if (ci.isCancellable()) {
            	ci.cancel();
            }
        }
	}
}
