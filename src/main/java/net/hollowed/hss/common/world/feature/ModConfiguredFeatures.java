package net.hollowed.hss.common.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.block.ModBlocks;
import net.hollowed.hss.common.block.custom.Clover;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ReplaceBlobsFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, HollowedsSwordsAndSorcery.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PLATINUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PLATINUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState())));

//    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CLOVER =
//            FeatureUtils.register("flower_clover", Feature.FLOWER,
//                    new RandomPatchConfiguration(16,6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
//                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CLOVER.get())))));



    //public static final Supplier<List<OreConfiguration.TargetBlockState>> END_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
    //        OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_ZIRCON_ORE.get().defaultBlockState())));
    //public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
    //        OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_ZIRCON_ORE.get().defaultBlockState())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> PLATINUM_ORE = CONFIGURED_FEATURES.register("platinum_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PLATINUM_ORES.get(),7)));


    //public static final RegistryObject<ConfiguredFeature<?, ?>> END_ZIRCON_ORE = CONFIGURED_FEATURES.register("end_zircon_ore",
    //        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_ZIRCON_ORES.get(), 9)));
    //public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_ZIRCON_ORE = CONFIGURED_FEATURES.register("nether_zircon_ore",
    //        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_ZIRCON_ORES.get(), 9)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CLOVER = CONFIGURED_FEATURES.register("clover",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CLOVER.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_TREE =
            CONFIGURED_FEATURES.register("mahogany_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.MAHOGANY_LOG.get()),
                            new StraightTrunkPlacer(6, 1, 2),
                            BlockStateProvider.simple(ModBlocks.MAHOGANY_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(2, 0, 2)).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_BUSH =
            CONFIGURED_FEATURES.register("mahogany_bush", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.MAHOGANY_LOG.get()),
                            new StraightTrunkPlacer(1,0,0),
                            BlockStateProvider.simple(ModBlocks.MAHOGANY_LEAVES.get()),
                            new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1),
                            new TwoLayersFeatureSize(3,0,4)).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_BUSH =
            CONFIGURED_FEATURES.register("oak_bush", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                            new StraightTrunkPlacer(1,0,0),
                            BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()),
                            new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1),
                            new TwoLayersFeatureSize(3,0,4)).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_SPAWN =
            CONFIGURED_FEATURES.register("mahogany_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.MAHOGANY_TREE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.MAHOGANY_TREE_CHECKED.getHolder().get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_BUSH_SPAWN =
            CONFIGURED_FEATURES.register("mahogany_bush_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.MAHOGANY_BUSH_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.MAHOGANY_BUSH_CHECKED.getHolder().get())));

   //Fir Tree Grower

   /** public static final RegistryObject<ConfiguredFeature<?, ?>> FIR_TREE =
            CONFIGURED_FEATURES.register("fir_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.FIR_LOG.get()),
                            new StraightTrunkPlacer(14,2,1),
                            BlockStateProvider.simple(ModBlocks.FIR_LEAVES.get()),
                            new SpruceFoliagePlacer(UniformInt.of(3, 3), UniformInt.of(2, 3), UniformInt.of(1, 3)),
                            new TwoLayersFeatureSize(1,0,2)).build())); **/

   //Mega Tree Grower

  /** public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_TREE =
           CONFIGURED_FEATURES.register("mahogany_tree", () ->
                   new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                           BlockStateProvider.simple(ModBlocks.MAHOGANY_LOG.get()),
                           new GiantTrunkPlacer(24,6,1),
                           BlockStateProvider.simple(ModBlocks.MAHOGANY_LEAVES.get()),
                           new MegaPineFoliagePlacer(UniformInt.of(1, 1), UniformInt.of(2, 3), UniformInt.of(16, 22)),
                           new TwoLayersFeatureSize(1,0,2)).build())); **/


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}

