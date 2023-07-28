package net.hollowed.hss.common.event;


import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class IceologerTick {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public int getScore(String score, Entity _ent) {
                Scoreboard _sc = _ent.level().getScoreboard();
                Objective _so = _sc.getObjective(score);
                if (_so != null)
                    return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
                return 0;
            }
        }.getScore("ice_cooldown", entity) == 0) {

                {
                    Entity _ent = entity;
                    Scoreboard _sc = _ent.level().getScoreboard();
                    Objective _so = _sc.getObjective("ice_cooldown");
                    if (_so == null)
                        _so = _sc.addObjective("ice_cooldown", ObjectiveCriteria.DUMMY, Component.literal("ice_cooldown"), ObjectiveCriteria.RenderType.INTEGER);
                    _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
                }
                if (entity instanceof IceologerEntity) {
                    ((IceologerEntity) entity).setAnimation("spell");
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute at @e[type=player,distance=..16] run summon cow ~ ~4 ~");
                    }
                }
                HollowedsSwordsAndSorcery.queueServerWork(Mth.nextInt(RandomSource.create(), 160, 240), () -> {
                    {
                        Entity _ent = entity;
                        Scoreboard _sc = _ent.level().getScoreboard();
                        Objective _so = _sc.getObjective("ice_cooldown");
                        if (_so == null)
                            _so = _sc.addObjective("ice_cooldown", ObjectiveCriteria.DUMMY, Component.literal("ice_cooldown"), ObjectiveCriteria.RenderType.INTEGER);
                        _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
                    }
                });
            }
        }
    }

