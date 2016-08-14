package derfl007.roads.blocks;

import derfl007.roads.Reference;
import derfl007.roads.Roads;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockRoad extends Block {
	public BlockRoad(String unlocalizedName) {
		super(Material.cloth);
		setUnlocalizedName(unlocalizedName);
		setCreativeTab(Roads.ROADS_TAB);
		Reference.setBlockBounds(this, Reference.ROAD_BLOCK_AABB);
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		// TODO Auto-generated method stub
		return false;
	}
}