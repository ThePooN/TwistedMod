package com.mrgreaper.twisted.client.interfaces;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.mrgreaper.twisted.items.Items;

public class SlotOrphanTear extends Slot {

	public SlotOrphanTear(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack){
		return stack.itemID == Items.orphantear.itemID;
	}
}
