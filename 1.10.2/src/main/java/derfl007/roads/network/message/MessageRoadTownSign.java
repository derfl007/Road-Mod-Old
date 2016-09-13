package derfl007.roads.network.message;

import derfl007.roads.Reference;
import derfl007.roads.client.renderer.tileentity.TileEntityRoadTownSignRenderer;
import derfl007.roads.network.ServerMessageHandler;
import derfl007.roads.tileentities.TileEntityRoadTownSign;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRoadTownSign implements IMessage {

    public BlockPos pos;
    public String text;
    
    public MessageRoadTownSign() {
    	
    }
    
    public MessageRoadTownSign(BlockPos pos, String text) {
    	this.pos = pos;
    	this.text = text;
    }

    public MessageRoadTownSign(TileEntityRoadTownSign te) {
        this(te.getPos(), te.signText);
        Reference.sayDebugChat(Minecraft.getMinecraft().thePlayer, "te.signText = " + te.signText);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    	PacketBuffer packetBuf = new PacketBuffer(buf);
        pos = packetBuf.readBlockPos();
        text = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	PacketBuffer packetBuf = new PacketBuffer(buf);
        packetBuf.writeBlockPos(pos);
        ByteBufUtils.writeUTF8String(buf, text);
    }

    public static class ServerHandler extends ServerMessageHandler<MessageRoadTownSign> {

        @Override
        protected void handle(MessageRoadTownSign message, MessageContext context) {
            EntityPlayerMP player = context.getServerHandler().playerEntity;
            player.markPlayerActive();
            WorldServer worldserver = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(player.dimension);
            Reference.sayDebugChat(player, "message.pos = "+message.pos);
            TileEntityRoadTownSign sign = (TileEntityRoadTownSign) worldserver.getTileEntity(message.pos);
            if(sign instanceof TileEntityRoadTownSign) {
            	Reference.sayDebugChat(player, sign.toString());
            	Reference.sayDebugChat(player, "message.text = "+message.text);
            	Reference.sayDebugChat(player, "sing.signText = "+sign.signText);
            	sign.signText = message.text;
            	new TileEntityRoadTownSignRenderer(sign, message.text);
            	Reference.sayDebugChat(player, "sing.signText = "+sign.signText);
            	sign.markDirty();
                IBlockState iblockstate = worldserver.getBlockState(message.pos);
                worldserver.notifyBlockUpdate(message.pos, iblockstate, iblockstate, 3);
            }
        }
    }
}