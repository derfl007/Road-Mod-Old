package derfl007.roads.tileentities;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityRoadTownSign extends TileEntity{

	public String signText;
	private boolean isEditable = true;
	private EntityPlayer player;
	
	public TileEntityRoadTownSign() {
	}

	
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		String s = signText;
		if(s == null) {
			s = "MINECRAFT CITY";
		}
		compound.setString("Text", s);
		return compound;
	}

	
	public void readFromNBT(NBTTagCompound compound) {
		this.isEditable = false;
		super.readFromNBT(compound);
		String s = compound.getString("Text");
	}
	
	
	public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }
	
	
	public boolean onlyOpsCanSetNbt()
    {
        return true;
    }

	
    public boolean getIsEditable()
    {
        return this.isEditable;
    }

    /**
     * Sets the sign's isEditable flag to the specified parameter.
     */
	
	
    @SideOnly(Side.CLIENT)
    public void setEditable(boolean isEditableIn)
    {
        this.isEditable = isEditableIn;

        if (!isEditableIn)
        {
            this.player = null;
        }
    }

	
    public void setPlayer(EntityPlayer playerIn)
    {
        this.player = playerIn;
    }

	
    public EntityPlayer getPlayer()
    {
        return this.player;
    }

	
    protected void func_190201_b(World p_190201_1_)
    {
        this.setWorldObj(p_190201_1_);
    }

	
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return (oldState.getBlock() != newSate.getBlock());
    }

    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(getPos(), 0, writeToNBT(new NBTTagCompound()));
    }

    
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        readFromNBT(pkt.getNbtCompound());
        markDirty();
    }

    
    public boolean executeCommand(final EntityPlayer playerIn) {
    	return false;
    }
    
    
    public CommandResultStats getStats()
    {
        return null;
    }
}