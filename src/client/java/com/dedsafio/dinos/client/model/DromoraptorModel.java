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

/** Modelo de Dromoraptor (reconstruido del mod original). */
public class DromoraptorModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("dinodedsafio", "dromoraptor"), "main");

    private final ModelPart root;
    private final ModelPart lleg;
    private final ModelPart rleg;
    private final ModelPart larm;
    private final ModelPart rarm;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart tail;

    public DromoraptorModel(ModelPart root) {
        this.root = root;
        this.lleg = root.getChild("body").getChild("lleg");
        this.rleg = root.getChild("body").getChild("rleg");
        this.larm = root.getChild("body").getChild("larm");
        this.rarm = root.getChild("body").getChild("rarm");
        this.neck = root.getChild("body").getChild("neck");
        this.head = root.getChild("body").getChild("neck").getChild("head");
        this.tail = root.getChild("body").getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(-3.5F, -3.5F, -6.0F, 7.0F, 7.0F, 12.0F), PartPose.offset(0.0F, 10.5F, -1.0F));
        PartDefinition lleg = body.addOrReplaceChild("lleg", CubeListBuilder.create().texOffs(34, 14).mirror(true).addBox(-1.5F, -2.0F, -3.5F, 4.0F, 8.0F, 5.0F), PartPose.offset(3.0F, 0.5F, 2.5F));
        PartDefinition lleg2 = lleg.addOrReplaceChild("lleg2", CubeListBuilder.create().texOffs(0, 48).mirror(true).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.5F, 4.5F, 1.0F));
        PartDefinition lfoot = lleg2.addOrReplaceChild("lfoot", CubeListBuilder.create().texOffs(20, 0).mirror(true).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 0.0F, 6.0F), PartPose.offset(0.0F, 8.5F, 0.5F));
        PartDefinition lclaw = lfoot.addOrReplaceChild("lclaw", CubeListBuilder.create().texOffs(21, 34).mirror(true).addBox(0.0F, -5.0F, -4.0F, 0.0F, 5.0F, 5.0F), PartPose.offset(-2.0F, 0.0F, -3.0F));
        PartDefinition rleg = body.addOrReplaceChild("rleg", CubeListBuilder.create().texOffs(34, 14).mirror(false).addBox(-2.5F, -2.0F, -3.5F, 4.0F, 8.0F, 5.0F), PartPose.offset(-3.0F, 0.5F, 2.5F));
        PartDefinition rleg2 = rleg.addOrReplaceChild("rleg2", CubeListBuilder.create().texOffs(0, 48).mirror(false).addBox(-1.0F, -0.75F, -0.5F, 2.0F, 9.0F, 2.0F), PartPose.offset(-0.5F, 4.75F, 1.0F));
        PartDefinition rfoot = rleg2.addOrReplaceChild("rfoot", CubeListBuilder.create().texOffs(20, 0).mirror(false).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 0.0F, 6.0F), PartPose.offset(0.0F, 8.25F, 0.5F));
        PartDefinition rclaw = rfoot.addOrReplaceChild("rclaw", CubeListBuilder.create().texOffs(21, 34).mirror(false).addBox(0.0F, -5.0F, -4.0F, 0.0F, 5.0F, 5.0F), PartPose.offset(2.0F, 0.0F, -3.0F));
        PartDefinition larm = body.addOrReplaceChild("larm", CubeListBuilder.create().texOffs(8, 48).mirror(true).addBox(-0.5F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).texOffs(44, 0).mirror(true).addBox(-0.5F, 2.0F, -4.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(3.0F, 2.5F, -3.0F));
        PartDefinition lhand = larm.addOrReplaceChild("lhand", CubeListBuilder.create().texOffs(0, 28).mirror(true).addBox(-4.0F, -1.5F, -3.0F, 4.0F, 3.0F, 3.0F), PartPose.offset(1.5F, 3.5F, -4.0F));
        PartDefinition lquill = larm.addOrReplaceChild("lquill", CubeListBuilder.create().texOffs(16, 47).mirror(true).addBox(0.0F, 0.0F, -3.5F, 0.0F, 3.0F, 7.0F), PartPose.offset(0.5F, 5.0F, -0.5F));
        PartDefinition rarm = body.addOrReplaceChild("rarm", CubeListBuilder.create().texOffs(8, 48).mirror(false).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).texOffs(44, 0).mirror(false).addBox(-1.5F, 2.0F, -4.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(-3.0F, 2.5F, -3.0F));
        PartDefinition rhand = rarm.addOrReplaceChild("rhand", CubeListBuilder.create().texOffs(0, 28).mirror(false).addBox(0.0F, -1.5F, -3.0F, 4.0F, 3.0F, 3.0F), PartPose.offset(-1.5F, 3.5F, -4.0F));
        PartDefinition rquill = rarm.addOrReplaceChild("rquill", CubeListBuilder.create().texOffs(16, 47).mirror(true).addBox(0.0F, 0.0F, -3.5F, 0.0F, 3.0F, 7.0F), PartPose.offset(-0.5F, 5.0F, -0.5F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(47, 22).mirror(false).addBox(-1.5F, -8.0F, -3.0F, 3.0F, 9.0F, 5.0F), PartPose.offset(0.0F, -1.5F, -5.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(-1.0F, -4.0F, -7.0F, 2.0F, 4.0F, 4.0F).texOffs(50, 8).mirror(false).addBox(-1.0F, -6.0F, -8.0F, 2.0F, 6.0F, 5.0F).texOffs(-9, 39).mirror(false).addBox(-2.0F, 2.0F, -8.0F, 4.0F, 0.0F, 9.0F).texOffs(46, 56).mirror(false).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F).texOffs(26, 54).mirror(false).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 4.0F, 6.0F), PartPose.offset(0.0F, -8.0F, -1.0F));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(30, 4).mirror(false).addBox(-1.5F, 0.0F, -6.0F, 3.0F, 2.0F, 6.0F).texOffs(2, 57).mirror(false).addBox(-1.5F, -1.0F, -6.0F, 3.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 2.0F, -1.5F));
        PartDefinition headquill = neck.addOrReplaceChild("headquill", CubeListBuilder.create().texOffs(46, 27).mirror(false).addBox(0.0F, -5.0F, -5.0F, 0.0F, 14.0F, 9.0F), PartPose.offset(0.0F, -8.0F, 2.0F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(16, 19).mirror(false).addBox(-1.5F, -1.25F, 1.0F, 3.0F, 3.0F, 12.0F), PartPose.offset(0.0F, -2.25F, 5.0F));
        PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create().texOffs(0, 5).mirror(false).addBox(0.0F, -7.5F, 0.0F, 0.0F, 9.0F, 14.0F), PartPose.offset(0.0F, 0.25F, 13.0F));
        PartDefinition tailQuill = tail.addOrReplaceChild("tailQuill", CubeListBuilder.create().texOffs(18, 36).mirror(false).addBox(0.0F, -5.0F, -6.0F, 0.0F, 6.0F, 12.0F), PartPose.offset(0.0F, -1.25F, 7.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float s = limbSwing * 0.6662F;
        float a = limbSwingAmount;
        lleg.xRot += Mth.cos(s) * 1.3F * a;
        rleg.xRot += Mth.cos(s + Mth.PI) * 1.3F * a;
        larm.xRot += Mth.cos(s + Mth.PI) * 0.7F * a;
        rarm.xRot += Mth.cos(s) * 0.7F * a;
        neck.yRot += netHeadYaw * 0.0087F;
        neck.xRot += headPitch * 0.0087F;
        head.yRot += netHeadYaw * 0.0087F;
        head.xRot += headPitch * 0.0087F;
        tail.yRot += Mth.sin(s * 0.5F) * 0.25F * a + Mth.sin(ageInTicks * 0.06F) * 0.05F;
    }
}
