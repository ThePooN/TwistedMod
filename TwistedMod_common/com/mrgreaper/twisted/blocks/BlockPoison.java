package com.mrgreaper.twisted.blocks;
//originly from vswe tutorial, in here at the moment as an example file 
//wont be in the finished mod (maybe in the alphas though but not used)
//should help me renember how to use particles
import java.util.Random;

import com.mrgreaper.twisted.client.particles.Particles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockPoison extends Block{
	public BlockPoison(int id){
	super(id, Material.rock);
	
	setCreativeTab(CreativeTabs.tabBlock);
	setHardness(1F);
	setStepSound(Block.soundStoneFootstep);
	setUnlocalizedName(BlockInfo.POISON_UNLOCALIZED_NAME);
	
	}
	@SideOnly(Side.CLIENT)
	public Icon particleIcon; //this is where we set the particle image file
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.POISON_TEXTURE);
		particleIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.POISON_PARTICLE_TEXTURE);//the location of the particle file assets/twisted/textures/blocks/name.png
	}

@Override
@SideOnly(Side.CLIENT) //we only want to track particles on the client side!
public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
	 for (int i = 0; i < 4; i++){
		 
		 float particleX = x + rand.nextFloat();
		 float particleY = y + rand.nextFloat();
		 float particleZ = z + rand.nextFloat();
		 
		 float particleMotionX = -0.5f + rand.nextFloat();
		 float particleMotionY = -0.5f + rand.nextFloat();
		 float particleMotionZ = -0.5f + rand.nextFloat();
		 
		 Particles.POISON.spawnParticle(world, particleX, particleY, particleZ, particleMotionX, particleMotionZ, particleMotionZ);
		// Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPoisonFX(world, particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ));
	 }
}
	 public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){ // an example of how to get an event in game, here its clearly when a player clicks the block
		 if (!world.isRemote){ //this is a check to make sure were on the server side..the server will tell the client what to do ..its bossy like that
			 player.addPotionEffect(new PotionEffect(Potion.poison.id,40, 1)); //adding potion effects is really that easy ! yikes
		 }
	 }

}
		
	
