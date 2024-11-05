package com.kittehmod.ceilands.entity.vehicle;

import org.jetbrains.annotations.Nullable;

import com.kittehmod.ceilands.registry.CeilandsEntities;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class ModChestBoat extends ModBoat implements HasCustomInventoryScreen, ContainerEntity
{
	private static final int CONTAINER_SIZE = 27;
	private NonNullList<ItemStack> itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
	@Nullable
	private ResourceLocation lootTable;
	private long lootTableSeed;

	public ModChestBoat(EntityType<? extends ModBoat> entity, Level level) {
		super(entity, level);
	}

	public ModChestBoat(Level level, double x, double y, double z) {
		this(CeilandsEntities.CEILANDS_CHEST_BOAT, level);
		this.setPos(x, y, z);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	protected float getSinglePassengerXOffset() {
		return 0.15F;
	}

	protected int getMaxPassengers() {
		return 1;
	}

	protected void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		this.addChestVehicleSaveData(tag);
	}

	protected void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.readChestVehicleSaveData(tag);
	}

	public void destroy(DamageSource dmgSource) {
		super.destroy(dmgSource);
		this.chestVehicleDestroyed(dmgSource, this.level, this);
	}

	public void remove(Entity.RemovalReason reason) {
		if (!this.level.isClientSide && reason.shouldDestroy()) {
			Containers.dropContents(this.level, this, this);
		}

		super.remove(reason);
	}

	public InteractionResult interact(Player player, InteractionHand hand) {
		return this.canAddPassenger(player) && !player.isSecondaryUseActive() ? super.interact(player, hand) : this.interactWithChestVehicle(this::gameEvent, player);
	}

	public void openCustomInventoryScreen(Player player) {
		player.openMenu(this);
		if (!player.level.isClientSide) {
			this.gameEvent(GameEvent.CONTAINER_OPEN, player);
			PiglinAi.angerNearbyPiglins(player, true);
		}

	}

	public void clearContent() {
		this.clearChestVehicleContent();
	}

	public int getContainerSize() {
		return CONTAINER_SIZE;
	}

	public ItemStack getItem(int slot) {
		return this.getChestVehicleItem(slot);
	}

	public ItemStack removeItem(int slot, int amount) {
		return this.removeChestVehicleItem(slot, amount);
	}

	public ItemStack removeItemNoUpdate(int slot) {
		return this.removeChestVehicleItemNoUpdate(slot);
	}

	public void setItem(int slot, ItemStack stack) {
		this.setChestVehicleItem(slot, stack);
	}

	public SlotAccess getSlot(int stack) {
		return this.getChestVehicleSlot(stack);
	}

	public void setChanged() {
	}

	public boolean stillValid(Player player) {
		return this.isChestVehicleStillValid(player);
	}

	@Nullable
	public AbstractContainerMenu createMenu(int p_219910_, Inventory inventory, Player player) {
		if (this.lootTable != null && player.isSpectator()) {
			return null;
		} else {
			this.unpackLootTable(inventory.player);
			return ChestMenu.threeRows(p_219910_, inventory, this);
		}
	}

	public void unpackLootTable(@Nullable Player p_219914_) {
		this.unpackChestVehicleLootTable(p_219914_);
	}

	@Nullable
	public ResourceLocation getLootTable() {
		return this.lootTable;
	}

	public void setLootTable(@Nullable ResourceLocation resourceLocation) {
		this.lootTable = resourceLocation;
	}

	public long getLootTableSeed() {
		return this.lootTableSeed;
	}

	public void setLootTableSeed(long seed) {
		this.lootTableSeed = seed;
	}

	public NonNullList<ItemStack> getItemStacks() {
		return this.itemStacks;
	}

	public void clearItemStacks() {
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
	}
}
