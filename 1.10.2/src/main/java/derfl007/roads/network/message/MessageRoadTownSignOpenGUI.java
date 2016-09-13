package derfl007.roads.network.message;

import java.nio.charset.Charset;

import derfl007.roads.Reference;
import derfl007.roads.client.gui.GuiEditRoadTownSign;
import derfl007.roads.network.ClientMessageHandler;
import derfl007.roads.tileentities.TileEntityRoadTownSign;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageRoadTownSignOpenGUI implements IMessage {

    public BlockPos pos;

    public String texture;
    public boolean isMetal;
    public boolean isMoving;

    public MessageRoadTownSignOpenGUI() {
    }

    public MessageRoadTownSignOpenGUI(TileEntityRoadTownSign tileEntity) {
        this.pos = tileEntity.getPos();
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        PacketBuffer packetBuf = new PacketBuffer(buf);

        this.pos = packetBuf.readBlockPos();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        PacketBuffer packetBuf = new PacketBuffer(buf);

        packetBuf.writeBlockPos(pos);
    }


    public static class Handler extends ClientMessageHandler<MessageRoadTownSignOpenGUI> {

        @Override
        @SideOnly(Side.CLIENT)
        protected void handle(MessageRoadTownSignOpenGUI message, MessageContext context) {
            WorldClient world = FMLClientHandler.instance().getClient().theWorld;
            TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.pos);

            if (!(tileEntity instanceof TileEntityRoadTownSign)) {
                tileEntity = new TileEntityRoadTownSign();
                tileEntity.setWorldObj(FMLClientHandler.instance().getClient().theWorld);
                tileEntity.setPos(message.pos);
            }
            tileEntity.markDirty();
            Reference.sayDebugChat(FMLClientHandler.instance().getClientPlayerEntity(), tileEntity.toString());
            FMLClientHandler.instance().getClient().displayGuiScreen(new GuiEditRoadTownSign((TileEntityRoadTownSign) tileEntity));
        }
    }
}