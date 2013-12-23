package kwx.tek.core.handlers;

import java.io.File;
import java.util.logging.Level;

import kwx.tek.lib.IDs;
import kwx.tek.lib.Reference;
import kwx.tek.lib.Strings;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {

	public static Configuration config;

	public static void preConfig(File file){
		config = new Configuration(file);

		try{
			config.load();
			
			//Ores
			IDs.copperOre = config.getBlock(Strings.copperOre + " ID", IDs.COPPERORE_DEFAULT).getInt(IDs.COPPERORE_DEFAULT);
			IDs.tinOre = config.getBlock(Strings.tinOre + " ID", IDs.TINORE_DEFAULT).getInt(IDs.TINORE_DEFAULT);
			IDs.aluminiumOre = config.getBlock(Strings.aluminiumOre + " ID", IDs.ALUMINIUMORE_DEFAULT).getInt(IDs.ALUMINIUMORE_DEFAULT);
			IDs.siliconOre = config.getBlock(Strings.siliconOre + " ID", IDs.SILICONORE_DEFUALT).getInt(IDs.SILICONORE_DEFUALT);
			IDs.uraniumOre = config.getBlock(Strings.uraniumOre + " ID", IDs.URANIUMORE_DEFUALT).getInt(IDs.URANIUMORE_DEFUALT);
			IDs.titaniumOre = config.getBlock(Strings.titaniumOre + " ID", IDs.TITANIUMORE_DEFUALT).getInt(IDs.TITANIUMORE_DEFUALT);
			IDs.platinumOre = config.getBlock(Strings.platinumOre + " ID", IDs.PLATINUMORE_DEFUALT).getInt(IDs.PLATINUMORE_DEFUALT);
		
			//Rubber tree
			IDs.rubberLog = config.getBlock(Strings.rubberLog + " ID", IDs.RUBBERLOG_DEFAULT).getInt(IDs.RUBBERLOG_DEFAULT);
			IDs.rubberLeaves = config.getBlock(Strings.rubberLeaves + " ID", IDs.RUBBERLEAVES_DEFAULT).getInt(IDs.RUBBERLEAVES_DEFAULT);
			IDs.rubberSapling = config.getBlock(Strings.rubberSapling + " ID", IDs.RUBBERSAPLING_DEFAULT).getInt(IDs.RUBBERSAPLING_DEFAULT);
			
		}

		catch(Exception e){
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + "Has a problem loading the config file");
		}
		finally{
			config.save();
		}
	}
}
