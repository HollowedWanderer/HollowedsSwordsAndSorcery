package net.hollowed.hss.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class DeepslatePlatinumOre extends Block {
    public DeepslatePlatinumOre() {
        super(Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE).strength(7f, 8f).requiresCorrectToolForDrops());
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}

