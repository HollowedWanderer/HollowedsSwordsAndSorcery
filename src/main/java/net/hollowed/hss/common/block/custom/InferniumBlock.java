package net.hollowed.hss.common.block.custom;

import net.hollowed.hss.common.block.event.InferniumPlaced;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class InferniumBlock extends Block {
    public InferniumBlock() {
        super(Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL).strength(6f, 7f).requiresCorrectToolForDrops());
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        InferniumPlaced.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
        super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
        InferniumPlaced.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }

}

