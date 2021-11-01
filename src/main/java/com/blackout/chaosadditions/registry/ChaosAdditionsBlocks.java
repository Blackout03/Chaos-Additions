package com.blackout.chaosadditions.registry;

import com.blackout.chaosadditions.ChaosAdditions;
import io.github.chaosawakens.common.registry.CAItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;
@Mod.EventBusSubscriber(modid = ChaosAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChaosAdditionsBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChaosAdditions.MODID);
    public static final DeferredRegister<Item> ITEM_BLOCKS = DeferredRegister.create(ForgeRegistries.ITEMS, ChaosAdditions.MODID);

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", () -> new Block(Block.Properties.copy(Blocks.OBSIDIAN).strength(3, 3).harvestLevel(3).harvestTool(ToolType.SHOVEL).requiresCorrectToolForDrops()), CAItemGroups.blocksItemGroup);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () -> new Block(Block.Properties.copy(Blocks.OBSIDIAN).strength(3, 3).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), CAItemGroups.blocksItemGroup);

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup) {
        return registerBlock(name, supplier, itemGroup, true);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, boolean generateItem) {
        return registerBlock(name, supplier, itemGroup, 64, generateItem);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, int stackSize, boolean generateItem) {
        RegistryObject<B> block = ChaosAdditionsBlocks.BLOCKS.register(name, supplier);
        if (generateItem)ITEM_BLOCKS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).stacksTo(stackSize)));
        return block;
    }
}

