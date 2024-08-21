package com.bread.mixin;

import com.bread.BookSavestate;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {

    @Inject(method = "interactBlockInternal", at = @At("RETURN"))
    private void writeBookLectern(ClientPlayerEntity player, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (BookSavestate.shouldSavestate &&
                client.world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.LECTERN)
                && client.player.getMainHandStack().isOf(Items.WRITABLE_BOOK)) {
            BookSavestate.shouldSavestate = false;
            BookSavestate.writeBook();
        }
    }

    @Inject(method = "interactEntity", at = @At("HEAD"))
    private void writeBookItemFrame(PlayerEntity player, Entity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (BookSavestate.shouldSavestate && client.player.getMainHandStack().isOf(Items.WRITABLE_BOOK) && entity.getType().equals(EntityType.ITEM_FRAME)) {
            BookSavestate.shouldSavestate = false;
            BookSavestate.writeBook();
        }
    }

}
