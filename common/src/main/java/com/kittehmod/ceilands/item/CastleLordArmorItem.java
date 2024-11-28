package com.kittehmod.ceilands.item;

import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;

public class CastleLordArmorItem extends ArmorItem
{
    private static final UUID[] ARMOR_MODIFIER_UUID_PER_SLOT = new UUID[]{
        UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
        UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
        UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
        UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")
    };
    
	// Had to declare those four modifiers as opposed to one to work around attribute modifier jank.
	private static final AttributeModifier CROWN_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_crown_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier CHESTPLATE_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_chestplate_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier LEGGINGS_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_leggings_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier BOOTS_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_boots_damage_bonus", 1, Operation.ADDITION);
	
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	
	public CastleLordArmorItem(EquipmentSlot slot, Properties properties) {
		super(CeilandsArmorMaterials.CASTLE_LORD, slot, properties);
		
		// this.getDefaultInstance().addAttributeModifier(Attributes.ATTACK_DAMAGE, getModifierForSlot(), this.getEquipmentSlot());
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID $$4 = ARMOR_MODIFIER_UUID_PER_SLOT[slot.getIndex()];
        builder.put(Attributes.ARMOR, new AttributeModifier($$4, "Armor modifier", (double)CeilandsArmorMaterials.CASTLE_LORD.getDefenseForSlot(slot), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier($$4, "Armor toughness", (double)CeilandsArmorMaterials.CASTLE_LORD.getToughness(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_DAMAGE, getModifierForSlot(slot));
        this.defaultModifiers = builder.build();
	}
	
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot $$0) {
        return $$0 == this.getSlot() ? this.defaultModifiers : super.getDefaultAttributeModifiers($$0);
    }
	
	private AttributeModifier getModifierForSlot(EquipmentSlot slot) {
		switch(slot) {
		case HEAD:
		default:
			return CROWN_DAMAGE_MODIFIER;
		case CHEST:
			return CHESTPLATE_DAMAGE_MODIFIER;
		case LEGS:
			return LEGGINGS_DAMAGE_MODIFIER;
		case FEET:
			return BOOTS_DAMAGE_MODIFIER;
		}
	}
}
