package com.kittehmod.ceilands.worldgen.features.trees;

import java.util.Optional;

import com.kittehmod.ceilands.registry.CeilandsFeatures;

import net.minecraft.world.level.block.grower.TreeGrower;

public class CeilandsTreeGrower 
{
	public static final TreeGrower CEILTRUNK = new TreeGrower("ceiltrunk", Optional.of(CeilandsFeatures.CEILTRUNK_TREE_LARGE), Optional.of(CeilandsFeatures.CEILTRUNK_TREE_REGULAR), Optional.of(CeilandsFeatures.CEILTRUNK_TREE_BEES));
	public static final TreeGrower LUZAWOOD = new TreeGrower("luzawood", 0.3F, Optional.empty(), Optional.empty(), Optional.of(CeilandsFeatures.LUZAWOOD_TREE_SINGLE), Optional.of(CeilandsFeatures.LUZAWOOD_TREE_DOUBLE), Optional.of(CeilandsFeatures.LUZAWOOD_TREE_SINGLE_BEES), Optional.of(CeilandsFeatures.LUZAWOOD_TREE_DOUBLE_BEES));
}
