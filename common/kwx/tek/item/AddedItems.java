package kwx.tek.item;

import cpw.mods.fml.common.registry.GameRegistry;
import kwx.tek.item.ingots.ItemCopperIngot;
import kwx.tek.item.ingots.ItemTinIngot;
import kwx.tek.lib.IDs;
import kwx.tek.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class AddedItems {
	
	//Ingots
	public static Item ingotCopper;
	public static Item ingotTin;
	
	public static void initItems(){
		
		//Ingots
		ingotCopper = new ItemCopperIngot(IDs.ingotCopper).setUnlocalizedName(Strings.ingotCopper);
		ingotTin = new ItemTinIngot(IDs.ingotTin).setUnlocalizedName(Strings.ingotTin);
		
	}
}
