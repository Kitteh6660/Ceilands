package com.kittehmod.ceilands.forge.compat;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.forge.CeilandsRegistry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.ModList;
import oshi.util.tuples.Pair;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class FarmersDelightCompat 
{
	public static final ResourceLocation CEILTRUNK_CABINET_RES = new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_cabinet");
	public static final ResourceLocation LUZAWOOD_CABINET_RES = new ResourceLocation(Ceilands.MOD_ID, "luzawood_cabinet");
	// public static final ResourceLocation CEILINUM_KNIFE_RES = new ResourceLocation(Ceilands.MOD_ID, "ceilinum_knife");
	
	public FarmersDelightCompat(boolean register) {
		if (!register) {
			return;
		}
		// Item CEILINUM_KNIFE = ModList.get().isLoaded("farmersdelight") ? new KnifeItem(new Item.Properties().tab(FarmersDelight.CREATIVE_TAB)) : null;
		Block CEILTRUNK_CABINET = ModList.get().isLoaded("farmersdelight") ? new CabinetBlock(BlockBehaviour.Properties.of(Material.WOOD).color(MaterialColor.COLOR_LIGHT_GREEN).strength(2.5F).sound(SoundType.WOOD)) : null;
		Block LUZAWOOD_CABINET = ModList.get().isLoaded("farmersdelight") ? new CabinetBlock(BlockBehaviour.Properties.of(Material.WOOD).color(MaterialColor.COLOR_LIGHT_BLUE).strength(2.5F).sound(SoundType.WOOD)) : null;
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_CABINET_RES, CEILTRUNK_CABINET));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_CABINET_RES, LUZAWOOD_CABINET));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_CABINET_RES, new BlockItem(CEILTRUNK_CABINET, new Item.Properties().tab(FarmersDelight.CREATIVE_TAB))));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_CABINET_RES, new BlockItem(LUZAWOOD_CABINET, new Item.Properties().tab(FarmersDelight.CREATIVE_TAB))));
	}
}
