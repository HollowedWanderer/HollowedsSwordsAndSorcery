package net.hollowed.hss.common.block.custom;

import net.hollowed.hss.common.client.particle.ModParticleTypes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class MistleafLilyParticle {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level)
            _level.sendParticles(ModParticleTypes.FOG.get(), x, y, z, 5, 15, 5, 15, 0.04);
    }
}

