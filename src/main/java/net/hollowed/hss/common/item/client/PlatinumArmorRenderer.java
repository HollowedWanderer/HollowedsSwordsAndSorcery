package net.hollowed.hss.common.item.client;

import net.hollowed.hss.common.item.custom.PlatinumArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PlatinumArmorRenderer extends GeoArmorRenderer<PlatinumArmorItem> {
    public PlatinumArmorRenderer() {
        super(new PlatinumArmorModel());
    }
}
