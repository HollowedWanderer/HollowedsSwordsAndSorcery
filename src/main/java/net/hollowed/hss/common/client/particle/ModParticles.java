package net.hollowed.hss.common.client.particle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModParticles {
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticleTypes.ELECTRIC_PULSE.get(), ElectricPulse::provider);
        event.registerSpriteSet(ModParticleTypes.ELECTRICAL_CRACKLE.get(), ElectricalCrackle::provider);
        event.registerSpriteSet(ModParticleTypes.FRICTION_SPARKS.get(), FrictionSparks::provider);
        event.registerSpriteSet(ModParticleTypes.DEATH_SWEEP.get(), DeathSweep::provider);
        event.registerSpriteSet(ModParticleTypes.ICE_PORTAL.get(), IcePortal::provider);
        event.registerSpriteSet(ModParticleTypes.LEAVES.get(), Leaves::provider);
        event.registerSpriteSet(ModParticleTypes.SLASH.get(), Slash::provider);
        event.registerSpriteSet(ModParticleTypes.FOG.get(), Fog::provider);
    }
}

