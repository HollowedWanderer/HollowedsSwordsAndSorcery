package net.hollowed.hss;

import com.mojang.logging.LogUtils;
import net.hollowed.hss.common.block.ModBlocks;
import net.hollowed.hss.common.block.entity.ModBlockEntities;
import net.hollowed.hss.common.block.entity.ModWoodTypes;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.entity.client.DeepslateGolemRenderer;
import net.hollowed.hss.common.entity.client.WroughtSentinelRenderer;
import net.hollowed.hss.common.entity.client.WroughtSpearmanRenderer;
import net.hollowed.hss.common.entity.client.WroughtSwordsmanRenderer;
import net.hollowed.hss.common.entity.custom.WroughtSentinelEntity;
import net.hollowed.hss.common.item.ModItems;
import net.hollowed.hss.common.item.custom.ParagliderItem;
import net.hollowed.hss.common.sound.ModSounds;
import net.hollowed.hss.common.villager.ModVillagers;
import net.hollowed.hss.common.world.feature.ModConfiguredFeatures;
import net.hollowed.hss.common.world.feature.ModPlacedFeatures;
import net.hollowed.hss.common.world.structure.ModStructures;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
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
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

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

    public HollowedsSwordsAndSorcery() {



        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlockEntities.register(modEventBus);



        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);

        ModStructures.register(modEventBus);

        GeckoLib.initialize();
        modEventBus.addListener(this::enqueueIMC);
    }

    public void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TEMPLE_STATUE.get(), RenderType.cutout());

        WoodType.register(ModWoodTypes.MAHOGANY);
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {

        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
            @SuppressWarnings("deprecation") ItemPropertyFunction itemPropertyGetter =
                    (stack, world, entity, i) -> entity instanceof Player && ParagliderItem.isItemParagliding(stack) ? 1 : 0;

            ItemProperties.register(ModItems.WINGED_MEDALLION.get(), new ResourceLocation("paragliding"), itemPropertyGetter);

            Sheets.addWoodType(ModWoodTypes.MAHOGANY);
        });

        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        SlotTypePreset[] types = {SlotTypePreset.HEAD, SlotTypePreset.NECKLACE, SlotTypePreset.BELT, SlotTypePreset.BACK};
        for (SlotTypePreset type : types) {
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> type.getMessageBuilder().build());
        }
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HANDS.getMessageBuilder().size(2).build());
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("feet").priority(220).icon(InventoryMenu.EMPTY_ARMOR_SLOT_BOOTS).build());
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntityTypes.WROUGHT_SPEARMAN.get(), WroughtSpearmanRenderer::new);
            EntityRenderers.register(ModEntityTypes.WROUGHT_SWORDSMAN.get(), WroughtSwordsmanRenderer::new);
            EntityRenderers.register(ModEntityTypes.DEEPSLATE_GOLEM.get(), DeepslateGolemRenderer::new);
            EntityRenderers.register(ModEntityTypes.WROUGHT_SENTINEL.get(), WroughtSentinelRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHOCKWAVE.get(), WroughtSentinelRenderer::new);
        }
    }
    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
                                             BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

}
