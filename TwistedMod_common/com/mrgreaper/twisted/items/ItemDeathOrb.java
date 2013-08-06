package com.mrgreaper.twisted.items;

import java.util.Random;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.client.sounds.Sounds;

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
	}
	
	 //@SideOnly(Side.CLIENT)
	    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	    {
	    	int x = entityplayer.serverPosX;
	    	int y = entityplayer.serverPosY;
	    	int z = entityplayer.serverPosZ;
	    	System.out.println(itemstack.stackSize + " " + itemstack);
	    	itemstack.stackSize --;
	    	System.out.println(itemstack.stackSize + " " + itemstack);
	    	if (!entityplayer.worldObj.isRemote){
	    		Sounds.DEATH_ORB_LAUNCH.onEntityPlay(world, entityplayer, 1, 1);
	    	}
	      	Random randomGenerator = new Random();
	    	int randomInt = randomGenerator.nextInt(3);
	    	if (randomInt == 0){
	    	entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.balloonr,1));
	    	}
	    	if (randomInt == 1){
		    	entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.orphantear,1));
		    	}
	    	if (randomInt == 2){
		    	entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.orphanleg,1));
		    	}
	    	return itemstack;
	    }

	
	
/*	hmm this is one way i can do it but then it only trigures when right clicking a block... need a new method	
 * @Override
	    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
			if(!world.isRemote)
	    	{
	    		System.out.println("itemstack : " + itemstack + "entity player : " + entityplayer + "world : " + world + " X: " + x + " Y: " + y + " z: " + z + " side: " + side + "hitX : " + hitX + "hitY : " + hitY + "hitZ : " + hitZ);
	    	}
	    	
	    	return false;
	    }*/
		
		
		
		@Override
		@SideOnly(Side.CLIENT)
		//here is where we add the textures etc, has to be client side ofcourse
		public void registerIcons(IconRegister register) {
			itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.DEATHORB_ICON);
		}
	

}
