package com.kittehmod.ceilands.forge.util;

import com.kittehmod.ceilands.forge.CompatsForge;
import com.kittehmod.ceilands.registry.CeilandsItems;
import com.kittehmod.ceilands.util.CreativeModeTabDatabase;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import oshi.util.tuples.Quartet;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabHelper 
{
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
		MutableHashedLinkedMap<ItemStack, TabVisibility> entries = event.getEntries();
    	// Insert into vanilla tabs.
    	if (tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
    		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.BUILDING_BLOCKS) {
    			if (quad.getA() == null) {
    				event.accept(quad.getB());
    				continue;
    			}
    			if (quad.getD()) {
    				entries.putAfter(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());
    			}
    			else {
    				entries.putBefore(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());    				
    			}
    		}
    		if (CompatsForge.DRAMATIC_DOORS_INSTALLED) {
    			entries.putBefore(CeilandsItems.CEILTRUNK_DOOR.getDefaultInstance(), BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "short_ceiltrunk_door")).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
        		entries.putAfter(CeilandsItems.CEILTRUNK_DOOR.getDefaultInstance(), BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "tall_ceiltrunk_door")).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
        		entries.putBefore(CeilandsItems.LUZAWOOD_DOOR.getDefaultInstance(), BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "short_luzawood_door")).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
        		entries.putAfter(CeilandsItems.LUZAWOOD_DOOR.getDefaultInstance(), BuiltInRegistries.ITEM.get(new ResourceLocation("dramaticdoors", "tall_luzawood_door")).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (tabKey == CreativeModeTabs.NATURAL_BLOCKS) {
    		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.NATURAL_BLOCKS) {
    			if (quad.getA() == null) {
    				event.accept(quad.getB());
    				continue;
    			}
    			if (quad.getD()) {
    				entries.putAfter(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());
    			}
    			else {
    				entries.putBefore(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());    				
    			}
    		}
    	}
    	if (tabKey == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
    		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.FUNCTIONAL_BLOCKS) {
    			if (quad.getA() == null) {
    				event.accept(quad.getB());
    				continue;
    			}
    			if (quad.getD()) {
    				entries.putAfter(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());
    			}
    			else {
    				entries.putBefore(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());    				
    			}
    		}
    	}
    	if (tabKey == CreativeModeTabs.REDSTONE_BLOCKS) {
    		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.REDSTONE_BLOCKS) {
    			if (quad.getA() == null) {
    				event.accept(quad.getB());
    				continue;
    			}
    			if (quad.getD()) {
    				entries.putAfter(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());
    			}
    			else {
    				entries.putBefore(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());    				
    			}
    		}
    	}
    	if (tabKey == CreativeModeTabs.TOOLS_AND_UTILITIES) {
    		entries.putAfter(CompatsForge.BOATLOAD_INSTALLED ? BuiltInRegistries.ITEM.get(new ResourceLocation("boatload", "large_warped_boat")).getDefaultInstance() : Items.CHERRY_CHEST_BOAT.getDefaultInstance(), CeilandsItems.CEILTRUNK_BOAT.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.TOOLS_AND_UTILITIES) {
    			if (quad.getA() == null) {
    				event.accept(quad.getB());
    				continue;
    			}
    			if (quad.getD()) {
    				entries.putAfter(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());
    			}
    			else {
    				entries.putBefore(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());    				
    			}
    		}
    	}
    	if (tabKey == CreativeModeTabs.COMBAT) {
    		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.COMBAT) {
    			if (quad.getA() == null) {
    				event.accept(quad.getB());
    				continue;
    			}
    			if (quad.getD()) {
    				entries.putAfter(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());
    			}
    			else {
    				entries.putBefore(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());    				
    			}
    		}
    	}
    	if (tabKey == CreativeModeTabs.INGREDIENTS) {
    		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.INGREDIENTS) {
    			if (quad.getA() == null) {
    				event.accept(quad.getB());
    				continue;
    			}
    			if (quad.getD()) {
    				entries.putAfter(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());
    			}
    			else {
    				entries.putBefore(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());    				
    			}
    		}
    	}
    	if (tabKey == CreativeModeTabs.SPAWN_EGGS) {
    		for (Quartet<Item, Item, TabVisibility, Boolean> quad : CreativeModeTabDatabase.SPAWN_EGGS) {
    			if (quad.getA() == null) {
    				event.accept(quad.getB());
    				continue;
    			}
    			if (quad.getD()) {
    				entries.putAfter(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());
    			}
    			else {
    				entries.putBefore(quad.getA().getDefaultInstance(), quad.getB().getDefaultInstance(), quad.getC());    				
    			}
    		}
    	}
	}
}
