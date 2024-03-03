package com.dev.air.viamcp.newpacket.impl;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

import java.io.IOException;

public class PacketC2STeleportConfirm implements Packet<INetHandlerPlayServer> {

    private int teleportId;

    public PacketC2STeleportConfirm(int teleportId) {
        this.teleportId = teleportId;
    }

    public void processPacket(INetHandlerPlayServer handler) {}

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.teleportId = buf.readVarIntFromBuffer();
    }

    public void writePacketData(PacketBuffer buf) throws IOException {
        buf.writeVarIntToBuffer(this.teleportId);
    }

    public int getTeleportId() {
        return teleportId;
    }

}
