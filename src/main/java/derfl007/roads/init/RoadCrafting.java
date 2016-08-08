package derfl007.roads.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RoadCrafting {
	
	public static void register() {
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road), "TTT", "TTT", "TTT", 'T', RoadItems.item_tar);
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_line), "TTT", "TDT", "TTT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_line_double), "DTD", "DTD", "DTD", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_line_merge), "TDT", "DDD", "DTD", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_line_diagonal), "TTD", "TDT", "DTT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_arrow_s), "TDT", "TDT", "TDT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_arrow_r), "TTT", "TDD", "TDT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_arrow_l), "TTT", "DDT", "TDT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_arrow_rl), "TTT", "DDD", "TDT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_arrow_sr), "TDT", "TDD", "TDT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_arrow_sl), "TDT", "DDT", "TDT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_arrow_srl), "TDT", "DDD", "TDT", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_white_quarter), "TTT", "TDD", "TDD", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_white_half), "TTT", "DDD", "DDD", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_white), "DDD", "DDD", "DDD", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapedRecipe(new ItemStack(RoadBlocks.road_crosswalk), "DDD", "TTT", "DDD", 'T', RoadItems.item_tar, 'D', new ItemStack(Items.DYE, 1, 15));
		
	}
}
