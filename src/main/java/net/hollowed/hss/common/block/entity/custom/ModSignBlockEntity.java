package net.hollowed.hss.common.block.entity.custom;

import net.hollowed.hss.common.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

  //  @Override
    //public @NotNull BlockEntityType<?> getType() {
      //  return ModBlockEntities.MOD_SIGN_BLOCK_ENTITIES.get();
    //}
}
