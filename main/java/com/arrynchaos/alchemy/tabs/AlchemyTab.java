package com.arrynchaos.alchemy.tabs;

import com.arrynchaos.alchemy.AlchemyMod;
import com.arrynchaos.alchemy.init.AlchemyItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AlchemyTab extends CreativeTabs 
{
	 
    public AlchemyTab(String name) 
    {
        super(AlchemyMod.MODID + "." + name);
    }
 
    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() 
    {
        return new ItemStack(AlchemyItems.MORTAR_PESTLE_WOOD);
    }
 
}
