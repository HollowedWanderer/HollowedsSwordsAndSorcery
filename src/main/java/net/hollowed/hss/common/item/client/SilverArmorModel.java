package net.hollowed.hss.common.item.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.item.custom.SilverArmorItem;
import net.hollowed.hss.common.item.custom.SteelArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SilverArmorModel extends GeoModel<SilverArmorItem> {
    @Override
    public ResourceLocation getModelResource(SilverArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/silver_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SilverArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/armor/silver_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SilverArmorItem animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/silver_armor.animation.json");
    }
}
