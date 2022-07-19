package kittehmod.ceilands.block;

import kittehmod.ceilands.worldgen.dimension.CeilandsDimension;
import kittehmod.ceilands.worldgen.dimension.CeilandsTeleporter;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.Rotation;

public class CeilandsPortalBlock extends Block
{
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final int AABB_OFFSET = 2;
	protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

	public CeilandsPortalBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
	}
	
	public BlockState updateShape(BlockState currentState, Direction dir, BlockState newState, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
		if (!canPortalBlockStay(level, pos1)) {
			return Blocks.AIR.defaultBlockState();
		}
		else {
			return currentState;
		}
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
		if (!(level.getBlockState(pos.above()).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS) || level.getBlockState(pos.above()).is(CeilandsBlocks.CEILANDS_PORTAL.get()))) {
			flag = false;
		}
		if (!(level.getBlockState(pos.below()).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS) || level.getBlockState(pos.below()).is(CeilandsBlocks.CEILANDS_PORTAL.get()))) {
			flag = false;
		}
		if (!(level.getBlockState(pos.relative(Direction.fromAxisAndDirection(level.getBlockState(pos).getValue(AXIS), AxisDirection.POSITIVE), 1)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS) || level.getBlockState(pos.relative(Direction.fromAxisAndDirection(level.getBlockState(pos).getValue(AXIS), AxisDirection.POSITIVE), 1)).is(CeilandsBlocks.CEILANDS_PORTAL.get()))) {
			flag = false;
		}
		if (!(level.getBlockState(pos.relative(Direction.fromAxisAndDirection(level.getBlockState(pos).getValue(AXIS), AxisDirection.NEGATIVE), 1)).is(CeilandsBlockTags.CEILANDS_PORTAL_FRAME_BLOCKS) || level.getBlockState(pos.relative(Direction.fromAxisAndDirection(level.getBlockState(pos).getValue(AXIS), AxisDirection.NEGATIVE), 1)).is(CeilandsBlocks.CEILANDS_PORTAL.get()))) {
			flag = false;
		}
		return flag;
	}
	
	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (!level.isClientSide() && !entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
			MinecraftServer minecraftserver = ((ServerLevel)level).getServer();
			ResourceKey<Level> levelToChoose = entity.getLevel() == minecraftserver.getLevel(CeilandsDimension.CEILANDS) ? Level.OVERWORLD : CeilandsDimension.CEILANDS;
			entity.handleInsidePortal(pos);
			if (!entity.isOnPortalCooldown()) {
				ServerLevel destinationWorld = minecraftserver.getLevel(levelToChoose);
				entity.setPortalCooldown();
				entity.changeDimension(minecraftserver.getLevel(levelToChoose), new CeilandsTeleporter(destinationWorld));
			}
		}
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
