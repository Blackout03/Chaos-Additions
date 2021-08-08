package com.blackout.caadditions;

import com.blackout.caadditions.config.CAAdditionsConfig;
import com.blackout.caadditions.registry.CAAdditionsItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

@Mod(CAAdditions.MODID)
public class CAAdditions {

    public static final String MODID = "caadditions";
    public static final String MODNAME = "Chaos Awakens Additions";
    public static final String VERSION = "0.1";

    private static final Logger LOGGER = LogManager.getLogger();

    public CAAdditions() {
        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();

        LOGGER.debug(MODNAME + " Version is:" + VERSION);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CAAdditionsItems.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CAAdditionsConfig.COMMON_SPEC);
    }
}
