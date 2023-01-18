package net.hollowed.hss.common.world.feature.tree;


import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class FirTreeGrower {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _serverworld) {
            StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("hss", "fir_tree"));
            if (template != null) {
                template.placeInWorld(_serverworld, new BlockPos(x - 2, y, z - 2), new BlockPos(x - 2, y, z - 2),
                        new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
                        3);
            }
        }
    }
}
