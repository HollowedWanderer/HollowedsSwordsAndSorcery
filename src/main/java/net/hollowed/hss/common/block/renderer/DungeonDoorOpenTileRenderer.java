package net.hollowed.hss.common.block.renderer;

import net.hollowed.hss.common.block.entity.custom.DungeonDoorOpenBlockEntity;
import net.hollowed.hss.common.block.model.DungeonDoorOpenBlockModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class DungeonDoorOpenTileRenderer extends GeoBlockRenderer<DungeonDoorOpenBlockEntity> {
	public DungeonDoorOpenTileRenderer() {
		super(new DungeonDoorOpenBlockModel());
	}

	@Override
	public RenderType getRenderType(DungeonDoorOpenBlockEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
