package kwx.modID.core.handlers;

import java.io.File;
import java.util.logging.Level;

import kwx.modID.lib.IDs;
import kwx.modID.lib.Reference;
import kwx.modID.lib.Strings;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {

	public static Configuration config;

	public static void preConfig(File file){
		config = new Configuration(file);

		try{
			config.load();
			
			IDs.aeriteOre = config.getBlock(Strings.aeriteOre + " ID", IDs.AERITEORE_DEFAULT).getInt(IDs.AERITEORE_DEFAULT);
			IDs.aetheriumItem = config.getItem(Strings.aetheriumItem  + " ID", IDs.AETHERIUMITEM_DEFAULT).getInt(IDs.AETHERIUMITEM_DEFAULT);
			IDs.aetheriumOre = config.getBlock(Strings.aetheriumOre  + " ID", IDs.AETHERIUMORE_DEFAULT).getInt(IDs.AETHERIUMORE_DEFAULT);
			IDs.lunariumOre = config.getBlock(Strings.lunariumOre  + " ID", IDs.LUNARIUMORE_DEFAULT).getInt(IDs.LUNARIUMORE_DEFAULT);
			IDs.magnetiteOre = config.getBlock(Strings.magnetiteOre  + " ID", IDs.MAGNETITEORE_DEFAULT).getInt(IDs.MAGNETITEORE_DEFAULT);
			IDs.sunnariumOre = config.getBlock(Strings.sunnariumOre  + " ID", IDs.SUNNARIUMORE_DEFAULT).getInt(IDs.SUNNARIUMORE_DEFAULT);
			IDs.territeOre = config.getBlock(Strings.territeOre  + " ID", IDs.TERRITEORE_DEFAULT).getInt(IDs.TERRITEORE_DEFAULT);
			IDs.thermiteItem = config.getItem(Strings.thermiteItem  + " ID", IDs.THERMITEITEM_DEFAULT).getInt(IDs.THERMITEITEM_DEFAULT);
			IDs.thermiteOre = config.getBlock(Strings.thermiteOre  + " ID", IDs.THERMITEORE_DEFAULT).getInt(IDs.THERMITEORE_DEFAULT);
			IDs.magnetiteIngot = config.getItem(Strings.magnetiteIngot + " ID", IDs.MAGNETITEINGOT_DEFAULT).getInt(IDs.MAGNETITEINGOT_DEFAULT);
			IDs.sunnariumIngot = config.getItem(Strings.sunnariumIngot + " ID", IDs.SUNNARIUMINGOT_DEFAULT).getInt(IDs.SUNNARIUMINGOT_DEFAULT);
			IDs.lunnariumIngot = config.getItem(Strings.lunariumIngot + " ID", IDs.LUNNARIUMINGOT_DEFAULT).getInt(IDs.LUNNARIUMINGOT_DEFAULT);
			IDs.territeIngot = config.getItem(Strings.territeIngot + " ID", IDs.TERRITEINGOT_DEFAULT).getInt(IDs.TERRITEINGOT_DEFAULT);
			IDs.aeriteItem = config.getItem(Strings.aeriteItem + " ID", IDs.AERITEITEM_DEFAULT).getInt(IDs.AERITEITEM_DEFAULT);
			IDs.Smasher = config.getBlock(Strings.Smasher + " ID", IDs.SMASHER_DEFAULT).getInt(IDs.SMASHER_DEFAULT);
			IDs.SmasherActive = config.getBlock(Strings.SmasherActive + " ID", IDs.SMASHERACTIVE_DEFAULT).getInt(IDs.SMASHERACTIVE_DEFAULT);
			IDs.magnetiteMass = config.getItem(Strings.magnetiteMass + " ID", IDs.MAGNETITEMASS_DEFAULT).getInt(IDs.MAGNETITEMASS_DEFAULT);
			IDs.territeMass = config.getItem(Strings.territeMass + " ID", IDs.TERRITEMASS_DEFAULT).getInt(IDs.TERRITEMASS_DEFAULT);
			IDs.lunnariumMass = config.getItem(Strings.lunnariumMass + " ID", IDs.LUNNARIUMMASS_DEFAULT).getInt(IDs.LUNNARIUMMASS_DEFAULT);
			IDs.sunnariumMass = config.getItem(Strings.sunnariumMass + " ID", IDs.SUNNARIUMMASS_DEFAULT).getInt(IDs.SUNNARIUMMASS_DEFAULT);
			IDs.silkWorm = config.getItem(Strings.silkWorm + " ID", IDs.SILKWORM_DEFAULT).getInt(IDs.SILKWORM_DEFAULT);
			IDs.mullberryLeaves = config.getItem(Strings.mullberryLeaves + " ID", IDs.MULLBERRYLEAVES_DEFAULT).getInt(IDs.MULLBERRYLEAVES_DEFAULT);
			IDs.wormBreeder = config.getBlock(Strings.wormBreeder + " ID", IDs.WORMBREEDER_DEFAULT).getInt(IDs.WORMBREEDER_DEFAULT);
			IDs.wormBreederActive = config.getBlock(Strings.wormBreederActive + " ID", IDs.WORMBREEDERACTIVE_DEFAULT).getInt(IDs.WORMBREEDERACTIVE_DEFAULT);
			IDs.mulberryPlant = config.getBlock(Strings.mulberryPlant + " ID", IDs.MULBERRYPLANT_DEFAULT).getInt(IDs.MULBERRYPLANT_DEFAULT);
			IDs.silk = config.getItem(Strings.silk + " ID", IDs.SILK_DEFAULT).getInt(IDs.SILK_DEFAULT);
		}

		catch(Exception e){
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + "Has a problem loading the config file");
		}
		finally{
			config.save();
		}
	}
}
