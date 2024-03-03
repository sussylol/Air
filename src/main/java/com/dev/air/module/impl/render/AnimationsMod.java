package com.dev.air.module.impl.render;

import com.dev.air.event.impl.render.BlockItemRenderer;
import com.dev.air.module.api.Category;
import com.dev.air.module.api.Module;
import com.dev.air.module.api.annotation.ModuleInfo;
import com.dev.air.value.impl.ModeValue;
import net.lenni0451.asmevents.event.Target;

@ModuleInfo(name = "Animations", description = "Add additions to your sword animations", category = Category.RENDER, autoEnable = true)
public class AnimationsMod extends Module {

    public final ModeValue blockAnimation = new ModeValue("Block Mode", "1.7", "None", "1.7");
    public final ModeValue walkAnimation = new ModeValue("Walk Mode", "None", "None", "Old");

    @Target
    public void onBlockItemRender(BlockItemRenderer event) {
        if (blockAnimation.is("1.7")) {
            mc.getItemRenderer().transformFirstPersonItem(0.0F, event.f1);
            mc.getItemRenderer().doBlockTransformations();
        }

        event.setCancelled(true);
        if (blockAnimation.is("None")) event.setCancelled(false);
    }

}
