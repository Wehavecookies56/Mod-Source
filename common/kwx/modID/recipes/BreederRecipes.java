package kwx.modID.recipes;

import kwx.modID.item.AddedItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BreederRecipes
{
	public BreederRecipes()
	{
		
	}
	public static ItemStack getSmeltingResult(int i, int j)
	{
         return getOutput(i, j);
	}
	private static ItemStack getOutput(int i, int j)
	{
         if (i == AddedItems.SilkWorm.itemID && j == AddedItems.SilkWorm.itemID)
         {
                 return new ItemStack(AddedItems.Silk, 1);
         }
         return null;
	}
}