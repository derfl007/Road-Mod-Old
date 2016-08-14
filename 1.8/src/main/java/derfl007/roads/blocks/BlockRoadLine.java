package derfl007.roads.blocks;

import derfl007.roads.Reference;
import derfl007.roads.Roads;
import derfl007.roads.init.RoadBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRoadLine extends Block {
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");

	public BlockRoadLine() {
		super(Material.cloth);
		setUnlocalizedName("road_line");
		setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false))
				.withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false))
				.withProperty(WEST, Boolean.valueOf(false)));
		setCreativeTab(Roads.ROADS_TAB);
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return Reference.ROAD_BLOCK_AABB;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		for (connectableBlocks b : connectableBlocks.values()) {
			if (b.block().equals(block)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	public static enum connectableBlocks {
		ROAD_LINE(RoadBlocks.road_line), //
		ROAD_LINE_MERGE(RoadBlocks.road_line_merge), //
		ROAD_LINE_DIAGONAL(RoadBlocks.road_line_diagonal), //
		ROAD_WHITE_QUARTER(RoadBlocks.road_white_quarter), //
		ROAD_WHITE_HALF(RoadBlocks.road_white_half), //
		// ROAD_EXCL_ZONE(RoadBlocks.road_excl_zone), //
		// ROAD_EXCL_ZONE_CORNER_IN(RoadBlocks.road_excl_zone_corner_in), //
		// ROAD_EXCL_ZONE_CORNER_OUT(RoadBlocks.road_excl_zone_corner_out), //
		// ROAD_EXCL_ZONE_DIAGONAL_IN(RoadBlocks.road_excl_zone_diagonal_in), //
		// ROAD_EXCL_ZONE_DIAGONAL_OUT(RoadBlocks.road_excl_zone_diagonal_out),
		// //
		// ROAD_EXCL_ZONE_LINE(RoadBlocks.road_excl_zone_line), //
		ROAD_EXCL_ZONE_SPLIT_IN_L(RoadBlocks.road_excl_zone_split_in_l), //
		ROAD_EXCL_ZONE_SPLIT_IN_R(RoadBlocks.road_excl_zone_split_in_r), //
		ROAD_EXCL_ZONE_SPLIT_OUT_L(RoadBlocks.road_excl_zone_split_out_l), //
		ROAD_EXCL_ZONE_SPLIT_OUT_R(RoadBlocks.road_excl_zone_split_out_r); //

		private final Block block;

		connectableBlocks(Block block) {
			this.block = block;
		}

		private Block block() {
			return block;
		}

		public String getName() {
			return block().toString();
		}
	}

	/**
	 * Get the actual Block state of this Block at the given position. This
	 * applies properties not visible in the metadata, such as fence
	 * connections.
	 */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north())))
				.withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east())))
				.withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south())))
				.withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())));
	}

	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { NORTH, SOUTH, EAST, WEST });
    }
}