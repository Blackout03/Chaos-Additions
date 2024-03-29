package com.blackout.chaosadditions.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class CADConfig {
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = commonSpecPair.getRight();
		COMMON = commonSpecPair.getLeft();
	}

	public static class Common {
		public final ConfigValue<Integer> woodenAIOTDamage;
		public final ConfigValue<Integer> stoneAIOTDamage;
		public final ConfigValue<Integer> goldenAIOTDamage;
		public final ConfigValue<Integer> ironAIOTDamage;
		public final ConfigValue<Integer> diamondAIOTDamage;
		public final ConfigValue<Integer> netheriteAIOTDamage;
		public final ConfigValue<Integer> crystalWoodAIOTDamage;
		public final ConfigValue<Integer> kyaniteAIOTDamage;
		public final ConfigValue<Integer> pinkTourmalineAIOTDamage;
		public final ConfigValue<Integer> catsEyeAIOTDamage;
		public final ConfigValue<Integer> copperAIOTDamage;
		public final ConfigValue<Integer> tinAIOTDamage;
		public final ConfigValue<Integer> silverAIOTDamage;
		public final ConfigValue<Integer> platinumAIOTDamage;
		public final ConfigValue<Integer> emeraldAIOTDamage;
		public final ConfigValue<Integer> amethystAIOTDamage;
		public final ConfigValue<Integer> tigersEyeAIOTDamage;
		public final ConfigValue<Integer> rubyAIOTDamage;
		public final ConfigValue<Integer> ultimateAIOTDamage;
		public final ConfigValue<Integer> sapphireAIOTDamage;
		public final ConfigValue<Integer> meganiumAIOTDamage;

		public final ConfigValue<Integer> sapphireSwordDamage;
		public final ConfigValue<Integer> sapphirePickaxeDamage;
		public final ConfigValue<Integer> sapphireAxeDamage;
		public final ConfigValue<Integer> sapphireShovelDamage;
		public final ConfigValue<Integer> sapphireHoeDamage;

		public final ConfigValue<Boolean> enableSapphireShipwreckLootGen;

		Common(ForgeConfigSpec.Builder builder) {
			builder.push("Attack Damage");
			builder.push("AIOT");
			woodenAIOTDamage = builder.define("Damage of the Wooden AIOT", 3);
			stoneAIOTDamage = builder.define("Damage of the Stone AIOT", 4);
			goldenAIOTDamage = builder.define("Damage of the Golden AIOT", 3);
			ironAIOTDamage = builder.define("Damage of the Iron AIOT", 5);
			diamondAIOTDamage = builder.define("Damage of the Diamond AIOT", 6);
			netheriteAIOTDamage = builder.define("Damage of the Netherite AIOT", 7);
			crystalWoodAIOTDamage = builder.define("Damage of the Crystal Wood AIOT", 3);
			kyaniteAIOTDamage = builder.define("Damage of the Kyanite AIOT", 4);
			pinkTourmalineAIOTDamage = builder.define("Damage of the Pink Tourmaline AIOT", 10);
			catsEyeAIOTDamage = builder.define("Damage of the Cat's Eye AIOT", 11);
			copperAIOTDamage = builder.define("Damage of the Copper AIOT", 4);
			tinAIOTDamage = builder.define("Damage of the Tin AIOT", 4);
			silverAIOTDamage = builder.define("Damage of the Silver AIOT", 5);
			platinumAIOTDamage = builder.define("Damage of the Platinum AIOT", 9);
			emeraldAIOTDamage = builder.define("Damage of the Emerald AIOT", 5);
			amethystAIOTDamage = builder.define("Damage of the Amethyst AIOT", 14);
			tigersEyeAIOTDamage = builder.define("Damage of the Tiger's Eye AIOT", 11);
			rubyAIOTDamage = builder.define("Damage of the Ruby AIOT", 19);
			ultimateAIOTDamage = builder.define("Damage of the Ultimate AIOT", 39);
			sapphireAIOTDamage = builder.define("Damage of the Sapphire AIOT", 11);
			meganiumAIOTDamage = builder.define("Damage of the Meganium AIOT", 59);
			builder.pop();
			builder.push("Sapphire Weapons/Tools");
			sapphireSwordDamage = builder.define("Damage of the Sapphire Sword", 12);
			sapphireAxeDamage = builder.define("Damage of the Sapphire Axe", 14);
			sapphirePickaxeDamage = builder.define("Damage of the Sapphire Pickaxe", 10);
			sapphireShovelDamage = builder.define("Damage of the Sapphire Shovel", 11);
			sapphireHoeDamage = builder.define("Damage of the Sapphire Hoe", 1);
			builder.pop();
			builder.pop();
			builder.push("World Generation");
			enableSapphireShipwreckLootGen = builder.define("Sapphire shipwreck loot generation", true);
			builder.pop();
		}
	}
}
