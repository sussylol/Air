package com.dev.air.util.other;

import com.dev.air.Client;
import net.minecraft.util.ChatComponentText;

import static com.dev.air.util.MinecraftInstance.*;

public class ChatUtil {

    public static void sendClientMessage(String message) {
        mc.player.addChatMessage(new ChatComponentText(Client.NAME + " > " + message));
    }

}
