package com.kittehmod.ceilands.client.renderer;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.client.entity.model.CastleLordModel;
import com.kittehmod.ceilands.entity.mob.CastleLord;

import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;

import net.minecraft.client.renderer.entity.PiglinRenderer;
import net.minecraft.resources.ResourceLocation;

public class CastleLordRenderer extends HumanoidMobRenderer<CastleLord, CastleLordModel<CastleLord>>
{
	public static final ModelLayerLocation CASTLE_LORD_MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(Ceilands.MOD_ID, "castle_lord"), "main");
	public static final ModelLayerLocation CASTLE_LORD_MODEL_OUTER_ARMOR_LAYER = new ModelLayerLocation(new ResourceLocation(Ceilands.MOD_ID, "castle_lord"), "outer_armor");
	public static final ModelLayerLocation CASTLE_LORD_MODEL_INNER_ARMOR_LAYER = new ModelLayerLocation(new ResourceLocation(Ceilands.MOD_ID, "castle_lord"), "inner_armor");
	
	public CastleLordRenderer(Context context) {
		this(context, CASTLE_LORD_MODEL_LAYER, CASTLE_LORD_MODEL_INNER_ARMOR_LAYER, CASTLE_LORD_MODEL_OUTER_ARMOR_LAYER, 1.0F);
	}
	
	public CastleLordRenderer(Context context, ModelLayerLocation layer, ModelLayerLocation armorLayer1, ModelLayerLocation armorLayer2, float scale) {
		super(context, createModel(context.getModelSet(), layer), scale);
		this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel(context.bakeLayer(armorLayer1)), new HumanoidArmorModel(context.bakeLayer(armorLayer2)), context.getModelManager()));
		// this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
    private static CastleLordModel<CastleLord> createModel(EntityModelSet $$0, ModelLayerLocation $$1) {
        CastleLordModel<CastleLord> $$3 = new CastleLordModel<>($$0.bakeLayer($$1));
        return $$3;
    }

	@Override
	public ResourceLocation getTextureLocation(CastleLord mob) {
		return new ResourceLocation(Ceilands.MOD_ID, "textures/entity/castle_lord/castle_lord.png");
	}
	
    private static ModelLayerLocation createLayer(String $$0, String $$1) {
        return new ModelLayerLocation(ResourceLocation.tryParse($$0), $$1);
    }

}
