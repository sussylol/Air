package com.dev.air.viamcp.util;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;

import java.net.MalformedURLException;
import java.net.URL;

public class VersionUtil {

    public static double getMinimalMotion() {
        boolean onePointSeventeenth = ViaLoadingBase.getInstance().getTargetVersion().isNewerThanOrEqualTo(ProtocolVersion.v1_17);
        boolean onePointNine = ViaLoadingBase.getInstance().getTargetVersion().isNewerThanOrEqualTo(ProtocolVersion.v1_9);
        if (onePointNine && !onePointSeventeenth) return 0.002D;
        if (onePointSeventeenth) return 0.003D;

        return 0.005D;
    }

    public static double getExpandValue() {
        return ViaLoadingBase.getInstance().getTargetVersion().isNewerThanOrEqualTo(ProtocolVersion.v1_9) ? 0 : .1;
    }

    public static URL getParsedResourcePackUrl(String url) {
        try {
            URL uRL = new URL(url);
            String string = uRL.getProtocol();
            return !"http".equals(string) && !"https".equals(string) ? null : uRL;
        } catch (MalformedURLException var3) {
            return null;
        }
    }


}
