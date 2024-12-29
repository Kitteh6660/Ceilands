package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;
import com.kittehmod.ceilands.entity.mob.CastleLord;
import com.kittehmod.ceilands.entity.mob.SpiderMonarch;
import com.kittehmod.ceilands.entity.vehicle.ModBoat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import oshi.util.tuples.Pair;

public class CeilandsEntities
{
	public static void init() {};
	
	/** Creates and registers entity. */
	private static EntityType registerEntity(String name, EntityType entity) {
		ENTITIES.add(new Pair<ResourceLocation, EntityType<?>>(ResourceLocation.fromNamespaceAndPath(Ceilands.MOD_ID, name), entity));
		return entity;
	}

	public static final List<Pair<ResourceLocation, EntityType<?>>> ENTITIES = new ArrayList<Pair<ResourceLocation, EntityType<?>>>();
	
	public static final EntityType<CastleLord> CASTLE_LORD = registerEntity("castle_lord", EntityType.Builder.<CastleLord>of(CastleLord::new, MobCategory.MONSTER).sized(0.6F, 1.9F).build("castle_lord"));
	public static final EntityType<SpiderMonarch> SPIDER_MONARCH = registerEntity("spider_monarch", EntityType.Builder.<SpiderMonarch>of(SpiderMonarch::new, MobCategory.MONSTER).sized(2.5F, 1.8F).build("spider_monarch"));

	public static final EntityType<ModBoat> CEILANDS_BOAT = registerEntity("ceilands_boat", EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build("ceilands_boat"));
	public static final EntityType<ModBoat> CEILANDS_CHEST_BOAT = registerEntity("ceilands_chest_boat", EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build("ceilands_chest_boat"));
}
