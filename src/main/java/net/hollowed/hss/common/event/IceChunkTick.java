package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceChunkEntity;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class IceChunkTick {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof IceChunkEntity) {
            IceChunkEntity icechunk = (IceChunkEntity) entity;
            if ((!world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))
                    || !world.isEmptyBlock(BlockPos.containing(x - 1, y - 0.1, z))
                    || !world.isEmptyBlock(BlockPos.containing(x - 1, y - 0.1, z - 1))
                    || !world.isEmptyBlock(BlockPos.containing(x - 1, y - 0.1, z + 1))
                    || !world.isEmptyBlock(BlockPos.containing(x + 1, y - 0.1, z))
                    || !world.isEmptyBlock(BlockPos.containing(x + 1, y - 0.1, z - 1))
                    || !world.isEmptyBlock(BlockPos.containing(x + 1, y - 0.1, z + 1))
                    || !world.isEmptyBlock(BlockPos.containing(x, y - 0.01, z + 1))
                    || !world.isEmptyBlock(BlockPos.containing(x, y - 0.01, z - 1)))
                    && !icechunk.FuncOnce) {
                icechunk.FuncOnce = true;
                HollowedsSwordsAndSorcery.queueServerWork(6, () -> {
                    if (!entity.level().isClientSide())
                        entity.discard();
                    IceChunkSmash.execute(world, x, y, z);
                    HollowedsSwordsAndSorcery.queueServerWork(1, () -> {
                        icechunk.FuncOnce = false;
                    });
                });


            }
        }
    }
}