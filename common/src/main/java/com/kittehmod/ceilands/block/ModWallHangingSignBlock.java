package com.kittehmod.ceilands.block;

import com.kittehmod.ceilands.blockentities.ModHangingSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallHangingSignBlock extends WallHangingSignBlock
{
	public ModWallHangingSignBlock(Properties properties, WoodType woodtype) {
		super(woodtype, properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModHangingSignBlockEntity(pos, state);
	}
}
