package kittehmod.ceilands.entity;

import javax.annotation.Nullable;

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

	public ModChestBoat(EntityType<? extends ModBoat> p_219869_, Level p_219870_) {
		super(p_219869_, p_219870_);
	}

	public ModChestBoat(Level p_219872_, double p_219873_, double p_219874_, double p_219875_) {
		this(CeilandsEntities.CEILANDS_CHEST_BOAT.get(), p_219872_);
		this.setPos(p_219873_, p_219874_, p_219875_);
		this.xo = p_219873_;
		this.yo = p_219874_;
		this.zo = p_219875_;
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

	public void destroy(DamageSource source) {
		super.destroy(source);
		this.chestVehicleDestroyed(source, this.level(), this);
	}

	public void remove(Entity.RemovalReason reason) {
		if (!this.level().isClientSide() && reason.shouldDestroy()) {
			Containers.dropContents(this.level(), this, this);
		}

		super.remove(reason);
	}

	public InteractionResult interact(Player player, InteractionHand hand) {
		if (this.canAddPassenger(player) && !player.isSecondaryUseActive()) {
			return super.interact(player, hand);
		} else {
			InteractionResult interactionresult = this.interactWithContainerVehicle(player);
			if (interactionresult.consumesAction()) {
				this.gameEvent(GameEvent.CONTAINER_OPEN, player);
				PiglinAi.angerNearbyPiglins(player, true);
			}

			return interactionresult;
		}
	}

	public void openCustomInventoryScreen(Player player) {
		player.openMenu(this);
		if (!player.level().isClientSide()) {
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

	public ItemStack getItem(int p_219880_) {
		return this.getChestVehicleItem(p_219880_);
	}

	public ItemStack removeItem(int p_219882_, int p_219883_) {
		return this.removeChestVehicleItem(p_219882_, p_219883_);
	}

	public ItemStack removeItemNoUpdate(int p_219904_) {
		return this.removeChestVehicleItemNoUpdate(p_219904_);
	}

	public void setItem(int p_219885_, ItemStack p_219886_) {
		this.setChestVehicleItem(p_219885_, p_219886_);
	}

	public SlotAccess getSlot(int p_219918_) {
		return this.getChestVehicleSlot(p_219918_);
	}

	public void setChanged() {
	}

	public boolean stillValid(Player p_219896_) {
		return this.isChestVehicleStillValid(p_219896_);
	}

	@Nullable
	public AbstractContainerMenu createMenu(int p_219910_, Inventory p_219911_, Player p_219912_) {
		if (this.lootTable != null && p_219912_.isSpectator()) {
			return null;
		} else {
			this.unpackLootTable(p_219911_.player);
			return ChestMenu.threeRows(p_219910_, p_219911_, this);
		}
	}

	public void unpackLootTable(@Nullable Player p_219914_) {
		this.unpackChestVehicleLootTable(p_219914_);
	}

	@Nullable
	public ResourceLocation getLootTable() {
		return this.lootTable;
	}

	public void setLootTable(@Nullable ResourceLocation p_219890_) {
		this.lootTable = p_219890_;
	}

	public long getLootTableSeed() {
		return this.lootTableSeed;
	}

	public void setLootTableSeed(long p_219888_) {
		this.lootTableSeed = p_219888_;
	}

	public NonNullList<ItemStack> getItemStacks() {
		return this.itemStacks;
	}

	public void clearItemStacks() {
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
	}
}
