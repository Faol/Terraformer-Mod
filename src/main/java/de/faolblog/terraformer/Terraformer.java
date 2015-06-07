package de.faolblog.terraformer;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.faolblog.terraformer.handler.ConfigurationHandler;
import de.faolblog.terraformer.init.ModItems;
import de.faolblog.terraformer.proxy.IProxy;
import de.faolblog.terraformer.reference.Reference;
import de.faolblog.terraformer.utility.LogHelper;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION,guiFactory =Reference.GUI_FACTORY_CLASS)
public class Terraformer {
    @Mod.Instance(Reference.MOD_ID)
    public static Terraformer instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY ,serverSide = Reference.CLIENT_PROXY)
    public static IProxy SidedProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        LogHelper.info("Pre Initialization Complete");
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        LogHelper.info("Initialization Complete");
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post Initialization Complete");
    }
}
