package net.hollowed.hss.common.event;

import net.hollowed.hss.common.block.custom.MahoganyLeaves;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

//import static net.hollowed.hss.common.item.ModHotKeys.FIRE_RING;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientForgeEvents {

	public static class ClientForgeEvent {

		@SubscribeEvent
		public static void onKeyInput (InputEvent.Key event) {
//			if (Minecraft.getInstance().screen == null) {
//				if (event.getKey() == FIRE_RING.getKey().getValue()) {
//					if (event.getAction() == GLFW.GLFW_PRESS) {
//						HollowedsSwordsAndSorcery.PACKET_HANDLER.sendToServer(new FireRiderShift(0, 0));
//						FireRiderShift.pressAction(Minecraft.getInstance().player, 0, 0);
//					}
//				}
//			}
		}

//		@SubscribeEvent
//		public static void onKeyRegister(RegisterKeyMappingsEvent event) {
//
//			event.register(FIRE_RING);
//
//		}
	}

	@SubscribeEvent
	public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
		MahoganyLeaves.blockColorLoad(event);
	}

	@SubscribeEvent
	public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
		MahoganyLeaves.itemColorLoad(event);
	}
}
