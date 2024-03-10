package com.kittehmod.ceilands.item;

import com.kittehmod.ceilands.CeilandsMod;
import com.kittehmod.ceilands.block.CeilandsBlocks;
import com.kittehmod.ceilands.entity.ModBoat;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CeilandsItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CeilandsMod.MODID);

    public static final RegistryObject<Item> CEILANDS_PORTAL_ACTIVATOR = ITEMS.register("ceilands_portal_activator", () -> new CeilandsPortalActivatorItem(new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> CEILINGNEOUS = ITEMS.register("ceilingneous", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_STAIRS = ITEMS.register("ceilingneous_stairs", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_SLAB = ITEMS.register("ceilingneous_slab", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_WALL = ITEMS.register("ceilingneous_wall", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_WALL.get(), new Item.Properties()));

	public static final RegistryObject<Item> POLISHED_CEILINGNEOUS = ITEMS.register("polished_ceilingneous", () -> new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS.get(), new Item.Properties()));
	public static final RegistryObject<Item> POLISHED_CEILINGNEOUS_STAIRS = ITEMS.register("polished_ceilingneous_stairs", () -> new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> POLISHED_CEILINGNEOUS_SLAB = ITEMS.register("polished_ceilingneous_slab", () -> new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> POLISHED_CEILINGNEOUS_WALL = ITEMS.register("polished_ceilingneous_wall", () -> new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_WALL.get(), new Item.Properties()));

	public static final RegistryObject<Item> CEILINGNEOUS_BRICK = ITEMS.register("ceilingneous_bricks", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICKS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_BRICK_STAIRS = ITEMS.register("ceilingneous_brick_stairs", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_BRICK_SLAB = ITEMS.register("ceilingneous_brick_slab", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_BRICK_WALL = ITEMS.register("ceilingneous_brick_wall", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_WALL.get(), new Item.Properties()));

	public static final RegistryObject<Item> CRACKED_CEILINGNEOUS_BRICK = ITEMS.register("cracked_ceilingneous_bricks", () -> new BlockItem(CeilandsBlocks.CRACKED_CEILINGNEOUS_BRICKS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHISELED_CEILINGNEOUS = ITEMS.register("chiseled_ceilingneous", () -> new BlockItem(CeilandsBlocks.CHISELED_CEILINGNEOUS.get(), new Item.Properties()));

	public static final RegistryObject<Item> CEILINGNEOUS_BUTTON = ITEMS.register("ceilingneous_button", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_PRESSURE_PLATE = ITEMS.register("ceilingneous_pressure_plate", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_PRESSURE_PLATE.get(), new Item.Properties()));

	public static final RegistryObject<Item> CEILINGNEOUS_COAL_ORE = ITEMS.register("ceilingneous_coal_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_COAL_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_COPPER_ORE = ITEMS.register("ceilingneous_copper_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_COPPER_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_IRON_ORE = ITEMS.register("ceilingneous_iron_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_IRON_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_GOLD_ORE = ITEMS.register("ceilingneous_gold_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_GOLD_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_DIAMOND_ORE = ITEMS.register("ceilingneous_diamond_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_DIAMOND_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_REDSTONE_ORE = ITEMS.register("ceilingneous_redstone_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_REDSTONE_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_LAPIS_ORE = ITEMS.register("ceilingneous_lapis_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_LAPIS_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILINGNEOUS_EMERALD_ORE = ITEMS.register("ceilingneous_emerald_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_EMERALD_ORE.get(), new Item.Properties()));

	public static final RegistryObject<Item> CEILTRUNK_LOG = ITEMS.register("ceiltrunk_log", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_LOG.get(), new Item.Properties()));
	public static final RegistryObject<Item> STRIPPED_CEILTRUNK_LOG = ITEMS.register("stripped_ceiltrunk_log", () -> new BlockItem(CeilandsBlocks.STRIPPED_CEILTRUNK_LOG.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_WOOD = ITEMS.register("ceiltrunk_wood", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<Item> STRIPPED_CEILTRUNK_WOOD = ITEMS.register("stripped_ceiltrunk_wood", () -> new BlockItem(CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_LEAVES = ITEMS.register("ceiltrunk_leaves", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_SAPLING = ITEMS.register("ceiltrunk_sapling", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_PLANKS = ITEMS.register("ceiltrunk_planks", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_PLANKS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_STAIRS = ITEMS.register("ceiltrunk_stairs", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_SLAB = ITEMS.register("ceiltrunk_slab", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_FENCE = ITEMS.register("ceiltrunk_fence", () -> new FurnaceFuellableBlockItem(CeilandsBlocks.CEILTRUNK_FENCE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> CEILTRUNK_FENCE_GATE = ITEMS.register("ceiltrunk_fence_gate", () -> new FurnaceFuellableBlockItem(CeilandsBlocks.CEILTRUNK_FENCE_GATE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> CEILTRUNK_DOOR = ITEMS.register("ceiltrunk_door", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_TRAPDOOR = ITEMS.register("ceiltrunk_trapdoor", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_BUTTON = ITEMS.register("ceiltrunk_button", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_PRESSURE_PLATE = ITEMS.register("ceiltrunk_pressure_plate", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_PRESSURE_PLATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CEILTRUNK_SIGN = ITEMS.register("ceiltrunk_sign", () -> new SignItem(new Item.Properties().stacksTo(16), CeilandsBlocks.CEILTRUNK_SIGN.get(), CeilandsBlocks.CEILTRUNK_WALL_SIGN.get()));
	public static final RegistryObject<Item> CEILTRUNK_HANGING_SIGN = ITEMS.register("ceiltrunk_hanging_sign", () -> new HangingSignItem(CeilandsBlocks.CEILTRUNK_HANGING_SIGN.get(), CeilandsBlocks.CEILTRUNK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
	public static final RegistryObject<Item> CEILTRUNK_BOAT = ITEMS.register("ceiltrunk_boat", () -> new ModBoatItem(false, ModBoat.Type.CEILTRUNK, new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CEILTRUNK_CHEST_BOAT = ITEMS.register("ceiltrunk_chest_boat", () -> new ModBoatItem(true, ModBoat.Type.CEILTRUNK, new Item.Properties().stacksTo(1)));
	
	public static final RegistryObject<Item> LUZAWOOD_LOG = ITEMS.register("luzawood_log", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_LOG.get(), new Item.Properties()));
	public static final RegistryObject<Item> STRIPPED_LUZAWOOD_LOG = ITEMS.register("stripped_luzawood_log", () -> new BlockItem(CeilandsBlocks.STRIPPED_LUZAWOOD_LOG.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_WOOD = ITEMS.register("luzawood_wood", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<Item> STRIPPED_LUZAWOOD_WOOD = ITEMS.register("stripped_luzawood_wood", () -> new BlockItem(CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_LEAVES = ITEMS.register("luzawood_leaves", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_SAPLING = ITEMS.register("luzawood_sapling", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_PLANKS = ITEMS.register("luzawood_planks", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_PLANKS.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_STAIRS = ITEMS.register("luzawood_stairs", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_SLAB = ITEMS.register("luzawood_slab", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_FENCE = ITEMS.register("luzawood_fence", () -> new FurnaceFuellableBlockItem(CeilandsBlocks.LUZAWOOD_FENCE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> LUZAWOOD_FENCE_GATE = ITEMS.register("luzawood_fence_gate", () -> new FurnaceFuellableBlockItem(CeilandsBlocks.LUZAWOOD_FENCE_GATE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> LUZAWOOD_DOOR = ITEMS.register("luzawood_door", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_TRAPDOOR = ITEMS.register("luzawood_trapdoor", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_BUTTON = ITEMS.register("luzawood_button", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_PRESSURE_PLATE = ITEMS.register("luzawood_pressure_plate", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_PRESSURE_PLATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> LUZAWOOD_SIGN = ITEMS.register("luzawood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), CeilandsBlocks.LUZAWOOD_SIGN.get(), CeilandsBlocks.LUZAWOOD_WALL_SIGN.get()));
	public static final RegistryObject<Item> LUZAWOOD_HANGING_SIGN = ITEMS.register("luzawood_hanging_sign", () -> new HangingSignItem(CeilandsBlocks.LUZAWOOD_HANGING_SIGN.get(), CeilandsBlocks.LUZAWOOD_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
	public static final RegistryObject<Item> LUZAWOOD_BOAT = ITEMS.register("luzawood_boat", () -> new ModBoatItem(false, ModBoat.Type.LUZAWOOD, new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LUZAWOOD_CHEST_BOAT = ITEMS.register("luzawood_chest_boat", () -> new ModBoatItem(true, ModBoat.Type.LUZAWOOD, new Item.Properties().stacksTo(1)));

	@SubscribeEvent
	public static void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		MutableHashedLinkedMap<ItemStack, TabVisibility> map = event.getEntries();
    	// Insert into vanilla tabs.
    	if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
    		map.putAfter(Items.PURPUR_SLAB.getDefaultInstance(), CEILINGNEOUS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILINGNEOUS.get().getDefaultInstance(), CEILINGNEOUS_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILINGNEOUS_STAIRS.get().getDefaultInstance(), CEILINGNEOUS_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILINGNEOUS_SLAB.get().getDefaultInstance(), CEILINGNEOUS_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILINGNEOUS_WALL.get().getDefaultInstance(), CHISELED_CEILINGNEOUS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CHISELED_CEILINGNEOUS.get().getDefaultInstance(), POLISHED_CEILINGNEOUS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(POLISHED_CEILINGNEOUS.get().getDefaultInstance(), POLISHED_CEILINGNEOUS_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(POLISHED_CEILINGNEOUS_STAIRS.get().getDefaultInstance(), POLISHED_CEILINGNEOUS_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(POLISHED_CEILINGNEOUS_SLAB.get().getDefaultInstance(), POLISHED_CEILINGNEOUS_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(POLISHED_CEILINGNEOUS_WALL.get().getDefaultInstance(), CEILINGNEOUS_BRICK.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILINGNEOUS_BRICK.get().getDefaultInstance(), CEILINGNEOUS_BRICK_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILINGNEOUS_BRICK_STAIRS.get().getDefaultInstance(), CEILINGNEOUS_BRICK_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILINGNEOUS_BRICK_SLAB.get().getDefaultInstance(), CEILINGNEOUS_BRICK_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILINGNEOUS_BRICK_WALL.get().getDefaultInstance(), CRACKED_CEILINGNEOUS_BRICK.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		map.putAfter(Items.WARPED_BUTTON.getDefaultInstance(), CEILTRUNK_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_LOG.get().getDefaultInstance(), CEILTRUNK_WOOD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_WOOD.get().getDefaultInstance(), STRIPPED_CEILTRUNK_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(STRIPPED_CEILTRUNK_LOG.get().getDefaultInstance(), STRIPPED_CEILTRUNK_WOOD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(STRIPPED_CEILTRUNK_WOOD.get().getDefaultInstance(), CEILTRUNK_PLANKS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_PLANKS.get().getDefaultInstance(), CEILTRUNK_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_STAIRS.get().getDefaultInstance(), CEILTRUNK_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_SLAB.get().getDefaultInstance(), CEILTRUNK_FENCE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_FENCE.get().getDefaultInstance(), CEILTRUNK_FENCE_GATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_FENCE_GATE.get().getDefaultInstance(), CEILTRUNK_DOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_DOOR.get().getDefaultInstance(), CEILTRUNK_TRAPDOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_TRAPDOOR.get().getDefaultInstance(), CEILTRUNK_PRESSURE_PLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_PRESSURE_PLATE.get().getDefaultInstance(), CEILTRUNK_BUTTON.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		map.putAfter(CEILTRUNK_BUTTON.get().getDefaultInstance(), LUZAWOOD_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_LOG.get().getDefaultInstance(), LUZAWOOD_WOOD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_WOOD.get().getDefaultInstance(), STRIPPED_LUZAWOOD_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(STRIPPED_LUZAWOOD_LOG.get().getDefaultInstance(), STRIPPED_LUZAWOOD_WOOD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(STRIPPED_LUZAWOOD_WOOD.get().getDefaultInstance(), LUZAWOOD_PLANKS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_PLANKS.get().getDefaultInstance(), LUZAWOOD_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_STAIRS.get().getDefaultInstance(), LUZAWOOD_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_SLAB.get().getDefaultInstance(), LUZAWOOD_FENCE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_FENCE.get().getDefaultInstance(), LUZAWOOD_FENCE_GATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_FENCE_GATE.get().getDefaultInstance(), LUZAWOOD_DOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_DOOR.get().getDefaultInstance(), LUZAWOOD_TRAPDOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_TRAPDOOR.get().getDefaultInstance(), LUZAWOOD_PRESSURE_PLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_PRESSURE_PLATE.get().getDefaultInstance(), LUZAWOOD_BUTTON.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
    		map.putAfter(Items.END_STONE.getDefaultInstance(), CEILINGNEOUS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);

    		map.putAfter(Items.DEEPSLATE_COAL_ORE.getDefaultInstance(), CEILINGNEOUS_COAL_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_COPPER_ORE.getDefaultInstance(), CEILINGNEOUS_COPPER_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_IRON_ORE.getDefaultInstance(), CEILINGNEOUS_IRON_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_GOLD_ORE.getDefaultInstance(), CEILINGNEOUS_GOLD_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_DIAMOND_ORE.getDefaultInstance(), CEILINGNEOUS_DIAMOND_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_EMERALD_ORE.getDefaultInstance(), CEILINGNEOUS_EMERALD_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_LAPIS_ORE.getDefaultInstance(), CEILINGNEOUS_LAPIS_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_REDSTONE_ORE.getDefaultInstance(), CEILINGNEOUS_REDSTONE_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		
    		map.putAfter(Items.WARPED_STEM.getDefaultInstance(), CEILTRUNK_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_LOG.get().getDefaultInstance(), LUZAWOOD_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.FLOWERING_AZALEA_LEAVES.getDefaultInstance(), CEILTRUNK_LEAVES.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_LEAVES.get().getDefaultInstance(), LUZAWOOD_LEAVES.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.CHERRY_SAPLING.getDefaultInstance(), CEILTRUNK_SAPLING.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_SAPLING.get().getDefaultInstance(), LUZAWOOD_SAPLING.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
    		map.putAfter(Items.WARPED_HANGING_SIGN.getDefaultInstance(), CEILTRUNK_SIGN.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_SIGN.get().getDefaultInstance(), CEILTRUNK_HANGING_SIGN.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_HANGING_SIGN.get().getDefaultInstance(), LUZAWOOD_SIGN.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_SIGN.get().getDefaultInstance(), LUZAWOOD_HANGING_SIGN.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
    		map.putAfter(Items.CHERRY_CHEST_BOAT.getDefaultInstance(), CEILTRUNK_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_BOAT.get().getDefaultInstance(), CEILTRUNK_CHEST_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CEILTRUNK_CHEST_BOAT.get().getDefaultInstance(), LUZAWOOD_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(LUZAWOOD_BOAT.get().getDefaultInstance(), LUZAWOOD_CHEST_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.put(CEILANDS_PORTAL_ACTIVATOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
	}
}
