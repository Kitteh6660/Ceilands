package com.kittehmod.ceilands.forge.compat.blocks;

import java.util.Map;
import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.HollowLogClimbable;
import twilightforest.block.HollowLogHorizontal;
import twilightforest.block.HollowLogVertical;

// A workaround for janky Hollow Log block items.
public class CeilandsHollowLogItem extends BlockItem 
{
    private final HollowLogHorizontal horizontalLog;
    private final HollowLogVertical verticalLog;
    private final HollowLogClimbable climbable;

	public CeilandsHollowLogItem(Supplier<? extends HollowLogHorizontal> horizontalLog, Supplier<? extends HollowLogVertical> verticalLog, Supplier<? extends HollowLogClimbable> climbableLog, Properties properties) {
		super(verticalLog.get(), properties);
		this.horizontalLog = horizontalLog.get();
		this.verticalLog = verticalLog.get();
		this.climbable = climbableLog.get();
	}

    @Nullable
    @Override
    protected BlockState getPlacementState(BlockPlaceContext context) {
        return switch (context.getClickedFace().getAxis()) {
            case Y -> this.verticalLog.getStateForPlacement(context);
            case X, Z -> this.horizontalLog.getStateForPlacement(context);
        };
    }
    
    @Override
    public void registerBlocks(Map<Block, Item> blockItemMap, Item item) {
        super.registerBlocks(blockItemMap, item);
        blockItemMap.put(this.horizontalLog, item);
        blockItemMap.put(this.verticalLog, item);
        blockItemMap.put(this.climbable, item);
    }

    @Override
    public void removeFromBlockToItemMap(Map<Block, Item> blockItemMap, Item item) {
        super.removeFromBlockToItemMap(blockItemMap, item);
        blockItemMap.remove(this.horizontalLog);
        blockItemMap.remove(this.verticalLog);
        blockItemMap.remove(this.climbable);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 300;
    }
}
