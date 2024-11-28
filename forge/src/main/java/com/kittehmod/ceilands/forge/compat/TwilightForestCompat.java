package com.kittehmod.ceilands.forge.compat;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsFlammableBlocks;
import com.kittehmod.ceilands.forge.CeilandsRegistry;
import com.kittehmod.ceilands.forge.compat.blocks.CeilandsHollowLogItem;
import com.kittehmod.ceilands.registry.CeilandsBlocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;
import twilightforest.block.BanisterBlock;
import twilightforest.block.HollowLogClimbable;
import twilightforest.block.HollowLogHorizontal;
import twilightforest.block.HollowLogVertical;
import twilightforest.init.TFItems;

public class TwilightForestCompat 
{
	public static final ResourceLocation CEILTRUNK_BANISTER_RES = new ResourceLocation(Ceilands.MOD_ID, "ceiltrunk_banister");
	public static final ResourceLocation LUZAWOOD_BANISTER_RES = new ResourceLocation(Ceilands.MOD_ID, "luzawood_banister");
	public static final ResourceLocation CEILTRUNK_HOLLOW_LOG_RES = new ResourceLocation(Ceilands.MOD_ID, "hollow_ceiltrunk_log");
	public static final ResourceLocation LUZAWOOD_HOLLOW_LOG_RES = new ResourceLocation(Ceilands.MOD_ID, "hollow_luzawood_log");
	public static final ResourceLocation CEILTRUNK_HOLLOW_LOG_CLIMBABLE_RES = new ResourceLocation(Ceilands.MOD_ID, "hollow_ceiltrunk_log_climbable");
	public static final ResourceLocation LUZAWOOD_HOLLOW_LOG_CLIMBABLE_RES = new ResourceLocation(Ceilands.MOD_ID, "hollow_luzawood_log_climbable");
	
