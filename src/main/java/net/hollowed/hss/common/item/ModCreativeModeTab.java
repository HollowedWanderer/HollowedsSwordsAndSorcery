package net.hollowed.hss.common.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab HOLLOWEDS_SWORDS_AND_SORCERY_TAB = new CreativeModeTab("holloweds_swords_and_sorcery_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.STEEL_INGOT.get());
        }
    };
}
