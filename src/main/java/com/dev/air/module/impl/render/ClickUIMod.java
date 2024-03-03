package com.dev.air.module.impl.render;

import com.dev.air.Client;
import com.dev.air.module.api.Category;
import com.dev.air.module.api.Module;
import com.dev.air.module.api.annotation.ModuleInfo;
import org.lwjglx.input.Keyboard;

@ModuleInfo(name = "ClickGui", description = "Clickable interface for managing modules", category = Category.RENDER, key = Keyboard.KEY_RSHIFT)
public class ClickUIMod extends Module {

    @Override
    public void onEnable() {
        mc.displayGuiScreen(Client.instance.getImGuiScreen());
        setEnable(false);
    }
}
