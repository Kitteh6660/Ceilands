package com.kittehmod.ceilands.worldgen.structures;

import com.kittehmod.ceilands.CeilandsMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CeilandsProcessors
{
	public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSORS = DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, CeilandsMod.MODID);

	public static final RegistryObject<StructureProcessorType<ChainProcessor>> HANGING_CHAINS = STRUCTURE_PROCESSORS.register("hanging_chains", () -> () -> ChainProcessor.CODEC);
}
