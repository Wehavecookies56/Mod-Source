package kwx.modID.item;

import kwx.modID.ModMain;
import kwx.modID.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMagnetiteIngot extends ItemMain {

	public ItemMagnetiteIngot(int id) {
		super(id);
		this.setCreativeTab(ModMain.kwxCreativeTab);
	}

	public void registerIcons(IconRegister par1IconRegister) {
        itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
        }
}
