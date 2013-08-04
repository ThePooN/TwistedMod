package com.mrgreaper.twisted.interfaces;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
	
	public GuiHandler(){
		NetworkRegistry.instance().registerGuiHandler(TwistedMod.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID){
		case 0:
			break;
		case 1:
			System.out.println("case 1 OK");
			TileEntity tee = world.getBlockTileEntity(x, y, z);
			if (tee != null && tee instanceof TileEntityRebunnyator){
				System.out.println(tee);
				return new ContainerRebunnyator(player.inventory, (TileEntityRebunnyator)tee);
			}else{
				System.out.println ("i could not find the tile entity " + tee);
			}
			break;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
		case 0:
		break;
			case 1:
				TileEntity tee = world.getBlockTileEntity(x, y, z);
			if (tee != null && tee instanceof TileEntityRebunnyator){
				return new GuiRebunnyator(player.inventory, (TileEntityRebunnyator)tee);
			}
				
				break;
			}
		return null;
	}

}
