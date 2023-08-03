package net.hollowed.hss.common.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceChunkEntity;
import net.hollowed.hss.common.entity.custom.IceSpikesEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class IceSpikesRenderer extends GeoEntityRenderer<IceSpikesEntity> {
    public IceSpikesRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IceSpikesModel());
        this.shadowRadius = 0.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(IceSpikesEntity instance) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/ice_spikes.png");
    }

    @Override
    public RenderType getRenderType(IceSpikesEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }

    @Override
    public void preRender(PoseStack poseStack, IceSpikesEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1.1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
