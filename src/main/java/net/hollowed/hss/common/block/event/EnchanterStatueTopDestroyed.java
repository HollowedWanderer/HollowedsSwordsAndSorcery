package net.hollowed.hss.common.block.event;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class EnchanterStatueTopDestroyed {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        {
            BlockPos _pos = BlockPos.containing(x, y - 1, z);
            Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y - 1, z), null);
            world.destroyBlock(_pos, false);
        }
    }
}

