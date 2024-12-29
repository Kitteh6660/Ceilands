package com.kittehmod.ceilands.neoforge;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableSet;
import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.entity.mob.CastleLord;
import com.kittehmod.ceilands.entity.mob.SpiderMonarch;
import com.kittehmod.ceilands.neoforge.compat.FarmersDelightCompat;
import com.kittehmod.ceilands.neoforge.compat.TwilightForestCompat;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsFeatures;
import com.kittehmod.ceilands.registry.CeilandsGameRules;
import com.kittehmod.ceilands.registry.CeilandsItems;
import com.kittehmod.ceilands.registry.CeilandsPOIType;
import com.kittehmod.ceilands.registry.CeilandsTrunkPlacerType;
import com.kittehmod.ceilands.util.CreativeModeTabDatabase;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Quintet;
import oshi.util.tuples.Triplet;

public class CeilandsRegistry 
{
	public static final List<Pair<ResourceLocation, Block>> COMPAT_BLOCKS = new ArrayList();
	public static final List<Pair<ResourceLocation, Item>> COMPAT_ITEMS = new ArrayList();
	
	private static boolean initializedAdditional = false;
	
	@SubscribeEvent
	public static void register(RegisterEvent event) {
		event.register(Registries.BLOCK, registry -> {
			CeilandsBlocks.init();
			CeilandsRegistry.registerCompats();
			for (Pair<ResourceLocation, Block> pair : CeilandsBlocks.BLOCKS) {
				registry.register(pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, Block> pair : COMPAT_BLOCKS) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.ITEM, registry -> {
			CeilandsItems.init();
			for (Pair<ResourceLocation, Item> pair : CeilandsItems.ITEMS) {
				registry.register(pair.getA(), pair.getB());
			}
			for (Pair<ResourceLocation, Item> pair : COMPAT_ITEMS) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.ENTITY_TYPE, registry -> {
			CeilandsItems.init();
			for (Pair<ResourceLocation, EntityType<?>> pair : CeilandsEntities.ENTITIES) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.BLOCK_ENTITY_TYPE, registry -> {
			CeilandsBlockEntities.init();
			for (Pair<ResourceLocation, BlockEntityType<?>> pair : CeilandsBlockEntities.BLOCK_ENTITIES) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.FEATURE, registry -> {
			CeilandsFeatures.init();
			for (Pair<ResourceLocation, Feature<?>> pair : CeilandsFeatures.FEATURES) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.TRUNK_PLACER_TYPE, registry -> {
			CeilandsTrunkPlacerType.init();
			for (Pair<ResourceLocation, TrunkPlacerType<?>> pair : CeilandsTrunkPlacerType.TRUNK_PLACERS) {
				registry.register(pair.getA(), pair.getB());
			}
		});
		event.register(Registries.POINT_OF_INTEREST_TYPE, registry -> {
			registry.register(CeilandsPOIType.CEILANDS_PORTAL, new PoiType(ImmutableSet.copyOf(CeilandsBlocks.CEILANDS_PORTAL.getStateDefinition().getPossibleStates()), 0, 1));
		});
		if (!initializedAdditional) {
			initializedAdditional = true;
			CeilandsGameRules.setup();
			CreativeModeTabDatabase.populateContents();
		}
	}
	
	@SubscribeEvent
	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(CeilandsEntities.CASTLE_LORD, CastleLord.createAttributes().build());
		event.put(CeilandsEntities.SPIDER_MONARCH, SpiderMonarch.createAttributes().build());
	}
	
    protected static void registerCompats() {
    	if (ModList.get().isLoaded("farmersdelight")) {
    		new FarmersDelightCompat(true);
    	}
    	if (ModList.get().isLoaded("twilightforest")) {
    		new TwilightForestCompat(true);
    	}
    	/*if (ModList.get().isLoaded("woodworks")) {
    		new WoodworksCompat(true);
    	}
    	if (ModList.get().isLoaded("boatload")) {
    		new BoatloadCompat(true);
    	}*/
    }
    
    protected static void registerFlammable() {
    	for (Triplet<Block, Integer, Integer> entry : CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS) {
    		((FireBlock)Blocks.FIRE).setFlammable(entry.getA(), entry.getB(), entry.getC());
    	}
    }
    
    protected static void registerFlowerPots() {
    	((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_sapling"), () -> CeilandsBlocks.POTTED_LUZAWOOD_SAPLING);
    }
    
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
    	// Insert into vanilla tabs.
		for (Quintet<Item, Item, TabVisibility, Boolean, ResourceKey<CreativeModeTab>> quint : CreativeModeTabDatabase.ITEM_ENTRIES) {
			if (quint.getE() != tabKey) {
				continue;
			}
			if (quint.getA() == null) {
				event.accept(quint.getB());
				continue;
			}
			if (quint.getD()) {
				event.insertAfter(quint.getA().getDefaultInstance(), quint.getB().getDefaultInstance(), quint.getC());
			}
			else {
				event.insertBefore(quint.getA().getDefaultInstance(), quint.getB().getDefaultInstance(), quint.getC());    				
			}
		}
		if (CompatsNeoForge.DRAMATIC_DOORS_INSTALLED && tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
			event.insertBefore(CeilandsItems.CEILTRUNK_DOOR.getDefaultInstance(), BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("dramaticdoors", "short_ceiltrunk_door")).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(CeilandsItems.CEILTRUNK_DOOR.getDefaultInstance(), BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("dramaticdoors", "tall_ceiltrunk_door")).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertBefore(CeilandsItems.LUZAWOOD_DOOR.getDefaultInstance(), BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("dramaticdoors", "short_luzawood_door")).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_DOOR.getDefaultInstance(), BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("dramaticdoors", "tall_luzawood_door")).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
}
