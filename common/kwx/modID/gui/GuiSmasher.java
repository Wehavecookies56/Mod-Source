package kwx.modID.gui;

import kwx.modID.TileEntity.TileEntitySmasher;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import kwx.modID.container.*;
import kwx.modID.lib.Reference;

public class GuiSmasher extends GuiContainer
{
private ResourceLocation yf = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/gui/smasher.png");
private TileEntitySmasher furnaceInventory;

public GuiSmasher(InventoryPlayer par1InventoryPlayer, TileEntitySmasher par2TileEntitySmasher)
{
         super(new ContainerSmasher(par1InventoryPlayer, par2TileEntitySmasher));
         this.furnaceInventory = par2TileEntitySmasher;
}
/**
         * Draw the foreground layer for the GuiContainer (everything in front of the items)
         */
protected void drawGuiContainerForegroundLayer(int par1, int par2)
{
         this.fontRenderer.drawString(StatCollector.translateToLocal("Smasher"), 40, 6, 4210752);
         this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
}
/**
         * Draw the background layer for the GuiContainer (everything behind the items)
         */
protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
{
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         mc.renderEngine.bindTexture(yf);
         int var5 = (this.width - this.xSize) / 2;
         int var6 = (this.height - this.ySize) / 2;
         this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
         int var7;
         if (this.furnaceInventory.isBurning())
         {
                 var7 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
                 this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
         }
         var7 = this.furnaceInventory.getCookProgressScaled(24);
         this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
}
}