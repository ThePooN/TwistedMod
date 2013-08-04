package com.mrgreaper.twisted.items;

import com.mrgreaper.twisted.TwistedMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class itemOrphanTear extends Item{

	public itemOrphanTear(int id) {
		super(id);
		setCreativeTab(TwistedMod.tabTwisted); //set the creative tab to use
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.ORPHANTEAR_UNLOCALIZED_NAME);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	//here is where we add the textures etc, has to be client side ofcourse
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.ORPHANTEAR_ICON);
	}
	
	

}
