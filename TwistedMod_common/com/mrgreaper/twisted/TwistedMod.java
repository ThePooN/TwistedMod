package com.mrgreaper.twisted;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.mrgreaper.twisted.blocks.Blocks;

import com.mrgreaper.twisted.client.interfaces.GuiHandler;
import com.mrgreaper.twisted.config.ConfigHandler;
import com.mrgreaper.twisted.config.configInfo;
import com.mrgreaper.twisted.entities.Entities;
import com.mrgreaper.twisted.items.Items;
import com.mrgreaper.twisted.network.ModInformation;
import com.mrgreaper.twisted.proxies.CommonProxy;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod( name = ModInformation.NAME, modid = ModInformation.ID, version = ModInformation.VERSION)

@NetworkMod( clientSideRequired = true, serverSideRequired =false )


public class TwistedMod {
	
    public static CreativeTabs tabTwisted = new CreativeTabs("tabTwisted") {
        public ItemStack getIconItemStack() {
        	//return new ItemStack(Item.carrot, 1, 0);
              return new ItemStack(Items.bunnyd, 1, 0);
        	
        }
};

@Instance(ModInformation.ID)
public static TwistedMod instance;

@SidedProxy(clientSide = "com.mrgreaper.twisted.proxies.ClientProxy", serverSide = "com.mrgreaper.twisted.proxies.CommonProxy")
public static CommonProxy proxy;

@EventHandler
public void preInit(FMLPreInitializationEvent event){
	//in here stuff is loaded like loading textures and sounds, aking configs etc
    ConfigHandler.init(event.getSuggestedConfigurationFile());
	if (configInfo.DEBUG){
		System.out.println("++++DEBUG MODE ON++++");
	}else{
		System.out.println("-----DEBUG MODE OFF----");
	}
	Items.init();
	Blocks.init();
	
    proxy.initSounds();
    proxy.initRenderers();
}

@EventHandler
public void load(FMLInitializationEvent event){
  Items.addNames();
  Items.registerRecipes();
  Blocks.addNames();
  Blocks.registerTileEntities();
  LanguageRegistry.instance().addStringLocalization("itemGroup.tabTwisted", "en_US", "Mr G Reapers Twisted Tab");
  
  Entities.init();
 // new GenerationHandeler();
  new GuiHandler();
}

@EventHandler
public void modsLoaded(FMLPreInitializationEvent event){
	
}

}