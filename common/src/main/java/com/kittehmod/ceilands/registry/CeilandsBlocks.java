package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.block.CeilandsPortalBlock;
import com.kittehmod.ceilands.block.CeilingSaplingBlock;
import com.kittehmod.ceilands.block.ModBedBlock;
import com.kittehmod.ceilands.block.ModBlockSetType;
import com.kittehmod.ceilands.block.ModCeilingHangingSignBlock;
import com.kittehmod.ceilands.block.ModLogBlock;
import com.kittehmod.ceilands.block.ModStandingSignBlock;
import com.kittehmod.ceilands.block.ModWallHangingSignBlock;
import com.kittehmod.ceilands.block.ModWallSignBlock;
import com.kittehmod.ceilands.block.ModWoodType;
import com.kittehmod.ceilands.worldgen.features.trees.CeiltrunkTreeGrower;
import com.kittehmod.ceilands.worldgen.features.trees.LuzawoodTreeGrower;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import oshi.util.tuples.Pair;

public class CeilandsBlocks
{
	public static void init() {};
	
	/** Creates and registers block. */
	private static Block registerBlock(String name, Block block) {
		BLOCKS.add(new Pair<ResourceLocation, Block>(new ResourceLocation(Ceilands.MOD_ID, name), block));
		return block;
	}

	public static final List<Pair<ResourceLocation, Block>> BLOCKS = new ArrayList<Pair<ResourceLocation, Block>>();

	
	// Ceilingneous
	public static final Block CEILINGNEOUS = registerBlock("ceilingneous", new Block(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final Block CEILINGNEOUS_STAIRS = registerBlock("ceilingneous_stairs", new StairBlock(CEILINGNEOUS.defaultBlockState(), BlockBehaviour.Properties.copy(CEILINGNEOUS)){});
	public static final Block CEILINGNEOUS_SLAB = registerBlock("ceilingneous_slab", new SlabBlock(BlockBehaviour.Properties.copy(CEILINGNEOUS)));
	public static final Block CEILINGNEOUS_WALL = registerBlock("ceilingneous_wall", new WallBlock(BlockBehaviour.Properties.copy(CEILINGNEOUS)));

	public static final Block POLISHED_CEILINGNEOUS = registerBlock("polished_ceilingneous", new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block POLISHED_CEILINGNEOUS_STAIRS = registerBlock("polished_ceilingneous_stairs", new StairBlock(POLISHED_CEILINGNEOUS.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_CEILINGNEOUS)){});
	public static final Block POLISHED_CEILINGNEOUS_SLAB = registerBlock("polished_ceilingneous_slab", new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_CEILINGNEOUS)));
	public static final Block POLISHED_CEILINGNEOUS_WALL = registerBlock("polished_ceilingneous_wall", new WallBlock(BlockBehaviour.Properties.copy(POLISHED_CEILINGNEOUS)));
	
