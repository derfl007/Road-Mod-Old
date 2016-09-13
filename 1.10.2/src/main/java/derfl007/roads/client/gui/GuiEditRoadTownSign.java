package derfl007.roads.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import derfl007.roads.Reference;
import derfl007.roads.network.PacketHandler;
import derfl007.roads.network.message.MessageRoadTownSign;
import derfl007.roads.tileentities.TileEntityRoadTownSign;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiEditRoadTownSign extends GuiScreen {
	
	/** Reference to the tile entity. */
    private final TileEntityRoadTownSign te;
    
	private GuiLabel label;
	
	private GuiTextField textField;
	
	private GuiButton doneBtn;
	
	public GuiEditRoadTownSign(TileEntityRoadTownSign te)
    {
        this.te = te;
    }

	
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	this.drawDefaultBackground();
    	try {
    		this.textField.drawTextBox();
    	} catch (NullPointerException e) {
    		System.out.println(e);
    	}
    	this.drawCenteredString(this.fontRendererObj, I18n.format("roads.gui.town_sign", new Object[0]), this.width / 2, 20, 16777215);
    	super.drawScreen(mouseX, mouseY, partialTicks);    
    }
    
    @Override
    public boolean doesGuiPauseGame() {
    	return false;
    }
    
    @Override
    public void initGui() { 
    	Keyboard.enableRepeatEvents(true);
    	this.textField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 150, 50, 300, 20);
    	this.textField.setMaxStringLength(32500);
        this.textField.setFocused(true);
    	buttonList.add(this.doneBtn = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 24,  I18n.format("gui.done", new Object[0])));
    
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {

        this.textField.textboxKeyTyped(typedChar, keyCode);
        te.signText = textField.getText();
        Reference.sayDebugChat(Minecraft.getMinecraft().thePlayer, "te.signText = "+te.signText);
        

        if (keyCode == 28 || keyCode == 156) { 
        	this.actionPerformed(this.doneBtn);
        }
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
        Reference.sayDebugChat(Minecraft.getMinecraft().thePlayer, "te.signText = " + te.signText);
        PacketHandler.INSTANCE.sendToServer(new MessageRoadTownSign(te));
    }
    
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.textField.mouseClicked(mouseX, mouseY, mouseButton);
    }    
    
    @Override
    public void updateScreen() {
        textField.updateCursorCounter();
    }
    
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	if(button == doneBtn) {
        	this.mc.displayGuiScreen((GuiScreen)null);
    	}
    }
}