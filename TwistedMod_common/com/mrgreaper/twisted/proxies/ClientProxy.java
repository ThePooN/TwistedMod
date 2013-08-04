package com.mrgreaper.twisted.proxies;

import com.mrgreaper.twisted.client.sounds.SoundHandler;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void initSounds() {
		new SoundHandler();
	}
	
	@Override
	public void initRenderers() {
		//init the rendering stuff
//		RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
	}
	
}