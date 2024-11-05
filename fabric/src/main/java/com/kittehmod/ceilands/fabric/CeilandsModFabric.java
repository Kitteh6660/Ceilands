package com.kittehmod.ceilands.fabric;

import com.kittehmod.ceilands.registry.CeilandsGameRules;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CeilandsModFabric implements ModInitializer
{
	@Override
	public void onInitialize() {
		if (FabricLoader.getInstance().isModLoaded("connector")) {
			return;
		}
		CeilandsRegistry.initializeRegistry();
	}
}
