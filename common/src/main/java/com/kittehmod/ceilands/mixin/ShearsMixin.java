package com.kittehmod.ceilands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.kittehmod.ceilands.registry.CeilandsBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(ShearsItem.class)
public class ShearsMixin 
{
	@Inject(method = "mineBlock(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At(value = "RETURN"), cancellable = true)
	private void injectMineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity, CallbackInfoReturnable<Boolean> ci) {
		if (state.is(CeilandsBlocks.SPIDER_SILK_BLOCK) || state.is(CeilandsBlocks.SPIDER_SILK_CARPET)) {
			ci.setReturnValue(true);
		}
	}
	
	@Inject(method = "getDestroySpeed(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/block/state/BlockState;)F", at = @At(value = "HEAD"), cancellable = true)
	private void injectDestroySpeed(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> ci) {
		if (state.is(CeilandsBlocks.SPIDER_SILK_BLOCK) || state.is(CeilandsBlocks.SPIDER_SILK_CARPET)) {
			ci.setReturnValue(10.0F);
		}
	}
}
