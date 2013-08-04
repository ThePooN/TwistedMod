package com.mrgreaper.twisted.client.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public enum Particles {
	POISON;//poison particle effect by vswe, kept here so that i can see how its done (im old the memory gets ...whats the word..
	
	public void spawnParticle(World world, double X, double Y, double Z, double motionX, double motionY, double motionZ){
		Minecraft mc = Minecraft.getMinecraft();
		if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null){
			int particleSetting = mc.gameSettings.particleSetting;
			
			if (particleSetting ==2 || (particleSetting == 1 && world.rand.nextInt(3) == 0)){ //if particle setting is 1 then randomize which particle to render
				return;
			}
			
			double distanceX = mc.renderViewEntity.posX - X;
			double distanceY = mc.renderViewEntity.posY - Y;
			double distanceZ = mc.renderViewEntity.posZ - Z;
			
			double maxDistance = 16;
			if (distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ > maxDistance * maxDistance){ //arghhhhhhhhhhhhhhhhhhhh! Trigonometry arghhhh its here to see how far the player is from the particle so we dont render them to players too far away!
				return;
			}
			
			EntityFX particleEffect = null;
			switch(this) {
			case POISON:
				particleEffect = new EntityPoisonFX(world, X, Y, Z, motionX, motionY, motionZ);
				break;
			}
			
			if (particleEffect !=null){
				Minecraft.getMinecraft().effectRenderer.addEffect(particleEffect);
				
			}
		}
	}

}
