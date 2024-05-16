package com.kittehmod.ceilands.block;

import java.util.ArrayList;

import com.kittehmod.ceilands.registry.CeilandsBlocks;

import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Triplet;

public class CeilandsFlammableBlocks 
{
	public static final ArrayList<Triplet<Block, Integer, Integer>> CEILANDS_FLAMMABLE_BLOCKS = new ArrayList();
	
	static {
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.CEILTRUNK_PLANKS, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.LUZAWOOD_PLANKS, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.CEILTRUNK_SLAB, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.LUZAWOOD_SLAB, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.CEILTRUNK_STAIRS, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.LUZAWOOD_STAIRS, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.CEILTRUNK_FENCE, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.LUZAWOOD_FENCE, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.CEILTRUNK_FENCE_GATE, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.LUZAWOOD_FENCE_GATE, 5, 20));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.CEILTRUNK_LOG, 5, 5));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.LUZAWOOD_LOG, 5, 5));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.CEILTRUNK_WOOD, 5, 5));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.LUZAWOOD_WOOD, 5, 5));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.STRIPPED_CEILTRUNK_LOG, 5, 5));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.STRIPPED_LUZAWOOD_LOG, 5, 5));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD, 5, 5));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD, 5, 5));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.CEILTRUNK_LEAVES, 30, 60));
		CEILANDS_FLAMMABLE_BLOCKS.add(new Triplet(CeilandsBlocks.LUZAWOOD_LEAVES, 30, 60));
	}
}
