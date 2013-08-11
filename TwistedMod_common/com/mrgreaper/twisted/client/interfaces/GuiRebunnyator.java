package com.mrgreaper.twisted.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mrgreaper.twisted.network.PacketHandler;
import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) //client side only
public class GuiRebunnyator extends GuiContainer{

	public GuiRebunnyator(InventoryPlayer invPlayer, TileEntityRebunnyator rebunnyator) { 
		super(new ContainerRebunnyator(invPlayer, rebunnyator));
		
		xSize = 176; //set the size (max 256 x 256
		ySize = 154; //to the size of the texture

	}
	
	private static final ResourceLocation texture = new ResourceLocation("twisted", "textures/gui/rebunnyator.png"); // set the resource location

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1); //resets the colours
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(texture); //assign the texture(get render engine bind texture
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize); //draw a rectangle from the texture
		
		
	}
	
	@Override // for adding text to the gui
	protected void drawGuiContainerForegroundLayer(int x, int y){ //add text to the gui
		fontRenderer.drawString("ReBunnyAtor",8 ,6,0x404040); // text ,xcords,ycords, colour
	}
	
	@Override // adding a button
	public void initGui(){
		super.initGui();
		buttonList.clear(); //clear the old list of buttons to make sure we donet get them again..hmmm wierd
		
		buttonList.add(new GuiButton(0, guiLeft+ 100, guiTop +40, 60,20,"test")); // adds the button id, xlocation reletive to gui top, y location likewise releative, size of buton lenghth,size of button width, txt on button
	}
	
	@Override
	protected void actionPerformed(GuiButton button){
		if (button.id == 0) { //the id of the button so lets see if its clicked
			System.out.println("clicketyclcik"); // if it is lets print some text
			PacketHandler.sendButtonPacket((byte)button.id); //send the button id to the packet and let the server know the player hit the button
		}
		
	}
	

}
