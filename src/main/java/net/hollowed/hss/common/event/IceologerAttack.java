package net.hollowed.hss.common.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Objects;

public class IceologerAttack {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof Level level) {
            if (!level.isClientSide()) {
                // Spawn particles on the server side
                spawnParticles((ServerLevel) level, x, y + 2, z, 20);
            } else {
                // On the client side, play sounds locally
                // Spawn particles on the client side
                spawnParticlesClient(level, x, y + 2, z, 20);
            }
        }
    }

    private static void spawnParticles(ServerLevel world, double x, double y, double z, int count) {
        for (int i = 0; i < count; i++) {
            double motionX = Mth.nextDouble(world.random, -0.05, 0.05);
            double motionY = Mth.nextDouble(world.random, -0.05, 0.05);
            double motionZ = Mth.nextDouble(world.random, -0.05, 0.05);
            world.sendParticles(ParticleTypes.EFFECT, x, y, z, 1, motionX, motionY, motionZ, 0.0);
        }
    }

    private static void spawnParticlesClient(Level world, double x, double y, double z, int count) {
        for (int i = 0; i < count; i++) {
            double motionX = Mth.nextDouble(world.random, -0.05, 0.05);
            double motionY = Mth.nextDouble(world.random, -0.05, 0.05);
            double motionZ = Mth.nextDouble(world.random, -0.05, 0.05);
            world.addParticle(ParticleTypes.EFFECT, x, y, z, motionX, motionY, motionZ);
        }
    }
}