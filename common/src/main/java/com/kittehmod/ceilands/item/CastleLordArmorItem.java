package com.kittehmod.ceilands.item;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class CastleLordArmorItem extends ArmorItem
{
	// Had to declare those four modifiers as opposed to one to work around attribute modifier jank.
	private static final AttributeModifier CROWN_DAMAGE_MODIFIER = new AttributeModifier(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "castle_lord_crown_damage_bonus"), 1, Operation.ADD_VALUE);
	private static final AttributeModifier CHESTPLATE_DAMAGE_MODIFIER = new AttributeModifier(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "castle_lord_chestplate_damage_bonus"), 1, Operation.ADD_VALUE);
	private static final AttributeModifier LEGGINGS_DAMAGE_MODIFIER = new AttributeModifier(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "castle_lord_leggings_damage_bonus"), 1, Operation.ADD_VALUE);
	private static final AttributeModifier BOOTS_DAMAGE_MODIFIER = new AttributeModifier(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "castle_lord_boots_damage_bonus"), 1, Operation.ADD_VALUE);
	
	public CastleLordArmorItem(ArmorItem.Type type, Properties properties) {
		super(CeilandsArmorMaterials.CASTLE_LORD, type, properties);
	}
	
	@Override
	public ItemAttributeModifiers getDefaultAttributeModifiers() {
		ItemAttributeModifiers modifiers = super.getDefaultAttributeModifiers();
		switch(this.getEquipmentSlot()) {
			case HEAD:
				modifiers = modifiers.withModifierAdded(Attributes.ATTACK_DAMAGE, CROWN_DAMAGE_MODIFIER, EquipmentSlotGroup.bySlot(this.getEquipmentSlot()));
				break;
			case CHEST:
			case BODY:
				modifiers = modifiers.withModifierAdded(Attributes.ATTACK_DAMAGE, CHESTPLATE_DAMAGE_MODIFIER, EquipmentSlotGroup.bySlot(this.getEquipmentSlot()));
				break;
			case LEGS:
				modifiers = modifiers.withModifierAdded(Attributes.ATTACK_DAMAGE, LEGGINGS_DAMAGE_MODIFIER, EquipmentSlotGroup.bySlot(this.getEquipmentSlot()));
				break;
			case FEET:
				modifiers = modifiers.withModifierAdded(Attributes.ATTACK_DAMAGE, BOOTS_DAMAGE_MODIFIER, EquipmentSlotGroup.bySlot(this.getEquipmentSlot()));
				break;
			default:
		}
		return modifiers;
	}
}
