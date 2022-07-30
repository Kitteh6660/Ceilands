package kittehmod.ceilands.block;

import java.util.function.ToIntFunction;

import kittehmod.ceilands.CeilandsMod;
import kittehmod.ceilands.worldgen.features.trees.CeiltrunkTreeGrower;
import kittehmod.ceilands.worldgen.features.trees.LuzawoodTreeGrower;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
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
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("deprecation")
public class CeilandsBlocks
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CeilandsMod.MODID);

	public static final RegistryObject<Block> CEILANDS_PORTAL = BLOCKS.register("ceilands_portal", () -> new CeilandsPortalBlock(BlockBehaviour.Properties.of(Material.PORTAL).strength(-1.0F, 0.0F).lightLevel((light) -> { return 8; } ).noCollission().noOcclusion()));
	
	public static final RegistryObject<Block> CEILINGNEOUS = BLOCKS.register("ceilingneous", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final RegistryObject<Block> CEILINGNEOUS_STAIRS = BLOCKS.register("ceilingneous_stairs", () -> new StairBlock(() -> CEILINGNEOUS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CEILINGNEOUS.get())));
	public static final RegistryObject<Block> CEILINGNEOUS_SLAB = BLOCKS.register("ceilingneous_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CEILINGNEOUS.get())));
	public static final RegistryObject<Block> CEILINGNEOUS_WALL = BLOCKS.register("ceilingneous_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(CEILINGNEOUS.get())));

	public static final RegistryObject<Block> POLISHED_CEILINGNEOUS = BLOCKS.register("polished_ceilingneous", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_CEILINGNEOUS_STAIRS = BLOCKS.register("polished_ceilingneous_stairs", () -> new StairBlock(() -> POLISHED_CEILINGNEOUS.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_CEILINGNEOUS.get())));
	public static final RegistryObject<Block> POLISHED_CEILINGNEOUS_SLAB = BLOCKS.register("polished_ceilingneous_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_CEILINGNEOUS.get())));
	public static final RegistryObject<Block> POLISHED_CEILINGNEOUS_WALL = BLOCKS.register("polished_ceilingneous_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_CEILINGNEOUS.get())));
	
	public static final RegistryObject<Block> CEILINGNEOUS_BRICKS = BLOCKS.register("ceilingneous_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CEILINGNEOUS_BRICK_STAIRS = BLOCKS.register("ceilingneous_brick_stairs", () -> new StairBlock(() -> CEILINGNEOUS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CEILINGNEOUS_BRICKS.get())));
	public static final RegistryObject<Block> CEILINGNEOUS_BRICK_SLAB = BLOCKS.register("ceilingneous_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CEILINGNEOUS_BRICKS.get())));
	public static final RegistryObject<Block> CEILINGNEOUS_BRICK_WALL = BLOCKS.register("ceilingneous_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(CEILINGNEOUS_BRICKS.get())));

	public static final RegistryObject<Block> CRACKED_CEILINGNEOUS_BRICKS = BLOCKS.register("cracked_ceilingneous_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_CEILINGNEOUS = BLOCKS.register("chiseled_ceilingneous", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> CEILINGNEOUS_BUTTON = BLOCKS.register("ceilingneous_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.STONE).noCollission().strength(0.5F).sound(SoundType.STONE).noCollission()));
	public static final RegistryObject<Block> CEILINGNEOUS_PRESSURE_PLATE = BLOCKS.register("ceilingneous_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(0.5F).sound(SoundType.STONE)));	
	
	public static final RegistryObject<Block> CEILINGNEOUS_COAL_ORE = BLOCKS.register("ceilingneous_coal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(0, 2)));
	public static final RegistryObject<Block> CEILINGNEOUS_COPPER_ORE = BLOCKS.register("ceilingneous_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final RegistryObject<Block> CEILINGNEOUS_IRON_ORE = BLOCKS.register("ceilingneous_iron_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final RegistryObject<Block> CEILINGNEOUS_GOLD_ORE = BLOCKS.register("ceilingneous_gold_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final RegistryObject<Block> CEILINGNEOUS_DIAMOND_ORE = BLOCKS.register("ceilingneous_diamond_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> CEILINGNEOUS_REDSTONE_ORE = BLOCKS.register("ceilingneous_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel(litBlockEmission(9))));
	public static final RegistryObject<Block> CEILINGNEOUS_LAPIS_ORE = BLOCKS.register("ceilingneous_lapis_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(2, 5)));
	public static final RegistryObject<Block> CEILINGNEOUS_EMERALD_ORE = BLOCKS.register("ceilingneous_emerald_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(3, 7)));
	
	public static final RegistryObject<Block> CEILTRUNK_LOG = BLOCKS.register("ceiltrunk_log", () -> new ModLogBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_CEILTRUNK_LOG = BLOCKS.register("stripped_ceiltrunk_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_WOOD = BLOCKS.register("ceiltrunk_wood", () -> new ModLogBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_CEILTRUNK_WOOD = BLOCKS.register("stripped_ceiltrunk_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_LEAVES = BLOCKS.register("ceiltrunk_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.5F).sound(SoundType.AZALEA_LEAVES).noOcclusion()));
	public static final RegistryObject<Block> CEILTRUNK_SAPLING = BLOCKS.register("ceiltrunk_sapling", () -> new CeilingSaplingBlock(new CeiltrunkTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).randomTicks().noCollission()));
	public static final RegistryObject<Block> CEILTRUNK_PLANKS = BLOCKS.register("ceiltrunk_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_STAIRS = BLOCKS.register("ceiltrunk_stairs", () -> new StairBlock(() -> CEILTRUNK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_SLAB = BLOCKS.register("ceiltrunk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_FENCE = BLOCKS.register("ceiltrunk_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_BUTTON = BLOCKS.register("ceiltrunk_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_PRESSURE_PLATE = BLOCKS.register("ceiltrunk_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_DOOR = BLOCKS.register("ceiltrunk_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> CEILTRUNK_TRAPDOOR = BLOCKS.register("ceiltrunk_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> CEILTRUNK_FENCE_GATE = BLOCKS.register("ceiltrunk_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CEILTRUNK_SIGN = BLOCKS.register("ceiltrunk_sign", () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK));
	public static final RegistryObject<Block> CEILTRUNK_WALL_SIGN = BLOCKS.register("ceiltrunk_wall_sign", () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.CEILTRUNK));
	
	public static final RegistryObject<Block> LUZAWOOD_LOG = BLOCKS.register("luzawood_log", () -> new ModLogBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_LUZAWOOD_LOG = BLOCKS.register("stripped_luzawood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_WOOD = BLOCKS.register("luzawood_wood", () -> new ModLogBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_LUZAWOOD_WOOD = BLOCKS.register("stripped_luzawood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_LEAVES = BLOCKS.register("luzawood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.5F).sound(SoundType.AZALEA_LEAVES).noOcclusion()));
	public static final RegistryObject<Block> LUZAWOOD_SAPLING = BLOCKS.register("luzawood_sapling", () -> new SaplingBlock(new LuzawoodTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).randomTicks().noCollission()));
	public static final RegistryObject<Block> POTTED_LUZAWOOD_SAPLING = BLOCKS.register("potted_luzawood_sapling", () -> new FlowerPotBlock(LUZAWOOD_SAPLING.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noCollission()));
	public static final RegistryObject<Block> LUZAWOOD_PLANKS = BLOCKS.register("luzawood_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_STAIRS = BLOCKS.register("luzawood_stairs", () -> new StairBlock(() -> LUZAWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_SLAB = BLOCKS.register("luzawood_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_FENCE = BLOCKS.register("luzawood_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_BUTTON = BLOCKS.register("luzawood_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_PRESSURE_PLATE = BLOCKS.register("luzawood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_DOOR = BLOCKS.register("luzawood_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> LUZAWOOD_TRAPDOOR = BLOCKS.register("luzawood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> LUZAWOOD_FENCE_GATE = BLOCKS.register("luzawood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LUZAWOOD_SIGN = BLOCKS.register("luzawood_sign", () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD));
	public static final RegistryObject<Block> LUZAWOOD_WALL_SIGN = BLOCKS.register("luzawood_wall_sign", () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.LUZAWOOD));
	
	private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
		return (p_50763_) -> {
			return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
		};
	}
}
