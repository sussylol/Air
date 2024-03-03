package com.dev.air.module.impl.movement;

import com.dev.air.event.impl.packet.update.PreMotionEvent;
import com.dev.air.event.impl.tick.movement.MoveInputEvent;
import com.dev.air.module.api.Category;
import com.dev.air.module.api.Module;
import com.dev.air.module.api.annotation.ModuleInfo;
import com.dev.air.util.player.MoveUtil;
import com.dev.air.value.impl.ModeValue;
import net.lenni0451.asmevents.event.Target;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.BlockPos;

@ModuleInfo(name = "Jesus", description = "Change your movement in water", category = Category.MOVEMENT)
public class JesusMod extends Module {

    private final ModeValue mode = new ModeValue("Mode", "Legit", "Legit", "Verus", "Polar", "Vulcan");

    @Override
    public String getPrefix() {
        return mode.getMode();
    }

    @Target
    public void onPreMotion(PreMotionEvent event) {
        if (mc.player.isInWater() && MoveUtil.isMoving()) {
            if (mode.is("Verus")) MoveUtil.strafe(.3F);
            if (mode.is("Polar")) MoveUtil.boost(.1F);
        }

        if (mode.is("Vulcan") && mc.world.getBlockState(new BlockPos(mc.player).down()).getBlock() instanceof BlockLiquid) {
            mc.player.motionY = 0.1F;
        }
    }

    @Target
    public void onMoveInput(MoveInputEvent event) {
        if (mc.player.isInWater() && !mc.gameSettings.keyBindSneak.isKeyDown()) {
            if (mode.is("Verus") || mode.is("Legit")) event.setJumping(true);
        }
    }

}
