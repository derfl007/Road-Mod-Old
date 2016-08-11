package derfl007.roads.proxy;

import derfl007.roads.init.RoadBlocks;
import derfl007.roads.init.RoadItems;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		RoadBlocks.registerRenders();
		RoadItems.registerRenders();
	}

}
