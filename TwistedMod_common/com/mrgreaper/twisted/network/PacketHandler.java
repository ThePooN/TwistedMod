package com.mrgreaper.twisted.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
		
		int entityId = reader.readInt();

		EntityPlayer entityPlayer = (EntityPlayer)player;
		Entity entity = entityPlayer.worldObj.getEntityByID(entityId);//		Entity entity = entityPlayer.worldObj.getEntityByID(entityId);
//		if (entity != null && entity instanceof EntitySpaceship && entity.riddenByEntity == entityPlayer){ //check to see if the entity is an entity..and if it is mounted on the ship
//			((EntitySpaceship)entity).doDrop();
		}
		

}
