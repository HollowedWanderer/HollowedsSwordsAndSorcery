package net.hollowed.hss.common.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.entity.custom.DeepslateGolemEntity;
import net.hollowed.hss.common.entity.custom.WroughtSentinelEntity;
import net.hollowed.hss.common.entity.custom.WroughtSpearmanEntity;
import net.hollowed.hss.common.entity.custom.WroughtSwordsmanEntity;
import net.hollowed.hss.common.item.ModItems;
import net.hollowed.hss.common.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


public class ModEvents {

    @Mod.EventBusSubscriber(modid = HollowedsSwordsAndSorcery.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            if(event.getType() == ModVillagers.SPELUNKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.STEEL_INGOT.get(), 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        stack,10,8,0.02F));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = HollowedsSwordsAndSorcery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.WROUGHT_SPEARMAN.get(), WroughtSpearmanEntity.setAttributes());
            event.put(ModEntityTypes.WROUGHT_SWORDSMAN.get(), WroughtSwordsmanEntity.setAttributes());
            event.put(ModEntityTypes.DEEPSLATE_GOLEM.get(), DeepslateGolemEntity.setAttributes());
            event.put(ModEntityTypes.WROUGHT_SENTINEL.get(), WroughtSentinelEntity.setAttributes());
        }
    }

}
