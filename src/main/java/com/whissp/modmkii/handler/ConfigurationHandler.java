package com.whissp.modmkii.handler;

import com.whissp.modmkii.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{

    public static Configuration configuration;
    public static boolean testValue=false;
    public static boolean otherValue=false;


    public static void init(File configFile) {
        // Create the configuration object from the given configuration file
        if(configuration==null)
        {
            configuration=new Configuration(configFile);
        }
    }

    @SubscribeEvent
    private void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    public void loadConfiguration()
    {
        testValue=configuration.getBoolean("configValue",Configuration.CATEGORY_GENERAL,false,"this is an example config value");
        otherValue=configuration.getBoolean("configValue",Configuration.CATEGORY_GENERAL,false,"this is an example config value");
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }


}
