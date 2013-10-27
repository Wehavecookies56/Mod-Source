package kwx.modID;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import kwx.modID.TileEntity.TileEntityBreeder;
import kwx.modID.TileEntity.TileEntitySmasher;
import kwx.modID.block.AddedBlocks;
import kwx.modID.core.handlers.ConfigurationHandler;
import kwx.modID.core.handlers.GuiHandler;
import kwx.modID.core.handlers.LocalizationHandler;
import kwx.modID.core.handlers.UpdateHandler;
import kwx.modID.core.proxies.CommonProxy;
import kwx.modID.event.EventManager;
import kwx.modID.item.AddedItems;
import kwx.modID.lib.Reference;
import kwx.modID.recipes.Crafting;
import kwx.modID.recipes.Smelting;
import kwx.modID.packetHandler.*;
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

@Mod(name = Reference.MOD_NAME, modid = Reference.MOD_ID, version = Reference.MOD_VER)

@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = "CHANNEL_NAME", packetHandler = modIDPacketHandler.class)

public class ModMain {
	
	@Instance(Reference.MOD_ID)
	public static ModMain instance;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	public static CreativeTabs kwxCreativeTab = new kwx.modID.creativeTab.kwxCreativeTab(CreativeTabs.getNextID(),"kwxMaterialsTab");
	
	EventManager eventManager = new EventManager();
	
	@SidedProxy(clientSide = "kwx.modID.core.proxies.ClientProxy", serverSide = "kwx.modID.core.proxies.CommonProxy")
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
		NetworkRegistry.instance().registerConnectionHandler(new UpdateHandler("Mod Name", Reference.MOD_VER, "http://pastebin.com/raw.php?i=RgNj7tfw"));
		
		GameRegistry.registerTileEntity(TileEntitySmasher.class,"tileEntitySmasher");
		GameRegistry.registerTileEntity(TileEntityBreeder.class, "tileEntityBreeder");
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		
		MinecraftForge.addGrassSeed(new ItemStack(AddedItems.SilkWorm), 2);
		MinecraftForge.addGrassSeed(new ItemStack(AddedItems.MullberryLeaves), 3);
		
		proxy.registerRenderers();

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//POST INIT
	}

}
