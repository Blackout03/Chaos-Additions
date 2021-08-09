package com.blackout.caadditions.enums;

import io.github.chaosawakens.common.registry.CABlocks;
import io.github.chaosawakens.common.registry.CAItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum CAAdditionsItemTier implements IItemTier {
    TOOL_EMERALD(3, 1300, 8, 6, 24, () -> Ingredient.of(Items.EMERALD.getItem())),

    TOOL_AMETHYST(3, 2000, 9, 11, 18, () -> Ingredient.of(CAItems.AMETHYST.get())),

    TOOL_RUBY(4, 1800, 10, 16, 22, () -> Ingredient.of(CAItems.RUBY.get())),

    TOOL_TIGERS_EYE(3, 1600, 10, 8, 20, () -> Ingredient.of(CAItems.TIGERS_EYE.get())),

    TOOL_CRYSTAL_WOOD(0, 300, 2, 1, 6, () -> Ingredient.of(CABlocks.CRYSTAL_WOOD.get())),

    TOOL_KYANITE(1, 800, 3, 2, 6, () -> Ingredient.of(CABlocks.KYANITE.get())),

    TOOL_PINK_TOURMALINE(2, 1100, 7, 8, 6, () -> Ingredient.of(CAItems.PINK_TOURMALINE_INGOT.get())),

    TOOL_CATS_EYE(3, 1600, 8, 8, 20, () -> Ingredient.of(CAItems.CATS_EYE_INGOT.get())),

    TOOL_ULTIMATE(5, 3000, 15, 36, 64, () -> Ingredient.of(CAItems.TITANIUM_INGOT.get(), CAItems.URANIUM_INGOT.get())),

    TOOL_COPPER(1, 150, 4, 2, 6, () -> Ingredient.of(CAItems.COPPER_LUMP.get())),

    TOOL_TIN(1, 180, 5, 3, 8, () -> Ingredient.of(CAItems.TIN_LUMP.get())),

    TOOL_SILVER(2, 450, 7, 4, 10, () -> Ingredient.of(CAItems.SILVER_LUMP.get())),

    TOOL_PLATINUM(3, 1600, 8, 6, 12, () -> Ingredient.of(CAItems.PLATINUM_LUMP.get()));


    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    CAAdditionsItemTier(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = damage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    public float getSpeed() {
        return this.efficiency;
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public int getLevel() {
        return this.harvestLevel;
    }

    public int getUses() {
        return this.maxUses;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
