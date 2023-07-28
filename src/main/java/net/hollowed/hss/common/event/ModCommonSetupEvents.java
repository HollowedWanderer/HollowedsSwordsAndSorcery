package net.hollowed.hss.common.event;

import net.hollowed.hss.common.block.entity.ModWoodTypes;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.entity.custom.DeepslateGolemEntity;
import net.hollowed.hss.common.entity.custom.IceologerEntity;
import net.hollowed.hss.common.item.ModItems;
//import net.hollowed.hss.common.item.custom.ParagliderItem;
//import net.hollowed.hss.common.villager.ModVillagers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonSetupEvents {

	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {


		}
	}

	public static void addModWoodTypes (FMLCommonSetupEvent event) {

		event.enqueueWork(() -> {

			//Sheets.addWoodType(ModWoodTypes.MAHOGANY);
			//Sheets.addWoodType(ModWoodTypes.CINNAMON);

		});
	}

	//public static void addModItemProperties (FMLCommonSetupEvent event) {
//
//		event.enqueueWork(() -> {
//
//			@SuppressWarnings("deprecation") ItemPropertyFunction itemPropertyGetter =
//					(stack, world, entity, i) -> entity instanceof Player && ParagliderItem.isItemParagliding(stack) ? 1 : 0;
//
//			ItemProperties.register(ModItems.WINGED_MEDALLION.get(), new ResourceLocation("paragliding"), itemPropertyGetter);
//
//		});
//	}

	public static void addModVillagerPOIS (FMLCommonSetupEvent event) {

		//event.enqueueWork(ModVillagers::registerPOIs);

	}

}
