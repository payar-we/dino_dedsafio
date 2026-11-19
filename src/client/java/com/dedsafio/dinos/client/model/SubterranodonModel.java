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

/** Modelo de Subterranodon (reconstruido del mod original). */
public class SubterranodonModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("dinodedsafio", "subterranodon"), "main");

    private final ModelPart root;
    private final ModelPart lwing;
    private final ModelPart rwing;
    private final ModelPart lwingTip;
    private final ModelPart rwingTip;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart lleg;
    private final ModelPart rleg;
    private final ModelPart tail;

    public SubterranodonModel(ModelPart root) {
        this.root = root;
        this.lwing = root.getChild("body").getChild("lwing");
        this.rwing = root.getChild("body").getChild("rwing");
        this.lwingTip = root.getChild("body").getChild("lwing").getChild("lwingTip");
        this.rwingTip = root.getChild("body").getChild("rwing").getChild("rwingTip");
        this.neck = root.getChild("body").getChild("neck");
        this.head = root.getChild("body").getChild("neck").getChild("head");
        this.lleg = root.getChild("body").getChild("lleg");
        this.rleg = root.getChild("body").getChild("rleg");
        this.tail = root.getChild("body").getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 46).mirror(false).addBox(-5.0F, -5.0F, -7.0F, 10.0F, 10.0F, 14.0F), PartPose.offset(0.0F, 19.0F, -1.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(74, 27).mirror(false).addBox(-2.0F, -1.0F, -8.5F, 4.0F, 5.0F, 8.0F), PartPose.offset(0.0F, -4.0F, -6.5F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 46).mirror(false).addBox(0.0F, -15.0F, -13.0F, 0.0F, 12.0F, 19.0F).texOffs(0, 79).mirror(false).addBox(-3.0F, -6.0F, -8.0F, 6.0F, 7.0F, 9.0F).texOffs(74, 10).mirror(false).addBox(-1.0F, -3.0F, -22.0F, 2.0F, 3.0F, 14.0F).texOffs(51, 78).mirror(false).addBox(-2.0F, -7.0F, -32.0F, 4.0F, 9.0F, 10.0F), PartPose.offset(0.0F, 1.0F, -5.5F));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(-1.5F, -3.0F, -23.5F, 3.0F, 8.0F, 9.0F).texOffs(71, 62).mirror(false).addBox(-0.5F, -1.0F, -15.0F, 1.0F, 3.0F, 15.0F), PartPose.offset(0.0F, -1.0F, -8.0F));
        PartDefinition lwing = body.addOrReplaceChild("lwing", CubeListBuilder.create().texOffs(12, 36).mirror(false).addBox(0.5F, 0.5F, 2.0F, 26.0F, 0.0F, 10.0F).texOffs(72, 42).mirror(false).addBox(0.5F, -1.0F, -2.0F, 26.0F, 3.0F, 4.0F), PartPose.offset(4.5F, -3.0F, -5.0F));
        PartDefinition lhand = lwing.addOrReplaceChild("lhand", CubeListBuilder.create().texOffs(30, 87).mirror(false).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 3.0F, 4.0F), PartPose.offset(25.0F, 0.5F, -2.0F));
        PartDefinition lwingTip = lwing.addOrReplaceChild("lwingTip", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(0.0F, 0.0F, 1.0F, 26.0F, 0.0F, 24.0F).texOffs(72, 49).mirror(false).addBox(0.0F, -1.0F, -1.0F, 26.0F, 2.0F, 2.0F), PartPose.offset(26.5F, 0.5F, -1.0F));
        PartDefinition rwing = body.addOrReplaceChild("rwing", CubeListBuilder.create().texOffs(12, 36).mirror(true).addBox(-26.5F, 0.5F, 2.0F, 26.0F, 0.0F, 10.0F).texOffs(72, 42).mirror(true).addBox(-26.5F, -1.0F, -2.0F, 26.0F, 3.0F, 4.0F), PartPose.offset(-4.5F, -3.0F, -5.0F));
        PartDefinition rhand = rwing.addOrReplaceChild("rhand", CubeListBuilder.create().texOffs(30, 87).mirror(false).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 4.0F), PartPose.offset(-25.0F, 2.0F, -2.0F));
        PartDefinition rwingTip = rwing.addOrReplaceChild("rwingTip", CubeListBuilder.create().texOffs(72, 49).mirror(true).addBox(-26.0F, -1.0F, -1.0F, 26.0F, 2.0F, 2.0F).texOffs(0, 0).mirror(true).addBox(-26.0F, 0.0F, 1.0F, 26.0F, 0.0F, 24.0F), PartPose.offset(-26.5F, 0.5F, -1.0F));
        PartDefinition lleg = body.addOrReplaceChild("lleg", CubeListBuilder.create().texOffs(25, 70).mirror(false).addBox(-2.0F, 0.0F, -0.5F, 5.0F, 0.0F, 13.0F), PartPose.offset(2.0F, -2.5F, 6.5F));
        PartDefinition ltalon = lleg.addOrReplaceChild("ltalon", CubeListBuilder.create().texOffs(98, 30).mirror(false).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F), PartPose.offset(0.5F, 0.0F, 12.5F));
        PartDefinition rleg = body.addOrReplaceChild("rleg", CubeListBuilder.create().texOffs(25, 70).mirror(true).addBox(-3.0F, 0.0F, -0.5F, 5.0F, 0.0F, 13.0F), PartPose.offset(-2.0F, -2.5F, 6.5F));
        PartDefinition rtalon = rleg.addOrReplaceChild("rtalon", CubeListBuilder.create().texOffs(98, 30).mirror(true).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F), PartPose.offset(-0.5F, 0.0F, 12.5F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(41, 46).mirror(false).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 0.0F, 19.0F), PartPose.offset(0.0F, -3.5F, 6.5F));
        PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create().texOffs(0, 51).mirror(false).addBox(0.0F, -5.0F, 0.0F, 0.0F, 9.0F, 19.0F).texOffs(29, 46).mirror(false).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 19.0F), PartPose.offset(0.0F, 0.0F, 18.5F));
        return LayerDefinition.create(mesh, 256, 256);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float flap = Mth.sin(ageInTicks * 0.45F);
        lwing.zRot += flap * 0.7F;
        rwing.zRot -= flap * 0.7F;
        lwingTip.zRot += Mth.sin(ageInTicks * 0.45F - 0.8F) * 0.35F;
        rwingTip.zRot -= Mth.sin(ageInTicks * 0.45F - 0.8F) * 0.35F;
        neck.yRot += netHeadYaw * 0.0087F;
        neck.xRot += headPitch * 0.0087F;
        head.yRot += netHeadYaw * 0.0087F;
        head.xRot += headPitch * 0.0087F;
        lleg.xRot += 0.5F;
        rleg.xRot += 0.5F;
        tail.xRot += Mth.sin(ageInTicks * 0.2F) * 0.08F;
    }
}
