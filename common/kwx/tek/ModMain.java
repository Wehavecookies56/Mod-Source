package kwx.tek;

import java.io.File;

import universalelectricity.compatibility.Compatibility;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import kwx.tek.block.AddedBlocks;
import kwx.tek.core.handlers.ConfigurationHandler;
import kwx.tek.core.handlers.LocalizationHandler;
import kwx.tek.core.handlers.UpdateHandler;
import kwx.tek.core.proxies.CommonProxy;
import kwx.tek.event.EventManager;
import kwx.tek.item.AddedItems;
import kwx.tek.lib.Reference;
import kwx.tek.packetHandler.*;
import kwx.tek.recipes.Crafting;
import kwx.tek.recipes.Smelting;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = Reference.MOD_NAME, modid = Reference.MOD_ID, version = Reference.MOD_VER, dependencies = "required-after:kwxCore@[0.0.1]")

@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = "CHANNEL_NAME", packetHandler = tekPacketHandler.class)

public class ModMain {
	
	@Instance(Reference.MOD_ID)
	public static ModMain instance;
	
	public static CreativeTabs kwxCreativeTab = new kwx.tek.creativeTab.kwxCreativeTab(CreativeTabs.getNextID(),"kwxMaterialsTab");
	
	EventManager eventManager = new EventManager();
	
	@SidedProxy(clientSide = "kwx.tek.core.proxies.ClientProxy", serverSide = "kwx.tek.core.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ConfigurationHandler.preConfig(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
		AddedBlocks.initBlocks();
		AddedItems.initItems();
		Smelting.InitSmelting();
		Crafting.InitCrafting();
		LocalizationHandler.loadLanguages();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		GameRegistry.registerWorldGenerator(eventManager);
		NetworkRegistry.instance().registerConnectionHandler(new UpdateHandler("Tek", Reference.MOD_VER, "http://pastebin.com/raw.php?i=8RJgb5FM"));		
		proxy.registerRenderers();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//POST INIT
	}

}
