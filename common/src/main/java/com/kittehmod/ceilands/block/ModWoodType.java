package com.kittehmod.ceilands.block;

import com.kittehmod.ceilands.Ceilands;

import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodType extends WoodType
{
	public static final WoodType CEILTRUNK = WoodType.register(new ModWoodType(Ceilands.MOD_ID + ":ceiltrunk"));
	public static final WoodType LUZAWOOD = WoodType.register(new ModWoodType(Ceilands.MOD_ID + ":luzawood"));
	
	public ModWoodType(String id) {
		super(id);
	}
}
