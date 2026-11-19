package com.dedsafio.dinos;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;

public class ModItems {
    public static final Item DROMORAPTOR_EGG = egg("dromoraptor", ModEntities.DROMORAPTOR, 0x3D5A2A, 0xD4A017);
    public static final Item KRAGTOPS_EGG = egg("kragtops", ModEntities.KRAGTOPS, 0x6B5A3C, 0xB9A77A);
    public static final Item MASTODINO_EGG = egg("mastodino", ModEntities.MASTODINO, 0x4A3426, 0xC9B27C);
    public static final Item PLUMOSAURIO_EGG = egg("plumosaurio", ModEntities.PLUMOSAURIO, 0x8A6A4A, 0xE0D5B0);
    public static final Item SUBTERRANODON_EGG = egg("subterranodon", ModEntities.SUBTERRANODON, 0x4A4A66, 0xB8745A);

    public static final Item DINO_LOG = block("dino_log", ModBlocks.DINO_LOG);
    public static final Item DINO_LOG_HONGO = block("dino_log_hongo", ModBlocks.DINO_LOG_HONGO);
    public static final Item DINO_LEAVES = block("dino_leaves", ModBlocks.DINO_LEAVES);
    public static final Item CACA = block("caca", ModBlocks.CACA);
    public static final Item AMBER_ORE = block("amber_ore", ModBlocks.AMBER_ORE);
    public static final Item RAW_AMBER = Registry.register(BuiltInRegistries.ITEM, DinoMod.id("raw_amber"), new Item(new Item.Properties()));
    public static final Item AMBER = Registry.register(BuiltInRegistries.ITEM, DinoMod.id("amber"), new Item(new Item.Properties()));

    public static final CreativeModeTab TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, DinoMod.id("dinosaurios"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.dinodedsafio"))
                    .icon(() -> new ItemStack(DROMORAPTOR_EGG))
                    .displayItems((params, out) -> {
                        out.accept(DROMORAPTOR_EGG);
                        out.accept(KRAGTOPS_EGG);
                        out.accept(MASTODINO_EGG);
                        out.accept(PLUMOSAURIO_EGG);
                        out.accept(SUBTERRANODON_EGG);
                        out.accept(DINO_LOG);
                        out.accept(DINO_LOG_HONGO);
                        out.accept(DINO_LEAVES);
                        out.accept(CACA);
                        out.accept(AMBER_ORE);
                        out.accept(RAW_AMBER);
                        out.accept(AMBER);
                    }).build());

    private static Item egg(String name, EntityType<? extends net.minecraft.world.entity.Mob> type, int c1, int c2) {
        return Registry.register(BuiltInRegistries.ITEM, DinoMod.id(name + "_spawn_egg"), new SpawnEggItem(type, c1, c2, new Item.Properties()));
    }

    private static Item block(String name, Block b) {
        return Registry.register(BuiltInRegistries.ITEM, DinoMod.id(name), new BlockItem(b, new Item.Properties()));
    }

    public static void init() {}
}
