package kwx.tek.lib;

import kwx.tek.block.AddedBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class oreDict {

	public void registerOres(){
		
		OreDictionary.registerOre("oreCopper", AddedBlocks.copperOre);
		OreDictionary.registerOre("oreTin", AddedBlocks.tinOre);
		OreDictionary.registerOre("oreAluminium", AddedBlocks.aluminiumOre);
		OreDictionary.registerOre("oreSilicon", AddedBlocks.siliconOre);
		OreDictionary.registerOre("oreUranium", AddedBlocks.uraniumOre);
		OreDictionary.registerOre("oreTitanium", AddedBlocks.titaniumOre);
		OreDictionary.registerOre("orePlatinum", AddedBlocks.platinumOre);
		
	}
}
