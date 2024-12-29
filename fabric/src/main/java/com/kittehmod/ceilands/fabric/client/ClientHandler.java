package com.kittehmod.ceilands.fabric.client;

import com.kittehmod.ceilands.client.CeilandsSkyEffect;
import com.kittehmod.ceilands.client.ClientCommon;
import com.kittehmod.ceilands.client.entity.model.CastleLordModel;
import com.kittehmod.ceilands.client.renderer.CastleLordRenderer;
import com.kittehmod.ceilands.client.renderer.CeilandsBoatRenderer;
import com.kittehmod.ceilands.client.renderer.SpiderMonarchRenderer;
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
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Pair;

public class ClientHandler implements ClientModInitializer
{
	@Override
	public void onInitializeClient() {
		if (FabricLoader.getInstance().isModLoaded("connector")) {
			return;
		}
		ClientCommon.initializeCommonClient();
		for (Pair<Block, RenderType> pair : ClientCommon.BLOCK_RENDERS) {
			BlockRenderLayerMap.INSTANCE.putBlock(pair.getA(), pair.getB());
		}
		
	    EntityModelLayerRegistry.registerModelLayer(CastleLordRenderer.CASTLE_LORD_MODEL_LAYER, CastleLordModel::getBaseLayerDefinition);
	    EntityModelLayerRegistry.registerModelLayer(CastleLordRenderer.CASTLE_LORD_MODEL_INNER_ARMOR_LAYER, CastleLordModel::getInnerLayerDefinition);
	    EntityModelLayerRegistry.registerModelLayer(CastleLordRenderer.CASTLE_LORD_MODEL_OUTER_ARMOR_LAYER, CastleLordModel::getOuterLayerDefinition);
		
		ColorProviderRegistry.BLOCK.register((state, worldIn, pos, tintIndex) -> { return state != null && worldIn != null ? ClientCommon.CEILTRUNK_COLOUR : FoliageColor.getDefaultColor(); }, CeilandsBlocks.CEILTRUNK_LEAVES);
		ColorProviderRegistry.BLOCK.register((state, worldIn, pos, tintIndex) -> ClientCommon.LUZAWOOD_COLOUR, CeilandsBlocks.LUZAWOOD_LEAVES);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ClientCommon.CEILTRUNK_COLOUR, CeilandsItems.CEILTRUNK_LEAVES);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ClientCommon.LUZAWOOD_COLOUR, CeilandsItems.LUZAWOOD_LEAVES);
		registerSky();
	}
	
	public static void registerSky() {
		DimensionSpecialEffects.EFFECTS.put(CeilandsSkyEffect.CEILANDS_EFFECTS, new CeilandsSkyEffect.CeilandsEffects());
	}
}
