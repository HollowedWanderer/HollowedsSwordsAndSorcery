package net.hollowed.hss.common.block.listener;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.block.entity.ModBlockEntities;
import net.hollowed.hss.common.block.renderer.DungeonDoorOpenTileRenderer;
import net.hollowed.hss.common.block.renderer.DungeonDoorTileRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;


@Mod.EventBusSubscriber(modid = HollowedsSwordsAndSorcery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntities.DUNGEON_DOOR.get(), context -> new DungeonDoorTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.DUNGEON_DOOR_OPEN.get(), context -> new DungeonDoorOpenTileRenderer());
	}
}
