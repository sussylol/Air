package com.dev.air.event.impl.client;

import com.dev.air.value.Value;
import net.lenni0451.asmevents.event.IEvent;

public class ValueUpdateEvent implements IEvent {

    private final Value<?> value;

    public ValueUpdateEvent(Value<?> value) {
        this.value = value;
    }

    public Value<?> getValue() {
        return value;
    }
}
