package com.kittehmod.ceilands.block;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

public class ModBedBlock extends BedBlock
{
	public ModBedBlock(DyeColor dye, Properties properties) {
		super(dye, properties);
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
}
