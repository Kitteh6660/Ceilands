package kittehmod.ceilands.item;

import javax.annotation.Nullable;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class FurnaceFuellableBlockItem extends BlockItem
{
	private final int burnTime;
	
	public FurnaceFuellableBlockItem(Block block, Properties properties, int fuelTicks) {
		super(block, properties);
		this.burnTime = fuelTicks;
	}

	@Override
	public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
		return burnTime;
	}
}
