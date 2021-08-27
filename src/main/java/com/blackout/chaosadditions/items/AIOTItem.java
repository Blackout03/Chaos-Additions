package com.blackout.chaosadditions.items;

import com.blackout.chaosadditions.util.ToolUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class AIOTItem extends ToolItem {
    public AIOTItem(IItemTier itemTier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super((float)attackDamage, attackSpeed, itemTier, null, properties
                .addToolType(ToolType.PICKAXE, itemTier.getLevel())
                .addToolType(ToolType.AXE, itemTier.getLevel())
                .addToolType(ToolType.SHOVEL, itemTier.getLevel())
                .addToolType(ToolType.HOE, itemTier.getLevel()));
    }

    public boolean isCorrectToolForDrops(BlockState state) {
        return !(state.getHarvestTool() == ToolType.AXE) || !(state.getHarvestTool() == ToolType.HOE) || !(state.getHarvestTool() == ToolType.SHOVEL) || !(state.getHarvestTool() == ToolType.PICKAXE);
    }

    public float getDestroySpeed(ItemStack itemStack, BlockState blockState) {
        return this.speed;
    }

    public ActionResultType useOn(ItemUseContext itemUseContext) {
        PlayerEntity player = itemUseContext.getPlayer();
        BlockPos pos = itemUseContext.getClickedPos();
        World world = itemUseContext.getLevel();

        if (player == null) return ActionResultType.PASS;
        if (player.isShiftKeyDown() && world.getBlockState(pos).getBlock().isToolEffective(world.getBlockState(pos), ToolType.SHOVEL)) {
            return ToolUtil.hoeUse(itemUseContext);
        } else if (player.isShiftKeyDown() && world.getBlockState(pos).getBlock().isToolEffective(world.getBlockState(pos), ToolType.AXE)) {
            return ToolUtil.axeUse(itemUseContext);
        } else if (!player.isShiftKeyDown()) {
            return ToolUtil.shovelUse(itemUseContext);
        }
        return ActionResultType.PASS;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        if(Screen.hasShiftDown()) {
            list.add(new TranslationTextComponent("tooltip.chaosadditions.default.tooltip_1"));
            list.add(new TranslationTextComponent("tooltip.chaosadditions.default.tooltip_2"));
            list.add(new TranslationTextComponent("tooltip.chaosadditions.default.tooltip_3"));
        } else {
            list.add(new TranslationTextComponent("tooltip.chaosadditions.default.tooltip"));
        }
    }
}
