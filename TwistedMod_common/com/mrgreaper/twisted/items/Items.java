package com.mrgreaper.twisted.items;

import com.mrgreaper.twisted.config.configInfo;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item bunnyd;
	public static Item bunnya;
	public static Item orphantear;
	public static Item deathorb;
	public static Item bunnye;
	public static Item balloonr;
	public static Item orphanleg;
	//public static Item bunnys;
	
	public static void init() {
		bunnyd = new itemBunnyD(ItemInfo.BUNNYD_ID);
		bunnye = new ItemBunnyE(ItemInfo.BUNNYE_ID);
		bunnya = new ItemBunnyA(ItemInfo.BUNNYA_ID);
		orphantear = new itemOrphanTear(ItemInfo.ORPHANTEAR_ID);
		deathorb = new ItemDeathOrb(ItemInfo.DEATHORB_ID);
		balloonr = new ItemBalloonR(ItemInfo.BALLOONR_ID);
		orphanleg = new ItemOrphanLeg(ItemInfo.ORPHANLEG_ID, 2, true);
		
		//bunnys = new ItemBunnyS(ItemInfo.BUNNYS_ID, 0, 0, false);
	}
	public static void addNames() {
		LanguageRegistry.addName(bunnyd, ItemInfo.BUNNYD_NAME);
		LanguageRegistry.addName(bunnya, ItemInfo.BUNNYA_NAME);
		LanguageRegistry.addName(bunnye, ItemInfo.BUNNYE_NAME);
		LanguageRegistry.addName(orphantear, ItemInfo.ORPHANTEAR_NAME);
		LanguageRegistry.addName(deathorb, ItemInfo.DEATHORB_NAME);
		LanguageRegistry.addName(balloonr, ItemInfo.BALLOONR_NAME);
		LanguageRegistry.addName(orphanleg, ItemInfo.ORPHANLEG_NAME);
		//LanguageRegistry.addName(bunnys, ItemInfo.BUNNYS_NAME);
		

}
}