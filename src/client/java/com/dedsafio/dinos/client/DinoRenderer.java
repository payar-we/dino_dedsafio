package com.dedsafio.dinos.client;

import com.dedsafio.dinos.DinoMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class DinoRenderer<T extends Mob> extends MobRenderer<T, EntityModel<T>> {
    private final ResourceLocation texture;

    public DinoRenderer(EntityRendererProvider.Context ctx, EntityModel<T> model, float shadow, String name) {
        super(ctx, model, shadow);
        this.texture = DinoMod.id("textures/entity/" + name + ".png");
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return texture;
    }
}
