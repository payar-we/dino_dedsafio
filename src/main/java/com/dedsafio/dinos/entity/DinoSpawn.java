package com.dedsafio.dinos.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

/** Reglas de aparición natural: suelo firme (la dimensión tiene techo). */
public class DinoSpawn {
    public static boolean onGround(LevelAccessor level, BlockPos pos, MobSpawnType type) {
        if (type == MobSpawnType.SPAWN_EGG || type == MobSpawnType.COMMAND || type == MobSpawnType.SPAWNER
                || type == MobSpawnType.MOB_SUMMONED || type == MobSpawnType.MOB_SUMMONED) return true;
        BlockState below = level.getBlockState(pos.below());
        boolean floor = below.is(BlockTags.DIRT) || below.is(BlockTags.BASE_STONE_OVERWORLD) || below.is(BlockTags.SAND);
        return floor && level.getFluidState(pos).isEmpty() && pos.getY() > level.getSeaLevel() - 2;
    }

    public static boolean inAir(LevelAccessor level, BlockPos pos, MobSpawnType type) {
        if (type == MobSpawnType.SPAWN_EGG || type == MobSpawnType.COMMAND || type == MobSpawnType.SPAWNER) return true;
        return level.getBlockState(pos).isAir() && pos.getY() > level.getSeaLevel() + 6 && pos.getY() < 285;
    }

    /** Carne cruda, cuero y hueso (la dimensión no usa tablas de loot para esto). */
    public static void drops(Mob mob, int beefMin, int beefMax, int leatherMax, int boneMax) {
        var r = mob.getRandom();
        mob.spawnAtLocation(new ItemStack(Items.BEEF, beefMin + r.nextInt(beefMax - beefMin + 1)));
        int l = r.nextInt(leatherMax + 1);
        if (l > 0) mob.spawnAtLocation(new ItemStack(Items.LEATHER, l));
        int b = r.nextInt(boneMax + 1);
        if (b > 0) mob.spawnAtLocation(new ItemStack(Items.BONE, b));
    }
}