	public TwilightForestCompat(boolean register) {
		if (!register) {
			return;
		}
		Block CEILTRUNK_BANISTER = new BanisterBlock(Properties.copy(CeilandsBlocks.CEILTRUNK_PLANKS));
		Block LUZAWOOD_BANISTER = new BanisterBlock(Properties.copy(CeilandsBlocks.LUZAWOOD_PLANKS));
		// Disgusting workaround because Hollow Log constructor blocks strictly only use RegistryObject. >:(
		RegistryObject<HollowLogHorizontal> HOLLOW_CEILTRUNK_LOG_HORIZONTAL_RO = RegistryObject.create(new ResourceLocation(Ceilands.MOD_ID, "hollow_ceiltrunk_log_horizontal"), ForgeRegistries.Keys.BLOCKS, Ceilands.MOD_ID);
		RegistryObject<HollowLogVertical> HOLLOW_CEILTRUNK_LOG_VERTICAL_RO = RegistryObject.create(new ResourceLocation(Ceilands.MOD_ID, "hollow_ceiltrunk_log_vertical"), ForgeRegistries.Keys.BLOCKS, Ceilands.MOD_ID);
		RegistryObject<HollowLogClimbable> HOLLOW_CEILTRUNK_LOG_CLIMBABLE_RO = RegistryObject.create(new ResourceLocation(Ceilands.MOD_ID, "hollow_ceiltrunk_log_climbable"), ForgeRegistries.Keys.BLOCKS, Ceilands.MOD_ID);
		RegistryObject<HollowLogHorizontal> HOLLOW_LUZAWOOD_LOG_HORIZONTAL_RO = RegistryObject.create(new ResourceLocation(Ceilands.MOD_ID, "hollow_luzawood_log_horizontal"), ForgeRegistries.Keys.BLOCKS, Ceilands.MOD_ID);
		RegistryObject<HollowLogVertical> HOLLOW_LUZAWOOD_LOG_VERTICAL_RO = RegistryObject.create(new ResourceLocation(Ceilands.MOD_ID, "hollow_luzawood_log_vertical"), ForgeRegistries.Keys.BLOCKS, Ceilands.MOD_ID);
		RegistryObject<HollowLogClimbable> HOLLOW_LUZAWOOD_LOG_CLIMBABLE_RO = RegistryObject.create(new ResourceLocation(Ceilands.MOD_ID, "hollow_luzawood_log_climbable"), ForgeRegistries.Keys.BLOCKS, Ceilands.MOD_ID);
		HollowLogHorizontal HOLLOW_CEILTRUNK_LOG_HORIZONTAL = new HollowLogHorizontal(Block.Properties.of(Material.WOOD).color(MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD));
		HollowLogVertical HOLLOW_CEILTRUNK_LOG_VERTICAL = new HollowLogVertical(Block.Properties.of(Material.WOOD).color(MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD), HOLLOW_CEILTRUNK_LOG_CLIMBABLE_RO);
		HollowLogClimbable HOLLOW_CEILTRUNK_LOG_CLIMBABLE = new HollowLogClimbable(Block.Properties.of(Material.WOOD).color(MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 4.0F).sound(SoundType.WOOD), HOLLOW_CEILTRUNK_LOG_VERTICAL_RO);
		HollowLogHorizontal HOLLOW_LUZAWOOD_LOG_HORIZONTAL = new HollowLogHorizontal(Block.Properties.of(Material.WOOD).color(MaterialColor.COLOR_LIGHT_BLUE).strength(2.0F, 4.0F).sound(SoundType.WOOD));
		HollowLogVertical HOLLOW_LUZAWOOD_LOG_VERTICAL = new HollowLogVertical(Block.Properties.of(Material.WOOD).color(MaterialColor.COLOR_LIGHT_BLUE).strength(2.0F, 4.0F).sound(SoundType.WOOD), HOLLOW_LUZAWOOD_LOG_CLIMBABLE_RO);
		HollowLogClimbable HOLLOW_LUZAWOOD_LOG_CLIMBABLE = new HollowLogClimbable(Block.Properties.of(Material.WOOD).color(MaterialColor.COLOR_LIGHT_BLUE).strength(2.0F, 4.0F).sound(SoundType.WOOD), HOLLOW_LUZAWOOD_LOG_VERTICAL_RO);
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(CEILTRUNK_BANISTER_RES, CEILTRUNK_BANISTER));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(LUZAWOOD_BANISTER_RES, LUZAWOOD_BANISTER));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(new ResourceLocation(Ceilands.MOD_ID, "hollow_ceiltrunk_log_horizontal"), HOLLOW_CEILTRUNK_LOG_HORIZONTAL));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(new ResourceLocation(Ceilands.MOD_ID, "hollow_ceiltrunk_log_vertical"), HOLLOW_CEILTRUNK_LOG_VERTICAL));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(new ResourceLocation(Ceilands.MOD_ID, "hollow_ceiltrunk_log_climbable"), HOLLOW_CEILTRUNK_LOG_CLIMBABLE));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(new ResourceLocation(Ceilands.MOD_ID, "hollow_luzawood_log_horizontal"), HOLLOW_LUZAWOOD_LOG_HORIZONTAL));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(new ResourceLocation(Ceilands.MOD_ID, "hollow_luzawood_log_vertical"), HOLLOW_LUZAWOOD_LOG_VERTICAL));
		CeilandsRegistry.COMPAT_BLOCKS.add(new Pair(new ResourceLocation(Ceilands.MOD_ID, "hollow_luzawood_log_climbable"), HOLLOW_LUZAWOOD_LOG_CLIMBABLE));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_BANISTER_RES, new BlockItem(CEILTRUNK_BANISTER, new Item.Properties().tab(TFItems.creativeTab))));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_BANISTER_RES, new BlockItem(LUZAWOOD_BANISTER, new Item.Properties().tab(TFItems.creativeTab))));
		// Register a specially-coded item which use Suppliers. Workaround. Moral of the story: Don't use RegistryObject for constructors. Use Suppliers.
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(CEILTRUNK_HOLLOW_LOG_RES, new CeilandsHollowLogItem(() -> HOLLOW_CEILTRUNK_LOG_HORIZONTAL, () -> HOLLOW_CEILTRUNK_LOG_VERTICAL, () -> HOLLOW_CEILTRUNK_LOG_CLIMBABLE, new Item.Properties().tab(TFItems.creativeTab))));
		CeilandsRegistry.COMPAT_ITEMS.add(new Pair(LUZAWOOD_HOLLOW_LOG_RES, new CeilandsHollowLogItem(() -> HOLLOW_LUZAWOOD_LOG_HORIZONTAL, () -> HOLLOW_LUZAWOOD_LOG_VERTICAL, () -> HOLLOW_LUZAWOOD_LOG_CLIMBABLE, new Item.Properties().tab(TFItems.creativeTab))));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CEILTRUNK_BANISTER, 5, 20));
		CeilandsFlammableBlocks.CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(LUZAWOOD_BANISTER, 5, 20));
	}
}
