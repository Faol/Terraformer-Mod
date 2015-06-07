package de.faolblog.terraformer.handler;


import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.faolblog.terraformer.reference.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static Configuration configuration;
    public static boolean testValue=false;
    public static boolean testValue2=false;

    public static void init(File configFile){
        if(configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            //Resync configs
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        testValue=configuration.get(Configuration.CATEGORY_GENERAL,"configValue",true,"Example").getBoolean(true);
        testValue2=configuration.get("Test","configValue",true,"Example").getBoolean(true);
        if(configuration.hasChanged()) {
            configuration.save();
        }

    }
}
