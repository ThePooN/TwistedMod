package com.mrgreaper.twisted.blocks;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockStaticGen extends BlockContainer{

		public BlockStaticGen(int id) {
			super(id, Material.iron);
			
			setCreativeTab(TwistedMod.tabTwisted);
			setHardness(2f);
			setStepSound(Block.soundMetalFootstep);
			setUnlocalizedName(BlockInfo.STATICGEN_UNLOCALIZED_NAME);
		}
		@SideOnly(Side.CLIENT)
		private Icon topIcon;
		@SideOnly(Side.CLIENT)
		private Icon sideIcon;
		
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister register){
			topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION +":"+  BlockInfo.STATICGEN_TOP);
			sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION +":"+  BlockInfo.STATICGEN_SIDES);
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
				FMLNetworkHandler.openGui(player, TwistedMod.instance, 1, world, x, y, z);
				System.out.println("it was clicked");
			}
				return true;
				}
    	@Override
    	public TileEntity createNewTileEntity(World world) {
    		return new TileEntityRebunnyator();
    	}

}
