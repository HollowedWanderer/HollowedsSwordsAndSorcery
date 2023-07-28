package net.hollowed.hss.common.block.model;

import net.hollowed.hss.common.block.entity.custom.DungeonDoorOpenBlockEntity;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;


public class DungeonDoorOpenBlockModel extends GeoModel<DungeonDoorOpenBlockEntity> {
	@Override
	public ResourceLocation getAnimationResource(DungeonDoorOpenBlockEntity animatable) {
		return new ResourceLocation("hss", "animations/dungeon_door_open.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DungeonDoorOpenBlockEntity animatable) {
		return new ResourceLocation("hss", "geo/dungeon_door_open.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DungeonDoorOpenBlockEntity entity) {
		return new ResourceLocation("hss", "textures/block/dungeon_door.png");
	}
}
