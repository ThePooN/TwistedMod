package com.mrgreaper.twisted.proxies;

import com.mrgreaper.twisted.client.RenderBalloon;
import com.mrgreaper.twisted.client.sounds.SoundHandler;
import com.mrgreaper.twisted.entities.EntityBalloon;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void initSounds() {
		new SoundHandler();
	}
	
	@Override
	public void initRenderers() {
		//init the rendering stuff
		RenderingRegistry.registerEntityRenderingHandler(EntityBalloon.class, new RenderBalloon()); ///two peramiters the class and the new instance of the render code
	}
	
}