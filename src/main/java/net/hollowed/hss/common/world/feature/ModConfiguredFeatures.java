package net.hollowed.hss.common.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PLATINUM_ORE_KEY = registerKey("overworld_platinum_ore");

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PLATINUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.PLATINUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState())));


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        register(context, OVERWORLD_PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_PLATINUM_ORES.get(), 7));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


//    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CLOVER =
//            FeatureUtils.register("flower_clover", Feature.FLOWER,
//                    new RandomPatchConfiguration(16,6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
//                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CLOVER.get())))));

//    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
//            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_ZIRCON_ORE.get().defaultBlockState())));
//    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
//            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_ZIRCON_ORE.get().defaultBlockState())));

//    public static final RegistryObject<ConfiguredFeature<?, ?>> END_ZIRCON_ORE = CONFIGURED_FEATURES.register("end_zircon_ore",
//            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_ZIRCON_ORES.get(), 9)));
//    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_ZIRCON_ORE = CONFIGURED_FEATURES.register("nether_zircon_ore",
//            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_ZIRCON_ORES.get(), 9)));

  //  public static final RegistryObject<ConfiguredFeature<?, ?>> CLOVER = CONFIGURED_FEATURES.register("clover",
    //        () -> new ConfiguredFeature<>(Feature.FLOWER,
      //              new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
        //                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CLOVER.get()))))));

  //  public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_TREE =
    //        CONFIGURED_FEATURES.register("mahogany_tree", () ->
      //              new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        //                    BlockStateProvider.simple(ModBlocks.MAHOGANY_LOG.get()),
          //                  new StraightTrunkPlacer(6, 1, 2),
            //                BlockStateProvider.simple(ModBlocks.MAHOGANY_LEAVES.get()),
              //              new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
                //            new TwoLayersFeatureSize(2, 0, 2)).build()));

  //  public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_BUSH =
    //        CONFIGURED_FEATURES.register("mahogany_bush", () ->
      //              new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        //                    BlockStateProvider.simple(ModBlocks.MAHOGANY_LOG.get()),
          //                  new StraightTrunkPlacer(1,0,0),
            //                BlockStateProvider.simple(ModBlocks.MAHOGANY_LEAVES.get()),
              //              new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1),
                //            new TwoLayersFeatureSize(3,0,4)).build()));

 //   public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_BUSH =
   //         CONFIGURED_FEATURES.register("oak_bush", () ->
     //               new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
       //                     BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
         //                   new StraightTrunkPlacer(1,0,0),
           //                 BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()),
             //               new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1),
               //             new TwoLayersFeatureSize(3,0,4)).build()));

  //  public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_SPAWN =
    //        CONFIGURED_FEATURES.register("mahogany_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
      //              new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
        //                    ModPlacedFeatures.MAHOGANY_TREE_CHECKED.getHolder().get(),
          //                  0.5F)), ModPlacedFeatures.MAHOGANY_TREE_CHECKED.getHolder().get())));

    //public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_BUSH_SPAWN =
      //      CONFIGURED_FEATURES.register("mahogany_bush_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
        //            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
          //                  ModPlacedFeatures.MAHOGANY_BUSH_CHECKED.getHolder().get(),
            //                0.5F)), ModPlacedFeatures.MAHOGANY_BUSH_CHECKED.getHolder().get())));

    // Fir Tree Grower

    /** public static final RegistryObject<ConfiguredFeature<?, ?>> FIR_TREE =
     CONFIGURED_FEATURES.register("fir_tree", () ->
     new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
     BlockStateProvider.simple(ModBlocks.FIR_LOG.get()),
     new StraightTrunkPlacer(14,2,1),
     BlockStateProvider.simple(ModBlocks.FIR_LEAVES.get()),
     new SpruceFoliagePlacer(UniformInt.of(3, 3), UniformInt.of(2, 3), UniformInt.of(1, 3)),
     new TwoLayersFeatureSize(1,0,2)).build())); **/

    // Mega Tree Grower

    /** public static final RegistryObject<ConfiguredFeature<?, ?>> MAHOGANY_TREE =
     CONFIGURED_FEATURES.register("mahogany_tree", () ->
     new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
     BlockStateProvider.simple(ModBlocks.MAHOGANY_LOG.get()),
     new GiantTrunkPlacer(24,6,1),
     BlockStateProvider.simple(ModBlocks.MAHOGANY_LEAVES.get()),
     new MegaPineFoliagePlacer(UniformInt.of(1, 1), UniformInt.of(2, 3), UniformInt.of(16, 22)),
     new TwoLayersFeatureSize(1,0,2)).build())); **/



