package derfl007.roads.blocks;

import derfl007.roads.Roads;
import derfl007.roads.init.RoadBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRoadSign extends BlockDirectional {
	public BlockRoadSign(String unlocalizedName) {
		super(Material.iron);
		this.setUnlocalizedName(unlocalizedName);
		setCreativeTab(Roads.ROADS_TAB);
	}
	
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool WEST = PropertyBool.create("west");

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		int meta = ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
		switch (meta) {
		case 0:
			return state.withProperty(UP, Boolean.valueOf(this.canConnectTo(worldIn, pos.up())))
					.withProperty(DOWN, Boolean.valueOf(this.canConnectTo(worldIn, pos.down())))
					.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north())))
					.withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south())))
					.withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east())))
					.withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())));
		case 1:
			return state.withProperty(UP, Boolean.valueOf(this.canConnectTo(worldIn, pos.up())))
					.withProperty(DOWN, Boolean.valueOf(this.canConnectTo(worldIn, pos.down())))
					.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.east())))
					.withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())))
					.withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.south())))
					.withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.north())));
		case 2:
			return state.withProperty(UP, Boolean.valueOf(this.canConnectTo(worldIn, pos.up())))
					.withProperty(DOWN, Boolean.valueOf(this.canConnectTo(worldIn, pos.down())))
					.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south())))
					.withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north())))
					.withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())))
					.withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east())));
		case 3:
			return state.withProperty(UP, Boolean.valueOf(this.canConnectTo(worldIn, pos.up())))
					.withProperty(DOWN, Boolean.valueOf(this.canConnectTo(worldIn, pos.down())))
					.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())))
					.withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.east())))
					.withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.north())))
					.withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.south())));
		default:
			return state.withProperty(UP, Boolean.valueOf(this.canConnectTo(worldIn, pos.up())))
					.withProperty(DOWN, Boolean.valueOf(this.canConnectTo(worldIn, pos.down())))
					.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north())))
					.withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south())))
					.withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east())))
					.withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())));
		}

	}
	
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();
		String blockname = block.getUnlocalizedName().toString();
		try {
			if (blockname.substring(5, 20).equals("road_block_sign") || block == RoadBlocks.road_traffic_light
					|| block == RoadBlocks.road_pedestrian_traffic_light) {
				return true;
			} else {
				return false;
			}
		} catch (StringIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("Index out of bounds!");
			if (block == RoadBlocks.road_traffic_light || block == RoadBlocks.road_pedestrian_traffic_light) {
				return true;
			} else {
				return false;
			}
		}
	}

	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { FACING, UP, DOWN, NORTH, SOUTH, EAST, WEST });
    }
}