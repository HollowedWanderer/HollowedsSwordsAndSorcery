package net.hollowed.hss.common.block.entity;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.block.ModBlocks;
import net.hollowed.hss.common.block.entity.custom.AlloyForgeBlockEntity;
import net.hollowed.hss.common.block.entity.custom.DungeonDoorBlockEntity;
import net.hollowed.hss.common.block.entity.custom.DungeonDoorOpenBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HollowedsSwordsAndSorcery.MOD_ID);

    public static final RegistryObject<BlockEntityType<AlloyForgeBlockEntity>> ALLOY_FORGE = BLOCK_ENTITIES.register("alloy_forge", () ->
            BlockEntityType.Builder.of(AlloyForgeBlockEntity::new, ModBlocks.ALLOY_FORGE.get()).build(null));
    public static final RegistryObject<BlockEntityType<DungeonDoorBlockEntity>> DUNGEON_DOOR = BLOCK_ENTITIES.register("dungeon_door", () ->
            BlockEntityType.Builder.of(DungeonDoorBlockEntity::new, ModBlocks.DUNGEON_DOOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<DungeonDoorOpenBlockEntity>> DUNGEON_DOOR_OPEN = BLOCK_ENTITIES.register("dungeon_door_open", () ->
            BlockEntityType.Builder.of(DungeonDoorOpenBlockEntity::new, ModBlocks.DUNGEON_DOOR_OPEN.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
