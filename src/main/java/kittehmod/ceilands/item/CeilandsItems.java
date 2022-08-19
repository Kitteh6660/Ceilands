package kittehmod.ceilands.item;

import kittehmod.ceilands.CeilandsMod;
import kittehmod.ceilands.block.CeilandsBlocks;
import kittehmod.ceilands.entity.ModBoat;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CeilandsItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CeilandsMod.MODID);

    public static final RegistryObject<Item> CEILANDS_PORTAL_ACTIVATOR = ITEMS.register("ceilands_portal_activator", () -> new CeilandsPortalActivatorItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));

	public static final RegistryObject<Item> CEILINGNEOUS = ITEMS.register("ceilingneous", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_STAIRS = ITEMS.register("ceilingneous_stairs", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_SLAB = ITEMS.register("ceilingneous_slab", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_WALL = ITEMS.register("ceilingneous_wall", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

	public static final RegistryObject<Item> POLISHED_CEILINGNEOUS = ITEMS.register("polished_ceilingneous", () -> new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> POLISHED_CEILINGNEOUS_STAIRS = ITEMS.register("polished_ceilingneous_stairs", () -> new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> POLISHED_CEILINGNEOUS_SLAB = ITEMS.register("polished_ceilingneous_slab", () -> new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> POLISHED_CEILINGNEOUS_WALL = ITEMS.register("polished_ceilingneous_wall", () -> new BlockItem(CeilandsBlocks.POLISHED_CEILINGNEOUS_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

	public static final RegistryObject<Item> CEILINGNEOUS_BRICK = ITEMS.register("ceilingneous_bricks", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_BRICK_STAIRS = ITEMS.register("ceilingneous_brick_stairs", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_BRICK_SLAB = ITEMS.register("ceilingneous_brick_slab", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_BRICK_WALL = ITEMS.register("ceilingneous_brick_wall", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

	public static final RegistryObject<Item> CRACKED_CEILINGNEOUS_BRICK = ITEMS.register("cracked_ceilingneous_bricks", () -> new BlockItem(CeilandsBlocks.CRACKED_CEILINGNEOUS_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CHISELED_CEILINGNEOUS = ITEMS.register("chiseled_ceilingneous", () -> new BlockItem(CeilandsBlocks.CHISELED_CEILINGNEOUS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> CEILINGNEOUS_BUTTON = ITEMS.register("ceilingneous_button", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> CEILINGNEOUS_PRESSURE_PLATE = ITEMS.register("ceilingneous_pressure_plate", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_PRESSURE_PLATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

	public static final RegistryObject<Item> CEILINGNEOUS_COAL_ORE = ITEMS.register("ceilingneous_coal_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_COAL_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_COPPER_ORE = ITEMS.register("ceilingneous_copper_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_COPPER_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_IRON_ORE = ITEMS.register("ceilingneous_iron_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_IRON_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_GOLD_ORE = ITEMS.register("ceilingneous_gold_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_GOLD_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_DIAMOND_ORE = ITEMS.register("ceilingneous_diamond_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_DIAMOND_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_REDSTONE_ORE = ITEMS.register("ceilingneous_redstone_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_REDSTONE_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_LAPIS_ORE = ITEMS.register("ceilingneous_lapis_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_LAPIS_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILINGNEOUS_EMERALD_ORE = ITEMS.register("ceilingneous_emerald_ore", () -> new BlockItem(CeilandsBlocks.CEILINGNEOUS_EMERALD_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> CEILTRUNK_LOG = ITEMS.register("ceiltrunk_log", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_CEILTRUNK_LOG = ITEMS.register("stripped_ceiltrunk_log", () -> new BlockItem(CeilandsBlocks.STRIPPED_CEILTRUNK_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILTRUNK_WOOD = ITEMS.register("ceiltrunk_wood", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_CEILTRUNK_WOOD = ITEMS.register("stripped_ceiltrunk_wood", () -> new BlockItem(CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILTRUNK_LEAVES = ITEMS.register("ceiltrunk_leaves", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> CEILTRUNK_SAPLING = ITEMS.register("ceiltrunk_sapling", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_SAPLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> CEILTRUNK_PLANKS = ITEMS.register("ceiltrunk_planks", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILTRUNK_STAIRS = ITEMS.register("ceiltrunk_stairs", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILTRUNK_SLAB = ITEMS.register("ceiltrunk_slab", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CEILTRUNK_FENCE = ITEMS.register("ceiltrunk_fence", () -> new FurnaceFuellableBlockItem(CeilandsBlocks.CEILTRUNK_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS), 300));
	public static final RegistryObject<Item> CEILTRUNK_FENCE_GATE = ITEMS.register("ceiltrunk_fence_gate", () -> new FurnaceFuellableBlockItem(CeilandsBlocks.CEILTRUNK_FENCE_GATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE), 300));
	public static final RegistryObject<Item> CEILTRUNK_DOOR = ITEMS.register("ceiltrunk_door", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> CEILTRUNK_TRAPDOOR = ITEMS.register("ceiltrunk_trapdoor", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> CEILTRUNK_BUTTON = ITEMS.register("ceiltrunk_button", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> CEILTRUNK_PRESSURE_PLATE = ITEMS.register("ceiltrunk_pressure_plate", () -> new BlockItem(CeilandsBlocks.CEILTRUNK_PRESSURE_PLATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> CEILTRUNK_SIGN = ITEMS.register("ceiltrunk_sign", () -> new SignItem(new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS).stacksTo(16), CeilandsBlocks.CEILTRUNK_SIGN.get(), CeilandsBlocks.CEILTRUNK_WALL_SIGN.get()));
	public static final RegistryObject<Item> CEILTRUNK_BOAT = ITEMS.register("ceiltrunk_boat", () -> new ModBoatItem(false, ModBoat.Type.CEILTRUNK, new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1)));
	public static final RegistryObject<Item> CEILTRUNK_CHEST_BOAT = ITEMS.register("ceiltrunk_chest_boat", () -> new ModBoatItem(true, ModBoat.Type.CEILTRUNK, new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1)));
	
	public static final RegistryObject<Item> LUZAWOOD_LOG = ITEMS.register("luzawood_log", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_LUZAWOOD_LOG = ITEMS.register("stripped_luzawood_log", () -> new BlockItem(CeilandsBlocks.STRIPPED_LUZAWOOD_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUZAWOOD_WOOD = ITEMS.register("luzawood_wood", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_LUZAWOOD_WOOD = ITEMS.register("stripped_luzawood_wood", () -> new BlockItem(CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUZAWOOD_LEAVES = ITEMS.register("luzawood_leaves", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> LUZAWOOD_SAPLING = ITEMS.register("luzawood_sapling", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_SAPLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> LUZAWOOD_PLANKS = ITEMS.register("luzawood_planks", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUZAWOOD_STAIRS = ITEMS.register("luzawood_stairs", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUZAWOOD_SLAB = ITEMS.register("luzawood_slab", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUZAWOOD_FENCE = ITEMS.register("luzawood_fence", () -> new FurnaceFuellableBlockItem(CeilandsBlocks.LUZAWOOD_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS), 300));
	public static final RegistryObject<Item> LUZAWOOD_FENCE_GATE = ITEMS.register("luzawood_fence_gate", () -> new FurnaceFuellableBlockItem(CeilandsBlocks.LUZAWOOD_FENCE_GATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE), 300));
	public static final RegistryObject<Item> LUZAWOOD_DOOR = ITEMS.register("luzawood_door", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> LUZAWOOD_TRAPDOOR = ITEMS.register("luzawood_trapdoor", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> LUZAWOOD_BUTTON = ITEMS.register("luzawood_button", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> LUZAWOOD_PRESSURE_PLATE = ITEMS.register("luzawood_pressure_plate", () -> new BlockItem(CeilandsBlocks.LUZAWOOD_PRESSURE_PLATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> LUZAWOOD_SIGN = ITEMS.register("luzawood_sign", () -> new SignItem(new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS).stacksTo(16), CeilandsBlocks.LUZAWOOD_SIGN.get(), CeilandsBlocks.LUZAWOOD_WALL_SIGN.get()));
	public static final RegistryObject<Item> LUZAWOOD_BOAT = ITEMS.register("luzawood_boat", () -> new ModBoatItem(false, ModBoat.Type.LUZAWOOD, new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1)));
	public static final RegistryObject<Item> LUZAWOOD_CHEST_BOAT = ITEMS.register("luzawood_chest_boat", () -> new ModBoatItem(true, ModBoat.Type.LUZAWOOD, new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1)));

}
