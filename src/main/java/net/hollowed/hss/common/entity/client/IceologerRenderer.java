package net.hollowed.hss.common.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class IceologerRenderer extends GeoEntityRenderer<IceologerEntity> {
    public IceologerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IceologerModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(IceologerEntity instance) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/iceologer.png");
    }

    @Override
    public RenderType getRenderType(IceologerEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }

    @Override
    public void preRender(PoseStack poseStack, IceologerEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 0.9f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
