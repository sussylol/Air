package com.dev.air.prediction.network;

import com.dev.air.util.MinecraftInstance;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Screen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

public class EmptyNetworkHandler extends NetHandlerPlayClient {

    public EmptyNetworkHandler() {
        super(MinecraftInstance.mc, null, null, MinecraftInstance.mc.player.getGameProfile());
    }

    @Override
    public void addToSendQueue(Packet p_147297_1_) {}


}
