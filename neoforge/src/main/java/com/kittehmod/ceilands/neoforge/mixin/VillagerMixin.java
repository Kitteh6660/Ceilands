package com.kittehmod.ceilands.neoforge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;

import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.behavior.MeleeAttack;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.schedule.Activity;

// Currently doesn't do anything, Mixin file currently disabled.
@Mixin(Villager.class)
public class VillagerMixin 
{
    public static ImmutableList<Pair<Integer, ? extends BehaviorControl<? super Villager>>> getFightPackage(float f1) {
	      return ImmutableList.of(Pair.of(0, MeleeAttack.create(20)));
	}
	
	@Inject(method = "registerBrainGoals(Lnet/minecraft/world/entity/ai/Brain;)V", at = @At(value = "TAIL"))
	private void injectBrainGoals(Brain<Villager> brain, CallbackInfo callback) {
		brain.addActivityWithConditions(Activity.FIGHT, getFightPackage(0.5F), ImmutableSet.of(Pair.of(MemoryModuleType.HURT_BY_ENTITY, MemoryStatus.VALUE_PRESENT)));
	}
}
