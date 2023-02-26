package com.blackout.chaosadditions.items;

import com.blackout.chaosadditions.registry.CADItems;
import io.github.chaosawakens.api.IUtilityHelper;
import io.github.chaosawakens.common.registry.CAItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SapphireArmorItem extends ArmorItem {
	public SapphireArmorItem(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlot, Properties properties) {
		super(armorMaterial, equipmentSlot, properties);
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if (world.isClientSide) return;
		if (player.isUnderWater()) {
			if (player.getArmorSlots() != null) {
				if (IUtilityHelper.isFullArmorSet(player, CADItems.SAPPHIRE_HELMET.get(), CADItems.SAPPHIRE_CHESTPLATE.get(), CADItems.SAPPHIRE_LEGGINGS.get(), CADItems.SAPPHIRE_BOOTS.get())) {
					player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 100, 0, false, false, false));
					player.addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 100, 0, false, false, false));
				}
			}
		}
	}
}
