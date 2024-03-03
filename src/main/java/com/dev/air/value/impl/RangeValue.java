package com.dev.air.value.impl;

import com.dev.air.value.Value;

public class RangeValue extends Value<RangeValue> {

    private double first, second;
    private final double increment, min, max;

    public RangeValue(String displayName, double first, double second, double increment, double min, double max) {
        super(displayName.replace(" ", "_").toLowerCase() + "_range", displayName);
        this.first = first;
        this.second = second;
        this.increment = increment;
        this.min = min;
        this.max = max;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double value) {
        double prec = 1 / increment;
        double newV = Math.round(Math.max(min, Math.min(max, value)) * prec) / prec;
        if (newV > getSecond()) // mochi is dumb .bonk.
            newV = getSecond();
        this.first = newV;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double value) {
        double prec = 1 / increment;
        this.second = Math.round(Math.max(min, Math.min(max, value)) * prec) / prec;
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
