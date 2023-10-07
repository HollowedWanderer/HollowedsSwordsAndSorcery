package net.hollowed.hss.common.entity.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceChunkEntity;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceChunkModel extends GeoModel<IceChunkEntity> {
    @Override
    public ResourceLocation getModelResource(IceChunkEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/ice_chunk.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceChunkEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/ice_chunk.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceChunkEntity animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/ice_chunk.animation.json");
    }
}
