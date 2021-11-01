package com.blackout.chaosadditions.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SapphireSwordItem extends SwordItem {
    private final float attackDamage;

    public SapphireSwordItem(IItemTier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
        this.attackDamage = (float)attackDamage + tier.getAttackDamageBonus();
    }

    public float getDamage() {
        Entity entity = null;
        PlayerEntity player = (PlayerEntity) entity;
        if (player.isUnderWater()) {
            return this.attackDamage * 2;
        } else {
            return this.attackDamage / 2;
        }
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof PlayerEntity && stack.getItem() == this) {
            PlayerEntity player = (PlayerEntity) entity;
            stack.getOrCreateTag().putBoolean("inWater", player.isUnderWater());
        }
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, BlockState state) {
        float defaultSpeed = super.getDestroySpeed(stack, state);
        boolean isInWater = stack.hasTag() && stack.getTag() != null && stack.getTag().getBoolean("inWater");
        return isInWater ? (defaultSpeed * 3.0F) * 3.0F : (defaultSpeed / 3.0F) / 3.0F;
    }
}