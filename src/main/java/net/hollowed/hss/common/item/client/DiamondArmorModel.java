package net.hollowed.hss.common.item.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.item.custom.DiamondArmorItem;
import net.hollowed.hss.common.item.custom.PlatinumArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DiamondArmorModel extends GeoModel<DiamondArmorItem> {
    @Override
    public ResourceLocation getModelResource(DiamondArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/horned_diamond_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiamondArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/armor/horned_diamond_helmet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiamondArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/horned_diamond_helmet.animation.json");
    }
}
