package com.mrgreaper.twisted.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRebunnyator extends BlockContainer{//as it has a tile entity we need BlockContainer

	public BlockRebunnyator(int id) {
		super(id, Material.iron);
		
		setCreativeTab(TwistedMod.tabTwisted);
		setHardness(2f);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.REBUNNYATOR_UNLOCALIZED_NAME);
	}
		
		@SideOnly(Side.CLIENT)
		private Icon topIcon;
		@SideOnly(Side.CLIENT)
		private Icon sideIcon;
		
		
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister register){
			topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION +":"+  BlockInfo.REBUNNYATOR_TOP);
			sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION +":"+  BlockInfo.REBUNNYATOR_SIDES);
		}
		
		@SideOnly(Side.CLIENT)
		@Override
		public Icon getIcon(int side, int meta) {
			if (side == 1){
				return topIcon;
			}else{
				return sideIcon;
				}
		}

        @Override
		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
			if (!world.isRemote) {
				FMLNetworkHandler.openGui(player, TwistedMod.instance, 0, world, x, y, z);// the 0 after TwistedMod.instance is the gui id which references to the case in gui handeler (both server and client)
				System.out.println("it was clicked" + player + world);
			}
				return true;
				}
    	@Override
    	public TileEntity createNewTileEntity(World world) {
    		return new TileEntityRebunnyator();
    	}
    	
    	public void breakBlock(World world,int x, int y, int z, int id, int meta){ //lets not lose th contents of the machine on breaking
    		TileEntity te =world.getBlockTileEntity(x, y, z);
    		if (te != null && te instanceof IInventory){
    			IInventory inventory = (IInventory)te;
    			
    			for (int i = 0; i < inventory.getSizeInventory(); i++){
    				ItemStack stack = inventory.getStackInSlotOnClosing(i);
    				
    				if (stack !=null){
    					float spawnx = x + world.rand.nextFloat();
    					float spawny = y + world.rand.nextFloat();
    					float spawnz = z + world.rand.nextFloat();
    					
    					EntityItem droppedItem = new EntityItem(world, spawnx, spawny, spawnz, stack); //dropped items are entitys
    					
    					float mult = 0.5f;
    					
    					droppedItem.motionX = 0.5F + world.rand.nextFloat()* mult; //set its motion * by multi to keep the range small
    					droppedItem.motionY = 4 + world.rand.nextFloat() * mult;
    					droppedItem.motionZ = 0.5F + world.rand.nextFloat() * mult;
    					
    					world.spawnEntityInWorld(droppedItem);// now lets put it into the world
    				}
    			}
    		}
    		super.breakBlock(world, x, y, z, id, meta);
    	}


}


