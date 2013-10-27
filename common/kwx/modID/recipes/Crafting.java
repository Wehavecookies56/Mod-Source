package kwx.modID.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import kwx.modID.block.AddedBlocks;
import kwx.modID.item.AddedItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {

	public static void InitCrafting(){
		GameRegistry.addRecipe(new ItemStack(AddedBlocks.Smasher, 1), new Object[]{
			"III",
			"LFL",
			"STS",
			'L', Item.flint,
			'F', Block.furnaceIdle,
			'S', Block.stone,
			'T', AddedItems.ThermiteItem,
			'I', AddedItems.TerriteIngot,
		});
	}
}
