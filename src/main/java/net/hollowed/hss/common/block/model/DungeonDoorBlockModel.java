package net.hollowed.hss.common.block.model;

import net.hollowed.hss.common.block.entity.custom.DungeonDoorBlockEntity;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class DungeonDoorBlockModel extends GeoModel<DungeonDoorBlockEntity> {
	@Override
	public ResourceLocation getAnimationResource(DungeonDoorBlockEntity animatable) {
		return new ResourceLocation("hss", "animations/dungeon_door.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DungeonDoorBlockEntity animatable) {
		return new ResourceLocation("hss", "geo/dungeon_door.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DungeonDoorBlockEntity entity) {
		return new ResourceLocation("hss", "textures/block/dungeon_door.png");
	}
}
