package net.hollowed.hss.common.block.model;

import net.hollowed.hss.common.block.display.DungeonDoorDisplayItem;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;


public class DungeonDoorDisplayModel extends GeoModel<DungeonDoorDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DungeonDoorDisplayItem animatable) {
		return new ResourceLocation("hss", "animations/dungeon_door.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DungeonDoorDisplayItem animatable) {
		return new ResourceLocation("hss", "geo/dungeon_door.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DungeonDoorDisplayItem entity) {
		return new ResourceLocation("hss", "textures/block/dungeon_door.png");
	}
}
