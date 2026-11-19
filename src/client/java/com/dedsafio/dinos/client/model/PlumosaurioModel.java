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

/** Modelo de Plumosaurio (reconstruido del mod original). */
public class PlumosaurioModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("dinodedsafio", "plumosaurio"), "main");

    private final ModelPart root;
    private final ModelPart lleg;
    private final ModelPart rleg;
    private final ModelPart larm;
    private final ModelPart rarm;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart tail;

    public PlumosaurioModel(ModelPart root) {
        this.root = root;
        this.lleg = root.getChild("body").getChild("hips").getChild("lleg");
        this.rleg = root.getChild("body").getChild("hips").getChild("rleg");
        this.larm = root.getChild("body").getChild("chest").getChild("larm");
        this.rarm = root.getChild("body").getChild("chest").getChild("rarm");
        this.neck = root.getChild("body").getChild("chest").getChild("neck");
        this.head = root.getChild("body").getChild("chest").getChild("neck").getChild("neck2").getChild("neck2b").getChild("neck3").getChild("head");
        this.tail = root.getChild("body").getChild("hips").getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -15.0F, 0.0F));
        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(34, 98).mirror(false).addBox(-15.0F, 28.5F, -28.0F, 30.0F, 4.0F, 28.0F).texOffs(0, 0).mirror(false).addBox(-15.0F, -8.5F, -28.0F, 30.0F, 37.0F, 28.0F).texOffs(0, 96).mirror(false).addBox(-13.5F, -1.5F, -2.0F, 27.0F, 18.0F, 11.0F), PartPose.offset(0.0F, -10.5F, 3.0F));
        PartDefinition chestFeathers = chest.addOrReplaceChild("chestFeathers", CubeListBuilder.create().texOffs(0, 113).mirror(false).addBox(0.0F, -6.0F, -18.5F, 0.0F, 14.0F, 33.0F), PartPose.offset(0.0F, -8.5F, -9.5F));
        PartDefinition larm = chest.addOrReplaceChild("larm", CubeListBuilder.create().texOffs(40, 160).mirror(false).addBox(-2.5F, 4.0F, 2.5F, 7.0F, 21.0F, 15.0F).texOffs(84, 170).mirror(false).addBox(-2.0F, 9.0F, 3.0F, 6.0F, 8.0F, 14.0F).texOffs(130, 138).mirror(false).addBox(-2.5F, -4.0F, -2.5F, 7.0F, 8.0F, 20.0F), PartPose.offset(15.0F, 20.5F, -21.0F));
        PartDefinition larmFeathers = larm.addOrReplaceChild("larmFeathers", CubeListBuilder.create().texOffs(154, 221).mirror(false).addBox(0.0F, -11.5F, 0.0F, 0.0F, 23.0F, 6.0F), PartPose.offset(2.5F, 7.5F, 17.5F));
        PartDefinition lhand = larm.addOrReplaceChild("lhand", CubeListBuilder.create().texOffs(84, 170).mirror(false).addBox(-2.0F, -0.5F, -7.0F, 6.0F, 8.0F, 14.0F), PartPose.offset(0.0F, 17.5F, 10.0F));
        PartDefinition lhandClaw1 = lhand.addOrReplaceChild("lhandClaw1", CubeListBuilder.create().texOffs(151, 169).mirror(false).addBox(-12.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F).texOffs(0, 88).mirror(false).addBox(-12.0F, 0.0F, -2.0F, 13.0F, 4.0F, 4.0F), PartPose.offset(3.0F, 7.5F, -5.0F));
        PartDefinition lhandClaw2 = lhand.addOrReplaceChild("lhandClaw2", CubeListBuilder.create().texOffs(151, 169).mirror(false).addBox(-10.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F).texOffs(0, 88).mirror(false).addBox(-10.0F, 0.0F, -2.0F, 13.0F, 4.0F, 4.0F), PartPose.offset(1.0F, 7.5F, 0.0F));
        PartDefinition lhandClaw3 = lhand.addOrReplaceChild("lhandClaw3", CubeListBuilder.create().texOffs(151, 169).mirror(false).addBox(-10.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F).texOffs(0, 88).mirror(false).addBox(-10.0F, 0.0F, -2.0F, 13.0F, 4.0F, 4.0F), PartPose.offset(1.0F, 7.5F, 5.0F));
        PartDefinition rarm = chest.addOrReplaceChild("rarm", CubeListBuilder.create().texOffs(84, 170).mirror(true).addBox(-4.0F, 9.0F, 3.5F, 6.0F, 8.0F, 14.0F).texOffs(40, 160).mirror(true).addBox(-4.5F, 4.0F, 3.0F, 7.0F, 21.0F, 15.0F).texOffs(130, 138).mirror(true).addBox(-4.5F, -4.0F, -2.0F, 7.0F, 8.0F, 20.0F), PartPose.offset(-15.0F, 20.5F, -21.5F));
        PartDefinition rarmFeathers = rarm.addOrReplaceChild("rarmFeathers", CubeListBuilder.create().texOffs(154, 221).mirror(true).addBox(0.0F, -11.5F, 0.0F, 0.0F, 23.0F, 6.0F), PartPose.offset(-2.5F, 7.5F, 18.0F));
        PartDefinition rhand = rarm.addOrReplaceChild("rhand", CubeListBuilder.create().texOffs(84, 170).mirror(true).addBox(-4.0F, -0.5F, -7.0F, 6.0F, 8.0F, 14.0F), PartPose.offset(0.0F, 17.5F, 10.5F));
        PartDefinition rhandClaw1 = rhand.addOrReplaceChild("rhandClaw1", CubeListBuilder.create().texOffs(151, 169).mirror(true).addBox(11.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F).texOffs(0, 88).mirror(true).addBox(-1.0F, 0.0F, -2.0F, 13.0F, 4.0F, 4.0F), PartPose.offset(-3.0F, 7.5F, -5.0F));
        PartDefinition rhandClaw2 = rhand.addOrReplaceChild("rhandClaw2", CubeListBuilder.create().texOffs(151, 169).mirror(true).addBox(9.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F).texOffs(0, 88).mirror(true).addBox(-3.0F, 0.0F, -2.0F, 13.0F, 4.0F, 4.0F), PartPose.offset(-1.0F, 7.5F, 0.0F));
        PartDefinition rhandClaw3 = rhand.addOrReplaceChild("rhandClaw3", CubeListBuilder.create().texOffs(151, 169).mirror(true).addBox(9.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F).texOffs(0, 88).mirror(true).addBox(-3.0F, 0.0F, -2.0F, 13.0F, 4.0F, 4.0F), PartPose.offset(-1.0F, 7.5F, 5.0F));
        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(116, 20).mirror(false).addBox(-8.0F, -8.0F, -11.0F, 16.0F, 10.0F, 16.0F).texOffs(66, 138).mirror(false).addBox(-8.0F, 2.0F, -11.0F, 16.0F, 6.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -23.0F, 0.35F, 0.0F, 0.0F));
        PartDefinition neck2 = neck.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(116, 10).mirror(false).addBox(-8.0F, -10.0F, -11.0F, 16.0F, 10.0F, 16.0F), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.1F, 0.0F, 0.0F));
        PartDefinition neck2b = neck2.addOrReplaceChild("neck2b", CubeListBuilder.create().texOffs(116, 10).mirror(false).addBox(-8.0F, -10.0F, -11.0F, 16.0F, 10.0F, 16.0F), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.05F, 0.0F, 0.0F));
        PartDefinition neck3 = neck2b.addOrReplaceChild("neck3", CubeListBuilder.create().texOffs(116, 0).mirror(false).addBox(-8.0F, -10.0F, -11.0F, 16.0F, 10.0F, 16.0F), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.1F, 0.0F, 0.0F));
        PartDefinition neckFeathers = neck3.addOrReplaceChild("neckFeathers", CubeListBuilder.create().texOffs(0, 49).mirror(false).addBox(0.0F, -3.0F, -9.5F, 0.0F, 22.0F, 17.0F), PartPose.offset(0.0F, -10.0F, -7.5F));
        PartDefinition head = neck3.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 181).mirror(false).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 10.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -1.0F, -0.1F, 0.0F, 0.0F));
        PartDefinition head2 = head.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 171).mirror(false).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.05F, 0.0F, 0.0F));
        PartDefinition head2b = head2.addOrReplaceChild("head2b", CubeListBuilder.create().texOffs(0, 171).mirror(false).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.2F, 0.0F, 0.0F));
        PartDefinition head3 = head2b.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(0, 160).mirror(false).addBox(-5.0F, -11.0F, -5.0F, 10.0F, 11.0F, 10.0F).texOffs(168, 46).mirror(false).addBox(-3.0F, -11.0F, -12.0F, 6.0F, 2.0F, 7.0F).texOffs(168, 56).mirror(false).addBox(-4.5F, -11.0F, -17.0F, 9.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.9F, 0.0F, 0.0F));
        PartDefinition jaw = head3.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(88, 14).mirror(false).addBox(-3.5F, 0.0F, -7.0F, 7.0F, 4.0F, 7.0F).texOffs(0, 19).mirror(false).addBox(-4.5F, 2.0F, -12.0F, 9.0F, 2.0F, 5.0F), PartPose.offset(0.0F, -9.0F, -5.0F));
        PartDefinition lwattle = jaw.addOrReplaceChild("lwattle", CubeListBuilder.create().texOffs(30, 164).mirror(false).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F), PartPose.offset(3.0F, 4.0F, -1.0F));
        PartDefinition rwattle = jaw.addOrReplaceChild("rwattle", CubeListBuilder.create().texOffs(30, 164).mirror(false).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F), PartPose.offset(-3.0F, 4.0F, -1.0F));
        PartDefinition hips = body.addOrReplaceChild("hips", CubeListBuilder.create().texOffs(97, 46).mirror(false).addBox(-13.0F, -0.75F, -5.0F, 26.0F, 29.0F, 19.0F), PartPose.offset(0.0F, -10.5F, 3.0F));
        PartDefinition lleg = hips.addOrReplaceChild("lleg", CubeListBuilder.create().texOffs(124, 166).mirror(false).addBox(-4.0F, -3.0F, -7.5F, 8.0F, 18.0F, 11.0F), PartPose.offset(12.0F, 23.5F, 9.5F));
        PartDefinition lleg2 = lleg.addOrReplaceChild("lleg2", CubeListBuilder.create().texOffs(0, 0).mirror(false).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 12.0F, 7.0F), PartPose.offset(-0.5F, 13.0F, 1.0F));
        PartDefinition lfoot = lleg2.addOrReplaceChild("lfoot", CubeListBuilder.create().texOffs(88, 0).mirror(false).addBox(-3.5F, 0.5F, -7.5F, 7.0F, 3.0F, 11.0F), PartPose.offset(0.0F, 9.5F, 1.0F));
        PartDefinition claw1 = lfoot.addOrReplaceChild("claw1", CubeListBuilder.create().texOffs(88, 0).mirror(false).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(-2.5F, 0.5F, -7.5F));
        PartDefinition claw2 = lfoot.addOrReplaceChild("claw2", CubeListBuilder.create().texOffs(88, 0).mirror(false).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.5F, -7.5F));
        PartDefinition claw3 = lfoot.addOrReplaceChild("claw3", CubeListBuilder.create().texOffs(88, 0).mirror(false).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(2.5F, 0.5F, -7.5F));
        PartDefinition rleg = hips.addOrReplaceChild("rleg", CubeListBuilder.create().texOffs(124, 166).mirror(true).addBox(-4.0F, -3.0F, -7.5F, 8.0F, 18.0F, 11.0F), PartPose.offset(-12.0F, 23.5F, 9.5F));
        PartDefinition rleg2 = rleg.addOrReplaceChild("rleg2", CubeListBuilder.create().texOffs(0, 0).mirror(true).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 12.0F, 7.0F), PartPose.offset(0.5F, 13.0F, 1.0F));
        PartDefinition rfoot = rleg2.addOrReplaceChild("rfoot", CubeListBuilder.create().texOffs(88, 0).mirror(true).addBox(-3.5F, 0.5F, -7.5F, 7.0F, 3.0F, 11.0F), PartPose.offset(0.0F, 9.5F, 1.0F));
        PartDefinition rclaw1 = rfoot.addOrReplaceChild("rclaw1", CubeListBuilder.create().texOffs(88, 0).mirror(true).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(2.5F, 0.5F, -7.5F));
        PartDefinition rclaw2 = rfoot.addOrReplaceChild("rclaw2", CubeListBuilder.create().texOffs(88, 0).mirror(true).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.5F, -7.5F));
        PartDefinition rclaw3 = rfoot.addOrReplaceChild("rclaw3", CubeListBuilder.create().texOffs(88, 0).mirror(true).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(-2.5F, 0.5F, -7.5F));
        PartDefinition tail = hips.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(165, 100).mirror(false).addBox(-8.0F, -5.0F, -2.0F, 16.0F, 16.0F, 22.0F), PartPose.offset(0.0F, 10.5F, 13.0F));
        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(88, 225).mirror(false).addBox(-4.0F, -2.0F, -2.5F, 8.0F, 8.0F, 23.0F), PartPose.offset(0.0F, 1.0F, 19.5F));
        PartDefinition tailFeathers = tail2.addOrReplaceChild("tailFeathers", CubeListBuilder.create().texOffs(127, 167).mirror(false).addBox(-12.0F, 0.0F, -14.0F, 24.0F, 18.0F, 38.0F), PartPose.offset(0.0F, 1.0F, 17.5F));
        return LayerDefinition.create(mesh, 256, 256);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float s = limbSwing * 0.4F;
        float a = limbSwingAmount;
        lleg.xRot += Mth.cos(s) * 0.6F * a;
        rleg.xRot += Mth.cos(s + Mth.PI) * 0.6F * a;
        larm.xRot += Mth.cos(s + Mth.PI) * 0.3F * a;
        rarm.xRot += Mth.cos(s) * 0.3F * a;
        neck.yRot += netHeadYaw * 0.0087F;
        neck.xRot += headPitch * 0.0087F;
        head.yRot += netHeadYaw * 0.0087F;
        head.xRot += headPitch * 0.0087F;
        tail.yRot += Mth.sin(s * 0.5F) * 0.25F * a + Mth.sin(ageInTicks * 0.06F) * 0.05F;
    }
}
