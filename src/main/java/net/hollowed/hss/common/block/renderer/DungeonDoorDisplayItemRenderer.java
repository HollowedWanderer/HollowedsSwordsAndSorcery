package net.hollowed.hss.common.block.renderer;

import net.hollowed.hss.common.block.display.DungeonDoorDisplayItem;
import net.hollowed.hss.common.block.model.DungeonDoorDisplayModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;


public class DungeonDoorDisplayItemRenderer extends GeoItemRenderer<DungeonDoorDisplayItem> {
	public DungeonDoorDisplayItemRenderer() {
		super(new DungeonDoorDisplayModel());
	}

	@Override
	public RenderType getRenderType(DungeonDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
