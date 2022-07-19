package kittehmod.ceilands.worldgen.features.trees;

import kittehmod.ceilands.worldgen.features.CeilandsFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class LuzawoodTreeGrower extends AbstractTreeGrower 
{
	@Override
	protected Holder<ConfiguredFeature<TreeConfiguration, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
		if (random.nextFloat() < 0.2) {
			return bees ? CeilandsFeatures.LUZAWOOD_TREE_DOUBLE_BEES : CeilandsFeatures.LUZAWOOD_TREE_DOUBLE;
		}
		else {
			return bees ? CeilandsFeatures.LUZAWOOD_TREE_SINGLE_BEES : CeilandsFeatures.LUZAWOOD_TREE_SINGLE;
		}
	}

}
