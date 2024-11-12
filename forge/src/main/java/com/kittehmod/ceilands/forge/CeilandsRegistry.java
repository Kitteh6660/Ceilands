package com.kittehmod.ceilands.forge;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableSet;
import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.entity.mob.CastleLord;
import com.kittehmod.ceilands.forge.compat.BoatloadCompat;
import com.kittehmod.ceilands.forge.compat.FarmersDelightCompat;
import com.kittehmod.ceilands.forge.compat.TwilightForestCompat;
import com.kittehmod.ceilands.forge.compat.WoodworksCompat;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsGameRules;
import com.kittehmod.ceilands.registry.CeilandsPOIType;
import com.kittehmod.ceilands.registry.ModRegistryHandler;
import com.kittehmod.ceilands.util.CreativeModeTabDatabase;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CeilandsRegistry 
{
	public static final List<Pair<ResourceLocation, Block>> COMPAT_BLOCKS = new ArrayList();
	public static final List<Pair<ResourceLocation, Item>> COMPAT_ITEMS = new ArrayList();
	
	private static boolean initializedRegistries = false;
	
	@SubscribeEvent
	public static void register(RegisterEvent event) {
		if (!initializedRegistries) {
			initializedRegistries = true;
			ModRegistryHandler.registerModContent(false);
			CeilandsGameRules.setup();
			CreativeModeTabDatabase.populateContents();
		}
		event.register(ForgeRegistries.Keys.BLOCKS, registry -> {
			CeilandsRegistry.registerCompats();
			for (Pair<ResourceLocation, Block> pair : ModRegistryHandler.BLOCKS) {
				registry.register(pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, Block> pair : COMPAT_BLOCKS) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(ForgeRegistries.Keys.ITEMS, registry -> {
			for (Pair<ResourceLocation, Item> pair : ModRegistryHandler.ITEMS) {
				registry.register(pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, Item> pair : COMPAT_ITEMS) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(ForgeRegistries.Keys.ENTITY_TYPES, registry -> {
			for (Pair<ResourceLocation, EntityType<?>> pair : ModRegistryHandler.ENTITIES) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, registry -> {
			for (Pair<ResourceLocation, BlockEntityType<?>> pair : ModRegistryHandler.BLOCK_ENTITIES) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(ForgeRegistries.Keys.FEATURES, registry -> {
			for (Pair<ResourceLocation, Feature<?>> pair : ModRegistryHandler.FEATURES) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.TRUNK_PLACER_TYPE, registry -> {
			for (Pair<ResourceLocation, TrunkPlacerType<?>> pair : ModRegistryHandler.TRUNK_PLACERS) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(ForgeRegistries.Keys.POI_TYPES, registry -> {
			registry.register(CeilandsPOIType.CEILANDS_PORTAL, new PoiType(ImmutableSet.copyOf(CeilandsBlocks.CEILANDS_PORTAL.getStateDefinition().getPossibleStates()), 0, 1));
		});
	}
	
    protected static void registerCompats() {
    	if (ModList.get().isLoaded("farmersdelight")) {
    		new FarmersDelightCompat(true);
    	}
    	if (ModList.get().isLoaded("twilightforest")) {
    		new TwilightForestCompat(true);
    	}
    	if (ModList.get().isLoaded("woodworks")) {
    		new WoodworksCompat(true);
    	}
    	if (ModList.get().isLoaded("boatload")) {
    		new BoatloadCompat(true);
    	}
    }
    
	@SubscribeEvent
	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(CeilandsEntities.CASTLE_LORD, CastleLord.createAttributes().build());
	}
    
    protected static void registerFlammable() {
    	for (Triplet<Block, Integer, Integer> entry : CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS) {
    		((FireBlock)Blocks.FIRE).setFlammable(entry.getA(), entry.getB(), entry.getC());
    	}
    }
    
    protected static void registerFlowerPots() {
    	((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(new ResourceLocation(Ceilands.MOD_ID, "luzawood_sapling"), () -> CeilandsBlocks.POTTED_LUZAWOOD_SAPLING);
    }
}
