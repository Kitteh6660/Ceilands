package kittehmod.ceilands.block;

import kittehmod.ceilands.CeilandsMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CeilandsBlockTags
{
	
	public static final TagKey<Block> CEILANDS_PORTAL_FRAME_BLOCKS = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CeilandsMod.MODID, "ceilands_portal_blocks"));
}
