package com.dev.air.event.impl.render;

import net.lenni0451.asmevents.event.IEvent;
import net.minecraft.item.EnumAction;

public class ItemRendererEvent implements IEvent {

    private EnumAction action;

    public ItemRendererEvent(EnumAction action) {
        this.action = action;
    }

    public void setAction(EnumAction action) {
        this.action = action;
    }

    public EnumAction getAction() {
        return action;
    }

}
