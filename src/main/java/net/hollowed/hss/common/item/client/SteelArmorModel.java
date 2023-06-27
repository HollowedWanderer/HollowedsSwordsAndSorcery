package net.hollowed.hss.common.item.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.item.custom.SteelArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SteelArmorModel extends GeoModel<SteelArmorItem> {
    @Override
    public ResourceLocation getModelResource(SteelArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/steel_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SteelArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/armor/steel_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SteelArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/steel_armor.animation.json");
    }
}
