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

/** Modelo de Mastodino (reconstruido del mod original). */
public class MastodinoModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("dinodedsafio", "mastodino"), "main");

    private final ModelPart root;
    private final ModelPart lleg;
    private final ModelPart rleg;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart tail;
    private final ModelPart jaw;

    public MastodinoModel(ModelPart root) {
        this.root = root;
        this.lleg = root.getChild("body").getChild("lleg");
        this.rleg = root.getChild("body").getChild("rleg");
        this.neck = root.getChild("body").getChild("neck");
        this.head = root.getChild("body").getChild("neck").getChild("head");
        this.tail = root.getChild("body").getChild("tail");
        this.jaw = root.getChild("body").getChild("neck").getChild("head").getChild("jaw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(-13.0F, -15.0F, -20.0F, 26.0F, 30.0F, 39.0F).texOffs(91, 0).mirror(false).addBox(-1.0F, -18.0F, -9.0F, 2.0F, 3.0F, 5.0F).texOffs(91, 0).mirror(false).addBox(-1.0F, -18.0F, -18.0F, 2.0F, 3.0F, 5.0F).texOffs(91, 0).mirror(false).addBox(-1.0F, -18.0F, -2.0F, 2.0F, 3.0F, 5.0F).texOffs(91, 0).mirror(false).addBox(-1.0F, -18.0F, 5.0F, 2.0F, 3.0F, 5.0F).texOffs(91, 0).mirror(false).addBox(-1.0F, -18.0F, 12.0F, 2.0F, 3.0F, 5.0F), PartPose.offset(0.0F, -17.0F, 0.0F));
        PartDefinition rarm = body.addOrReplaceChild("rarm", CubeListBuilder.create().texOffs(16, 24).mirror(true).addBox(-8.0F, 0.0F, -1.5F, 8.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-13.0F, 11.0F, -13.5F, 0.0F, 0.0F, -1.2654F));
        PartDefinition larm = body.addOrReplaceChild("larm", CubeListBuilder.create().texOffs(16, 24).mirror(false).addBox(0.0F, 0.0F, -1.5F, 8.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(13.0F, 11.0F, -13.5F, 0.0F, 0.0F, 1.2654F));
        PartDefinition rleg = body.addOrReplaceChild("rleg", CubeListBuilder.create().texOffs(61, 106).mirror(true).addBox(-6.5F, -2.0F, -9.5F, 13.0F, 26.0F, 19.0F), PartPose.offset(-11.5F, 2.0F, 6.5F));
        PartDefinition rleg2 = rleg.addOrReplaceChild("rleg2", CubeListBuilder.create().texOffs(0, 0).mirror(true).addBox(-3.5F, -1.5F, -3.5F, 7.0F, 15.0F, 9.0F), PartPose.offset(0.0F, 21.5F, 7.0F));
        PartDefinition rfoot = rleg2.addOrReplaceChild("rfoot", CubeListBuilder.create().texOffs(125, 127).mirror(true).addBox(-6.0F, 0.0F, -12.5F, 11.0F, 4.0F, 17.0F), PartPose.offset(0.5F, 13.5F, 1.0F));
        PartDefinition rclaw1 = rfoot.addOrReplaceChild("rclaw1", CubeListBuilder.create().texOffs(91, 8).mirror(true).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(4.0F, 0.0F, -12.5F));
        PartDefinition rclaw2 = rfoot.addOrReplaceChild("rclaw2", CubeListBuilder.create().texOffs(91, 8).mirror(true).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(-0.5F, 0.0F, -12.5F));
        PartDefinition rclaw3 = rfoot.addOrReplaceChild("rclaw3", CubeListBuilder.create().texOffs(91, 8).mirror(true).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(-5.0F, 0.0F, -12.5F));
        PartDefinition lleg = body.addOrReplaceChild("lleg", CubeListBuilder.create().texOffs(61, 106).mirror(false).addBox(-6.5F, -2.0F, -9.5F, 13.0F, 26.0F, 19.0F), PartPose.offset(11.5F, 2.0F, 6.5F));
        PartDefinition lleg2 = lleg.addOrReplaceChild("lleg2", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(-3.5F, -1.5F, -3.5F, 7.0F, 15.0F, 9.0F), PartPose.offset(0.0F, 21.5F, 7.0F));
        PartDefinition lfoot = lleg2.addOrReplaceChild("lfoot", CubeListBuilder.create().texOffs(125, 127).mirror(false).addBox(-5.0F, 0.0F, -12.5F, 11.0F, 4.0F, 17.0F), PartPose.offset(-0.5F, 13.5F, 1.0F));
        PartDefinition lclaw1 = lfoot.addOrReplaceChild("lclaw1", CubeListBuilder.create().texOffs(91, 8).mirror(false).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(-4.0F, 0.0F, -12.5F));
        PartDefinition lclaw2 = lfoot.addOrReplaceChild("lclaw2", CubeListBuilder.create().texOffs(91, 8).mirror(false).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(0.5F, 0.0F, -12.5F));
        PartDefinition lclaw3 = lfoot.addOrReplaceChild("lclaw3", CubeListBuilder.create().texOffs(91, 8).mirror(false).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(5.0F, 0.0F, -12.5F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(44, 111).mirror(false).addBox(-1.0F, -19.0F, 3.0F, 2.0F, 5.0F, 3.0F).texOffs(0, 69).mirror(false).addBox(-1.0F, -26.0F, 1.0F, 2.0F, 5.0F, 5.0F).texOffs(91, 0).mirror(false).addBox(-1.0F, -26.0F, -6.0F, 2.0F, 3.0F, 5.0F).texOffs(0, 111).mirror(false).addBox(-7.0F, -23.0F, -13.0F, 14.0F, 26.0F, 16.0F), PartPose.offsetAndRotation(0.0F, -5.0F, -14.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(91, 0).mirror(false).addBox(-7.5F, -6.1F, -21.0F, 15.0F, 9.0F, 21.0F).texOffs(130, 59).mirror(false).addBox(-7.5F, -0.1F, -7.0F, 15.0F, 3.0F, 7.0F).texOffs(0, 25).mirror(false).addBox(2.5F, -9.1F, -7.0F, 5.0F, 3.0F, 6.0F).texOffs(0, 0).mirror(false).addBox(5.5F, -11.1F, -7.0F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).mirror(true).addBox(-7.5F, -11.1F, -7.0F, 2.0F, 2.0F, 2.0F).texOffs(0, 25).mirror(true).addBox(-7.5F, -9.1F, -7.0F, 5.0F, 3.0F, 6.0F).texOffs(0, 153).mirror(false).addBox(-7.5F, 2.9F, -21.0F, 15.0F, 5.0F, 21.0F), PartPose.offsetAndRotation(0.0F, -17.0F, -8.0F, -0.5672F, 0.0F, 0.0F));
        PartDefinition glasses = head.addOrReplaceChild("glasses", CubeListBuilder.create().texOffs(91, 30).mirror(false).addBox(-8.0F, -1.5F, -5.0F, 16.0F, 3.0F, 6.0F), PartPose.offset(0.0F, -7.6F, -2.5F));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(124, 73).mirror(false).addBox(-8.5F, 3.15F, -20.0F, 17.0F, 7.0F, 15.0F).texOffs(125, 106).mirror(false).addBox(-8.5F, -3.85F, -20.0F, 17.0F, 7.0F, 14.0F).texOffs(57, 70).mirror(false).addBox(-8.5F, 0.15F, -5.0F, 17.0F, 10.0F, 8.0F), PartPose.offset(0.0F, -0.25F, -2.0F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(135, 2).mirror(false).addBox(-8.0F, -9.0F, -3.0F, 16.0F, 18.0F, 28.0F).texOffs(91, 0).mirror(false).addBox(-1.0F, -12.0F, 3.0F, 2.0F, 3.0F, 5.0F).texOffs(91, 0).mirror(false).addBox(-1.0F, -12.0F, 10.0F, 2.0F, 3.0F, 5.0F).texOffs(0, 111).mirror(false).addBox(-1.0F, -11.0F, 17.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, -4.0F, 18.0F));
        PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create().texOffs(0, 1).mirror(false).addBox(0.0F, -5.5F, 20.0F, 0.0F, 1.0F, 3.0F).texOffs(0, 2).mirror(false).addBox(0.0F, -5.5F, 15.0F, 0.0F, 1.0F, 3.0F).texOffs(157, 64).mirror(false).addBox(-4.0F, -4.5F, -2.0F, 8.0F, 9.0F, 31.0F).texOffs(0, 111).mirror(false).addBox(-1.0F, -6.5F, 9.0F, 2.0F, 2.0F, 4.0F).texOffs(0, 111).mirror(false).addBox(-1.0F, -6.5F, 3.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, -2.5F, 24.0F));
        return LayerDefinition.create(mesh, 256, 256);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float s = limbSwing * 0.45F;
        float a = limbSwingAmount;
        lleg.xRot += Mth.cos(s) * 0.7F * a;
        rleg.xRot += Mth.cos(s + Mth.PI) * 0.7F * a;
        neck.yRot += netHeadYaw * 0.0087F;
        neck.xRot += headPitch * 0.0087F;
        head.yRot += netHeadYaw * 0.0087F;
        head.xRot += headPitch * 0.0087F;
        tail.yRot += Mth.sin(s * 0.5F) * 0.25F * a + Mth.sin(ageInTicks * 0.06F) * 0.05F;
        jaw.xRot += (Mth.sin(ageInTicks * 0.07F) + 1.0F) * 0.05F;
    }
}
