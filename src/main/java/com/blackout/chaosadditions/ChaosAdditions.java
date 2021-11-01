package com.blackout.chaosadditions;

import com.blackout.chaosadditions.config.ChaosAdditionsConfig;
import com.blackout.chaosadditions.data.ChaosAdditionsItemModelGenerator;
import com.blackout.chaosadditions.data.ChaosAdditionsLootProvider;
import com.blackout.chaosadditions.data.ChaosAdditionsLootTableProvider;
import com.blackout.chaosadditions.data.ChaosAdditionsRecipeGenerator;
import com.blackout.chaosadditions.events.BiomeLoadingEventHandler;
import com.blackout.chaosadditions.events.LoginEventHandler;
import com.blackout.chaosadditions.events.ToolTipEventSubscriber;
import com.blackout.chaosadditions.registry.ChaosAdditionsBlocks;
import com.blackout.chaosadditions.registry.ChaosAdditionsGlobalLootModifier;
import com.blackout.chaosadditions.registry.ChaosAdditionsItems;
import com.blackout.chaosadditions.registry.ChaosAdditionsItemsPureChaos;
import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.config.CAConfig;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

@Mod(ChaosAdditions.MODID)
public class ChaosAdditions {

    public static final String MODID = "chaosadditions";
    public static final String MODNAME = "Chaos Additions";
    public static final String VERSION = "0.3";

    public static final Logger LOGGER = LogManager.getLogger();

    public ChaosAdditions() {
        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();

        LOGGER.debug(MODNAME + " is an Addon for: " + ChaosAwakens.MODNAME + "!");
        LOGGER.debug("The Mod ID of " + MODNAME + " is: " + MODID);
        LOGGER.debug("The Mod ID of " + ChaosAwakens.MODNAME + " is: " + ChaosAwakens.MODID);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::gatherData);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            MinecraftForge.EVENT_BUS.addListener(ToolTipEventSubscriber::onToolTipEvent);
        }

        ChaosAdditionsBlocks.ITEM_BLOCKS.register(eventBus);
        ChaosAdditionsBlocks.BLOCKS.register(eventBus);
        ChaosAdditionsItems.ITEMS.register(eventBus);
        if (ModList.get().isLoaded("purechaos")) ChaosAdditionsItemsPureChaos.ITEMS.register(eventBus);
        ChaosAdditionsGlobalLootModifier.LOOT_MODIFIER_SERIALIZERS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(new LoginEventHandler());
        if (CAConfig.COMMON.showUpdateMessage.get()) UpdateHandler.init();
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeLoadingEventHandler::onBiomeLoadingEvent);
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ChaosAdditionsConfig.COMMON_SPEC);
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        final ExistingFileHelper existing = event.getExistingFileHelper();

        if (event.includeServer()) {
            dataGenerator.addProvider(new ChaosAdditionsItemModelGenerator(dataGenerator, existing));
            dataGenerator.addProvider(new ChaosAdditionsRecipeGenerator(dataGenerator));
            dataGenerator.addProvider(new ChaosAdditionsLootTableProvider(dataGenerator));
            dataGenerator.addProvider(new ChaosAdditionsLootProvider(dataGenerator));
        }
    }
}
