package kwx.modID.creativeTab;


import kwx.modID.block.AddedBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class kwxCreativeTab extends CreativeTabs {

	public kwxCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
		// TODO Auto-generated constructor stub
	}

	   @SideOnly(Side.CLIENT)

	    /**
	     * the itemID for the item to be displayed on the tab
	     */
	    public int getTabIconItemIndex()
	    {
		   // The item shown on tab
	        return AddedBlocks.MagnetiteOre.blockID;
	    }
	   
	   public String getTranslatedTabLabel(){
		   // Name shown when hovered over
		   return "modID";
	   }
	
}
