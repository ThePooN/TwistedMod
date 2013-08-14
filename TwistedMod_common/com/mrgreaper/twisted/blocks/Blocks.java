package com.mrgreaper.twisted.blocks;



import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;
import com.mrgreaper.twisted.tileentities.TileEntityStaticGen;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static BlockPoison poison;
    public static BlockRebunnyator rebunnyator;
    public static BlockStaticGen staticgen;
    public static BlockAlarm alarm;
    public static BlockGeorgeSkull georgeskull;
	
	public static void init() {
		
		poison = new BlockPoison(BlockInfo.POISON_ID); //from vswe tutorial, kept in at mo as a live example while i dev
		GameRegistry.registerBlock(poison, BlockInfo.POISON_KEY); 
		
		rebunnyator = new BlockRebunnyator(BlockInfo.REBUNNYATOR_ID);
		GameRegistry.registerBlock(rebunnyator, BlockInfo.REBUNNYATOR_KEY); 
		
		staticgen = new BlockStaticGen(BlockInfo.STATICGEN_ID);
		GameRegistry.registerBlock(staticgen, BlockInfo.STATICGEN_KEY); 
		
		alarm = new BlockAlarm(BlockInfo.ALARM_ID);
		GameRegistry.registerBlock(alarm, BlockInfo.ALARM_KEY);
		
		georgeskull = new BlockGeorgeSkull(BlockInfo.GEORGESKULL_ID);
		GameRegistry.registerBlock(georgeskull, BlockInfo.GEORGESKULL_KEY);
		
	}
	
	
	public static void addNames() {
		
		LanguageRegistry.addName(poison, BlockInfo.POISON_NAME);
		
		//added by me bellow
		LanguageRegistry.addName(rebunnyator, BlockInfo.REBUNNYATOR_NAME);
		LanguageRegistry.addName(staticgen, BlockInfo.STATICGEN_NAME);
		LanguageRegistry.addName(alarm, BlockInfo.ALARM_NAME);
		LanguageRegistry.addName(georgeskull, BlockInfo.GEORGESKULL_NAME);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityRebunnyator.class, BlockInfo.REBUNNYATOR_TE_key);
		GameRegistry.registerTileEntity(TileEntityStaticGen.class, BlockInfo.STATICGEN_TE_key);
	}
}