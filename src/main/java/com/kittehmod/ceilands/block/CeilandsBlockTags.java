package com.kittehmod.ceilands.block;

import com.kittehmod.ceilands.CeilandsMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CeilandsBlockTags
{
	
	public static final TagKey<Block> CEILANDS_PORTAL_FRAME_BLOCKS = TagKey.create(Registries.BLOCK, new ResourceLocation(CeilandsMod.MODID, "ceilands_portal_frame_blocks"));
	public static final TagKey<Block> CEILANDS_PORTAL_REPLACEABLES = TagKey.create(Registries.BLOCK, new ResourceLocation(CeilandsMod.MODID, "ceilands_portal_replaceables"));
	public static final TagKey<Block> WATER_ORB_REPLACEABLES = TagKey.create(Registries.BLOCK, new ResourceLocation(CeilandsMod.MODID, "water_orb_replaceables"));
}
