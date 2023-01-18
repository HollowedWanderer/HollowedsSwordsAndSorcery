package net.hollowed.hss.common.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.WroughtSpearmanEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WroughtSpearmanRenderer extends GeoEntityRenderer<WroughtSpearmanEntity> {
    public WroughtSpearmanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WroughtSpearmanModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(WroughtSpearmanEntity instance) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/wrought_sentry.png");
    }

    @Override
    public RenderType getRenderType(WroughtSpearmanEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.9f, 0.9f, 0.9f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
