package com.kittehmod.ceilands.forge.compat.client;

import com.kittehmod.ceilands.forge.compat.TwilightForestCompat;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.block.HollowLogClimbable;
import twilightforest.enums.HollowLogVariants;

public class TFCompatClient 
{
	public static final TFCompatClient INSTANCE = new TFCompatClient();
	
	public void registerColours(RegisterColorHandlersEvent.Block event) {
		event.register((state, worldIn, pos, tintIndex) -> { return state.getValue(HollowLogClimbable.VARIANT) != HollowLogVariants.Climbable.VINE || (tintIndex & 1) == 0 ? 0xFFFFFF : (worldIn != null && pos != null ? BiomeColors.getAverageFoliageColor(worldIn, pos) : FoliageColor.getDefaultColor()); }, 
				ForgeRegistries.BLOCKS.getValue(TwilightForestCompat.CEILTRUNK_HOLLOW_LOG_CLIMBABLE_RES), ForgeRegistries.BLOCKS.getValue(TwilightForestCompat.LUZAWOOD_HOLLOW_LOG_CLIMBABLE_RES));
	}
}
