package com.dev.air.module.impl.movement;

import com.dev.air.event.impl.packet.PacketReceiveEvent;
import com.dev.air.event.impl.packet.update.PreMotionEvent;
import com.dev.air.module.api.Category;
import com.dev.air.module.api.Module;
import com.dev.air.module.api.annotation.ModuleInfo;
import com.dev.air.util.packet.PacketUtil;
import com.dev.air.util.player.MoveUtil;
import com.dev.air.value.impl.ModeValue;
import com.dev.air.value.impl.NumberValue;
import net.lenni0451.asmevents.event.Target;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

@ModuleInfo(name = "Flight", description = "Flight in survival", category = Category.MOVEMENT)
public class FlightMod extends Module {

    private final ModeValue mode = new ModeValue("Mode", "Velocity", "Velocity", "Test");
    private final NumberValue velocitySpeed = new NumberValue("Speed", 1.0F, 0.1F, 0F, 1F).requires(mode, "Velocity");

    @Override
    public String getPrefix() {
        return mode.getMode();
    }

    @Override
    public void onEnable() {
    }

    @Target
    public void onPreMotion(PreMotionEvent event) {
        if (mode.is("Velocity")) {
            mc.player.motionY = mc.gameSettings.keyBindSneak.isKeyDown() ? -velocitySpeed.getValue() : mc.gameSettings.keyBindJump.isKeyDown() ? velocitySpeed.getValue() : 0;
            if (MoveUtil.isMoving()) MoveUtil.strafe(velocitySpeed.getFloat());
        }

        if (mode.is("Test")) {
            PacketUtil.sendNo(new C03PacketPlayer.C06PacketPlayerPosLook(mc.player.posX, mc.player.posY + 0.029, mc.player.posZ, mc.player.renderYawHead,
                    mc.player.renderPitchHead, mc.player.onGround));
            //PacketUtil.sendNo(new C0FPacketConfirmTransaction());
//            PacketUtil.sendNo(new C03PacketPlayer.C06PacketPlayerPosLook(mc.player.posX, mc.player.posY + (0.029 * 2), mc.player.posZ, mc.player.renderYawHead,
//                    mc.player.renderPitchHead, mc.player.onGround));
        }
    }

    @Target
    public void onPacketReceive(PacketReceiveEvent event) {
    }

}
