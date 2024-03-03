package com.dev.air.event.impl.movement;

import net.lenni0451.asmevents.event.wrapper.CancellableEvent;

public class SlowDownEvent extends CancellableEvent {

    private float moveStrafing = 0.2F, moveForward  = 0.2F;

    public void setMoveForward(float moveForward) {
        this.moveForward = moveForward;
    }

    public void setMoveStrafing(float moveStrafing) {
        this.moveStrafing = moveStrafing;
    }

    public float getMoveForward() {
        return moveForward;
    }

    public float getMoveStrafing() {
        return moveStrafing;
    }

}
