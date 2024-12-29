package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import oshi.util.tuples.Pair;

public class CeilandsPOIType
{
	public static final List<Pair<ResourceKey, PoiType>> POI_TYPES = new ArrayList<Pair<ResourceKey, PoiType>>();
	
	public static final ResourceKey<PoiType> CEILANDS_PORTAL = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_portal"));
}
