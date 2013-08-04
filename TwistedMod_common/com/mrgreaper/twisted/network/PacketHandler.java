package com.mrgreaper.twisted.network;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		//ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data); //the .data is set bellow
		
		//  //byte packetid= reader.readByte(); //we can check to see what packet id so we know if its the one we want
		// //if (packetid == 0) {
		//int entityId =reader.readInt();
	    //}else if (packetid == 1) {
		//   int x =reader.readInt();
		
		EntityPlayer entityPlayer = (EntityPlayer)player; //get player
//		Entity entity = entityPlayer.worldObj.getEntityByID(entityId);
//		if (entity != null && entity instanceof EntitySpaceship && entity.riddenByEntity == entityPlayer){ //check to see if the entity is an entity..and if it is mounted on the ship
//			((EntitySpaceship)entity).doDrop();
		}
		

}
