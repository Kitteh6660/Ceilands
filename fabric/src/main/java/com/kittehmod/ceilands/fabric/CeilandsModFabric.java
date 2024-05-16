package com.kittehmod.ceilands.fabric;

import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.fabric.util.CreativeTabHelper;
import com.kittehmod.ceilands.registry.CeilandsBiomes;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsFeatures;
import com.kittehmod.ceilands.registry.CeilandsItems;
import com.kittehmod.ceilands.registry.CeilandsTrunkPlacerType;
import com.mojang.logging.LogUtils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import org.slf4j.Logger;

public class CeilandsModFabric implements ModInitializer
{
	@Override
	public void onInitialize() {
		if (FabricLoader.getInstance().isModLoaded("connector")) {
			return;
		}
		CeilandsRegistry.registerPrimary();
		CeilandsRegistry.registerSecondary();
		CreativeTabHelper.assignItemsToTabs();
	}
}
