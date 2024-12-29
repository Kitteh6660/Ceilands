package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.CeiltrunkTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.DoubleLuzawoodTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.LargeCeiltrunkTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.LuzawoodTrunkPlacer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import oshi.util.tuples.Pair;

public class CeilandsTrunkPlacerType
{	
	public static void init() {};
	
	private static TrunkPlacerType registerTrunkPlacer(String name, TrunkPlacerType trunkplacer) {
		TRUNK_PLACERS.add(new Pair<ResourceLocation, TrunkPlacerType<?>>(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, name), trunkplacer));
		return trunkplacer;
	}

	public static final List<Pair<ResourceLocation, TrunkPlacerType<?>>> TRUNK_PLACERS = new ArrayList<Pair<ResourceLocation, TrunkPlacerType<?>>>();
	
	public static final TrunkPlacerType<CeiltrunkTrunkPlacer> CEILTRUNK_TRUNK_PLACER = registerTrunkPlacer("ceiltrunk_trunk_placer", new TrunkPlacerType<>(CeiltrunkTrunkPlacer.CODEC));
	public static final TrunkPlacerType<LargeCeiltrunkTrunkPlacer> LARGE_CEILTRUNK_TRUNK_PLACER = registerTrunkPlacer("large_ceiltrunk_trunk_placer", new TrunkPlacerType<>(LargeCeiltrunkTrunkPlacer.CODEC)); 
	public static final TrunkPlacerType<LuzawoodTrunkPlacer> LUZAWOOD_TRUNK_PLACER = registerTrunkPlacer("luzawood_trunk_placer", new TrunkPlacerType<>(LuzawoodTrunkPlacer.CODEC));
	public static final TrunkPlacerType<DoubleLuzawoodTrunkPlacer> DOUBLE_LUZAWOOD_TRUNK_PLACER = registerTrunkPlacer("double_luzawood_trunk_placer", new TrunkPlacerType<>(DoubleLuzawoodTrunkPlacer.CODEC));
}
