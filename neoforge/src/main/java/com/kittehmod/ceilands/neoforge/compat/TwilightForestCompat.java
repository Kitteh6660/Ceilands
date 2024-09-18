package com.kittehmod.ceilands.neoforge.compat;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.neoforge.CeilandsRegistry;
import com.kittehmod.ceilands.registry.CeilandsBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;
import twilightforest.block.BanisterBlock;
import twilightforest.block.ClimbableHollowLogBlock;
import twilightforest.block.HorizontalHollowLogBlock;
import twilightforest.block.VerticalHollowLogBlock;
import twilightforest.init.TFBlocks;
import twilightforest.init.TFCreativeTabs;
import twilightforest.init.TFItems;
import twilightforest.item.HollowLogItem;

public class TwilightForestCompat 
{
	public static final ResourceLocation CEILTRUNK_BANISTER_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "ceiltrunk_banister");
	public static final ResourceLocation LUZAWOOD_BANISTER_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "luzawood_banister");
	public static final ResourceLocation CEILTRUNK_HOLLOW_LOG_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_ceiltrunk_log");
	public static final ResourceLocation LUZAWOOD_HOLLOW_LOG_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_luzawood_log");
	public static final ResourceLocation CEILTRUNK_HOLLOW_LOG_CLIMBABLE_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_ceiltrunk_log_climbable");
	public static final ResourceLocation LUZAWOOD_HOLLOW_LOG_CLIMBABLE_RES = ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_luzawood_log_climbable");
	
	private Holder<Block> hollowHorizontalCeiltrunkLogHolder = Holder.direct(Blocks.AIR);
	private Holder<Block> hollowVerticalCeiltrunkLogHolder = Holder.direct(Blocks.AIR);
	private Holder<Block> hollowClimbableCeiltrunkLogHolder = Holder.direct(Blocks.AIR);
	private Holder<Block> hollowHorizontalLuzawoodLogHolder = Holder.direct(Blocks.AIR);
	private Holder<Block> hollowVerticalLuzawoodLogHolder = Holder.direct(Blocks.AIR);
	private Holder<Block> hollowClimbableLuzawoodLogHolder = Holder.direct(Blocks.AIR);
	
	public TwilightForestCompat(boolean register) {
		if (!register) {
			return;
		}
		// Add banisters.
		Block CEILTRUNK_BANISTER = new BanisterBlock(Properties.ofFullCopy(CeilandsBlocks.CEILTRUNK_PLANKS));
		Block LUZAWOOD_BANISTER = new BanisterBlock(Properties.ofFullCopy(CeilandsBlocks.LUZAWOOD_PLANKS));
		// Add hollow logs.
		HorizontalHollowLogBlock HOLLOW_CEILTRUNK_LOG_HORIZONTAL = new HorizontalHollowLogBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD));
		VerticalHollowLogBlock HOLLOW_CEILTRUNK_LOG_VERTICAL = new VerticalHollowLogBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD), hollowClimbableCeiltrunkLogHolder);
		ClimbableHollowLogBlock HOLLOW_CEILTRUNK_LOG_CLIMBABLE = new ClimbableHollowLogBlock(hollowVerticalCeiltrunkLogHolder, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD));
		HorizontalHollowLogBlock HOLLOW_LUZAWOOD_LOG_HORIZONTAL = new HorizontalHollowLogBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD));
		VerticalHollowLogBlock HOLLOW_LUZAWOOD_LOG_VERTICAL = new VerticalHollowLogBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD), hollowClimbableLuzawoodLogHolder);
		ClimbableHollowLogBlock HOLLOW_LUZAWOOD_LOG_CLIMBABLE = new ClimbableHollowLogBlock(hollowVerticalLuzawoodLogHolder, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD));
		// Fill out the holder.
		hollowHorizontalCeiltrunkLogHolder = Holder.direct(HOLLOW_CEILTRUNK_LOG_HORIZONTAL);
		hollowVerticalCeiltrunkLogHolder = Holder.direct(HOLLOW_CEILTRUNK_LOG_VERTICAL);
		hollowClimbableCeiltrunkLogHolder = Holder.direct(HOLLOW_CEILTRUNK_LOG_CLIMBABLE);
		hollowHorizontalLuzawoodLogHolder = Holder.direct(HOLLOW_LUZAWOOD_LOG_HORIZONTAL);
		hollowVerticalLuzawoodLogHolder = Holder.direct(HOLLOW_LUZAWOOD_LOG_VERTICAL);
		hollowClimbableLuzawoodLogHolder = Holder.direct(HOLLOW_LUZAWOOD_LOG_CLIMBABLE);
		// Put them on list of things to register.
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_BANISTER_RES, CEILTRUNK_BANISTER));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_BANISTER_RES, LUZAWOOD_BANISTER));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_ceiltrunk_log_horizontal"), HOLLOW_CEILTRUNK_LOG_HORIZONTAL));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_ceiltrunk_log_vertical"), HOLLOW_CEILTRUNK_LOG_VERTICAL));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_ceiltrunk_log_climbable"), HOLLOW_CEILTRUNK_LOG_CLIMBABLE));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_luzawood_log_horizontal"), HOLLOW_LUZAWOOD_LOG_HORIZONTAL));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_luzawood_log_vertical"), HOLLOW_LUZAWOOD_LOG_VERTICAL));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, "hollow_luzawood_log_climbable"), HOLLOW_LUZAWOOD_LOG_CLIMBABLE));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_BANISTER_RES, new BlockItem(CEILTRUNK_BANISTER, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_BANISTER_RES, new BlockItem(LUZAWOOD_BANISTER, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_HOLLOW_LOG_RES, new HollowLogItem(hollowHorizontalCeiltrunkLogHolder, hollowVerticalCeiltrunkLogHolder, hollowClimbableCeiltrunkLogHolder, new Item.Properties())));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_HOLLOW_LOG_RES, new HollowLogItem(hollowHorizontalCeiltrunkLogHolder, hollowVerticalLuzawoodLogHolder, hollowClimbableLuzawoodLogHolder, new Item.Properties())));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CEILTRUNK_BANISTER, 5, 20));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(LUZAWOOD_BANISTER, 5, 20));
	}
	
	@SubscribeEvent
	public void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == TFCreativeTabs.BLOCKS.getKey()) {
			event.insertAfter(TFBlocks.CHERRY_BANISTER.get().asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_BANISTER_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_BANISTER_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_BANISTER_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(TFItems.HOLLOW_CHERRY_LOG.get().asItem().getDefaultInstance(), BuiltInRegistries.ITEM.get(CEILTRUNK_HOLLOW_LOG_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(BuiltInRegistries.ITEM.get(CEILTRUNK_HOLLOW_LOG_RES).getDefaultInstance(), BuiltInRegistries.ITEM.get(LUZAWOOD_HOLLOW_LOG_RES).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
}
