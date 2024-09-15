package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.blockentities.ModSignBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;

public class CeilandsBlockEntities
{
	public static final BlockEntityType<ModSignBlockEntity> CEILANDS_SIGN = BlockEntityType.Builder.of(ModSignBlockEntity::new, CeilandsBlocks.CEILTRUNK_SIGN, CeilandsBlocks.CEILTRUNK_WALL_SIGN, CeilandsBlocks.LUZAWOOD_SIGN, CeilandsBlocks.LUZAWOOD_WALL_SIGN).build(null);
}
