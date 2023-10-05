package kittehmod.ceilands.block;

import kittehmod.ceilands.CeilandsMod;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodType
{
	public static final WoodType CEILTRUNK = WoodType.register(new WoodType(CeilandsMod.MODID + ":ceiltrunk", ModBlockSetType.CEILTRUNK));
	public static final WoodType LUZAWOOD = WoodType.register(new WoodType(CeilandsMod.MODID + ":luzawood", ModBlockSetType.LUZAWOOD));
}
