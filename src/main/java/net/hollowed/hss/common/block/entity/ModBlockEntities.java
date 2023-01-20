package net.hollowed.hss.common.block.entity;

import net.hollowed.hss.common.block.ModBlocks;
import net.hollowed.hss.common.block.entity.custom.ModSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> MOD_BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN_BLOCK_ENTITIES =
            MOD_BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.MAHOGANY_WALL_SIGN.get(), ModBlocks.MAHOGANY_SIGN.get(),
                            ModBlocks.CINNAMON_WALL_SIGN.get(), ModBlocks.CINNAMON_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) { MOD_BLOCK_ENTITIES.register(eventBus); }
}
