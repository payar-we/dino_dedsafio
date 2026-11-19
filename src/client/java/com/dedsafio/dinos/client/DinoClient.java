package com.dedsafio.dinos.client;

import com.dedsafio.dinos.ModBlocks;
import com.dedsafio.dinos.ModEntities;
import com.dedsafio.dinos.client.model.*;
import com.dedsafio.dinos.entity.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class DinoClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DINO_LEAVES, RenderType.cutoutMipped());

        EntityModelLayerRegistry.registerModelLayer(DromoraptorModel.LAYER, DromoraptorModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(KragtopsModel.LAYER, KragtopsModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(MastodinoModel.LAYER, MastodinoModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(PlumosaurioModel.LAYER, PlumosaurioModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(SubterranodonModel.LAYER, SubterranodonModel::createBodyLayer);

        EntityRenderers.register(ModEntities.DROMORAPTOR, ctx -> new DinoRenderer<DromoraptorEntity>(ctx,
                new DromoraptorModel<DromoraptorEntity>(ctx.bakeLayer(DromoraptorModel.LAYER)), 0.9F, "dromoraptor"));
        EntityRenderers.register(ModEntities.KRAGTOPS, ctx -> new DinoRenderer<KragtopsEntity>(ctx,
                new KragtopsModel<KragtopsEntity>(ctx.bakeLayer(KragtopsModel.LAYER)), 1.8F, "kragtops"));
        EntityRenderers.register(ModEntities.MASTODINO, ctx -> new DinoRenderer<MastodinoEntity>(ctx,
                new MastodinoModel<MastodinoEntity>(ctx.bakeLayer(MastodinoModel.LAYER)), 2.4F, "mastodino"));
        EntityRenderers.register(ModEntities.PLUMOSAURIO, ctx -> new DinoRenderer<PlumosaurioEntity>(ctx,
                new PlumosaurioModel<PlumosaurioEntity>(ctx.bakeLayer(PlumosaurioModel.LAYER)), 2.2F, "plumosaurio"));
        EntityRenderers.register(ModEntities.SUBTERRANODON, ctx -> new DinoRenderer<SubterranodonEntity>(ctx,
                new SubterranodonModel<SubterranodonEntity>(ctx.bakeLayer(SubterranodonModel.LAYER)), 0.8F, "subterranodon"));
    }
}
