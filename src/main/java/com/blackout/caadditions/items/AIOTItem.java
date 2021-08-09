package com.blackout.caadditions.items;

import com.blackout.caadditions.util.ToolUtil;
import io.github.chaosawakens.common.registry.CABlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
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
        return state.getHarvestTool() == ToolType.AXE || state.getHarvestTool() == ToolType.HOE || state.getHarvestTool() == ToolType.SHOVEL || state.getHarvestTool() == ToolType.PICKAXE;
    }

    public float getDestroySpeed(ItemStack itemStack, BlockState blockState) {
        Material material = blockState.getMaterial();
        Block block = blockState.getBlock();
        return block != CABlocks.TERMITE_INFESTED_ORE.get() && block != CABlocks.RED_ANT_INFESTED_ORE.get() && block != CABlocks.FOSSILISED_EMERALD_GATOR.get() && block != CABlocks.FOSSILISED_ENT.get() && block != CABlocks.FOSSILISED_HERCULES_BEETLE.get() && block != CABlocks.FOSSILISED_RUBY_BUG.get() && block != Blocks.NETHER_WART_BLOCK && block != Blocks.WARPED_WART_BLOCK && block != Blocks.HAY_BLOCK && block != Blocks.DRIED_KELP_BLOCK && block != Blocks.TARGET && block != Blocks.SHROOMLIGHT && block != Blocks.SPONGE && block != Blocks.WET_SPONGE && block != Blocks.JUNGLE_LEAVES && block != Blocks.OAK_LEAVES && block != Blocks.SPRUCE_LEAVES && block != Blocks.DARK_OAK_LEAVES && block != Blocks.ACACIA_LEAVES && block != Blocks.BIRCH_LEAVES && block != Blocks.CLAY && block != Blocks.DIRT && block != Blocks.COARSE_DIRT && block != Blocks.PODZOL && block != Blocks.FARMLAND && block != Blocks.GRASS_BLOCK && block != Blocks.GRAVEL && block != Blocks.MYCELIUM && block != Blocks.SAND && block != Blocks.RED_SAND && block != Blocks.SNOW_BLOCK && block != Blocks.SNOW && block != Blocks.SOUL_SAND && block != Blocks.GRASS_PATH && block != Blocks.WHITE_CONCRETE_POWDER && block != Blocks.ORANGE_CONCRETE_POWDER && block != Blocks.MAGENTA_CONCRETE_POWDER && block != Blocks.LIGHT_BLUE_CONCRETE_POWDER && block != Blocks.YELLOW_CONCRETE_POWDER && block != Blocks.LIME_CONCRETE_POWDER && block != Blocks.PINK_CONCRETE_POWDER && block != Blocks.GRAY_CONCRETE_POWDER && block != Blocks.LIGHT_GRAY_CONCRETE_POWDER && block != Blocks.CYAN_CONCRETE_POWDER && block != Blocks.PURPLE_CONCRETE_POWDER && block != Blocks.BLUE_CONCRETE_POWDER && block != Blocks.BROWN_CONCRETE_POWDER && block != Blocks.GREEN_CONCRETE_POWDER && block != Blocks.RED_CONCRETE_POWDER && block != Blocks.BLACK_CONCRETE_POWDER && block != Blocks.SOUL_SOIL && material != Material.WOOD && material != Material.NETHER_WOOD && material != Material.PLANT && material != Material.REPLACEABLE_PLANT && material != Material.BAMBOO && material != Material.VEGETABLE && material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(itemStack, blockState) : this.speed;
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
            list.add(new TranslationTextComponent("tooltip.caadditions.default.tooltip_1"));
            list.add(new TranslationTextComponent("tooltip.caadditions.default.tooltip_2"));
            list.add(new TranslationTextComponent("tooltip.caadditions.default.tooltip_3"));
        } else {
            list.add(new TranslationTextComponent("tooltip.caadditions.default.tooltip"));
        }
    }
}
