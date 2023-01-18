package net.hollowed.hss.common.item.custom;

import net.hollowed.hss.common.item.ModCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;
import java.util.List;

public class ParagliderItem extends Item implements DyeableLeatherItem, ICurioItem {


	public ParagliderItem(){
		super(new Properties().stacksTo(1).tab(ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB));
	}

	@Override public int getMaxDamage(ItemStack stack){return (432);}
	@Override public boolean canBeDepleted(){
		return (432)>0;
	}
	@Override public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair){
		ITagManager<Item> tags = ForgeRegistries.ITEMS.tags();
		return tags!=null&&tags.getTag(Tags.Items.LEATHER).contains(repair.getItem());
	}

	@Override public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		if(stack.isDamageableItem()&&stack.getMaxDamage()<=stack.getDamageValue()){
			tooltip.add(Component.translatable("tooltip.paraglider.paraglider_broken").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
		}
	}

	@Override public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged){
		return slotChanged||oldStack.getItem()!=newStack.getItem()||isItemParagliding(oldStack)!=isItemParagliding(newStack);
	}



	@Override
	public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
	{
			livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 0, (false), (false)));
	}

	public static boolean isItemParagliding(ItemStack stack){
		CompoundTag tag = stack.getTag();
		return tag!=null&&tag.getBoolean("Paragliding");
	}

	public static void setItemParagliding(ItemStack stack, boolean paragliding){
		if(isItemParagliding(stack)==paragliding) return;
		CompoundTag tag = stack.getOrCreateTag();
		if(paragliding) tag.putBoolean("Paragliding", true);
		else tag.remove("Paragliding");
	}
}
