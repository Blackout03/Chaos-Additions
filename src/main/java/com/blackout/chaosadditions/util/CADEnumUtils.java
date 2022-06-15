package com.blackout.chaosadditions.util;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.registry.CADItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public class CADEnumUtils {
	public enum CADItemTier implements IItemTier {
		// Harvest level, Max uses, Efficiency, Damage, Enchantability
		TOOL_SAPPHIRE(4, 2200, 9, 14, 20, () -> Ingredient.of(CADItems.SAPPHIRE.get())),
		TOOL_MEGANIUM(6, 1741, 8, 46, 56, null);

		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final Supplier<Ingredient> repairMaterial;

		CADItemTier(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = damage;
			this.enchantability = enchantability;
			this.repairMaterial = repairMaterial;
		}

		@Override
		public int getUses() {
			return this.maxUses;
		}

		@Override
		public float getSpeed() {
			return this.efficiency;
		}

		@Override
		public float getAttackDamageBonus() {
			return this.attackDamage;
		}

		@Override
		public int getLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getEnchantmentValue() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return this.repairMaterial.get();
		}
	}

	public enum CADArmorMaterial implements IArmorMaterial {
		//Name, Durability multiplier, Damage Reduction multiplier, Damage Reduction, Enchantability, Sound Events, Toughness, Knockback Resistance, Repair Material
		SAPPHIRE("sapphire", 34, new int[]{3, 7, 8, 3}, 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5f, 0f, () -> Ingredient.of(CADItems.SAPPHIRE.get()));

		private final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
		private final String name;
		private final int durability;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundOnEquip;
		private final float toughness;
		private final float knockbackResistance;
		private final Supplier<Ingredient> repairMaterial;

		CADArmorMaterial(String nameIn, int durabilityIn, int[] damageReductionAmountArrayIn, int enchantabilityIn, SoundEvent soundOnEquip, float toughnessIn, float knockbackResistanceIn, Supplier<Ingredient> repairMaterialIn) {
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
}
