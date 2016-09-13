package derfl007.roads.network;

import derfl007.roads.Reference;
import derfl007.roads.network.message.MessageRoadTownSign;
import derfl007.roads.network.message.MessageRoadTownSignOpenGUI;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

	/** Simple network rapper... oh um, sorry I meant wrapper. */ 
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

	/** Register messages */
    public static void init() {
    	INSTANCE.registerMessage(MessageRoadTownSignOpenGUI.Handler.class, MessageRoadTownSignOpenGUI.class, 0, Side.CLIENT);
        INSTANCE.registerMessage(MessageRoadTownSign.ServerHandler.class, MessageRoadTownSign.class, 1, Side.SERVER);
    }
}
