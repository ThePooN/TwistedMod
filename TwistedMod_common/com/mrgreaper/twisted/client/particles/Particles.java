package com.mrgreaper.twisted.client.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public enum Particles {
	POISON;
	
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
			if (distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ > maxDistance * maxDistance){ //arghhhhhhhhhhhhhhhhhhhh! triganamutry arghhhh
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
