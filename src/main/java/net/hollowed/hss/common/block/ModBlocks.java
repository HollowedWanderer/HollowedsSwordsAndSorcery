package net.hollowed.hss.common.block;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.block.custom.*;
import net.hollowed.hss.common.block.entity.ModWoodTypes;
import net.hollowed.hss.common.item.ModCreativeModeTab;
import net.hollowed.hss.common.item.ModItems;
import net.hollowed.hss.common.world.feature.tree.FirTreeGrower;
import net.hollowed.hss.common.world.feature.tree.MahoganyTreeGrower;
import net.hollowed.hss.common.world.feature.tree.NullTree;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.OAK_PLANKS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HollowedsSwordsAndSorcery.MOD_ID);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new SteelBlock(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MINING_TABLE = registerBlock("mining_table",
            () -> new MiningTable(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);

    //Crates

    public static final RegistryObject<Block> CRATE = registerBlock("crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> APPLE_CRATE = registerBlock("apple_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> POTATO_CRATE = registerBlock("potato_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> CARROT_CRATE = registerBlock("carrot_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> BEETROOT_CRATE = registerBlock("beetroot_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> CHORUS_FRUIT_CRATE = registerBlock("chorus_fruit_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> GOLDEN_CARROT_CRATE = registerBlock("golden_carrot_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> GOLDEN_APPLE_CRATE = registerBlock("golden_apple_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> ARROW_CRATE = registerBlock("arrow_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> ROTTeN_FLESH__CRATE = registerBlock("rotten_flesh_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> BLAZE_ROD_CRATE = registerBlock("blaze_rod_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> ENDER_PEARL_CRATE = registerBlock("ender_pearl_crate",
            () -> new Crate(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> STRING_SPOOL = registerBlock("string_spool",
            () -> new StringSpool(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> CHARCOAL_BLOCK = registerBlock("charcoal_block",
            () -> new CharcoalBlock(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);

    //Sacks

    public static final RegistryObject<Block> GUNPOWDER_SACK = registerBlock("gunpowder_sack",
            () -> new ExplosiveSack(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> COCOA_BEAN_SACK = registerBlock("cocoa_bean_sack",
            () -> new Sack(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> SWEET_BERRY_SACK = registerBlock("sweet_berry_sack",
            () -> new Sack(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> SUGAR_SACK = registerBlock("sugar_sack",
            () -> new Sack(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FEATHER_SACK = registerBlock("feather_sack",
            () -> new FeatherSack(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> GLOW_BERRY_SACK = registerBlock("glow_berry_sack",
            () -> new Sack(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);

    //bundles

    public static final RegistryObject<Block> BONE_BUNDLE = registerBlock("bone_bundle",
            () -> new BoneBundle(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> BAMBOO_BUNDLE = registerBlock("bamboo_bundle",
            () -> new BambooBundle(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> CACTUS_BUNDLE = registerBlock("cactus_bundle",
            () -> new CactusBundle(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> SUGAR_CANE_BUNDLE = registerBlock("sugar_cane_bundle",
            () -> new SugarCaneBundle(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> STICK_BUNDLE = registerBlock("stick_bundle",
            () -> new StickBundle(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);

    //Mahogany Wood

    public static final RegistryObject<Block> MAHOGANY_LOG = registerBlock("mahogany_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_WOOD = registerBlock("mahogany_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> STRIPPED_MAHOGANY_LOG = registerBlock("stripped_mahogany_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> STRIPPED_MAHOGANY_WOOD = registerBlock("stripped_mahogany_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_PLANKS = registerBlock("mahogany_planks",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_LEAVES = registerBlock("mahogany_leaves",
            () -> new MahoganyLeaves() {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_SAPLING = registerBlock("mahogany_sapling",
            () -> new SaplingBlock(new MahoganyTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_STAIRS = registerBlock("mahogany_stairs",
            () -> new StairBlock(() -> ModBlocks.MAHOGANY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f)),
            ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_SLAB = registerBlock("mahogany_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f)),
            ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_FENCE = registerBlock("mahogany_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f)),
            ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_FENCE_GATE = registerBlock("mahogany_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f)),
            ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_BUTTON = registerBlock("mahogany_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).sound(SoundType.WOOD)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_PRESSURE_PLATE = registerBlock("mahogany_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).sound(SoundType.WOOD)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_DOOR = registerBlock("mahogany_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    .strength(0.5f).noOcclusion().sound(SoundType.WOOD)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_TRAPDOOR = registerBlock("mahogany_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)
                    .strength(0.5f).noOcclusion().sound(SoundType.WOOD)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MAHOGANY_WALL_SIGN = registerBlockWithoutBlockItem("mahogany_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MAHOGANY));

    public static final RegistryObject<Block> MAHOGANY_SIGN = registerBlockWithoutBlockItem("mahogany_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.MAHOGANY));

    //  "render_type": "cutout"  - render layer in json models


    //Fir Wood

    public static final RegistryObject<Block> GREEN_FIR_SAPLING = registerBlock("green_fir_sapling",
            () -> new FirSapling(new NullTree(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FIR_LEAVES = registerBlock("fir_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> ORANGE_FIR_LEAVES = registerBlock("orange_fir_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FIR_LOG = registerBlock("fir_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FIR_WOOD = registerBlock("fir_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> STRIPPED_FIR_LOG = registerBlock("stripped_fir_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> STRIPPED_FIR_WOOD = registerBlock("stripped_fir_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FIR_PLANKS = registerBlock("fir_planks",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FIR_STAIRS = registerBlock("fir_stairs",
            () -> new StairBlock(() -> ModBlocks.MAHOGANY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f)),
            ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FIR_SLAB = registerBlock("fir_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f)),
            ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FIR_FENCE = registerBlock("fir_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f)),
            ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> FIR_FENCE_GATE = registerBlock("fir_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f)),
            ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);



    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            () -> new PlatinumBlock(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> AETHERIUM_BLOCK = registerBlock("aetherium_block",
            () -> new AetheriumBlock(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> MYTHRIL_BLOCK = registerBlock("mythril_block",
            () -> new MythrilBlock(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> BEWITCHMENT_TABLE = registerBlock("bewitchment_table",
            () -> new BewitchmentTableBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion().dynamicShape().sound(SoundType.STONE)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> CLOVER = registerBlock("clover",
            () -> new Clover(MobEffects.LUCK, 10,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);

    public static final RegistryObject<Block> CATTAIL = registerBlock("cattail",
            () -> new Cattail(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);

    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            () -> new PlatinumOre(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            () -> new DeepslatePlatinumOre(), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
   public static final RegistryObject<Block> TEMPLE_STATUE = registerBlock("temple_statue",
          () -> new TempleStatue(BlockBehaviour.Properties.of(Material.STONE)
                  .strength(4f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.POLISHED_DEEPSLATE)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);
    public static final RegistryObject<Block> EMPTY_TEMPLE_STATUE = registerBlock("empty_temple_statue",
            () -> new EmptyTempleStatue(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.POLISHED_DEEPSLATE)), ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSideHandler {
        @SubscribeEvent
        public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
            MahoganyLeaves.blockColorLoad(event);
        }

        @SubscribeEvent
        public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
            MahoganyLeaves.itemColorLoad(event);
        }
    }

}

   // DoublePlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));