package com.kittehmod.ceilands.item;

import java.util.ArrayList;

import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.world.item.Item;
import oshi.util.tuples.Pair;

public class CeilandsFuels {
	
	public static final ArrayList<Pair<Item, Integer>> CEILANDS_FUELS = new ArrayList();
	
	static {
		CEILANDS_FUELS.add(new Pair(CeilandsItems.CEILTRUNK_FENCE_GATE, 300));
		CEILANDS_FUELS.add(new Pair(CeilandsItems.CEILTRUNK_FENCE, 300));
		CEILANDS_FUELS.add(new Pair(CeilandsItems.LUZAWOOD_FENCE_GATE, 300));
		CEILANDS_FUELS.add(new Pair(CeilandsItems.LUZAWOOD_FENCE, 300));
	}
}
