package com.dev.air.event.impl.packet;

import com.dev.air.event.api.SendTypeEvent;
import net.lenni0451.asmevents.event.wrapper.CancellableEvent;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayClient;

public class PacketReceiveEvent extends CancellableEvent {

    private Packet packet;
    public PacketReceiveEvent(Packet<INetHandlerPlayClient> packet) {
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

}
