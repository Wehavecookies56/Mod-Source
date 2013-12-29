package kwx.tek.item;

import cpw.mods.fml.common.registry.GameRegistry;
import kwx.tek.item.ingots.ItemAluminiumIngot;
import kwx.tek.item.ingots.ItemCopperIngot;
import kwx.tek.item.ingots.ItemPlatinumIngot;
import kwx.tek.item.ingots.ItemSteelIngot;
import kwx.tek.item.ingots.ItemTinIngot;
import kwx.tek.item.ingots.ItemTitaniumIngot;
import kwx.tek.item.otherItems.ItemResin;
import kwx.tek.lib.IDs;
import kwx.tek.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class AddedItems {
	
	//Ingots
	public static Item ingotCopper;
	public static Item ingotTin;
	public static Item ingotAluminium;
	public static Item ingotTitanium;
	public static Item ingotPlatinum;
	public static Item ingotSteel;
	public static Item resin;
	
	public static void initItems(){
		
		//Ingots
		ingotCopper = new ItemCopperIngot(IDs.ingotCopper).setUnlocalizedName(Strings.ingotCopper);
		ingotTin = new ItemTinIngot(IDs.ingotTin).setUnlocalizedName(Strings.ingotTin);
		ingotAluminium = new ItemAluminiumIngot(IDs.ingotAluminium).setUnlocalizedName(Strings.ingotAluminium);
		ingotTitanium = new ItemTitaniumIngot(IDs.ingotTitanium).setUnlocalizedName(Strings.ingotTitanium);
		ingotPlatinum = new ItemPlatinumIngot(IDs.ingotPlatinum).setUnlocalizedName(Strings.ingotPlatinum);
		ingotSteel = new ItemSteelIngot(IDs.ingotSteel).setUnlocalizedName(Strings.ingotSteel);
		
		//Rubber tree
		resin = new ItemResin(IDs.itemResin).setUnlocalizedName(Strings.itemResin);
	}
}
