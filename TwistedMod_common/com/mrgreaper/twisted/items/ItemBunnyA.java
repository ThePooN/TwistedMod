package com.mrgreaper.twisted.items;

import java.util.Random;

import appeng.api.Materials;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.client.sounds.Sounds;
import com.mrgreaper.twisted.config.configInfo;
import com.mrgreaper.twisted.proxies.CommonProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import universalelectricity.core.item.ItemElectric;

public class ItemBunnyA extends Item {

	public ItemBunnyA(int id) {
		super(id);
		setCreativeTab(TwistedMod.tabTwisted);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.BUNNYA_UNLOCALIZED_NAME);
	}
	
	@Override 
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		int playerX = (int) player.prevPosX;
		int playerY = (int) player.prevPosY;
		int playerZ = (int) player.prevPosZ;
		if (configInfo.DEBUG){System.out.println(playerX + " " + playerY + " " + playerZ);}
		if (!player.worldObj.isRemote){
			Random randomGenerator = new Random(); //test of random
			int randomInt = randomGenerator.nextInt(5);
			if (configInfo.DEBUG){System.out.println("the random number was "+randomInt + "the entity was " + player + " theplayer :" + Minecraft.getMinecraft().thePlayer);}
			if (randomInt == 0){
			      Sounds.CREATED_MONSTER.onEntityPlay(world, player, 1, 1); //test of onentity play of sound server side so that all hear it
			}
			if (randomInt == 1){
				Sounds.BUNNY_RELEASE.onEntityPlay(world, player, 1, 1);
				}
			if (randomInt == 2){
				Sounds.BUNNY_LITTLE.onEntityPlay(world, player, 1, 1);
				}
			if (randomInt == 3){
				Sounds.BUNNY_EXP.onEntityPlay(world, player, 1, 1);
				}
			if (randomInt == 4){
				Sounds.BUNNY_RESSISTANCE.onEntityPlay(world, player, 1, 1);
				}
		}else{Minecraft.getMinecraft().thePlayer.addChatMessage("Dont let The evil vile creature go free!");}
	}
	
