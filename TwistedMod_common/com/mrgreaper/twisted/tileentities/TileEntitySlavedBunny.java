package com.mrgreaper.twisted.tileentities;

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
			//SpeechHandler.speechSynth(world, entityname, vVoice, vPitch, vPitchRange, vPitchShift, vSentence);
			SpeechHandler.speechSynth(null, null, vVoice, vPitch, vPitchRange, vPitchShift, vSentence);
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
