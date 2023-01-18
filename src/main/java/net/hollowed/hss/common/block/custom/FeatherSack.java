package net.hollowed.hss.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class FeatherSack extends HayBlock {
    public FeatherSack() {
        super(Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(0.7f, 1f));
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}


