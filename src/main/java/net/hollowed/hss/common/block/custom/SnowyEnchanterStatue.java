package net.hollowed.hss.common.block.custom;

import net.hollowed.hss.common.block.event.EnchanterStatueDestroyed;
import net.hollowed.hss.common.block.event.EnchanterStatuePlaced;
import net.hollowed.hss.common.block.event.SnowyEnchanterStatuePlaced;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;

public class SnowyEnchanterStatue extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public SnowyEnchanterStatue() {
        super(Properties.copy(Blocks.ANDESITE).sound(SoundType.STONE).strength(1.5f, 6).noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        if (player.getInventory().getSelected().getItem() instanceof TieredItem tieredItem)
            return tieredItem.getTier().getLevel() >= 0;
        return false;
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        SnowyEnchanterStatuePlaced.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
        boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
        EnchanterStatueDestroyed.execute(world, pos.getX(), pos.getY(), pos.getZ());
        return retval;
    }

    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion e) {
        super.wasExploded(world, pos, e);
        EnchanterStatueDestroyed.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }

}

