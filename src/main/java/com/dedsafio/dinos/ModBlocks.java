package com.dedsafio.dinos;

import com.dedsafio.dinos.block.CacaBlock;
import com.dedsafio.dinos.block.HongoLogBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {
    public static final Block DINO_LOG = reg("dino_log", new RotatedPillarBlock(logProps()));
    public static final Block DINO_LOG_HONGO = reg("dino_log_hongo", new HongoLogBlock(logProps()));
    public static final Block DINO_LEAVES = reg("dino_leaves", new LeavesBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GREEN).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
            .isValidSpawn((s, g, p, t) -> false).isSuffocating((s, g, p) -> false).isViewBlocking((s, g, p) -> false)
            .pushReaction(PushReaction.DESTROY)));
    public static final Block CACA = reg("caca", new CacaBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIRT).strength(0.3F).sound(SoundType.MUD).noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final Block AMBER_ORE = reg("amber_ore", new DropExperienceBlock(UniformInt.of(1, 3), BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static BlockBehaviour.Properties logProps() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD).ignitedByLava();
    }

    private static Block reg(String name, Block b) {
        return Registry.register(BuiltInRegistries.BLOCK, DinoMod.id(name), b);
    }

    public static void init() {}
}
