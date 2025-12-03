package izzyn.aartifice.screens;

import izzyn.aartifice.AdvancedArtificing;
import izzyn.aartifice.menus.CreativeManaSourceMenu;
import izzyn.aartifice.screens.widgets.ScrollWidget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.BeaconScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerListener;
import net.minecraft.world.item.ItemStack;

public class CreativeManaSourceScreen extends AbstractContainerScreen<CreativeManaSourceMenu> {
    int Potence;
    double Purity;
    double Pull;

    int xOffset;
    int yOffset;

    ScrollWidget scrollPotence;
    ScrollWidget scrollPurity;
    ScrollWidget scrollPull;
    public static final ResourceLocation BACKGROUND = AdvancedArtificing.identifier("textures/gui/container/creative_mana_source.png");
    public CreativeManaSourceScreen(CreativeManaSourceMenu sourceMenu, Inventory inventory, Component component) {
        super(sourceMenu, inventory, component);
        sourceMenu.addSlotListener(new ContainerListener() {
            public void slotChanged(AbstractContainerMenu abstractContainerMenu, int i, ItemStack itemStack) {
            }

            public void dataChanged(AbstractContainerMenu abstractContainerMenu, int i, int j) {
                CreativeManaSourceScreen.this.Potence = sourceMenu.getPotency();
                CreativeManaSourceScreen.this.Purity = sourceMenu.getPurity();
                CreativeManaSourceScreen.this.Pull = sourceMenu.getPull();

            }
        });
        this.Potence = sourceMenu.getPotency();
        this.Purity = sourceMenu.getPurity();
        this.Pull = sourceMenu.getPull();
    }

    @Override
    protected void init(){
        xOffset = (this.width - 256)/2;
        yOffset = (this.height - 128)/2;
        int x = xOffset+5;
        int y = yOffset+20;
        scrollPotence = new ScrollWidget(x,y,100,20, Component.empty(), ((float)(this.menu.getPotency()))/100, v -> this.menu.setPotency((int)(100*v)));
        scrollPurity = new ScrollWidget(x,y+30,100,20, Component.empty(), Purity, v -> Purity=v);
        scrollPull = new ScrollWidget(x,y+60,100,20, Component.empty(), Pull, v-> Pull=v);
        addRenderableWidget(scrollPotence);
        addRenderableWidget(scrollPurity);
        addRenderableWidget(scrollPull);
        this.titleLabelY += 999999;
        this.inventoryLabelY += 999999;
        super.init();
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int mouseX, int mouseY) {
        int i = (this.width - 256)/2;
        int j = (this.height - 128)/2;
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, xOffset, yOffset, 0, 0, 256, 128, 256,128);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    public void resize(Minecraft minecraft, int width, int height) {
        super.resize(minecraft, width, height);
        this.init(); // reposition labels
    }

    @Override
    public void render(GuiGraphics context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        // Minecraft doesn't have a "label" widget, so we'll have to draw our own text.
        // We'll subtract the font height from the Y position to make the text appear above the button.
        // Subtracting an extra 10 pixels will give the text some padding.
        // textRenderer, text, x, y, color, hasShadow
        context.drawString(this.font, String.format("Potency %d", this.menu.getPotency()), xOffset + 5, yOffset + 20 - this.font.lineHeight, 0xFFFFFFFF, true);
        context.drawString(this.font, "Purity", xOffset + 5, yOffset + 30 + 20 - this.font.lineHeight, 0xFFFFFFFF, true);
        context.drawString(this.font, "Pull", xOffset + 5, yOffset + 60 + 20 - this.font.lineHeight, 0xFFFFFFFF, true);
    }

}