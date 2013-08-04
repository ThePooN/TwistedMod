package com.mrgreaper.twisted.blocks;



import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;
import com.mrgreaper.twisted.tileentities.TileEntityStaticGen;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static BlockPoison poison;

public static BlockRebunnyator rebunnyator;
public static BlockStaticGen staticgen;
	
	public static void init() {
		
		poison = new BlockPoison(BlockInfo.POISON_ID);
		GameRegistry.registerBlock(poison, BlockInfo.POISON_KEY); 
		
		//added by me bellow
		rebunnyator = new BlockRebunnyator(BlockInfo.REBUNNYATOR_ID);
		GameRegistry.registerBlock(rebunnyator, BlockInfo.REBUNNYATOR_KEY); 
		
		staticgen = new BlockStaticGen(BlockInfo.STATICGEN_ID);
		GameRegistry.registerBlock(staticgen, BlockInfo.STATICGEN_KEY); 
	}
	
	
	public static void addNames() {
		
		LanguageRegistry.addName(poison, BlockInfo.POISON_NAME);
		
		//added by me bellow
		LanguageRegistry.addName(rebunnyator, BlockInfo.REBUNNYATOR_NAME);
		LanguageRegistry.addName(staticgen, BlockInfo.STATICGEN_NAME);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityRebunnyator.class, BlockInfo.REBUNNYATOR_TE_key);
		GameRegistry.registerTileEntity(TileEntityStaticGen.class, BlockInfo.STATICGEN_TE_key);
	}
}