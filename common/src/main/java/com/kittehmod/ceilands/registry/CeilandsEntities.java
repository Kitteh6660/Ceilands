package com.kittehmod.ceilands.registry;

import com.kittehmod.ceilands.entity.mob.CastleLord;
import com.kittehmod.ceilands.entity.vehicle.ModBoat;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class CeilandsEntities
{
	public static final EntityType<CastleLord> CASTLE_LORD = EntityType.Builder.<CastleLord>of(CastleLord::new, MobCategory.MONSTER).sized(0.6F, 1.9F).build("castle_lord");

	public static final EntityType<ModBoat> CEILANDS_BOAT = EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build("ceilands_boat"); //.setCustomClientFactory((spawnEntity, world) -> new ModBoat(world, 0, 0, 0))
	public static final EntityType<ModBoat> CEILANDS_CHEST_BOAT = EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build("ceilands_chest_boat"); //.setCustomClientFactory((spawnEntity, world) -> new ModChestBoat(world, 0, 0, 0))
}
