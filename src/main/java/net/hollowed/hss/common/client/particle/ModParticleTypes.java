package net.hollowed.hss.common.client.particle;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;



public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, HollowedsSwordsAndSorcery.MOD_ID);
    public static final RegistryObject<SimpleParticleType> ELECTRIC_PULSE = REGISTRY.register("electric_pulse",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> ELECTRICAL_CRACKLE = REGISTRY.register("electrical_crackle",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FRICTION_SPARKS = REGISTRY.register("friction_sparks",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> DEATH_SWEEP = REGISTRY.register("death_sweep",
            () -> new SimpleParticleType(false));
}

