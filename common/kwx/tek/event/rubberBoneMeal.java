package kwx.tek.event;

import kwx.tek.block.AddedBlocks;
import kwx.tek.block.rubberTree.blockRubberSapling;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class rubberBoneMeal {

	@ForgeSubscribe
	public void usedBonemeal(BonemealEvent event){
		
		if(event.ID == AddedBlocks.rubberSapling.blockID){
			
			if(!event.world.isRemote){
				((blockRubberSapling)AddedBlocks.rubberSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
			}
			
		}
		
	}
	
}
