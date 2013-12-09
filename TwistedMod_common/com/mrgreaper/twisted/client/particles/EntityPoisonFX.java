package com.mrgreaper.twisted.client.particles;
//this is from vswe tutorial, its here to help me rather then to be used though i may adapt it
import com.mrgreaper.twisted.blocks.Blocks;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class EntityPoisonFX extends EntityFX{
	
	public EntityPoisonFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ){
		super(world, x, y, z, motionX, motionY, motionZ);
		
		//func_110125_a(Blocks.poison.particleIcon);  //this stopped working on 953, /msg mcpbot !gcm func_110125_a says it should be EntityFX.setParticleIcon but its not
		
		particleScale = 3; //size
		particleAlpha = rand.nextFloat(); //is it solid ? 1 or transparent 0?
		particleBlue = rand.nextFloat();
		particleGreen = rand.nextFloat();
		particleRed = rand.nextFloat();
	}
	
	@Override
	public void onUpdate(){ //every tick do this
	super.onUpdate();
	
	particleScale = (1 - (float)particleAge / particleMaxAge) * 3;
	}
	
	
	@Override
	public int getFXLayer() {
		return 1;
	}
	

}

