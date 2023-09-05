package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.AbstractClientPlayer;

import javax.annotation.Nullable;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

import java.util.Objects;

@Mod.EventBusSubscriber
public class PlayerTickAnimations {
    public static boolean playerIdle;
    public static boolean playerStep;
    public static boolean playerWalk;
    public static boolean playerSprint;
    public static boolean playerSneakIdle;
    public static boolean playerSneak;
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player.level(), event.player);
        }
    }

    public static void execute(LevelAccessor world, Entity entity) {
        execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (((0.001 < Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().z(), 2)) && entity.isShiftKeyDown()) && !playerSneak) && !PlayerPunchAir.punchOverride) {
            if (world.isClientSide()) {
                if (entity instanceof AbstractClientPlayer player) {
                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("hss", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("hss", "sneak")))));
                    }
                }
                playerSneak = true;
                playerIdle = false;
                playerSneakIdle = false;
                playerSprint = false;
                HollowedsSwordsAndSorcery.queueServerWork(20, ()-> {
                    playerSneak = false;
                });
            }
        }
        if (((0.001 >= Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().z(), 2)) && entity.isShiftKeyDown()) && !playerSneakIdle) && !PlayerPunchAir.punchOverride) {
            if (world.isClientSide()) {
                if (entity instanceof AbstractClientPlayer player) {
                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("hss", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("hss", "sneak_idle")))));
                    }
                }
                playerSneakIdle = true;
                playerIdle = false;
                playerSprint = false;
                HollowedsSwordsAndSorcery.queueServerWork(1, ()-> {
                    playerSneak = false;
                });
                HollowedsSwordsAndSorcery.queueServerWork(50, ()-> {
                    playerSneakIdle = false;
                });
            }
        }
        if ((((entity.isSprinting() && !entity.isSwimming()) && !playerSprint) && !entity.isShiftKeyDown()) && !PlayerPunchAir.punchOverride) {
            playerSneakIdle = false;
            playerStep = false;
            playerWalk = false;
            HollowedsSwordsAndSorcery.queueServerWork(1, ()-> {
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("hss", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("hss", "sprint")))));
                        }
                    }
                    playerSprint = true;
                    HollowedsSwordsAndSorcery.queueServerWork(10, ()-> {
                        playerSprint = false;
                    });
                }
            });
        }
        /* --Code for step animation if I decide to fix the animation-- */
        if (((0 < Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().z(), 2)) && 0.117 > Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().z(), 2))
                && !entity.isShiftKeyDown()) && !playerStep) && !PlayerPunchAir.punchOverride) {
                playerWalk = false;
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("hss", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("hss", "step")))));
                        }
                    }
                    playerStep = true;
                    playerIdle = false;
                    playerSneakIdle = false;
                    playerSprint = false;
                    HollowedsSwordsAndSorcery.queueServerWork(10, ()-> {
                        playerStep = false;
                    });
                }
        }
        if ((((0.117 <= Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().z(), 2)) && !entity.isSprinting()) && !playerWalk)
                && !entity.isShiftKeyDown()) && !PlayerPunchAir.punchOverride) {
            if (world.isClientSide()) {
                if (entity instanceof AbstractClientPlayer player) {
                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("hss", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("hss", "walk")))));
                    }
                }
                playerWalk = true;
                playerSneakIdle = false;
                playerStep = false;
                playerSprint = false;
                HollowedsSwordsAndSorcery.queueServerWork(15, ()-> {
                    playerWalk = false;
                });
            }
        }
    }
}
