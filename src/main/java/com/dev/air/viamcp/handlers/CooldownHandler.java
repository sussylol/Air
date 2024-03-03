package com.dev.air.viamcp.handlers;

import com.dev.air.event.impl.packet.PacketReceiveEvent;
import com.dev.air.event.impl.update.PostUpdateEvent;
import net.lenni0451.asmevents.event.Target;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.network.play.server.S45PacketTitle;

import static com.dev.air.util.MinecraftInstance.*;

public class CooldownHandler {

    @Target
    public void onPostUpdate(PostUpdateEvent event) {
        double delay = 4;
        if (mc.player.getHeldItem() != null) {
            Item item = mc.player.getHeldItem().getItem();
            if (item instanceof ItemSpade || item == Items.golden_axe || item == Items.diamond_axe || item == Items.wooden_hoe || item == Items.golden_hoe) delay = 20;
            if (item == Items.wooden_axe || item == Items.stone_axe) delay = 25;
            if (item instanceof ItemSword) delay = 12;
            if (item instanceof ItemPickaxe) delay = 17;
            if (item == Items.iron_axe) delay = 22;
            if (item == Items.stone_hoe) delay = 10;
            if (item == Items.iron_hoe) delay = 7;
        }

        delay *= Math.max(1, mc.timer.timerSpeed);
        mc.player.attackDelay = delay;
    }

    @Target
    public void onPacketReceive(PacketReceiveEvent event) {
        if (event.getPacket() instanceof S45PacketTitle) {
            S45PacketTitle wrapper = (S45PacketTitle) event.getPacket();

            System.out.println(wrapper.getMessage().getUnformattedText());
            /* via version cooldown stuff, we don't need this anymore :) */
            String filtered = wrapper.getMessage().getUnformattedText().replace("§8", "").replace("§7", "");
            if (filtered.equalsIgnoreCase("˙˙˙˙˙˙˙˙˙˙")) {
                event.setCancelled(true);
                mc.ingameGUI.resetTitle();
            }
        }
    }

}
