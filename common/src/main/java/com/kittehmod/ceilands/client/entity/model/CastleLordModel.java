package com.kittehmod.ceilands.client.entity.model;

import com.kittehmod.ceilands.entity.mob.CastleLord;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.HumanoidArm;

public class CastleLordModel<T extends CastleLord> extends PlayerModel<T>
{
	public static final LayerDefinition CASTLE_LORD_LAYER = LayerDefinition.create(PlayerModel.createMesh(CubeDeformation.NONE, false), 64, 64);
	public static final LayerDefinition CASTLE_LORD_OUTER_LAYER = LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(1.0F), 0), 64, 32);
	public static final LayerDefinition CASTLE_LORD_INNER_LAYER = LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.5F), 0), 64, 32);

	public CastleLordModel(ModelPart modelPart) {
		super(modelPart, false);
	}
	
	public static MeshDefinition createMesh(CubeDeformation cubedeform, boolean b) {
		MeshDefinition $$0 = PlayerModel.createMesh(cubedeform, false);
        PartDefinition $$1 = $$0.getRoot();
        PartDefinition $$2 = $$1.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        $$2.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
        $$2.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        return $$0;
	}

    public ModelPart getHat() {
        return this.hat;
    }
	
	@Override
	public ModelPart getHead() {
		return this.head;
	}
	
	@Override
	public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
		this.getArm(arm).translateAndRotate(poseStack);
	}

	@Override
	public void setupAnim(T var1, float var2, float var3, float var4, float var5, float var6) {
		super.setupAnim(var1, var2, var3, var4, var5, var6);
	}
	
	@Override
    protected void setupAttackAnimation(T $$0, float $$1) {
    	super.setupAttackAnimation($$0, $$1);
    }

    private void holdWeaponHigh(T $$0) {
        if ($$0.isLeftHanded()) {
            this.leftArm.xRot = -1.8F;
        } else {
            this.rightArm.xRot = -1.8F;
        }
    }
	
	public static LayerDefinition getBaseLayerDefinition() {
		return CASTLE_LORD_LAYER;
	}
	public static LayerDefinition getOuterLayerDefinition() {
		return CASTLE_LORD_OUTER_LAYER;
	}
	public static LayerDefinition getInnerLayerDefinition() {
		return CASTLE_LORD_INNER_LAYER;
	}
}
