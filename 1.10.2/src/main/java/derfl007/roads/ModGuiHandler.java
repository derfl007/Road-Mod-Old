package derfl007.roads;

import derfl007.roads.client.gui.GuiEditRoadTownSign;
import derfl007.roads.tileentities.TileEntityRoadTownSign;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler{
	public static final int ROAD_TOWN_SIGN_GUI = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    if (ID == ROAD_TOWN_SIGN_GUI) {
	        return new GuiEditRoadTownSign(new TileEntityRoadTownSign());
	    }
	    return null;
	}
}
