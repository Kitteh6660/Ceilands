package com.kittehmod.ceilands.forge.client;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.client.ClientBase;
import com.kittehmod.ceilands.client.entity.model.CastleLordModel;
import com.kittehmod.ceilands.client.renderer.CastleLordRenderer;
import com.kittehmod.ceilands.client.renderer.CeilandsBoatRenderer;
import com.kittehmod.ceilands.client.renderer.SpiderMonarchRenderer;
import com.kittehmod.ceilands.forge.compat.TwilightForestCompat;
import com.kittehmod.ceilands.forge.compat.WoodworksCompat;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientHandler
{
	public static void setupRenderers() {
		BlockEntityRenderers.register(CeilandsBlockEntities.CEILANDS_SIGN, SignRenderer::new);
		BlockEntityRenderers.register(CeilandsBlockEntities.CEILANDS_HANGING_SIGN, HangingSignRenderer::new);
		
		EntityRenderers.register(CeilandsEntities.SPIDER_MONARCH, SpiderMonarchRenderer::new);
		EntityRenderers.register(CeilandsEntities.CASTLE_LORD, CastleLordRenderer::new);
		EntityRenderers.register(CeilandsEntities.CEILANDS_BOAT, (boat) -> { return new CeilandsBoatRenderer(boat, false); } );
		EntityRenderers.register(CeilandsEntities.CEILANDS_CHEST_BOAT, (boat) -> { return new CeilandsBoatRenderer(boat, true); } );
		
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILINUM_BARS, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILINUM_DOOR, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILINUM_TRAPDOOR, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILTRUNK_LEAVES, RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILTRUNK_SAPLING, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILTRUNK_DOOR, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILTRUNK_TRAPDOOR, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.LUZAWOOD_LEAVES, RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.LUZAWOOD_SAPLING, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.LUZAWOOD_DOOR, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.LUZAWOOD_TRAPDOOR, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.POTTED_LUZAWOOD_SAPLING, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(CeilandsBlocks.CEILANDS_PORTAL, RenderType.translucent());
		if (ModList.get().isLoaded("woodworks")) {
			ItemBlockRenderTypes.setRenderLayer(ForgeRegistries.BLOCKS.getValue(WoodworksCompat.CEILTRUNK_LADDER_RES), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(ForgeRegistries.BLOCKS.getValue(WoodworksCompat.CEILTRUNK_LEAF_PILE_RES), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(ForgeRegistries.BLOCKS.getValue(WoodworksCompat.LUZAWOOD_LADDER_RES), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(ForgeRegistries.BLOCKS.getValue(WoodworksCompat.LUZAWOOD_LEAF_PILE_RES), RenderType.cutout());
		}
	}
	
	@SubscribeEvent
	public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
	    event.registerLayerDefinition(CastleLordRenderer.CASTLE_LORD_MODEL_LAYER, CastleLordModel::getBaseLayerDefinition);
	    event.registerLayerDefinition(CastleLordRenderer.CASTLE_LORD_MODEL_INNER_ARMOR_LAYER, CastleLordModel::getInnerLayerDefinition);
	    event.registerLayerDefinition(CastleLordRenderer.CASTLE_LORD_MODEL_OUTER_ARMOR_LAYER, CastleLordModel::getOuterLayerDefinition);
	}
	
	@SubscribeEvent
	public static void registerBlockColours(RegisterColorHandlersEvent.Block event) {
		event.register((state, worldIn, pos, tintIndex) -> {
			return state != null && worldIn != null ? ClientBase.CEILTRUNK_COLOUR : FoliageColor.getDefaultColor();
		}, CeilandsBlocks.CEILTRUNK_LEAVES);
		event.register((state, worldIn, pos, tintIndex) -> {
			return ClientBase.LUZAWOOD_COLOUR;
		}, CeilandsBlocks.LUZAWOOD_LEAVES);
		if (ModList.get().isLoaded("woodworks")) {
			event.register((state, worldIn, pos, tintIndex) -> { return state != null && worldIn != null ? ClientBase.CEILTRUNK_COLOUR : FoliageColor.getDefaultColor(); }, ForgeRegistries.BLOCKS.getValue(WoodworksCompat.CEILTRUNK_LEAF_PILE_RES));
			event.register((state, worldIn, pos, tintIndex) -> { return ClientBase.LUZAWOOD_COLOUR; }, ForgeRegistries.BLOCKS.getValue(WoodworksCompat.LUZAWOOD_LEAF_PILE_RES));
		}
		if (ModList.get().isLoaded("twilightforest")) {
			event.register((state, worldIn, pos, tintIndex) -> { return state != null && worldIn != null ? BiomeColors.getAverageFoliageColor(worldIn, pos) : FoliageColor.getDefaultColor(); }, 
					ForgeRegistries.BLOCKS.getValue(TwilightForestCompat.CEILTRUNK_HOLLOW_LOG_CLIMBABLE_RES), ForgeRegistries.BLOCKS.getValue(TwilightForestCompat.LUZAWOOD_HOLLOW_LOG_CLIMBABLE_RES));
		}
	}
	
	@SubscribeEvent
	public static void registerItemColours(RegisterColorHandlersEvent.Item event) {
		BlockColors blockColours = event.getBlockColors();
		event.register((stack, tintIndex) -> { 
			BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
			return blockColours.getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, tintIndex);
		}, CeilandsItems.CEILTRUNK_LEAVES, CeilandsItems.LUZAWOOD_LEAVES);
		if (ModList.get().isLoaded("woodworks")) {
			event.register((stack, tintIndex) -> { BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState(); return blockColours.getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, tintIndex); }, 
			ForgeRegistries.ITEMS.getValue(WoodworksCompat.CEILTRUNK_LEAF_PILE_RES), ForgeRegistries.ITEMS.getValue(WoodworksCompat.LUZAWOOD_LEAF_PILE_RES));
		}
	}
	
	@SubscribeEvent
	public static void registerSkyEffects(RegisterDimensionSpecialEffectsEvent event) {
		event.register(new ResourceLocation(Ceilands.MOD_ID, "the_ceilands"), new CeilandsSkyEffect.CeilandsEffects());
	}
	
}
