package net.hollowed.hss.common.event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class IceChunkSmash {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "execute as @e[type=!hss:iceologer,type=!minecraft:item,type=!hss:ice_chunk,type=!hss:ice_spikes,distance=..2] run damage @s 6 minecraft:falling_block");
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "particle minecraft:block packed_ice ~ ~ ~ 0.5 0.5 0.5 0 30");
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "particle minecraft:snowflake ~ ~0.2 ~ 1 0.25 1 0 200 normal");
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "playsound minecraft:block.glass.break block @a ~ ~ ~ 1 0.4");
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "execute as @e[type=!hss:iceologer,type=!minecraft:item,type=!hss:ice_chunk,type=!hss:ice_spikes,distance=..2] run effect give @s blindness 3 1");
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "execute as @e[type=!hss:iceologer,type=!minecraft:item,type=!hss:ice_chunk,type=!hss:ice_spikes,distance=..2] run effect give @s slowness 3 2");
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "summon hss:ice_spikes");
    }
}

