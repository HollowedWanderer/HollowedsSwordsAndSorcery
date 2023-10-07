package net.hollowed.hss.common.effect;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, HollowedsSwordsAndSorcery.MOD_ID);

    public static final RegistryObject<MobEffect> SILVER_SHIELD = MOB_EFFECTS.register("silver_shield",
            () -> new RangedEffect(MobEffectCategory.BENEFICIAL, -7877432));

    public static final RegistryObject<MobEffect> FOG = MOB_EFFECTS.register("fog",
            () -> new FogEffect(MobEffectCategory.BENEFICIAL, -7877432));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
