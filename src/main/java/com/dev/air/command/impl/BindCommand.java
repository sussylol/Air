package com.dev.air.command.impl;

import com.dev.air.Client;
import com.dev.air.command.api.Command;
import com.dev.air.module.api.Module;
import com.dev.air.util.other.ChatUtil;
import org.lwjglx.input.Keyboard;

public class BindCommand extends Command {

    public BindCommand(String name) {
        super(name);
    }

    @Override
    public void handleCommand(String[] args) {
        if (args.length < 3) return;

        Module module = Client.instance.getModuleManager().get(args[1]);

        if (module == null) {
            ChatUtil.sendClientMessage("Module not found!");
            return;
        }

        int key = Keyboard.getKeyIndex(args[2].toUpperCase());
        if (key == 0) {
            ChatUtil.sendClientMessage("Binded " + module.getName() + " to " + "NONE");
            module.setKey(0);
        } else {
            ChatUtil.sendClientMessage("Binded " + module.getName() + " to " + args[2].toUpperCase());
            module.setKey(key);
        }
    }

}
