package com.kittehmod.ceilands.client.renderer;

import org.joml.Matrix4f;

import com.kittehmod.ceilands.Ceilands;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;

public class CeilandsSkyEffect
{
	public static final ResourceLocation CEILANDS_EFFECTS = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "the_ceilands");

	private static final ResourceLocation MOON_LOCATION = ResourceLocation.parse("textures/environment/moon_phases.png");
	private static final ResourceLocation SUN_LOCATION = ResourceLocation.parse("textures/environment/sun.png");
	
	public static class CeilandsEffects extends DimensionSpecialEffects
	{
		public CeilandsEffects() {
			super(-5.0F, false, SkyType.NORMAL, false, false);
		}

		// Controls how bright the sky is depending on the time of day.
		@Override
		public Vec3 getBrightnessDependentFogColor(Vec3 vec3, float fl) {
			return vec3.multiply((double) (fl * 0.94F + 0.06F), (double) (fl * 0.94F + 0.06F), (double) (fl * 0.91F + 0.09F));
		}

		@Override
		public boolean isFoggyAt(int int1, int yPos) {
			return false;
		}

		@Override
		public float[] getSunriseColor(float time, float p_108873_) {
			return super.getSunriseColor(time + 0.5F, p_108873_);
		}
		
		public static void renderCeilandsSky(ClientLevel level, Matrix4f cameraMatrix, Matrix4f projectionMatrix, float partialTick, Camera camera, boolean isFoggy, Runnable runnable) {
			runnable.run();
			Minecraft minecraft = Minecraft.getInstance();
			if (!isFoggy) {
	            FogType fogtype = camera.getFluidInCamera();
	            if (fogtype != FogType.POWDER_SNOW && fogtype != FogType.LAVA && !doesMobEffectBlockSky(camera)) {
	                PoseStack posestack = new PoseStack();
	                posestack.mulPose(cameraMatrix);
					Vec3 vec3 = level.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), partialTick);
					float f = (float) vec3.x;
					float f1 = (float) vec3.y;
					float f2 = (float) vec3.z;
					FogRenderer.levelFogColor();
					Tesselator tesselator = Tesselator.getInstance();
					BufferBuilder bufferbuilder = null;
					RenderSystem.depthMask(false);
					RenderSystem.setShaderColor(f, f1, f2, 1.0F);
					ShaderInstance shaderinstance = RenderSystem.getShader();
					
					minecraft.levelRenderer.skyBuffer.bind();
					minecraft.levelRenderer.skyBuffer.drawWithShader(posestack.last().pose(), projectionMatrix, shaderinstance);
					VertexBuffer.unbind();
					RenderSystem.enableBlend();
					//This part controls the sunrise and sunset horizons.
					float[] afloat = level.effects().getSunriseColor(level.getTimeOfDay(partialTick), partialTick);
					if (afloat != null) {
						RenderSystem.setShader(GameRenderer::getPositionColorShader);
						RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
						posestack.pushPose();
						posestack.mulPose(Axis.XP.rotationDegrees(90.0F));
						float f3 = Mth.sin(level.getSunAngle(partialTick)) < 0.0F ? 180.0F : 0.0F;
						posestack.mulPose(Axis.ZP.rotationDegrees(-f3));
						posestack.mulPose(Axis.ZP.rotationDegrees(-90.0F));
						float f4 = afloat[0];
						float f5 = afloat[1];
						float f6 = afloat[2];
						Matrix4f matrix4f = posestack.last().pose();
						bufferbuilder = tesselator.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
						bufferbuilder.addVertex(matrix4f, 0.0F, 100.0F, 0.0F).setColor(f4, f5, f6, afloat[3]);
						int i = 16;

						for (int j = 0; j <= i; ++j) {
							float f7 = (float) j * ((float) Math.PI * 2F) / 16.0F;
							float f8 = Mth.sin(f7);
							float f9 = Mth.cos(f7);
							bufferbuilder.addVertex(matrix4f, f8 * 120.0F, f9 * 120.0F, -f9 * 40.0F * afloat[3]).setColor(afloat[0], afloat[1], afloat[2], 0.0F);
						}

						BufferUploader.drawWithShader(bufferbuilder.buildOrThrow());
						posestack.popPose();
					}
					RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
					posestack.pushPose();
					float f11 = 1.0F - level.getRainLevel(partialTick);
					RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f11);
					posestack.mulPose(Axis.YP.rotationDegrees(-90.0F));
					posestack.mulPose(Axis.XP.rotationDegrees((level.getTimeOfDay(partialTick + 0.5F) * -360.0F) + 180.0F));
					Matrix4f matrix4f1 = posestack.last().pose();
					float f12 = 30.0F;
					RenderSystem.setShader(GameRenderer::getPositionTexShader);
					RenderSystem.setShaderTexture(0, CeilandsSkyEffect.SUN_LOCATION);
					bufferbuilder = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
					bufferbuilder.addVertex(matrix4f1, -f12, 100.0F, -f12).setUv(0.0F, 0.0F);
					bufferbuilder.addVertex(matrix4f1, f12, 100.0F, -f12).setUv(1.0F, 0.0F);
					bufferbuilder.addVertex(matrix4f1, f12, 100.0F, f12).setUv(1.0F, 1.0F);
					bufferbuilder.addVertex(matrix4f1, -f12, 100.0F, f12).setUv(0.0F, 1.0F);
					BufferUploader.drawWithShader(bufferbuilder.buildOrThrow());
					f12 = 20.0F;
					RenderSystem.setShaderTexture(0, CeilandsSkyEffect.MOON_LOCATION);
					int k = level.getMoonPhase();
					int l = k % 4;
					int i1 = k / 4 % 2;
					float f13 = (float) (l + 0) / 4.0F;
					float f14 = (float) (i1 + 0) / 2.0F;
					float f15 = (float) (l + 1) / 4.0F;
					float f16 = (float) (i1 + 1) / 2.0F;
					bufferbuilder = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
					bufferbuilder.addVertex(matrix4f1, -f12, -100.0F, f12).setUv(f15, f16);
					bufferbuilder.addVertex(matrix4f1, f12, -100.0F, f12).setUv(f13, f16);
					bufferbuilder.addVertex(matrix4f1, f12, -100.0F, -f12).setUv(f13, f14);
					bufferbuilder.addVertex(matrix4f1, -f12, -100.0F, -f12).setUv(f15, f14);
					BufferUploader.drawWithShader(bufferbuilder.buildOrThrow());
					float f10 = level.getStarBrightness(partialTick) * f11;
					if (f10 > 0.0F) {
						RenderSystem.setShaderColor(f10, f10, f10, f10);
						FogRenderer.setupNoFog();
						minecraft.levelRenderer.starBuffer.bind();
						minecraft.levelRenderer.starBuffer.drawWithShader(posestack.last().pose(), projectionMatrix, GameRenderer.getPositionShader());
						VertexBuffer.unbind();
						runnable.run();
					}

					RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
					RenderSystem.disableBlend();
					RenderSystem.defaultBlendFunc();
					posestack.popPose();
					RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);
					/*double d0 = minecraft.player.getEyePosition(partialTick).y - level.getLevelData().getHorizonHeight(level);
					if (d0 < 0.0D) {
						posestack.pushPose();
						posestack.translate(0.0D, 12.0D, 0.0D);
						minecraft.levelRenderer.darkBuffer.bind();
						minecraft.levelRenderer.darkBuffer.drawWithShader(posestack.last().pose(), projectionMatrix, shaderinstance);
						VertexBuffer.unbind();
						posestack.popPose();
					}*/

					RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
					/*if (level.effects().hasGround()) {
						RenderSystem.setShaderColor(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F, 1.0F);
					} else {
						RenderSystem.setShaderColor(f, f1, f2, 1.0F);
					}*/

					RenderSystem.depthMask(true);
	            }
			}
		}
		
		public static boolean doesMobEffectBlockSky(Camera camera) {
			Entity entity = camera.getEntity();
			if (!(entity instanceof LivingEntity livingentity)) {
				return false;
			} else {
				return livingentity.hasEffect(MobEffects.BLINDNESS) || livingentity.hasEffect(MobEffects.DARKNESS);
			}
		}
	}
}
