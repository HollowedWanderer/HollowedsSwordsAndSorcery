package net.hollowed.hss.common.block.renderer;

import net.hollowed.hss.common.block.entity.custom.DungeonDoorBlockEntity;
import net.hollowed.hss.common.block.model.DungeonDoorBlockModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;


public class DungeonDoorTileRenderer extends GeoBlockRenderer<DungeonDoorBlockEntity> {
	public DungeonDoorTileRenderer() {
		super(new DungeonDoorBlockModel());
	}

	@Override
	public RenderType getRenderType(DungeonDoorBlockEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
