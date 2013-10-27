package kwx.modID.lib;

import net.minecraft.src.ModLoader;

public class PrintToPlayer {
	
	public static void printText(String message)
	{
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage(message);	
	}

}

