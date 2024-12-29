package com.kittehmod.ceilands.neoforge.client;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.client.CeilandsSkyEffect;
import com.kittehmod.ceilands.client.ClientCommon;
import com.kittehmod.ceilands.client.entity.model.CastleLordModel;
import com.kittehmod.ceilands.client.renderer.CastleLordRenderer;
import com.kittehmod.ceilands.client.renderer.CeilandsBoatRenderer;
import com.kittehmod.ceilands.client.renderer.SpiderMonarchRenderer;
import com.kittehmod.ceilands.neoforge.compat.TwilightForestCompat;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import oshi.util.tuples.Pair;

@EventBusSubscriber(modid = Ceilands.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientHandler
{
	public static void setupRenderers() {
		ClientCommon.initializeCommonClient();
		for (Pair<Block, RenderType> pair : ClientCommon.BLOCK_RENDERS) {
			ItemBlockRenderTypes.setRenderLayer(pair.getA(), pair.getB());
		}
		/*if (ModList.get().isLoaded("woodworks")) {
			ItemBlockRenderTypes.setRenderLayer(BuiltInRegistries.BLOCK.get(WoodworksCompat.CEILTRUNK_LADDER_RES), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(BuiltInRegistries.BLOCK.get(WoodworksCompat.CEILTRUNK_LEAF_PILE_RES), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(BuiltInRegistries.BLOCK.get(WoodworksCompat.LUZAWOOD_LADDER_RES), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(BuiltInRegistries.BLOCK.get(WoodworksCompat.LUZAWOOD_LEAF_PILE_RES), RenderType.cutout());
		}*/
	}
	
	@SubscribeEvent
	public static void setupClient(FMLClientSetupEvent event) {
		ClientHandler.setupRenderers();
		event.enqueueWork(() -> {
			Sheets.addWoodType(ModWoodType.CEILTRUNK);
			Sheets.addWoodType(ModWoodType.LUZAWOOD);
		});
	}
	
	@SubscribeEvent
	public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
	    event.registerLayerDefinition(CastleLordRenderer.CASTLE_LORD_MODEL_LAYER, CastleLordModel::getBaseLayerDefinition);
	    event.registerLayerDefinition(CastleLordRenderer.CASTLE_LORD_MODEL_INNER_ARMOR_LAYER, CastleLordModel::getInnerLayerDefinition);
	    event.registerLayerDefinition(CastleLordRenderer.CASTLE_LORD_MODEL_OUTER_ARMOR_LAYER, CastleLordModel::getOuterLayerDefinition);
	}
	
	@SubscribeEvent
	public static void registerEntityLayers(RegisterDimensionSpecialEffectsEvent event) {
		event.register(CeilandsSkyEffect.CEILANDS_EFFECTS, new CeilandsSkyEffect.CeilandsEffects());
	}
	
	@SubscribeEvent
	public static void registerBlockColours(RegisterColorHandlersEvent.Block event) {
		event.register((state, worldIn, pos, tintIndex) -> { return state != null && worldIn != null ? ClientCommon.CEILTRUNK_COLOUR : FoliageColor.getDefaultColor(); }, CeilandsBlocks.CEILTRUNK_LEAVES);
		event.register((state, worldIn, pos, tintIndex) -> { return ClientCommon.LUZAWOOD_COLOUR; }, CeilandsBlocks.LUZAWOOD_LEAVES);
		/*if (ModList.get().isLoaded("woodworks")) {
			event.register((state, worldIn, pos, tintIndex) -> { return state != null && worldIn != null ? ClientBase.CEILTRUNK_COLOUR : FoliageColor.getDefaultColor(); }, BuiltInRegistries.BLOCK.get(WoodworksCompat.CEILTRUNK_LEAF_PILE_RES));
			event.register((state, worldIn, pos, tintIndex) -> { return ClientBase.LUZAWOOD_COLOUR; }, BuiltInRegistries.BLOCK.get(WoodworksCompat.LUZAWOOD_LEAF_PILE_RES));
		}*/
		if (ModList.get().isLoaded("twilightforest")) {
			event.register((state, worldIn, pos, tintIndex) -> { return state != null && worldIn != null ? BiomeColors.getAverageFoliageColor(worldIn, pos) : FoliageColor.getDefaultColor(); }, 
				BuiltInRegistries.BLOCK.get(TwilightForestCompat.CEILTRUNK_HOLLOW_LOG_CLIMBABLE_RES), BuiltInRegistries.BLOCK.get(TwilightForestCompat.LUZAWOOD_HOLLOW_LOG_CLIMBABLE_RES));
		}
	}
	
	@SubscribeEvent
	public static void registerItemColours(RegisterColorHandlersEvent.Item event) {
		BlockColors blockColours = event.getBlockColors();
		event.register((stack, tintIndex) -> { BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState(); return blockColours.getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, tintIndex); }, CeilandsItems.CEILTRUNK_LEAVES, CeilandsItems.LUZAWOOD_LEAVES);
		/*if (ModList.get().isLoaded("woodworks")) {
			event.register((stack, tintIndex) -> { BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState(); return blockColours.getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, tintIndex); }, 
				BuiltInRegistries.ITEM.get(WoodworksCompat.CEILTRUNK_LEAF_PILE_RES), BuiltInRegistries.ITEM.get(WoodworksCompat.LUZAWOOD_LEAF_PILE_RES));
		}*/
	}
}
