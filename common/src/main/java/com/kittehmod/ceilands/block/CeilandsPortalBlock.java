package com.kittehmod.ceilands.block;

import java.util.Optional;

import org.jetbrains.annotations.Nullable;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsDimension;
import com.kittehmod.ceilands.tags.CeilandsBlockTags;
import com.kittehmod.ceilands.util.CeilandsPortalForcer;

import net.minecraft.BlockUtil;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.Portal;

public class CeilandsPortalBlock extends Block implements Portal
{
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final int AABB_OFFSET = 2;
	protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

	public CeilandsPortalBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
	}
	
	/*public BlockState updateShape(BlockState currentState, Direction dir, BlockState newState, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
		if (!canPortalBlockStay(level, pos1)) {
			return Blocks.AIR.defaultBlockState();
		}
		else {
			return currentState;
		}
	}*/
	
    @Override
    public BlockState updateShape(BlockState currentState, Direction dir, BlockState newState, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
		Direction.Axis $$6 = dir.getAxis();
		Direction.Axis $$7 = currentState.getValue(AXIS);
		boolean $$8 = $$7 != $$6 && $$6.isHorizontal();
		return !$$8 && !newState.is(this) && !new PortalShape(level, pos1, $$7).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(currentState, dir, newState, level, pos1, pos2);
    }
	
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		switch ((Direction.Axis) state.getValue(AXIS)) {
		case Z:
			return Z_AXIS_AABB;
		case X:
		default:
			return X_AXIS_AABB;
		}
	}

	public boolean canPortalBlockStay(LevelAccessor level, BlockPos pos) {
		boolean flag = true;
		if (!(level.getBlockState(pos.above()).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS) || level.getBlockState(pos.above()).is(CeilandsBlocks.CEILANDS_PORTAL))) {
			flag = false;
		}
		if (!(level.getBlockState(pos.below()).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS) || level.getBlockState(pos.below()).is(CeilandsBlocks.CEILANDS_PORTAL))) {
			flag = false;
		}
		if (!(level.getBlockState(pos.relative(Direction.fromAxisAndDirection(level.getBlockState(pos).getValue(AXIS), AxisDirection.POSITIVE), 1)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS) || level.getBlockState(pos.relative(Direction.fromAxisAndDirection(level.getBlockState(pos).getValue(AXIS), AxisDirection.POSITIVE), 1)).is(CeilandsBlocks.CEILANDS_PORTAL))) {
			flag = false;
		}
		if (!(level.getBlockState(pos.relative(Direction.fromAxisAndDirection(level.getBlockState(pos).getValue(AXIS), AxisDirection.NEGATIVE), 1)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS) || level.getBlockState(pos.relative(Direction.fromAxisAndDirection(level.getBlockState(pos).getValue(AXIS), AxisDirection.NEGATIVE), 1)).is(CeilandsBlocks.CEILANDS_PORTAL))) {
			flag = false;
		}
		return flag;
	}
	
	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity.canUsePortal(false)) {
        	entity.setAsInsidePortal(this, pos);
        }
	}
	
	@Override
	public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
        ResourceKey<Level> resourcekey = level.dimension() == CeilandsDimension.CEILANDS ? Level.OVERWORLD : CeilandsDimension.CEILANDS;
        ServerLevel serverlevel = level.getServer().getLevel(resourcekey);
        if (serverlevel == null) {
            return null;
        } else {
            boolean flag = serverlevel.dimension() == CeilandsDimension.CEILANDS;
            WorldBorder worldborder = serverlevel.getWorldBorder();
            double d0 = DimensionType.getTeleportationScale(level.dimensionType(), serverlevel.dimensionType());
            BlockPos blockpos = worldborder.clampToBounds(entity.getX() * d0, entity.getY(), entity.getZ() * d0);
            return this.getExitPortal(serverlevel, entity, pos, blockpos, flag, worldborder);
        }
	}
	
	/*private void handleEntityTeleport(BlockState state, Level level, BlockPos pos, Entity entity) {
		MinecraftServer minecraftserver = ((ServerLevel)level).getServer();
		ResourceKey<Level> levelToChoose = entity.level() == minecraftserver.getLevel(CeilandsDimension.CEILANDS) ? Level.OVERWORLD : CeilandsDimension.CEILANDS;
		ServerLevel destinationWorld = minecraftserver.getLevel(levelToChoose);
		if (destinationWorld == null) {
			return;
		}
		CeilandsPortalHelper helper = new CeilandsPortalHelper(destinationWorld);
		DimensionTransition portalInfo = helper.getPortalInfo(entity, destinationWorld, null);
		entity.portalEntrancePos = pos.immutable();
		// entity.changeDimension(destinationWorld);
		entity.teleportTo(destinationWorld, portalInfo.pos().x, portalInfo.pos().y, portalInfo.pos().z, null, portalInfo.yRot(), portalInfo.xRot()); // This works much better than changeDimension.
		entity.setPortalCooldown();
	}*/
	
    @Nullable
    private DimensionTransition getExitPortal(ServerLevel level, Entity entity, BlockPos pos1, BlockPos pos2, boolean p_350326_, WorldBorder border) {
        Optional<BlockPos> optional = level.getPortalForcer().findClosestPortalPosition(pos2, p_350326_, border);
        BlockUtil.FoundRectangle blockutil$foundrectangle;
        DimensionTransition.PostDimensionTransition dimensiontransition$postdimensiontransition;
        if (optional.isPresent()) {
            BlockPos blockpos = optional.get();
            BlockState blockstate = level.getBlockState(blockpos);
            blockutil$foundrectangle = BlockUtil.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, pos -> level.getBlockState(pos) == blockstate);
            dimensiontransition$postdimensiontransition = DimensionTransition.PLAY_PORTAL_SOUND.then(p_351967_ -> p_351967_.placePortalTicket(blockpos));
        } else {
            Direction.Axis direction$axis = entity.level().getBlockState(pos1).getOptionalValue(AXIS).orElse(Direction.Axis.X);
            Optional<BlockUtil.FoundRectangle> optional1 = level.getPortalForcer().createPortal(pos2, direction$axis);
            if (optional1.isEmpty()) {
                Ceilands.LOGGER.error("Unable to create a portal, likely target out of worldborder");
                return null;
            }

            blockutil$foundrectangle = optional1.get();
            dimensiontransition$postdimensiontransition = DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET);
        }

        return getDimensionTransitionFromExit(entity, pos1, blockutil$foundrectangle, level, dimensiontransition$postdimensiontransition);
    }
	
    private static DimensionTransition getDimensionTransitionFromExit(Entity p_350906_, BlockPos p_350376_, BlockUtil.FoundRectangle p_350428_, ServerLevel p_350928_, DimensionTransition.PostDimensionTransition p_352093_) {
        BlockState blockstate = p_350906_.level().getBlockState(p_350376_);
        Direction.Axis direction$axis;
        Vec3 vec3;
        if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            BlockUtil.FoundRectangle blockutil$foundrectangle = BlockUtil.getLargestRectangleAround(
                p_350376_, direction$axis, 21, Direction.Axis.Y, 21, p_351016_ -> p_350906_.level().getBlockState(p_351016_) == blockstate
            );
            vec3 = p_350906_.getRelativePortalPosition(direction$axis, blockutil$foundrectangle);
        } else {
            direction$axis = Direction.Axis.X;
            vec3 = new Vec3(0.5, 0.0, 0.0);
        }

        return createDimensionTransition(
            p_350928_, p_350428_, direction$axis, vec3, p_350906_, p_350906_.getDeltaMovement(), p_350906_.getYRot(), p_350906_.getXRot(), p_352093_
        );
    }

    private static DimensionTransition createDimensionTransition(ServerLevel level, BlockUtil.FoundRectangle rectangle, Direction.Axis axis, Vec3 p_351020_, Entity entity, Vec3 p_350266_, float p_350648_, float p_350338_, DimensionTransition.PostDimensionTransition p_352441_) {
        BlockPos blockpos = rectangle.minCorner;
        BlockState blockstate = level.getBlockState(blockpos);
        Direction.Axis direction$axis = blockstate.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
        double d0 = (double)rectangle.axis1Size;
        double d1 = (double)rectangle.axis2Size;
        EntityDimensions entitydimensions = entity.getDimensions(entity.getPose());
        int i = axis == direction$axis ? 0 : 90;
        Vec3 vec3 = axis == direction$axis ? p_350266_ : new Vec3(p_350266_.z, p_350266_.y, -p_350266_.x);
        double d2 = (double)entitydimensions.width() / 2.0 + (d0 - (double)entitydimensions.width()) * p_351020_.x();
        double d3 = (d1 - (double)entitydimensions.height()) * p_351020_.y();
        double d4 = 0.5 + p_351020_.z();
        boolean flag = direction$axis == Direction.Axis.X;
        Vec3 vec31 = new Vec3((double)blockpos.getX() + (flag ? d2 : d4), (double)blockpos.getY() + d3, (double)blockpos.getZ() + (flag ? d4 : d2));
        Vec3 vec32 = PortalShape.findCollisionFreePosition(vec31, level, entity, entitydimensions);
        return new DimensionTransition(level, vec32, vec3, p_350648_ + (float)i, p_350338_, p_352441_);
    }	
    
    @Override
    public Portal.Transition getLocalTransition() {
        return Portal.Transition.CONFUSION;
    }
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if (random.nextInt(100) == 0) {
			level.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
		}

		for (int i = 0; i < 4; ++i) {
			double d0 = (double) pos.getX() + random.nextDouble();
			double d1 = (double) pos.getY() + random.nextDouble();
			double d2 = (double) pos.getZ() + random.nextDouble();
			double d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			double d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			double d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			int j = random.nextInt(2) * 2 - 1;
			if (!level.getBlockState(pos.west()).is(this) && !level.getBlockState(pos.east()).is(this)) {
				d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
				d3 = (double) (random.nextFloat() * 2.0F * (float) j);
			} else {
				d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
				d5 = (double) (random.nextFloat() * 2.0F * (float) j);
			}

			level.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
		}

	}

	public ItemStack getCloneItemStack(BlockGetter p_54911_, BlockPos p_54912_, BlockState p_54913_) {
		return ItemStack.EMPTY;
	}

	public BlockState rotate(BlockState state, Rotation rotation) {
		switch (rotation) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch ((Direction.Axis) state.getValue(AXIS)) {
			case Z:
				return state.setValue(AXIS, Direction.Axis.X);
			case X:
				return state.setValue(AXIS, Direction.Axis.Z);
			default:
				return state;
			}
		default:
			return state;
		}
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}
}
