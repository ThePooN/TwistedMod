package com.mrgreaper.twisted.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlarm extends TileEntity implements IInventory{
	
	private ItemStack[] items; //set an array of items we can store ...ok so this is not really needed at mo for the alarm but may be needed later
	
	public TileEntityAlarm(){
		items = new ItemStack[3]; //stores 3 items in this inventory..well 3 itemstacks could be 3x64 ofcourse(again not needed for now)
	}

	@Override
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return items[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int count) {
		ItemStack itemstack = getStackInSlot(i);//first check whats in the slot
		
		if (itemstack != null){ //make sure the item stack isnt null
			if (itemstack.stackSize <= count){ //can we remove all of the itemstack?
				setInventorySlotContents(i, null); //clears the itemstack
			}else{
				itemstack = itemstack.splitStack(count); //if we dont want it all this will extract the amount we requested
				onInventoryChanged(); //updates the inventorys state not needed on set inventory contents above
			}
		}
		
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) { //used when closing the interface/inventory
		ItemStack item = getStackInSlot(i); 
		setInventorySlotContents(i, null);

		return item;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack; //the important part
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()){ //this isnt needed if your stack sizze max is 64 it stops you putting in more then the limit
			itemstack.stackSize = getInventoryStackLimit(); 
		}
		
		onInventoryChanged();
	}

	@Override
	public String getInvName() { 
		return "InventoryAlarm";
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;//check the player is close to the machine
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false; //this is where we can limit what is put in ie 
		//return itemstack.itemID == block.anvil.blockID;  would restrict it to anvils
	}
	
	@Override //saving the inventory
	public void writeToNBT(NBTTagCompound compound){ ///now to save the inventory ie the stuff we put inside it
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList();
		
		for (int i = 0; i < getSizeInventory(); i++){ //now lets read the inventory of the tile entity
			                                          // for when i get stuck or forget, this is explained best here http://www.youtube.com/watch?feature=player_detailpage&v=UpHauh6gCT4&t=1042  
			ItemStack stack = getStackInSlot(i); //lets get the stacks in each slot
			
			if (stack != null){ //lets make sure the slot is NOT empty
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i); //save its slot number
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		compound.setTag("Items", items);
		
		
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("Items");
		
		for (int i = 0; i < items.tagCount(); i++){ //another loop this time though all the tags
			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
		int slot = item.getByte("Slot");
		
		if (slot >= 0 && slot < getSizeInventory()){
		     setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
	}
}
	}

	public void recieveButtonEvent(byte buttonId) {
		System.out.println("button id : " + buttonId);
		switch(buttonId){
			case 0:
				System.out.println("the button with button id : " + buttonId + " was pressed.");
				
				break;
		}
	
		
	}

}
