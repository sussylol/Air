package com.dev.air.util.packet.other;

import net.minecraft.network.play.client.*;
import net.minecraft.network.play.server.*;

import java.util.HashMap;

public class PacketMapping {

    public static HashMap<Class, String> inPackets = new HashMap<>();
    public static HashMap<Class, String> outPackets = new HashMap<>();

    static {
        inPackets.put(S3EPacketTeams.class, "S3EPacketTeams");
        inPackets.put(S1EPacketRemoveEntityEffect.class, "S1EPacketRemoveEntityEffect");
        inPackets.put(S21PacketChunkData.class, "S21PacketChunkData");
        inPackets.put(S27PacketExplosion.class, "S27PacketExplosion");
        inPackets.put(S01PacketJoinGame.class, "S01PacketJoinGame");
        inPackets.put(S44PacketWorldBorder.class, "S44PacketWorldBorder");
        inPackets.put(S19PacketEntityHeadLook.class, "S19PacketEntityHeadLook");
        inPackets.put(S2FPacketSetSlot.class, "S2FPacketSetSlot");
        inPackets.put(S08PacketPlayerPosLook.class, "S08PacketPlayerPosLook");
        inPackets.put(S20PacketEntityProperties.class, "S20PacketEntityProperties");
        inPackets.put(S3FPacketCustomPayload.class, "S3FPacketCustomPayload");
        inPackets.put(S05PacketSpawnPosition.class, "S05PacketSpawnPosition");
        inPackets.put(S14PacketEntity.S17PacketEntityLookMove.class, "S17PacketEntityLookMove");
        inPackets.put(S29PacketSoundEffect.class, "S29PacketSoundEffect");
        inPackets.put(S33PacketUpdateSign.class, "S33PacketUpdateSign");
        inPackets.put(S14PacketEntity.S15PacketEntityRelMove.class, "S15PacketEntityRelMove");
        inPackets.put(S26PacketMapChunkBulk.class, "S26PacketMapChunkBulk");
        inPackets.put(S2CPacketSpawnGlobalEntity.class, "S2CPacketSpawnGlobalEntity");
        inPackets.put(S36PacketSignEditorOpen.class, "S36PacketSignEditorOpen");
        inPackets.put(S03PacketTimeUpdate.class, "S03PacketTimeUpdate");
        inPackets.put(S12PacketEntityVelocity.class, "S12PacketEntityVelocity");
        inPackets.put(S2DPacketOpenWindow.class, "S2DPacketOpenWindow");
        inPackets.put(S0APacketUseBed.class, "S0APacketUseBed");
        inPackets.put(S23PacketBlockChange.class, "S23PacketBlockChange");
        inPackets.put(S06PacketUpdateHealth.class, "S06PacketUpdateHealth");
        inPackets.put(S37PacketStatistics.class, "S37PacketStatistics");
        inPackets.put(S2APacketParticles.class, "S2APacketParticles");
        inPackets.put(S11PacketSpawnExperienceOrb.class, "S11PacketSpawnExperienceOrb");
        inPackets.put(S1DPacketEntityEffect.class, "S1DPacketEntityEffect");
        inPackets.put(S30PacketWindowItems.class, "S30PacketWindowItems");
        inPackets.put(S07PacketRespawn.class, "S07PacketRespawn");
        inPackets.put(S1BPacketEntityAttach.class, "S1BPacketEntityAttach");
        inPackets.put(S10PacketSpawnPainting.class, "S10PacketSpawnPainting");
        inPackets.put(S34PacketMaps.class, "S34PacketMaps");
        inPackets.put(S3APacketTabComplete.class, "S3APacketTabComplete");
        inPackets.put(S47PacketPlayerListHeaderFooter.class, "S47PacketPlayerListHeaderFooter");
        inPackets.put(S3BPacketScoreboardObjective.class, "S3BPacketScoreboardObjective");
        inPackets.put(S0BPacketAnimation.class, "S0BPacketAnimation");
        inPackets.put(S39PacketPlayerAbilities.class, "S39PacketPlayerAbilities");
        inPackets.put(S48PacketResourcePackSend.class, "S48PacketResourcePackSend");
        inPackets.put(S35PacketUpdateTileEntity.class, "S35PacketUpdateTileEntity");
        inPackets.put(S3CPacketUpdateScore.class, "S3CPacketUpdateScore");
        inPackets.put(S43PacketCamera.class, "S43PacketCamera");
        inPackets.put(S49PacketUpdateEntityNBT.class, "S49PacketUpdateEntityNBT");
        inPackets.put(S46PacketSetCompressionLevel.class, "S46PacketSetCompressionLevel");
        inPackets.put(S24PacketBlockAction.class, "S24PacketBlockAction");
        inPackets.put(S3DPacketDisplayScoreboard.class, "S3DPacketDisplayScoreboard");
        inPackets.put(S42PacketCombatEvent.class, "S42PacketCombatEvent");
        inPackets.put(S40PacketDisconnect.class, "S40PacketDisconnect");
        inPackets.put(S18PacketEntityTeleport.class, "S18PacketEntityTeleport");
        inPackets.put(S0CPacketSpawnPlayer.class, "S0CPacketSpawnPlayer");
        inPackets.put(S14PacketEntity.S16PacketEntityLook.class, "S16PacketEntityLook");
        inPackets.put(S13PacketDestroyEntities.class, "S13PacketDestroyEntities");
        inPackets.put(S45PacketTitle.class, "S45PacketTitle");
        inPackets.put(S04PacketEntityEquipment.class, "S04PacketEntityEquipment");
        inPackets.put(S0FPacketSpawnMob.class, "S0FPacketSpawnMob");
        inPackets.put(S09PacketHeldItemChange.class, "S09PacketHeldItemChange");
        inPackets.put(S00PacketKeepAlive.class, "S00PacketKeepAlive");
        inPackets.put(S1FPacketSetExperience.class, "S1FPacketSetExperience");
        inPackets.put(S2BPacketChangeGameState.class, "S2BPacketChangeGameState");
        inPackets.put(S41PacketServerDifficulty.class, "S41PacketServerDifficulty");
        inPackets.put(S0EPacketSpawnObject.class, "S0EPacketSpawnObject");
        inPackets.put(S31PacketWindowProperty.class, "S31PacketWindowProperty");
        inPackets.put(S38PacketPlayerListItem.class, "S38PacketPlayerListItem");
        inPackets.put(S02PacketChat.class, "S02PacketChat");
        inPackets.put(S28PacketEffect.class, "S28PacketEffect");
        inPackets.put(S32PacketConfirmTransaction.class, "S32PacketConfirmTransaction");
        inPackets.put(S19PacketEntityStatus.class, "S19PacketEntityStatus");
        inPackets.put(S2EPacketCloseWindow.class, "S2EPacketCloseWindow");
        inPackets.put(S1CPacketEntityMetadata.class, "S1CPacketEntityMetadata");
        inPackets.put(S22PacketMultiBlockChange.class, "S22PacketMultiBlockChange");
        inPackets.put(S25PacketBlockBreakAnim.class, "S25PacketBlockBreakAnim");
        inPackets.put(S14PacketEntity.class, "S14PacketEntity");
        inPackets.put(S0DPacketCollectItem.class, "S0DPacketCollectItem");

        outPackets.put(C07PacketPlayerDigging.class, "C07PacketPlayerDigging");
        outPackets.put(C03PacketPlayer.class, "C03PacketPlayer");
        outPackets.put(C13PacketPlayerAbilities.class, "C13PacketPlayerAbilities");
        outPackets.put(C18PacketSpectate.class, "C18PacketSpectate");
        outPackets.put(C03PacketPlayer.C04PacketPlayerPosition.class, "C04PacketPlayerPosition");
        outPackets.put(C03PacketPlayer.C05PacketPlayerLook.class, "C05PacketPlayerLook");
        outPackets.put(C12PacketUpdateSign.class, "C12PacketUpdateSign");
        outPackets.put(C03PacketPlayer.C06PacketPlayerPosLook.class, "C06PacketPlayerPosLook");
        outPackets.put(C0FPacketConfirmTransaction.class, "C0FPacketConfirmTransaction");
        outPackets.put(C11PacketEnchantItem.class, "C11PacketEnchantItem");
        outPackets.put(C0EPacketClickWindow.class, "C0EPacketClickWindow");
        outPackets.put(C0CPacketInput.class, "C0CPacketInput");
        outPackets.put(C10PacketCreativeInventoryAction.class, "C10PacketCreativeInventoryAction");
        outPackets.put(C00PacketKeepAlive.class, "C00PacketKeepAlive");
        outPackets.put(C0DPacketCloseWindow.class, "C0DPacketCloseWindow");
        outPackets.put(C0BPacketEntityAction.class, "C0BPacketEntityAction");
        outPackets.put(C14PacketTabComplete.class, "C14PacketTabComplete");
        outPackets.put(C19PacketResourcePackStatus.class, "C19PacketResourcePackStatus");
        outPackets.put(C0APacketAnimation.class, "C0APacketAnimation");
        outPackets.put(C17PacketCustomPayload.class, "C17PacketCustomPayload");
        outPackets.put(C16PacketClientStatus.class, "C16PacketClientStatus");
        outPackets.put(C09PacketHeldItemChange.class, "C09PacketHeldItemChange");
        outPackets.put(C02PacketUseEntity.class, "C02PacketUseEntity");
        outPackets.put(C15PacketClientSettings.class, "C15PacketClientSettings");
        outPackets.put(C01PacketChatMessage.class, "C01PacketChatMessage");
        outPackets.put(C08PacketPlayerBlockPlacement.class, "C08PacketPlayerBlockPlacement");
    }



}
