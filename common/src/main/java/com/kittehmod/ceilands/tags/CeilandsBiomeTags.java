package com.kittehmod.ceilands.tags;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class CeilandsBiomeTags 
{
	public static final TagKey<Biome> IS_CEILANDS = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "is_ceilands"));
}
