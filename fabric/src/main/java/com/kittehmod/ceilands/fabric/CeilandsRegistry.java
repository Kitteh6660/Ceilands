package com.kittehmod.ceilands.fabric;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.entity.mob.CastleLord;
import com.kittehmod.ceilands.item.CeilandsFuels;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsGameRules;
import com.kittehmod.ceilands.registry.ModRegistryHandler;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

public class CeilandsRegistry 
{
	public static final List<Pair<ResourceLocation, Block>> COMPAT_BLOCKS = new ArrayList();
	public static final List<Pair<ResourceLocation, Item>> COMPAT_ITEMS = new ArrayList();
	
	public static void initializeRegistry() {
		// Set up primary registries.
		ModRegistryHandler.registerModContent(true);
		CeilandsRegistry.registerPOIs();
		
		// Set up secondary registries.
		CeilandsRegistry.registerStrippables();
		CeilandsRegistry.registerFuels();
		CeilandsRegistry.registerFlammableBlocks();
		CeilandsGameRules.setup();
		
		// Set up tertiary registries.
		FabricDefaultAttributeRegistry.register(CeilandsEntities.CASTLE_LORD, CastleLord.createAttributes());
	}

	
	public static void registerPOIs() {
		PointOfInterestHelper.register(new ResourceLocation(Ceilands.MOD_ID, "ceilands_portal"), 0, 1, CeilandsBlocks.CEILANDS_PORTAL);
	}
	
	public static void registerFlammableBlocks() {
		for (Triplet<Block, Integer, Integer> entry : CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS) {
			FlammableBlockRegistry.getDefaultInstance().add(entry.getA(), entry.getB(), entry.getC());
		}
	}
	
	public static void registerFuels() {
		for (Pair<Item, Integer> entry : CeilandsFuels.CEILANDS_FUELS) {
			FuelRegistry.INSTANCE.add(entry.getA(), entry.getB());
		}
	}
	
	public static void registerStrippables() {
		StrippableBlockRegistry.register(CeilandsBlocks.CEILTRUNK_LOG, CeilandsBlocks.STRIPPED_CEILTRUNK_LOG);
		StrippableBlockRegistry.register(CeilandsBlocks.CEILTRUNK_WOOD, CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD);
		StrippableBlockRegistry.register(CeilandsBlocks.LUZAWOOD_LOG, CeilandsBlocks.STRIPPED_LUZAWOOD_LOG);
		StrippableBlockRegistry.register(CeilandsBlocks.LUZAWOOD_WOOD, CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD);
	}
}
