package com.kittehmod.ceilands.registry;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import net.minecraft.world.entity.ai.village.poi.PoiTypes;

public class CeilandsPOIType
{
	public static final PoiType CEILANDS_PORTAL_POI = new PoiType(ImmutableSet.copyOf(CeilandsBlocks.CEILANDS_PORTAL.getStateDefinition().getPossibleStates()), 0, 1);
	public static final ResourceKey<PoiType> CEILANDS_PORTAL = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation("ceilands:ceilands_portal"));
}
