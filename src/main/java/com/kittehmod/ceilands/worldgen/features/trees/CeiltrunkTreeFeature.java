package com.kittehmod.ceilands.worldgen.features.trees;

import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.BiConsumer;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageSetter;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;

public class CeiltrunkTreeFeature extends Feature<TreeConfiguration>
{
	public CeiltrunkTreeFeature(Codec<TreeConfiguration> codecIn) {
		super(codecIn);
	}

	public static boolean isFree(LevelSimulatedReader level, BlockPos pos) {
		return validTreePos(level, pos) || level.isStateAtPosition(pos, (state) -> { return state.is(BlockTags.LOGS); });
	}

	private static boolean isVine(LevelSimulatedReader level, BlockPos pos) {
		return level.isStateAtPosition(pos, (state) -> { return state.is(Blocks.VINE); });
	}

	private static boolean isBlockWater(LevelSimulatedReader level, BlockPos pos) {
		return level.isStateAtPosition(pos, (state) -> { return state.is(Blocks.WATER); });
	}

	public static boolean isAirOrLeaves(LevelSimulatedReader level, BlockPos pos) {
		return level.isStateAtPosition(pos, (state) -> { return state.isAir() || state.is(BlockTags.LEAVES); });
	}

	private static boolean isReplaceablePlant(LevelSimulatedReader level, BlockPos pos) {
		return level.isStateAtPosition(pos, (blockstate) -> {
			return blockstate.canBeReplaced();
		});
	}

	public static void setBlockKnownShape(LevelWriter p_236408_0_, BlockPos p_236408_1_, BlockState p_236408_2_) {
		p_236408_0_.setBlock(p_236408_1_, p_236408_2_, 19);
	}

	public static boolean validTreePos(LevelSimulatedReader level, BlockPos pos) {
		return isAirOrLeaves(level, pos) || isReplaceablePlant(level, pos) || isBlockWater(level, pos);
	}

