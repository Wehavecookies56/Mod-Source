package kwx.tek.creativeTab;


import kwx.tek.block.AddedBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class kwxCreativeTab extends CreativeTabs {

	public kwxCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
		
	}

	   @SideOnly(Side.CLIENT)

	    /**
	     * the itemID for the item to be displayed on the tab
	     */
	    public int getTabIconItemIndex()
	    {
		   // The item shown on tab
	        return AddedBlocks.copperOre.blockID;
	    }
	   
	   public String getTranslatedTabLabel(){
		   // Name shown when hovered over
		   return "Tek";
	   }
	
}
