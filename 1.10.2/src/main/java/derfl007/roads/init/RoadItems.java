package derfl007.roads.init;

import derfl007.roads.items.ItemTar;
import derfl007.roads.items.ItemWrench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RoadItems {

	public static Item item_tar, item_wrench;
	
	public static void init() {
		item_tar = new ItemTar();
		item_wrench = new ItemWrench();
	}
	
	public static void register() {
		GameRegistry.register(item_tar);
		GameRegistry.register(item_wrench);
	}
	
	public static void registerRenders() {
		registerRender(item_tar);
		registerRender(item_wrench);
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
