package com.kittehmod.ceilands.registry;

import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;

public class CeilandsGameRules 
{
	public static final GameRules.Key<BooleanValue> CEILANDS_VOID_TELEPORT = GameRules.register("ceilandsVoidTeleport", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	
	public static void setup() {} // Only exists to load this classfile.
}
