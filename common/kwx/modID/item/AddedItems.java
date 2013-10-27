package kwx.modID.item;

import cpw.mods.fml.common.registry.GameRegistry;
import kwx.modID.lib.IDs;
import kwx.modID.lib.Strings;
import net.minecraft.item.Item;

public class AddedItems {
	
	public static Item ThermiteItem;
	public static Item AetheriumItem;
	public static Item AeriteItem;
	public static Item MagnetiteIngot;
	public static Item SunnariumIngot;
	public static Item LunnariumIngot;
	public static Item TerriteIngot;
	public static Item MagnetiteMass;
	public static Item TerriteMass;
	public static Item LunnariumMass;
	public static Item SunnariumMass;
	public static Item SilkWorm;
	public static Item MullberryLeaves;
	public static Item Silk;
	
	public static void initItems(){
		
		ThermiteItem = new ItemThermite(IDs.thermiteItem).setUnlocalizedName(Strings.thermiteItem);
		AetheriumItem = new ItemAetherium(IDs.aetheriumItem).setUnlocalizedName(Strings.aetheriumItem);
		AeriteItem = new ItemAerite(IDs.aeriteItem).setUnlocalizedName(Strings.aeriteItem);
		MagnetiteIngot = new ItemMagnetiteIngot(IDs.magnetiteIngot).setUnlocalizedName(Strings.magnetiteIngot);
		SunnariumIngot = new ItemSunnariumIngot(IDs.sunnariumIngot).setUnlocalizedName(Strings.sunnariumIngot);
		LunnariumIngot = new ItemLunnariumIngot(IDs.lunnariumIngot).setUnlocalizedName(Strings.lunariumIngot);
		TerriteIngot  = new ItemTerriteIngot(IDs.territeIngot).setUnlocalizedName(Strings.territeIngot);
		
		MagnetiteMass = new ItemMagnetiteMass(IDs.magnetiteMass).setUnlocalizedName(Strings.magnetiteMass);
		TerriteMass = new ItemTerriteMass(IDs.territeMass).setUnlocalizedName(Strings.territeMass);
		LunnariumMass = new ItemLunnariumMass(IDs.lunnariumMass).setUnlocalizedName(Strings.lunnariumMass);
		SunnariumMass = new ItemSunnariumMass(IDs.sunnariumMass).setUnlocalizedName(Strings.sunnariumMass);
		
		SilkWorm = new ItemSilkWorm(IDs.silkWorm).setUnlocalizedName(Strings.silkWorm);
		
		Silk = new ItemSilk(IDs.silk).setUnlocalizedName(Strings.silk);
		
		MullberryLeaves = new ItemMullberryLeaves(IDs.mullberryLeaves).setUnlocalizedName(Strings.mullberryLeaves);
	}
}
