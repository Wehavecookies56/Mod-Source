package kwx.modID.block;

import cpw.mods.fml.common.registry.GameRegistry;
import kwx.modID.ModMain;
import kwx.modID.lib.IDs;
import kwx.modID.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AddedBlocks {

	public static Block MagnetiteOre;
	public static Block SunnariumOre;
	public static Block LunariumOre;
	public static Block ThermiteOre;
	public static Block TerriteOre;
	public static Block AetheriumOre;
	public static Block AeriteOre;
	public static Block Smasher;
	public static Block SmasherActive;
	public static Block WormBreeder;
	public static Block WormBreederActive;
	
	public static void initBlocks(){
		
	MagnetiteOre = new BlockMagnetiteOre(IDs.magnetiteOre, Material.rock).setUnlocalizedName(Strings.magnetiteOre); GameRegistry.registerBlock(MagnetiteOre, Strings.magnetiteOre);
	SunnariumOre = new BlockSunnariumOre(IDs.sunnariumOre, Material.rock).setUnlocalizedName(Strings.sunnariumOre); GameRegistry.registerBlock(SunnariumOre, Strings.sunnariumOre);
	LunariumOre = new BlockLunariumOre(IDs.lunariumOre, Material.rock).setUnlocalizedName(Strings.lunariumOre); GameRegistry.registerBlock(LunariumOre, Strings.lunariumOre);
	ThermiteOre = new BlockThermiteOre(IDs.thermiteOre, Material.rock).setUnlocalizedName(Strings.thermiteOre); GameRegistry.registerBlock(ThermiteOre, Strings.thermiteOre);
	TerriteOre = new BlockTerriteOre(IDs.territeOre, Material.rock).setUnlocalizedName(Strings.territeOre); GameRegistry.registerBlock(TerriteOre, Strings.territeOre);
	AetheriumOre = new BlockAetheriumOre(IDs.aetheriumOre, Material.rock).setUnlocalizedName(Strings.aetheriumOre); GameRegistry.registerBlock(AetheriumOre, Strings.aetheriumOre);
	AeriteOre = new BlockAeriteOre(IDs.aeriteOre, Material.rock).setUnlocalizedName(Strings.aeriteOre); GameRegistry.registerBlock(AeriteOre, Strings.aeriteOre);
	
	Smasher = new BlockSmasher(IDs.Smasher, false).setUnlocalizedName(Strings.Smasher).setCreativeTab(ModMain.kwxCreativeTab); GameRegistry.registerBlock(Smasher, Strings.Smasher);
	SmasherActive = new BlockSmasher(IDs.SmasherActive, true).setUnlocalizedName(Strings.SmasherActive).setLightValue(0.9F); GameRegistry.registerBlock(SmasherActive, Strings.SmasherActive);
	
	WormBreeder = new BlockWormBreeder(IDs.wormBreeder, false).setUnlocalizedName(Strings.wormBreeder).setCreativeTab(ModMain.kwxCreativeTab); GameRegistry.registerBlock(WormBreeder, Strings.wormBreeder);
	WormBreederActive = new BlockWormBreeder(IDs.wormBreederActive, true).setUnlocalizedName(Strings.wormBreederActive).setLightValue(0.9F); GameRegistry.registerBlock(WormBreederActive, Strings.wormBreederActive);

	}
}