package com.dedsafio.dinos;

import com.dedsafio.dinos.world.DinoCommand;
import com.dedsafio.dinos.world.RoofFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DinoMod implements ModInitializer {
    public static final String MOD_ID = "dinodedsafio";

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModSounds.init();
        ModBlocks.init();
        ModEntities.init();
        ModItems.init();
        Registry.register(BuiltInRegistries.FEATURE, id("techo"), new RoofFeature(NoneFeatureConfiguration.CODEC));
        CommandRegistrationCallback.EVENT.register((dispatcher, registry, env) -> DinoCommand.register(dispatcher));
    }
}
