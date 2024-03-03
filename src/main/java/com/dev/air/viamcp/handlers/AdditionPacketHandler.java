package com.dev.air.viamcp.handlers;

import com.dev.air.event.impl.packet.PacketSendEvent;
import com.dev.air.event.impl.update.PreUpdateEvent;
import com.dev.air.viamcp.util.VersionUtil;
import com.viaversion.viarewind.protocol.protocol1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viarewind.utils.PacketUtil;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Type;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import net.lenni0451.asmevents.event.Target;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C19PacketResourcePackStatus;
import net.minecraft.network.play.server.S48PacketResourcePackSend;

import static com.dev.air.util.MinecraftInstance.*;

public class AdditionPacketHandler {

    @Target
    public void onPacketSend(PacketSendEvent event) {
        if (event.getPacket() instanceof C03PacketPlayer) {
            C03PacketPlayer wrapper = (C03PacketPlayer) event.getPacket();
            if (!wrapper.isMoving() && !wrapper.getRotating() && !wrapper.isGroundState()) {
                event.setCancelled(true);
            }
        }

        if (ViaLoadingBase.getInstance().getTargetVersion().isNewerThan(ProtocolVersion.v1_20_2) &&
                event.getPacket() instanceof S48PacketResourcePackSend) {
            S48PacketResourcePackSend wrapper = (S48PacketResourcePackSend) event.getPacket();
            if (VersionUtil.getParsedResourcePackUrl(wrapper.getURL()) == null) {
                com.dev.air.util.packet.PacketUtil.sendNo(new C19PacketResourcePackStatus(wrapper.getHash(), C19PacketResourcePackStatus.Action.INVALID_URL));
                event.setCancelled(true);
            }
        }

    }

    @Target
    public void onPreUpdate(PreUpdateEvent event) {
        if (ViaLoadingBase.getInstance().getTargetVersion().isNewerThanOrEqualTo(ProtocolVersion.v1_9)) {
            if (mc.player.isUsingItem() && mc.player.getHeldItem() != null && mc.player.getHeldItem().getItem() instanceof ItemSword) {
                PacketWrapper packet = PacketWrapper.create(29, null, Via.getManager().getConnectionManager().getConnections().iterator().next());
                packet.write(Type.VAR_INT, 1);

                PacketUtil.sendToServer(packet, Protocol1_8To1_9.class, true, true);
                com.dev.air.util.packet.PacketUtil.sendNo(new C08PacketPlayerBlockPlacement(mc.player.getHeldItem()));
            }
        }
    }

}
