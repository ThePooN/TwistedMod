package com.mrgreaper.twisted.items;

import java.util.Random;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.client.sounds.Sounds;
import com.mrgreaper.twisted.config.configInfo;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
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
		setMaxStackSize(1);
	}
	
	 //@SideOnly(Side.CLIENT)
	    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	    {
	    	if (configInfo.DEBUG){System.out.println(itemstack.stackSize + " " + itemstack);}
	    	entityplayer.destroyCurrentEquippedItem();//kills the stack 
	    	if (configInfo.DEBUG){System.out.println(itemstack.stackSize + " " + itemstack);}
	    	if (!entityplayer.worldObj.isRemote){
	    		Sounds.DEATH_ORB_LAUNCH.onEntityPlay(world, entityplayer, 1, 1);
	    	}
	      	Random randomGenerator = new Random();
	    	int randomInt = randomGenerator.nextInt(3);
	    	switch(randomInt){//changed from if to switch to make it neater
	        case 0:
	    	    entityplayer.entityDropItem(new ItemStack(Items.balloonr), 1);
	    	   break;
	        case 1:
		    	entityplayer.entityDropItem(new ItemStack(Items.orphanleg), 1);
		    	break;
	        case 2:
		    	entityplayer.entityDropItem(new ItemStack(Items.orphantear), 1);
		    	break;
	    	}
	    	return itemstack;
	    }
		
		
		@Override
		@SideOnly(Side.CLIENT)
		//here is where we add the textures etc, has to be client side ofcourse
		public void registerIcons(IconRegister register) {
			itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.DEATHORB_ICON);
		}
	

}
