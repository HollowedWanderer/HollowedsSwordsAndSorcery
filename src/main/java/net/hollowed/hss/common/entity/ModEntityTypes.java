package net.hollowed.hss.common.entity;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.DeepslateGolemEntity;
import net.hollowed.hss.common.entity.custom.WroughtSentinelEntity;
import net.hollowed.hss.common.entity.custom.WroughtSpearmanEntity;
import net.hollowed.hss.common.entity.custom.WroughtSwordsmanEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HollowedsSwordsAndSorcery.MOD_ID);

    public static final RegistryObject<EntityType<WroughtSpearmanEntity>> WROUGHT_SPEARMAN =
            ENTITY_TYPES.register("wrought_spearman",
                    () -> EntityType.Builder.of(WroughtSpearmanEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.8f)
                            .build(new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "wrought_spearman").toString()));
    public static final RegistryObject<EntityType<WroughtSwordsmanEntity>> WROUGHT_SWORDSMAN =
            ENTITY_TYPES.register("wrought_swordsman",
                    () -> EntityType.Builder.of(WroughtSwordsmanEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.8f)
                            .build(new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "wrought_swordsman").toString()));
    public static final RegistryObject<EntityType<DeepslateGolemEntity>> DEEPSLATE_GOLEM =
            ENTITY_TYPES.register("deepslate_golem",
                    () -> EntityType.Builder.of(DeepslateGolemEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 0.8f)
                            .build(new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "deepslate_golem").toString()));

    public static final RegistryObject<EntityType<WroughtSentinelEntity>> WROUGHT_SENTINEL =
            ENTITY_TYPES.register("wrought_sentinel",
                    () -> EntityType.Builder.of(WroughtSentinelEntity::new, MobCategory.MONSTER)
                            .sized(1.6f, 3.2f)
                            .build(new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "wrought_sentinel").toString()));
    public static final RegistryObject<EntityType<WroughtSentinelEntity>> SHOCKWAVE =
            ENTITY_TYPES.register("shockwave",
                    () -> EntityType.Builder.of(WroughtSentinelEntity::new, MobCategory.AMBIENT)
                            .sized(1f, 0.8f)
                            .build(new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "shockwave").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
