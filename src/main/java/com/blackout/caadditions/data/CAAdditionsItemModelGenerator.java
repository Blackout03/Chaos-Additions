package com.blackout.caadditions.data;

import com.blackout.caadditions.CAAdditions;
import com.blackout.caadditions.registry.CAAdditionsItems;
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

public class CAAdditionsItemModelGenerator extends ItemModelProvider {

	public CAAdditionsItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, CAAdditions.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		generate(CAAdditionsItems.ITEMS.getEntries());
	}

	@Nonnull
	@Override
	public String getName() {
		return CAAdditions.MODNAME + " Item models";
	}

	private void generate(final Collection<RegistryObject<Item>> items) {
		final ModelFile parentGenerated = getExistingFile(mcLoc("item/generated"));
		final ExistingModelFile parentHandheld = getExistingFile(mcLoc("item/handheld"));

		for (RegistryObject<Item> item : items) {
			String name = item.getId().getPath();

			if (name.startsWith("enchanted"))
				name = name.substring(name.indexOf("_") + 1);

			/*
			 *  Skip elements that have no texture at assets/caadditions/textures/item
			 *  or already have an existing model at assets/caadditions/models/item
			 */
			if (!existingFileHelper.exists(new ResourceLocation(CAAdditions.MODID, "item/" + name), TEXTURE) || existingFileHelper.exists(new ResourceLocation(CAAdditions.MODID, "item/" + name), MODEL))
				continue;

			CAAdditions.LOGGER.info(item.getId());

			getBuilder(item.getId().getPath()).parent(item.get().getMaxDamage(ItemStack.EMPTY) > 0 && !(item.get() instanceof ArmorItem) ? parentHandheld : parentGenerated).texture("layer0", ItemModelProvider.ITEM_FOLDER + "/" + name);
		}
	}
}
