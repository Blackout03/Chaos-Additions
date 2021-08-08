package com.blackout.caadditions.items;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class AIOTItem extends ToolItem {
    public AIOTItem(IItemTier itemTier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super((float)attackDamage, attackSpeed, itemTier, null, properties.addToolType(ToolType.PICKAXE, itemTier.getLevel()).addToolType(ToolType.AXE, itemTier.getLevel()).addToolType(ToolType.SHOVEL, itemTier.getLevel()).addToolType(ToolType.HOE, itemTier.getLevel()));
    }

    public boolean isCorrectToolForDrops(BlockState state) {
        return state.getHarvestTool() == ToolType.AXE || state.getHarvestTool() == ToolType.HOE || state.getHarvestTool() == ToolType.SHOVEL || state.getHarvestTool() == ToolType.PICKAXE;
    }

    public float getDestroySpeed(ItemStack itemStack, BlockState blockState) {
        Material material = blockState.getMaterial();
        return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(itemStack, blockState) : this.speed;
    }

    public ActionResultType useOn(ItemUseContext itemUseContext) {
        PlayerEntity player = itemUseContext.getPlayer();
        World world = itemUseContext.getLevel();
        BlockPos blockpos = itemUseContext.getClickedPos();
        if (player.isShiftKeyDown()) {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(itemUseContext);
            if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
            if (itemUseContext.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
                BlockState blockstate = world.getBlockState(blockpos).getToolModifiedState(world, blockpos, itemUseContext.getPlayer(), itemUseContext.getItemInHand(), net.minecraftforge.common.ToolType.HOE);
                if (blockstate != null) {
                    PlayerEntity playerentity = itemUseContext.getPlayer();
                    world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (!world.isClientSide) {
                        world.setBlock(blockpos, blockstate, 11);
                        if (playerentity != null) {
                            itemUseContext.getItemInHand().hurtAndBreak(1, playerentity, (p_220043_1_) -> p_220043_1_.broadcastBreakEvent(itemUseContext.getHand()));
                        }
                    }

                    return ActionResultType.sidedSuccess(world.isClientSide);
                }
            } else {
                return ActionResultType.PASS;
            }
        } else {
            BlockState blockstate = world.getBlockState(blockpos);
            if (itemUseContext.getClickedFace() == Direction.DOWN) {
                return ActionResultType.PASS;
            } else {
                PlayerEntity playerentity = itemUseContext.getPlayer();
                BlockState blockstate1 = blockstate.getToolModifiedState(world, blockpos, playerentity, itemUseContext.getItemInHand(), net.minecraftforge.common.ToolType.SHOVEL);
                BlockState blockstate2 = null;
                if (blockstate1 != null && world.isEmptyBlock(blockpos.above())) {
                    world.playSound(playerentity, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    blockstate2 = blockstate1;
                } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                    if (!world.isClientSide()) {
                        world.levelEvent(null, 1009, blockpos, 0);
                    }

                    CampfireBlock.dowse(world, blockpos, blockstate);
                    blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.FALSE);
                }

                if (blockstate2 != null) {
                    if (!world.isClientSide) {
                        world.setBlock(blockpos, blockstate2, 11);
                        if (playerentity != null) {
                            itemUseContext.getItemInHand().hurtAndBreak(1, playerentity, (p_220041_1_) -> p_220041_1_.broadcastBreakEvent(itemUseContext.getHand()));
                        }
                    }

                    return ActionResultType.sidedSuccess(world.isClientSide);
                } else {
                    return ActionResultType.PASS;
                }
            }
        }
        if (player.isShiftKeyDown() || !player.isShiftKeyDown()) {
            BlockState blockstate = world.getBlockState(blockpos);
            BlockState block = blockstate.getToolModifiedState(world, blockpos, itemUseContext.getPlayer(), itemUseContext.getItemInHand(), net.minecraftforge.common.ToolType.AXE);
            if (block != null) {
                PlayerEntity playerentity = itemUseContext.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isClientSide) {
                    world.setBlock(blockpos, block, 11);
                    if (playerentity != null) {
                        itemUseContext.getItemInHand().hurtAndBreak(1, playerentity, (p_220040_1_) -> p_220040_1_.broadcastBreakEvent(itemUseContext.getHand()));
                    }
                }

                return ActionResultType.sidedSuccess(world.isClientSide);
            } else {
                return ActionResultType.PASS;
            }
        }
        return ActionResultType.PASS;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        if(Screen.hasShiftDown()) {
            list.add(new TranslationTextComponent("tooltip.caadditions.default.tooltip_1"));
            list.add(new TranslationTextComponent("tooltip.caadditions.default.tooltip_2"));
            list.add(new TranslationTextComponent("tooltip.caadditions.default.tooltip_2"));
        } else {
            list.add(new TranslationTextComponent("tooltip.caadditions.default.tooltip"));
        }
    }
}
