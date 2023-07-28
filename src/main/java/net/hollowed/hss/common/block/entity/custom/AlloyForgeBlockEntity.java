package net.hollowed.hss.common.block.entity.custom;

import net.hollowed.hss.common.block.entity.ModBlockEntities;
import net.hollowed.hss.common.gui.AlloyForgeMenu;
import net.hollowed.hss.common.recipe.AlloyForgeRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;

public class AlloyForgeBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(5) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    public ItemStack craftingItem = ItemStack.EMPTY;
    private int progress = 0;
    private int maxProgress = 100;
    protected final ContainerData data;

    public LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public AlloyForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALLOY_FORGE.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> AlloyForgeBlockEntity.this.progress;
                    case 1 -> AlloyForgeBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> AlloyForgeBlockEntity.this.progress = value;
                    case 1 -> AlloyForgeBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }





    public static void tick(Level level, BlockPos pos, BlockState state, AlloyForgeBlockEntity entity) {
        if (level.isClientSide()) {
            return;
        }

        if (hasRecipe(entity)) {
            entity.progress++;
            setChanged(level, pos, state);

            if (entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    public boolean canCraft() {
        ItemStack stack = itemHandler.getStackInSlot(4);
        int count = stack.getCount();
        boolean same = stack.getItem() == craftingItem.getItem();
        boolean fits = count + craftingItem.getCount() <= craftingItem.getMaxStackSize();
        return stack.isEmpty() || (same && fits);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hss.alloy_forge");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new AlloyForgeMenu(containerId, inventory, this, this.data);
    }

    private static boolean hasRecipe(AlloyForgeBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<AlloyForgeRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(AlloyForgeRecipe.Type.INSTANCE, inventory, level);

        if (recipe.isPresent()) {
            AlloyForgeRecipe alloyForgeRecipe = recipe.get();
            int count0 = alloyForgeRecipe.getIngredientCount(0);
            int count1 = alloyForgeRecipe.getIngredientCount(1);
            return count0 <= inventory.getItem(0).getCount() && count1 <= inventory.getItem(1).getCount() &&
                    canInsertAmountIntoOutputSlot(inventory) &&
                    canInsertItemIntoOutputSlot(inventory, alloyForgeRecipe.getResultItem());
        }

        return false;
    }

    private static void craftItem(AlloyForgeBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<AlloyForgeRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(AlloyForgeRecipe.Type.INSTANCE, inventory, level);

        if (hasRecipe(entity)) {
            AlloyForgeRecipe alloyForgeRecipe = recipe.get();
            int count0 = alloyForgeRecipe.getIngredientCount(0);
            int count1 = alloyForgeRecipe.getIngredientCount(1);
            ItemStack ingredient0 = entity.itemHandler.extractItem(0, count0, false); // Consume ingredient in slot 0
            ItemStack ingredient1 = entity.itemHandler.extractItem(1, count1, false); // Consume ingredient in slot 1
            ItemStack fuel = entity.itemHandler.extractItem(2, 1, false); // Consume fuel in slot 2

            // Adjust output count based on recipe count
            ItemStack outputStack = alloyForgeRecipe.getResultItem().copy();
            int outputCount = alloyForgeRecipe.getResultItem().getCount();
            outputStack.setCount(outputCount); // Set the correct count

            entity.itemHandler.insertItem(3, outputStack, false); // Add output to slot 3

            entity.resetProgress();
        }
    }




    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(3).getItem() == stack.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }

    public void remove() {
        SimpleContainer container = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) container.setItem(i, itemHandler.getStackInSlot(i));
        assert level != null;
        Containers.dropContents(level, getBlockPos(), container);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("alloy_forge.progress");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("alloy_forge.progress", this.progress);

        super.saveAdditional(tag);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }
}
