package derfl007.roads;

import derfl007.roads.init.RoadBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RoadsTab extends CreativeTabs {

	public RoadsTab() {
		super("tabRoads");
		
	}

	@Override
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(RoadBlocks.road_line);
    }
	

}
