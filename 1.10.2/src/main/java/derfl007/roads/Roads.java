package derfl007.roads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import derfl007.roads.init.RoadBlocks;
import derfl007.roads.init.RoadCrafting;
import derfl007.roads.init.RoadItems;
import derfl007.roads.init.RoadTileEntities;
import derfl007.roads.network.PacketHandler;
import derfl007.roads.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Roads {

	@Instance(Reference.MOD_ID)
	public static Roads instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	/** Creative Tab */
	public static final CreativeTabs ROADS_TAB = new RoadsTab();
	public static Logger logger = LogManager.getLogger("Roads");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Pre Init");
		RoadBlocks.init();
		RoadBlocks.register();
		RoadItems.init();
		RoadItems.register();
		PacketHandler.init();
		proxy.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("Init");
		RoadTileEntities.register();
		RoadCrafting.register();
		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("Post Init");
	}
}