package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.entity.ModBoat;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class CeilandsEntities
{
	public static final EntityType<ModBoat> CEILANDS_BOAT = EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build("ceilands_boat"); //.setCustomClientFactory((spawnEntity, world) -> new ModBoat(world, 0, 0, 0))
	public static final EntityType<ModBoat> CEILANDS_CHEST_BOAT = EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build("ceilands_chest_boat"); //.setCustomClientFactory((spawnEntity, world) -> new ModChestBoat(world, 0, 0, 0))
}
