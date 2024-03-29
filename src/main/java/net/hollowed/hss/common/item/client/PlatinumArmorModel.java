package net.hollowed.hss.common.item.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.item.custom.PlatinumArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlatinumArmorModel extends GeoModel<PlatinumArmorItem> {
    @Override
    public ResourceLocation getModelResource(PlatinumArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/platinum_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlatinumArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/armor/platinum_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlatinumArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/platinum_armor.animation.json");
    }
}
