package com.mrgreaper.twisted.items;

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
		//orphanleg= new 
		
		//bunnys = new ItemBunnyS(ItemInfo.BUNNYS_ID, 0, 0, false);
	}
	
	
	public static void addNames() {
		LanguageRegistry.addName(bunnyd, ItemInfo.BUNNYD_NAME);
		LanguageRegistry.addName(bunnya, ItemInfo.BUNNYA_NAME);
		LanguageRegistry.addName(bunnye, ItemInfo.BUNNYE_NAME);
		LanguageRegistry.addName(orphantear, ItemInfo.ORPHANTEAR_NAME);
		LanguageRegistry.addName(deathorb, ItemInfo.DEATHORB_NAME);
		LanguageRegistry.addName(balloonr, ItemInfo.BALLOONR_NAME);
		//LanguageRegistry.addName(bunnys, ItemInfo.BUNNYS_NAME);
		
/*		for (int i = 0; i < ItemInfo.CARD_NAMES.length; i++) {
			LanguageRegistry.addName(new ItemStack(card,  1, i), ItemInfo.CARD_NAMES[i]);
		}*/
	}
	//GameRegistry.addRecipe(new ItemStack(wand, 10) would make 10
	public static void registerRecipes() {
/*		GameRegistry.addRecipe(new ItemStack(wand),//output item
			new Object[] { 	"  X",//crafting grid
							" / ",
							"/  ",
							
							'X', Item.goldenCarrot, //items used in the above list
							'/', Item.stick 
						 });	*/	
		//my recipes
		GameRegistry.addRecipe(new ItemStack(bunnyd),//output item
				new Object[] { 	"D D",//crafting grid
								" C ",
								"D D",
								
								'D', Block.dirt, //items used in the above list
								'C', Item.carrot 
							 });	
		GameRegistry.addRecipe(new ItemStack(bunnya),//output item
				new Object[] { 	"  D",//crafting grid
								" C ",
								"  D",
								
								'D', Block.dirt, //items used in the above list
								'C', Item.carrot 
							 });
		
		
		//smelting recipies
		GameRegistry.addSmelting(Items.bunnyd.itemID ,new ItemStack(bunnya) , 0.1f);
		
		//from craft
		GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.leather), 0.1f);
		
		//other mod helpers
	}
}