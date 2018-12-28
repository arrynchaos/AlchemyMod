package com.arrynchaos.alchemy.item;

import com.arrynchaos.alchemy.AlchemyMod;
import com.arrynchaos.alchemy.gui.BrewingGui;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

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
}