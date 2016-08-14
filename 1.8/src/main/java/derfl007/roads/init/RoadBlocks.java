package derfl007.roads.init;

import derfl007.roads.Reference;
import derfl007.roads.blocks.BlockRoad;
import derfl007.roads.blocks.BlockRoadGuardrail;
import derfl007.roads.blocks.BlockRoadLantern;
import derfl007.roads.blocks.BlockRoadLine;
import derfl007.roads.blocks.BlockRoadRotatable;
import derfl007.roads.blocks.BlockRoadSidewalkCurb;
import derfl007.roads.blocks.BlockRoadSign;
import derfl007.roads.blocks.BlockRoadSignPost;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RoadBlocks {

	public static Block road, //
			road_white, //
			road_white_half, //
			road_white_quarter, //
			road_line, //
			road_line_merge, //
			road_line_double, //
			road_line_diagonal, //
			road_arrow_s, //
			road_arrow_r, //
			road_arrow_l, //
			road_arrow_rl, //
			road_arrow_sr, road_arrow_sl, //
			road_arrow_srl, //
			road_crosswalk, //
			road_excl_zone, //
			road_excl_zone_line, //
			road_excl_zone_corner_in, //
			road_excl_zone_corner_out, //
			road_excl_zone_diagonal_in, //
			road_excl_zone_diagonal_out, //
			road_excl_zone_split_in_r, //
			road_excl_zone_split_in_l, //
			road_excl_zone_split_out_r, //
			road_excl_zone_split_out_l, //
			road_sign_post, //
			road_sign_prohib_1, // closed in both directions for all vehicles
			road_sign_prohib_2, // no entry
			road_sign_prohib_3a, // no left turn
			road_sign_prohib_3b, // no right turn
			road_sign_prohib_3c, // no u-turn
			road_sign_prohib_4a, // no overtaking
			road_sign_prohib_4b, // end of overtaking restriction
			road_sign_prohib_10a_20, // speed sign 20
			road_sign_prohib_10a_30, // speed sign 30
			road_sign_prohib_10a_40, // speed sign 40
			road_sign_prohib_10a_50, // speed sign 50
			road_sign_prohib_10a_60, // speed sign 60
			road_sign_prohib_10a_70, // speed sign 70
			road_sign_prohib_10a_80, // speed sign 80
			road_sign_prohib_10a_100, // speed sign 100
			road_sign_prohib_10b_20, // end speed sign 20
			road_sign_prohib_10b_30, // end speed sign 30
			road_sign_prohib_10b_40, // end speed sign 40
			road_sign_prohib_10b_50, // end speed sign 50
			road_sign_prohib_10b_60, // end speed sign 60
			road_sign_prohib_10b_70, // end speed sign 70
			road_sign_prohib_10b_80, // end speed sign 80
			road_sign_prohib_10b_100, // end speed sign 100
			road_sign_warn_1, // uneven road
			road_sign_warn_2a, // dangerous right curve
			road_sign_warn_2b, // dangerous left curve
			road_sign_warn_2c, // dangerous curves, first right
			road_sign_warn_2d, // dangerous curves, first left
			road_sign_warn_3a, // junction
			road_sign_warn_3b, // junction with roundabout
			road_sign_warn_4, // crossroad with non-priority road
			road_sign_warn_8a, // road narrows on both sides
			road_sign_warn_8b, // road narrows from left
			road_sign_warn_8c, // road narrows from right
			road_sign_warn_9, // road works
			road_sign_warn_10a, // slippery road
			road_sign_warn_10b, // crosswind
			road_sign_warn_10c, // falling rocks
			road_sign_warn_11a, // pedestrian crossing
			road_sign_warn_11b, // cyclist crossing
			road_sign_warn_12, // children
			road_sign_warn_13, // animals
			road_sign_warn_14, // two-way traffic
			road_sign_warn_15, // traffic signals
			road_sign_warn_16, // other dangers
			road_sign_mandat_1, // left only
			road_sign_mandat_2, // right only
			road_sign_mandat_3, // straight only
			road_sign_mandat_4, // turn left
			road_sign_mandat_5, // turn right
			road_sign_mandat_6, // turn left or go straight
			road_sign_mandat_7, // turn right or go straight
			road_sign_mandat_8, // turn left or right
			road_sign_mandat_9, // follow left lane
			road_sign_mandat_10, // follow right lane
			road_sign_priority_1, // give way
			road_sign_priority_2, // stop
			road_sign_priority_3a, // priority road
			road_sign_priority_3b, // end of priority road
			road_sign_info_1a, // parking lot or parking lane
			road_sign_info_1b, // parking lot
			road_sign_info_8a, // expressway
			road_sign_info_8b, // end of expressway
			road_sign_info_8c, // motor road
			road_sign_info_8d, // end of motor road
			road_sign_info_9a, // pedestrian zone
			road_sign_info_9b, // end of pedestrian zone
			road_sign_info_10a, // one-way left
			road_sign_info_10b, // one-way right
			road_sign_info_11, // dead end
			road_sign_info_16a, // detour right
			road_sign_info_16b, // detour left
			road_sign_info_23, // two lanes merge into one
			road_guardrail, //
			road_sidewalk_curb, //
			road_lantern, //
			road_traffic_light, //
			road_pedestrian_traffic_light; //

	public static void init() {
		road = new BlockRoad("road");
		road_white = new BlockRoad("road_white");
		road_white_half = new BlockRoadRotatable("road_white_half");
		road_white_quarter = new BlockRoadRotatable("road_white_quarter");
		road_line = new BlockRoadLine();
		road_line_merge = new BlockRoadRotatable("road_line_merge");
		road_line_double = new BlockRoadRotatable("road_line_double");
		road_line_diagonal = new BlockRoadRotatable("road_line_diagonal");
		road_arrow_s = new BlockRoadRotatable("road_arrow_s");
		road_arrow_r = new BlockRoadRotatable("road_arrow_r");
		road_arrow_l = new BlockRoadRotatable("road_arrow_l");
		road_arrow_rl = new BlockRoadRotatable("road_arrow_rl");
		road_arrow_sr = new BlockRoadRotatable("road_arrow_sr");
		road_arrow_sl = new BlockRoadRotatable("road_arrow_sl");
		road_arrow_srl = new BlockRoadRotatable("road_arrow_srl");
		road_crosswalk = new BlockRoadRotatable("road_crosswalk");
		road_excl_zone = new BlockRoad("road_excl_zone");
		road_excl_zone_line = new BlockRoadRotatable("road_excl_zone_line");
		road_excl_zone_corner_in = new BlockRoadRotatable("road_excl_zone_corner_in");
		road_excl_zone_corner_out = new BlockRoadRotatable("road_excl_zone_corner_out");
		road_excl_zone_diagonal_in = new BlockRoadRotatable("road_excl_zone_diagonal_in");
		road_excl_zone_diagonal_out = new BlockRoadRotatable("road_excl_zone_diagonal_out");
		road_excl_zone_split_in_r = new BlockRoadRotatable("road_excl_zone_split_in_r");
		road_excl_zone_split_in_l = new BlockRoadRotatable("road_excl_zone_split_in_l");
		road_excl_zone_split_out_r = new BlockRoadRotatable("road_excl_zone_split_out_r");
		road_excl_zone_split_out_l = new BlockRoadRotatable("road_excl_zone_split_out_l");
		road_sign_post = new BlockRoadSignPost();
		road_sign_prohib_1 = new BlockRoadSign("road_sign_prohib_1");
		road_sign_prohib_2 = new BlockRoadSign("road_sign_prohib_2");
		road_sign_prohib_3a = new BlockRoadSign("road_sign_prohib_3a");
		road_sign_prohib_3b = new BlockRoadSign("road_sign_prohib_3b");
		road_sign_prohib_3c = new BlockRoadSign("road_sign_prohib_3c");
		road_sign_prohib_4a = new BlockRoadSign("road_sign_prohib_4a");
		road_sign_prohib_4b = new BlockRoadSign("road_sign_prohib_4b");
		road_sign_prohib_10a_20 = new BlockRoadSign("road_sign_prohib_10a_20");
		road_sign_prohib_10a_30 = new BlockRoadSign("road_sign_prohib_10a_30");
		road_sign_prohib_10a_40 = new BlockRoadSign("road_sign_prohib_10a_40");
		road_sign_prohib_10a_50 = new BlockRoadSign("road_sign_prohib_10a_50");
		road_sign_prohib_10a_60 = new BlockRoadSign("road_sign_prohib_10a_60");
		road_sign_prohib_10a_70 = new BlockRoadSign("road_sign_prohib_10a_70");
		road_sign_prohib_10a_80 = new BlockRoadSign("road_sign_prohib_10a_80");
		road_sign_prohib_10a_100 = new BlockRoadSign("road_sign_prohib_10a_100");
		road_sign_prohib_10b_20 = new BlockRoadSign("road_sign_prohib_10b_20");
		road_sign_prohib_10b_30 = new BlockRoadSign("road_sign_prohib_10b_30");
		road_sign_prohib_10b_40 = new BlockRoadSign("road_sign_prohib_10b_40");
		road_sign_prohib_10b_50 = new BlockRoadSign("road_sign_prohib_10b_50");
		road_sign_prohib_10b_60 = new BlockRoadSign("road_sign_prohib_10b_60");
		road_sign_prohib_10b_70 = new BlockRoadSign("road_sign_prohib_10b_70");
		road_sign_prohib_10b_80 = new BlockRoadSign("road_sign_prohib_10b_80");
		road_sign_prohib_10b_100 = new BlockRoadSign("road_sign_prohib_10b_100");
		road_sign_warn_1 = new BlockRoadSign("road_sign_warn_1");
		road_sign_warn_2a = new BlockRoadSign("road_sign_warn_2a");
		road_sign_warn_2b = new BlockRoadSign("road_sign_warn_2b");
		road_sign_warn_2c = new BlockRoadSign("road_sign_warn_2c");
		road_sign_warn_2d = new BlockRoadSign("road_sign_warn_2d");
		road_sign_warn_3a = new BlockRoadSign("road_sign_warn_3a");
		road_sign_warn_3b = new BlockRoadSign("road_sign_warn_3b");
		road_sign_warn_4 = new BlockRoadSign("road_sign_warn_4");
		road_sign_warn_8a = new BlockRoadSign("road_sign_warn_8a");
		road_sign_warn_8b = new BlockRoadSign("road_sign_warn_8b");
		road_sign_warn_8c = new BlockRoadSign("road_sign_warn_8c");
		road_sign_warn_9 = new BlockRoadSign("road_sign_warn_9");
		road_sign_warn_10a = new BlockRoadSign("road_sign_warn_10a");
		road_sign_warn_10b = new BlockRoadSign("road_sign_warn_10b");
		road_sign_warn_10c = new BlockRoadSign("road_sign_warn_10c");
		road_sign_warn_11a = new BlockRoadSign("road_sign_warn_11a");
		road_sign_warn_11b = new BlockRoadSign("road_sign_warn_11b");
		road_sign_warn_12 = new BlockRoadSign("road_sign_warn_12");
		road_sign_warn_13 = new BlockRoadSign("road_sign_warn_13");
		road_sign_warn_14 = new BlockRoadSign("road_sign_warn_14");
		road_sign_warn_15 = new BlockRoadSign("road_sign_warn_15");
		road_sign_warn_16 = new BlockRoadSign("road_sign_warn_16");
		road_sign_mandat_1 = new BlockRoadSign("road_sign_mandat_1");
		road_sign_mandat_2 = new BlockRoadSign("road_sign_mandat_2");
		road_sign_mandat_3 = new BlockRoadSign("road_sign_mandat_3");
		road_sign_mandat_4 = new BlockRoadSign("road_sign_mandat_4");
		road_sign_mandat_5 = new BlockRoadSign("road_sign_mandat_5");
		road_sign_mandat_6 = new BlockRoadSign("road_sign_mandat_6");
		road_sign_mandat_7 = new BlockRoadSign("road_sign_mandat_7");
		road_sign_mandat_8 = new BlockRoadSign("road_sign_mandat_8");
		road_sign_mandat_9 = new BlockRoadSign("road_sign_mandat_9");
		road_sign_mandat_10 = new BlockRoadSign("road_sign_mandat_10");
		road_sign_priority_1 = new BlockRoadSign("road_sign_priority_1");
		road_sign_priority_2 = new BlockRoadSign("road_sign_priority_2");
		road_sign_priority_3a = new BlockRoadSign("road_sign_priority_3a");
		road_sign_priority_3b = new BlockRoadSign("road_sign_priority_3b");
		road_sign_info_1a = new BlockRoadSign("road_sign_info_1a");
		road_sign_info_1b = new BlockRoadSign("road_sign_info_1b");
		road_sign_info_8a = new BlockRoadSign("road_sign_info_8a");
		road_sign_info_8b = new BlockRoadSign("road_sign_info_8b");
		road_sign_info_8c = new BlockRoadSign("road_sign_info_8c");
		road_sign_info_8d = new BlockRoadSign("road_sign_info_8d");
		road_sign_info_9a = new BlockRoadSign("road_sign_info_9a");
		road_sign_info_9b = new BlockRoadSign("road_sign_info_9b");
		road_sign_info_10a = new BlockRoadSign("road_sign_info_10a");
		road_sign_info_10b = new BlockRoadSign("road_sign_info_10b");
		road_sign_info_11 = new BlockRoadSign("road_sign_info_11");
		road_sign_info_16a = new BlockRoadSign("road_sign_info_16a");
		road_sign_info_16b = new BlockRoadSign("road_sign_info_16b");
		road_sign_info_23 = new BlockRoadSign("road_sign_info_23");
		road_guardrail = new BlockRoadGuardrail();
		road_sidewalk_curb = new BlockRoadSidewalkCurb();
		road_lantern = new BlockRoadLantern();
		road_traffic_light = new BlockRoadSign("road_traffic_light");
		road_pedestrian_traffic_light = new BlockRoadSign("road_pedestrian_traffic_light");
	}

	public static void register() {
		registerBlock(road);
		registerBlock(road_white);
		registerBlock(road_white_half);
		registerBlock(road_white_quarter);
		registerBlock(road_line);
		registerBlock(road_line_merge);
		registerBlock(road_line_double);
		registerBlock(road_line_diagonal);
		registerBlock(road_arrow_s);
		registerBlock(road_arrow_r);
		registerBlock(road_arrow_l);
		registerBlock(road_arrow_rl);
		registerBlock(road_arrow_sr);
		registerBlock(road_arrow_sl);
		registerBlock(road_arrow_srl);
		registerBlock(road_crosswalk);
		registerBlock(road_excl_zone);
		registerBlock(road_excl_zone_line);
		registerBlock(road_excl_zone_corner_in);
		registerBlock(road_excl_zone_corner_out);
		registerBlock(road_excl_zone_diagonal_in);
		registerBlock(road_excl_zone_diagonal_out);
		registerBlock(road_excl_zone_split_in_l);
		registerBlock(road_excl_zone_split_in_r);
		registerBlock(road_excl_zone_split_out_l);
		registerBlock(road_excl_zone_split_out_r);
		registerBlock(road_sign_post);
		registerBlock(road_sign_prohib_1);
		registerBlock(road_sign_prohib_2);
		registerBlock(road_sign_prohib_3a);
		registerBlock(road_sign_prohib_3b);
		registerBlock(road_sign_prohib_3c);
		registerBlock(road_sign_prohib_4a);
		registerBlock(road_sign_prohib_4b);
		registerBlock(road_sign_prohib_10a_20);
		registerBlock(road_sign_prohib_10a_30);
		registerBlock(road_sign_prohib_10a_40);
		registerBlock(road_sign_prohib_10a_50);
		registerBlock(road_sign_prohib_10a_60);
		registerBlock(road_sign_prohib_10a_70);
		registerBlock(road_sign_prohib_10a_80);
		registerBlock(road_sign_prohib_10a_100);
		registerBlock(road_sign_prohib_10b_20);
		registerBlock(road_sign_prohib_10b_30);
		registerBlock(road_sign_prohib_10b_40);
		registerBlock(road_sign_prohib_10b_50);
		registerBlock(road_sign_prohib_10b_60);
		registerBlock(road_sign_prohib_10b_70);
		registerBlock(road_sign_prohib_10b_80);
		registerBlock(road_sign_prohib_10b_100);
		registerBlock(road_sign_warn_1);
		registerBlock(road_sign_warn_2a);
		registerBlock(road_sign_warn_2b);
		registerBlock(road_sign_warn_2c);
		registerBlock(road_sign_warn_2d);
		registerBlock(road_sign_warn_3a);
		registerBlock(road_sign_warn_3b);
		registerBlock(road_sign_warn_4);
		registerBlock(road_sign_warn_8a);
		registerBlock(road_sign_warn_8b);
		registerBlock(road_sign_warn_8c);
		registerBlock(road_sign_warn_9);
		registerBlock(road_sign_warn_10a);
		registerBlock(road_sign_warn_10b);
		registerBlock(road_sign_warn_10c);
		registerBlock(road_sign_warn_11a);
		registerBlock(road_sign_warn_11b);
		registerBlock(road_sign_warn_12);
		registerBlock(road_sign_warn_13);
		registerBlock(road_sign_warn_14);
		registerBlock(road_sign_warn_15);
		registerBlock(road_sign_warn_16);
		registerBlock(road_sign_mandat_1);
		registerBlock(road_sign_mandat_2);
		registerBlock(road_sign_mandat_3);
		registerBlock(road_sign_mandat_4);
		registerBlock(road_sign_mandat_5);
		registerBlock(road_sign_mandat_6);
		registerBlock(road_sign_mandat_7);
		registerBlock(road_sign_mandat_8);
		registerBlock(road_sign_mandat_9);
		registerBlock(road_sign_mandat_10);
		registerBlock(road_sign_priority_1);
		registerBlock(road_sign_priority_2);
		registerBlock(road_sign_priority_3a);
		registerBlock(road_sign_priority_3b);
		registerBlock(road_sign_info_1a);
		registerBlock(road_sign_info_1b);
		registerBlock(road_sign_info_8a);
		registerBlock(road_sign_info_8b);
		registerBlock(road_sign_info_8c);
		registerBlock(road_sign_info_8d);
		registerBlock(road_sign_info_9a);
		registerBlock(road_sign_info_9b);
		registerBlock(road_sign_info_10a);
		registerBlock(road_sign_info_10b);
		registerBlock(road_sign_info_11);
		registerBlock(road_sign_info_16a);
		registerBlock(road_sign_info_16b);
		registerBlock(road_sign_info_23);
		registerBlock(road_guardrail);
		registerBlock(road_sidewalk_curb);
		registerBlock(road_lantern);
		registerBlock(road_traffic_light);
		registerBlock(road_pedestrian_traffic_light);
	}

	private static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(road);
		registerRender(road_white);
		registerRender(road_white_half);
		registerRender(road_white_quarter);
		registerRender(road_line);
		registerRender(road_line_merge);
		registerRender(road_line_double);
		registerRender(road_line_diagonal);
		registerRender(road_arrow_s);
		registerRender(road_arrow_r);
		registerRender(road_arrow_l);
		registerRender(road_arrow_rl);
		registerRender(road_arrow_sr);
		registerRender(road_arrow_sl);
		registerRender(road_arrow_srl);
		registerRender(road_crosswalk);
		registerRender(road_excl_zone);
		registerRender(road_excl_zone_line);
		registerRender(road_excl_zone_corner_in);
		registerRender(road_excl_zone_corner_out);
		registerRender(road_excl_zone_diagonal_in);
		registerRender(road_excl_zone_diagonal_out);
		registerRender(road_excl_zone_split_in_l);
		registerRender(road_excl_zone_split_in_r);
		registerRender(road_excl_zone_split_out_l);
		registerRender(road_excl_zone_split_out_r);
		registerRender(road_sign_post);
		registerRender(road_sign_prohib_1);
		registerRender(road_sign_prohib_2);
		registerRender(road_sign_prohib_3a);
		registerRender(road_sign_prohib_3b);
		registerRender(road_sign_prohib_3c);
		registerRender(road_sign_prohib_4a);
		registerRender(road_sign_prohib_4b);
		registerRender(road_sign_prohib_10a_20);
		registerRender(road_sign_prohib_10a_30);
		registerRender(road_sign_prohib_10a_40);
		registerRender(road_sign_prohib_10a_50);
		registerRender(road_sign_prohib_10a_60);
		registerRender(road_sign_prohib_10a_70);
		registerRender(road_sign_prohib_10a_80);
		registerRender(road_sign_prohib_10a_100);
		registerRender(road_sign_prohib_10b_20);
		registerRender(road_sign_prohib_10b_30);
		registerRender(road_sign_prohib_10b_40);
		registerRender(road_sign_prohib_10b_50);
		registerRender(road_sign_prohib_10b_60);
		registerRender(road_sign_prohib_10b_70);
		registerRender(road_sign_prohib_10b_80);
		registerRender(road_sign_prohib_10b_100);
		registerRender(road_sign_warn_1);
		registerRender(road_sign_warn_2a);
		registerRender(road_sign_warn_2b);
		registerRender(road_sign_warn_2c);
		registerRender(road_sign_warn_2d);
		registerRender(road_sign_warn_3a);
		registerRender(road_sign_warn_3b);
		registerRender(road_sign_warn_4);
		registerRender(road_sign_warn_8a);
		registerRender(road_sign_warn_8b);
		registerRender(road_sign_warn_8c);
		registerRender(road_sign_warn_9);
		registerRender(road_sign_warn_10a);
		registerRender(road_sign_warn_10b);
		registerRender(road_sign_warn_10c);
		registerRender(road_sign_warn_11a);
		registerRender(road_sign_warn_11b);
		registerRender(road_sign_warn_12);
		registerRender(road_sign_warn_13);
		registerRender(road_sign_warn_14);
		registerRender(road_sign_warn_15);
		registerRender(road_sign_warn_16);
		registerRender(road_sign_mandat_1);
		registerRender(road_sign_mandat_2);
		registerRender(road_sign_mandat_3);
		registerRender(road_sign_mandat_4);
		registerRender(road_sign_mandat_5);
		registerRender(road_sign_mandat_6);
		registerRender(road_sign_mandat_7);
		registerRender(road_sign_mandat_8);
		registerRender(road_sign_mandat_9);
		registerRender(road_sign_mandat_10);
		registerRender(road_sign_priority_1);
		registerRender(road_sign_priority_2);
		registerRender(road_sign_priority_3a);
		registerRender(road_sign_priority_3b);
		registerRender(road_sign_info_1a);
		registerRender(road_sign_info_1b);
		registerRender(road_sign_info_8a);
		registerRender(road_sign_info_8b);
		registerRender(road_sign_info_8c);
		registerRender(road_sign_info_8d);
		registerRender(road_sign_info_9a);
		registerRender(road_sign_info_9b);
		registerRender(road_sign_info_10a);
		registerRender(road_sign_info_10b);
		registerRender(road_sign_info_11);
		registerRender(road_sign_info_16a);
		registerRender(road_sign_info_16b);
		registerRender(road_sign_info_23);
		registerRender(road_guardrail);
		registerRender(road_sidewalk_curb);
		registerRender(road_lantern);
		registerRender(road_traffic_light);
		registerRender(road_pedestrian_traffic_light);
	}

	private static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
