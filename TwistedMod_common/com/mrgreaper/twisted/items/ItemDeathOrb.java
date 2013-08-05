package com.mrgreaper.twisted.items;

import com.mrgreaper.twisted.TwistedMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDeathOrb extends Item {
	public ItemDeathOrb(int id) {
		super(id);;
		setCreativeTab(TwistedMod.tabTwisted);
		setUnlocalizedName(ItemInfo.DEATHORB_UNLOCALIZED_NAME);
	}
		//@Override
		public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world){
			if (world.isRemote){
			System.out.println(itemstack + " " + entityplayer);
			return true;
			}else{
				System.out.println("error");
				return true;
			}
		}
		
		
		@Override
		@SideOnly(Side.CLIENT)
		//here is where we add the textures etc, has to be client side ofcourse
		public void registerIcons(IconRegister register) {
			itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.DEATHORB_ICON);
		}
	

}
