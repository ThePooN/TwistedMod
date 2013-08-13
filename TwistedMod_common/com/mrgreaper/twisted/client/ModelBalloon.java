package com.mrgreaper.twisted.client;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloon extends ModelBase {

	private ArrayList<ModelRenderer> parts;
	
	public ModelBalloon() {
		textureWidth = 64;
		textureHeight = 64;
	
		parts = new ArrayList<ModelRenderer>();
		
		ModelRenderer main = new ModelRenderer(this, 0, 0);
		main.addBox(-5, -5, -5, 
					10, 10, 10);
		main.setRotationPoint(0, 0, 0);
		parts.add(main);
		
		ModelRenderer pillars = new ModelRenderer(this, 0, 20);
		for (int x = -1; x <= 1; x += 2) {
			for (int z = -1; z <= 1; z +=2) {
				pillars.addBox(-1 + x * 4, -1, -1 + z * 4, 
								2, 2, 2);
			}			
		}
		
		pillars.setRotationPoint(0, -6, 0);
		parts.add(pillars);
		
		ModelRenderer top = new ModelRenderer(this, 0, 20);
		top.addBox(-5, -2, -5, 
					10, 4, 10);
					
		top.setRotationPoint(0, -9, 0);	
		parts.add(top);	
		
		for (float r = 0; r <= Math.PI * 2; r += Math.PI / 2) {
			ModelRenderer side = new ModelRenderer(this, 0, 34);
			side.addBox(-4, -2.5F, 5, 
						8, 5, 1);
						
			side.setRotationPoint(0, 0, 0);	
			side.rotateAngleY = r;
			parts.add(side);		
		}
	}
	
	@Override
	public void render(Entity entity, float val1, float val2, float val3, float val4, float val5, float mult) {
		for (ModelRenderer part : parts) {
			part.render(mult);
		}
	}
	
}
