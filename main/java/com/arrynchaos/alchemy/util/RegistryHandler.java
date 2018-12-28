package com.arrynchaos.alchemy.util;

import com.arrynchaos.alchemy.item.MortarPestleWood;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler 
{
 
    @SubscribeEvent
    public static void registerItems(Register<Item> event) 
    {
        final Item[] items = 
        	{
                new MortarPestleWood("mortarpestleWood", "mortar_pestle_wood")        
        	}; 
        event.getRegistry().registerAll(items);
    }
 
}