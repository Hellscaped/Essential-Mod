/*
 * Copyright (c) 2024 ModCore Inc. All rights reserved.
 *
 * This code is part of ModCore Inc.'s Essential Mod repository and is protected
 * under copyright registration # TX0009138511. For the full license, see:
 * https://github.com/EssentialGG/Essential/blob/main/LICENSE
 *
 * You may not use, copy, reproduce, modify, sell, license, distribute,
 * commercialize, or otherwise exploit, or create derivative works based
 * upon, this file or any other in this repository, all of which is reserved by Essential.
 */
package gg.essential.mixins.transformers.server;

import net.minecraft.server.integrated.IntegratedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IntegratedServer.class)
public abstract class Mixin_ServerCoroutineScope_IntegratedServer extends Mixin_ServerCoroutineScope {
    // The integrated server doesn't run `super.tick` while the game is paused, we do want to be able to schedule
    // stuff to run on the server thread even while the game is paused though, so we'll have to call our runTasks method
    // from here as well (this does mean it'll be called twice while not paused, but there's nothing wrong with that).
    @Inject(method = "tick", at = @At("HEAD"))
    protected void runTasks(CallbackInfo ci) {
        essential$runTasks(ci);
    }
}
