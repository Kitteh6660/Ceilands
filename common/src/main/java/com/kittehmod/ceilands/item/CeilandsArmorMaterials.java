package com.kittehmod.ceilands.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class CeilandsArmorMaterials 
{
    /*public static final Holder<ArmorMaterial> CEILINIUM = register("ceilands:ceilinium", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    	map.put(ArmorItem.Type.BOOTS, 2); map.put(ArmorItem.Type.LEGGINGS, 5); map.put(ArmorItem.Type.CHESTPLATE, 6); map.put(ArmorItem.Type.HELMET, 2); map.put(ArmorItem.Type.BODY, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Items.IRON_INGOT));*/
    public static final Holder<ArmorMaterial> CASTLE_LORD = register("ceilands:castle_lord", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    	map.put(ArmorItem.Type.BOOTS, 2); map.put(ArmorItem.Type.LEGGINGS, 4); map.put(ArmorItem.Type.CHESTPLATE, 5); map.put(ArmorItem.Type.HELMET, 2); map.put(ArmorItem.Type.BODY, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(CeilandsItems.CASTLE_LORD_REGALIA_FRAGMENTS));
    
    private static Holder<ArmorMaterial> register(String registryName, EnumMap<ArmorItem.Type, Integer> typeMap, int $$2, Holder<SoundEvent> soundEvent, float $$4, float $$5, Supplier<Ingredient> $$6/*, List<ArmorMaterial.Layer> $$7*/) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
        	enumMap.put(type, typeMap.get(type));
        }
        List<ArmorMaterial.Layer> layerList = List.of(new ArmorMaterial.Layer(ResourceLocation.tryParse(registryName)));
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.tryParse(registryName), new ArmorMaterial(enumMap, $$2, soundEvent, $$6, layerList, $$4, $$5));
    }
}
