package com.kittehmod.ceilands.mixin;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.kittehmod.ceilands.tags.CeilandsBlockTags;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(ShearsItem.class)
public class ShearsMixin 
{
	@ModifyReturnValue(method = "createToolProperties()Lnet/minecraft/world/item/component/Tool;", at = @At(value = "RETURN"))
	private static Tool modifyToolProperties(Tool tool) {
		List<Tool.Rule> list = new ArrayList(tool.rules());
		list.add(Tool.Rule.overrideSpeed(CeilandsBlockTags.SPIDER_SILK_BLOCKS, 10.0F));
		return new Tool(list, tool.defaultMiningSpeed(), tool.damagePerBlock());
	}
		
	@Inject(method = "mineBlock(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At(value = "RETURN"), cancellable = true)
	private void injectMineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity, CallbackInfoReturnable<Boolean> ci) {
		if (state.is(CeilandsBlockTags.SPIDER_SILK_BLOCKS)) {
			ci.setReturnValue(true);
		}
	}
}
