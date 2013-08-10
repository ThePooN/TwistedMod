package com.mrgreaper.twisted.client.interfaces;


import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

//this helps define the interface etc well control wise/slot wise etc

public class ContainerRebunnyator  extends Container{ 
	
	private TileEntityRebunnyator rebunnyator;
	
	public ContainerRebunnyator(InventoryPlayer invPlayer, TileEntityRebunnyator rebunnyator){
		this.rebunnyator = rebunnyator;
		
		for (int x = 0; x < 9; x++){ // this and bellow will create code for quick bar display in gui
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 130)); //8 + 18 * x and 130 set the location on the gui
		}
		
		for (int y = 0; y < 3; y ++){ //now lets add the users inventory to the gui..eeek
			for (int x = 0; x< 9; x++){
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x,72 + y* 18));
			}
		}
		addSlotToContainer(new SlotBunnyD(rebunnyator, 0, 8 ,17));// ok so lets add our unique slots container , slot id , Xcords, Ycords 
		addSlotToContainer(new SlotOrphanTear(rebunnyator, 1, 44 ,17));
		addSlotToContainer(new Slot(rebunnyator, 2, 138 ,17)); //this will be the output one
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return rebunnyator.isUseableByPlayer(entityplayer);
	}
	@Override 
	public ItemStack transferStackInSlot(EntityPlayer player, int i){ //prevent shift clicking to avoid crashing
		System.out.println("no shift clicking");
		return null;
	}
}
	
	