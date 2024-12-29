package com.kittehmod.ceilands.tags;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CeilandsBlockTags
{
	public static final TagKey<Block> CEILANDS_PORTAL_FRAME_BLOCKS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_portal_frame_blocks"));
	public static final TagKey<Block> CEILANDS_PORTAL_REPLACEABLES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceilands_portal_replaceables"));
	public static final TagKey<Block> WATER_ORB_REPLACEABLES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "water_orb_replaceables"));
	public static final TagKey<Block> SPIDER_SILK_BLOCKS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "spider_silk_blocks"));
}
