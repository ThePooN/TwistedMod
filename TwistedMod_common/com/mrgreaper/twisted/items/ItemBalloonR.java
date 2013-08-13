package com.mrgreaper.twisted.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.entities.EntityBalloon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBalloonR extends Item {

	public ItemBalloonR(int id) {
		super(id);
		setCreativeTab(TwistedMod.tabTwisted);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.BALLOONR_UNLOCALIZED_NAME);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityBalloon(world, x + 0.5, y + 1.5, z + 0.5));
			
			stack.stackSize--;
			
			return true;
		}else{
			return false;
		}

	}
	
	@Override
	@SideOnly(Side.CLIENT)
	//here is where we add the textures etc, has to be client side ofcourse
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.BALLOONR_ICON);
		
	}
}
