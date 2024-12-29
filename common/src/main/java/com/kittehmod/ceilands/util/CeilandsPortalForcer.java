package com.kittehmod.ceilands.util;

import java.util.Comparator;
import java.util.Optional;

import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsPOIType;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalForcer;

public class CeilandsPortalForcer extends PortalForcer
{
	protected final ServerLevel level;
	
	public CeilandsPortalForcer(ServerLevel level) {
		super(level);
		this.level = level;
	}
	
    @Override
    public Optional<BlockPos> findClosestPortalPosition(BlockPos pos, boolean p_352309_, WorldBorder worldBorder) {
        PoiManager poimanager = this.level.getPoiManager();
        int i = p_352309_ ? 16 : 128;
        poimanager.ensureLoadedAndValid(this.level, pos, i);
        return poimanager.getInSquare(p_230634_ -> p_230634_.is(CeilandsPOIType.CEILANDS_PORTAL), pos, i, PoiManager.Occupancy.ANY).map(PoiRecord::getPos)
        	.filter(worldBorder::isWithinBounds).filter(position -> this.level.getBlockState(position).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).min(Comparator.<BlockPos>comparingDouble(p_352046_ -> p_352046_.distSqr(pos)).thenComparingInt(Vec3i::getY));
    }

    @Override
    public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0;
        BlockPos blockpos = null;
        double d1 = -1.0;
        BlockPos blockpos1 = null;
        WorldBorder worldborder = this.level.getWorldBorder();
        int i = Math.min(this.level.getMaxBuildHeight(), this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
        int j = 1;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for (BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int k = Math.min(i, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getZ()));
            if (worldborder.isWithinBounds(blockpos$mutableblockpos1) && worldborder.isWithinBounds(blockpos$mutableblockpos1.move(direction, 1))) {
                blockpos$mutableblockpos1.move(direction.getOpposite(), 1);

                for (int l = k; l >= this.level.getMinBuildHeight(); l--) {
                    blockpos$mutableblockpos1.setY(l);
                    if (this.canPortalReplaceBlock(blockpos$mutableblockpos1)) {
                        int i1 = l;

                        while (l > this.level.getMinBuildHeight() && this.canPortalReplaceBlock(blockpos$mutableblockpos1.move(Direction.DOWN))) {
                            l--;
                        }

                        if (l + 4 <= i) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                blockpos$mutableblockpos1.setY(l);
                                if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 0)) {
                                    double d2 = pos.distSqr(blockpos$mutableblockpos1);
                                    if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, -1)
                                        && this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 1)
                                        && (d0 == -1.0 || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = blockpos$mutableblockpos1.immutable();
                                    }

                                    if (d0 == -1.0 && (d1 == -1.0 || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = blockpos$mutableblockpos1.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0 && d1 != -1.0) {
            blockpos = blockpos1;
            d0 = d1;
        }

        if (d0 == -1.0) {
            int k1 = Math.max(this.level.getMinBuildHeight() - -1, 70);
            int i2 = i - 9;
            if (i2 < k1) {
                return Optional.empty();
            }

            blockpos = new BlockPos(pos.getX() - direction.getStepX() * 1, Mth.clamp(pos.getY(), k1, i2), pos.getZ() - direction.getStepZ() * 1).immutable();
            blockpos = worldborder.clampToBounds(blockpos);
            Direction direction1 = direction.getClockWise();

            for (int i3 = -1; i3 < 2; i3++) {
                for (int j3 = 0; j3 < 2; j3++) {
                    for (int k3 = -1; k3 < 3; k3++) {
                        BlockState blockstate1 = k3 < 0 ? CeilandsBlocks.POLISHED_CEILINGNEOUS.defaultBlockState() : Blocks.AIR.defaultBlockState();
                        blockpos$mutableblockpos.setWithOffset(
                            blockpos, j3 * direction.getStepX() + i3 * direction1.getStepX(), k3, j3 * direction.getStepZ() + i3 * direction1.getStepZ()
                        );
                        this.level.setBlockAndUpdate(blockpos$mutableblockpos, blockstate1);
                    }
                }
            }
        }

        for (int l1 = -1; l1 < 3; l1++) {
            for (int j2 = -1; j2 < 4; j2++) {
                if (l1 == -1 || l1 == 2 || j2 == -1 || j2 == 3) {
                    blockpos$mutableblockpos.setWithOffset(blockpos, l1 * direction.getStepX(), j2, l1 * direction.getStepZ());
                    this.level.setBlock(blockpos$mutableblockpos, CeilandsBlocks.POLISHED_CEILINGNEOUS.defaultBlockState(), 3);
                }
            }
        }

        BlockState blockstate = CeilandsBlocks.CEILANDS_PORTAL.defaultBlockState().setValue(NetherPortalBlock.AXIS, axis);

        for (int k2 = 0; k2 < 2; k2++) {
            for (int l2 = 0; l2 < 3; l2++) {
                blockpos$mutableblockpos.setWithOffset(blockpos, k2 * direction.getStepX(), l2, k2 * direction.getStepZ());
                this.level.setBlock(blockpos$mutableblockpos, blockstate, 18);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
    }

    private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos p_248971_) {
        BlockState blockstate = this.level.getBlockState(p_248971_);
        return blockstate.canBeReplaced() && blockstate.getFluidState().isEmpty();
    }

    private boolean canHostFrame(BlockPos pos, BlockPos.MutableBlockPos mutablePos, Direction dir, int maxDist) {
        Direction direction = dir.getClockWise();

        for (int i = -1; i < 3; i++) {
            for (int j = -1; j < 4; j++) {
                mutablePos.setWithOffset(pos, direction.getStepX() * i + direction.getStepX() * maxDist, j, direction.getStepZ() * i + direction.getStepZ() * maxDist);
                if (j < 0 && !this.level.getBlockState(mutablePos).isSolid()) {
                    return false;
                }

                if (j >= 0 && !this.canPortalReplaceBlock(mutablePos)) {
                    return false;
                }
            }
        }

        return true;
    }
}
