package com.blackout.chaosadditions.events;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.api.IAutoEnchantable;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class CraftingEventSubscriber {

    public static void onItemCraftedEvent(final PlayerEvent.ItemCraftedEvent event) {

        ChaosAdditions.LOGGER.debug("CRAFTING", event.getCrafting());

        Item enchantedItem = event.getCrafting().getItem();
        if(event.getCrafting().getItem() instanceof IAutoEnchantable) {
            for(EnchantmentData enchant : ((IAutoEnchantable) enchantedItem).enchantments()) {
                event.getCrafting().enchant( enchant.enchantment, enchant.level);
            }
        }
    }
}
