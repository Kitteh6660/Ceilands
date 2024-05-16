package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.blockentities.ModHangingSignBlockEntity;
import com.kittehmod.ceilands.blockentities.ModSignBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;

public class CeilandsBlockEntities
{
	public static final BlockEntityType<ModSignBlockEntity> CEILANDS_SIGN = BlockEntityType.Builder.of(ModSignBlockEntity::new, CeilandsBlocks.CEILTRUNK_SIGN, CeilandsBlocks.CEILTRUNK_WALL_SIGN, CeilandsBlocks.LUZAWOOD_SIGN, CeilandsBlocks.LUZAWOOD_WALL_SIGN).build(null);
	public static final BlockEntityType<ModHangingSignBlockEntity> CEILANDS_HANGING_SIGN = BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, CeilandsBlocks.CEILTRUNK_HANGING_SIGN, CeilandsBlocks.CEILTRUNK_WALL_HANGING_SIGN, CeilandsBlocks.LUZAWOOD_HANGING_SIGN, CeilandsBlocks.LUZAWOOD_WALL_HANGING_SIGN).build(null);
}
