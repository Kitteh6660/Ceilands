package com.kittehmod.ceilands.block;

import com.kittehmod.ceilands.blockentities.ModSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallSignBlock extends WallSignBlock
{
	public ModWallSignBlock(Properties properties, WoodType woodtype) {
		super(woodtype, properties);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModSignBlockEntity(pos, state);
	}
}
