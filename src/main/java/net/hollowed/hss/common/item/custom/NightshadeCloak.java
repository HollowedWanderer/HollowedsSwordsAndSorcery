package net.hollowed.hss.common.item.custom;

import net.hollowed.hss.common.item.ModCreativeModeTab;
import net.minecraft.client.Game;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class NightshadeCloak extends Item implements ICurioItem {
    public NightshadeCloak(){
        super(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB));
    }
    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
    {
        if(Screen.hasShiftDown())
        {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, (false), (false)));
        }

    }


}
