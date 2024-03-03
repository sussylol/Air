package com.dev.air.util.packet.other;

import com.dev.air.util.other.Stopwatch;
import net.minecraft.network.Packet;

public class TimedPacket {

    private final Stopwatch stopwatch;
    private final Packet<?> packet;

    public TimedPacket(Packet<?> packet) {
        this.packet = packet;
        this.stopwatch = new Stopwatch();
    }

    public Stopwatch getStopwatch() {
        return stopwatch;
    }

    public Packet<?> getPacket() {
        return packet;
    }

}
