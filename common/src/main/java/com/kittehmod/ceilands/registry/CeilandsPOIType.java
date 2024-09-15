package com.kittehmod.ceilands.registry;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class CeilandsPOIType
{
	public static final PoiType CEILANDS_PORTAL_POI = new PoiType(ImmutableSet.copyOf(CeilandsBlocks.CEILANDS_PORTAL.getStateDefinition().getPossibleStates()), 0, 1);
	
	public static final ResourceKey<PoiType> CEILANDS_PORTAL = ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation("ceilands:ceilands_portal"));
}
