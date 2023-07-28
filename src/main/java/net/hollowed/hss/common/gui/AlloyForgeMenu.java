package net.hollowed.hss.common.gui;

import net.hollowed.hss.common.block.ModBlocks;
import net.hollowed.hss.common.block.entity.custom.AlloyForgeBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AlloyForgeMenu extends AbstractContainerMenu {
    public final AlloyForgeBlockEntity blockEntity;
    public final ContainerData data;

    public AlloyForgeMenu(int containerId, Inventory playerInventory, FriendlyByteBuf buf) {
        this(containerId, playerInventory, playerInventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(2));
    }

    public AlloyForgeMenu(int containerId, Inventory playerInventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.ALLOY_FORGE_MENU.get(), containerId);
        this.blockEntity = (AlloyForgeBlockEntity) entity;
        this.data = data;

        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);

        addDataSlots(data);

        blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            addSlot(new SlotItemHandler(handler, 0, 47, 17));
            addSlot(new SlotItemHandler(handler, 1, 65, 17));
            addSlot(new SlotItemHandler(handler, 2, 56, 53));
            addSlot(new SlotItemHandler(handler, 3, 116, 35) {
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false;
                }
            });
        });
    }

    private void addPlayerInventory(Inventory inventory) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                addSlot(new Slot(inventory, y*9+x+9, 8+x*18, 84+y*18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inventory) {
        for (int i = 0; i < 9; i++) {
            addSlot(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int slotIndex) {
        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = slots.get(slotIndex);

        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            originalStack = slotStack.copy();

            // Transfer from container to player inventory
            if (slotIndex < 4) {
                if (!this.moveItemStackTo(slotStack, 4, slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            // Transfer from player inventory to container
            else {
                if (!this.moveItemStackTo(slotStack, 0, 4, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotStack.getCount() == originalStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, slotStack);
        }

        return originalStack;
    }


    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(player.level(), blockEntity.getBlockPos()), player, ModBlocks.ALLOY_FORGE.get());
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = data.get(0);
        int maxProgress = data.get(1);
        return progress * 24 / Math.max(1, maxProgress);
    }
}
