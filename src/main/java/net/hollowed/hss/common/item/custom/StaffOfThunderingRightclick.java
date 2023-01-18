package net.hollowed.hss.common.item.custom;

//import net.minecraft.core.BlockPos;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResultHolder;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.LightningBolt;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.ClipContext;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.phys.Vec3;

//public class StaffOfThundering extends Item {


  //  public StaffOfThundering(Properties properties) {
    //    super(properties);


    //}






          //  level.addParticle(ParticleTypes.EFFECT, player.level.clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(20)),
            //        ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getX(), player.level.clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(20)),
              //      ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getY(), player.level.clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(20)),
                //    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getZ(), 0d, 0d, 0d);
            //LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(level);
            //entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(
              //      player.level.clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(20)),
                //            ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getX(),
                  //  player.level.clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(20)),
                    //        ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getY(),
                    //player.level.clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(20)),
                      //      ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getBlockPos().getZ())));
            //entityToSpawn.setVisualOnly(false);
            //level.addFreshEntity(entityToSpawn);

        //}



       // return super.use(level, player, hand);
    //}



//}




//LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
//            entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(
//                    entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)),
//                            ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
//                   entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)),
//                            ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
//                    entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)),
//                            ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())));
//            entityToSpawn.setVisualOnly(false);
//            _level.addFreshEntity(entityToSpawn);

/* imports omitted */

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class StaffOfThunderingRightclick {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _level) {
            LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
            entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(
                    entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                            ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
                    entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                            ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
                    entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                            ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())));
            entityToSpawn.setVisualOnly(false);
            _level.addFreshEntity(entityToSpawn);
        }
        if (world instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0.25, entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ(), 200, 1, 0.1, 1, 0.03);
        if (world instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.WAX_OFF, entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ(), 100, 1, 1, 1, 0.075);
        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(_player.getMainHandItem().getItem(), 80);
        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(null, new BlockPos(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.thunder")),
                        SoundSource.MASTER, 5, 1);
            } else {
                _level.playLocalSound(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)),
                                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.thunder")),
                        SoundSource.MASTER, 5, 1, false);
            }



        }
        {
            ItemStack _ist = itemstack;
            if (_ist.hurt(1, null, null)) {
                _ist.shrink(1);
                _ist.setDamageValue(0);
            }
        }
    }
}









