package net.hollowed.hss.common.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier Steel = new ForgeTier(2, 750, 7.0f,
            3f, 12, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.STEEL_INGOT.get()));
    public static final ForgeTier Platinum = new ForgeTier(3, 1851, 12.0f,
            3f, 16, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.PLATINUM.get()));
    public static final ForgeTier Relic = new ForgeTier(3, 2031, 14.0f,
            3f, 16, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.STEEL_INGOT.get()));
    public static final ForgeTier Aetherium = new ForgeTier(3, 3056, 12.0f,
            3f, 16, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.AETHERIUM_INGOT.get()));
}
