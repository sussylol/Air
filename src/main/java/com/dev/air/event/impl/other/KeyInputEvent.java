package com.dev.air.event.impl.other;

import net.lenni0451.asmevents.event.IEvent;

public class KeyInputEvent implements IEvent {

    private final int key;

    public KeyInputEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

}
