package com.kittehmod.ceilands.forge.compat;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.forge.CeilandsRegistry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import oshi.util.tuples.Pair;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;
import vectorwing.farmersdelight.common.registry.ModItems;

public class FarmersDelightCompat 
{
	public static final ResourceLocation CEILTRUNK_CABINET_RES = new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_cabinet");
	public static final ResourceLocation LUZAWOOD_CABINET_RES = new ResourceLocation(Ceilands.MOD_ID, "luzawood_cabinet");
	
	public FarmersDelightCompat(boolean register) {
		if (!register) {
			return;
		}
		Block CEILTRUNK_CABINET = ModList.get().isLoaded("farmersdelight") ? new CabinetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()) : null;
		Block LUZAWOOD_CABINET = ModList.get().isLoaded("farmersdelight") ? new CabinetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()) : null;
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_CABINET_RES, CEILTRUNK_CABINET));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_CABINET_RES, LUZAWOOD_CABINET));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_CABINET_RES, new BlockItem(CEILTRUNK_CABINET, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_CABINET_RES, new BlockItem(LUZAWOOD_CABINET, new Item.Properties())));
	}
	
	@SubscribeEvent
	public void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		MutableHashedLinkedMap<ItemStack, TabVisibility> map = event.getEntries();
		if (event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey()) {
			map.putAfter(ModItems.WARPED_CABINET.get().getDefaultInstance(), ForgeRegistries.ITEMS.getValue(CEILTRUNK_CABINET_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.putAfter(ForgeRegistries.ITEMS.getValue(CEILTRUNK_CABINET_RES).getDefaultInstance(), ForgeRegistries.ITEMS.getValue(LUZAWOOD_CABINET_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
}
