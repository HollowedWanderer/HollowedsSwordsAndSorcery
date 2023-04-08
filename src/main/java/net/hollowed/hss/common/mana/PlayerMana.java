package net.hollowed.hss.common.mana;

import net.minecraft.nbt.CompoundTag;

public class PlayerMana {
    private int mana;
    private final int max_mana = 20;
    private final int min_mana = 0;

    public int getMana() {
        return mana;
    }

    public void addMana(int add) {
        this.mana = Math.min(mana + add, max_mana);
    }

    public void subMana(int sub) {
        this.mana = Math.min(mana - sub, min_mana);
    }

    public void copyFrom(PlayerMana source) {
        this.mana = source.mana;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("mana", mana);
    }

    public void loadNBTData(CompoundTag nbt) {
        mana = nbt.getInt("mana");
    }
}
