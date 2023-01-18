package net.hollowed.hss.common.entity.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.WroughtSpearmanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WroughtSpearmanModel extends AnimatedGeoModel<WroughtSpearmanEntity> {
    @Override
    public ResourceLocation getModelResource(WroughtSpearmanEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/wrought_spearman.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WroughtSpearmanEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/wrought_sentry.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WroughtSpearmanEntity animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/wrought_sentry.animation.json");
    }
}
