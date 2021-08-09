package com.blackout.caadditions;

import com.blackout.caadditions.config.CAAdditionsConfig;
import com.blackout.caadditions.data.CAAdditionsItemModelGenerator;
import com.blackout.caadditions.data.CAAdditionsRecipeGenerator;
import com.blackout.caadditions.events.CraftingEventSubscriber;
import com.blackout.caadditions.events.LoginEventHandler;
import com.blackout.caadditions.registry.CAAdditionsItems;
import io.github.chaosawakens.common.config.CAConfig;
import io.github.chaosawakens.data.CAItemModelGenerator;
import io.github.chaosawakens.data.CALootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
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

    public static final Logger LOGGER = LogManager.getLogger();

    public CAAdditions() {
        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();

        LOGGER.debug(MODNAME + " Version is:" + VERSION);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::gatherData);

        CAAdditionsItems.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(new LoginEventHandler());
        if (CAAdditionsConfig.COMMON.showUpdateMessage.get())
            UpdateHandler.init();
        MinecraftForge.EVENT_BUS.addListener(CraftingEventSubscriber::onItemCraftedEvent);
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CAAdditionsConfig.COMMON_SPEC);
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        final ExistingFileHelper existing = event.getExistingFileHelper();

        if (event.includeServer()) {
            dataGenerator.addProvider(new CAAdditionsItemModelGenerator(dataGenerator, existing));
            dataGenerator.addProvider(new CAAdditionsRecipeGenerator(dataGenerator));
        }
    }
}
