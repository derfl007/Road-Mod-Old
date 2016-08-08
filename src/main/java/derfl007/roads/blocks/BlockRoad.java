package derfl007.roads.blocks;

import derfl007.roads.Reference;
import derfl007.roads.Roads;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRoad extends Block{
	public BlockRoad() {
		super(Material.CLOTH);
		setUnlocalizedName("road");
		setRegistryName("BlockRoad");
		setCreativeTab(Roads.ROADS_TAB);
	}
	
	
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return Reference.ROAD_BLOCK_AABB;
    }
	
}