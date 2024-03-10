package com.kittehmod.ceilands.blockentities;

import com.kittehmod.ceilands.CeilandsMod;
import com.kittehmod.ceilands.block.CeilandsBlocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CeilandsBlockEntities
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CeilandsMod.MODID);
	
	public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> CEILANDS_SIGN = BLOCK_ENTITIES.register("ceilands_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, CeilandsBlocks.CEILTRUNK_SIGN.get(), CeilandsBlocks.CEILTRUNK_WALL_SIGN.get(), CeilandsBlocks.LUZAWOOD_SIGN.get(), CeilandsBlocks.LUZAWOOD_WALL_SIGN.get()).build(null));
	public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> CEILANDS_HANGING_SIGN = BLOCK_ENTITIES.register("ceilands_hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, CeilandsBlocks.CEILTRUNK_HANGING_SIGN.get(), CeilandsBlocks.CEILTRUNK_WALL_HANGING_SIGN.get(), CeilandsBlocks.LUZAWOOD_HANGING_SIGN.get(), CeilandsBlocks.LUZAWOOD_WALL_HANGING_SIGN.get()).build(null));
}
