package net.hollowed.hss.common.event;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import java.util.Objects;

public class IceologerHurt {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (!(new Object() {
            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                    return Objects.requireNonNull(Minecraft.getInstance().getConnection()).getPlayerInfo(_player.getGameProfile().getId()) != null && Objects.requireNonNull(Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId())).getGameMode() == GameType.CREATIVE;
                }
                return false;
            }
        }.checkGamemode(sourceentity))) {
            sourceentity.setTicksFrozen(400);
        }
    }
}


