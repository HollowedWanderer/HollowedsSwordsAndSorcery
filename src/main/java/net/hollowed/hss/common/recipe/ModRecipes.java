package net.hollowed.hss.common.recipe;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, HollowedsSwordsAndSorcery.MOD_ID);

    public static final RegistryObject<RecipeSerializer<AlloyForgeRecipe>> FORGING_SERIALIZER =
            SERIALIZERS.register("forging", () -> AlloyForgeRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
