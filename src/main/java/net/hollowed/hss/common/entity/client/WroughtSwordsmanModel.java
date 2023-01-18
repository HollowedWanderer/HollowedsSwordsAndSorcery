package net.hollowed.hss.common.entity.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.WroughtSwordsmanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WroughtSwordsmanModel extends AnimatedGeoModel<WroughtSwordsmanEntity> {

    @Override
    public ResourceLocation getModelResource(WroughtSwordsmanEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/wrought_swordsman.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WroughtSwordsmanEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/wrought_sentry.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WroughtSwordsmanEntity animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/wrought_sentry.animation.json");
    }
}
