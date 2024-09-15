package com.kittehmod.ceilands.forge.compat;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.forge.CeilandsRegistry;
import com.kittehmod.ceilands.registry.CeilandsItems;
import com.teamabnormals.boatload.common.item.FurnaceBoatItem;
import com.teamabnormals.boatload.common.item.LargeBoatItem;
import com.teamabnormals.boatload.core.api.BoatloadBoatType;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import oshi.util.tuples.Pair;

public class BoatloadCompat 
{
	public static final ResourceLocation CEILTRUNK_FURNACE_BOAT_RES = new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_furnace_boat");
	public static final ResourceLocation LUZAWOOD_FURNACE_BOAT_RES = new ResourceLocation(Ceilands.MOD_ID, "luzawood_furnace_boat");
	public static final ResourceLocation LARGE_CEILTRUNK_BOAT_RES = new ResourceLocation(Ceilands.MOD_ID, "large_ceiltrunk_boat");
	public static final ResourceLocation LARGE_LUZAWOOD_BOAT_RES = new ResourceLocation(Ceilands.MOD_ID, "large_luzawood_boat");
	
	public BoatloadCompat(boolean register) {
		if (!register) {
			return;
		}
		BoatloadBoatType CEILTRUNK_BOAT_TYPE = BoatloadBoatType.register(BoatloadBoatType.create(new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk"), () -> { return CeilandsItems.CEILTRUNK_PLANKS; }, () -> { return CeilandsItems.CEILTRUNK_BOAT; }, () -> { return CeilandsItems.CEILTRUNK_CHEST_BOAT; }, () -> { return ForgeRegistries.ITEMS.getValue(CEILTRUNK_FURNACE_BOAT_RES); }, () -> { return ForgeRegistries.ITEMS.getValue(LARGE_CEILTRUNK_BOAT_RES); }));
		BoatloadBoatType LUZAWOOD_BOAT_TYPE = BoatloadBoatType.register(BoatloadBoatType.create(new ResourceLocation(Ceilands.MOD_ID, "luzawood"), () -> { return CeilandsItems.LUZAWOOD_PLANKS; }, () -> { return CeilandsItems.LUZAWOOD_BOAT; }, () -> { return CeilandsItems.LUZAWOOD_CHEST_BOAT; }, () -> { return ForgeRegistries.ITEMS.getValue(LUZAWOOD_FURNACE_BOAT_RES); }, () -> { return ForgeRegistries.ITEMS.getValue(LARGE_LUZAWOOD_BOAT_RES); }));
		Item CEILTRUNK_FURNACE_BOAT = new FurnaceBoatItem(CEILTRUNK_BOAT_TYPE);
		Item LARGE_CEILTRUNK_BOAT = new LargeBoatItem(CEILTRUNK_BOAT_TYPE);
		Item LUZAWOOD_FURNACE_BOAT = new FurnaceBoatItem(LUZAWOOD_BOAT_TYPE);
		Item LARGE_LUZAWOOD_BOAT = new LargeBoatItem(LUZAWOOD_BOAT_TYPE);
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_FURNACE_BOAT_RES, CEILTRUNK_FURNACE_BOAT));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_FURNACE_BOAT_RES, LUZAWOOD_FURNACE_BOAT));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LARGE_CEILTRUNK_BOAT_RES, LARGE_CEILTRUNK_BOAT));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LARGE_LUZAWOOD_BOAT_RES, LARGE_LUZAWOOD_BOAT));
	}
}
