package derfl007.roads.blocks;

import derfl007.roads.Roads;
import derfl007.roads.init.RoadBlocks;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRoadGuardrail extends BlockDirectional {
	public BlockRoadGuardrail() {
		super(Material.iron);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(SHAPE,
				BlockStairs.EnumShape.STRAIGHT));
		setUnlocalizedName("road_guardrail");
		setCreativeTab(Roads.ROADS_TAB);
	}

	public static final PropertyEnum SHAPE = PropertyEnum.create("shape", BlockStairs.EnumShape.class);
    

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing()).withProperty(SHAPE,
				BlockStairs.EnumShape.STRAIGHT);
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
		return iblockstate;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		i = i | ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
		return i;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(SHAPE, getStairsShape(state, worldIn, pos));
	}

	private static BlockStairs.EnumShape getStairsShape(IBlockState p_185706_0_, IBlockAccess p_185706_1_,
			BlockPos p_185706_2_) {
		EnumFacing enumfacing = (EnumFacing) p_185706_0_.getValue(FACING);
		IBlockState iblockstate = p_185706_1_.getBlockState(p_185706_2_.offset(enumfacing));

		if (iblockstate.getBlock() == RoadBlocks.road_guardrail) {
			EnumFacing enumfacing1 = (EnumFacing) iblockstate.getValue(FACING);

			if (enumfacing1.getAxis() != ((EnumFacing) p_185706_0_.getValue(FACING)).getAxis()) {
				if (enumfacing1 == enumfacing.rotateYCCW()) {
					return BlockStairs.EnumShape.OUTER_LEFT;
				}

				return BlockStairs.EnumShape.OUTER_RIGHT;
			}
		}

		IBlockState iblockstate1 = p_185706_1_.getBlockState(p_185706_2_.offset(enumfacing.getOpposite()));

		if (iblockstate1.getBlock() == RoadBlocks.road_guardrail) {
			EnumFacing enumfacing2 = (EnumFacing) iblockstate1.getValue(FACING);

			if (enumfacing2.getAxis() != ((EnumFacing) p_185706_0_.getValue(FACING)).getAxis()) {
				if (enumfacing2 == enumfacing.rotateYCCW()) {
					return BlockStairs.EnumShape.INNER_LEFT;
				}

				return BlockStairs.EnumShape.INNER_RIGHT;
			}
		}

		return BlockStairs.EnumShape.STRAIGHT;
	}
	
	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING, SHAPE});
    }
}
