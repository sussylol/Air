package com.dev.air.module.impl.render;

import com.dev.air.Client;
import com.dev.air.event.impl.render.Render2DEvent;
import com.dev.air.module.api.Category;
import com.dev.air.module.api.Module;
import com.dev.air.module.api.annotation.ModuleInfo;
import com.dev.air.util.math.ColorUtil;
import net.lenni0451.asmevents.event.Target;
import net.minecraft.client.gui.ScaledResolution;

@ModuleInfo(name = "Arraylist", description = "Show the current enabled mod", category = Category.RENDER, autoEnable = true)
public class ArraylistMod extends Module {

    @Target
    public void onRender2D(Render2DEvent event) {
        ScaledResolution resolution = new ScaledResolution(mc);

        int paddingX = 5;
        int renderY = 5, index = 0;
        for (Module module : Client.instance.getModuleManager().sort()) {
            if (!module.isEnable() || module.isHidden()) continue;

            int color = ColorUtil.interpolateColorsBackAndForth(10, index, Client.MAIN_COLOR, Client.ALT_COLOR, false).getRGB();
            String display = module.getPrefix().isEmpty() ? module.getName() :  module.getName() + " §7" + module.getPrefix();
            int renderX = resolution.getScaledWidth() - paddingX - mc.fontRenderer.getStringWidth(display);

            mc.fontRenderer.drawStringWithShadow(display, renderX, renderY, color);

            index += 15;
            renderY += mc.fontRenderer.FONT_HEIGHT;
        }
    }

}
