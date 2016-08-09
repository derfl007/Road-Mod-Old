package derfl007.roads.init;

import derfl007.roads.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
			road_lantern;

	public static void init() {
		road = new BlockRoad();
		road_white = new BlockRoadWhite();
		road_white_half = new BlockRoadWhiteHalf();
		road_white_quarter = new BlockRoadWhiteQuarter();
		road_line = new BlockRoadLine();
		road_line_merge = new BlockRoadLineMerge();
		road_line_double = new BlockRoadLineDouble();
		road_line_diagonal = new BlockRoadLineDiagonal();
		road_arrow_s = new BlockRoadArrowS();
		road_arrow_r = new BlockRoadArrowR();
		road_arrow_l = new BlockRoadArrowL();
		road_arrow_rl = new BlockRoadArrowRL();
		road_arrow_sr = new BlockRoadArrowSR();
		road_arrow_sl = new BlockRoadArrowSL();
		road_arrow_srl = new BlockRoadArrowSRL();
		road_crosswalk = new BlockRoadCrosswalk();
		road_excl_zone = new BlockRoadExclZone();
		road_excl_zone_line = new BlockRoadExclZoneLine();
		road_excl_zone_corner_in = new BlockRoadExclZoneCornerIn();
		road_excl_zone_corner_out = new BlockRoadExclZoneCornerOut();
		road_excl_zone_diagonal_in = new BlockRoadExclZoneDiagonalIn();
		road_excl_zone_diagonal_out = new BlockRoadExclZoneDiagonalOut();
		road_excl_zone_split_in_r = new BlockRoadExclZoneSplitInR();
		road_excl_zone_split_in_l = new BlockRoadExclZoneSplitInL();
		road_excl_zone_split_out_r = new BlockRoadExclZoneSplitOutR();
		road_excl_zone_split_out_l = new BlockRoadExclZoneSplitOutL();
		road_sign_post = new BlockRoadSignPost();
		road_sign_prohib_1 = new BlockRoadSignProhib1();
		road_sign_prohib_2 = new BlockRoadSignProhib2();
		road_sign_prohib_3a = new BlockRoadSignProhib3a();
		road_sign_prohib_3b = new BlockRoadSignProhib3b();
		road_sign_prohib_3c = new BlockRoadSignProhib3c();
		road_sign_prohib_4a = new BlockRoadSignProhib4a();
		road_sign_prohib_4b = new BlockRoadSignProhib4b();
		road_sign_prohib_10a_20 = new BlockRoadSignProhib10a20();
		road_sign_prohib_10a_30 = new BlockRoadSignProhib10a30();
		road_sign_prohib_10a_40 = new BlockRoadSignProhib10a40();
		road_sign_prohib_10a_50 = new BlockRoadSignProhib10a50();
		road_sign_prohib_10a_60 = new BlockRoadSignProhib10a60();
		road_sign_prohib_10a_70 = new BlockRoadSignProhib10a70();
		road_sign_prohib_10a_80 = new BlockRoadSignProhib10a80();
		road_sign_prohib_10a_100 = new BlockRoadSignProhib10a100();
		road_sign_prohib_10b_20 = new BlockRoadSignProhib10b20();
		road_sign_prohib_10b_30 = new BlockRoadSignProhib10b30();
		road_sign_prohib_10b_40 = new BlockRoadSignProhib10b40();
		road_sign_prohib_10b_50 = new BlockRoadSignProhib10b50();
		road_sign_prohib_10b_60 = new BlockRoadSignProhib10b60();
		road_sign_prohib_10b_70 = new BlockRoadSignProhib10b70();
		road_sign_prohib_10b_80 = new BlockRoadSignProhib10b80();
		road_sign_prohib_10b_100 = new BlockRoadSignProhib10b100();
		road_sign_warn_1 = new BlockRoadSignWarn1();
		road_sign_warn_2a = new BlockRoadSignWarn2a();
		road_sign_warn_2b = new BlockRoadSignWarn2b();
		road_sign_warn_2c = new BlockRoadSignWarn2c();
		road_sign_warn_2d = new BlockRoadSignWarn2d();
		road_sign_warn_3a = new BlockRoadSignWarn3a();
		road_sign_warn_3b = new BlockRoadSignWarn3b();
		road_sign_warn_4 = new BlockRoadSignWarn4();
		road_sign_warn_8a = new BlockRoadSignWarn8a();
		road_sign_warn_8b = new BlockRoadSignWarn8b();
		road_sign_warn_8c = new BlockRoadSignWarn8c();
		road_sign_warn_9 = new BlockRoadSignWarn9();
		road_sign_warn_10a = new BlockRoadSignWarn10a();
		road_sign_warn_10b = new BlockRoadSignWarn10b();
		road_sign_warn_10c = new BlockRoadSignWarn10c();
		road_sign_warn_11a = new BlockRoadSignWarn11a();
		road_sign_warn_11b = new BlockRoadSignWarn11b();
		road_sign_warn_12 = new BlockRoadSignWarn12();
		road_sign_warn_13 = new BlockRoadSignWarn13();
		road_sign_warn_14 = new BlockRoadSignWarn14();
		road_sign_warn_15 = new BlockRoadSignWarn15();
		road_sign_warn_16 = new BlockRoadSignWarn16();
		road_sign_mandat_1 = new BlockRoadSignMandat1();
		road_sign_mandat_2 = new BlockRoadSignMandat2();
		road_sign_mandat_3 = new BlockRoadSignMandat3();
		road_sign_mandat_4 = new BlockRoadSignMandat4();
		road_sign_mandat_5 = new BlockRoadSignMandat5();
		road_sign_mandat_6 = new BlockRoadSignMandat6();
		road_sign_mandat_7 = new BlockRoadSignMandat7();
		road_sign_mandat_8 = new BlockRoadSignMandat8();
		road_sign_mandat_9 = new BlockRoadSignMandat9();
		road_sign_mandat_10 = new BlockRoadSignMandat10();
		road_sign_priority_1 = new BlockRoadSignPriority1();
		road_sign_priority_2 = new BlockRoadSignPriority2();
		road_sign_priority_3a = new BlockRoadSignPriority3a();
		road_sign_priority_3b = new BlockRoadSignPriority3b();
		road_sign_info_1a = new BlockRoadSignInfo1a();
		road_sign_info_1b = new BlockRoadSignInfo1b();
		road_sign_info_8a = new BlockRoadSignInfo8a();
		road_sign_info_8b = new BlockRoadSignInfo8b();
		road_sign_info_8c = new BlockRoadSignInfo8c();
		road_sign_info_8d = new BlockRoadSignInfo8d();
		road_sign_info_9a = new BlockRoadSignInfo9a();
		road_sign_info_9b = new BlockRoadSignInfo9b();
		road_sign_info_10a = new BlockRoadSignInfo10a();
		road_sign_info_10b = new BlockRoadSignInfo10b();
		road_sign_info_11 = new BlockRoadSignInfo11();
		road_sign_info_16a = new BlockRoadSignInfo16a();
		road_sign_info_16b = new BlockRoadSignInfo16b();
		road_sign_info_23 = new BlockRoadSignInfo23();
		road_guardrail = new BlockRoadGuardrail();
		road_sidewalk_curb = new BlockRoadSidewalkCurb();
		road_lantern = new BlockRoadLantern();
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
	}

	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
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
	}

	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
