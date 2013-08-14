package com.mrgreaper.twisted.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;


/*public class ModelDeathOrb extends ModelBase
{
	  //fields
	    public ModelRenderer core;
	    public ModelRenderer Shape1;
	    public ModelRenderer Shape2;
	    public ModelRenderer Shape3;
	    public ModelRenderer Shape4;
	    public ModelRenderer core2;
	  
	  public ModelDeathOrb()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      core = new ModelRenderer(this, 0, 0);
	      core.addBox(0F, 0F, 0F, 4, 1, 4);
	      core.setRotationPoint(0F, 0F, 0F);
	      core.setTextureSize(64, 32);
	      core.mirror = true;
	      setRotation(core, 0F, 0F, 0F);
	      Shape1 = new ModelRenderer(this, 24, 10);
	      Shape1.addBox(0F, 0F, 0F, 2, 1, 2);
	      Shape1.setRotationPoint(-1F, 1F, 1F);
	      Shape1.setTextureSize(64, 32);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);
	      Shape2 = new ModelRenderer(this, 28, 0);
	      Shape2.addBox(0F, 0F, 0F, 2, 1, 2);
	      Shape2.setRotationPoint(1F, 1F, -1F);
	      Shape2.setTextureSize(64, 32);
	      Shape2.mirror = true;
	      setRotation(Shape2, 0F, 0F, 0F);
	      Shape3 = new ModelRenderer(this, 28, 0);
	      Shape3.addBox(0F, 0F, 0F, 2, 1, 2);
	      Shape3.setRotationPoint(1F, 1F, 3F);
	      Shape3.setTextureSize(64, 32);
	      Shape3.mirror = true;
	      setRotation(Shape3, 0F, 0F, 0F);
	      Shape4 = new ModelRenderer(this, 24, 10);
	      Shape4.addBox(0F, 0F, 0F, 2, 1, 2);
	      Shape4.setRotationPoint(3F, 1F, 1F);
	      Shape4.setTextureSize(64, 32);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0F, 0F);
	      core2 = new ModelRenderer(this, 0, 0);
	      core2.addBox(0F, 0F, 0F, 4, 1, 4);
	      core2.setRotationPoint(0F, 2F, 0F);
	      core2.setTextureSize(64, 32);
	      core2.mirror = true;
	      setRotation(core2, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	    core.render(f5);
	    Shape1.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape4.render(f5);
	    core2.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  }

	}


*/
//bellow failed attempt to use obj
@SideOnly(Side.CLIENT)
public class ModelDeathOrb extends ModelBase
{
    private IModelCustom modelDeathOrb;
    
    public ModelDeathOrb() {
    	modelDeathOrb = AdvancedModelLoader.loadModel("/assets/twisted/models/deathorb.obj");
    }

}
