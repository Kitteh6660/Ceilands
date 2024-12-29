package com.kittehmod.ceilands.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModBlockSetType
{
	public static final BlockSetType CEILINGNEOUS = BlockSetType.register(new BlockSetType("ceilingneous", true, true, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.STONE,
        SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN,
        SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON
    ));

	public static final BlockSetType CEILTRUNK = BlockSetType.register(new BlockSetType("ceiltrunk"));
	public static final BlockSetType LUZAWOOD = BlockSetType.register(new BlockSetType("luzawood"));
}
