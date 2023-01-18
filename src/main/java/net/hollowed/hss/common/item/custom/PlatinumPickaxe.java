package net.hollowed.hss.common.item.custom;

import net.hollowed.hss.common.item.ModCreativeModeTab;
import net.hollowed.hss.common.item.ModItems;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class PlatinumPickaxe extends PickaxeItem {
    public PlatinumPickaxe() {
        super(new Tier() {
            public int getUses() {
                return 1851;
            }

            public float getSpeed() {
                return 14f;
            }

            public float getAttackDamageBonus() {
                return 5f;
            }

            public int getLevel() {
                return 3;
            }

            public int getEnchantmentValue() {
                return 16;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(ModItems.PLATINUM.get()));
            }
        }, 1, -2.7999999999999998f, new Item.Properties().tab(ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB));
    }
}

