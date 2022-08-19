package kittehmod.ceilands.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class ModLogBlock extends RotatedPillarBlock
{
	public ModLogBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
		Block newBlock;
		if (toolAction == ToolActions.AXE_STRIP) {
			if (state.getBlock() == CeilandsBlocks.CEILTRUNK_LOG.get() || state.getBlock() == CeilandsBlocks.CEILTRUNK_WOOD.get()) {
				newBlock = state.getBlock() == CeilandsBlocks.CEILTRUNK_LOG.get() ? CeilandsBlocks.STRIPPED_CEILTRUNK_LOG.get() : CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD.get();
			}
			else {
				newBlock = state.getBlock() == CeilandsBlocks.LUZAWOOD_LOG.get() ? CeilandsBlocks.STRIPPED_LUZAWOOD_LOG.get() : CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD.get();
			}
			return newBlock != null ? newBlock.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)) : null;
		}
		return super.getToolModifiedState(state, context, toolAction, simulate);
	}
}
