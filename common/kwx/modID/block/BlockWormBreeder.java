package kwx.modID.block;

import java.util.Random;

import kwx.modID.ModMain;

import kwx.modID.TileEntity.TileEntityBreeder;
import kwx.modID.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockWormBreeder extends BlockContainer
{
private Random furnaceRand = new Random();
private final boolean isActive;
private static boolean keepFurnaceInventory = false;
@SideOnly(Side.CLIENT)
private Icon breederIconTop;
@SideOnly(Side.CLIENT)
private Icon breederIconFront;
@SideOnly(Side.CLIENT)
private Icon breederIconSides;
@SideOnly(Side.CLIENT)
private Icon breederIconBottom;

public BlockWormBreeder(int par1, boolean par2)
{
         super(par1, Material.rock);
         this.isActive = par2;
}

/**
         * Returns the ID of the items to drop on destruction.
         */
public int idDropped(int par1, Random par2Random, int par3)
{
         return AddedBlocks.WormBreeder.blockID;
}
/**
         * Called whenever the block is added into the world. Args: world, x, y, z
         */
@Override
public void onBlockAdded(World world, int x, int y, int z) {
	super.onBlockAdded(world, x, y, z);
	setDefaultDirection(world, x, y, z);
}
/**
         * set a blocks direction
         */
private void setDefaultDirection(World world, int x, int y, int z) {
	if(!world.isRemote) {
		int zNeg = world.getBlockId(x, y, z - 1);
		int zPos = world.getBlockId(x, y, z + 1);
		int xNeg = world.getBlockId(x - 1, y, z);
		int xPos = world.getBlockId(x + 1, y, z);
		byte meta = 3;

		if(Block.opaqueCubeLookup[xNeg] && !Block.opaqueCubeLookup[xPos]) {
			meta = 5;
		}

		if(Block.opaqueCubeLookup[xPos] && !Block.opaqueCubeLookup[xNeg]) {
			meta = 4;
		}

		if(Block.opaqueCubeLookup[zNeg] && !Block.opaqueCubeLookup[zPos]) {
			meta = 3;
		}

		if(Block.opaqueCubeLookup[zPos] && !Block.opaqueCubeLookup[zNeg]) {
			meta = 2;
		}

		world.setBlockMetadataWithNotify(x, y, z, meta, 2);
	}
}
@SideOnly(Side.CLIENT)
/**
         * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
         */
@Override
public Icon getIcon(int side, int meta) {
	if(side == 1) {
		return this.breederIconTop;
	} else if(side == 0){
		return this.breederIconBottom;
	}else if(side != meta) {
		return breederIconSides;
	} else {
		return breederIconFront;
	}
}
@SideOnly(Side.CLIENT)
/**
         * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
         */
public void registerIcons(IconRegister par1IconRegister)
{
         this.breederIconFront = par1IconRegister.registerIcon(this.isActive ? Reference.MOD_ID + ":wormBreederFrontActive" : Reference.MOD_ID +":wormBreederFrontInactive");
         this.breederIconBottom = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + "wormBreederTop");
         this.breederIconSides = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + "wormBreederSide");
         this.breederIconBottom = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + "wormBreederBottom");
}
@SideOnly(Side.CLIENT)
/**
         * A randomly called display update to be able to add particles or other items for display
         */
