package com.blackout.caadditions.registry;

import com.blackout.caadditions.CAAdditions;
import com.blackout.caadditions.config.CAAdditionsConfig;
import com.blackout.caadditions.items.AIOTItem;
import com.blackout.caadditions.items.EnchantedAIOTItem;
import io.github.chaosawakens.common.enums.ToolMaterials;
import io.github.chaosawakens.common.registry.CAItemGroups;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ShieldItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = CAAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CAAdditionsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CAAdditions.MODID);

    public static final RegistryObject<AIOTItem> EMERALD_AIOT = ITEMS.register("emerald_aiot", () -> new EnchantedAIOTItem(ToolMaterials.TOOL_EMERALD, CAAdditionsConfig.COMMON.emeraldAIOTDamage.get() - 7, -2.8F, new Item.Properties().tab(CAItemGroups.equipmentItemGroup), new EnchantmentData[] { new EnchantmentData(Enchantments.SILK_TOUCH, 1)}));
    public static final RegistryObject<AIOTItem> AMETHYST_AIOT = ITEMS.register("amethyst_aiot", () -> new AIOTItem(ToolMaterials.TOOL_AMETHYST, CAAdditionsConfig.COMMON.amethystAIOTDamage.get() - 7, -2.8F, new Item.Properties().tab(CAItemGroups.equipmentItemGroup)));
    public static final RegistryObject<AIOTItem> TIGERS_EYE_AIOT = ITEMS.register("tigers_eye_aiot", () -> new AIOTItem(ToolMaterials.TOOL_TIGERS_EYE, CAAdditionsConfig.COMMON.tigersEyeAIOTDamage.get() - 7, -2.8F, new Item.Properties().tab(CAItemGroups.equipmentItemGroup)));
    public static final RegistryObject<AIOTItem> RUBY_AIOT = ITEMS.register("ruby_aiot", () -> new AIOTItem(ToolMaterials.TOOL_RUBY, CAAdditionsConfig.COMMON.rubyAIOTDamage.get() - 17, -2.8F, new Item.Properties().tab(CAItemGroups.equipmentItemGroup)));
    public static final RegistryObject<AIOTItem> ULTIMATE_AIOT = ITEMS.register("ultimate_aiot", () -> new EnchantedAIOTItem(ToolMaterials.TOOL_ULTIMATE, CAAdditionsConfig.COMMON.ultimateAIOTDamage.get() - 17, -2.8F, new Item.Properties().tab(CAItemGroups.equipmentItemGroup),
            new EnchantmentData[] { new EnchantmentData(Enchantments.BLOCK_EFFICIENCY, 5), new EnchantmentData(Enchantments.BLOCK_FORTUNE, 5), new EnchantmentData(Enchantments.UNBREAKING, 2)}));

    public static final RegistryObject<ShieldItem> RUBY_SHIELD = ITEMS.register("ruby_shield", () -> new ShieldItem(new Item.Properties().durability(756).tab(CAItemGroups.equipmentItemGroup)));
}
