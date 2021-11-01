package com.blackout.chaosadditions.data;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.registry.ChaosAdditionsBlocks;
import com.blackout.chaosadditions.registry.ChaosAdditionsItems;
import com.blackout.chaosadditions.registry.ChaosAdditionsItemsPureChaos;
import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.registry.CABlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nonnull;
import java.util.Collection;

public class ChaosAdditionsItemModelGenerator extends ItemModelProvider {

	public ChaosAdditionsItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, ChaosAdditions.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		generate(ChaosAdditionsItems.ITEMS.getEntries());
		generate(ChaosAdditionsItemsPureChaos.ITEMS.getEntries());
		generateBlockItems(ChaosAdditionsBlocks.ITEM_BLOCKS.getEntries());
	}

	@Nonnull
	@Override
	public String getName() {
		return ChaosAdditions.MODNAME + " Item models";
	}

	private void generate(final Collection<RegistryObject<Item>> items) {
		final ModelFile parentGenerated = getExistingFile(mcLoc("item/generated"));
		final ExistingModelFile parentHandheld = getExistingFile(mcLoc("item/handheld"));

		for (RegistryObject<Item> item : items) {
			String name = item.getId().getPath();

			if (name.startsWith("enchanted"))
				name = name.substring(name.indexOf("_") + 1);

			/*
			 *  Skip elements that have no texture at assets/chaosadditions/textures/item
			 *  or already have an existing model at assets/chaosadditions/models/item
			 */
			if (!existingFileHelper.exists(new ResourceLocation(ChaosAdditions.MODID, "item/" + name), TEXTURE) || existingFileHelper.exists(new ResourceLocation(ChaosAdditions.MODID, "item/" + name), MODEL))
				continue;

			ChaosAdditions.LOGGER.info(item.getId());

			getBuilder(item.getId().getPath()).parent(item.get().getMaxDamage(ItemStack.EMPTY) > 0 && !(item.get() instanceof ArmorItem) ? parentHandheld : parentGenerated).texture("layer0", ItemModelProvider.ITEM_FOLDER + "/" + name);
		}
	}

	private void generateBlockItems(final Collection<RegistryObject<Item>> itemBlocks) {
		for (RegistryObject<Item> item : itemBlocks) {
			String name = item.getId().getPath();

			/*
			 *  Skip elements that have no block model inside of assets/chaosadditions/models/block
			 *  or already have an existing item model at assets/chaosadditions/models/item
			 */

			if (!existingFileHelper.exists(new ResourceLocation(ChaosAdditions.MODID, "block/" + name), MODEL) || existingFileHelper.exists(new ResourceLocation(ChaosAdditions.MODID, "item/" + name), MODEL))
				continue;

			ChaosAdditions.LOGGER.info(item.getId());

			withExistingParent(name, new ResourceLocation(ChaosAdditions.MODID, "block/" + name));

		}
	}
}
