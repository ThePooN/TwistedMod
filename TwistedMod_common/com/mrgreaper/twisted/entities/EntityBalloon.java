package com.mrgreaper.twisted.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBalloon extends Entity {
	public EntityBalloon(World world){
		super(world);
	}
	
	private double startY;
	private double targetY;
	
	public EntityBalloon(World world, double x, double y, double z){
		this(world);
		
		posX = x;
		startY = posY = y;
		posZ = z;
	}
	
	@Override 
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound){
		startY= nbttagcompound.getShort("Start");
		targetY = nbttagcompound.getShort("Target");
	}

	@Override 
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound){
		nbttagcompound.setShort("Start", (short)startY);
		nbttagcompound.setShort("Target", (short)targetY);
	}
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!worldObj.isRemote){
			if (targetY == 0 ||Math.abs(posY - targetY) < 0.25){ //are we at the target?
				targetY = startY + worldObj.rand.nextDouble()* 5; //ah yes then lets get a new target!
			}
			
			if (posY < targetY){ //are we bellow the targe?
				motionY= 0.05; //move up
			}else{ //ah then we must be above the target
				motionY = - 0.05; //move down
			}
			
		}
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

}
