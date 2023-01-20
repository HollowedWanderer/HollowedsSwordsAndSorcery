package net.hollowed.hss.common.world.feature.tree;

import net.hollowed.hss.common.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;

public class MahoganyTreeGrower extends AbstractTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource p_222910_, boolean p_222911_) {
        return ModConfiguredFeatures.MAHOGANY_TREE.getHolder().get();
    }
}
