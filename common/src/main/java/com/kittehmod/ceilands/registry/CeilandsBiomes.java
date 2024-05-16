package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class CeilandsBiomes
{
	public static final ResourceKey<Biome> LUZAWOOD_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(Ceilands.MOD_ID, "luzawood_forest"));
	public static final ResourceKey<Biome> TOPSY_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(Ceilands.MOD_ID, "topsy_forest"));
	public static final ResourceKey<Biome> OCEAN_ORBS = ResourceKey.create(Registries.BIOME, new ResourceLocation(Ceilands.MOD_ID, "ocean_orbs"));	
	public static final ResourceKey<Biome> SNOW_ROOF = ResourceKey.create(Registries.BIOME, new ResourceLocation(Ceilands.MOD_ID, "snow_roof"));
	public static final ResourceKey<Biome> INVERTED_PEAKS = ResourceKey.create(Registries.BIOME, new ResourceLocation(Ceilands.MOD_ID, "inverted_peaks"));
}
