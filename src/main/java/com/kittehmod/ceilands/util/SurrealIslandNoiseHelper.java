package com.kittehmod.ceilands.util;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import net.minecraft.world.level.levelgen.OreVeinifier;

public class SurrealIslandNoiseHelper
{
	// simplex2d(x, z) < veinThreshold && |simplex3d(x, y, z)| < wallThickness && worleyNoise3d(x, y, z) < webThickness
	/*public boolean isWithinNoise(RandomSource random, int x, int y, int z, float veinThreshold, float wallThickness, float webThickness) {
		SimplexNoise simplex = new SimplexNoise(random);
		return simplex.getValue(x, z) < veinThreshold && simplex.getValue(x, y, z) < wallThickness && worleyNoise3d(x, y, z) < webThickness;
	}*/
	
}
