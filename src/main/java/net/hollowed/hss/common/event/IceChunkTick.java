package net.hollowed.hss.common.event;

import com.mojang.datafixers.types.Func;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceChunkEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class IceChunkTick {
    static boolean FuncOnce;

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((!world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))
                || !world.isEmptyBlock(BlockPos.containing(x - 1, y - 0.1, z))
                || !world.isEmptyBlock(BlockPos.containing(x - 1, y - 0.1, z - 1))
                || !world.isEmptyBlock(BlockPos.containing(x - 1, y - 0.1, z + 1))
                || !world.isEmptyBlock(BlockPos.containing(x + 1, y - 0.1, z))
                || !world.isEmptyBlock(BlockPos.containing(x + 1, y - 0.1, z - 1))
                || !world.isEmptyBlock(BlockPos.containing(x + 1, y - 0.1, z + 1))
                || !world.isEmptyBlock(BlockPos.containing(x, y - 0.01, z + 1))
                || !world.isEmptyBlock(BlockPos.containing(x, y - 0.01, z - 1)))
                && !FuncOnce) {
            FuncOnce = true;
            HollowedsSwordsAndSorcery.queueServerWork(6, () -> {
                if (!entity.level().isClientSide())
                    entity.discard();
                IceChunkSmash.execute(world, x, y, z);
                HollowedsSwordsAndSorcery.queueServerWork(1, () -> {
                    FuncOnce = false;
                });
            });


        }
    }
}