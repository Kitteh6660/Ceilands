package com.kittehmod.ceilands.fabric.client;

import com.kittehmod.ceilands.client.ClientBase;
import com.kittehmod.ceilands.client.entity.model.CastleLordModel;
import com.kittehmod.ceilands.client.renderer.CastleLordRenderer;
import com.kittehmod.ceilands.client.renderer.CeilandsBoatRenderer;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsItems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.FoliageColor;

public class ClientHandler implements ClientModInitializer
{
	@Override
	public void onInitializeClient() {
		if (FabricLoader.getInstance().isModLoaded("connector")) {
			return;
		}
	    EntityModelLayerRegistry.registerModelLayer(CastleLordRenderer.CASTLE_LORD_MODEL_LAYER, CastleLordModel::getBaseLayerDefinition);
	    EntityModelLayerRegistry.registerModelLayer(CastleLordRenderer.CASTLE_LORD_MODEL_INNER_ARMOR_LAYER, CastleLordModel::getInnerLayerDefinition);
	    EntityModelLayerRegistry.registerModelLayer(CastleLordRenderer.CASTLE_LORD_MODEL_OUTER_ARMOR_LAYER, CastleLordModel::getOuterLayerDefinition);
	    
		BlockEntityRenderers.register(CeilandsBlockEntities.CEILANDS_SIGN, SignRenderer::new);
		
		EntityRendererRegistry.register(CeilandsEntities.CASTLE_LORD, CastleLordRenderer::new);
		EntityRendererRegistry.register(CeilandsEntities.CEILANDS_BOAT, (boat) -> { return new CeilandsBoatRenderer(boat, false); } );
		EntityRendererRegistry.register(CeilandsEntities.CEILANDS_CHEST_BOAT, (boat) -> { return new CeilandsBoatRenderer(boat, true); } );
		
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.CEILTRUNK_LEAVES, RenderType.cutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.CEILTRUNK_SAPLING, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.CEILTRUNK_DOOR, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.CEILTRUNK_TRAPDOOR, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.LUZAWOOD_LEAVES, RenderType.cutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.LUZAWOOD_SAPLING, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.LUZAWOOD_DOOR, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.LUZAWOOD_TRAPDOOR, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.CEILINUM_DOOR, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.CEILINUM_TRAPDOOR, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.CEILINUM_BARS, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.POTTED_LUZAWOOD_SAPLING, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CeilandsBlocks.CEILANDS_PORTAL, RenderType.translucent());
		
		ColorProviderRegistry.BLOCK.register((state, worldIn, pos, tintIndex) -> { return state != null && worldIn != null ? ClientBase.CEILTRUNK_COLOUR : FoliageColor.getDefaultColor(); }, CeilandsBlocks.CEILTRUNK_LEAVES);
		ColorProviderRegistry.BLOCK.register((state, worldIn, pos, tintIndex) -> ClientBase.LUZAWOOD_COLOUR, CeilandsBlocks.LUZAWOOD_LEAVES);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ClientBase.CEILTRUNK_COLOUR, CeilandsItems.CEILTRUNK_LEAVES);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ClientBase.LUZAWOOD_COLOUR, CeilandsItems.LUZAWOOD_LEAVES);
		registerSky();
	}
	
	public static void registerSky() {
		DimensionSpecialEffects.EFFECTS.put(CeilandsSkyEffect.CEILANDS_EFFECTS, new CeilandsSkyEffect.CeilandsEffects());
	}
}
