package com.dedsafio.dinos;

import com.dedsafio.dinos.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final EntityType<DromoraptorEntity> DROMORAPTOR = reg("dromoraptor",
            EntityType.Builder.of(DromoraptorEntity::new, MobCategory.MONSTER).sized(1.2F, 1.9F).clientTrackingRange(10));
    public static final EntityType<KragtopsEntity> KRAGTOPS = reg("kragtops",
            EntityType.Builder.of(KragtopsEntity::new, MobCategory.CREATURE).sized(2.2F, 3.0F).clientTrackingRange(10));
    public static final EntityType<MastodinoEntity> MASTODINO = reg("mastodino",
            EntityType.Builder.of(MastodinoEntity::new, MobCategory.MONSTER).sized(2.8F, 4.6F).clientTrackingRange(12));
    public static final EntityType<PlumosaurioEntity> PLUMOSAURIO = reg("plumosaurio",
            EntityType.Builder.of(PlumosaurioEntity::new, MobCategory.CREATURE).sized(2.6F, 7.0F).clientTrackingRange(12));
    public static final EntityType<SubterranodonEntity> SUBTERRANODON = reg("subterranodon",
            EntityType.Builder.of(SubterranodonEntity::new, MobCategory.MONSTER).sized(1.4F, 1.2F).clientTrackingRange(12));

    private static <T extends Mob> EntityType<T> reg(String name, EntityType.Builder<T> b) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, DinoMod.id(name), b.build(name));
    }

    public static void init() {
        FabricDefaultAttributeRegistry.register(DROMORAPTOR, DromoraptorEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(KRAGTOPS, KragtopsEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(MASTODINO, MastodinoEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PLUMOSAURIO, PlumosaurioEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SUBTERRANODON, SubterranodonEntity.createAttributes());
    }
}
