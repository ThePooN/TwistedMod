package com.mrgreaper.twisted.client.sounds;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SoundHandler {
	
	public SoundHandler() {
		MinecraftForge.EVENT_BUS.register(this); //were telling event bus we want to register the soundhandler inside it
		
	}
	
	@ForgeSubscribe
	public void onSoundsLoad(SoundLoadEvent event){ // so when vanila loads sounds..so do we
		for (Sounds sound : Sounds.values()) {
			addSound(event, sound);
		}
		
	}
	
	private void addSound(SoundLoadEvent event, Sounds sound){
		event.manager.soundPoolSounds.addSound(Sounds.SOUNDS_LOCATION + ":" + sound.getName() + ".ogg");//refers to assets then sound folder
	}

}
