package kwx.modID.core.handlers;

import kwx.modID.TileEntity.TileEntityBreeder;
import kwx.modID.TileEntity.TileEntitySmasher;
import kwx.modID.container.ContainerBreeder;
import kwx.modID.container.ContainerSmasher;
import kwx.modID.gui.GuiBreeder;
import kwx.modID.gui.GuiSmasher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		switch(id)
		{
			case 0: return new ContainerSmasher(player.inventory, (TileEntitySmasher) tile_entity);
			case 1: return new ContainerBreeder(player.inventory, (TileEntityBreeder) tile_entity);
		}
		return null;
	}
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		switch(id)
		{
			case 0: return new GuiSmasher(player.inventory, (TileEntitySmasher) tile_entity);
			case 1: return new GuiBreeder(player.inventory, (TileEntityBreeder) tile_entity);
		}
		return null;
	}
}