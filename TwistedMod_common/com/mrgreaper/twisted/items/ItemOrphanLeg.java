package com.mrgreaper.twisted.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

import com.mrgreaper.twisted.TwistedMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOrphanLeg extends ItemFood {

	//public ItemOrphanLeg(int id) {
		//super(id);
		public ItemOrphanLeg(int id, int par2, boolean par3) {
		super(id, 3, true);
		// TODO Auto-generated constructor stub
		setCreativeTab(TwistedMod.tabTwisted);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.ORPHANLEG_UNLOCALIZED_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	//here is where we add the textures etc, has to be client side ofcourse
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.ORPHANLEG_ICON);
		
	}
}