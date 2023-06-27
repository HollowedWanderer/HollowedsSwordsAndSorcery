package net.hollowed.hss;

import com.mojang.logging.LogUtils;
import net.hollowed.hss.common.block.ModBlocks;
import net.hollowed.hss.common.block.entity.ModBlockEntities;
import net.hollowed.hss.common.client.particle.ModParticleTypes;
import net.hollowed.hss.common.client.particle.ModParticles;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.event.ModClientSetupEvents;
import net.hollowed.hss.common.event.ModCommonSetupEvents;
import net.hollowed.hss.common.item.ModCreativeModeTab;
import net.hollowed.hss.common.item.ModItems;

//import net.hollowed.hss.common.villager.ModVillagers;
import net.hollowed.hss.common.world.feature.ModConfiguredFeatures;
import net.hollowed.hss.common.world.feature.ModPlacedFeatures;
import net.hollowed.hss.common.world.structure.ModStructures;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;
//import top.theillusivec4.curios.api.CuriosApi;
//import top.theillusivec4.curios.api.SlotTypeMessage;
//import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HollowedsSwordsAndSorcery.MOD_ID)
public class HollowedsSwordsAndSorcery {
    public static final String MOD_ID = "hss";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, MOD_ID), () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int messageID = 0;

    private static final List<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ArrayList<>();

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry(action, tick));
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getKey().run());
            workQueue.removeAll(actions);
        }
    }


    public HollowedsSwordsAndSorcery() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModParticleTypes.REGISTRY.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntityTypes.register(modEventBus);
       // ModVillagers.register(modEventBus);

        ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);

        ModStructures.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onClientSetup);
        //modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onClientSetup(final FMLClientSetupEvent event) {
        // Some client setup code
        LOGGER.info("Starting Client Setup...");

        ModClientSetupEvents.modWoodTypes();
        ModClientSetupEvents.modRenderTypes();

        LOGGER.info("Client Setup finished.");
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("Starting Common Setup...");

        ModCommonSetupEvents.addModWoodTypes(event);
        //ModCommonSetupEvents.addModItemProperties(event);
        ModCommonSetupEvents.addModVillagerPOIS(event);

        LOGGER.info("Common Setup finished.");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ModCreativeModeTab.EQUIPMENT_TAB.get()) {
            event.accept(ModItems.STEEL_INGOT);
            event.accept(ModItems.SILVER_SCRAP);
            event.accept(ModItems.MYTHRIL_INGOT);
            event.accept(ModItems.PLATINUM);
            event.accept(ModItems.MYTHRIL_INGOT);
            event.accept(ModItems.ENDER_DUST);
            event.accept(ModItems.DEATHS_SCYTHE);
            event.accept(ModItems.STEEL_SWORD);
            event.accept(ModItems.STEEL_PICKAXE);
            event.accept(ModItems.STEEL_AXE);
            event.accept(ModItems.STEEL_SHOVEL);
            event.accept(ModItems.STEEL_HOE);
            event.accept(ModItems.STEEL_HELMET);
            event.accept(ModItems.STEEL_CHESTPLATE);
            event.accept(ModItems.STEEL_LEGGING);
            event.accept(ModItems.STEEL_BOOTS);
            event.accept(ModItems.STEEL_GREATSWORD);
            event.accept(ModItems.STEEL_GLAIVE);
            event.accept(ModItems.PLATINUM_SWORD);
            event.accept(ModItems.PLATINUM_PICKAXE);
            event.accept(ModItems.PLATINUM_AXE);
            event.accept(ModItems.PLATINUM_SHOVEL);
            event.accept(ModItems.PLATINUM_HOE);
            event.accept(ModItems.PLATINUM_HELMET);
            event.accept(ModItems.PLATINUM_CHESTPLATE);
            event.accept(ModItems.PLATINUM_LEGGINGS);
            event.accept(ModItems.PLATINUM_BOOTS);
            event.accept(ModItems.PLATINUM_GREATSWORD);
            event.accept(ModItems.PLATINUM_GLAIVE);
            event.accept(ModItems.SILVER_HELMET);
            event.accept(ModItems.SILVER_PLATED_CHESTPIECE);
            event.accept(ModItems.SILVER_PLATED_LEGGINGS);
            event.accept(ModItems.SILVER_TIPPED_BOOTS);
            event.accept(ModItems.SILVER_PLATED_CROSSBOW);
        }
        if(event.getTab() == ModCreativeModeTab.SORCERY_TAB.get()) {
            event.accept(ModItems.ETERNAL_GOLDEN_CARROT);
            event.accept(ModItems.STAFF_OF_THUNDERING);
        }
        if(event.getTab() == ModCreativeModeTab.BLOCKS_TAB.get()) {
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.INFERNIUM_BLOCK);
            event.accept(ModBlocks.ZEPHYRITE_BLOCK);
            event.accept(ModBlocks.STEEL_BLOCK);
            event.accept(ModBlocks.MYTHRIL_BLOCK);
            event.accept(ModBlocks.PLATINUM_BLOCK);
            event.accept(ModBlocks.STICK_BUNDLE);
            event.accept(ModBlocks.SLATE);
            event.accept(ModBlocks.SLATE_BRICKS);
            event.accept(ModBlocks.SLATE_TILES);
            //event.accept(ModBlocks.SLATE_BRICK_STAIRS);
            //event.accept(ModBlocks.SLATE_BRICK_SLAB);
            //event.accept(ModBlocks.SLATE_BRICK_WALL);
            //event.accept(ModBlocks.SLATE_TILE_SLAB);
            //event.accept(ModBlocks.SLATE_TILE_STAIRS);
            event.accept(ModBlocks.VERTICAL_DARK_OAK_PLANKS);
            event.accept(ModBlocks.BROWN_TERRACOTTA_SHINGLES);
        }
    }

  //  private void enqueueIMC(final InterModEnqueueEvent event) {
   //     SlotTypePreset[] types = {SlotTypePreset.HEAD, SlotTypePreset.NECKLACE, SlotTypePreset.BELT, SlotTypePreset.BACK};
   //     for (SlotTypePreset type : types) {
   //         InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> type.getMessageBuilder().build());
   //     }

   //     InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
    //            () -> SlotTypePreset.HANDS.getMessageBuilder().size(2).build());
    //    InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
    //            () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
    //    InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
    //            () -> new SlotTypeMessage.Builder("feet")
     //                   .priority(220).icon(InventoryMenu.EMPTY_ARMOR_SLOT_BOOTS).build());
   // }

   public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder,
                                             Function<FriendlyByteBuf, T> decoder,
                                             BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

}
