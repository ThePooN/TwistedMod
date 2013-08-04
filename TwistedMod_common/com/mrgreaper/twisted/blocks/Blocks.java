package com.mrgreaper.twisted.blocks;


import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static BlockPoison poison;

public static BlockRebunnyator rebunnyator;
	
	public static void init() {
		
		poison = new BlockPoison(BlockInfo.POISON_ID);
		GameRegistry.registerBlock(poison, BlockInfo.POISON_KEY); 
		
		//added by me bellow
		rebunnyator = new BlockRebunnyator(BlockInfo.REBUNNYATOR_ID);
		GameRegistry.registerBlock(rebunnyator, BlockInfo.REBUNNYATOR_KEY); 
	}
	
	
	public static void addNames() {
		
		LanguageRegistry.addName(poison, BlockInfo.POISON_NAME);
		
		//added by me bellow
		LanguageRegistry.addName(rebunnyator, BlockInfo.REBUNNYATOR_NAME);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityRebunnyator.class, BlockInfo.REBUNNYATOR_TE_key);
	}
}