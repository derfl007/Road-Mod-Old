package derfl007.roads.items;

import derfl007.roads.Reference;
import derfl007.roads.Roads;
import derfl007.roads.blocks.BlockRoadTownSign;
import derfl007.roads.init.RoadBlocks;
import derfl007.roads.network.PacketHandler;
import derfl007.roads.network.message.MessageRoadTownSignOpenGUI;
import derfl007.roads.tileentities.TileEntityRoadTownSign;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRoadTownSign extends Item
{
    public ItemRoadTownSign()
    {
        this.maxStackSize = 16;
        this.setRegistryName("ItemRoadTownSign");
        this.setUnlocalizedName("item_road_town_sign");
        this.setCreativeTab(Roads.ROADS_TAB);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world,
    		BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    	if (!world.getBlockState(pos).getMaterial().isSolid()) {
            return EnumActionResult.PASS;
        } else {
            pos = pos.offset(facing);
            
            if (world.isRemote) {
                return EnumActionResult.PASS;
            } else {
            	
            	world.setBlockState(pos, RoadBlocks.road_town_sign.getDefaultState().withProperty(
            			BlockRoadTownSign.FACING, player.getHorizontalFacing().getOpposite()));
            	TileEntity tileEntity = world.getTileEntity(pos);
            	if (tileEntity instanceof TileEntityRoadTownSign && !ItemBlock.setTileEntityNBT(
            			world, player, pos, stack)) {
            		
                    TileEntityRoadTownSign te = (TileEntityRoadTownSign) tileEntity;
                    te.setPlayer(player);
                    PacketHandler.INSTANCE.sendTo(new MessageRoadTownSignOpenGUI(te), (EntityPlayerMP) player);
                }
            	return EnumActionResult.SUCCESS;
            }
        }
    }
}