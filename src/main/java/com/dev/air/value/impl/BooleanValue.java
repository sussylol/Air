package com.dev.air.value.impl;

import com.dev.air.event.impl.client.ValueUpdateEvent;
import com.dev.air.value.Value;
import net.lenni0451.asmevents.EventManager;

public class BooleanValue extends Value<BooleanValue> {

    private boolean enabled;

    public BooleanValue(String displayName, boolean enabled) {
        super(displayName.replace(" ", "_").toLowerCase() + "_bool", displayName);
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        EventManager.call(new ValueUpdateEvent(this));
    }
}
