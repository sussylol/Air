package net.optifine.gui;

import net.minecraft.client.gui.Chat;
import net.minecraft.client.gui.VideoSettings;
import net.minecraft.src.Config;
import net.optifine.shaders.Shaders;

public class ChatOF extends Chat {
    private static final String CMD_RELOAD_SHADERS = "/reloadShaders";
    private static final String CMD_RELOAD_CHUNKS = "/reloadChunks";

    public ChatOF(Chat guiChat) {
        super(VideoSettings.getGuiChatText(guiChat));
    }

    /**
     * Used to add chat messages to the client's GuiChat.
     */
    public void sendChatMessage(String msg) {
        if (this.checkCustomCommand(msg)) {
            this.mc.ingameGUI.getChatGUI().addToSentMessages(msg);
        } else {
            super.sendChatMessage(msg);
        }
    }

    private boolean checkCustomCommand(String msg) {
        if (msg == null) {
            return false;
        } else {
            msg = msg.trim();

            if (msg.equals("/reloadShaders")) {
                if (Config.isShaders()) {
                    Shaders.uninit();
                    Shaders.loadShaderPack();
                }

                return true;
            } else if (msg.equals("/reloadChunks")) {
                this.mc.renderGlobal.loadRenderers();
                return true;
            } else {
                return false;
            }
        }
    }
}
