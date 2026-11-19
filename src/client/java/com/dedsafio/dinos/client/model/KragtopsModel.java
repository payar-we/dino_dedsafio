package com.dedsafio.dinos.client.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

/** Modelo de Kragtops (reconstruido del mod original). */
public class KragtopsModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("dinodedsafio", "kragtops"), "main");

    private final ModelPart root;
    private final ModelPart lleg;
    private final ModelPart rleg;
    private final ModelPart larm;
    private final ModelPart rarm;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart tail;
    private final ModelPart jaw;

    public KragtopsModel(ModelPart root) {
        this.root = root;
        this.lleg = root.getChild("body").getChild("lleg");
        this.rleg = root.getChild("body").getChild("rleg");
        this.larm = root.getChild("body").getChild("larm");
        this.rarm = root.getChild("body").getChild("rarm");
        this.neck = root.getChild("body").getChild("neck");
        this.head = root.getChild("body").getChild("neck").getChild("head");
        this.tail = root.getChild("body").getChild("tail");
        this.jaw = root.getChild("body").getChild("neck").getChild("head").getChild("jaw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(-11.0F, -14.0F, -17.5F, 22.0F, 30.0F, 35.0F), PartPose.offset(0.0F, -3.0F, 0.0F));
        PartDefinition bodySpikes = body.addOrReplaceChild("bodySpikes", CubeListBuilder.create().texOffs(0, 22).mirror(false).addBox(0.0F, -15.5F, -21.5F, 0.0F, 31.0F, 43.0F), PartPose.offset(0.0F, -2.5F, 0.0F));
        PartDefinition rleg = body.addOrReplaceChild("rleg", CubeListBuilder.create().texOffs(117, 17).mirror(true).addBox(-5.0F, -2.0F, -8.0F, 9.0F, 15.0F, 12.0F), PartPose.offset(-11.0F, 5.0F, 9.5F));
        PartDefinition rleg2 = rleg.addOrReplaceChild("rleg2", CubeListBuilder.create().texOffs(126, 44).mirror(true).addBox(-3.0F, -1.5F, -4.0F, 6.0F, 13.0F, 8.0F), PartPose.offset(-0.5F, 8.5F, 2.0F));
        PartDefinition rfoot = rleg2.addOrReplaceChild("rfoot", CubeListBuilder.create().texOffs(114, 0).mirror(true).addBox(-4.0F, 0.0F, -6.5F, 8.0F, 2.0F, 11.0F), PartPose.offset(0.0F, 11.5F, -0.5F));
        PartDefinition lleg = body.addOrReplaceChild("lleg", CubeListBuilder.create().texOffs(117, 17).mirror(false).addBox(-4.0F, -2.0F, -8.0F, 9.0F, 15.0F, 12.0F), PartPose.offset(11.0F, 5.0F, 9.5F));
        PartDefinition lleg2 = lleg.addOrReplaceChild("lleg2", CubeListBuilder.create().texOffs(126, 44).mirror(false).addBox(-3.0F, -1.5F, -4.0F, 6.0F, 13.0F, 8.0F), PartPose.offset(0.5F, 8.5F, 2.0F));
        PartDefinition lfoot = lleg.addOrReplaceChild("lfoot", CubeListBuilder.create().texOffs(114, 0).mirror(false).addBox(-4.0F, 0.0F, -6.5F, 8.0F, 2.0F, 11.0F), PartPose.offset(0.5F, 20.0F, 1.5F));
        PartDefinition rarm = body.addOrReplaceChild("rarm", CubeListBuilder.create().texOffs(0, 0).mirror(true).addBox(-4.0F, -2.0F, -4.5F, 6.0F, 25.0F, 9.0F).texOffs(79, 7).mirror(true).addBox(-1.0F, 17.0F, -7.5F, 3.0F, 3.0F, 3.0F).texOffs(105, 31).mirror(true).addBox(-1.0F, 20.0F, -7.5F, 3.0F, 2.0F, 2.0F), PartPose.offset(-10.0F, 4.0F, -12.0F));
        PartDefinition larm = body.addOrReplaceChild("larm", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(-2.0F, -2.0F, -4.5F, 6.0F, 25.0F, 9.0F).texOffs(79, 7).mirror(false).addBox(-2.0F, 17.0F, -7.5F, 3.0F, 3.0F, 3.0F).texOffs(105, 31).mirror(false).addBox(-2.0F, 20.0F, -7.5F, 3.0F, 2.0F, 2.0F), PartPose.offset(10.0F, 4.0F, -12.0F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(65, 75).mirror(false).addBox(-6.0F, -5.0F, -1.0F, 12.0F, 12.0F, 21.0F), PartPose.offset(0.0F, -1.0F, 16.5F));
        PartDefinition tailSpike = tail.addOrReplaceChild("tailSpike", CubeListBuilder.create().texOffs(0, 98).mirror(false).addBox(0.0F, -4.0F, -9.5F, 0.0F, 12.0F, 19.0F), PartPose.offset(0.0F, -5.0F, 10.5F));
        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(26, 129).mirror(true).addBox(-10.0F, -3.0F, 14.0F, 7.0F, 3.0F, 3.0F).texOffs(95, 46).mirror(false).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 7.0F, 19.0F).texOffs(26, 129).mirror(false).addBox(3.0F, -3.0F, 8.0F, 7.0F, 3.0F, 3.0F).texOffs(26, 129).mirror(false).addBox(3.0F, -3.0F, 14.0F, 7.0F, 3.0F, 3.0F).texOffs(26, 129).mirror(true).addBox(-10.0F, -3.0F, 8.0F, 7.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 19.0F));
        PartDefinition tail2Spike = tail2.addOrReplaceChild("tail2Spike", CubeListBuilder.create().texOffs(131, 83).mirror(false).addBox(0.0F, -4.0F, -8.5F, 0.0F, 8.0F, 17.0F), PartPose.offset(0.0F, -3.0F, 9.5F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(100, 129).mirror(false).addBox(-5.0F, -7.0F, -16.0F, 10.0F, 14.0F, 20.0F), PartPose.offset(0.0F, 5.0F, -16.5F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(110, 72).mirror(false).addBox(-8.0F, -17.0F, -17.0F, 16.0F, 12.0F, 8.0F).texOffs(79, 29).mirror(false).addBox(-4.0F, 10.0F, -17.0F, 8.0F, 2.0F, 4.0F).texOffs(46, 108).mirror(false).addBox(-7.0F, -5.0F, -7.0F, 14.0F, 15.0F, 10.0F).texOffs(94, 108).mirror(false).addBox(-11.0F, -17.0F, 0.0F, 22.0F, 18.0F, 3.0F).texOffs(0, 96).mirror(false).addBox(-14.0F, -20.0F, 0.0F, 28.0F, 21.0F, 0.0F).texOffs(79, 0).mirror(false).addBox(-7.0F, -9.0F, -7.0F, 3.0F, 4.0F, 3.0F).texOffs(21, 0).mirror(false).addBox(4.0F, -9.0F, -7.0F, 3.0F, 4.0F, 3.0F).texOffs(0, 129).mirror(false).addBox(-4.0F, -5.0F, -17.0F, 8.0F, 7.0F, 10.0F).texOffs(36, 142).mirror(false).addBox(-4.0F, 2.0F, -17.0F, 8.0F, 8.0F, 4.0F), PartPose.offset(0.0F, -6.0F, -14.0F));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(65, 140).mirror(false).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 2.0F, -6.0F));
        PartDefinition grassBunch = jaw.addOrReplaceChild("grassBunch", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, -3.5F));
        PartDefinition grass = grassBunch.addOrReplaceChild("grass", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition grass5 = grass.addOrReplaceChild("grass5", CubeListBuilder.create().texOffs(24, 165).mirror(false).addBox(-2.4246F, -0.4275F, -2.5F, 5.0F, 0.0F, 5.0F), PartPose.offsetAndRotation(2.4246F, -0.4275F, 0.0F, 0.0F, 0.0F, -0.3491F));
        PartDefinition grass2 = grassBunch.addOrReplaceChild("grass2", CubeListBuilder.create().texOffs(1, 165).mirror(false).addBox(0.0F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition grassBunch2 = jaw.addOrReplaceChild("grassBunch2", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, -3.5F));
        PartDefinition grass3 = grassBunch2.addOrReplaceChild("grass3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition grass6 = grass3.addOrReplaceChild("grass6", CubeListBuilder.create().texOffs(24, 165).mirror(true).addBox(-2.5754F, -0.4275F, -2.5F, 5.0F, 0.0F, 5.0F), PartPose.offsetAndRotation(-2.4246F, -0.4275F, 0.0F, 0.0F, 0.0F, 0.3491F));
        PartDefinition grass4 = grassBunch2.addOrReplaceChild("grass4", CubeListBuilder.create().texOffs(1, 165).mirror(true).addBox(-5.0F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 256, 256);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float s = limbSwing * 0.5F;
        float a = limbSwingAmount;
        lleg.xRot += Mth.cos(s) * 0.8F * a;
        rleg.xRot += Mth.cos(s + Mth.PI) * 0.8F * a;
        larm.xRot += Mth.cos(s + Mth.PI) * 0.8F * a;
        rarm.xRot += Mth.cos(s) * 0.8F * a;
        neck.yRot += netHeadYaw * 0.0087F;
        neck.xRot += headPitch * 0.0087F;
        head.yRot += netHeadYaw * 0.0087F;
        head.xRot += headPitch * 0.0087F;
        tail.yRot += Mth.sin(s * 0.5F) * 0.25F * a + Mth.sin(ageInTicks * 0.06F) * 0.05F;
        jaw.xRot += (Mth.sin(ageInTicks * 0.09F) + 1.0F) * 0.04F;
    }
}
