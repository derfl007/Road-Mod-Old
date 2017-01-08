package derfl007.roads.proxy;

import derfl007.roads.entities.EntityCar;
import derfl007.roads.init.RoadBlocks;
import derfl007.roads.init.RoadItems;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy implements CommonProxy {
	
	@Override
	public void init() {
		RoadBlocks.registerRenders();
		RoadItems.registerRenders();
	}

	@Override
	public void preInit() {
		
	}

}
