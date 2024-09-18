package com.kittehmod.ceilands.block;

import com.kittehmod.ceilands.blockentities.ModSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModStandingSignBlock extends StandingSignBlock
{

	public ModStandingSignBlock(Properties properties, WoodType woodtype) {
		super(woodtype, properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModSignBlockEntity(pos, state);
	}
}
