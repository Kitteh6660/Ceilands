package com.kittehmod.ceilands.registry;

import java.util.function.ToIntFunction;

import com.kittehmod.ceilands.block.CeilandsPortalBlock;
import com.kittehmod.ceilands.block.CeilingSaplingBlock;
import com.kittehmod.ceilands.block.ModBlockSetType;
import com.kittehmod.ceilands.block.ModCeilingHangingSignBlock;
import com.kittehmod.ceilands.block.ModLogBlock;
import com.kittehmod.ceilands.block.ModStandingSignBlock;
import com.kittehmod.ceilands.block.ModWallHangingSignBlock;
import com.kittehmod.ceilands.block.ModWallSignBlock;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.worldgen.features.trees.CeilandsTreeGrower;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockSetType.PressurePlateSensitivity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class CeilandsBlocks
{
	public static final Block CEILANDS_PORTAL = new CeilandsPortalBlock(BlockBehaviour.Properties.of().strength(-1.0F, 0.0F).lightLevel((light) -> { return 8; } ).noCollission().noOcclusion());
	
	public static final Block CEILINGNEOUS = new Block(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
	public static final Block CEILINGNEOUS_STAIRS = new StairBlock(CEILINGNEOUS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CEILINGNEOUS)) {};
	public static final Block CEILINGNEOUS_SLAB = new SlabBlock(BlockBehaviour.Properties.ofFullCopy(CEILINGNEOUS));
	public static final Block CEILINGNEOUS_WALL = new WallBlock(BlockBehaviour.Properties.ofFullCopy(CEILINGNEOUS));

	public static final Block POLISHED_CEILINGNEOUS = new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE));
	public static final Block POLISHED_CEILINGNEOUS_STAIRS = new StairBlock(POLISHED_CEILINGNEOUS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_CEILINGNEOUS)) {};
	public static final Block POLISHED_CEILINGNEOUS_SLAB = new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_CEILINGNEOUS));
	public static final Block POLISHED_CEILINGNEOUS_WALL = new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_CEILINGNEOUS));
	
	public static final Block CEILINGNEOUS_BRICKS = new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE));
	public static final Block CEILINGNEOUS_BRICK_STAIRS = new StairBlock(CEILINGNEOUS_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CEILINGNEOUS_BRICKS)) {};
	public static final Block CEILINGNEOUS_BRICK_SLAB = new SlabBlock(BlockBehaviour.Properties.ofFullCopy(CEILINGNEOUS_BRICKS));
	public static final Block CEILINGNEOUS_BRICK_WALL = new WallBlock(BlockBehaviour.Properties.ofFullCopy(CEILINGNEOUS_BRICKS));

	public static final Block CRACKED_CEILINGNEOUS_BRICKS = new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE));
	public static final Block CHISELED_CEILINGNEOUS = new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE));
	
	public static final Block CEILINGNEOUS_BUTTON = new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.STONE).noCollission()) {};
	public static final Block CEILINGNEOUS_PRESSURE_PLATE = new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(0.5F).sound(SoundType.STONE)) {};
	
	public static final Block CEILINGNEOUS_COAL_ORE = new DropExperienceBlock(UniformInt.of(0, 2), BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
	public static final Block CEILINGNEOUS_COPPER_ORE = new DropExperienceBlock(UniformInt.of(0, 0), BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
	public static final Block CEILINGNEOUS_IRON_ORE = new DropExperienceBlock(UniformInt.of(0, 0), BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
	public static final Block CEILINGNEOUS_GOLD_ORE = new DropExperienceBlock(UniformInt.of(0, 0), BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
	public static final Block CEILINGNEOUS_DIAMOND_ORE = new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
	public static final Block CEILINGNEOUS_REDSTONE_ORE = new RedStoneOreBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel(litBlockEmission(9)));
	public static final Block CEILINGNEOUS_LAPIS_ORE = new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
	public static final Block CEILINGNEOUS_EMERALD_ORE = new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
	
	public static final Block CEILTRUNK_LOG = new ModLogBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block STRIPPED_CEILTRUNK_LOG = new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block CEILTRUNK_WOOD = new ModLogBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block STRIPPED_CEILTRUNK_WOOD = new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {}; 
	public static final Block CEILTRUNK_LEAVES = new LeavesBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.AZALEA_LEAVES).noOcclusion().ignitedByLava());
	public static final Block CEILTRUNK_SAPLING = new CeilingSaplingBlock(CeilandsTreeGrower.CEILTRUNK, BlockBehaviour.Properties.of().instabreak().sound(SoundType.GRASS).randomTicks().noCollission().ignitedByLava());
	public static final Block CEILTRUNK_PLANKS = new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block CEILTRUNK_STAIRS = new StairBlock(CEILTRUNK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block CEILTRUNK_SLAB = new SlabBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block CEILTRUNK_FENCE = new FenceBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block CEILTRUNK_BUTTON = new ButtonBlock(ModBlockSetType.CEILTRUNK, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD)) {};
	public static final Block CEILTRUNK_PRESSURE_PLATE = new PressurePlateBlock(ModBlockSetType.CEILTRUNK, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block CEILTRUNK_DOOR = new DoorBlock(ModBlockSetType.CEILTRUNK, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()) {};
	public static final Block CEILTRUNK_TRAPDOOR = new TrapDoorBlock(ModBlockSetType.CEILTRUNK, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()) {};
	public static final Block CEILTRUNK_FENCE_GATE = new FenceGateBlock(ModWoodType.CEILTRUNK, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block CEILTRUNK_SIGN = new ModStandingSignBlock(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK);
	public static final Block CEILTRUNK_WALL_SIGN = new ModWallSignBlock(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK);
	public static final Block CEILTRUNK_HANGING_SIGN = new ModCeilingHangingSignBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission(), ModWoodType.CEILTRUNK);
	public static final Block CEILTRUNK_WALL_HANGING_SIGN = new ModWallHangingSignBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK);
	
	public static final Block LUZAWOOD_LOG = new ModLogBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block STRIPPED_LUZAWOOD_LOG = new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block LUZAWOOD_WOOD = new ModLogBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block STRIPPED_LUZAWOOD_WOOD = new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block LUZAWOOD_LEAVES = new LeavesBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.AZALEA_LEAVES).noOcclusion().ignitedByLava()) {};
	public static final Block LUZAWOOD_SAPLING = new SaplingBlock(CeilandsTreeGrower.LUZAWOOD, BlockBehaviour.Properties.of().instabreak().sound(SoundType.GRASS).randomTicks().noCollission().ignitedByLava()) {};
	public static final Block POTTED_LUZAWOOD_SAPLING = new FlowerPotBlock(LUZAWOOD_SAPLING, BlockBehaviour.Properties.of().instabreak().noCollission());
	public static final Block LUZAWOOD_PLANKS = new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block LUZAWOOD_STAIRS = new StairBlock(LUZAWOOD_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block LUZAWOOD_SLAB = new SlabBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block LUZAWOOD_FENCE = new FenceBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block LUZAWOOD_BUTTON = new ButtonBlock(ModBlockSetType.LUZAWOOD, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD)) {};
	public static final Block LUZAWOOD_PRESSURE_PLATE = new PressurePlateBlock(ModBlockSetType.LUZAWOOD, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block LUZAWOOD_DOOR = new DoorBlock(ModBlockSetType.LUZAWOOD, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()) {};
	public static final Block LUZAWOOD_TRAPDOOR = new TrapDoorBlock(ModBlockSetType.LUZAWOOD, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()) {};
	public static final Block LUZAWOOD_FENCE_GATE = new FenceGateBlock(ModWoodType.LUZAWOOD, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {};
	public static final Block LUZAWOOD_SIGN = new ModStandingSignBlock(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD);
	public static final Block LUZAWOOD_WALL_SIGN = new ModWallSignBlock(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD);
	public static final Block LUZAWOOD_HANGING_SIGN = new ModCeilingHangingSignBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission(), ModWoodType.LUZAWOOD);
	public static final Block LUZAWOOD_WALL_HANGING_SIGN = new ModWallHangingSignBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD);
	
	private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
		return (p_50763_) -> {
			return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
		};
	}
}
