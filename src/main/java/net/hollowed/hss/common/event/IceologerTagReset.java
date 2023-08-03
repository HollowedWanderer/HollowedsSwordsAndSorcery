package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class IceologerTagReset {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        execute(event, event.getEntity());
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        HollowedsSwordsAndSorcery.queueServerWork(30, () -> {
            {
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                            entity.getName().getString(), entity.getDisplayName(), Objects.requireNonNull(entity.level().getServer()), entity), "kill @e[type=hss:ice_chunk]");
                }
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                            entity.getName().getString(), entity.getDisplayName(), Objects.requireNonNull(entity.level().getServer()), entity), "kill @e[type=hss:ice_spikes]");
                }
            }
        });
    }
}


