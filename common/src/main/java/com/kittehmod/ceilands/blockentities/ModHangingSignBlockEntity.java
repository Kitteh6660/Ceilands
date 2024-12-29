package com.kittehmod.ceilands.blockentities;

import com.kittehmod.ceilands.registry.CeilandsBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSignBlockEntity extends HangingSignBlockEntity
{
    private static final int MAX_TEXT_LINE_WIDTH = 60;
    private static final int TEXT_LINE_HEIGHT = 9;
    
	public ModHangingSignBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}
	
	@Override
	public BlockEntityType<?> getType() {
		return CeilandsBlockEntities.CEILANDS_HANGING_SIGN;
	}
	
	@Override
    public boolean isValidBlockState(BlockState $$0) {
        return this.getType().isValid($$0);
    }
}
