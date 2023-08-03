package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceChunkEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class IceChunkSpawn {

    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof IceChunkEntity) {
            ((IceChunkEntity) entity).setAnimation("test");
        }

        HollowedsSwordsAndSorcery.queueServerWork(12, () -> {
            entity.setDeltaMovement(new Vec3(0, (-0.8), 0));
        });
        HollowedsSwordsAndSorcery.queueServerWork(100, () -> {
            if (!entity.level().isClientSide())
                entity.discard();
        });
    }
}


