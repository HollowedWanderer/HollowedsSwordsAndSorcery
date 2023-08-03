package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.hollowed.hss.common.entity.custom.IceologerEntity;

import java.util.Objects;

public class IceologerTick {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (!IceologerEntity.iceChunkCooldown && entity.isAlive()) {
            if (entity instanceof IceologerEntity) {
                IceologerEntity.casting = true;
                IceologerEntity.castingCheck = true;
                // Call the IceologerAttack.execute method
                IceologerAttack.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());

                IceologerEntity.iceChunkCooldown = true;
            }
            HollowedsSwordsAndSorcery.queueServerWork(180, () -> {
                IceologerEntity.iceChunkCooldown = false;
            });
        }
    }
}
