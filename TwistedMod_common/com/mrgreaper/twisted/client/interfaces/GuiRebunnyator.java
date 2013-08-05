package com.mrgreaper.twisted.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

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
	
	

}