	public static final Block CEILINGNEOUS_BRICKS = registerBlock("ceilingneous_bricks", new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block CEILINGNEOUS_BRICK_STAIRS = registerBlock("ceilingneous_brick_stairs", new StairBlock(CEILINGNEOUS_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(CEILINGNEOUS_BRICKS)){});
	public static final Block CEILINGNEOUS_BRICK_SLAB = registerBlock("ceilingneous_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(CEILINGNEOUS_BRICKS)));
	public static final Block CEILINGNEOUS_BRICK_WALL = registerBlock("ceilingneous_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(CEILINGNEOUS_BRICKS)));

	public static final Block CRACKED_CEILINGNEOUS_BRICKS = registerBlock("cracked_ceilingneous_bricks", new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block CHISELED_CEILINGNEOUS = registerBlock("chiseled_ceilingneous", new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final Block CEILINGNEOUS_BUTTON = registerBlock("ceilingneous_button", new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.STONE), BlockSetType.STONE, 20, false){});
	public static final Block CEILINGNEOUS_PRESSURE_PLATE = registerBlock("ceilingneous_pressure_plate", new PressurePlateBlock(Sensitivity.MOBS, BlockBehaviour.Properties.of().noCollission().requiresCorrectToolForDrops().strength(0.5F).sound(SoundType.STONE), BlockSetType.STONE){});
	
	// Roofshale
	public static final Block ROOFSHALE = registerBlock("roofshale", new Block(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final Block ROOFSHALE_STAIRS = registerBlock("roofshale_stairs", new StairBlock(ROOFSHALE.defaultBlockState(), BlockBehaviour.Properties.copy(ROOFSHALE)){});
	public static final Block ROOFSHALE_SLAB = registerBlock("roofshale_slab", new SlabBlock(BlockBehaviour.Properties.copy(ROOFSHALE)));
	public static final Block ROOFSHALE_WALL = registerBlock("roofshale_wall", new WallBlock(BlockBehaviour.Properties.copy(ROOFSHALE)));

	public static final Block POLISHED_ROOFSHALE = registerBlock("polished_roofshale", new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block POLISHED_ROOFSHALE_STAIRS = registerBlock("polished_roofshale_stairs", new StairBlock(POLISHED_ROOFSHALE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_ROOFSHALE)){});
	public static final Block POLISHED_ROOFSHALE_SLAB = registerBlock("polished_roofshale_slab", new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_ROOFSHALE)));
	public static final Block POLISHED_ROOFSHALE_WALL = registerBlock("polished_roofshale_wall", new WallBlock(BlockBehaviour.Properties.copy(POLISHED_ROOFSHALE)));
	
	public static final Block ROOFSHALE_BRICKS = registerBlock("roofshale_bricks", new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block ROOFSHALE_BRICK_STAIRS = registerBlock("roofshale_brick_stairs", new StairBlock(ROOFSHALE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(ROOFSHALE_BRICKS)){});
	public static final Block ROOFSHALE_BRICK_SLAB = registerBlock("roofshale_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(ROOFSHALE_BRICKS)));
	public static final Block ROOFSHALE_BRICK_WALL = registerBlock("roofshale_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(ROOFSHALE_BRICKS)));

	public static final Block CHISELED_ROOFSHALE = registerBlock("chiseled_roofshale", new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block CHISELED_ROOFSHALE_BRICKS = registerBlock("chiseled_roofshale_bricks", new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));

	// Ore Blocks
	public static final Block CEILINGNEOUS_COAL_ORE = registerBlock("ceilingneous_coal_ore", new DropExperienceBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(0, 2)));
	public static final Block CEILINGNEOUS_COPPER_ORE = registerBlock("ceilingneous_copper_ore", new DropExperienceBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final Block CEILINGNEOUS_IRON_ORE = registerBlock("ceilingneous_iron_ore", new DropExperienceBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final Block CEILINGNEOUS_GOLD_ORE = registerBlock("ceilingneous_gold_ore", new DropExperienceBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final Block CEILINGNEOUS_DIAMOND_ORE = registerBlock("ceilingneous_diamond_ore", new DropExperienceBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(3, 7)));
	public static final Block CEILINGNEOUS_REDSTONE_ORE = registerBlock("ceilingneous_redstone_ore", new RedStoneOreBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel(litBlockEmission(9))));
	public static final Block CEILINGNEOUS_LAPIS_ORE = registerBlock("ceilingneous_lapis_ore", new DropExperienceBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(2, 5)));
	public static final Block CEILINGNEOUS_EMERALD_ORE = registerBlock("ceilingneous_emerald_ore", new DropExperienceBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(3, 7)));
	
	// Ceilinum
	public static final Block CEILINUM_ORE = registerBlock("ceilinum_ore", new DropExperienceBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(0, 2)));
	public static final Block RAW_CEILINUM_BLOCK = registerBlock("raw_ceilinum_block", new Block(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final Block CEILINUM_BLOCK = registerBlock("ceilinum_block", new Block(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));

	public static final Block CUT_CEILINUM = registerBlock("cut_ceilinum", new Block(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final Block CUT_CEILINUM_STAIRS = registerBlock("cut_ceilinum_stairs", new StairBlock(CUT_CEILINUM.defaultBlockState(), BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)){});
	public static final Block CUT_CEILINUM_SLAB = registerBlock("cut_ceilinum_slab", new SlabBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final Block CHISELED_CEILINUM = registerBlock("chiseled_ceilinum", new Block(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final Block CEILINUM_BARS = registerBlock("ceilinum_bars", new IronBarsBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)){});

	public static final Block CEILINUM_DOOR = registerBlock("ceilinum_door", new DoorBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion(), BlockSetType.IRON){});
	public static final Block CEILINUM_TRAPDOOR = registerBlock("ceilinum_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion(), BlockSetType.IRON){});
	
	// Ceiltrunk Wood Set
	public static final Block CEILTRUNK_LOG = registerBlock("ceiltrunk_log", new ModLogBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block STRIPPED_CEILTRUNK_LOG = registerBlock("stripped_ceiltrunk_log", new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block CEILTRUNK_WOOD = registerBlock("ceiltrunk_wood", new ModLogBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block STRIPPED_CEILTRUNK_WOOD = registerBlock("stripped_ceiltrunk_wood", new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){}); 
	public static final Block CEILTRUNK_LEAVES = registerBlock("ceiltrunk_leaves", new LeavesBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.AZALEA_LEAVES).noOcclusion()));
	public static final Block CEILTRUNK_SAPLING = registerBlock("ceiltrunk_sapling", new CeilingSaplingBlock(new CeiltrunkTreeGrower(), BlockBehaviour.Properties.of().instabreak().sound(SoundType.GRASS).randomTicks().noCollission()));
	public static final Block CEILTRUNK_PLANKS = registerBlock("ceiltrunk_planks", new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block CEILTRUNK_STAIRS = registerBlock("ceiltrunk_stairs", new StairBlock(CEILTRUNK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block CEILTRUNK_SLAB = registerBlock("ceiltrunk_slab", new SlabBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block CEILTRUNK_FENCE = registerBlock("ceiltrunk_fence", new FenceBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block CEILTRUNK_BUTTON = registerBlock("ceiltrunk_button", new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD), ModBlockSetType.CEILTRUNK, 30, true){});
	public static final Block CEILTRUNK_PRESSURE_PLATE = registerBlock("ceiltrunk_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD).ignitedByLava(), ModBlockSetType.CEILTRUNK){});
	public static final Block CEILTRUNK_DOOR = registerBlock("ceiltrunk_door", new DoorBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion(), ModBlockSetType.CEILTRUNK){});
	public static final Block CEILTRUNK_TRAPDOOR = registerBlock("ceiltrunk_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion(), ModBlockSetType.CEILTRUNK){});
	public static final Block CEILTRUNK_FENCE_GATE = registerBlock("ceiltrunk_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK));
	public static final Block CEILTRUNK_SIGN = registerBlock("ceiltrunk_sign", new ModStandingSignBlock(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK));
	public static final Block CEILTRUNK_WALL_SIGN = registerBlock("ceiltrunk_wall_sign", new ModWallSignBlock(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK));
	public static final Block CEILTRUNK_HANGING_SIGN = registerBlock("ceiltrunk_hanging_sign", new ModCeilingHangingSignBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission(), ModWoodType.CEILTRUNK));
	public static final Block CEILTRUNK_WALL_HANGING_SIGN = registerBlock("ceiltrunk_wall_hanging_sign", new ModWallHangingSignBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK));
	
	// Luzawood Wood Set
	public static final Block LUZAWOOD_LOG = registerBlock("luzawood_log", new ModLogBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block STRIPPED_LUZAWOOD_LOG = registerBlock("stripped_luzawood_log", new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block LUZAWOOD_WOOD = registerBlock("luzawood_wood", new ModLogBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block STRIPPED_LUZAWOOD_WOOD = registerBlock("stripped_luzawood_wood", new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){}); 
	public static final Block LUZAWOOD_LEAVES = registerBlock("luzawood_leaves", new LeavesBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.AZALEA_LEAVES).noOcclusion()));
	public static final Block LUZAWOOD_SAPLING = registerBlock("luzawood_sapling", new SaplingBlock(new LuzawoodTreeGrower(), BlockBehaviour.Properties.of().instabreak().sound(SoundType.GRASS).randomTicks().noCollission()){});
	public static final Block LUZAWOOD_PLANKS = registerBlock("luzawood_planks", new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block LUZAWOOD_STAIRS = registerBlock("luzawood_stairs", new StairBlock(LUZAWOOD_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block LUZAWOOD_SLAB = registerBlock("luzawood_slab", new SlabBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block LUZAWOOD_FENCE = registerBlock("luzawood_fence", new FenceBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)){});
	public static final Block LUZAWOOD_BUTTON = registerBlock("luzawood_button", new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD), ModBlockSetType.LUZAWOOD, 30, true){});
	public static final Block LUZAWOOD_PRESSURE_PLATE = registerBlock("luzawood_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD).ignitedByLava(), ModBlockSetType.LUZAWOOD){});
	public static final Block LUZAWOOD_DOOR = registerBlock("luzawood_door", new DoorBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion(), ModBlockSetType.LUZAWOOD){});
	public static final Block LUZAWOOD_TRAPDOOR = registerBlock("luzawood_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion(), ModBlockSetType.LUZAWOOD){});
	public static final Block LUZAWOOD_FENCE_GATE = registerBlock("luzawood_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD));
	public static final Block LUZAWOOD_SIGN = registerBlock("luzawood_sign", new ModStandingSignBlock(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD));
	public static final Block LUZAWOOD_WALL_SIGN = registerBlock("luzawood_wall_sign", new ModWallSignBlock(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD));
	public static final Block LUZAWOOD_HANGING_SIGN = registerBlock("luzawood_hanging_sign", new ModCeilingHangingSignBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD).noCollission(), ModWoodType.LUZAWOOD));
	public static final Block LUZAWOOD_WALL_HANGING_SIGN = registerBlock("luzawood_wall_hanging_sign", new ModWallHangingSignBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD));
	
	// Miscellaneous
	public static final Block CEILANDS_PORTAL = registerBlock("ceilands_portal", new CeilandsPortalBlock(BlockBehaviour.Properties.of().strength(-1.0F, 0.0F).lightLevel((light) -> { return 8; } ).noCollission().noOcclusion()));
	public static final Block POTTED_LUZAWOOD_SAPLING = registerBlock("potted_luzawood_sapling", new FlowerPotBlock(LUZAWOOD_SAPLING, BlockBehaviour.Properties.of().instabreak().noCollission()));

	public static final Block SPIDER_SILK_BLOCK = registerBlock("spider_silk_block", new Block(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOL)));
	public static final Block SPIDER_SILK_CARPET = registerBlock("spider_silk_carpet", new CarpetBlock(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOL)));
	// public static final Block SPIDER_SILK_BED = registerBlock("spider_silk_bed", new ModBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WOOL)));

	private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
		return (p_50763_) -> {
			return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
		};
	}
}
