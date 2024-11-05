package com.kittehmod.ceilands.item;

import com.google.common.collect.Multimap;
import com.kittehmod.ceilands.Ceilands;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;

public class CastleLordArmorItem extends ArmorItem
{
	// Had to declare those four modifiers as opposed to one to work around attribute modifier jank.
	private static final AttributeModifier CROWN_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_crown_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier CHESTPLATE_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_chestplate_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier LEGGINGS_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_leggings_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier BOOTS_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_boots_damage_bonus", 1, Operation.ADDITION);
	
	public CastleLordArmorItem(EquipmentSlot type, Properties properties) {
		super(CeilandsArmorMaterials.CASTLE_LORD, type, properties);
	}
	
	//TODO: Figure out how to make this work in 1.19.2.
	/*@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
		Multimap<Attribute, AttributeModifier> modifiers = super.getDefaultAttributeModifiers(slot);
		switch(slot) {
			case HEAD:
				modifiers.put(Attributes.ATTACK_DAMAGE, CROWN_DAMAGE_MODIFIER);
				break;
			case CHEST:
				modifiers.put(Attributes.ATTACK_DAMAGE, CHESTPLATE_DAMAGE_MODIFIER);
				break;
			case LEGS:
				modifiers.put(Attributes.ATTACK_DAMAGE, LEGGINGS_DAMAGE_MODIFIER);
				break;
			case FEET:
				modifiers.put(Attributes.ATTACK_DAMAGE, BOOTS_DAMAGE_MODIFIER);
				break;
			default:
		}
		return modifiers;
	}*/
}
