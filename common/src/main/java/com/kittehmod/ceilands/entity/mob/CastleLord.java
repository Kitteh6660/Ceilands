package com.kittehmod.ceilands.entity.mob;

import org.jetbrains.annotations.Nullable;

import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsItems;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;

public class CastleLord extends Monster implements InventoryCarrier
{
	private final SimpleContainer inventory = new SimpleContainer(8);
	
	public CastleLord(EntityType<? extends Monster> mob, Level level) {
		super(mob, level);
		this.xpReward = Monster.XP_REWARD_BOSS;
		((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
	}
	
    public CastleLord(Level level) {
        this(CeilandsEntities.CASTLE_LORD, level);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.writeInventoryToTag(tag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readInventoryFromTag(tag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }
    
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> $$0) {
        super.onSyncedDataUpdated($$0);
    }
    
    @Override
    public void tick() {
    	super.tick();
     }
    
    @Override
    public boolean hurt(DamageSource source, float $$1) {
        if (!super.hurt(source, $$1)) {
            return false;
        } else if (!(this.level() instanceof ServerLevel)) {
            return false;
        } else {
            ServerLevel $$2 = (ServerLevel)this.level();
            LivingEntity $$3 = this.getTarget();
            if ($$3 == null && source.getEntity() instanceof LivingEntity) {
                $$3 = (LivingEntity)source.getEntity();
            }
            return true;
        }
    }
    
    @VisibleForDebug
    public SimpleContainer getInventory() {
        return this.inventory;
    }
    
    protected ItemStack addToInventory(ItemStack $$0) {
        return this.inventory.addItem($$0);
    }

    protected boolean canAddToInventory(ItemStack $$0) {
        return this.inventory.canAddItem($$0);
    }
    
    @Override
    protected void dropCustomDeathLoot(DamageSource source, int $$1, boolean $$2) {
        super.dropCustomDeathLoot(source, $$1, $$2);
        this.inventory.removeAllItems().forEach(this::spawnAtLocation);
    }
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, false));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 12.0F).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 100).add(Attributes.ARMOR, 2.0).add(Attributes.ATTACK_DAMAGE, 1.0);
	}

	@Override
	public int getMaxFallDistance() {
		return this.getTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return false;
	}
	
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, CompoundTag tag) {
    	this.populateDefaultEquipmentSlots(level.getRandom(), difficulty);
    	return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData, tag);
    }
	
    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficulty) {
    	this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(CeilandsItems.CASTLE_LORD_CROWN));
    	this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(CeilandsItems.CASTLE_LORD_CHESTPLATE));
    	this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(CeilandsItems.CASTLE_LORD_LEGGINGS));
    	this.setItemSlot(EquipmentSlot.FEET, new ItemStack(CeilandsItems.CASTLE_LORD_BOOTS));
    	this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
    }

	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.HOSTILE_SWIM;
	}

	@Override
	protected SoundEvent getSwimSplashSound() {
		return SoundEvents.HOSTILE_SPLASH;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource $$0) {
		return SoundEvents.HOSTILE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.HOSTILE_DEATH;
	}

	@Override
	public LivingEntity.Fallsounds getFallSounds() {
		return new LivingEntity.Fallsounds(SoundEvents.HOSTILE_SMALL_FALL, SoundEvents.HOSTILE_BIG_FALL);
	}

	@Override
	public float getWalkTargetValue(BlockPos $$0, LevelReader $$1) {
		return -$$1.getPathfindingCostFromLightLevels($$0);
	}

	@Override
	public boolean shouldDropExperience() {
		return true;
	}

	@Override
	protected boolean shouldDropLoot() {
		return true;
	}

	public boolean isPreventingPlayerRest(Player $$0) {
		return true;
	}
}
