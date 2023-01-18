package net.hollowed.hss.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.Collections;
import java.util.List;

public class PlatinumOre extends Block {
    public PlatinumOre() {
        super(Properties.of(Material.STONE).sound(SoundType.STONE).strength(7f, 8f).requiresCorrectToolForDrops());
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}

