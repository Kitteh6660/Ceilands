package com.kittehmod.ceilands.forge.mixin;

import org.spongepowered.asm.mixin.Mixin;

import com.kittehmod.ceilands.block.ModLogBlock;
import com.kittehmod.ceilands.registry.CeilandsBlocks;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

@Mixin(ModLogBlock.class)
public class ModLogBlockMixin extends RotatedPillarBlock
{
	public ModLogBlockMixin(Properties properties) {
		super(properties); // Does nothing.
	}

	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
		Block newBlock;
		if (toolAction == ToolActions.AXE_STRIP) {
			if (state.getBlock() == CeilandsBlocks.CEILTRUNK_LOG || state.getBlock() == CeilandsBlocks.CEILTRUNK_WOOD) {
				newBlock = state.getBlock() == CeilandsBlocks.CEILTRUNK_LOG ? CeilandsBlocks.STRIPPED_CEILTRUNK_LOG : CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD;
			}
			else {
				newBlock = state.getBlock() == CeilandsBlocks.LUZAWOOD_LOG ? CeilandsBlocks.STRIPPED_LUZAWOOD_LOG : CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD;
			}
			return newBlock != null ? newBlock.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)) : null;
		}
		return super.getToolModifiedState(state, context, toolAction, simulate);
	}
}
