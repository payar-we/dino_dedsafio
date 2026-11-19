package com.dedsafio.dinos.entity;

import com.dedsafio.dinos.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import com.dedsafio.dinos.ModBlocks;

public class PlumosaurioEntity extends PathfinderMob {
    public PlumosaurioEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120.0)
                .add(Attributes.ATTACK_DAMAGE, 12.0)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0)
                .add(Attributes.MOVEMENT_SPEED, 0.26)
                .add(Attributes.ARMOR, 4.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.6)
                .add(Attributes.FOLLOW_RANGE, 24.0);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true));
        goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.7));
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 14.0F));
        goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    public boolean removeWhenFarAway(double dist) {
        return false;
    }

    /** Los plumosaurios de vez en cuando dejan su caca. */
    @Override
    public void aiStep() {
        super.aiStep();
        if (!level().isClientSide && isAlive() && onGround() && random.nextInt(2400) == 0) {
            BlockPos p = blockPosition();
            BlockState caca = ModBlocks.CACA.defaultBlockState();
            if (level().getBlockState(p).isAir() && caca.canSurvive(level(), p)) {
                level().setBlockAndUpdate(p, caca);
                playSound(SoundEvents.CHICKEN_EGG, 0.6F, 0.6F);
            }
        }
    }

    @Override
    public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
        return DinoSpawn.onGround(level, blockPosition(), type) && super.checkSpawnRules(level, type);
    }


    @Override protected SoundEvent getAmbientSound() { return ModSounds.PLUMOSAURIO_IDLE; }
    @Override protected SoundEvent getHurtSound(DamageSource s) { return ModSounds.PLUMOSAURIO_HURT; }
    @Override protected SoundEvent getDeathSound() { return ModSounds.PLUMOSAURIO_DEATH; }
    @Override protected void playStepSound(BlockPos pos, BlockState state) { playSound(SoundEvents.COW_STEP, 0.5F, 1.0F); }

    @Override
    protected void dropCustomDeathLoot(net.minecraft.server.level.ServerLevel level, DamageSource source, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, source, recentlyHit);
        DinoSpawn.drops(this, 3, 7, 3, 3);
    }
}
