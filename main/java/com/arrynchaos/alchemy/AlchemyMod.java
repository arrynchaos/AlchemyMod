package com.arrynchaos.alchemy;

import org.apache.logging.log4j.Logger;

import com.arrynchaos.alchemy.proxy.IProxy;
import com.arrynchaos.alchemy.tabs.AlchemyTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AlchemyMod.MODID, name = AlchemyMod.NAME, version = AlchemyMod.VERSION, acceptedMinecraftVersions = AlchemyMod.MC_VERSION)
public class AlchemyMod 
{ 
    public static final String MODID = "alchemymod";
    public static final String NAME = "Alchemy Mod";
    public static final String VERSION = "0.0.1";
    public static final String MC_VERSION = "[1.12.2]";
 
    public static final CreativeTabs ALCHEMY_TAB = new AlchemyTab("tabAlchemyMod");

    public static final String CLIENT = "com.arrynchaos.alchemy.proxy.ClientProxy";
    public static final String SERVER = "com.arrynchaos.alchemy.proxy.ServerProxy";
 
    @SidedProxy(clientSide = AlchemyMod.CLIENT, serverSide = AlchemyMod.SERVER)
    public static IProxy proxy;
    
    public static Logger logger;
 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }
 
    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("TutorialMod.NAME " + "says hi!");
    }
 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
 
    }
 
}
