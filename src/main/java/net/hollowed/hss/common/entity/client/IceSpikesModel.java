package net.hollowed.hss.common.entity.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceChunkEntity;
import net.hollowed.hss.common.entity.custom.IceSpikesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceSpikesModel extends GeoModel<IceSpikesEntity> {
    @Override
    public ResourceLocation getModelResource(IceSpikesEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/ice_spikes.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceSpikesEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/ice_spikes.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceSpikesEntity animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/ice_spikes.animation.json");
    }
}
