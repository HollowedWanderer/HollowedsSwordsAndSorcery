package net.hollowed.hss.common.block.model;

import net.hollowed.hss.common.block.display.DungeonDoorOpenDisplayItem;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;


public class DungeonDoorOpenDisplayModel extends GeoModel<DungeonDoorOpenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DungeonDoorOpenDisplayItem animatable) {
		return new ResourceLocation("hss", "animations/dungeon_door_open.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DungeonDoorOpenDisplayItem animatable) {
		return new ResourceLocation("hss", "geo/dungeon_door_open.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DungeonDoorOpenDisplayItem entity) {
		return new ResourceLocation("hss", "textures/block/dungeon_door.png");
	}
}
