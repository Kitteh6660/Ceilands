package com.kittehmod.ceilands.item;

import com.kittehmod.ceilands.block.CeilandsBlockTags;
import com.kittehmod.ceilands.block.CeilandsBlocks;
import com.kittehmod.ceilands.block.CeilandsPortalBlock;
import com.kittehmod.ceilands.worldgen.dimension.CeilandsDimension;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CeilandsPortalActivatorItem extends Item
{

	public CeilandsPortalActivatorItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public InteractionResult useOn(UseOnContext context) {
		Player player = context.getPlayer();
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos().relative(context.getClickedFace(), 1);
		BlockState state = level.getBlockState(pos);
		if (!level.isClientSide()) {
			if (inPortalDimension(level)) {
				//optional = net.minecraftforge.event.ForgeEventFactory.onTrySpawnPortal(level, pos, optional);
				if (isPortal(level, pos, player.getDirection().getClockWise(), true)) {
					level.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
					return InteractionResult.SUCCESS;
				}
			}
			if (!state.canSurvive(level, pos)) {
				level.removeBlock(pos, false);
			}
		}
		else {
			if (isPortal(level, pos, player.getDirection().getClockWise(), true)) {
				
			}
		}
		return InteractionResult.PASS;
	}

	private static boolean inPortalDimension(Level level) {
		return level.dimension() == Level.OVERWORLD || level.dimension() == Level.NETHER || level.dimension() == CeilandsDimension.CEILANDS;
	}

	private static boolean isPortal(Level level, BlockPos pos, Direction dir, boolean setBlocks) {
		if (!inPortalDimension(level)) {
			return false;
		} else {
			//BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();
			// Check portal frames.
			for (int i = 0; i < 23; i++) {
				for (int j = 0; j < 23; j++) {
					if (level.getBlockState(pos.below(i).relative(dir, j)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
						break;
					}
					else if (!(level.getBlockState(pos.below(i).relative(dir, j)).is(CeilandsBlockTags.CEILANDS_PORTAL_REPLACEABLES))) {
						return false;
					}
					if (j >= 22) {
						return false;
					}
				}
				for (int j = 0; j < 23; j++) {
					if (level.getBlockState(pos.below(i).relative(dir.getOpposite(), j)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
						break;
					}
					else if (!(level.getBlockState(pos.below(i).relative(dir.getOpposite(), j)).is(CeilandsBlockTags.CEILANDS_PORTAL_REPLACEABLES))) {
						return false;
					}
					if (j >= 22) {
						return false;
					}
				}
				if (level.getBlockState(pos.below(i)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
					break;
				}
				if (i >= 22) {
					return false;
				}
			}
			for (int i = 0; i < 23; i++) {
				for (int j = 0; j < 23; j++) {
					if (level.getBlockState(pos.above(i).relative(dir, j)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
						break;
					}
					else if (!(level.getBlockState(pos.above(i).relative(dir, j)).is(CeilandsBlockTags.CEILANDS_PORTAL_REPLACEABLES))) {
						return false;
					}
					if (j >= 22) {
						return false;
					}
				}
				for (int j = 0; j < 23; j++) {
					if (level.getBlockState(pos.above(i).relative(dir.getOpposite(), j)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
						break;
					}
					else if (!(level.getBlockState(pos.above(i).relative(dir.getOpposite(), j)).is(CeilandsBlockTags.CEILANDS_PORTAL_REPLACEABLES))) {
						return false;
					}
					if (j >= 22) {
						return false;
					}
				}
				if (level.getBlockState(pos.above(i)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
					break;
				}
				if (i >= 22) {
					return false;
				}
			}
			if (!setBlocks) {
				return true;
			}
			// Fill portal blocks downwards.
			for (int i = 0; i < 23; i++) {
				for (int j = 0; j < 23; j++) {
					if (level.getBlockState(pos.below(i).relative(dir, j)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
						break;
					}
					if (level.getBlockState(pos.below(i).relative(dir, j)).is(CeilandsBlockTags.CEILANDS_PORTAL_REPLACEABLES)) {
						level.setBlock(pos.below(i).relative(dir, j), CeilandsBlocks.CEILANDS_PORTAL.get().defaultBlockState().setValue(CeilandsPortalBlock.AXIS, dir.getAxis()), 11);
					}
				}
				for (int j = 0; j < 23; j++) {
					if (level.getBlockState(pos.below(i).relative(dir.getOpposite(), j)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
						break;
					}
					if (level.getBlockState(pos.below(i).relative(dir.getOpposite(), j)).is(CeilandsBlockTags.CEILANDS_PORTAL_REPLACEABLES)) {
						level.setBlock(pos.below(i).relative(dir.getOpposite(), j), CeilandsBlocks.CEILANDS_PORTAL.get().defaultBlockState().setValue(CeilandsPortalBlock.AXIS, dir.getAxis()), 11);
					}
				}
				if (level.getBlockState(pos.below(i)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
					break;
				}
			}
			// Fill portal blocks upwards.
			for (int i = 0; i < 23; i++) {
				for (int j = 0; j < 23; j++) {
					if (level.getBlockState(pos.above(i).relative(dir, j)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
						break;
					}
					if (level.getBlockState(pos.above(i).relative(dir, j)).is(CeilandsBlockTags.CEILANDS_PORTAL_REPLACEABLES)) {
						level.setBlock(pos.above(i).relative(dir, j), CeilandsBlocks.CEILANDS_PORTAL.get().defaultBlockState().setValue(CeilandsPortalBlock.AXIS, dir.getAxis()), 11);
					}
				}
				for (int j = 0; j < 23; j++) {
					if (level.getBlockState(pos.above(i).relative(dir.getOpposite(), j)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
						break;
					}
					if (level.getBlockState(pos.above(i).relative(dir.getOpposite(), j)).is(CeilandsBlockTags.CEILANDS_PORTAL_REPLACEABLES)) {
						level.setBlock(pos.above(i).relative(dir.getOpposite(), j), CeilandsBlocks.CEILANDS_PORTAL.get().defaultBlockState().setValue(CeilandsPortalBlock.AXIS, dir.getAxis()), 11);
					}
				}
				if (level.getBlockState(pos.above(i)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS)) {
					break;
				}
			}
			return true;
		}
	}
}
