package com.kittehmod.ceilands.neoforge.util;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.neoforge.CompatsNeoForge;
import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class CreativeTabHelper 
{
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
    	// Insert into vanilla tabs.
    	if (tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
    		event.insertAfter(Items.PURPUR_SLAB.getDefaultInstance(), CeilandsItems.CEILINGNEOUS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILINGNEOUS.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILINGNEOUS_STAIRS.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILINGNEOUS_SLAB.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_WALL.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILINGNEOUS_WALL.getDefaultInstance(), CeilandsItems.CHISELED_CEILINGNEOUS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CHISELED_CEILINGNEOUS.getDefaultInstance(), CeilandsItems.POLISHED_CEILINGNEOUS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.POLISHED_CEILINGNEOUS.getDefaultInstance(), CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS.getDefaultInstance(), CeilandsItems.POLISHED_CEILINGNEOUS_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.POLISHED_CEILINGNEOUS_SLAB.getDefaultInstance(), CeilandsItems.POLISHED_CEILINGNEOUS_WALL.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.POLISHED_CEILINGNEOUS_WALL.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_BRICKS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILINGNEOUS_BRICKS.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_BRICK_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILINGNEOUS_BRICK_STAIRS.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_BRICK_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILINGNEOUS_BRICK_SLAB.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_BRICK_WALL.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILINGNEOUS_BRICK_WALL.getDefaultInstance(), CeilandsItems.CRACKED_CEILINGNEOUS_BRICKS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		event.insertAfter(Items.WARPED_BUTTON.getDefaultInstance(), CeilandsItems.CEILTRUNK_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_LOG.getDefaultInstance(), CeilandsItems.CEILTRUNK_WOOD.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_WOOD.getDefaultInstance(), CeilandsItems.STRIPPED_CEILTRUNK_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.STRIPPED_CEILTRUNK_LOG.getDefaultInstance(), CeilandsItems.STRIPPED_CEILTRUNK_WOOD.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.STRIPPED_CEILTRUNK_WOOD.getDefaultInstance(), CeilandsItems.CEILTRUNK_PLANKS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_PLANKS.getDefaultInstance(), CeilandsItems.CEILTRUNK_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_STAIRS.getDefaultInstance(), CeilandsItems.CEILTRUNK_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_SLAB.getDefaultInstance(), CeilandsItems.CEILTRUNK_FENCE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_FENCE.getDefaultInstance(), CeilandsItems.CEILTRUNK_FENCE_GATE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_FENCE_GATE.getDefaultInstance(), CeilandsItems.CEILTRUNK_DOOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_DOOR.getDefaultInstance(), CeilandsItems.CEILTRUNK_TRAPDOOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_TRAPDOOR.getDefaultInstance(), CeilandsItems.CEILTRUNK_PRESSURE_PLATE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_PRESSURE_PLATE.getDefaultInstance(), CeilandsItems.CEILTRUNK_BUTTON.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		event.insertAfter(CeilandsItems.CEILTRUNK_BUTTON.getDefaultInstance(), CeilandsItems.LUZAWOOD_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_LOG.getDefaultInstance(), CeilandsItems.LUZAWOOD_WOOD.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_WOOD.getDefaultInstance(), CeilandsItems.STRIPPED_LUZAWOOD_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.STRIPPED_LUZAWOOD_LOG.getDefaultInstance(), CeilandsItems.STRIPPED_LUZAWOOD_WOOD.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.STRIPPED_LUZAWOOD_WOOD.getDefaultInstance(), CeilandsItems.LUZAWOOD_PLANKS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_PLANKS.getDefaultInstance(), CeilandsItems.LUZAWOOD_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_STAIRS.getDefaultInstance(), CeilandsItems.LUZAWOOD_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_SLAB.getDefaultInstance(), CeilandsItems.LUZAWOOD_FENCE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_FENCE.getDefaultInstance(), CeilandsItems.LUZAWOOD_FENCE_GATE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_FENCE_GATE.getDefaultInstance(), CeilandsItems.LUZAWOOD_DOOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_DOOR.getDefaultInstance(), CeilandsItems.LUZAWOOD_TRAPDOOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_TRAPDOOR.getDefaultInstance(), CeilandsItems.LUZAWOOD_PRESSURE_PLATE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_PRESSURE_PLATE.getDefaultInstance(), CeilandsItems.LUZAWOOD_BUTTON.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (tabKey == CreativeModeTabs.NATURAL_BLOCKS) {
    		event.insertAfter(Items.END_STONE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);

    		event.insertAfter(Items.DEEPSLATE_COAL_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_COAL_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.DEEPSLATE_COPPER_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_COPPER_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.DEEPSLATE_IRON_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_IRON_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.DEEPSLATE_GOLD_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_GOLD_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.DEEPSLATE_DIAMOND_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_DIAMOND_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.DEEPSLATE_EMERALD_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_EMERALD_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.DEEPSLATE_LAPIS_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_LAPIS_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.DEEPSLATE_REDSTONE_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_REDSTONE_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		event.insertAfter(Items.WARPED_STEM.getDefaultInstance(), CeilandsItems.CEILTRUNK_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_LOG.getDefaultInstance(), CeilandsItems.LUZAWOOD_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.FLOWERING_AZALEA_LEAVES.getDefaultInstance(), CeilandsItems.CEILTRUNK_LEAVES.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_LEAVES.getDefaultInstance(), CeilandsItems.LUZAWOOD_LEAVES.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(Items.CHERRY_SAPLING.getDefaultInstance(), CeilandsItems.CEILTRUNK_SAPLING.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_SAPLING.getDefaultInstance(), CeilandsItems.LUZAWOOD_SAPLING.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (tabKey == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
    		event.insertAfter(Items.WARPED_HANGING_SIGN.getDefaultInstance(), CeilandsItems.CEILTRUNK_SIGN.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_SIGN.getDefaultInstance(), CeilandsItems.CEILTRUNK_HANGING_SIGN.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_HANGING_SIGN.getDefaultInstance(), CeilandsItems.LUZAWOOD_SIGN.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_SIGN.getDefaultInstance(), CeilandsItems.LUZAWOOD_HANGING_SIGN.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (tabKey == CreativeModeTabs.REDSTONE_BLOCKS) {
    		// Nothing here currently...
    	}
    	if (tabKey == CreativeModeTabs.TOOLS_AND_UTILITIES) {
    		event.insertAfter(CompatsNeoForge.BOATLOAD_INSTALLED ? BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("boatload", "large_warped_boat")).getDefaultInstance() : Items.CHERRY_CHEST_BOAT.getDefaultInstance(), CeilandsItems.CEILTRUNK_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_BOAT.getDefaultInstance(), CeilandsItems.CEILTRUNK_CHEST_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.CEILTRUNK_CHEST_BOAT.getDefaultInstance(), CeilandsItems.LUZAWOOD_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.insertAfter(CeilandsItems.LUZAWOOD_BOAT.getDefaultInstance(), CeilandsItems.LUZAWOOD_CHEST_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		event.accept(CeilandsItems.CEILANDS_PORTAL_ACTIVATOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
	}
}
