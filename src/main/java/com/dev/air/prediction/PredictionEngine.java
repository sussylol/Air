package com.dev.air.prediction;

import com.dev.air.prediction.network.EmptyNetworkHandler;
import com.dev.air.util.MinecraftInstance;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class PredictionEngine {

    private final DummyPlayerEntity dummyPlayer;

    public PredictionEngine(EntityPlayerSP entityPlayer) {
        this.dummyPlayer = new DummyPlayerEntity();
        this.dummyPlayer.setPositionAndRotation(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, entityPlayer.rotationYaw, entityPlayer.rotationPitch);
        this.dummyPlayer.setHealth(20);
        this.dummyPlayer.motionX = entityPlayer.motionX;
        this.dummyPlayer.motionY = entityPlayer.motionY;
        this.dummyPlayer.motionZ = entityPlayer.motionZ;
        this.dummyPlayer.isJumping = entityPlayer.isJumping;
    }

    public void runTick() {
        this.dummyPlayer.movementInput = MinecraftInstance.mc.player.movementInput;
        this.dummyPlayer.ticksExisted++;
        this.dummyPlayer.onUpdate();
    }

    public Vec3 getPosition() {
        return dummyPlayer.getPositionVector();
    }

    private static class DummyPlayerEntity extends EntityPlayerSP {

        public DummyPlayerEntity() {
            super(MinecraftInstance.mc, MinecraftInstance.mc.world, new EmptyNetworkHandler(), MinecraftInstance.mc.player.getStatFileWriter());
        }

        @Override
        public float getHealth() {
            return getMaxHealth();
        }

        @Override
        protected boolean isCurrentViewEntity() {
            return false;
        }

        @Override
        public void playSound(String name, float volume, float pitch) {}

        @Override
        protected void playStepSound(BlockPos pos, Block blockIn) {}

    }

}
