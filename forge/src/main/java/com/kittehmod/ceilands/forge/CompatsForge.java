package com.kittehmod.ceilands.forge;

import net.minecraftforge.fml.ModList;

public class CompatsForge 
{
	public static final boolean FARMERS_DELIGHT_INSTALLED = ModList.get().isLoaded("farmersdelight");
	public static final boolean TWILIGHT_FOREST_INSTALLED = ModList.get().isLoaded("twilightforest");
	public static final boolean BOATLOAD_INSTALLED = ModList.get().isLoaded("boatload");
	public static final boolean WOODWORKS_INSTALLED = ModList.get().isLoaded("woodworks");
}
