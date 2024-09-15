package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.worldgen.structures.ChainProcessor;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class CeilandsProcessors
{
	public static final StructureProcessorType<ChainProcessor> HANGING_CHAINS = () -> ChainProcessor.CODEC;
}
