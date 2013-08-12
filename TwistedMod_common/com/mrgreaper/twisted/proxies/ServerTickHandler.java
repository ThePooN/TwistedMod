package com.mrgreaper.twisted.proxies;

import java.util.EnumSet;
import java.util.Random;

import com.mrgreaper.twisted.client.sounds.Sounds;
import com.mrgreaper.twisted.config.configInfo;
import com.mrgreaper.twisted.items.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

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
		    	if (randomInt == 0 && configInfo.ELECBUNNYCRYS){Sounds.BUNNY_OWW.onEntityPlay(player.worldObj, player, 1, 1);}//tempory sound 
		    	if (randomInt == 1 && configInfo.ELECBUNNYCRYS){Sounds.BUNNY_OWW.onEntityPlay(player.worldObj, player, 1, 1);}
		    	if (randomInt == 2 && configInfo.ELECBUNNYCRYS){Sounds.BUNNY_OWW.onEntityPlay(player.worldObj, player, 1, 1);}
		    	if (randomInt == 3 && configInfo.ELECBUNNYCRYS){Sounds.BUNNY_OWW.onEntityPlay(player.worldObj, player, 1, 1);}
		    	if (randomInt == 4 && configInfo.ELECBUNNYCRYS){Sounds.BUNNY_OWW.onEntityPlay(player.worldObj, player, 1, 1);}
		    	sound = true;
			}
			if (itemstack.getItem() != Items.bunnye){
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