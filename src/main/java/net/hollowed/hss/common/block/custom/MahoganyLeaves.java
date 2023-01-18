package net.hollowed.hss.common.block.custom;

import net.hollowed.hss.common.block.ModBlocks;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class MahoganyLeaves extends LeavesBlock {
    public MahoganyLeaves() {
        super(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F, 0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion());
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }



    @OnlyIn(Dist.CLIENT)
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return FoliageColor.getDefaultColor();
        }, ModBlocks.MAHOGANY_LEAVES.get());
    }

    @OnlyIn(Dist.CLIENT)
    public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, index) -> {
            return FoliageColor.getDefaultColor();
        }, ModBlocks.MAHOGANY_LEAVES.get());
    }
}
