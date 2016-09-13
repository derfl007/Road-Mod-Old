package derfl007.roads.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelRoadsTownSign extends ModelBase {
	public ModelRenderer signBoard = new ModelRenderer(this, 0, 0);

	public ModelRoadsTownSign() {
		this.signBoard.addBox(-12.0F, -14.0F, -12.0F, 24, 12, 0, 0.0F);
	}

	/**
	 * Renders the sign model through TileEntityRoadTownSignRenderer
	 */
	public void renderRoadsTownSign() {
		this.signBoard.render(0.0625F);
	}
}