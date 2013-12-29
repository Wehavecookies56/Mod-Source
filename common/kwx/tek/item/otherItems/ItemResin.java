package kwx.tek.item.otherItems;

import kwx.tek.lib.Reference;
import kwx.tek.TekMain;
import kwx.tek.item.ItemMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemResin extends ItemMain {

	public ItemResin(int id) {
		super(id);
		this.setCreativeTab(TekMain.kwxCreativeTab);
	}

	public void registerIcons(IconRegister par1IconRegister) {
        	itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
        }
}
