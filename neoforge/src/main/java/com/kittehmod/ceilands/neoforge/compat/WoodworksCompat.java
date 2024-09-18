package com.kittehmod.ceilands.neoforge.compat;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.neoforge.CeilandsRegistry;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsItems;
/*import com.teamabnormals.blueprint.client.BlueprintChestMaterials;
import com.teamabnormals.blueprint.client.renderer.block.ChestBlockEntityWithoutLevelRenderer;
import com.teamabnormals.blueprint.common.block.BlueprintBeehiveBlock;
import com.teamabnormals.blueprint.common.block.BlueprintChiseledBookShelfBlock;
import com.teamabnormals.blueprint.common.block.LeafPileBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.entity.BlueprintChestBlockEntity;
import com.teamabnormals.blueprint.common.block.entity.BlueprintTrappedChestBlockEntity;
import com.teamabnormals.blueprint.common.item.BEWLRBlockItem;
import com.teamabnormals.woodworks.core.registry.WoodworksBlocks;*/

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

// To be re-implemented when Blueprint gets updated to 1.21.
public class WoodworksCompat 
{
	/*public static final ResourceLocation CEILTRUNK_BOARDS_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_boards");
	public static final ResourceLocation CEILTRUNK_BEEHIVE_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_beehive");
	public static final ResourceLocation CEILTRUNK_CHEST_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_chest");
	public static final ResourceLocation CEILTRUNK_TRAPPED_CHEST_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "trapped_ceiltrunk_chest");
	public static final ResourceLocation CEILTRUNK_LADDER_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_ladder");
	public static final ResourceLocation CEILTRUNK_BOOKSHELF_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_bookshelf");
	public static final ResourceLocation CEILTRUNK_CHISELED_BOOKSHELF_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "chiseled_ceiltrunk_bookshelf");
	public static final ResourceLocation CEILTRUNK_LEAF_PILE_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_leaf_pile");
	public static final ResourceLocation LUZAWOOD_BOARDS_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_boards");
	public static final ResourceLocation LUZAWOOD_BEEHIVE_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_beehive");
	public static final ResourceLocation LUZAWOOD_CHEST_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_chest");
	public static final ResourceLocation LUZAWOOD_TRAPPED_CHEST_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "trapped_luzawood_chest");
	public static final ResourceLocation LUZAWOOD_LADDER_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_ladder");
	public static final ResourceLocation LUZAWOOD_BOOKSHELF_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_bookshelf");
	public static final ResourceLocation LUZAWOOD_CHISELED_BOOKSHELF_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "chiseled_luzawood_bookshelf");
	public static final ResourceLocation LUZAWOOD_LEAF_PILE_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_leaf_pile");

	public WoodworksCompat(boolean register) {
		if (!register) {
			return;
		}
		Block CEILTRUNK_BOARDS = new RotatedPillarBlock(Properties.ofFullCopy(CeilandsBlocks.CEILTRUNK_PLANKS));
		Block CEILTRUNK_BEEHIVE = new BlueprintBeehiveBlock(Properties.ofFullCopy(Blocks.BEEHIVE));
		Block CEILTRUNK_CHEST = new BlueprintChestBlock("ceilands:ceiltrunk_normal", Properties.ofFullCopy(Blocks.CHEST));
		Block TRAPPED_CEILTRUNK_CHEST = new BlueprintTrappedChestBlock("ceilands:ceiltrunk_trapped", Properties.ofFullCopy(Blocks.TRAPPED_CHEST));
		Block CEILTRUNK_LADDER = new LadderBlock(Properties.ofFullCopy(Blocks.LADDER));
		Block CEILTRUNK_BOOKSHELF = new Block(Properties.ofFullCopy(Blocks.BOOKSHELF));
		Block CHISELED_CEILTRUNK_BOOKSHELF = new BlueprintChiseledBookShelfBlock(Properties.ofFullCopy(Blocks.CHISELED_BOOKSHELF));
		Block CEILTRUNK_LEAF_PILE = new LeafPileBlock(Properties.ofFullCopy(CeilandsBlocks.CEILTRUNK_LEAVES));
		Block LUZAWOOD_BOARDS = new RotatedPillarBlock(Properties.ofFullCopy(CeilandsBlocks.LUZAWOOD_PLANKS));
		Block LUZAWOOD_BEEHIVE = new BlueprintBeehiveBlock(Properties.ofFullCopy(Blocks.BEEHIVE));
		Block LUZAWOOD_CHEST = new BlueprintChestBlock("ceilands:luzawood_normal", Properties.ofFullCopy(Blocks.CHEST));
		Block TRAPPED_LUZAWOOD_CHEST = new BlueprintTrappedChestBlock("ceilands:luzawood_trapped", Properties.ofFullCopy(Blocks.TRAPPED_CHEST));
		Block LUZAWOOD_LADDER = new LadderBlock(Properties.ofFullCopy(Blocks.LADDER));
		Block LUZAWOOD_BOOKSHELF = new Block(Properties.ofFullCopy(Blocks.BOOKSHELF));
		Block CHISELED_LUZAWOOD_BOOKSHELF = new BlueprintChiseledBookShelfBlock(Properties.ofFullCopy(Blocks.CHISELED_BOOKSHELF));
		Block LUZAWOOD_LEAF_PILE = new LeafPileBlock(Properties.ofFullCopy(CeilandsBlocks.LUZAWOOD_LEAVES));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_BOARDS_RES, CEILTRUNK_BOARDS));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_BEEHIVE_RES, CEILTRUNK_BEEHIVE));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_CHEST_RES, CEILTRUNK_CHEST));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_TRAPPED_CHEST_RES, TRAPPED_CEILTRUNK_CHEST));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_LADDER_RES, CEILTRUNK_LADDER));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_BOOKSHELF_RES, CEILTRUNK_BOOKSHELF));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_CHISELED_BOOKSHELF_RES, CHISELED_CEILTRUNK_BOOKSHELF));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_LEAF_PILE_RES, CEILTRUNK_LEAF_PILE));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_BOARDS_RES, LUZAWOOD_BOARDS));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_BEEHIVE_RES, LUZAWOOD_BEEHIVE));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_CHEST_RES, LUZAWOOD_CHEST));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_TRAPPED_CHEST_RES, TRAPPED_LUZAWOOD_CHEST));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_LADDER_RES, LUZAWOOD_LADDER));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_BOOKSHELF_RES, LUZAWOOD_BOOKSHELF));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_CHISELED_BOOKSHELF_RES, CHISELED_LUZAWOOD_BOOKSHELF));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_LEAF_PILE_RES, LUZAWOOD_LEAF_PILE));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_BOARDS_RES, new BlockItem(CEILTRUNK_BOARDS, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_BEEHIVE_RES, new BlockItem(CEILTRUNK_BEEHIVE, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_CHEST_RES, new BEWLRBlockItem(CEILTRUNK_CHEST, new Item.Properties(), () -> () -> chestBEWLR(false))));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_TRAPPED_CHEST_RES, new BEWLRBlockItem(TRAPPED_CEILTRUNK_CHEST, new Item.Properties(), () -> () -> chestBEWLR(true))));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_LADDER_RES, new BlockItem(CEILTRUNK_LADDER, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_BOOKSHELF_RES, new BlockItem(CEILTRUNK_BOOKSHELF, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_CHISELED_BOOKSHELF_RES, new BlockItem(CHISELED_CEILTRUNK_BOOKSHELF, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_LEAF_PILE_RES, new BlockItem(CEILTRUNK_LEAF_PILE, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_BOARDS_RES, new BlockItem(LUZAWOOD_BOARDS, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_BEEHIVE_RES, new BlockItem(LUZAWOOD_BEEHIVE, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_CHEST_RES, new BEWLRBlockItem(LUZAWOOD_CHEST, new Item.Properties(), () -> () -> chestBEWLR(false))));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_TRAPPED_CHEST_RES, new BEWLRBlockItem(TRAPPED_LUZAWOOD_CHEST, new Item.Properties(), () -> () -> chestBEWLR(true))));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_LADDER_RES, new BlockItem(LUZAWOOD_LADDER, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_BOOKSHELF_RES, new BlockItem(LUZAWOOD_BOOKSHELF, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_CHISELED_BOOKSHELF_RES, new BlockItem(CHISELED_LUZAWOOD_BOOKSHELF, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_LEAF_PILE_RES, new BlockItem(LUZAWOOD_LEAF_PILE, new Item.Properties())));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CEILTRUNK_BOARDS, 5, 20));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(LUZAWOOD_BOARDS, 5, 20));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CEILTRUNK_BOOKSHELF, 5, 20));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(LUZAWOOD_BOOKSHELF, 5, 20));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CEILTRUNK_LEAF_PILE, 30, 60));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(LUZAWOOD_LEAF_PILE, 30, 60));
		BlueprintChestMaterials.registerMaterials(Ceilands.MOD_ID, "ceiltrunk", false);
		BlueprintChestMaterials.registerMaterials(Ceilands.MOD_ID, "ceiltrunk", true);
		BlueprintChestMaterials.registerMaterials(Ceilands.MOD_ID, "luzawood", false);
		BlueprintChestMaterials.registerMaterials(Ceilands.MOD_ID, "luzawood", true);
	}
	
	@SubscribeEvent
	public void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			event.insertAfter(CeilandsItems.CEILTRUNK_PLANKS.getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_BOARDS_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(CeilandsItems.LUZAWOOD_PLANKS.getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_BOARDS_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
		if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			event.insertAfter(WoodworksBlocks.CHERRY_LEAF_PILE.get().asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_LEAF_PILE_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_LEAF_PILE_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_LEAF_PILE_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
		if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			event.insertAfter(WoodworksBlocks.WARPED_BEEHIVE.get().asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_BEEHIVE_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_BEEHIVE_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_BEEHIVE_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(WoodworksBlocks.CHISELED_WARPED_BOOKSHELF.get().asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_BOOKSHELF_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_BOOKSHELF_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_CHISELED_BOOKSHELF_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_CHISELED_BOOKSHELF_RES).asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_BOOKSHELF_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(LUZAWOOD_BOOKSHELF_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_CHISELED_BOOKSHELF_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(WoodworksBlocks.WARPED_LADDER.get().asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_LADDER_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_LADDER_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_LADDER_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(WoodworksBlocks.WARPED_CHEST.get().asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_CHEST_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_CHEST_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_CHEST_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
		if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			event.insertAfter(WoodworksBlocks.TRAPPED_WARPED_CHEST.get().asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_TRAPPED_CHEST_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_TRAPPED_CHEST_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_TRAPPED_CHEST_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
	
	//@OnlyIn(Dist.CLIENT)
	private BEWLRBlockItem.LazyBEWLR chestBEWLR(boolean trapped) {
		return trapped ? new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> {
			return new ChestBlockEntityWithoutLevelRenderer<>(dispatcher, entityModelSet, new BlueprintTrappedChestBlockEntity(BlockPos.ZERO, Blocks.TRAPPED_CHEST.defaultBlockState()));
		}) : new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> {
			return new ChestBlockEntityWithoutLevelRenderer<>(dispatcher, entityModelSet, new BlueprintChestBlockEntity(BlockPos.ZERO, Blocks.CHEST.defaultBlockState()));
		});
	}*/
}
