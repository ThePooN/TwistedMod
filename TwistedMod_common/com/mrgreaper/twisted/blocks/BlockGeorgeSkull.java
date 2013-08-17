package com.mrgreaper.twisted.blocks;

import java.util.Random;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.client.sounds.Sounds;
import com.mrgreaper.twisted.items.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockGeorgeSkull extends Block{

	public BlockGeorgeSkull(int id){
		super(id, Material.rock);
		
		setCreativeTab(TwistedMod.tabTwisted);
		setHardness(1F);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(BlockInfo.GEORGESKULL_UNLOCALIZED_NAME);
		
		}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.GEORGESKULL_TEXTURE);
	}
	
	
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(24);
		georgeRandomSpeakToPlayer(randomInt,x,y,z,player);
	}
	
	private void georgeRandomSpeakToPlayer(int randomInt, int x, int y, int z, EntityPlayer player) {
		String name = player.getEntityName();
		ItemStack itemstack = player.getCurrentEquippedItem();
		System.out.println("name " + name + " item " + itemstack);
		switch(randomInt){
		case 0:
			// ill take that remove the players equiped item
			if (itemstack != null){ player.destroyCurrentEquippedItem();
			Sounds.SKULL_TAKE.onEntityPlay(player.worldObj, player, 1, 1);
			//play taken sound item
			}else{
				Sounds.SKULL_PITY.onEntityPlay(player.worldObj, player, 1, 1);
				//player has no item...mock them :)
			}
			break;
		case 1:
			//give the player a present so that they may spread evil in your name
			player.entityDropItem(new ItemStack (Item.stick) , 1);
			Sounds.SKULL_GIVESTICK.onEntityPlay(player.worldObj, player, 1, 1);
			//Sounds.BUNNY_OWW.onEntityPlay(player.worldObj, player, 1, 1);
			break;
		case 2:
			//stuff here
			break;
		case 3:
			//stuff here
			break;
		case 4:
			//stuff here
			break;
		case 5:
			//stuff here
			break;
		case 6:
			//stuff here
			break;
		case 7:
			//stuff here
			break;
		case 8:
			//stuff here
			break;
		case 9:
			//stuff here
			break;
		case 10:
			//stuff here
			break;
		case 11:
			//stuff here
			break;
		case 12:
			//stuff here
			break;
		case 13:
			//stuff here
			break;
		case 14:
			//stuff here
			break;
		case 15:
			//stuff here
			break;
		case 16:
			//stuff here
			break;
		case 17:
			//stuff here
			break;
		case 18:
			//stuff here
			break;
		case 19:
			//stuff here
			break;
		case 20:
			//stuff here
			break;
		case 21:
			//stuff here
			break;
		case 22:
			//stuff here
			break;
		case 23:
			//stuff here
			break;
		case 24:
			//stuff here
			break;
		case 25:
			//stuff here
			break;
		}
		
	}

	
//	public Object georgeRandomSpeak(World world,int x ,int y,int z){
//		return world;
//	
//	}
}