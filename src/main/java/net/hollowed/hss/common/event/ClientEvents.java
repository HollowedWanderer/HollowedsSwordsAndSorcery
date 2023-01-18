package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.item.ModHotKeys;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

//import static net.hollowed.hss.common.item.ModHotKeys.FIRE_RING;

public class ClientEvents
{
    @Mod.EventBusSubscriber(modid = HollowedsSwordsAndSorcery.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents
    {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event)
        {
            if (Minecraft.getInstance().screen == null) {
                //if (event.getKey() == FIRE_RING.getKey().getValue()) {
                    //if (event.getAction() == GLFW.GLFW_PRESS) {
                   //     HollowedsSwordsAndSorcery.PACKET_HANDLER.sendToServer(new FireRiderShift(0, 0));
                   //     FireRiderShift.pressAction(Minecraft.getInstance().player, 0, 0);
                   // }
               // }
            }

        }
    }
    @Mod.EventBusSubscriber(modid = HollowedsSwordsAndSorcery.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents
    {
       // @SubscribeEvent
        //public static void onKeyRegister(RegisterKeyMappingsEvent event)
        {
          //  event.register(FIRE_RING);
        }
    }
}
