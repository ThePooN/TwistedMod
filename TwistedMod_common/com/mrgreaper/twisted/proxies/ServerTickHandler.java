package com.mrgreaper.twisted.proxies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.blocks.BlockInfo;
import com.mrgreaper.twisted.blocks.Blocks;
import com.mrgreaper.twisted.client.sounds.Sounds;
import com.mrgreaper.twisted.client.sounds.SpeechHandler;
import com.mrgreaper.twisted.config.configInfo;
import com.mrgreaper.twisted.items.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ServerTickHandler implements ITickHandler {
	
	boolean sound;
	//int trigger;

	private void onPlayerTick(EntityPlayer player){
		if (player.getCurrentEquippedItem() != null){
			ItemStack itemstack = player.getCurrentEquippedItem();
			//System.out.println(itemstack);
			
			if (itemstack.getItem() == Items.bunnye && !sound){
				//here needs to go a random generator and 3 or 4 different sound effects for the bunny begging for death :)
				Random randomGenerator = new Random();
			   	int randomInt = randomGenerator.nextInt(5);
		    	if (randomInt == 0 && configInfo.ELECBUNNYCRYS){Sounds.BUNNYBEG_A.onEntityPlay(player.worldObj, player, 1, 1);}//tempory sound 
		    	if (randomInt == 1 && configInfo.ELECBUNNYCRYS){Sounds.BUNNYBEG_B.onEntityPlay(player.worldObj, player, 1, 1);}
		    	if (randomInt == 2 && configInfo.ELECBUNNYCRYS){Sounds.BUNNYBEG_C.onEntityPlay(player.worldObj, player, 1, 1);}
		    	if (randomInt == 3 && configInfo.ELECBUNNYCRYS){Sounds.BUNNYBEG_D.onEntityPlay(player.worldObj, player, 1, 1);}
		    	if (randomInt == 4 && configInfo.ELECBUNNYCRYS){Sounds.BUNNYBEG_E.onEntityPlay(player.worldObj, player, 1, 1);}
		    	sound = true;
			}
			if (player.getCurrentEquippedItem().itemID == BlockInfo.SLAVEDBUNNY_ID && !sound){ //this is suppose to get the players in range including the player and play a short speech synth sentence to them on eqip
				//here needs to go a random generator and 3 or 4 different sound effects for the bunny begging for death :)
				AxisAlignedBB axisalignedbb =
						AxisAlignedBB.getAABBPool().getAABB((double)player.posX, (double)player.posY, (double)player.posZ, (double)(player.posX + 1), (double)(player.posY + 1), (double)(player.posZ + 1)).expand(10, 10, 10);
				//axisalignedbb.maxY = (double)player.getEyeHeight()+10;
	            List list = player.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
	            //iterate
	              Iterator iterator = list.iterator();
	              EntityPlayer entityplayer;
	  //iterate
	              while (iterator.hasNext())
	              {
	            	  ArrayList<String> enslavedBunnyTemp = new ArrayList<String>(Arrays.asList("why is it so dark?","Maybe i want to be in here","Its so cold in here","im not digging out of here, honest","can you digitize a carrot for me?","did you have to plug it in there?!","I have candy","why do you hate bunnys?","please, end my pain","let me out","I cant feel my tail","Help im trapped! What have you done to me","I dont feel right","my voice is wrong","you have no heart","where is this wire plugged in?"));//make an array list so we can add to it easierly
	            	  String enslavedBunnyOnHoldArray[] = new String[enslavedBunnyTemp.size()];
	            	  enslavedBunnyOnHoldArray = enslavedBunnyTemp.toArray(enslavedBunnyOnHoldArray);//copy the arraylist to the array
	 
	                  entityplayer = (EntityPlayer)iterator.next(); //would be nice if i could get the range the player is from the tileentity to control the volume....some day 
	      			//SpeechHandler.speechSynth(world, entityname, vVoice, vPitch, vPitchRange, vPitchShift, vSentence);
	                  Random randomGenerator = new Random(); //get a random number
	  			   	int randomInt = randomGenerator.nextInt(enslavedBunnyOnHoldArray.length); //that is equal to the number of entries in the array were using
	  			  if(TwistedMod.isClient)
	  				  SpeechHandler.speechSynth(null, null, 2, 25, 5, 10, enslavedBunnyOnHoldArray[randomInt]); //play an entry from the array
	      			sound = true;
	      			System.out.println(entityplayer);
	      			 {
	                       iterator = list.iterator();
	      //iterate again
	                       while (iterator.hasNext())
	                       {
	                               entityplayer = (EntityPlayer)iterator.next();
	      		}
	      			 }
	                  }
	              }
			if (itemstack.getItem() != Items.bunnye && player.getCurrentEquippedItem().itemID != BlockInfo.SLAVEDBUNNY_ID ){
				sound = false;
			
			}
			
			
		}
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (type.equals((EnumSet.of(TickType.PLAYER)))){
			onPlayerTick((EntityPlayer)tickData[0]);
		}

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
