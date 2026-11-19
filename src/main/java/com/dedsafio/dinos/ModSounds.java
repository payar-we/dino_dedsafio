package com.dedsafio.dinos;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static final SoundEvent DROMORAPTOR_IDLE = reg("dromoraptor.idle");
    public static final SoundEvent DROMORAPTOR_HURT = reg("dromoraptor.hurt");
    public static final SoundEvent DROMORAPTOR_DEATH = reg("dromoraptor.death");
    public static final SoundEvent KRAGTOPS_IDLE = reg("kragtops.idle");
    public static final SoundEvent KRAGTOPS_HURT = reg("kragtops.hurt");
    public static final SoundEvent KRAGTOPS_DEATH = reg("kragtops.death");
    public static final SoundEvent MASTODINO_IDLE = reg("mastodino.idle");
    public static final SoundEvent MASTODINO_HURT = reg("mastodino.hurt");
    public static final SoundEvent MASTODINO_DEATH = reg("mastodino.death");
    public static final SoundEvent PLUMOSAURIO_IDLE = reg("plumosaurio.idle");
    public static final SoundEvent PLUMOSAURIO_HURT = reg("plumosaurio.hurt");
    public static final SoundEvent PLUMOSAURIO_DEATH = reg("plumosaurio.death");
    public static final SoundEvent SUBTERRANODON_IDLE = reg("subterranodon.idle");
    public static final SoundEvent SUBTERRANODON_HURT = reg("subterranodon.hurt");
    public static final SoundEvent SUBTERRANODON_DEATH = reg("subterranodon.death");

    private static SoundEvent reg(String name) {
        ResourceLocation id = DinoMod.id(name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void init() {}
}
