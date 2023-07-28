package net.hollowed.hss.common.gui;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HollowedsSwordsAndSorcery.MOD_ID);

    public static final RegistryObject<MenuType<AlloyForgeMenu>> ALLOY_FORGE_MENU = MENU_TYPES.register("alloy_forge_menu",
            () -> IForgeMenuType.create(AlloyForgeMenu::new));

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }

}
