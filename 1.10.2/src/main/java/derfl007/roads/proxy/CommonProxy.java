package derfl007.roads.proxy;

import derfl007.roads.ModGuiHandler;
import derfl007.roads.Roads;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit() {
	}
	
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Roads.instance, new ModGuiHandler());
	}
}
