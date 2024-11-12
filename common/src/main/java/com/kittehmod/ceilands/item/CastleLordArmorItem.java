package com.kittehmod.ceilands.item;

import java.util.EnumMap;
import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.kittehmod.ceilands.Ceilands;

import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;

public class CastleLordArmorItem extends ArmorItem
{
    private static final EnumMap<ArmorItem.Type, UUID> ARMOR_MODIFIER_UUID_PER_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), $$0 -> {
        $$0.put(ArmorItem.Type.BOOTS, UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"));
        $$0.put(ArmorItem.Type.LEGGINGS, UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"));
        $$0.put(ArmorItem.Type.CHESTPLATE, UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"));
        $$0.put(ArmorItem.Type.HELMET, UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"));
    });
    
	// Had to declare those four modifiers as opposed to one to work around attribute modifier jank.
	private static final AttributeModifier CROWN_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_crown_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier CHESTPLATE_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_chestplate_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier LEGGINGS_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_leggings_damage_bonus", 1, Operation.ADDITION);
	private static final AttributeModifier BOOTS_DAMAGE_MODIFIER = new AttributeModifier("ceilands:castle_lord_boots_damage_bonus", 1, Operation.ADDITION);
	
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	
	public CastleLordArmorItem(Type type, Properties properties) {
		super(CeilandsArmorMaterials.CASTLE_LORD, type, properties);
		
		// this.getDefaultInstance().addAttributeModifier(Attributes.ATTACK_DAMAGE, getModifierForSlot(), this.getEquipmentSlot());
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID $$4 = ARMOR_MODIFIER_UUID_PER_TYPE.get(type);
        builder.put(Attributes.ARMOR, new AttributeModifier($$4, "Armor modifier", (double)CeilandsArmorMaterials.CASTLE_LORD.getDefenseForType(type), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier($$4, "Armor toughness", (double)CeilandsArmorMaterials.CASTLE_LORD.getToughness(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_DAMAGE, getModifierForSlot(type));
        this.defaultModifiers = builder.build();
	}
	
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot $$0) {
        return $$0 == this.type.getSlot() ? this.defaultModifiers : super.getDefaultAttributeModifiers($$0);
    }
	
	private AttributeModifier getModifierForSlot(Type type) {
		switch(type) {
		case HELMET:
		default:
			return CROWN_DAMAGE_MODIFIER;
		case CHESTPLATE:
			return CHESTPLATE_DAMAGE_MODIFIER;
		case LEGGINGS:
			return LEGGINGS_DAMAGE_MODIFIER;
		case BOOTS:
			return BOOTS_DAMAGE_MODIFIER;
		}
	}
}
