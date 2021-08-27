package com.blackout.chaosadditions.util;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ToolUtil {

    public static ActionResultType
    hoeUse(ItemUseContext ctx) {
        ItemStack stack = ctx.getItemInHand();
        PlayerEntity player = ctx.getPlayer();
        World world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Direction side = ctx.getClickedFace();

        if (player == null || !player.mayUseItemAt(pos, side, stack)) {
            return ActionResultType.PASS;
        } else {
            if (ctx.getClickedFace() != Direction.DOWN && world.isEmptyBlock(pos.above())) {
                BlockState blockstate = world.getBlockState(pos).getToolModifiedState(world, pos, ctx.getPlayer(), ctx.getItemInHand(), ToolType.HOE);
                if (blockstate != null) {
                    if (blockstate.getBlock() == Blocks.FARMLAND) {
                        blockstate = Blocks.FARMLAND.defaultBlockState();
                    }
                    world.playSound(player, pos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (!world.isClientSide) {
                        world.setBlockAndUpdate(pos, blockstate);
                        ctx.getItemInHand().hurtAndBreak(1, player, (playerEntity) -> {
                            playerEntity.broadcastBreakEvent(ctx.getHand());
                        });
                    }

                    return ActionResultType.sidedSuccess(world.isClientSide);
                } else if (world.getBlockState(pos).getBlock() instanceof FarmlandBlock) {
                    Block block = null;
                    block = Blocks.GRASS_BLOCK;
                    if (block != null) {
                        world.setBlockAndUpdate(pos, block.defaultBlockState());
                        if (world.getBlockState(pos).getBlock() == Blocks.FARMLAND) {
                            player.setPos(player.getX(), player.getY() + 0.0625, player.getZ());
                        }
                        return ActionResultType.sidedSuccess(world.isClientSide);
                    }
                }
            }
            return ActionResultType.PASS;
        }
    }

    public static ActionResultType shovelUse(ItemUseContext ctx) {
        // vanilla copy
        World world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (ctx.getClickedFace() != Direction.DOWN) {
            PlayerEntity player = ctx.getPlayer();
            BlockState modifiedState = state.getToolModifiedState(world, pos, player, ctx.getItemInHand(), ToolType.SHOVEL);
            if (modifiedState != null && world.isEmptyBlock(pos.above())) {
                world.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            } else if (state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
                if (!world.isClientSide()) {
                    world.levelEvent(null, 1009, pos, 0);
                }

                CampfireBlock.dowse(world, pos, state);
                modifiedState = state.setValue(CampfireBlock.LIT, false);
            }

            if (modifiedState != null) {
                if (!world.isClientSide) {
                    world.setBlockAndUpdate(pos, modifiedState);
                    if (player != null) {
                        ctx.getItemInHand().hurtAndBreak(1, player, (entity) -> {
                            entity.broadcastBreakEvent(ctx.getHand());
                        });
                    }
                }

                return ActionResultType.sidedSuccess(world.isClientSide);
            }
        }
        return ActionResultType.PASS;
    }

    public static ActionResultType axeUse(ItemUseContext ctx) {
        // vanilla copy
        World world = ctx.getLevel();
        BlockPos blockpos = ctx.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState block = blockstate.getToolModifiedState(world, blockpos, ctx.getPlayer(), ctx.getItemInHand(), net.minecraftforge.common.ToolType.AXE);
        if (block != null) {
            PlayerEntity playerentity = ctx.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isClientSide) {
                world.setBlockAndUpdate(blockpos, block);
                if (playerentity != null) {
                    ctx.getItemInHand().hurtAndBreak(1, playerentity, (player) -> {
                        player.broadcastBreakEvent(ctx.getHand());
                    });
                }
            }

            return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
            return ActionResultType.PASS;
        }
    }
}