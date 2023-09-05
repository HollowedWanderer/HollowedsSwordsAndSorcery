package net.hollowed.hss.common.event;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
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
public class PlayerPunchBlock {
    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity) {
        execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:pickaxes")))) && !PlayerPunchAir.punchOverride) {
            if (world.isClientSide()) {
                if (entity instanceof AbstractClientPlayer player) {
                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("hss", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("hss", "mine")))));
                    }
                }
                PlayerPunchAir.punchOverride = true;
                HollowedsSwordsAndSorcery.queueServerWork(10, ()-> {
                    PlayerPunchAir.punchOverride = false;
                });
            }
        } else if (!PlayerPunchAir.punchOverride) {
            if (world.isClientSide()) {
                if (entity instanceof AbstractClientPlayer player) {
                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("hss", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("hss", "punch")))));
                    }
                }
                PlayerPunchAir.punchOverride = true;
                HollowedsSwordsAndSorcery.queueServerWork(10, ()-> {
                    PlayerPunchAir.punchOverride = false;
                });
            }
        }
    }
}
