package derfl007.roads.proxy;

import derfl007.roads.init.RoadBlocks;
import derfl007.roads.init.RoadItems;
import derfl007.roads.init.RoadTileEntities;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		RoadTileEntities.registerRenders();
	}
	
	@Override
	public void init() {
		RoadBlocks.registerRenders();
		RoadItems.registerRenders();
	}

}
