package com.mrgreaper.twisted.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.mrgreaper.twisted.client.interfaces.ContainerRebunnyator;
import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
		
		EntityPlayer entityPlayer = (EntityPlayer)player;
		
		byte packetId = reader.readByte();
	
		System.out.println("packet id is : " + packetId);
		switch (packetId) {
		case 0:
			byte buttonId = reader.readByte();
			Container container = entityPlayer.openContainer; //the server will know that the player still has this open ..it sees the container as we automagicly get the players name via packet
			if (container !=null && container instanceof ContainerRebunnyator){
				TileEntityRebunnyator rebunnyator = ((ContainerRebunnyator)container).getRebunnyator();//here is where we get the tile entity name
				rebunnyator.recieveButtonEvent(buttonId);
			}
			break;
			
		}
		
		}
	public static void sendButtonPacket(byte id) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream =new DataOutputStream(byteStream);
		
		try{
			dataStream.writeByte((byte)0); //the id for this part of the packet
			dataStream.writeByte(id);
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(ModInformation.CHANNEL,  byteStream.toByteArray()));
		    System.out.println(id);
		}catch(IOException ex){
			System.err.append("failed to send button packet");
		}
	}
		

}
