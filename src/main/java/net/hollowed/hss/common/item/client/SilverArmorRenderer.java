package net.hollowed.hss.common.item.client;

import net.hollowed.hss.common.item.custom.PlatinumArmorItem;
import net.hollowed.hss.common.item.custom.SilverArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SilverArmorRenderer extends GeoArmorRenderer<SilverArmorItem> {
    public SilverArmorRenderer() {
        super(new SilverArmorModel());
    }
}
