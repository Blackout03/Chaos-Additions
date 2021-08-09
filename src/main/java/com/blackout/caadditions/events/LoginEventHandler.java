package com.blackout.caadditions.events;

import com.blackout.caadditions.CAAdditions;
import com.blackout.caadditions.UpdateHandler;
import com.blackout.caadditions.config.CAAdditionsConfig;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class LoginEventHandler {
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        if (UpdateHandler.show && CAAdditionsConfig.COMMON.showUpdateMessage.get())
            player.sendMessage(new TranslationTextComponent(UpdateHandler.updateStatus), player.getUUID());
        CAAdditions.LOGGER.debug(UpdateHandler.updateStatus);
        CAAdditions.LOGGER.debug(UpdateHandler.show);
    }

    @OnlyIn(Dist.CLIENT)
    public void sendChatMessage(String text, PlayerEntity player) {
        TranslationTextComponent component2 = new TranslationTextComponent(I18n.get(text, new Object[0]));
        player.sendMessage(component2, player.getUUID());
    }
}
