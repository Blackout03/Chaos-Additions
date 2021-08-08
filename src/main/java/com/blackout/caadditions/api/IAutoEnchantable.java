package com.blackout.caadditions.api;

import net.minecraft.enchantment.EnchantmentData;

/**
 * Functional interface for items that will come with enchantments when crafted or acquired
 * @author invalid2 | Copied from Chaos Awakens
 */
@FunctionalInterface
public interface IAutoEnchantable {

    EnchantmentData[] enchantments();
}
