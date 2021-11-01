package com.blackout.chaosadditions.data;

import com.blackout.chaosadditions.registry.ChaosAdditionsBlocks;
import com.blackout.chaosadditions.registry.ChaosAdditionsItems;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;

public class ChaosAdditionsBlockLootTables extends BlockLootTables {

	@Override
	protected void addTables() {
		add(ChaosAdditionsBlocks.SAPPHIRE_ORE.get(), createSingleOreDrop(ChaosAdditionsItems.SAPPHIRE.get()));

		dropSelf(ChaosAdditionsBlocks.SAPPHIRE_BLOCK.get());
	}

	protected static LootTable.Builder createSingleOreDrop(IItemProvider item) {
		return LootTable.lootTable().withPool(applyExplosionCondition(item, LootPool.lootPool()).apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).add(ItemLootEntry.lootTableItem(item)));
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ChaosAdditionsBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
