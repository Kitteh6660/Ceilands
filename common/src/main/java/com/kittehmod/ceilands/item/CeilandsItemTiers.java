package com.kittehmod.ceilands.item;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum CeilandsItemTiers implements Tier
{
	CEILINIUM(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 768, 7.0F, 3.0F, 16, () -> Ingredient.of(Items.IRON_INGOT));
	
    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    private CeilandsItemTiers(final TagKey<Block> tagKey, final int usesIn, final float speedIn, final float damageIn, final int enchIn, final Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = tagKey;
        this.uses = usesIn;
        this.speed = speedIn;
        this.damage = damageIn;
        this.enchantmentValue = enchIn;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }
    
    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

}
