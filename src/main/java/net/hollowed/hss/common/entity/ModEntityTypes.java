package net.hollowed.hss.common.entity;

import net.hollowed.hss.common.entity.custom.DeepslateGolemEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);


    public static final RegistryObject<EntityType<DeepslateGolemEntity>> DEEPSLATE_GOLEM =
            ENTITY_TYPES.register("deepslate_golem",
                    () -> EntityType.Builder.of(DeepslateGolemEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 0.8f)
                            .build(new ResourceLocation(MOD_ID, "deepslate_golem").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
