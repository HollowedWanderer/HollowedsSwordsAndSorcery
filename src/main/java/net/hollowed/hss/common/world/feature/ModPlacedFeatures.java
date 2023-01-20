package net.hollowed.hss.common.world.feature;


import net.hollowed.hss.common.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MOD_ID);

    public static final RegistryObject<PlacedFeature> PLATINUM_ORE_PLACED = PLACED_FEATURES.register("platinum_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PLATINUM_ORE.getHolder().get(),
                    commonOrePlacement(4, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> CLOVER_PLACED = PLACED_FEATURES.register("clover_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CLOVER.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(8),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

//    public static final Holder<PlacedFeature> CLOVER = PlacementUtils.register("clover_placed",
//            ModConfiguredFeatures.CLOVER, RarityFilter.onAverageOnceEvery(16),
//            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

//
//    public static final RegistryObject<PlacedFeature> END_ZIRCON_ORE_PLACED = PLACED_FEATURES.register("end_zircon_ore_placed",
//            () -> new PlacedFeature(ModConfiguredFeatures.END_ZIRCON_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
//                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

//    public static final RegistryObject<PlacedFeature> NETHER_ZIRCON_ORE_PLACED = PLACED_FEATURES.register("nether_zircon_ore_placed",
//            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_ZIRCON_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
//                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> MAHOGANY_TREE_CHECKED = PLACED_FEATURES.register("mahogany_tree_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.MAHOGANY_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.MAHOGANY_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> MAHOGANY_PLACED = PLACED_FEATURES.register("mahogany_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MAHOGANY_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(0, 0.5f, 2))));

    public static final RegistryObject<PlacedFeature> MAHOGANY_BUSH_CHECKED = PLACED_FEATURES.register("mahogany_bush_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.MAHOGANY_BUSH.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.MAHOGANY_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> MAHOGANY_BUSH_PLACED = PLACED_FEATURES.register("mahogany_bush_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MAHOGANY_BUSH_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.25f, 2))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
