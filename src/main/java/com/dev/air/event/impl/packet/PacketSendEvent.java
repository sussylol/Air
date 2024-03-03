package com.dev.air.event.impl.packet;

import com.dev.air.event.api.SendTypeEvent;
import net.lenni0451.asmevents.event.wrapper.CancellableEvent;
import net.minecraft.network.Packet;

public class PacketSendEvent extends CancellableEvent {

    private Packet<?> packet;
    public PacketSendEvent(Packet<?> packet) {
        this.packet = packet;
    }

    public Packet<?> getPacket() {
        return packet;
    }

    public void setPacket(Packet<?> packet) {
        this.packet = packet;
    }

}
