package com.mrgreaper.twisted.client;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mrgreaper.twisted.entities.EntityDeathOrb;



public class RenderDeathOrb extends Render{

	private ModelDeathOrb model; //see modelDeathOrb class 
	
	public RenderDeathOrb() {
		model = new ModelDeathOrb();
		shadowSize = 0.5f; //set the shadow
	}
	
	private static final ResourceLocation texture = new ResourceLocation("twisted", "models/metal1.png");
	
	public void renderDeathOrb(EntityDeathOrb deathorb, double x, double y, double z, float yaw, float partialTickTime){
		 GL11.glPushMatrix(); //start tools
		 GL11.glTranslatef((float)x,(float) y,(float) z); //this is where we draw the model at the location
		 GL11.glScalef(-1F, -1F, -1F); //this sets the scale
		 func_110777_b(deathorb); //load the texture for the entity
		 
		 model.render(deathorb, 0F, 0F, 0F, 0F, 0F, 0.0625f);// first is the entity the 0f differ depending on what your rendering and the last part is the size (usualy mc models are huge so 0.0625f)
		 
		 GL11.glPopMatrix(); //now we remove the tools
		 
		 
	}
	
	
	
	@Override
	public void doRender(Entity entity, double x, double y, double z,float yaw, float partialTickTime) {	
	   renderDeathOrb((EntityDeathOrb)entity,x,y,z,yaw,partialTickTime);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return texture;
	}
	

}
