package net.hollowed.hss.common.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.DeepslateGolemEntity;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


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
    public RenderType getRenderType(DeepslateGolemEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
