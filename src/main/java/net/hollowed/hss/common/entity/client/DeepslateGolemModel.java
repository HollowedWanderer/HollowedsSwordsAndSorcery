package net.hollowed.hss.common.entity.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.DeepslateGolemEntity;
import net.hollowed.hss.common.entity.custom.WroughtSpearmanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeepslateGolemModel extends AnimatedGeoModel<DeepslateGolemEntity> {
    @Override
    public ResourceLocation getModelResource(DeepslateGolemEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/deepslate_golem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DeepslateGolemEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/deepslate_golem.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DeepslateGolemEntity animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/deepslate_golem.animation.json");
    }
}
