package com.mrgreaper.twisted.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;
import com.mrgreaper.twisted.tileentities.TileEntityStaticGen;

public class ContainerStaticGen extends Container{
	
	private TileEntityStaticGen staticgen;
	
	public ContainerStaticGen(InventoryPlayer invPlayer, TileEntityStaticGen staticgen){
		this.staticgen = staticgen;
		
		for (int x = 0; x < 9; x++){ // this and bellow will create code for quick bar display in gui
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 130)); //8 + 18 * x and 130 set the location on the gui
		}
		
		for (int y = 0; y < 3; y ++){ //now lets add the users inventory to the gui..eeek
			for (int x = 0; x< 9; x++){
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x,72 + y* 18));
			}
		}
	}
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return staticgen.isUseableByPlayer(entityplayer);
	}
	@Override 
	public ItemStack transferStackInSlot(EntityPlayer player, int i){ //prevent shift clicking to avoid crashing
		System.out.println("no shift clicking");
		return null;
	}
}
	
	