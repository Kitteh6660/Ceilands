package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.blockentities.ModHangingSignBlockEntity;
import com.kittehmod.ceilands.blockentities.ModSignBlockEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import oshi.util.tuples.Pair;

public class CeilandsBlockEntities
{
	public static void init() {};
	
	/** Creates and registers block entity. */
	private static BlockEntityType registerBlockEntity(String name, BlockEntityType blockentity) {
		BLOCK_ENTITIES.add(new Pair<ResourceLocation, BlockEntityType<?>>(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, name), blockentity));
		return blockentity;
	}
	
	public static final List<Pair<ResourceLocation, BlockEntityType<?>>> BLOCK_ENTITIES = new ArrayList<Pair<ResourceLocation, BlockEntityType<?>>>();
	
	public static final BlockEntityType<ModSignBlockEntity> CEILANDS_SIGN = registerBlockEntity("ceilands_sign", BlockEntityType.Builder.of(ModSignBlockEntity::new, CeilandsBlocks.CEILTRUNK_SIGN, CeilandsBlocks.CEILTRUNK_WALL_SIGN, CeilandsBlocks.LUZAWOOD_SIGN, CeilandsBlocks.LUZAWOOD_WALL_SIGN).build(null));
	public static final BlockEntityType<ModHangingSignBlockEntity> CEILANDS_HANGING_SIGN = registerBlockEntity("ceilands_hanging_sign", BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, CeilandsBlocks.CEILTRUNK_HANGING_SIGN, CeilandsBlocks.CEILTRUNK_WALL_HANGING_SIGN, CeilandsBlocks.LUZAWOOD_HANGING_SIGN, CeilandsBlocks.LUZAWOOD_WALL_HANGING_SIGN).build(null));
}
