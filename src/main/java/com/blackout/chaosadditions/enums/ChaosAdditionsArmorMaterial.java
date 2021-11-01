package com.blackout.chaosadditions.enums;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.registry.ChaosAdditionsItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public enum ChaosAdditionsArmorMaterial implements IArmorMaterial {
    //Name, Durability multiplier, Damage Reduction multiplier, Damage Reduction, Enchantability, Sound Events, Toughness, Knockback Resistance, Repair Material
    SAPPHIRE("sapphire", 34, new int[] {3, 7, 8, 3}, 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5f, 0f, () -> {
        return Ingredient.of(ChaosAdditionsItems.SAPPHIRE.get());
    });

    private final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
    private final String name;
    private final int durability;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundOnEquip;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    ChaosAdditionsArmorMaterial(String nameIn, int durabilityIn, int[] damageReductionAmountArrayIn, int enchantabilityIn, SoundEvent soundOnEquip, float toughnessIn,
                                float knockbackResistanceIn, Supplier<Ingredient> repairMaterialIn) {

        this.name = ChaosAdditions.MODID + ":" + nameIn;
        this.durability = durabilityIn;
        this.damageReductionAmountArray = damageReductionAmountArrayIn;
        this.enchantability = enchantabilityIn;
        this.soundOnEquip = soundOnEquip;
        this.toughness = toughnessIn;
        this.knockbackResistance = knockbackResistanceIn;
        this.repairMaterial = repairMaterialIn;

    }
    @Override
    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
        return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * this.durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
        return this.damageReductionAmountArray[p_200902_1_.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundOnEquip;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
