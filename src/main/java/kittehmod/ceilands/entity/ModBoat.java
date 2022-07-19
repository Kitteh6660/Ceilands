package kittehmod.ceilands.entity;

import kittehmod.ceilands.block.CeilandsBlocks;
import kittehmod.ceilands.item.CeilandsItems;
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
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

	public ModBoat(EntityType<? extends ModBoat> p_38290_, Level level) {
		super(p_38290_, level);
	}

	public ModBoat(Level p_219872_, double p_219873_, double p_219874_, double p_219875_) {
		this(CeilandsEntities.CEILANDS_BOAT.get(), p_219872_);
		this.setPos(p_219873_, p_219874_, p_219875_);
		this.xo = p_219873_;
		this.yo = p_219874_;
		this.zo = p_219875_;
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_TYPE, ModBoat.Type.CEILTRUNK.ordinal());
   }
	
	protected void addAdditionalSaveData(CompoundTag p_38359_) {
		p_38359_.putString("Type", this.getCeilandsBoatType().getName());
	}

	protected void readAdditionalSaveData(CompoundTag p_38338_) {
	   if (p_38338_.contains("Type", 8)) {
		   this.setType(ModBoat.Type.byName(p_38338_.getString("Type")));
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
			return CeilandsItems.CEILTRUNK_BOAT.get();
		case LUZAWOOD:
			return CeilandsItems.LUZAWOOD_BOAT.get();
		}
	}

	public static enum Type
	{
		CEILTRUNK(CeilandsBlocks.CEILTRUNK_PLANKS.get(), "ceiltrunk"), 
		LUZAWOOD(CeilandsBlocks.LUZAWOOD_PLANKS.get(), "luzawood");

		private final String name;
		private final Block planks;

		private Type(Block p_38427_, String p_38428_) {
			this.name = p_38428_;
			this.planks = p_38427_;
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

		public static ModBoat.Type byId(int p_38431_) {
			ModBoat.Type[] aboat$type = values();
			if (p_38431_ < 0 || p_38431_ >= aboat$type.length) {
				p_38431_ = 0;
			}

			return aboat$type[p_38431_];
		}

		public static ModBoat.Type byName(String p_38433_) {
			ModBoat.Type[] aboat$type = values();

			for (int i = 0; i < aboat$type.length; ++i) {
				if (aboat$type[i].getName().equals(p_38433_)) {
					return aboat$type[i];
				}
			}

			return aboat$type[0];
		}
	}
}
