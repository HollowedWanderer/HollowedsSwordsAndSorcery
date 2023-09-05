package net.hollowed.hss.common.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.entity.custom.DeepslateGolemEntity;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.hollowed.hss.common.item.ModItems;
//import net.hollowed.hss.common.villager.ModVillagers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

public class ModEvents {

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            //if(event.getType() == ModVillagers.SPELUNKER.get()) {
              //  Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
              //  ItemStack stack = new ItemStack(ModItems.STEEL_INGOT.get(), 1);
              //  int villagerLevel = 1;

              //  trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                //        new ItemStack(Items.EMERALD, 5),
                  //      stack,10,8,0.02F));
            //}
        }
    }
    @Mod.EventBusSubscriber(modid = HollowedsSwordsAndSorcery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        }
    }

}
