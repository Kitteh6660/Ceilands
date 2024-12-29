package com.kittehmod.ceilands.item;

import java.util.List;

import com.google.common.collect.Lists;
import com.kittehmod.ceilands.util.MobEffectHelper;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class VenomousSpearItem extends Item
{
	private static final MobEffectInstance SPEAR_VENOM = new MobEffectInstance(MobEffects.POISON, 160, 0);
	private ItemAttributeModifiers defaultModifiers;
	
	public VenomousSpearItem(Properties properties) {
		super(properties);
		this.defaultModifiers = VenomousSpearItem.createAttributes();
	}
	
    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
            .add(Attributes.ATTACK_DAMAGE,new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)5.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)-2.8F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
            .build();
    }
    
    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.defaultModifiers != null ? this.defaultModifiers : super.getDefaultAttributeModifiers();
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
		stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
		return true;
	}
	
	@Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
		List<Pair<Holder<Attribute>, AttributeModifier>> tempList = Lists.newArrayList();
        super.appendHoverText(stack, context, list, flag);
        MutableComponent $$7 = Component.translatable(SPEAR_VENOM.getDescriptionId());
        Holder<MobEffect> $$8 = SPEAR_VENOM.getEffect();
        $$8.value().createModifiers(SPEAR_VENOM.getAmplifier(), ($$1x, $$2x) -> tempList.add(new Pair<>($$1x, $$2x)));
        if (SPEAR_VENOM.getAmplifier() > 0) {
            $$7 = Component.translatable("potion.withAmplifier", $$7, Component.translatable("potion.potency." + SPEAR_VENOM.getAmplifier()));
        }

        if (!SPEAR_VENOM.endsWithin(20)) {
            $$7 = Component.translatable("potion.withDuration", $$7, MobEffectUtil.formatDuration(SPEAR_VENOM, 1, context.tickRate()));
        }
        list.add($$7.withStyle($$8.value().getCategory().getTooltipFormatting()));
	}
    
    @Override
    public int getEnchantmentValue() {
        return 1;
    }
}
