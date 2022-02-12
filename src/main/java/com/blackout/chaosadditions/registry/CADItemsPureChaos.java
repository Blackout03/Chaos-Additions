package com.blackout.chaosadditions.registry;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.config.CADConfig;
import com.blackout.chaosadditions.enums.CADItemTier;
import com.blackout.chaosadditions.items.AIOTItem;
import io.github.chaosawakens.common.registry.CAItemGroups;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChaosAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CADItemsPureChaos {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChaosAdditions.MODID);

    public static final RegistryObject<AIOTItem> MEGANIUM_AIOT = ITEMS.register("meganium_aiot", () -> new AIOTItem(CADItemTier.TOOL_MEGANIUM, CADConfig.COMMON.meganiumAIOTDamage.get() - 47, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
}
