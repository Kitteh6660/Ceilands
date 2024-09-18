package com.kittehmod.ceilands.block;

import com.kittehmod.ceilands.registry.CeilandsBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class ModLogBlock extends RotatedPillarBlock
{
	public ModLogBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public ItemInteractionResult useItemOn(ItemStack itemstack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemTags.AXES)) {
			Block newBlock;
			if (state.getBlock() == CeilandsBlocks.CEILTRUNK_LOG || state.getBlock() == CeilandsBlocks.CEILTRUNK_WOOD) {
				newBlock = state.getBlock() == CeilandsBlocks.CEILTRUNK_LOG ? CeilandsBlocks.STRIPPED_CEILTRUNK_LOG : CeilandsBlocks.STRIPPED_CEILTRUNK_WOOD;
			}
			else {
				newBlock = state.getBlock() == CeilandsBlocks.LUZAWOOD_LOG ? CeilandsBlocks.STRIPPED_LUZAWOOD_LOG : CeilandsBlocks.STRIPPED_LUZAWOOD_WOOD;
			}
            if (player != null) {
                itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            }
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newBlock.defaultBlockState()));
			level.setBlock(pos, newBlock.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)), 11);
			return ItemInteractionResult.sidedSuccess(level.isClientSide());
		}
		return super.useItemOn(itemstack, state, level, pos, player, hand, result);
	}
}
