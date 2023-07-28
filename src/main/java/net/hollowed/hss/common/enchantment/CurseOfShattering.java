package net.hollowed.hss.common.enchantment;

import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class CurseOfShattering extends Enchantment {
    public CurseOfShattering(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public int getMinCost(int p_45102_) {
        return p_45102_ * 25;
    }

    @Override
    public int getMaxCost(int p_45105_) {
        return this.getMinCost(p_45105_) + 50;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean checkCompatibility(Enchantment p_45024_) {
        return super.checkCompatibility(p_45024_) && p_45024_ != Enchantments.MENDING;
    }

    @Override
    public boolean isCurse() {
        return true;
    }
}