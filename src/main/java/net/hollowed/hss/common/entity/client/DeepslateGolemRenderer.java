package net.hollowed.hss.common.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.DeepslateGolemEntity;
import net.hollowed.hss.common.entity.custom.WroughtSpearmanEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeepslateGolemRenderer extends GeoEntityRenderer<DeepslateGolemEntity> {
    public DeepslateGolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeepslateGolemModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(DeepslateGolemEntity instance) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/deepslate_golem.png");
    }

    @Override
    public RenderType getRenderType(DeepslateGolemEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.9f, 0.9f, 0.9f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
