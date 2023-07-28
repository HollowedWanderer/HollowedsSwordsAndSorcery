package net.hollowed.hss.common.block.renderer;

import net.hollowed.hss.common.block.display.DungeonDoorOpenDisplayItem;
import net.hollowed.hss.common.block.model.DungeonDoorOpenDisplayModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;


public class DungeonDoorOpenDisplayItemRenderer extends GeoItemRenderer<DungeonDoorOpenDisplayItem> {
	public DungeonDoorOpenDisplayItemRenderer() {
		super(new DungeonDoorOpenDisplayModel());
	}

	@Override
	public RenderType getRenderType(DungeonDoorOpenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
