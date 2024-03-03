package com.dev.air.value.impl;

import com.dev.air.value.Value;

import java.awt.*;

public class ColorValue extends Value {

    private Color color;

    public ColorValue(String displayName, Color color) {
        super(displayName.replace(" ", "_").toLowerCase() + "_range", displayName);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
