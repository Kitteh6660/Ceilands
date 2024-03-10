package com.kittehmod.ceilands.entity;

import com.kittehmod.ceilands.CeilandsMod;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CeilandsEntities
{
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CeilandsMod.MODID);
	
	public static final RegistryObject<EntityType<ModBoat>> CEILANDS_BOAT = ENTITIES.register("ceilands_boat", () -> EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new ModBoat(world, 0, 0, 0)).build("ceilands_boat"));
	public static final RegistryObject<EntityType<ModBoat>> CEILANDS_CHEST_BOAT = ENTITIES.register("ceilands_chest_boat", () -> EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new ModChestBoat(world, 0, 0, 0)).build("ceilands_chest_boat"));
}
