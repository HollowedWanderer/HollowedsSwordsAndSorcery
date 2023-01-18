package net.hollowed.hss.common.network;

import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;



import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerJoinWorld {
    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        execute(event, event.getLevel(), event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity) {
        execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        {
            boolean _setval = true;
            entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.FireRiderCooldown = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        new Object() {
            private int ticks = 0;
            private float waitTicks;
            private LevelAccessor world;

            public void start(LevelAccessor world, int waitTicks) {
                this.waitTicks = waitTicks;
                MinecraftForge.EVENT_BUS.register(this);
                this.world = world;
            }

            @SubscribeEvent
            public void tick(TickEvent.ServerTickEvent event) {
                if (event.phase == TickEvent.Phase.END) {
                    this.ticks += 1;
                    if (this.ticks >= this.waitTicks)
                        run();
                }
            }

            private void run() {
                {
                    boolean _setval = false;
                    entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.FireRiderCooldown = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                MinecraftForge.EVENT_BUS.unregister(this);
            }
        }.start(world, 200);
    }
}

