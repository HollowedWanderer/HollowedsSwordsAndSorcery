package net.hollowed.hss.common.event;

import net.hollowed.hss.common.block.entity.ModWoodTypes;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.entity.client.DeepslateGolemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientSetupEvents {

	public static void modRenderTypes() {

		EntityRenderers.register(ModEntityTypes.DEEPSLATE_GOLEM.get(), DeepslateGolemRenderer::new);


		// ItemBlockRenderTypes.setRenderLayer(ModBlocks.TEMPLE_STATUE.get(), RenderType.cutout());
		// ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATTAIL.get(), renderType -> renderType == RenderType.cutout());

		//BlockEntityRenderers.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
	}

	public static void modWoodTypes() {

		//WoodType.register(ModWoodTypes.CINNAMON);
		//WoodType.register(ModWoodTypes.MAHOGANY);

	}


//	@SubscribeEvent
//	public static void onClientSetup(FMLClientSetupEvent event) {
//		EntityRenderers.register(ModEntityTypes.WROUGHT_SPEARMAN.get(), WroughtSpearmanRenderer::new);
//		EntityRenderers.register(ModEntityTypes.WROUGHT_SWORDSMAN.get(), WroughtSwordsmanRenderer::new);
//		EntityRenderers.register(ModEntityTypes.DEEPSLATE_GOLEM.get(), DeepslateGolemRenderer::new);
//		EntityRenderers.register(ModEntityTypes.WROUGHT_SENTINEL.get(), WroughtSentinelRenderer::new);
//		EntityRenderers.register(ModEntityTypes.SHOCKWAVE.get(), WroughtSentinelRenderer::new);
//
//		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TEMPLE_STATUE.get(), RenderType.cutout());
//		ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATTAIL.get(), renderType -> renderType == RenderType.cutout());
//	}

}