	/**
	 * Called when placing the tree feature.
	 */
	private boolean doPlace(WorldGenLevel level, RandomSource source, BlockPos pos, BiConsumer<BlockPos, BlockState> consumer1, BiConsumer<BlockPos, BlockState> consumer2, FoliageSetter foliage, TreeConfiguration config) {
		int trunkHeight = config.trunkPlacer.getTreeHeight(source);
		int foliageHeight = config.foliagePlacer.foliageHeight(source, trunkHeight, config);
		int k = trunkHeight + foliageHeight;
		int l = config.foliagePlacer.foliageRadius(source, k);
		BlockPos blockpos = config.rootPlacer.map((rootplacer) -> { return rootplacer.getTrunkOrigin(pos, source); }).orElse(pos);
		int i1 = Math.min(pos.getY(), blockpos.getY());
		int j1 = Math.max(pos.getY(), blockpos.getY()) + trunkHeight + 1;
		if (!isFree(level, pos.below())) {
			return false;
		}
		if (i1 >= level.getMinBuildHeight() + 1 && j1 <= level.getMaxBuildHeight()) {
			OptionalInt optionalint = config.minimumSize.minClippedHeight();
			int k1 = this.getMaxFreeTreeHeight(level, trunkHeight, blockpos, config);
			if (k1 >= -trunkHeight || !optionalint.isEmpty() && k1 >= optionalint.getAsInt()) {
				if (config.rootPlacer.isPresent() && !config.rootPlacer.get().placeRoots(level, consumer1, source, pos, blockpos, config)) {
					return false;
				} else {
					List<FoliagePlacer.FoliageAttachment> list = config.trunkPlacer.placeTrunk(level, consumer2, source, k1, blockpos, config);
					list.forEach((p_225279_) -> { config.foliagePlacer.createFoliage(level, foliage, source, config, k1, p_225279_, foliageHeight, l); });
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private int getMaxFreeTreeHeight(LevelSimulatedReader reader, int height, BlockPos pos, TreeConfiguration config) {
		MutableBlockPos blockpos$mutable = new MutableBlockPos();

		for (int i = 0; i <= height + 1; ++i) {
			int j = config.minimumSize.getSizeAtHeight(height, -i);

			for (int k = -j; k <= j; ++k) {
				for (int l = -j; l <= j; ++l) {
					blockpos$mutable.setWithOffset(pos, k, -i, l);
					if (!isFree(reader, blockpos$mutable) || !config.ignoreVines && isVine(reader, blockpos$mutable)) {
						return i - 2;
					}
				}
			}
		}

		return height;
	}

	@Override
	public final boolean place(FeaturePlaceContext<TreeConfiguration> placeContxt) {
		WorldGenLevel worldgenlevel = placeContxt.level();
		RandomSource randomsource = placeContxt.random();
		BlockPos blockpos = placeContxt.origin();
		TreeConfiguration treeconfiguration = placeContxt.config();
		Set<BlockPos> set = Sets.newHashSet();
		Set<BlockPos> set1 = Sets.newHashSet();
		Set<BlockPos> set2 = Sets.newHashSet();
		Set<BlockPos> set3 = Sets.newHashSet();
		BiConsumer<BlockPos, BlockState> biconsumer = (pos, state) -> {
			set.add(pos.immutable());
			worldgenlevel.setBlock(pos, state, 19);
		};
		BiConsumer<BlockPos, BlockState> biconsumer1 = (pos, state) -> {
			set1.add(pos.immutable());
			worldgenlevel.setBlock(pos, state, 19);
		};
		FoliageSetter foliage = new FoliagePlacer.FoliageSetter() {
         public void set(BlockPos pos, BlockState state) {
            set2.add(pos.immutable());
            worldgenlevel.setBlock(pos, state, 19);
         }

         public boolean isSet(BlockPos state) {
            return set2.contains(state);
         }
      };
		BiConsumer<BlockPos, BlockState> biconsumer3 = (pos, state) -> {
			set3.add(pos.immutable());
			worldgenlevel.setBlock(pos, state, 19);
		};
		boolean flag = this.doPlace(worldgenlevel, randomsource, blockpos, biconsumer, biconsumer1, foliage, treeconfiguration);
		if (flag && (!set1.isEmpty() || !set2.isEmpty())) {
			if (!treeconfiguration.decorators.isEmpty()) {
				TreeDecorator.Context treedecorator$context = new TreeDecorator.Context(worldgenlevel, biconsumer3, randomsource, set1, set2, set);
				treeconfiguration.decorators.forEach((p_160528_) -> { p_160528_.place(treedecorator$context); });
			}
			return BoundingBox.encapsulatingPositions(Iterables.concat(set, set1, set2)).map((p_160521_) -> {
				DiscreteVoxelShape discretevoxelshape = updateLeaves(worldgenlevel, p_160521_, set, set2);
				StructureTemplate.updateShapeAtEdge(worldgenlevel, 3, discretevoxelshape, p_160521_.minX(), p_160521_.minY(), p_160521_.minZ());
				return true;
			}).orElse(false);
		} else {
			return false;
		}
	}

	private static DiscreteVoxelShape updateLeaves(LevelAccessor worldIn, BoundingBox bbIn, Set<BlockPos> p_236403_3_, Set<BlockPos> p_236403_4_) {
		List<Set<BlockPos>> list = Lists.newArrayList();
		DiscreteVoxelShape discretevoxelshape = new BitSetDiscreteVoxelShape(bbIn.getXSpan(), bbIn.getYSpan(), bbIn.getZSpan());
		int amt = 6;

		for (int j = 0; j < amt; ++j) {
			list.add(Sets.newHashSet());
		}

		MutableBlockPos blockpos$mutable = new MutableBlockPos();

		for (BlockPos blockpos : Lists.newArrayList(p_236403_4_)) {
			if (bbIn.isInside(blockpos)) {
				discretevoxelshape.fill(blockpos.getX() - bbIn.minX(), blockpos.getY() - bbIn.minY(), blockpos.getZ() - bbIn.minZ());
			}
		}

		for (BlockPos blockpos1 : Lists.newArrayList(p_236403_3_)) {
			if (bbIn.isInside(blockpos1)) {
				discretevoxelshape.fill(blockpos1.getX() - bbIn.minX(), blockpos1.getY() - bbIn.minY(), blockpos1.getZ() - bbIn.minZ());
			}

			for (Direction direction : Direction.values()) {
				blockpos$mutable.setWithOffset(blockpos1, direction);
				if (!p_236403_3_.contains(blockpos$mutable)) {
					BlockState blockstate = worldIn.getBlockState(blockpos$mutable);
					if (blockstate.hasProperty(BlockStateProperties.DISTANCE)) {
						list.get(0).add(blockpos$mutable.immutable());
						setBlockKnownShape(worldIn, blockpos$mutable, blockstate.setValue(BlockStateProperties.DISTANCE, Integer.valueOf(1)));
						if (bbIn.isInside(blockpos$mutable)) {
							discretevoxelshape.fill(blockpos$mutable.getX() - bbIn.minX(), blockpos$mutable.getY() - bbIn.minY(), blockpos$mutable.getZ() - bbIn.minZ());
						}
					}
				}
			}
		}

		for (int l = 1; l < amt; ++l) {
			Set<BlockPos> set = list.get(l - 1);
			Set<BlockPos> set1 = list.get(l);

			for (BlockPos blockpos2 : set) {
				if (bbIn.isInside(blockpos2)) {
					discretevoxelshape.fill(blockpos2.getX() - bbIn.minX(), blockpos2.getY() - bbIn.minY(), blockpos2.getZ() - bbIn.minZ());
				}

				for (Direction direction1 : Direction.values()) {
					blockpos$mutable.setWithOffset(blockpos2, direction1);
					if (!set.contains(blockpos$mutable) && !set1.contains(blockpos$mutable)) {
						BlockState blockstate1 = worldIn.getBlockState(blockpos$mutable);
						if (blockstate1.hasProperty(BlockStateProperties.DISTANCE)) {
							int k = blockstate1.getValue(BlockStateProperties.DISTANCE);
							if (k > l + 1) {
								BlockState blockstate2 = blockstate1.setValue(BlockStateProperties.DISTANCE, Integer.valueOf(l + 1));
								setBlockKnownShape(worldIn, blockpos$mutable, blockstate2);
								if (bbIn.isInside(blockpos$mutable)) {
									discretevoxelshape.fill(blockpos$mutable.getX() - bbIn.minX(), blockpos$mutable.getY() - bbIn.minY(), blockpos$mutable.getZ() - bbIn.minZ());
								}

								set1.add(blockpos$mutable.immutable());
							}
						}
					}
				}
			}
		}

		return discretevoxelshape;
	}

}
