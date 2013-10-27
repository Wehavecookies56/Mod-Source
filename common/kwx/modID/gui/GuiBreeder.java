package kwx.modID.gui;

import kwx.modID.TileEntity.TileEntityBreeder;
import kwx.modID.container.ContainerBreeder;
import kwx.modID.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiBreeder extends GuiContainer
{
private ResourceLocation tif = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/gui/breeder.png");
private TileEntityBreeder breederInventory;

public GuiBreeder(InventoryPlayer inventoryplayer, TileEntityBreeder tileentityBreeder)
{
         super(new ContainerBreeder(inventoryplayer, tileentityBreeder));
         breederInventory = tileentityBreeder;
}
/**
         * Draw the foreground layer for the GuiContainer (everythin in front of the items)
         */
protected void drawGuiContainerForegroundLayer(int par1, int par2)
{
         fontRenderer.drawString(StatCollector.translateToLocal("Silk Worm Breeder"), 40, 6, 0x404040);
         fontRenderer.drawString(StatCollector.translateToLocal("Inventory"), 8, (ySize - 96) + 2, 0x404040);
}
/**
         * Draw the background layer for the GuiContainer (everything behind the items)
         */
protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
{
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         mc.renderEngine.bindTexture(tif);
         int l = (width - xSize) / 2;
         int i1 = (height - ySize) / 2;
         drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
         if (breederInventory.isBurning())
         {
                 int j1 = breederInventory.getBurnTimeRemainingScaled(12);
                 drawTexturedModalRect(l + 56, (i1 + 36 + 12) - j1, 176, 12 - j1, 14, j1 + 2);
         }
         int k1 = breederInventory.getCookProgressScaled(24);
         drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);
}
}