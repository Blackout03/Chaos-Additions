package com.blackout.caadditions.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import org.apache.commons.lang3.tuple.Pair;

public class CAAdditionsConfig {

    public static class Common {
        public final ConfigValue<Integer> emeraldAIOTDamage;
        public final ConfigValue<Integer> amethystAIOTDamage;
        public final ConfigValue<Integer> tigersEyeAIOTDamage;
        public final ConfigValue<Integer> rubyAIOTDamage;
        public final ConfigValue<Integer> ultimateAIOTDamage;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Attack Damage");
            builder.push("AIOT");
            emeraldAIOTDamage = builder.define("Damage of the Emerald AIOT", 9);
            amethystAIOTDamage = builder.define("Damage of the Amethyst AIOT", 11);
            tigersEyeAIOTDamage = builder.define("Damage of the Tiger's Eye AIOT", 14);
            rubyAIOTDamage = builder.define("Damage of the Ruby AIOT", 19);
            ultimateAIOTDamage = builder.define("Damage of the Ultimate AIOT", 39);
            builder.pop();
            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}
