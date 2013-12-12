package com.mrgreaper.twisted.blocks;

import com.mrgreaper.twisted.TwistedMod;
import com.mrgreaper.twisted.tileentities.TileEntityAlarm;
import com.mrgreaper.twisted.tileentities.TileEntityRebunnyator;
import com.mrgreaper.twisted.tileentities.TileEntitySlavedBunny;

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

public class BlockSlavedBunny extends BlockContainer {

	protected BlockSlavedBunny(int id) {
		super(id, Material.iron);
		setCreativeTab(TwistedMod.tabTwisted);
		setHardness(2f);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.SLAVEDBUNNY_UNLOCALIZED_NAME);
		}
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		topIcon = register.registerIcon("twisted:slavedbunny_side");
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION +":"+  BlockInfo.SLAVEDBUNNY_TEXTURE);
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
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySlavedBunny();
	}

}
