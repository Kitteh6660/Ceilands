package com.kittehmod.ceilands.client.renderer;

import com.kittehmod.ceilands.entity.mob.SpiderMonarch;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpiderMonarchRenderer extends SpiderRenderer<SpiderMonarch> 
{
    private static final ResourceLocation CAVE_SPIDER_LOCATION = ResourceLocation.tryParse("ceilands:textures/entity/spider_monarch/spider_monarch.png");
    private static final float SCALE = 2.0f;

    public SpiderMonarchRenderer(EntityRendererProvider.Context context) {
        super(context, ModelLayers.SPIDER);
        this.shadowRadius *= SCALE;
    }

    @Override
    protected void scale(SpiderMonarch mob, PoseStack poseStack, float f) {
        poseStack.scale(SCALE, SCALE, SCALE);
    }

    @Override
    public ResourceLocation getTextureLocation(SpiderMonarch mob) {
        return CAVE_SPIDER_LOCATION;
    }
}