public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
{
         if (this.isActive)
         {
                 int var6 = par1World.getBlockMetadata(par2, par3, par4);
                 float var7 = (float)par2 + 0.5F;
                 float var8 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
                 float var9 = (float)par4 + 0.5F;
                 float var10 = 0.52F;
                 float var11 = par5Random.nextFloat() * 0.6F - 0.3F;
                 if (var6 == 4)
                 {
                         par1World.spawnParticle("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                         par1World.spawnParticle("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                 }
                 else if (var6 == 5)
                 {
                         par1World.spawnParticle("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                         par1World.spawnParticle("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                 }
                 else if (var6 == 2)
                 {
                         par1World.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
                         par1World.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
                 }
                 else if (var6 == 3)
                 {
                         par1World.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
                         par1World.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
                 }
         }
}
/**
         * Called upon block activation (right click on the block.)
         */
//Pay close attention here as this is where the magic is in the block class. If this is incorrect, your furnace will not open its GUI
public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
{
         if (par1World.isRemote)
{
return true;
}
else if (!par5EntityPlayer.isSneaking())
{
TileEntityBreeder var10 = (TileEntityBreeder) par1World.getBlockTileEntity(par2, par3, par4);
if (var10 != null)
{
//Remember in the mod class where I mentioned without the @Instance your furnace will send an error to the console about the network mod....Your @instance is necessary for thi here and the GUI handler
par5EntityPlayer.openGui(ModMain.instance, 1, par1World, par2, par3, par4);
}
return true;
}
else
{
return false;
}
}
/**
         * Update which block ID the furnace is using depending on whether or not it is burning
         */
public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
{
         int var5 = par1World.getBlockMetadata(par2, par3, par4);
         TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
         keepFurnaceInventory = true;
         if (par0)
         {
                 par1World.setBlock(par2, par3, par4, AddedBlocks.WormBreederActive.blockID);
         }
         else
         {
                 par1World.setBlock(par2, par3, par4, AddedBlocks.WormBreeder.blockID);
         }
         keepFurnaceInventory = false;
         par1World.setBlockMetadataWithNotify(par2, par3, par4, var5, 2);

         if (var6 != null)
         {
                 var6.validate();
                 par1World.setBlockTileEntity(par2, par3, par4, var6);
         }
}
/**
         * Returns a new instance of a block&#39;s tile entity class. Called on placing the block.
         */
public TileEntity createNewTileEntity(World par1World)
{
         return new TileEntityBreeder();
}
/**
         * Called when the block is placed in the world.
         */
@Override
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
	int rotation = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360F) + 0.5D) & 3;

	if(rotation == 0) {
		world.setBlockMetadataWithNotify(x, y, z, 2, 2);
	}

	if(rotation == 1) {
		world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	}

	if(rotation == 2) {
		world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	}

	if(rotation == 3) {
		world.setBlockMetadataWithNotify(x, y, z, 4, 2);
	}
}
/**
         * ejects contained items into the world, and notifies neighbours of an update, as appropriate
         */
public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
{
         if (!keepFurnaceInventory)
         {
                 TileEntityBreeder var7 = (TileEntityBreeder)par1World.getBlockTileEntity(par2, par3, par4);
                 if (var7 != null)
                 {
                         for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
                         {
                                 ItemStack itemstack = var7.getStackInSlot(var8);
                                 if (itemstack != null)
                                 {
                                         float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                                         float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                                         float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                                         while (itemstack.stackSize > 0)
                                         {
                                                 int k1 = this.furnaceRand.nextInt(21) + 10;
                                                 if (k1 > itemstack.stackSize)
                                                 {
                                                         k1 = itemstack.stackSize;
                                                 }
                                                 itemstack.stackSize -= k1;
                                                 EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));
                                                 if (itemstack.hasTagCompound())
                                                 {
                                                         entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                                                 }
                                                 float f3 = 0.05F;
                                                 entityitem.motionX = (double)((float)this.furnaceRand.nextGaussian() * f3);
                                                 entityitem.motionY = (double)((float)this.furnaceRand.nextGaussian() * f3 + 0.2F);
                                                 entityitem.motionZ = (double)((float)this.furnaceRand.nextGaussian() * f3);
                                                 par1World.spawnEntityInWorld(entityitem);
                                         }
                                 }
                         }
                         par1World.func_96440_m(par2, par3, par4, par5);
                 }
         }
         super.breakBlock(par1World, par2, par3, par4, par5, par6);
}

public boolean hasComparatorInputOverride()
{
         return true;
}
public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
{
         return Container.calcRedstoneFromInventory((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
}

}