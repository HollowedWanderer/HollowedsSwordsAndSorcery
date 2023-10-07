package net.hollowed.hss.common.item.client;

import net.hollowed.hss.common.item.custom.DiamondArmorItem;
import net.hollowed.hss.common.item.custom.PlatinumArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DiamondArmorRenderer extends GeoArmorRenderer<DiamondArmorItem> {
    public DiamondArmorRenderer() {
        super(new DiamondArmorModel());
    }
}
