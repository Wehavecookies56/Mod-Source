package kwx.tek.item.ingots;

import kwx.tek.lib.Reference;
import kwx.tek.TekMain;
import kwx.tek.item.ItemMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAluminiumIngot extends ItemMain {

	public ItemAluminiumIngot(int id) {
		super(id);
		this.setCreativeTab(TekMain.kwxCreativeTab);
	}

	public void registerIcons(IconRegister par1IconRegister) {
        itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
        }
}
