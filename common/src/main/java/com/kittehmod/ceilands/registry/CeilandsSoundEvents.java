package com.kittehmod.ceilands.registry;

import java.util.ArrayList;
import java.util.List;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import oshi.util.tuples.Pair;

public class CeilandsSoundEvents 
{
	public static void init() {};
	
	/** Creates and registers sound events. */
	private static SoundEvent registerSoundEvent(String name, SoundEvent sound) {
		SOUND_EVENTS.add(new Pair<ResourceLocation, SoundEvent>(new ResourceLocation(Ceilands.MOD_ID, name), sound));
		return sound;
	}

	public static final List<Pair<ResourceLocation, SoundEvent>> SOUND_EVENTS = new ArrayList<Pair<ResourceLocation, SoundEvent>>();
	
	public static final SoundEvent CASTLE_LORD_AMBIENT = registerSoundEvent("entity.castle_lord.ambient", SoundEvent.createVariableRangeEvent(new ResourceLocation(Ceilands.MOD_ID, "entity.castle_lord.ambient")));
	public static final SoundEvent CASTLE_LORD_CHASING = registerSoundEvent("entity.castle_lord.chasing", SoundEvent.createVariableRangeEvent(new ResourceLocation(Ceilands.MOD_ID, "entity.castle_lord.chasing")));
	public static final SoundEvent CASTLE_LORD_DEATH = registerSoundEvent("entity.castle_lord.death", SoundEvent.createVariableRangeEvent(new ResourceLocation(Ceilands.MOD_ID, "entity.castle_lord.death")));
	public static final SoundEvent CASTLE_LORD_HURT = registerSoundEvent("entity.castle_lord.hurt", SoundEvent.createVariableRangeEvent(new ResourceLocation(Ceilands.MOD_ID, "entity.castle_lord.hurt")));
	public static final SoundEvent SPIDER_MONARCH_AMBIENT = registerSoundEvent("entity.spider_monarch.ambient", SoundEvent.createVariableRangeEvent(new ResourceLocation(Ceilands.MOD_ID, "entity.spider_monarch.ambient")));
	public static final SoundEvent SPIDER_MONARCH_STEP = registerSoundEvent("entity.spider_monarch.step", SoundEvent.createVariableRangeEvent(new ResourceLocation(Ceilands.MOD_ID, "entity.spider_monarch.step")));
	public static final SoundEvent SPIDER_MONARCH_DEATH = registerSoundEvent("entity.spider_monarch.death", SoundEvent.createVariableRangeEvent(new ResourceLocation(Ceilands.MOD_ID, "entity.spider_monarch.death")));
	public static final SoundEvent SPIDER_MONARCH_HURT = registerSoundEvent("entity.spider_monarch.hurt", SoundEvent.createVariableRangeEvent(new ResourceLocation(Ceilands.MOD_ID, "entity.spider_monarch.hurt")));
}
