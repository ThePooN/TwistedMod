package com.mrgreaper.twisted.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.mrgreaper.twisted.TwistedMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOrphanLeg extends Item {

	public ItemOrphanLeg(int id) {
		super(id);
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