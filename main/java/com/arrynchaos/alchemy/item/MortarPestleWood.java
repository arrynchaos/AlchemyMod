package com.arrynchaos.alchemy.item;

import javax.annotation.Nullable;

import com.arrynchaos.alchemy.AlchemyMod;
import com.arrynchaos.alchemy.gui.BrewingGui;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class MortarPestleWood extends Item 
{
	 
    public MortarPestleWood(String unlocalizedName, String registryName) 
    {
        setUnlocalizedName(AlchemyMod.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(AlchemyMod.ALCHEMY_TAB);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) 
    {
    	{
    		Minecraft.getMinecraft().displayGuiScreen(new BrewingGui());
    	}
    	return super.onItemRightClick(worldIn, player, hand);
    	
    }
    
    ItemStackHandler inventory = new ItemStackHandler(5);
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	inventory.deserializeNBT(compound.getCompoundTag("inventory"));
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) 
    {
    	compound.setTag("inventory", inventory.serializeNBT());
    	return super.writeToNBT(compound);
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
    	return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }
    
    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) 
    {
    	return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }
}