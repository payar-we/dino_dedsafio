package com.dedsafio.dinos.world;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/** Techo de roca de la dimensión: se genera sobre todo el chunk. */
public class RoofFeature extends Feature<NoneFeatureConfiguration> {
    public static final int TOP = 319;

    public RoofFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
        BlockPos origin = ctx.origin();
        RandomSource random = ctx.random();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {
                int x = origin.getX() + dx;
                int z = origin.getZ() + dz;
                int bottom = 300 + random.nextInt(5);
                boolean spike = random.nextInt(14) == 0;
                if (spike) bottom -= 3 + random.nextInt(9);
                for (int y = bottom; y <= TOP; y++) {
                    pos.set(x, y, z);
                    if (y >= TOP - 1) level.setBlock(pos, Blocks.BEDROCK.defaultBlockState(), 2);
                    else if (spike && y == bottom && random.nextInt(4) == 0) level.setBlock(pos, Blocks.GLOWSTONE.defaultBlockState(), 2);
                    else level.setBlock(pos, (y < bottom + 2 && random.nextInt(3) == 0 ? Blocks.TUFF : Blocks.STONE).defaultBlockState(), 2);
                }
            }
        }
        return true;
    }
}
