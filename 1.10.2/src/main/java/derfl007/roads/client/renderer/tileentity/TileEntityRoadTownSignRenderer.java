package derfl007.roads.client.renderer.tileentity;

import derfl007.roads.Reference;
import derfl007.roads.client.model.ModelRoadsTownSign;
import derfl007.roads.network.PacketHandler;
import derfl007.roads.network.message.MessageRoadTownSign;
import derfl007.roads.tileentities.TileEntityRoadTownSign;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityRoadTownSignRenderer extends TileEntitySpecialRenderer<TileEntityRoadTownSign> {
	private static final ResourceLocation ROAD_TOWN_SIGN_TEXTURE = new ResourceLocation("roads:textures/entity/road_town_sign.png");
	private ModelRoadsTownSign model = new ModelRoadsTownSign();
	public String text;
	public TileEntityRoadTownSign te;

    public TileEntityRoadTownSignRenderer() {
        this.model = new ModelRoadsTownSign();
    }
    
    public TileEntityRoadTownSignRenderer(TileEntityRoadTownSign te, String text) {
    	this.te = te;
    	this.text = text;
    }
	
	@Override
	public void renderTileEntityAt(TileEntityRoadTownSign te, double x, double y, double z, float partialTicks,
			int destroyStage) throws NullPointerException {
		if(this.te !=null) te = this.te;
		if(this.te == null) text = "NO TEXT";
		Block block = te.getBlockType();
		GlStateManager.pushMatrix();
		float f = 0.6666667F;
		int k = te.getBlockMetadata();
		float f2 = 0.0F;

		if (k == 1) {
			f2 = 90.0F;
		}

		if (k == 2) {
			f2 = 180.0F;
		}

		if (k == 3) {
			f2 = -90.0F;
		}

		GlStateManager.translate((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
		GlStateManager.rotate(-f2, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(0.0F, -0.3125F, -0.4375F);

		if (destroyStage >= 0) {
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scale(4.0F, 2.0F, 1.0F);
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		} else {
			this.bindTexture(ROAD_TOWN_SIGN_TEXTURE);
		}

		GlStateManager.enableRescaleNormal();
		GlStateManager.pushMatrix();
		GlStateManager.scale(0.6666667F, -0.6666667F, -0.6666667F);
		this.model.renderRoadsTownSign();
		GlStateManager.popMatrix();
		FontRenderer fontrenderer = this.getFontRenderer();
		float f3 = 0.010416667F;
		GlStateManager.translate(0.0F, 0.40F, 0.501F);
//		GlStateManager.scale(0.010416667F, -0.010416667F, 0.010416667F);
		GlStateManager.glNormal3f(0.0F, 0.0F, -0.010416667F);
		GlStateManager.depthMask(false);
		int i = 0;

		if (destroyStage < 0) {
			int sLength = text.length();
			if(sLength >= 12) {
				GlStateManager.scale(0.010F, -0.02F, 010416667F);
			} else if(sLength >= 10) {
				GlStateManager.scale(0.012F, -0.02F, 010416667F);
			} else if(sLength >= 8) {
				GlStateManager.scale(0.014F, -0.02F, 010416667F);
			} else if(sLength >= 6) {
				GlStateManager.scale(0.016F, -0.02F, 010416667F);
			} else if(sLength >= 4) {
				GlStateManager.scale(0.018F, -0.02F, 010416667F);
			} else {
				GlStateManager.scale(0.020F, -0.02F, 0.010416667F);
			}
				fontrenderer.drawString(text, -fontrenderer.getStringWidth(text) / 2, 0, 0);
		}

		GlStateManager.depthMask(true);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.popMatrix();

		if (destroyStage >= 0) {
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
	}
}