package com.mrgreaper.twisted.client.sounds;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.io.*;

import com.sun.speech.freetts.*;


@SideOnly(Side.CLIENT)
public class SpeechHandler {
	

	public static void speechSynth(World world,Entity entityname,double vVoice,float vPitch,float vPitchRange,float vPitchShift,String vSentence ) {
		String VOICENAME = "kevin16";
		if (vVoice == 1) {VOICENAME = "kevin";}; //for now we wont use the low quality one, it would proberly not be used much and thus the removal of an augment will help players
		if (vVoice == 2) {VOICENAME = "kevin16";};
		//if (vVoice == 3) {VOICENAME = "alan";}; //REMed out as alan can only talk about the time...which would get confusng for some users
		
		Voice voice;
		VoiceManager vm= VoiceManager.getInstance();
		voice=vm.getVoice(VOICENAME);
		voice.allocate();
		voice.setPitch(vPitch);
		voice.setPitchRange(vPitchRange);
		voice.setPitchShift(vPitchShift);
		voice.speak(vSentence);
	}
}
