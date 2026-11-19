package com.dedsafio.dinos.world;

import com.dedsafio.dinos.DinoMod;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;
import java.util.List;

/** /dino entrar [jugadores]  y  /dino volver [jugadores] */
public class DinoCommand {
    public static final ResourceKey<Level> DINO_WORLD =
            ResourceKey.create(Registries.DIMENSION, DinoMod.id("dino_world"));

    public static void register(CommandDispatcher<CommandSourceStack> d) {
        d.register(Commands.literal("dino").requires(s -> s.hasPermission(2))
                .then(Commands.literal("entrar")
                        .executes(c -> go(c.getSource(), List.of(c.getSource().getPlayerOrException()), true))
                        .then(Commands.argument("jugadores", EntityArgument.players())
                                .executes(c -> go(c.getSource(), EntityArgument.getPlayers(c, "jugadores"), true))))
                .then(Commands.literal("volver")
                        .executes(c -> go(c.getSource(), List.of(c.getSource().getPlayerOrException()), false))
                        .then(Commands.argument("jugadores", EntityArgument.players())
                                .executes(c -> go(c.getSource(), EntityArgument.getPlayers(c, "jugadores"), false)))));
    }

    private static int go(CommandSourceStack src, Collection<ServerPlayer> players, boolean enter) {
        MinecraftServer server = src.getServer();
        ServerLevel dino = server.getLevel(DINO_WORLD);
        if (dino == null) {
            src.sendFailure(Component.literal("La dimensión de los dinosaurios no está cargada."));
            return 0;
        }
        int n = 0;
        for (ServerPlayer p : players) {
            if (enter) {
                BlockPos pos = findSurface(dino, 0, 0);
                p.teleportTo(dino, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, p.getYRot(), p.getXRot());
            } else {
                ServerLevel ow = server.overworld();
                BlockPos spawn = ow.getSharedSpawnPos();
                p.teleportTo(ow, spawn.getX() + 0.5, spawn.getY(), spawn.getZ() + 0.5, p.getYRot(), p.getXRot());
            }
            n++;
        }
        final int count = n;
        src.sendSuccess(() -> Component.literal(count + " jugador(es) movidos."), true);
        return n;
    }

    /** Busca suelo libre bajo el techo (el heightmap normal daría el techo). */
    public static BlockPos findSurface(ServerLevel level, int cx, int cz) {
        for (int r = 0; r < 160; r += 6) {
            int x = cx + r, z = cz + (r * 7) % 23;
            level.getChunk(x >> 4, z >> 4);
            for (int y = 290; y > level.getMinBuildHeight() + 5; y--) {
                BlockPos p = new BlockPos(x, y, z);
                BlockState s = level.getBlockState(p);
                if (s.isAir() || s.is(BlockTags.LEAVES) || s.is(BlockTags.LOGS)) continue;
                if (!s.getFluidState().isEmpty()) return p.above();
                if (s.blocksMotion()) {
                    if (level.getBlockState(p.above()).isAir() && level.getBlockState(p.above(2)).isAir()) return p.above();
                    break;
                }
            }
        }
        return new BlockPos(cx, 120, cz);
    }
}
