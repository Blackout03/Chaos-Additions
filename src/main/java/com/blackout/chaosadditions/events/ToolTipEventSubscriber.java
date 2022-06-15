package com.blackout.chaosadditions.events;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.registry.CADTags;
import io.github.chaosawakens.client.config.CAClientConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class ToolTipEventSubscriber {
	public static void onToolTipEvent(ItemTooltipEvent event) {
		if (CAClientConfig.CLIENT.enableTooltips.get()) {
			final Item item = event.getItemStack().getItem();
			if (item.is(CADTags.Items.CUSTOM_TOOLTIPS)) {
				if (Screen.hasShiftDown() || Screen.hasControlDown())
					event.getToolTip().add(new TranslationTextComponent("tooltip." + ChaosAdditions.MODID + "." + item.getRegistryName().toString().replaceAll(ChaosAdditions.MODID + ":", "")).withStyle(TextFormatting.AQUA));
				else
					event.getToolTip().add(new TranslationTextComponent("tooltip." + ChaosAdditions.MODID + ".default").withStyle(TextFormatting.AQUA));
			}
		}
	}
}
