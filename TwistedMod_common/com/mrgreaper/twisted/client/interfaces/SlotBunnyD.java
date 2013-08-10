package com.mrgreaper.twisted.client.interfaces;

import com.mrgreaper.twisted.items.Items;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBunnyD extends Slot {

	public SlotBunnyD(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack){
		return stack.itemID == Items.bunnyd.itemID;
	}
}