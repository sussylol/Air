package com.dev.air.event.impl.packet.update;

import net.lenni0451.asmevents.event.wrapper.CancellableEvent;

public class PreMotionEvent extends CancellableEvent {

    private double x, y, z;
    private float yaw, pitch;
    private boolean ground;

    public PreMotionEvent(double x, double y, double z, float yaw, float pitch, boolean ground) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.ground = ground;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public boolean isGround() {
        return ground;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setGround(boolean ground) {
        this.ground = ground;
    }

}
