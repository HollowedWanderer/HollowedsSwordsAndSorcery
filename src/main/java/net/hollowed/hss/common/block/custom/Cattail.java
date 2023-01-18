package net.hollowed.hss.common.block.custom;

import javax.annotation.Nullable;

import net.hollowed.hss.common.block.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Cattail extends BushBlock implements SimpleWaterloggedBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


    public Cattail(BlockBehaviour.Properties p_52861_) {
        super(p_52861_);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor accessor, BlockPos blockPos, BlockPos pos) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);

        if (direction.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (direction == Direction.UP) || blockState.is(this) && blockState.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(accessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, blockState, accessor, blockPos, pos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, flag);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
        builder.add(HALF);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return box(1, 0, 1, 15, 16, 15).move(offset.x, offset.y, offset.z);
    }



    public void setPlacedBy(Level p_52872_, BlockPos p_52873_, BlockState p_52874_, LivingEntity p_52875_, ItemStack p_52876_) {
        BlockPos blockpos = p_52873_.above();
        p_52872_.setBlock(blockpos, copyWaterloggedFrom(p_52872_, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)), 3);
    }

    public boolean canSurvive(BlockState p_52887_, LevelReader p_52888_, BlockPos p_52889_) {
        if (p_52887_.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(p_52887_, p_52888_, p_52889_);
        } else {
            BlockState blockstate = p_52888_.getBlockState(p_52889_.below());
            if (p_52887_.getBlock() != this) return super.canSurvive(p_52887_, p_52888_, p_52889_); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public static void placeAt(LevelAccessor p_153174_, BlockState p_153175_, BlockPos p_153176_, int p_153177_) {
        BlockPos blockpos = p_153176_.above();
        p_153174_.setBlock(p_153176_, copyWaterloggedFrom(p_153174_, p_153176_, p_153175_.setValue(HALF, DoubleBlockHalf.LOWER)), p_153177_);
        p_153174_.setBlock(blockpos, copyWaterloggedFrom(p_153174_, blockpos, p_153175_.setValue(HALF, DoubleBlockHalf.UPPER)), p_153177_);
    }

    public static BlockState copyWaterloggedFrom(LevelReader p_182454_, BlockPos p_182455_, BlockState p_182456_) {
        return p_182456_.hasProperty(BlockStateProperties.WATERLOGGED) ? p_182456_.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(p_182454_.isWaterAt(p_182455_))) : p_182456_;
    }

    public void playerWillDestroy(Level p_52878_, BlockPos p_52879_, BlockState p_52880_, Player p_52881_) {
        if (!p_52878_.isClientSide) {
            if (p_52881_.isCreative()) {
                preventCreativeDropFromBottomPart(p_52878_, p_52879_, p_52880_, p_52881_);
            } else {
                dropResources(p_52880_, p_52878_, p_52879_, null, p_52881_, p_52881_.getMainHandItem());
            }
        }

        super.playerWillDestroy(p_52878_, p_52879_, p_52880_, p_52881_);
    }

    public void playerDestroy(Level p_52865_, Player p_52866_, BlockPos p_52867_, BlockState p_52868_, @Nullable BlockEntity p_52869_, ItemStack p_52870_) {
        super.playerDestroy(p_52865_, p_52866_, p_52867_, Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
    }

    protected static void preventCreativeDropFromBottomPart(Level p_52904_, BlockPos p_52905_, BlockState p_52906_, Player p_52907_) {
        DoubleBlockHalf doubleblockhalf = p_52906_.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = p_52905_.below();
            BlockState blockstate = p_52904_.getBlockState(blockpos);
            if (blockstate.is(p_52906_.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.hasProperty(BlockStateProperties.WATERLOGGED) && blockstate.getValue(BlockStateProperties.WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                p_52904_.setBlock(blockpos, blockstate1, 35);
                p_52904_.levelEvent(p_52907_, 2001, blockpos, Block.getId(blockstate));
            }
        }

    }

    public long getSeed(BlockState p_52891_, BlockPos p_52892_) {
        return Mth.getSeed(p_52892_.getX(), p_52892_.below(p_52891_.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), p_52892_.getZ());
    }


    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATTAIL.get(), renderType -> renderType == RenderType.cutout());
    }

}

