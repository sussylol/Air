package com.dev.air.event.impl.tick.movement;

import net.lenni0451.asmevents.event.IEvent;

public class PlayerJumpEvent implements IEvent {

    private float yaw, jumpHeight;

    public PlayerJumpEvent(float yaw, float jumpHeight) {
        this.yaw = yaw;
        this.jumpHeight = jumpHeight;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

}
