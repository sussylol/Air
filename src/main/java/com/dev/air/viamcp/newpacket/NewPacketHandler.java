package com.dev.air.viamcp.newpacket;

import com.dev.air.viamcp.newpacket.impl.PacketC2STeleportConfirm;
import com.viaversion.viabackwards.protocol.protocol1_9to1_9_1.Protocol1_9To1_9_1;
import com.viaversion.viarewind.utils.PacketUtil;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.ServerboundPackets1_9;
import net.minecraft.network.Packet;

public class NewPacketHandler {

    public static boolean handlePacket(Packet<?> packet) {
        if (packet instanceof PacketC2STeleportConfirm) {
            PacketC2STeleportConfirm wrapper = (PacketC2STeleportConfirm) packet;

            PacketWrapper teleportConfirm =
                    PacketWrapper.create(ServerboundPackets1_9.TELEPORT_CONFIRM, null, Via.getManager().getConnectionManager().getConnections().iterator().next());
            teleportConfirm.write(Type.VAR_INT, 1);

            PacketUtil.sendToServer(teleportConfirm, Protocol1_9To1_9_1.class, true, true);
        }

        return packet instanceof PacketC2STeleportConfirm;
    }

}
