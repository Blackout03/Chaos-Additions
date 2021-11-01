package com.blackout.chaosadditions.items;

import com.blackout.chaosadditions.registry.ChaosAdditionsItems;
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
    public void onArmorTick(@Nonnull ItemStack stack, World world, PlayerEntity player) {
        if (player.isUnderWater()) {
            if (player.getItemBySlot(EquipmentSlotType.HEAD).sameItem(ChaosAdditionsItems.SAPPHIRE_HELMET.get().getDefaultInstance()) &&
                    player.getItemBySlot(EquipmentSlotType.CHEST).sameItem(ChaosAdditionsItems.SAPPHIRE_CHESTPLATE.get().getDefaultInstance()) &&
                    player.getItemBySlot(EquipmentSlotType.LEGS).sameItem(ChaosAdditionsItems.SAPPHIRE_LEGGINGS.get().getDefaultInstance()) &&
                    player.getItemBySlot(EquipmentSlotType.FEET).sameItem(ChaosAdditionsItems.SAPPHIRE_BOOTS.get().getDefaultInstance())) {

                player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 100, 0, false, false, false));
                player.addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 100, 0, false, false, false));
            }
        } else {
            player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 1, false, false, false));
        }
    }
}
