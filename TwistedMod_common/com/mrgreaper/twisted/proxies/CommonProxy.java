package com.mrgreaper.twisted.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommonProxy {

	public void initSounds() {
		// TODO Auto-generated method stub
		
	}

	public void initRenderers() {
		// TODO Auto-generated method stub
		
	}
	public static void chatHandler(EntityPlayer player,  String msg) {
		player.addChatMessage(msg);
    }

}
