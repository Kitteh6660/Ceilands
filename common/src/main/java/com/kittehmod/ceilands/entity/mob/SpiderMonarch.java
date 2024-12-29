package com.kittehmod.ceilands.entity.mob;

import org.jetbrains.annotations.Nullable;

import com.kittehmod.ceilands.registry.CeilandsEntities;
import com.kittehmod.ceilands.registry.CeilandsSoundEvents;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SpiderMonarch extends Spider
{
	private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
	private static final EntityDataAccessor<BlockPos> SPAWN_POSITION = SynchedEntityData.defineId(SpiderMonarch.class, EntityDataSerializers.BLOCK_POS);
	
	public SpiderMonarch(EntityType<? extends Spider> mob, Level level) {
		super(mob, level);
		this.xpReward = Monster.XP_REWARD_BOSS;
	}

    public SpiderMonarch(Level level) {
        this(CeilandsEntities.SPIDER_MONARCH, level);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        this.bossEvent.setName(this.getDisplayName());
     }
    
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder.define(SPAWN_POSITION, this.blockPosition()));
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
    
	@Override
	protected void registerGoals() {
		super.registerGoals();
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Animal.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 200).add(Attributes.ARMOR, 3.0).add(Attributes.ATTACK_DAMAGE, 3.0);
	}
    

	@Override
	protected SoundEvent getAmbientSound() {
		return CeilandsSoundEvents.SPIDER_MONARCH_AMBIENT;
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
		return CeilandsSoundEvents.SPIDER_MONARCH_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return CeilandsSoundEvents.SPIDER_MONARCH_DEATH;
	}

	@Override
	public LivingEntity.Fallsounds getFallSounds() {
		return new LivingEntity.Fallsounds(SoundEvents.HOSTILE_SMALL_FALL, SoundEvents.HOSTILE_BIG_FALL);
	}
	
	@Override
	public int getMaxFallDistance() {
		return this.getTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return false;
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
	
    protected void customServerAiStep() {
	    super.customServerAiStep();
	    this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }
    
    public void startSeenByPlayer(ServerPlayer player) {
    	super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }
}
