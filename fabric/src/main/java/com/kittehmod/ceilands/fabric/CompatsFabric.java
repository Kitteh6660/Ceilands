package com.kittehmod.ceilands.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class CompatsFabric 
{
	public static final boolean DRAMATIC_DOORS_INSTALLED = FabricLoader.getInstance().isModLoaded("dramaticdoors");
}
