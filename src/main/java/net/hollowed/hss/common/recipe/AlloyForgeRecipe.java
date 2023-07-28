package net.hollowed.hss.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AlloyForgeRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final Ingredient fuelIngredient;

    public AlloyForgeRecipe(ResourceLocation id, ItemStack output,
                            NonNullList<Ingredient> recipeItems, Ingredient fuelIngredient) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.fuelIngredient = fuelIngredient;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        if (!fuelIngredient.test(container.getItem(2))) {
            return false; // Recipe requires fuel, but the fuel slot is empty or contains invalid fuel
        }

        for (int i = 0; i < recipeItems.size(); i++) {
            Ingredient ingredient = recipeItems.get(i);
            int requiredCount = getIngredientCount(i);
            ItemStack itemStack = container.getItem(i);
            if (!ingredient.test(itemStack) || itemStack.getCount() < requiredCount) {
                return false; // Ingredient in slot i does not match or has insufficient count
            }
        }

        return true;
    }

    @Override
    public ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AlloyForgeRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "forging";
    }

    public static class Serializer implements RecipeSerializer<AlloyForgeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "forging");

        @Override
        public AlloyForgeRecipe fromJson(ResourceLocation recipeId, JsonObject serializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(serializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(serializedRecipe, "ingredients");
            NonNullList<Ingredient> recipeItems = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < recipeItems.size(); i++) {
                recipeItems.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            Ingredient fuelIngredient = Ingredient.fromJson(serializedRecipe.get("fuel_ingredient"));

            return new AlloyForgeRecipe(recipeId, output, recipeItems, fuelIngredient);
        }

        @Override
        public @Nullable AlloyForgeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> recipeItems = NonNullList.create();

            for (int i = 0; i < recipeItems.size(); i++) {
                recipeItems.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            Ingredient fuelIngredient = Ingredient.fromNetwork(buf);

            return new AlloyForgeRecipe(id, output, recipeItems, fuelIngredient);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, AlloyForgeRecipe recipe) {
            for (Ingredient ingredient : recipe.recipeItems) {
                ingredient.toNetwork(buf);
            }
            buf.writeItem(recipe.output);
            recipe.fuelIngredient.toNetwork(buf);
        }
    }

    public ItemStack getResultItem() {
        return output.copy();
    }

    public int getIngredientCount(int index) {
        if (index >= 0 && index < recipeItems.size()) {
            Ingredient ingredient = recipeItems.get(index);
            ItemStack[] matchingStacks = ingredient.getItems();
            if (matchingStacks.length > 0) {
                return matchingStacks[0].getCount();
            }
        }
        return 1; // Default count is 1 if index is out of range or no matching stacks found
    }

    public NonNullList<Ingredient> getRecipeItems() {
        return recipeItems;
    }
}
