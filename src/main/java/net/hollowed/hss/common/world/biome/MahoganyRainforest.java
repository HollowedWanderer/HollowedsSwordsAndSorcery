package net.hollowed.hss.common.world.biome;

import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;

import java.util.List;

public class MahoganyRainforest {
    public static final Climate.ParameterPoint PARAMETER_POINT = new Climate.ParameterPoint(Climate.Parameter.span(0.366666666666f, 0.7f),
            Climate.Parameter.span(-0.166666666667f, 0.166666666667f), Climate.Parameter.span(0.343333333333f, 0.676666666667f),
            Climate.Parameter.span(0.733333333333f, 1.066666666667f), Climate.Parameter.point(0),
            Climate.Parameter.span(-0.91031032251f, -0.576976989176f), 0);

    public static Biome createBiome() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(10387789).grassColorOverride(9470285).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("hss:grass_mahogany_rainforest", VegetationFeatures.PATCH_GRASS,
                        List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("hss:flower_mahogany_rainforest", VegetationFeatures.FLOWER_DEFAULT, List.of(CountPlacement.of(4),
                        RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("hss:disk_sand_mahogany_rainforest",
                        FeatureUtils.register("hss:disk_sand_mahogany_rainforest", Feature.DISK,
                                new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.SAND),
                                        BlockPredicate.matchesBlocks(List.of(Blocks.GRASS_BLOCK, Blocks.DIRT)), UniformInt.of(2, 6), 2)),
                        List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("hss:disk_gravel_mahogany_rainforest",
                        FeatureUtils.register("hss:disk_gravel_mahogany_rainforest", Feature.DISK,
                                new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL),
                                        BlockPredicate.matchesBlocks(List.of(Blocks.GRASS_BLOCK, Blocks.DIRT)), UniformInt.of(2, 5), 2)),
                        List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
        BiomeDefaultFeatures.addDesertVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addExtraEmeralds(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addLushCavesVegetationFeatures(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenerationSettings);
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(1.2999999999999998f).downfall(0.5f)
                .specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
    }
}

