package derfl007.roads.blocks;

import java.util.List;

import javax.annotation.Nullable;

import derfl007.roads.Reference;
import derfl007.roads.Roads;
import derfl007.roads.items.ItemWrench;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRoadRotatable extends Block {
	public BlockRoadRotatable(String unlocalizedName, String registryName) {
		super(Material.CLOTH);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(Roads.ROADS_TAB);
	}
	
    protected static final AxisAlignedBB AABB_QTR_TOP_WEST = new AxisAlignedBB(0.0D, 0.3125D, 0.0D, 0.5D, 0.8125D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP_EAST = new AxisAlignedBB(0.5D, 0.3125D, 0.0D, 1.0D, 0.8125D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP_NORTH = new AxisAlignedBB(0.0D, 0.3125D, 0.0D, 1.0D, 0.8125D, 0.5D);
    protected static final AxisAlignedBB AABB_QTR_TOP_SOUTH = new AxisAlignedBB(0.0D, 0.3125D, 0.5D, 1.0D, 0.8125D, 1.0D);
    protected static final AxisAlignedBB AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0D, -0.1875D, 0.0D, 1.0D, 0.3125D, 1.0D);
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyDirection SLOPE_FACING = PropertyDirection.create("slope_facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool SLOPE = PropertyBool.create("slope");
	
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, 
			AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        if(state.getValue(SLOPE) == true) {
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SLAB_BOTTOM);
        	switch(state.getValue(FACING)) {
			case WEST:
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_TOP_EAST);
				break;
			case SOUTH:
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_TOP_NORTH);
				break;
			case NORTH:
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_TOP_SOUTH);
				break;
			case EAST:
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_TOP_WEST);
				break;
			default:
				break;
        	}
        } else {
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, Reference.ROAD_BLOCK_AABB);
        }
    }

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return Reference.ROAD_BLOCK_AABB;
	}
	
	private boolean shouldBeSlope(IBlockAccess worldIn, BlockPos pos, IBlockState state) {
		Block block = worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock();
		if(block instanceof BlockRoad || block instanceof BlockRoadLine) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(SLOPE, Boolean.valueOf(shouldBeSlope(worldIn, pos, worldIn.getBlockState(pos)))).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(meta < 4) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(0))
					.withProperty(SLOPE_FACING, EnumFacing.getHorizontal(meta));
		} else if(meta < 8) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(1))
					.withProperty(SLOPE_FACING, EnumFacing.getHorizontal(meta-4));
		} else if(meta < 12) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(2))
					.withProperty(SLOPE_FACING, EnumFacing.getHorizontal(meta-8));
		} else {
			return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(3))
					.withProperty(SLOPE_FACING, EnumFacing.getHorizontal(meta-12));
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int facing = state.getValue(FACING).getHorizontalIndex();
		int slopeFacing = state.getValue(SLOPE_FACING).getHorizontalIndex();
		if(facing == 0) {
			return slopeFacing;
		} else if (facing == 1) {
			return 4 + slopeFacing;
		} else if (facing == 2) {
			return 8 + slopeFacing;
		} else if (facing == 3) {
			return 12 + slopeFacing;
		} else {
			return 0; 
		}
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, SLOPE, SLOPE_FACING });
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(SLOPE, Boolean.valueOf(shouldBeSlope(worldIn, pos, state)));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(worldIn.isRemote) {
			return false;
		}
		if(heldItem != null) {
			if(heldItem.getItem() instanceof ItemWrench) {
				EnumFacing slopeFacing = worldIn.getBlockState(pos).getValue(SLOPE_FACING);
				if(slopeFacing == EnumFacing.NORTH) {
					worldIn.setBlockState(pos, state.withProperty(SLOPE_FACING, EnumFacing.EAST).withProperty(SLOPE, Boolean.valueOf(shouldBeSlope((World) worldIn, pos, state))));
				} else if(slopeFacing == EnumFacing.EAST) {
					worldIn.setBlockState(pos, state.withProperty(SLOPE_FACING, EnumFacing.SOUTH).withProperty(SLOPE, Boolean.valueOf(shouldBeSlope((World) worldIn, pos, state))));
				} else if(slopeFacing == EnumFacing.SOUTH) {
					worldIn.setBlockState(pos, state.withProperty(SLOPE_FACING, EnumFacing.WEST).withProperty(SLOPE, Boolean.valueOf(shouldBeSlope((World) worldIn, pos, state))));
				} else if(slopeFacing == EnumFacing.WEST) {
					worldIn.setBlockState(pos, state.withProperty(SLOPE_FACING, EnumFacing.NORTH).withProperty(SLOPE, Boolean.valueOf(shouldBeSlope((World) worldIn, pos, state))));
				} else {
					worldIn.setBlockState(pos, state.withProperty(SLOPE_FACING, EnumFacing.NORTH).withProperty(SLOPE, Boolean.valueOf(shouldBeSlope((World) worldIn, pos, state))));
				}
				return true;
			}
		}
		return false;
	}
}