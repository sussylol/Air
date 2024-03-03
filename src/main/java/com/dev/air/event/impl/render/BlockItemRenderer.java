package com.dev.air.event.impl.render;

import net.lenni0451.asmevents.event.IEvent;
import net.lenni0451.asmevents.event.wrapper.CancellableEvent;

public class BlockItemRenderer extends CancellableEvent {

    public final float f, f1, f2, f3;

    public BlockItemRenderer(float f, float f1, float f2, float f3) {
        this.f = f;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

}
