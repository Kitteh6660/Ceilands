package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class CeilandsDimension
{
	public static final ResourceKey<Level> CEILANDS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Ceilands.MOD_ID, "the_ceilands"));
	
	public static final ResourceKey<DimensionType> CEILANDS_TYPE_KEY = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(Ceilands.MOD_ID, "the_ceilands"));
}
