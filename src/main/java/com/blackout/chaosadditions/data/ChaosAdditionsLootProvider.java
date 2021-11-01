package com.blackout.chaosadditions.data;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.loot.ChaosAdditionsLootModifier;
import com.blackout.chaosadditions.registry.ChaosAdditionsGlobalLootModifier;
import com.blackout.chaosadditions.registry.ChaosAdditionsItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ChaosAdditionsLootProvider extends GlobalLootModifierProvider {
    public ChaosAdditionsLootProvider(DataGenerator gen) {
        super(gen, ChaosAdditions.MODID);
    }

    @Override
    protected void start() {
        add("sapphire_treasure", ChaosAdditionsGlobalLootModifier.SAPPHIRE_TREASURE.get(), new ChaosAdditionsLootModifier(
                new ILootCondition[] {
                        LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_treasure")).build()
                }, 0.125f, 1, 1, ChaosAdditionsItems.SAPPHIRE.get()
        ));
    }
}
