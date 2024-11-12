package com.kittehmod.ceilands.item;

import java.util.function.Supplier;

import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum CeilandsArmorMaterials implements ArmorMaterial
{
    CASTLE_LORD("ceilands:castle_lord", 20, new int[]{2, 5, 4, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(CeilandsItems.CASTLE_LORD_REGALIA_FRAGMENTS));
    
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final float knockbackResist;
	private final Supplier<Ingredient> repairMaterial;
    
	private CeilandsArmorMaterials(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughnessIn, float knockbackResistIn, Supplier<Ingredient> repairMaterialSupplier) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountsIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = equipSoundIn;
		this.toughness = toughnessIn;
		this.knockbackResist = knockbackResistIn;
		this.repairMaterial = repairMaterialSupplier;
	}

	public int getDurabilityForType(Type slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.ordinal()] * this.maxDamageFactor;
	}

	public int getDefenseForType(Type slotIn) {
		return this.damageReductionAmountArray[slotIn.ordinal()];
	}

	public int getEnchantmentValue() {
		return this.enchantability;
	}

	public SoundEvent getEquipSound() {
		return this.soundEvent;
	}

	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}

	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResist;
	}
}
