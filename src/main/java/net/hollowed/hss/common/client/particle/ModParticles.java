package net.hollowed.hss.common.client.particle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModParticles {
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.register(ModParticleTypes.ELECTRIC_PULSE.get(), ElectricPulse::provider);
        event.register(ModParticleTypes.ELECTRICAL_CRACKLE.get(), ElectricalCrackle::provider);
        event.register(ModParticleTypes.FRICTION_SPARKS.get(), FrictionSparks::provider);
    }
}

