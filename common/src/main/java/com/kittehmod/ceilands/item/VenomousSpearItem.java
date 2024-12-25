package com.kittehmod.ceilands.item;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import com.kittehmod.ceilands.util.MobEffectHelper;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;

public class VenomousSpearItem extends Item implements Vanishable
{
	private static final MobEffectInstance SPEAR_VENOM = new MobEffectInstance(MobEffects.POISON, 160, 0);
	
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	
	public VenomousSpearItem(Properties properties) {
		super(properties);
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	    builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 5.0D, AttributeModifier.Operation.ADDITION));
	    builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)-2.8F, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!target.hasEffect(MobEffects.POISON)) {
			target.addEffect(MobEffectHelper.copyEffect(SPEAR_VENOM));
		}
		else if (target.getEffect(MobEffects.POISON).getDuration() < 160) {
			target.removeEffect(MobEffects.POISON);
			target.addEffect(MobEffectHelper.copyEffect(SPEAR_VENOM));	
		}
		stack.hurtAndBreak(1, attacker, (le) -> {
			le.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		return true;
	}
	
	@Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(stack, level, list, flag);
       List<MobEffectInstance> tempList = new ArrayList<>();
       tempList.add(SPEAR_VENOM);
       PotionUtils.addPotionTooltip(tempList, list, 1.0F);
	}
	
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot $$0) {
        return $$0 == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers($$0);
    }
    
    @Override
    public int getEnchantmentValue() {
        return 1;
    }
}
