package com.blackout.chaosadditions.events;

import com.blackout.chaosadditions.ChaosAdditions;
import com.blackout.chaosadditions.registry.ChaosAdditionsItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChaosAdditions.MODID, bus= Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CDAttackEvents {
    static float damage;

    @SubscribeEvent
    public void onEntityHitBeforeDmgIsApplied(LivingAttackEvent event)
    {
        damage = event.getAmount();
        ChaosAdditions.LOGGER.info("Damage: " + damage);
    }

    @SubscribeEvent
    public static void onPlayerAttackEntity(AttackEntityEvent event) {
        PlayerEntity player = event.getPlayer();
        LivingEntity target = (LivingEntity) event.getTarget();
        if (player.getMainHandItem().getItem() == ChaosAdditionsItems.SAPPHIRE_SWORD.get() ||
                player.getMainHandItem().getItem() == ChaosAdditionsItems.SAPPHIRE_AXE.get() ||
                event.getPlayer().getMainHandItem().getItem() == ChaosAdditionsItems.SAPPHIRE_PICKAXE.get() ||
                event.getPlayer().getMainHandItem().getItem() == ChaosAdditionsItems.SAPPHIRE_SHOVEL.get() ||
                event.getPlayer().getMainHandItem().getItem() == ChaosAdditionsItems.SAPPHIRE_HOE.get() ||
                event.getPlayer().getMainHandItem().getItem() == ChaosAdditionsItems.SAPPHIRE_AIOT.get()) {
            if (target.isAlive()) {
                if (player.isUnderWater()) {
                    target.hurt(DamageSource.playerAttack(player), damage * 2);
                } else {
                    target.hurt(DamageSource.playerAttack(player), damage / 2);
                }
            }
        }
    }
}
