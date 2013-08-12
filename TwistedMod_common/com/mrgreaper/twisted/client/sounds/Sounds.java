package com.mrgreaper.twisted.client.sounds;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public enum Sounds {
	BUNNY_RELEASE("bunnyRelease"),
	BUNNY_OWW("bunnyOww"),
	BUNNY_LITTLE("LittleBunny"),
	BUNNY_RESSISTANCE("bunnyResistance"),
	BUNNY_EXP("bunnyExp"),
	BUNNY_ELECTRIC("bunnyElectricfy"),
	BUNNY_GROWL("growl"),
	EVIL_LAUGHB("laughb"),
	SHAKEA("shakea"),
	SHAKEB("shakeb"),
	SHAKEC("shakec"),
	SHAKED("shaked"),
	SHAKEE("shakee"),
	SHAKEF("shakef"),
	SHAKEG("shakeg"),
	SHAKEH("shakeh"),
	SHAKEI("shakei"),
	SHAKEJ("shakej"),
	SHAKEK("shakek"),
	SHAKEL("shakel"),
	SHAKEM("shakem"),
	SHAKEN("shaken"),
	SHAKEO("shakeo"),
	SHAKEP("shakep"),
	SHAKEQ("shakeq"),
	SHAKER("shaker"),
	SHAKES("shakes"),
	SHAKET("shaket"),
	SHAKEU("shakeu"),
	SHAKEV("shakev"),
	EVIL_LAUGH("laugh"),
	DEATH_ORB_LAUNCH("deathOrbLaunch"),
	CREATED_MONSTER("monster");
	
	
	public static final String SOUNDS_LOCATION = "twisted";
	private String name;
	
	Sounds(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void play(double x, double y, double z, float volume, float pitch){
		Minecraft.getMinecraft().sndManager.playSound(SOUNDS_LOCATION + ":" + name, (float)x, (float)y, (float)z, volume, pitch);
	}
    //bellow should of been a helper for playing sounds on entity but it failed no idea why!
		public void onEntityPlay(World world,Entity entityName,float volume ,float pitch){
			world.playSoundAtEntity(entityName,(SOUNDS_LOCATION + ":" + name), (float)volume,(float) pitch);
		}

}
