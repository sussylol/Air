package com.dev.air.event.impl.tick.movement;

import net.lenni0451.asmevents.event.IEvent;

public class MoveInputEvent implements IEvent {

    private float forward, strafe;
    private boolean jumping, sneak;

    public MoveInputEvent(float forward, float strafe, boolean jumping, boolean sneak) {
        this.forward = forward;
        this.strafe = strafe;
        this.jumping = jumping;
        this.sneak = sneak;
    }

    public float getForward() {
        return forward;
    }

    public void setForward(float forward) {
        this.forward = forward;
    }

    public float getStrafe() {
        return strafe;
    }

    public void setStrafe(float strafe) {
        this.strafe = strafe;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isSneak() {
        return sneak;
    }

    public void setSneak(boolean sneak) {
        this.sneak = sneak;
    }

}
