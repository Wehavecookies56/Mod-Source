package kwx.modID.block;

import java.util.Random;

import kwx.modID.ModMain;
import kwx.modID.item.AddedItems;
import kwx.modID.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import kwx.modID.creativeTab.kwxCreativeTab;

public class BlockThermiteOre extends Block {

	public BlockThermiteOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(ModMain.kwxCreativeTab);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setLightValue(0.3F);
		MinecraftForge.setBlockHarvestLevel(AddedBlocks.ThermiteOre, "pickaxe", 2);
	}
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return AddedItems.ThermiteItem.itemID;
    }
    
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
    }

}
