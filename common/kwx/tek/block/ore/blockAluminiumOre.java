package kwx.tek.block.ore;

import java.util.Random;

import kwx.tek.ModMain;
import kwx.tek.block.AddedBlocks;
import kwx.tek.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

public class blockAluminiumOre extends Block {

	public blockAluminiumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(ModMain.kwxCreativeTab);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
	}
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return AddedBlocks.aluminiumOre.blockID;
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
    }

}
