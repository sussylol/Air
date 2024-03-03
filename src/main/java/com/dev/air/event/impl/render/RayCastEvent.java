package com.dev.air.event.impl.render;

import com.dev.air.util.rotation.other.Rotation;
import net.lenni0451.asmevents.event.IEvent;

public class RayCastEvent implements IEvent {

    private Rotation rotation;
    private double reach;
    private final RayCastType type;

    public RayCastEvent(RayCastType type, Rotation rotation, double reach) {
        this.rotation = rotation;
        this.reach = reach;
        this.type = type;
    }

    public enum RayCastType {
        BLOCK, ENTITY;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public void setReach(double reach) {
        this.reach = reach;
    }

    public double getReach() {
        return reach;
    }

    public RayCastType getType() {
        return type;
    }

}
