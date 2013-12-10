package com.mrgreaper.twisted.tileentities;

import java.util.Iterator;
import java.util.List;

import com.mrgreaper.twisted.client.sounds.SpeechHandler;

import dan200.computer.api.IComputerAccess;
import dan200.computer.api.ILuaContext;
import dan200.computer.api.IPeripheral;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TileEntitySlavedBunny extends TileEntity implements IPeripheral{

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "EnslavedBunny";
	}

	@Override
	public String[] getMethodNames() {
		// TODO Auto-generated method stub
		return (new String[] { "speak" });
	}

	@Override// peripheral.speak(1,0,60,"By your command") = cylon ......cooool ..and yes im a geek..no i dont care
	public Object[] callMethod(IComputerAccess computer, ILuaContext context,
			int method, Object[] arguments)  throws Exception
            {
		switch(method) {
		case 0: {
			float vVoice = 2;
			float vPitch = ((Number) arguments[0]).floatValue();
			float vPitchRange = ((Number) arguments[1]).floatValue();
			float vPitchShift = ((Number) arguments[2]).floatValue();
			String vSentence = (arguments[3].toString());
			//bellow here is where i try to get players nearby
			double vRange = 15;
			//get bounding box (using beacon code.....this could end badly)
			AxisAlignedBB axisalignedbb =
					AxisAlignedBB.getAABBPool().getAABB((double)this.xCoord, (double)this.yCoord, (double)this.zCoord, (double)(this.xCoord + 1), (double)(this.yCoord + 1), (double)(this.zCoord + 1)).expand(vRange, vRange, vRange);
			//don't check above the map
            axisalignedbb.maxY = (double)this.worldObj.getHeight();
          //get all players in the bounding box
            List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
          //iterate
            Iterator iterator = list.iterator();
            EntityPlayer entityplayer;
//iterate
            while (iterator.hasNext())
            {
                    entityplayer = (EntityPlayer)iterator.next(); //would be nice if i could get the range the player is from the tileentity to control the volume....some day 
			//SpeechHandler.speechSynth(world, entityname, vVoice, vPitch, vPitchRange, vPitchShift, vSentence);
			SpeechHandler.speechSynth(null, null, vVoice, vPitch, vPitchRange, vPitchShift, vSentence);
			
			 {
                 iterator = list.iterator();
//iterate again
                 while (iterator.hasNext())
                 {
                         entityplayer = (EntityPlayer)iterator.next();
		}
			 }
            }
		}
		
		default:
		return null;
		}
	}

	@Override
	public boolean canAttachToSide(int side) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void attach(IComputerAccess computer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(IComputerAccess computer) {
		// TODO Auto-generated method stub
		
	}

}
