package com.blackout.chaosadditions.data;

import com.blackout.chaosadditions.registry.CADBlocks;
import com.blackout.chaosadditions.registry.CADItems;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;

public class CADBlockLootTables extends BlockLootTables {
	protected static LootTable.Builder createSingleOreDrop(IItemProvider item) {
		return LootTable.lootTable().withPool(applyExplosionCondition(item, LootPool.lootPool()).apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).add(ItemLootEntry.lootTableItem(item)));
	}

	@Override
	protected void addTables() {
		add(CADBlocks.SAPPHIRE_ORE.get(), createSingleOreDrop(CADItems.SAPPHIRE.get()));

		dropSelf(CADBlocks.SAPPHIRE_BLOCK.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return CADBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
