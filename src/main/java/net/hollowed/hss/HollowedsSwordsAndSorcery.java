package net.hollowed.hss;

import com.mojang.logging.LogUtils;
import net.hollowed.hss.common.block.ModBlocks;
import net.hollowed.hss.common.block.entity.ModBlockEntities;
import net.hollowed.hss.common.client.particle.ModParticleTypes;
import net.hollowed.hss.common.client.particle.ModParticles;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.event.ModClientSetupEvents;
import net.hollowed.hss.common.event.ModCommonSetupEvents;
import net.hollowed.hss.common.item.ModItems;
import net.hollowed.hss.common.sound.ModSounds;
import net.hollowed.hss.common.villager.ModVillagers;
import net.hollowed.hss.common.world.feature.ModConfiguredFeatures;
import net.hollowed.hss.common.world.feature.ModPlacedFeatures;
import net.hollowed.hss.common.world.structure.ModStructures;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.common.MinecraftForge;
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
import software.bernie.geckolib3.GeckoLib;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

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


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModSounds.register(modEventBus);

        ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);

        ModStructures.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::enqueueIMC);

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
        ModCommonSetupEvents.addModItemProperties(event);
        ModCommonSetupEvents.addModVillagerPOIS(event);

        LOGGER.info("Common Setup finished.");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        SlotTypePreset[] types = {SlotTypePreset.HEAD, SlotTypePreset.NECKLACE, SlotTypePreset.BELT, SlotTypePreset.BACK};
        for (SlotTypePreset type : types) {
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> type.getMessageBuilder().build());
        }

        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                () -> SlotTypePreset.HANDS.getMessageBuilder().size(2).build());
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                () -> new SlotTypeMessage.Builder("feet")
                        .priority(220).icon(InventoryMenu.EMPTY_ARMOR_SLOT_BOOTS).build());
    }

   public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder,
                                             Function<FriendlyByteBuf, T> decoder,
                                             BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

}
