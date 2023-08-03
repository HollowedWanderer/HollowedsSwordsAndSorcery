package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class IceSpikesSpawn {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        HollowedsSwordsAndSorcery.queueServerWork(7, () -> {
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        "playsound minecraft:entity.player.hurt_freeze hostile @a ~ ~ ~ 1 0.4");
            IceSpikesStab.execute(world, x, y, z);
            HollowedsSwordsAndSorcery.queueServerWork(1, () -> {
                IceSpikesStab.execute(world, x, y, z);
                HollowedsSwordsAndSorcery.queueServerWork(1, () -> {
                    IceSpikesStab.execute(world, x, y, z);
                    HollowedsSwordsAndSorcery.queueServerWork(1, () -> {
                        IceSpikesStab.execute(world, x, y, z);
                        HollowedsSwordsAndSorcery.queueServerWork(1, () -> {
                            IceSpikesStab.execute(world, x, y, z);
                            HollowedsSwordsAndSorcery.queueServerWork(1, () -> {
                                IceSpikesStab.execute(world, x, y, z);
                            });
                        });
                    });
                });
            });
        });
        HollowedsSwordsAndSorcery.queueServerWork(50, () -> {
            if (!entity.level().isClientSide())
                entity.discard();
        });
    }
}



