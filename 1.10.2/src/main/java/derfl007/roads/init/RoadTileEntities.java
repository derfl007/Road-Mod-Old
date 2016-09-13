package derfl007.roads.init;

import derfl007.roads.client.renderer.tileentity.TileEntityRoadTownSignRenderer;
import derfl007.roads.tileentities.TileEntityRoadTownSign;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RoadTileEntities {
	public static void register() {
		GameRegistry.registerTileEntity(TileEntityRoadTownSign.class, "roadsTownSign");
	}
	public static void registerRenders() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoadTownSign.class, new TileEntityRoadTownSignRenderer());
	}
}