package com.bread.mixin;

import com.bread.BookSavestate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public class HandledScreenMixin {

    @Inject(method = "init", at = @At("RETURN"))
    public void writeBookContainer(CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (BookSavestate.shouldSavestate && player.currentScreenHandler.slots.size() >= 63) {
            BookSavestate.shouldSavestate = false;
            BookSavestate.dupe(2);
        }
    }
}