package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.CeiltrunkTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.DoubleLuzawoodTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.LargeCeiltrunkTrunkPlacer;
import com.kittehmod.ceilands.worldgen.features.trunkplacers.LuzawoodTrunkPlacer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class CeilandsTrunkPlacerType
{	
	public static final TrunkPlacerType<CeiltrunkTrunkPlacer> CEILTRUNK_TRUNK_PLACER = new TrunkPlacerType<>(CeiltrunkTrunkPlacer.CODEC);
	public static final TrunkPlacerType<LargeCeiltrunkTrunkPlacer> LARGE_CEILTRUNK_TRUNK_PLACER = new TrunkPlacerType<>(LargeCeiltrunkTrunkPlacer.CODEC); 
	public static final TrunkPlacerType<LuzawoodTrunkPlacer> LUZAWOOD_TRUNK_PLACER = new TrunkPlacerType<>(LuzawoodTrunkPlacer.CODEC);
	public static final TrunkPlacerType<DoubleLuzawoodTrunkPlacer> DOUBLE_LUZAWOOD_TRUNK_PLACER = new TrunkPlacerType<>(DoubleLuzawoodTrunkPlacer.CODEC);
}
