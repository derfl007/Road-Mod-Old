package derfl007.roads;

import net.minecraft.util.math.AxisAlignedBB;

public class Reference {
	public static final String MOD_ID = "roads";
	public static final String MOD_NAME = "Road Mod";
	public static final String VERSION = "0.7a";
	public static final String ACCEPTED_VERSIONS = "[1.10.2]";

	public static final String CLIENT_PROXY_CLASS = "derfl007.roads.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "derfl007.roads.proxy.CommonProxy";

	public static final AxisAlignedBB ROAD_BLOCK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.82D, 1.0D);
	public static final AxisAlignedBB ROAD_SIGN_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
}