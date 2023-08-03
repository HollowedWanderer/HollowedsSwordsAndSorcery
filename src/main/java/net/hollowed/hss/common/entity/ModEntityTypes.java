package net.hollowed.hss.common.entity;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.IceChunkEntity;
import net.hollowed.hss.common.entity.custom.IceSpikesEntity;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HollowedsSwordsAndSorcery.MOD_ID);
    public static final RegistryObject<EntityType<IceologerEntity>> ICEOLOGER = register("iceologer",
            EntityType.Builder.<IceologerEntity>of(IceologerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IceologerEntity::new)

                    .sized(0.6f, 1.8f));
    public static final RegistryObject<EntityType<IceChunkEntity>> ICE_CHUNK = register("ice_chunk",
            EntityType.Builder.<IceChunkEntity>of(IceChunkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
                    .setCustomClientFactory(IceChunkEntity::new).fireImmune().sized(2.0f, 1f));

    public static final RegistryObject<EntityType<IceSpikesEntity>> ICE_SPIKES = register("ice_spikes",
            EntityType.Builder.<IceSpikesEntity>of(IceSpikesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
                    .setCustomClientFactory(IceSpikesEntity::new).fireImmune().sized(0.1f, 0.1f));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(IceologerEntity::init);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ICEOLOGER.get(), IceologerEntity.createAttributes().build());
        event.put(ICE_CHUNK.get(), IceologerEntity.createAttributes().build());
        event.put(ICE_SPIKES.get(), IceologerEntity.createAttributes().build());
    }
}

