package com.kittehmod.ceilands.neoforge.compat;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.neoforge.CeilandsRegistry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import oshi.util.tuples.Pair;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;
import vectorwing.farmersdelight.common.registry.ModItems;

public class FarmersDelightCompat 
{
	public static final ResourceLocation CEILTRUNK_CABINET_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_cabinet");
	public static final ResourceLocation LUZAWOOD_CABINET_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_cabinet");
	
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
		if (event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT) {
			event.insertAfter(ModItems.WARPED_CABINET.get().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_CABINET_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_CABINET_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_CABINET_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
}
