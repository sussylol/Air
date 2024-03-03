package com.dev.air.value.impl;

import com.dev.air.event.impl.client.ValueUpdateEvent;
import com.dev.air.value.Value;
import net.lenni0451.asmevents.EventManager;

public class NumberValue extends Value<NumberValue> {

    private double value;
    private final double increment, min, max;

    public NumberValue(String displayName, double value, double increment, double min, double max) {
        super(displayName.replace(" ", "_").toLowerCase() + "_number", displayName);
        this.value = value;
        this.increment = increment;
        this.min = min;
        this.max = max;
    }

    public double getValue() {
        return value;
    }

    public float getFloat() {
        return (float) value;
    }

    public int getInt() {
        return ((int) value);
    }

    public void setValue(double value) {
        double prec = 1 / increment;
        this.value = Math.round(Math.max(min, Math.min(max, value)) * prec) / prec;

        EventManager.call(new ValueUpdateEvent(this));
    }

    public double getIncrement() {
        return increment;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

}
