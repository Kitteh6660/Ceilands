package com.kittehmod.ceilands.entity.vehicle;

import com.kittehmod.ceilands.registry.CeilandsBlocks;
import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ModBoat extends Boat
{
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoat.class, EntityDataSerializers.INT);

	public ModBoat(EntityType<? extends ModBoat> entity, Level level) {
		super(entity, level);
	}

	public ModBoat(Level level, double x, double y, double z) {
		this(CeilandsEntities.CEILANDS_BOAT, level);
		this.setPos(x, y, z);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_TYPE, ModBoat.Type.CEILTRUNK.ordinal());
   }
	
	protected void addAdditionalSaveData(CompoundTag tag) {
		tag.putString("Type", this.getCeilandsBoatType().getName());
	}

	protected void readAdditionalSaveData(CompoundTag tag) {
	   if (tag.contains("Type", 8)) {
		   this.setType(ModBoat.Type.byName(tag.getString("Type")));
	   }
	}
	
	public void setType(ModBoat.Type typeIn) {
		this.entityData.set(DATA_ID_TYPE, typeIn.ordinal());
	}

	public ModBoat.Type getCeilandsBoatType() {
		return ModBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
	}

	public Item getDropItem() {
		switch (this.getCeilandsBoatType()) {
		case CEILTRUNK:
		default:
			return CeilandsItems.CEILTRUNK_BOAT;
		case LUZAWOOD:
			return CeilandsItems.LUZAWOOD_BOAT;
		}
	}

	public static enum Type
	{
		CEILTRUNK(CeilandsBlocks.CEILTRUNK_PLANKS, "ceiltrunk"), 
		LUZAWOOD(CeilandsBlocks.LUZAWOOD_PLANKS, "luzawood");

		private final String name;
		private final Block planks;

		private Type(Block block, String name) {
			this.name = name;
			this.planks = block;
		}

		public String getName() {
			return this.name;
		}

		public Block getPlanks() {
			return this.planks;
		}

		public String toString() {
			return this.name;
		}

		public static ModBoat.Type byId(int id) {
			ModBoat.Type[] aboat$type = values();
			if (id < 0 || id >= aboat$type.length) {
				id = 0;
			}

			return aboat$type[id];
		}

		public static ModBoat.Type byName(String name) {
			ModBoat.Type[] aboat$type = values();

			for (int i = 0; i < aboat$type.length; ++i) {
				if (aboat$type[i].getName().equals(name)) {
					return aboat$type[i];
				}
			}

			return aboat$type[0];
		}
	}
}
