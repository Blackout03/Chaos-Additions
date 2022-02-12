package com.blackout.chaosadditions.registry;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.loot.CADLootModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CADGlobalLootModifier {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, ChaosAdditions.MODID);

    public static final RegistryObject<CADLootModifier.Serializer> SAPPHIRE_TREASURE = LOOT_MODIFIER_SERIALIZERS.register("sapphire_treasure", CADLootModifier.Serializer::new);
}
