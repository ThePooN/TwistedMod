package com.mrgreaper.twisted;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.mrgreaper.twisted.blocks.Blocks;
import com.mrgreaper.twisted.client.interfaces.GuiHandler;
import com.mrgreaper.twisted.client.sounds.SpeechHandler;
import com.mrgreaper.twisted.config.ConfigHandler;
import com.mrgreaper.twisted.config.configInfo;
import com.mrgreaper.twisted.entities.Entities;
import com.mrgreaper.twisted.items.Items;
import com.mrgreaper.twisted.items.recipies;
import com.mrgreaper.twisted.network.ModInformation;
import com.mrgreaper.twisted.network.PacketHandler;
import com.mrgreaper.twisted.proxies.CommonProxy;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod( name = ModInformation.NAME, modid = ModInformation.ID, version = ModInformation.VERSION)

@NetworkMod(channels = {ModInformation.CHANNEL}, clientSideRequired = true, serverSideRequired =false, packetHandler = PacketHandler.class )


public class TwistedMod {
	
    public static CreativeTabs tabTwisted = new CreativeTabs("tabTwisted") {
        public ItemStack getIconItemStack() {
        	//return new ItemStack(Item.carrot, 1, 0);
              return new ItemStack(Items.bunnyd, 1, 0);
        	
        }
};

public static boolean isClient;

@Instance(ModInformation.ID)
public static TwistedMod instance;

@SidedProxy(clientSide = "com.mrgreaper.twisted.proxies.ClientProxy", serverSide = "com.mrgreaper.twisted.proxies.CommonProxy")
public static CommonProxy proxy;

@EventHandler
public void preInit(FMLPreInitializationEvent event){
	
	isClient = event.getSide().isClient();
	
	//in here stuff is loaded like loading textures and sounds, aking configs etc
    ConfigHandler.init(event.getSuggestedConfigurationFile());
	if (configInfo.DEBUG){
		System.out.println("++++ Twisted Mod ++++");
		System.out.println("++++DEBUG MODE ON++++");
	}else{
		System.out.println("----  Twisted Mod   ---");
		System.out.println("-----DEBUG MODE OFF----");
	}
	System.out.println("By Mr G Reaper...WARNING may contain bunnys!");
	Items.init();
	Blocks.init();
	
    proxy.initSounds();
    proxy.initRenderers();
    proxy.registerServerTickHandler();
}


@EventHandler
public void load(FMLInitializationEvent event){
  Items.addNames();
  recipies.registerRecipes();
  Blocks.addNames();
  Blocks.registerTileEntities();
  LanguageRegistry.instance().addStringLocalization("itemGroup.tabTwisted", "en_US", "Mr G Reapers Twisted Tab");
  
  Entities.init();
 // new GenerationHandeler();
  new GuiHandler();
  
  //SpeechHandler.speechSynth(null, null, 2, 10, 10, 10, "speech is on");
}

@EventHandler
public void modsLoaded(FMLPreInitializationEvent event){
	     if (Loader.isModLoaded("AppliedEnergistics")) {
	            try {
	                     configInfo.appEngLoaded = true;
	                      
	                System.out.println( "AppliedEnergistics detected by twisted mod");
	            }
	            catch (Exception e) {
	                System.out.println("Could not load appeng settings");
	                e.printStackTrace(System.err);
	            }
	     }else{ 
	    	 configInfo.appEngLoaded = false;
	     }
	     if (Loader.isModLoaded("IC2")) {
	            try {
	                     configInfo.IC2Loaded = true;
	                      
	                System.out.println( "ic2 detected by twisted mod");
	            }
	            catch (Exception e) {
	                System.out.println("Could not load appeng settings");
	                e.printStackTrace(System.err);
	            }
	     }else{ 
	    	 configInfo.appEngLoaded = false;
	     }
	     
}
	        
	

}