package kwx.modID.TileEntity;

import kwx.modID.block.BlockSmasher;
import kwx.modID.item.AddedItems;
import kwx.modID.recipes.SmasherRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeDummyContainer;

public class TileEntitySmasher extends TileEntity implements ISidedInventory
{

private ItemStack[] furnaceItemStacks = new ItemStack[3];
public int furnaceBurnTime;
private String customName;
public int currentItemBurnTime;
public int furnaceCookTime;
/**
         * Returns the number of slots in the inventory.
         */
public int getSizeInventory()
{
         return this.furnaceItemStacks.length;
}
/**
         * Returns the stack in slot i
         */
public ItemStack getStackInSlot(int par1)
{
         return this.furnaceItemStacks[par1];
}
/**
         * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
         * new stack.
         */
public ItemStack decrStackSize(int par1, int par2)
{
         if (this.furnaceItemStacks[par1] != null)
         {
                 ItemStack itemstack;
                 if (this.furnaceItemStacks[par1].stackSize <= par2)
                 {
                         itemstack = this.furnaceItemStacks[par1];
                         this.furnaceItemStacks[par1] = null;
                         return itemstack;
                 }
                 else
                 {
                         itemstack = this.furnaceItemStacks[par1].splitStack(par2);
                         if (this.furnaceItemStacks[par1].stackSize == 0)
                         {
                                 this.furnaceItemStacks[par1] = null;
                         }
                         return itemstack;
                 }
         }
         else
         {
                 return null;
         }
}
/**
         * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
         * like when you close a workbench GUI.
         */
public ItemStack getStackInSlotOnClosing(int par1)
{
         if (this.furnaceItemStacks[par1] != null)
         {
                 ItemStack itemstack = this.furnaceItemStacks[par1];
                 this.furnaceItemStacks[par1] = null;
                 return itemstack;
         }
         else
         {
                 return null;
         }
}
/**
         * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
         */
public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
{
         this.furnaceItemStacks[par1] = par2ItemStack;
         if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
         {
                 par2ItemStack.stackSize = this.getInventoryStackLimit();
         }
}
/**
         * Returns the name of the inventory.
         */
public String getInvName()
{
         return this.isInvNameLocalized1() ? this.customName : "container.furnace";
}
/**
         * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
         * language. Otherwise it will be used directly.
         */
public boolean isInvNameLocalized1()
{
         return "container.smasher" != null;
}

/**
         * Reads a tile entity from NBT.
         */
public void readFromNBT(NBTTagCompound par1NBTTagCompound)
        {
                super.readFromNBT(par1NBTTagCompound);
                NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
                this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

                for (int var3 = 0; var3 < var2.tagCount(); ++var3)
                {
                        NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
                        byte var5 = var4.getByte("Slot");

                        if (var5 >= 0 && var5 < this.furnaceItemStacks.length)
                        {
                                this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
                        }
                }

                this.furnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
                this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
                this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
        
}
/**
         * Writes a tile entity to NBT.
         */
public void writeToNBT(NBTTagCompound par1NBTTagCompound)
        {
                super.writeToNBT(par1NBTTagCompound);
                par1NBTTagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
                par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
                NBTTagList var2 = new NBTTagList();

                for (int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3)
                {
                        if (this.furnaceItemStacks[var3] != null)
                        {
                                NBTTagCompound var4 = new NBTTagCompound();
                                var4.setByte("Slot", (byte)var3);
                                this.furnaceItemStacks[var3].writeToNBT(var4);
                                var2.appendTag(var4);
                        }
                }

                par1NBTTagCompound.setTag("Items", var2);
        }
/**
         * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
         * this more of a set than a get?*
         */
public int getInventoryStackLimit()
{
         return 64;
}
@SideOnly(Side.CLIENT)
/**
         * Returns an integer between 0 and the passed value representing how close the current item is to being completely
         * cooked
         */
public int getCookProgressScaled(int par1)
{
         return this.furnaceCookTime * par1 / 200;
}
@SideOnly(Side.CLIENT)
/**
         * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
         * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
         */
public int getBurnTimeRemainingScaled(int par1)
{
         if (this.currentItemBurnTime == 0)
         {
                 this.currentItemBurnTime = 200;
         }
         return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
}
/**
         * Returns true if the furnace is currently burning
         */
public boolean isBurning()
{
         return this.furnaceBurnTime > 0;
}
/**
         * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
         * ticks and creates a new spawn inside its implementation.
         */
public void updateEntity()
{
         boolean flag = this.furnaceBurnTime > 0;
         boolean flag1 = false;
         if (this.furnaceBurnTime > 0)
         {
                 --this.furnaceBurnTime;
         }
         if (!this.worldObj.isRemote)
         {
                 if (this.furnaceBurnTime == 0 && this.canSmelt())
                 {
                         this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
                         if (this.furnaceBurnTime > 0)
                         {
                                 flag1 = true;
                                 if (this.furnaceItemStacks[1] != null)
                                 {
                                         --this.furnaceItemStacks[1].stackSize;
                                         if (this.furnaceItemStacks[1].stackSize == 0)
                                         {
                                                 this.furnaceItemStacks[1] = this.furnaceItemStacks[1].getItem().getContainerItemStack(furnaceItemStacks[1]);
                                         }
                                 }
                         }
                 }
                 if (this.isBurning() && this.canSmelt())
                 {
                         ++this.furnaceCookTime;
                         if (this.furnaceCookTime == 200)
                         {
                                 this.furnaceCookTime = 0;
                                 this.smeltItem();
                                 flag1 = true;
                         }
                 }
                 else
                 {
                         this.furnaceCookTime = 0;
                 }
                 if (flag != this.furnaceBurnTime > 0)
                 {
                         flag1 = true;
                         BlockSmasher.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                 }
         }
         if (flag1)
         {
                 this.onInventoryChanged();
         }
}
/**
         * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
         */
private boolean canSmelt()
{
         if (this.furnaceItemStacks[0] == null)
         {
                 return false;
         }
         else
         {
                 ItemStack itemstack = SmasherRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
                 if (itemstack == null) return false;
                 if (this.furnaceItemStacks[2] == null) return true;
                 if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
                 int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
                 return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
         }
}
/**
         * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
         */
public void smeltItem()
{
         if (this.canSmelt())
         {
                 ItemStack itemstack = SmasherRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
                 if (this.furnaceItemStacks[2] == null)
                 {
                         this.furnaceItemStacks[2] = itemstack.copy();
                 }
                 else if (this.furnaceItemStacks[2].isItemEqual(itemstack))
                 {
                         furnaceItemStacks[2].stackSize += itemstack.stackSize;
                 }
                 --this.furnaceItemStacks[0].stackSize;
                 if (this.furnaceItemStacks[0].stackSize <= 0)
                 {
                         this.furnaceItemStacks[0] = null;
                 }
         }
}
/**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
public static int getItemBurnTime(ItemStack par0ItemStack)
{
         if (par0ItemStack == null)
         {
                 return 0;
         }
         else
         {
                 int i = par0ItemStack.getItem().itemID;
                 Item item = par0ItemStack.getItem();
                 
                 if (i == AddedItems.ThermiteItem.itemID) return 1500;
                 return GameRegistry.getFuelValue(par0ItemStack);
         }
}
/**
         * Return true if item is a fuel source (getItemBurnTime() > 0).
         */
public static boolean isItemFuel(ItemStack par0ItemStack)
{
         return getItemBurnTime(par0ItemStack) > 0;
}
/**
         * Do not make give this method the name canInteractWith because it clashes with Container
         */
public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
{
         return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
}
public void openChest() {}
public void closeChest() {}

        @Override
        public boolean isInvNameLocalized()
        {
                return (this.customName != null) && (this.customName.length() > 0);
        }

        public void setCustomName(String name)
        {
                this.customName = "container.smasher";
        }

        @Override
        public int[] getAccessibleSlotsFromSide(int var1) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public boolean canInsertItem(int i, ItemStack itemstack, int j) {
                // TODO Auto-generated method stub
                return false;
        }

        @Override
        public boolean canExtractItem(int i, ItemStack itemstack, int j) {
                // TODO Auto-generated method stub
                return false;
        }

        @Override
        public boolean isItemValidForSlot(int i, ItemStack itemstack) {
                return false;
        }
        
}