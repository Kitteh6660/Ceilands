package com.kittehmod.ceilands.client;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.client.renderer.CastleLordRenderer;
import com.kittehmod.ceilands.client.renderer.CeilandsBoatRenderer;
import com.kittehmod.ceilands.client.renderer.SpiderMonarchRenderer;
import com.kittehmod.ceilands.registry.CeilandsBlockEntities;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Pair;

public class ClientCommon 
{
	public static final int CEILTRUNK_COLOUR = 0xCFFF00;
	public static final int LUZAWOOD_COLOUR = 0x46C3FF;
	
	public static final List<Pair<Block, RenderType>> BLOCK_RENDERS = new ArrayList<Pair<Block, RenderType>>();
	
	public static void initializeCommonClient() {
		initializeBlockEntityRenderers();
		initializeEntityRenderers();
		initializeBlockRenderList();
	}

	private static void initializeBlockEntityRenderers() {
		BlockEntityRenderers.register(CeilandsBlockEntities.CEILANDS_SIGN, SignRenderer::new);
		BlockEntityRenderers.register(CeilandsBlockEntities.CEILANDS_HANGING_SIGN, HangingSignRenderer::new);
	}
	
	private static void initializeEntityRenderers() {
		EntityRenderers.register(CeilandsEntities.CASTLE_LORD, CastleLordRenderer::new);
		EntityRenderers.register(CeilandsEntities.SPIDER_MONARCH, SpiderMonarchRenderer::new);
		EntityRenderers.register(CeilandsEntities.CEILANDS_BOAT, (boat) -> { return new CeilandsBoatRenderer(boat, false); } );
		EntityRenderers.register(CeilandsEntities.CEILANDS_CHEST_BOAT, (boat) -> { return new CeilandsBoatRenderer(boat, true); } );
	}
	
	private static void initializeBlockRenderList() {
		setBlockRenderType(CeilandsBlocks.CEILINUM_BARS, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.CEILINUM_DOOR, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.CEILINUM_TRAPDOOR, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.CEILTRUNK_LEAVES, RenderType.cutoutMipped());
		setBlockRenderType(CeilandsBlocks.CEILTRUNK_SAPLING, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.CEILTRUNK_DOOR, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.CEILTRUNK_TRAPDOOR, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.LUZAWOOD_LEAVES, RenderType.cutoutMipped());
		setBlockRenderType(CeilandsBlocks.LUZAWOOD_SAPLING, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.LUZAWOOD_DOOR, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.LUZAWOOD_TRAPDOOR, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.POTTED_LUZAWOOD_SAPLING, RenderType.cutout());
		setBlockRenderType(CeilandsBlocks.CEILANDS_PORTAL, RenderType.translucent());
	}
	
	private static void setBlockRenderType(Block block, RenderType rendertype) {
		BLOCK_RENDERS.add(new Pair<Block, RenderType>(block, rendertype));
	}
}
