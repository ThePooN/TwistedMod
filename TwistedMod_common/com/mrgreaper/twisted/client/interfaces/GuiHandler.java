package com.mrgreaper.twisted.client.interfaces;



import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.tileentities.TileEntityAlarm;
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
			System.out.println("case 0 OK");
			TileEntity te = world.getBlockTileEntity(x, y, z); //get the tile entitys location
			if (te != null && te instanceof TileEntityRebunnyator){ //make sure its not null and is what we want it to be
				System.out.println(te);
				return new ContainerRebunnyator(player.inventory, (TileEntityRebunnyator)te);
			}else{
				System.out.println ("i could not find the tile entity " + te);
			}
			break;
		case 1:
			System.out.println("case 1 OK");
			TileEntity tea = world.getBlockTileEntity(x, y, z); //get the tile entitys location
			if (tea != null && tea instanceof TileEntityAlarm){ //make sure its not null and is what we want it to be
				System.out.println(tea);
				return new ContainerAlarm(player.inventory, (TileEntityAlarm)tea);
			}else{
				System.out.println ("i could not find the tile entity " + tea);
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
			TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityRebunnyator){
			return new GuiRebunnyator(player.inventory, (TileEntityRebunnyator)te);
		}
			
			break;
		case 1:
			TileEntity tea = world.getBlockTileEntity(x, y, z);
		if (tea != null && tea instanceof TileEntityAlarm){
			return new GuiAlarm(player.inventory, (TileEntityAlarm)tea);
		}
			
			break;
			}
		return null;
	}

}
