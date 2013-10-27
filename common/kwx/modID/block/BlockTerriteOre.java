package kwx.modID.block;

import kwx.modID.ModMain;
import kwx.modID.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

public class BlockTerriteOre extends Block {

	public BlockTerriteOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(ModMain.kwxCreativeTab);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		MinecraftForge.setBlockHarvestLevel(AddedBlocks.TerriteOre, "pickaxe", 2);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
    }

}