/*	public static ItemStack genNewItem(int charge){
	     ItemStack stack = new ItemStack(Items.bunnye, 1);
	     stack.getItem().setCharge(1000);
	     return stack;
	}*/

	boolean disabler;
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		//Sounds.SHAKEI.onEntityPlay(world, entityplayer, 1, 1);
		//ItemStack.copyItemStack(Materials.matQuartz);
		//entityplayer.entityDropItem(ItemStack.copyItemStack(Materials.matQuartz), 1);//test code will change when more awake
		if (!entityplayer.worldObj.isRemote){//we only want to do this on the server side or it gets ...interesting
		Random randomGenerator = new Random();
    	int randomInt = randomGenerator.nextInt(configInfo.BUNNYSTATICCHANCE);
    	if (randomInt == 0){
    		//ok so check if its o out of what ever is set in our bunnystaticchance..if it is, kill the live bunny and replace it with a static one
    		entityplayer.destroyCurrentEquippedItem(); //lets kill the bunny in thier hands mooooo ha ha ha ha ha haaa
    		if (configInfo.DEBUG) { System.out.println("random number on bunny right click is "+ randomInt);//if debug is on lets look at that number :)
    		}
    		if (!entityplayer.worldObj.isRemote){entityplayer.entityDropItem(new ItemStack(Items.bunnye), 1);}
    		Sounds.BUNNY_ELECTRIC.onEntityPlay(world, entityplayer, 1, 1); // new sound test
    		}else{
    			int randomInt2 = randomGenerator.nextInt(24);
    			bunnyShakeFailHandler(randomInt2, itemstack, entityplayer, world);
    		}
		} 
		return itemstack;}
    
	@Override
	@SideOnly(Side.CLIENT)
	//here is where we add the textures etc, has to be client side ofcourse
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.BUNNYA_ICON);
		
	}
	
	public Object bunnyShakeFailHandler(int ID,ItemStack itemstack, EntityPlayer player, World world){
		String name = player.getEntityName();
		if (configInfo.DEBUG){System.out.println(name);}
		switch(ID){
		case 0:
			CommonProxy.chatHandler(player, "A small charge builds but earths itself almost immediatly.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEA.onEntityPlay(world, player, 1, 1);}
			break;
		case 1:
			CommonProxy.chatHandler(player, "Oh my thats not good, it didnt give it enough static charge but it did fluff up its furr a bit.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEB.onEntityPlay(world, player, 1, 1);}
			break;
		case 2:
			CommonProxy.chatHandler(player, "The bunny is doing a little jig..oh no wait i think thats a fit. hop your proud of yourself.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEC.onEntityPlay(world, player, 1, 1);}
			break;
		case 3:
			CommonProxy.chatHandler(player, "It bites you and wont seem to let go.");
			player.attackEntityFrom(DamageSource.generic, 4.0F);
			if (configInfo.SHAKESPEECH){Sounds.SHAKED.onEntityPlay(world, player, 1, 1);}
			break;
		case 4:
			CommonProxy.chatHandler(player, "The bunny appears to be making a crude gesture with its paws...oh now really that is rude!");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEE.onEntityPlay(world, player, 1, 1);}
			break;
		case 5:
			CommonProxy.chatHandler(player, "I cant repeat what the bunny is doing now!");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEF.onEntityPlay(world, player, 1, 1);}
			break;
		case 6:
			CommonProxy.chatHandler(player, "The bunny winks at you...wait no..its mooning you.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEG.onEntityPlay(world, player, 1, 1);}
			break;
		case 7:
			CommonProxy.chatHandler(player, "All that happens is your wrist aches a little.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEH.onEntityPlay(world, player, 1, 1);}
			break;
		case 8:
			CommonProxy.chatHandler(player, "The bunny keels over and dies");
			player.destroyCurrentEquippedItem();
			if (!player.worldObj.isRemote){player.entityDropItem(new ItemStack(Items.bunnyd), 1);}
			Sounds.BUNNY_OWW.onEntityPlay(world, player, 1, 1);
			if (configInfo.SHAKESPEECH){Sounds.SHAKEI.onEntityPlay(world, player, 1, 1);}
			break;
		case 9:
			CommonProxy.chatHandler(player, "The bunny seems to twitch its nose in threatening manner.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEJ.onEntityPlay(world, player, 1, 1);}
			break;
		case 10:
			CommonProxy.chatHandler(player, "I think it stole your pickaxe.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEK.onEntityPlay(world, player, 1, 1);}
			break;
		case 11:
			CommonProxy.chatHandler(player, "The bunny looks puzzled for a second then throws up.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEL.onEntityPlay(world, player, 1, 1);}
			break;
		case 12:
			CommonProxy.chatHandler(player, "The bunny does a little impression of you, shaking his paw then sniggers.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEM.onEntityPlay(world, player, 1, 1);}
			break;
		case 13:
			CommonProxy.chatHandler(player, "The bunny appears to be mocking you.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEN.onEntityPlay(world, player, 1, 1);}
			break;
		case 14:
			CommonProxy.chatHandler(player, "You think thats enough to energize the bunny...shake failure.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEO.onEntityPlay(world, player, 1, 1);}
			break;
		case 15:
			CommonProxy.chatHandler(player, "The bunny blows you a rasperry.");
			Sounds.SHAKEP.onEntityPlay(world, player, 1, 1);
			break;
		case 16:
			CommonProxy.chatHandler(player, "The bunny just stares back at you.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEQ.onEntityPlay(world, player, 1, 1);}
			break;
		case 17:
			CommonProxy.chatHandler(player, "You failed to shake the bunny enough to energize it.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKER.onEntityPlay(world, player, 1, 1);}
			break;
		case 18:
			CommonProxy.chatHandler(player, "The bunny looks you up and down and growls, i dont think he liked that");
			Sounds.BUNNY_GROWL.onEntityPlay(world, player, 1, 1);
			break;
		case 19:
			CommonProxy.chatHandler(player, "Awww bless he is head banging to some unheard music....or is that whiplash?");
			if (configInfo.SHAKESPEECH){Sounds.SHAKES.onEntityPlay(world, player, 1, 1);}
			break;
		case 20:
			CommonProxy.chatHandler(player, "Can bunnys be staticly charged? really? if so you may need to try harder.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKET.onEntityPlay(world, player, 1, 1);}
			break;
		case 21:
			CommonProxy.chatHandler(player, "The bunny looks at you, you cant help feeling that its disapointed in you.");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEU.onEntityPlay(world, player, 1, 1);}
			break;
		case 22:
			CommonProxy.chatHandler(player, "The bunny shakes its head and writes you a message..it says 'i pitty you " + name + " ' ");
			Sounds.EVIL_LAUGHB.onEntityPlay(world, player, 1, 1);
			break;
		case 23:
			CommonProxy.chatHandler(player, "The bunny straightens its furr and slaps you across the face");
			if (configInfo.SHAKESPEECH){Sounds.SHAKEV.onEntityPlay(world, player, 1, 1);}
			break;
		case 24:
			CommonProxy.chatHandler(player, "");
			break;
		}
		
		return null;
		
	}

	
	

}