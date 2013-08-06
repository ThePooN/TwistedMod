package com.mrgreaper.twisted.items;

import java.util.Random;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.client.sounds.Sounds;
import com.mrgreaper.twisted.config.configInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBunnyA extends Item {

	public ItemBunnyA(int id) {
		super(id);
		setCreativeTab(TwistedMod.tabTwisted);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.BUNNYA_UNLOCALIZED_NAME);
	}
	
	@Override //had to make the sound play client side, making it play server side ment it was only played for the host
	          //not too much of an issue in this circumstance but i need to find what went wrong for the future.
	          // world.playSoundAtEntity may be the key but so far not easy to set up lol
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		//int playerX = (int) Minecraft.getMinecraft().thePlayer.lastTickPosX;
		//int playerY = (int) Minecraft.getMinecraft().thePlayer.lastTickPosY;
		//int playerZ = (int) Minecraft.getMinecraft().thePlayer.lastTickPosZ;
		int playerX = (int) player.prevPosX;
		int playerY = (int) player.prevPosY;
		int playerZ = (int) player.prevPosZ;
		System.out.println(playerX + " " + playerY + " " + playerZ);
		if (!player.worldObj.isRemote){
			Random randomGenerator = new Random(); //test of random
			int randomInt = randomGenerator.nextInt(5);
			System.out.println("the random number was "+randomInt + "the entity was " + player + " theplayer :" + Minecraft.getMinecraft().thePlayer);
			if (randomInt == 0){
			      Sounds.CREATED_MONSTER.onEntityPlay(world, player, 1, 1); //test of onentity play of sound server side so that all hear it
				//Sounds.CREATED_MONSTER.play (playerX ,playerY, playerZ, 150, 1);
			}
			if (randomInt == 1){
				Sounds.BUNNY_RELEASE.onEntityPlay(world, player, 1, 1);
				//Sounds.BUNNY_RELEASE.play (playerX ,playerY, playerZ, 150, 1);
				}
			if (randomInt == 2){
				Sounds.BUNNY_LITTLE.onEntityPlay(world, player, 1, 1);
				//Sounds.BUNNY_LITTLE.play (playerX ,playerY, playerZ, 150, 1);
				}
			if (randomInt == 3){
				Sounds.BUNNY_EXP.onEntityPlay(world, player, 1, 1);
				//Sounds.BUNNY_EXP.play (playerX ,playerY, playerZ, 150, 1);
				}
			if (randomInt == 4){
				Sounds.BUNNY_RESSISTANCE.onEntityPlay(world, player, 1, 1);
				//Sounds.BUNNY_RESSISTANCE.play (playerX ,playerY, playerZ, 150, 1);
				}
			Minecraft.getMinecraft().thePlayer.addChatMessage("Dont let The evil vile creature go free!");
		}
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		int playerX = (int) entityplayer.prevPosX;
		int playerY = (int) entityplayer.prevPosY;
		int playerZ = (int) entityplayer.prevPosZ;
    	Random randomGenerator = new Random();
    	int randomInt = randomGenerator.nextInt(configInfo.BUNNYSTATICCHANCE);
    	if (randomInt == 0){
    		itemstack.stackSize --;
    		if (!entityplayer.worldObj.isRemote){ //lets do this bit serverside
    		entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.bunnye,1));
    		Sounds.BUNNY_ELECTRIC.onEntityPlay(world, entityplayer, 1, 1); // new sound test
    		}
    		//Sounds.BUNNY_ELECTRIC.play (playerX ,playerY, playerZ, 150, 1);
    	}else{
    		int randomIntB = randomGenerator.nextInt(17);
        	if (randomIntB == 0 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("You failed to shake the bunny enough to energize it.");
        	}
        	if (randomIntB == 1 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny just stares back at you.");
        	}	
        	if (randomIntB == 2 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny blows you a rasperry.");
        	}
        	if (randomIntB == 3 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("You think thats enough to energize the bunny...shake failure.");
        	}
        	if (randomIntB == 4 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny appears to be mocking you.");
        	}
        	if (randomIntB == 5 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny does a little impression of you, shaking his paw then sniggers.");
        	}
        	if (randomIntB == 6 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny looks puzzled for a second then throws up.");
        	}
        	if (randomIntB == 7 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny seems to twitch its nose in threatening manner.");
        	}
        	if (randomIntB == 8 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("the bunny keels over and dies");
        	}
        	if (randomIntB == 8){
        		itemstack.stackSize --;
        		entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.bunnyd,1));
        		Sounds.BUNNY_OWW.onEntityPlay(world, entityplayer, 1, 1);
        	}
        	if (randomIntB == 9 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("A small charge builds but earths itself almost immediatly.");
        	}
        	if (randomIntB == 10 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("All that happens is your wrist aches a little.");
        	}
        	if (randomIntB == 11 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny winks at you...wait no..its mooning you.");
        	}
        	if (randomIntB == 12 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("I cant repeat what the bunny is doing now!");
        	}
        	if (randomIntB == 13 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny appears to be making a crude gesture with its paws...oh now really that is rude!");
        	}
        	if (randomIntB == 14 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("The bunny is doing a little jig..oh no wait i think thats a fit. hop your proud of yourself.");
        	}
        	if (randomIntB == 15 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("Oh my thats not good, it didnt give it enough static charge but it did fluff up its furr a bit.");
        	}
        	if (randomIntB == 16 && entityplayer.worldObj.isRemote){
        		Minecraft.getMinecraft().thePlayer.addChatMessage("It bites you and wont seem to let go.");
        	}
        	if (randomIntB == 16 && !entityplayer.worldObj.isRemote){
        		entityplayer.attackEntityFrom(DamageSource.generic, 1.0F);
        	}
    	}
	 
    	return itemstack;
    }
	@Override
	@SideOnly(Side.CLIENT)
	//here is where we add the textures etc, has to be client side ofcourse
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.BUNNYA_ICON);
		
	}

	
	

}