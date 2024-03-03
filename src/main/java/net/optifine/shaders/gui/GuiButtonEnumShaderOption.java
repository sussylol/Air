package net.optifine.shaders.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.optifine.shaders.config.EnumShaderOption;

public class GuiButtonEnumShaderOption extends GuiButton {
    private EnumShaderOption enumShaderOption = null;

    public GuiButtonEnumShaderOption(EnumShaderOption enumShaderOption, int x, int y, int widthIn, int heightIn) {
        super(enumShaderOption.ordinal(), x, y, widthIn, heightIn, getButtonText(enumShaderOption));
        this.enumShaderOption = enumShaderOption;
    }

    public EnumShaderOption getEnumShaderOption() {
        return this.enumShaderOption;
    }

    private static String getButtonText(EnumShaderOption eso) {
        String s = I18n.format(eso.getResourceKey()) + ": ";

        switch (eso) {
            case ANTIALIASING:
                return s + Shaders.toStringAa(net.optifine.shaders.Shaders.configAntialiasingLevel);

            case NORMAL_MAP:
                return s + Shaders.toStringOnOff(net.optifine.shaders.Shaders.configNormalMap);

            case SPECULAR_MAP:
                return s + Shaders.toStringOnOff(net.optifine.shaders.Shaders.configSpecularMap);

            case RENDER_RES_MUL:
                return s + Shaders.toStringQuality(net.optifine.shaders.Shaders.configRenderResMul);

            case SHADOW_RES_MUL:
                return s + Shaders.toStringQuality(net.optifine.shaders.Shaders.configShadowResMul);

            case HAND_DEPTH_MUL:
                return s + Shaders.toStringHandDepth(net.optifine.shaders.Shaders.configHandDepthMul);

            case CLOUD_SHADOW:
                return s + Shaders.toStringOnOff(net.optifine.shaders.Shaders.configCloudShadow);

            case OLD_HAND_LIGHT:
                return s + net.optifine.shaders.Shaders.configOldHandLight.getUserValue();

            case OLD_LIGHTING:
                return s + net.optifine.shaders.Shaders.configOldLighting.getUserValue();

            case SHADOW_CLIP_FRUSTRUM:
                return s + Shaders.toStringOnOff(net.optifine.shaders.Shaders.configShadowClipFrustrum);

            case TWEAK_BLOCK_DAMAGE:
                return s + Shaders.toStringOnOff(net.optifine.shaders.Shaders.configTweakBlockDamage);

            default:
                return s + net.optifine.shaders.Shaders.getEnumShaderOption(eso);
        }
    }

    public void updateButtonText() {
        this.displayString = getButtonText(this.enumShaderOption);
    }
}
