package com.kittehmod.ceilands.worldgen.biomes;

import com.kittehmod.ceilands.CeilandsMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CeilandsBiomes
{
	public static final ResourceKey<Biome> LUZAWOOD_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CeilandsMod.MODID, "luzawood_forest"));
	public static final ResourceKey<Biome> TOPSY_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CeilandsMod.MODID, "topsy_forest"));
	public static final ResourceKey<Biome> OCEAN_ORBS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CeilandsMod.MODID, "ocean_orbs"));	
	public static final ResourceKey<Biome> SNOW_ROOF = ResourceKey.create(Registries.BIOME, new ResourceLocation(CeilandsMod.MODID, "snow_roof"));
	public static final ResourceKey<Biome> INVERTED_PEAKS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CeilandsMod.MODID, "inverted_peaks"));
}
