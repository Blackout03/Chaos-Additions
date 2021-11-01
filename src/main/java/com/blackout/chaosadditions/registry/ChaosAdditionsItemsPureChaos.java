package com.blackout.chaosadditions.registry;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.config.ChaosAdditionsConfig;
import com.blackout.chaosadditions.enums.ChaosAdditionsArmorMaterial;
import com.blackout.chaosadditions.enums.ChaosAdditionsItemTier;
import com.blackout.chaosadditions.items.*;
import io.github.chaosawakens.common.enums.CAItemTier;
import io.github.chaosawakens.common.registry.CAItemGroups;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChaosAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChaosAdditionsItemsPureChaos {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChaosAdditions.MODID);

    public static final RegistryObject<AIOTItem> MEGANIUM_AIOT = ITEMS.register("meganium_aiot", () -> new AIOTItem(ChaosAdditionsItemTier.TOOL_MEGANIUM, ChaosAdditionsConfig.COMMON.meganiumAIOTDamage.get() - 47, -2.4F, new Item.Properties().tab(CAItemGroups.equipmentItemGroup)));
}
