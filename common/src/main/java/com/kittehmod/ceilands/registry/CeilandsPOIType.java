package com.kittehmod.ceilands.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class CeilandsPOIType
{
	public static final ResourceKey<PoiType> CEILANDS_PORTAL = ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation("ceilands:ceilands_portal"));
}
