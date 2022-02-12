package com.blackout.chaosadditions.registry;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.config.CADConfig;
import com.blackout.chaosadditions.enums.CADArmorMaterial;
import com.blackout.chaosadditions.enums.CADItemTier;
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
public class CADItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChaosAdditions.MODID);

    public static final RegistryObject<AIOTItem> WOODEN_AIOT = ITEMS.register("wooden_aiot", () -> new AIOTItem(ItemTier.WOOD, CADConfig.COMMON.woodenAIOTDamage.get() - 1, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> STONE_AIOT = ITEMS.register("stone_aiot", () -> new AIOTItem(ItemTier.STONE, CADConfig.COMMON.stoneAIOTDamage.get() - 2, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> GOLDEN_AIOT = ITEMS.register("golden_aiot", () -> new AIOTItem(ItemTier.GOLD, CADConfig.COMMON.goldenAIOTDamage.get() - 1, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> IRON_AIOT = ITEMS.register("iron_aiot", () -> new AIOTItem(ItemTier.IRON, CADConfig.COMMON.ironAIOTDamage.get() - 3, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> DIAMOND_AIOT = ITEMS.register("diamond_aiot", () -> new AIOTItem(ItemTier.DIAMOND, CADConfig.COMMON.diamondAIOTDamage.get() - 4, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> NETHERITE_AIOT = ITEMS.register("netherite_aiot", () -> new AIOTItem(ItemTier.NETHERITE, CADConfig.COMMON.netheriteAIOTDamage.get() - 5, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));

    public static final RegistryObject<AIOTItem> CRYSTAL_WOOD_AIOT = ITEMS.register("crystal_wood_aiot", () -> new AIOTItem(CAItemTier.TOOL_CRYSTAL_WOOD, CADConfig.COMMON.crystalWoodAIOTDamage.get() - 2, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> KYANITE_AIOT = ITEMS.register("kyanite_aiot", () -> new AIOTItem(CAItemTier.TOOL_KYANITE, CADConfig.COMMON.kyaniteAIOTDamage.get() - 3, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> PINK_TOURMALINE_AIOT = ITEMS.register("pink_tourmaline_aiot", () -> new AIOTItem(CAItemTier.TOOL_PINK_TOURMALINE, CADConfig.COMMON.pinkTourmalineAIOTDamage.get() - 9, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> CATS_EYE_AIOT = ITEMS.register("cats_eye_aiot", () -> new AIOTItem(CAItemTier.TOOL_CATS_EYE, CADConfig.COMMON.catsEyeAIOTDamage.get() - 9, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> COPPER_AIOT = ITEMS.register("copper_aiot", () -> new AIOTItem(CAItemTier.TOOL_COPPER, CADConfig.COMMON.copperAIOTDamage.get() - 3, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> TIN_AIOT = ITEMS.register("tin_aiot", () -> new AIOTItem(CAItemTier.TOOL_TIN, CADConfig.COMMON.tinAIOTDamage.get() - 4, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> SILVER_AIOT = ITEMS.register("silver_aiot", () -> new AIOTItem(CAItemTier.TOOL_SILVER, CADConfig.COMMON.silverAIOTDamage.get() - 5, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> PLATINUM_AIOT = ITEMS.register("platinum_aiot", () -> new AIOTItem(CAItemTier.TOOL_PLATINUM, CADConfig.COMMON.platinumAIOTDamage.get() - 7, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> EMERALD_AIOT = ITEMS.register("emerald_aiot", () -> new EnchantedAIOTItem(CAItemTier.TOOL_EMERALD, CADConfig.COMMON.emeraldAIOTDamage.get() - 7, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT),new EnchantmentData[] { new EnchantmentData(Enchantments.SILK_TOUCH, 1)}));
    public static final RegistryObject<AIOTItem> AMETHYST_AIOT = ITEMS.register("amethyst_aiot", () -> new AIOTItem(CAItemTier.TOOL_AMETHYST, CADConfig.COMMON.amethystAIOTDamage.get() - 12, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> TIGERS_EYE_AIOT = ITEMS.register("tigers_eye_aiot", () -> new AIOTItem(CAItemTier.TOOL_TIGERS_EYE, CADConfig.COMMON.tigersEyeAIOTDamage.get() - 9, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> RUBY_AIOT = ITEMS.register("ruby_aiot", () -> new AIOTItem(CAItemTier.TOOL_RUBY, CADConfig.COMMON.rubyAIOTDamage.get() - 17, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> ULTIMATE_AIOT = ITEMS.register("ultimate_aiot", () -> new EnchantedAIOTItem(CAItemTier.TOOL_ULTIMATE, CADConfig.COMMON.ultimateAIOTDamage.get() - 37, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT),
            new EnchantmentData[] { new EnchantmentData(Enchantments.BLOCK_EFFICIENCY, 5), new EnchantmentData(Enchantments.BLOCK_FORTUNE, 5), new EnchantmentData(Enchantments.UNBREAKING, 2)}));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",() -> new Item(new Item.Properties().tab(CAItemGroups.ITEMS)));

    public static final RegistryObject<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SapphireSwordItem(CADItemTier.TOOL_SAPPHIRE, CADConfig.COMMON.sapphireSwordDamage.get() - 15, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new SapphirePickaxeItem(CADItemTier.TOOL_SAPPHIRE, CADConfig.COMMON.sapphirePickaxeDamage.get() - 15, -2.8F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new SapphireAxeItem(CADItemTier.TOOL_SAPPHIRE, CADConfig.COMMON.sapphireAxeDamage.get() - 15, -3F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new SapphireShovelItem(CADItemTier.TOOL_SAPPHIRE, CADConfig.COMMON.sapphireShovelDamage.get() - 15, -3F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<HoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new SapphireHoeItem(CADItemTier.TOOL_SAPPHIRE, CADConfig.COMMON.sapphireHoeDamage.get() - 15, 0F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<AIOTItem> SAPPHIRE_AIOT = ITEMS.register("sapphire_aiot", () -> new SapphireAIOTItem(CADItemTier.TOOL_SAPPHIRE, CADConfig.COMMON.sapphireAIOTDamage.get() - 15, -2.4F, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));

    public static final RegistryObject<ArmorItem> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new SapphireArmorItem(CADArmorMaterial.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<ArmorItem> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new SapphireArmorItem(CADArmorMaterial.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<ArmorItem> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new SapphireArmorItem(CADArmorMaterial.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
    public static final RegistryObject<ArmorItem> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new SapphireArmorItem(CADArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties().tab(CAItemGroups.EQUIPMENT)));
}
