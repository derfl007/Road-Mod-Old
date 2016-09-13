package derfl007.roads.blocks;

import derfl007.roads.Roads;
import derfl007.roads.init.RoadBlocks;
import derfl007.roads.tileentities.TileEntityRoadTownSign;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRoadTownSign extends BlockContainer {

	public BlockRoadTownSign(String unlocalizedName, String registryName) {
		super(Material.IRON);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(Roads.ROADS_TAB);
	}
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool WEST = PropertyBool.create("west");

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityRoadTownSign();
	}
	
	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
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
		return state.getValue(FACING).getHorizontalIndex();
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		int meta = state.getValue(FACING).getHorizontalIndex();
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
		if (block.getClass() == RoadBlocks.road_sign_info_1a.getClass() || block == RoadBlocks.road_traffic_light
				|| block == RoadBlocks.road_pedestrian_traffic_light) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, UP, DOWN, NORTH, SOUTH, EAST, WEST });
	}
}
