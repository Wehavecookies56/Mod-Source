package kwx.tek.block;

import cpw.mods.fml.common.registry.GameRegistry;
import kwx.tek.TekMain;
import kwx.tek.block.ore.blockAluminiumOre;
import kwx.tek.block.ore.blockCopperOre;
import kwx.tek.block.ore.blockPlatinumOre;
import kwx.tek.block.ore.blockSiliconOre;
import kwx.tek.block.ore.blockTinOre;
import kwx.tek.block.ore.blockTitaniumOre;
import kwx.tek.block.ore.blockUraniumOre;
import kwx.tek.block.rubberTree.blockRubberLeaves;
import kwx.tek.block.rubberTree.blockRubberLog;
import kwx.tek.block.rubberTree.blockRubberSapling;
import kwx.tek.lib.IDs;
import kwx.tek.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AddedBlocks {
	
	//Ores
	
	public static Block copperOre;
	public static Block tinOre;
	public static Block aluminiumOre;
	public static Block siliconOre;
	public static Block uraniumOre;
	public static Block titaniumOre;
	public static Block platinumOre;
	
	//Rubber tree
	
	public static Block rubberLog;
	public static Block rubberLeaves;
	public static Block rubberSapling;
	
	public static void initBlocks(){
		
		//Ores
		
		copperOre = new blockCopperOre(IDs.copperOre, Material.rock).setUnlocalizedName(Strings.copperOre); GameRegistry.registerBlock(copperOre, Strings.copperOre);
		tinOre = new blockTinOre(IDs.tinOre, Material.rock).setUnlocalizedName(Strings.tinOre); GameRegistry.registerBlock(tinOre, Strings.tinOre);
		aluminiumOre = new blockAluminiumOre(IDs.aluminiumOre, Material.rock).setUnlocalizedName(Strings.aluminiumOre); GameRegistry.registerBlock(aluminiumOre, Strings.aluminiumOre);
		siliconOre = new blockSiliconOre(IDs.siliconOre, Material.rock).setUnlocalizedName(Strings.siliconOre); GameRegistry.registerBlock(siliconOre, Strings.siliconOre);
		uraniumOre = new blockUraniumOre(IDs.uraniumOre, Material.rock).setUnlocalizedName(Strings.uraniumOre); GameRegistry.registerBlock(uraniumOre, Strings.uraniumOre);
		titaniumOre = new blockTitaniumOre(IDs.titaniumOre, Material.rock).setUnlocalizedName(Strings.titaniumOre); GameRegistry.registerBlock(titaniumOre, Strings.titaniumOre);
		platinumOre = new blockPlatinumOre(IDs.platinumOre, Material.rock).setUnlocalizedName(Strings.platinumOre); GameRegistry.registerBlock(platinumOre, Strings.platinumOre);
		
		//Rubber tree
		
		rubberLog = new blockRubberLog(IDs.rubberLog).setUnlocalizedName(Strings.rubberLog); GameRegistry.registerBlock(rubberLog, Strings.rubberLog);
		//rubberLeaves = new blockRubberLeaves(IDs.rubberLeaves).setUnlocalizedName(Strings.rubberLeaves); GameRegistry.registerBlock(rubberLeaves, Strings.rubberLeaves);
		//rubberSapling = new blockRubberSapling(IDs.rubberSapling).setUnlocalizedName(Strings.rubberSapling); GameRegistry.registerBlock(rubberSapling, Strings.rubberSapling);
		
	}
}