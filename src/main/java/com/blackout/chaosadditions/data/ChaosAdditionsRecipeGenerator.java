package com.blackout.chaosadditions.data;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.registry.ChaosAdditionsItems;
import io.github.chaosawakens.common.registry.CAItems;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;

import java.util.function.Consumer;

public class ChaosAdditionsRecipeGenerator extends RecipeProvider {

	public ChaosAdditionsRecipeGenerator(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> recipeConsumer) {
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.WOODEN_AIOT.get(), Items.WOODEN_PICKAXE, Items.WOODEN_AXE, Items.WOODEN_SHOVEL, Items.WOODEN_HOE);
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.STONE_AIOT.get(), Items.STONE_PICKAXE, Items.STONE_AXE, Items.STONE_SHOVEL, Items.STONE_HOE);
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.GOLDEN_AIOT.get(), Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_HOE);
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.IRON_AIOT.get(), Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE);
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.DIAMOND_AIOT.get(), Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE);
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.NETHERITE_AIOT.get(), Items.NETHERITE_PICKAXE, Items.NETHERITE_AXE, Items.NETHERITE_SHOVEL, Items.NETHERITE_HOE);

		recipeAIOT(recipeConsumer, ChaosAdditionsItems.CRYSTAL_WOOD_AIOT.get(), CAItems.CRYSTAL_WOOD_PICKAXE.get(), CAItems.CRYSTAL_WOOD_AXE.get(), CAItems.CRYSTAL_WOOD_SHOVEL.get(), CAItems.CRYSTAL_WOOD_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.KYANITE_AIOT.get(), CAItems.KYANITE_PICKAXE.get(), CAItems.KYANITE_AXE.get(), CAItems.KYANITE_SHOVEL.get(), CAItems.KYANITE_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.PINK_TOURMALINE_AIOT.get(), CAItems.PINK_TOURMALINE_PICKAXE.get(), CAItems.PINK_TOURMALINE_AXE.get(), CAItems.PINK_TOURMALINE_SHOVEL.get(), CAItems.PINK_TOURMALINE_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.CATS_EYE_AIOT.get(), CAItems.CATS_EYE_PICKAXE.get(), CAItems.CATS_EYE_AXE.get(), CAItems.CATS_EYE_SHOVEL.get(), CAItems.CATS_EYE_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.COPPER_AIOT.get(), CAItems.COPPER_PICKAXE.get(), CAItems.COPPER_AXE.get(), CAItems.COPPER_SHOVEL.get(), CAItems.COPPER_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.TIN_AIOT.get(), CAItems.TIN_PICKAXE.get(), CAItems.TIN_AXE.get(), CAItems.TIN_SHOVEL.get(), CAItems.TIN_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.SILVER_AIOT.get(), CAItems.SILVER_PICKAXE.get(), CAItems.SILVER_AXE.get(), CAItems.SILVER_SHOVEL.get(), CAItems.SILVER_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.PLATINUM_AIOT.get(), CAItems.PLATINUM_PICKAXE.get(), CAItems.PLATINUM_AXE.get(), CAItems.PLATINUM_SHOVEL.get(), CAItems.PLATINUM_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.EMERALD_AIOT.get(), CAItems.EMERALD_PICKAXE.get(), CAItems.EMERALD_AXE.get(), CAItems.EMERALD_SHOVEL.get(), CAItems.EMERALD_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.AMETHYST_AIOT.get(), CAItems.AMETHYST_PICKAXE.get(), CAItems.AMETHYST_AXE.get(), CAItems.AMETHYST_SHOVEL.get(), CAItems.AMETHYST_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.TIGERS_EYE_AIOT.get(), CAItems.TIGERS_EYE_PICKAXE.get(), CAItems.TIGERS_EYE_AXE.get(), CAItems.TIGERS_EYE_SHOVEL.get(), CAItems.TIGERS_EYE_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.RUBY_AIOT.get(), CAItems.RUBY_PICKAXE.get(), CAItems.RUBY_AXE.get(), CAItems.RUBY_SHOVEL.get(), CAItems.RUBY_HOE.get());
		recipeAIOT(recipeConsumer, ChaosAdditionsItems.ULTIMATE_AIOT.get(), CAItems.ULTIMATE_PICKAXE.get(), CAItems.ULTIMATE_AXE.get(), CAItems.ULTIMATE_SHOVEL.get(), CAItems.ULTIMATE_HOE.get());
	}

	private static void recipeAIOT(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, IItemProvider input1, IItemProvider input2, IItemProvider input3, IItemProvider input4) {
		ShapelessRecipeBuilder.shapeless(output).requires(input1).requires(input2).requires(input3).requires(input4).unlockedBy("has_tool1", has(input1)).unlockedBy("has_tool2", has(input2)).unlockedBy("has_tool3", has(input3)).unlockedBy("has_too4", has(input4)).save(recipeConsumer);
		ChaosAdditions.LOGGER.info(output.asItem().getRegistryName());
	}
}
