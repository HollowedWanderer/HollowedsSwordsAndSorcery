package net.hollowed.hss.common.gui;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.awt.*;

public class AlloyForgeScreen extends AbstractContainerScreen<AlloyForgeMenu> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/gui/alloy_forge.png");

    public AlloyForgeScreen(AlloyForgeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float tick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        graphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        renderProgress(graphics, x+80, y+35);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, delta);
        renderTooltip(graphics, mouseX, mouseY);
    }

    private void renderProgress(GuiGraphics graphics, int x, int y) {
        int progress = menu.getScaledProgress();
        graphics.blit(TEXTURE, x, y, 176, 14, progress, 17);
    }
}
