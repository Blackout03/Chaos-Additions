package com.blackout.chaosadditions.registry;

import com.blackout.chaosadditions.ChaosAdditions;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class CADTags {
    public static class Items {
        public static final ITag<Item> CUSTOM_TOOLTIPS = ItemTags.bind(ChaosAdditions.MODID + ":custom_tooltips");
    }
}
