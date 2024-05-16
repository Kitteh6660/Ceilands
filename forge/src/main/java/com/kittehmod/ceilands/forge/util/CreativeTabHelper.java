package com.kittehmod.ceilands.forge.util;

import com.kittehmod.ceilands.forge.CompatsForge;
import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabHelper 
{
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		MutableHashedLinkedMap<ItemStack, TabVisibility> map = event.getEntries();
    	// Insert into vanilla tabs.
    	if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
    		map.putAfter(Items.PURPUR_SLAB.getDefaultInstance(), CeilandsItems.CEILINGNEOUS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILINGNEOUS.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILINGNEOUS_STAIRS.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILINGNEOUS_SLAB.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_WALL.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILINGNEOUS_WALL.getDefaultInstance(), CeilandsItems.CHISELED_CEILINGNEOUS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CHISELED_CEILINGNEOUS.getDefaultInstance(), CeilandsItems.POLISHED_CEILINGNEOUS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.POLISHED_CEILINGNEOUS.getDefaultInstance(), CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.POLISHED_CEILINGNEOUS_STAIRS.getDefaultInstance(), CeilandsItems.POLISHED_CEILINGNEOUS_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.POLISHED_CEILINGNEOUS_SLAB.getDefaultInstance(), CeilandsItems.POLISHED_CEILINGNEOUS_WALL.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.POLISHED_CEILINGNEOUS_WALL.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_BRICKS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILINGNEOUS_BRICKS.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_BRICK_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILINGNEOUS_BRICK_STAIRS.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_BRICK_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILINGNEOUS_BRICK_SLAB.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_BRICK_WALL.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILINGNEOUS_BRICK_WALL.getDefaultInstance(), CeilandsItems.CRACKED_CEILINGNEOUS_BRICKS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		map.putAfter(Items.WARPED_BUTTON.getDefaultInstance(), CeilandsItems.CEILTRUNK_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_LOG.getDefaultInstance(), CeilandsItems.CEILTRUNK_WOOD.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_WOOD.getDefaultInstance(), CeilandsItems.STRIPPED_CEILTRUNK_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.STRIPPED_CEILTRUNK_LOG.getDefaultInstance(), CeilandsItems.STRIPPED_CEILTRUNK_WOOD.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.STRIPPED_CEILTRUNK_WOOD.getDefaultInstance(), CeilandsItems.CEILTRUNK_PLANKS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_PLANKS.getDefaultInstance(), CeilandsItems.CEILTRUNK_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_STAIRS.getDefaultInstance(), CeilandsItems.CEILTRUNK_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_SLAB.getDefaultInstance(), CeilandsItems.CEILTRUNK_FENCE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_FENCE.getDefaultInstance(), CeilandsItems.CEILTRUNK_FENCE_GATE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_FENCE_GATE.getDefaultInstance(), CeilandsItems.CEILTRUNK_DOOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_DOOR.getDefaultInstance(), CeilandsItems.CEILTRUNK_TRAPDOOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_TRAPDOOR.getDefaultInstance(), CeilandsItems.CEILTRUNK_PRESSURE_PLATE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_PRESSURE_PLATE.getDefaultInstance(), CeilandsItems.CEILTRUNK_BUTTON.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		map.putAfter(CeilandsItems.CEILTRUNK_BUTTON.getDefaultInstance(), CeilandsItems.LUZAWOOD_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_LOG.getDefaultInstance(), CeilandsItems.LUZAWOOD_WOOD.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_WOOD.getDefaultInstance(), CeilandsItems.STRIPPED_LUZAWOOD_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.STRIPPED_LUZAWOOD_LOG.getDefaultInstance(), CeilandsItems.STRIPPED_LUZAWOOD_WOOD.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.STRIPPED_LUZAWOOD_WOOD.getDefaultInstance(), CeilandsItems.LUZAWOOD_PLANKS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_PLANKS.getDefaultInstance(), CeilandsItems.LUZAWOOD_STAIRS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_STAIRS.getDefaultInstance(), CeilandsItems.LUZAWOOD_SLAB.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_SLAB.getDefaultInstance(), CeilandsItems.LUZAWOOD_FENCE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_FENCE.getDefaultInstance(), CeilandsItems.LUZAWOOD_FENCE_GATE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_FENCE_GATE.getDefaultInstance(), CeilandsItems.LUZAWOOD_DOOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_DOOR.getDefaultInstance(), CeilandsItems.LUZAWOOD_TRAPDOOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_TRAPDOOR.getDefaultInstance(), CeilandsItems.LUZAWOOD_PRESSURE_PLATE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_PRESSURE_PLATE.getDefaultInstance(), CeilandsItems.LUZAWOOD_BUTTON.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
    		map.putAfter(Items.END_STONE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);

    		map.putAfter(Items.DEEPSLATE_COAL_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_COAL_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_COPPER_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_COPPER_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_IRON_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_IRON_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_GOLD_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_GOLD_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_DIAMOND_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_DIAMOND_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_EMERALD_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_EMERALD_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_LAPIS_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_LAPIS_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_REDSTONE_ORE.getDefaultInstance(), CeilandsItems.CEILINGNEOUS_REDSTONE_ORE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		map.putAfter(Items.WARPED_STEM.getDefaultInstance(), CeilandsItems.CEILTRUNK_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_LOG.getDefaultInstance(), CeilandsItems.LUZAWOOD_LOG.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.FLOWERING_AZALEA_LEAVES.getDefaultInstance(), CeilandsItems.CEILTRUNK_LEAVES.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_LEAVES.getDefaultInstance(), CeilandsItems.LUZAWOOD_LEAVES.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.CHERRY_SAPLING.getDefaultInstance(), CeilandsItems.CEILTRUNK_SAPLING.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_SAPLING.getDefaultInstance(), CeilandsItems.LUZAWOOD_SAPLING.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
    		map.putAfter(Items.WARPED_HANGING_SIGN.getDefaultInstance(), CeilandsItems.CEILTRUNK_SIGN.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_SIGN.getDefaultInstance(), CeilandsItems.CEILTRUNK_HANGING_SIGN.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_HANGING_SIGN.getDefaultInstance(), CeilandsItems.LUZAWOOD_SIGN.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_SIGN.getDefaultInstance(), CeilandsItems.LUZAWOOD_HANGING_SIGN.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
    		// Nothing here currently...
    	}
    	if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
    		map.putAfter(CompatsForge.BOATLOAD_INSTALLED ? ForgeRegistries.ITEMS.getValue(new ResourceLocation("boatload", "large_warped_boat")).getDefaultInstance() : Items.CHERRY_CHEST_BOAT.getDefaultInstance(), CeilandsItems.CEILTRUNK_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_BOAT.getDefaultInstance(), CeilandsItems.CEILTRUNK_CHEST_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.CEILTRUNK_CHEST_BOAT.getDefaultInstance(), CeilandsItems.LUZAWOOD_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CeilandsItems.LUZAWOOD_BOAT.getDefaultInstance(), CeilandsItems.LUZAWOOD_CHEST_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.put(CeilandsItems.CEILANDS_PORTAL_ACTIVATOR.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
	}
}
