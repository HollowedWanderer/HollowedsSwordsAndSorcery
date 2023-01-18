package net.hollowed.hss.common.item.custom;


import net.hollowed.hss.common.item.ModCreativeModeTab;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class StaffOfThundering extends SwordItem {

    public StaffOfThundering() {
        super(new Tier() {
                  public int getUses() {
                      return 250;
                  }

                  public float getSpeed() {
                      return 0f;
                  }

                  public float getAttackDamageBonus() {
                      return 5f;
                  }

                  public int getLevel() {
                      return 0;
                  }

                  public int getEnchantmentValue() {
                      return 15;
                  }

                  public Ingredient getRepairIngredient() {
                      return Ingredient.EMPTY;
                  }
              },

                3, -2.7999999999999998f,

                new Item.Properties().tab(ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB));
    }






    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ItemStack itemstack = ar.getObject();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        StaffOfThunderingRightclick.execute(world, entity, itemstack);
        return ar;
    }
}

