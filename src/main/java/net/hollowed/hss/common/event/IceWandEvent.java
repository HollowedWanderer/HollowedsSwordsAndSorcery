package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class IceWandEvent {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        HollowedsSwordsAndSorcery.queueServerWork(1, () -> {

                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                            _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                    "playsound minecraft:entity.illusioner.cast_spell player @a ~ ~ ~ 1 1");
                        }
                    }
                });
            }
        }
