package net.hollowed.hss.common.event;

import net.hollowed.hss.common.effect.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DamageHandler {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            DamageSource source = event.getSource(); // what caused the damage
            float amount = event.getAmount(); // amount of damage taken
            if (player.hasEffect(ModEffects.SILVER_SHIELD.get()) && shouldAffect(source)) {
                event.setAmount(amount * 10f); // sets the amount of damage taken to
                // 80% of its original value
            }
        }
    }

    private static boolean shouldAffect(DamageSource source) {
        return source.is(DamageTypes.ARROW) ||
                source.is(DamageTypes.FIREBALL) ||
                source.is(DamageTypes.FALLING_STALACTITE) ||
                source.is(DamageTypes.FIREWORKS) ||
                source.is(DamageTypes.MAGIC); // ...
    }
}