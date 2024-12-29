package com.kittehmod.ceilands.util;

import net.minecraft.world.effect.MobEffectInstance;

public class MobEffectHelper 
{
    public static MobEffectInstance copyEffect(MobEffectInstance effect) {
    	return new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier());
    }
}
