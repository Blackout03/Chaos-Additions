package com.blackout.chaosadditions.events;

import com.blackout.chaosadditions.registry.ChaosAdditionsConfiguredFeatures;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class BiomeLoadingEventHandler {
    public static void onBiomeLoadingEvent(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();

        StructureHandler.addfeatures(event);
    }


    private static class StructureHandler {

        public static void addfeatures(BiomeLoadingEvent event) {
            BiomeGenerationSettingsBuilder gen = event.getGeneration();

            RegistryKey<Biome> biome = RegistryKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(event.getName(), "Who registered null name biome, naming criticism!"));

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)) {
                addOceanOres(gen);
            }
        }

        private static void addOceanOres(BiomeGenerationSettingsBuilder gen) {
            gen.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ChaosAdditionsConfiguredFeatures.ORE_SAPPHIRE);
        }
    }
}
