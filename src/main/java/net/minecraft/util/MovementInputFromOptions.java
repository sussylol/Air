package net.minecraft.util;

import com.dev.air.event.impl.tick.movement.MoveInputEvent;
import net.lenni0451.asmevents.EventManager;
import net.minecraft.client.settings.GameSettings;

public class MovementInputFromOptions extends MovementInput {
    private final GameSettings gameSettings;

    public MovementInputFromOptions(GameSettings gameSettingsIn) {
        this.gameSettings = gameSettingsIn;
    }

    public void updatePlayerMoveState() {
        this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;

        if (this.gameSettings.keyBindForward.isKeyDown()) ++this.moveForward;
        if (this.gameSettings.keyBindBack.isKeyDown()) --this.moveForward;
        if (this.gameSettings.keyBindLeft.isKeyDown()) ++this.moveStrafe;
        if (this.gameSettings.keyBindRight.isKeyDown()) --this.moveStrafe;

        this.originalStrafe = this.moveStrafe;
        this.originalForward = this.moveForward;
        MoveInputEvent event = new MoveInputEvent(moveForward, moveStrafe, this.gameSettings.keyBindJump.isKeyDown(), this.gameSettings.keyBindSneak.isKeyDown());
        EventManager.call(event);

        this.jump = event.isJumping();
        this.sneak = event.isSneak();
        this.moveForward = event.getForward();
        this.moveStrafe = event.getStrafe();

        if (this.sneak) {
            this.moveStrafe = (float) ((double) this.moveStrafe * 0.3D);
            this.moveForward = (float) ((double) this.moveForward * 0.3D);
        }
    }
}
