package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class IceologerTick {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24, 24, 24), e -> true).isEmpty() || !world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 24, 24, 24), e -> true).isEmpty()) {
            if (entity == null)
                return;

            if (entity instanceof IceologerEntity) {
                IceologerEntity iceologer = (IceologerEntity) entity;
                if (!iceologer.iceChunkCooldown && entity.isAlive()) {
                    iceologer.casting = true;
                    iceologer.castingCheck = true;
                    // Call the IceologerAttack.execute method
                    IceologerAttack.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());

                    iceologer.iceChunkCooldown = true;
                    HollowedsSwordsAndSorcery.queueServerWork(180, () -> {
                        iceologer.iceChunkCooldown = false;
                    });
                }
            }

        }
    }
}
