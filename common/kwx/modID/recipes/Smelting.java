package kwx.modID.recipes;

import net.minecraft.item.ItemStack;
import kwx.modID.block.AddedBlocks;
import kwx.modID.item.AddedItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class Smelting {

	public static void InitSmelting(){
		GameRegistry.addSmelting(AddedBlocks.MagnetiteOre.blockID, new ItemStack(AddedItems.MagnetiteIngot), 0.7F);
		GameRegistry.addSmelting(AddedBlocks.SunnariumOre.blockID, new ItemStack(AddedItems.SunnariumIngot), 0.7F);
		GameRegistry.addSmelting(AddedBlocks.LunariumOre.blockID, new ItemStack(AddedItems.LunnariumIngot), 0.7F);
		GameRegistry.addSmelting(AddedBlocks.TerriteOre.blockID, new ItemStack(AddedItems.TerriteIngot), 0.7F);
		
		GameRegistry.addSmelting(AddedItems.MagnetiteMass.itemID, new ItemStack(AddedItems.MagnetiteIngot), 0.7F);
		GameRegistry.addSmelting(AddedItems.SunnariumMass.itemID, new ItemStack(AddedItems.SunnariumIngot), 0.7F);
		GameRegistry.addSmelting(AddedItems.LunnariumMass.itemID, new ItemStack(AddedItems.LunnariumIngot), 0.7F);
		GameRegistry.addSmelting(AddedItems.TerriteMass.itemID, new ItemStack(AddedItems.TerriteIngot), 0.7F);
	}
}
