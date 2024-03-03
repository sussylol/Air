package com.dev.air.ui.clickgui.imgui;

import com.dev.air.Client;
import com.dev.air.imgui.ImGuiImpl;
import com.dev.air.module.api.Category;
import com.dev.air.module.api.Module;
import com.dev.air.value.Value;
import com.dev.air.value.impl.*;
import imgui.ImGui;
import imgui.ImGuiStyle;
import imgui.flag.ImGuiCol;
import imgui.flag.ImGuiWindowFlags;
import net.minecraft.client.gui.Screen;

import java.awt.*;

public class ImGuiClickUiScreen extends Screen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ImGuiImpl.render(io -> {
            theme();

            int x = 5;
            for (Category category : Category.values()) {
                if (category == Category.TEST && !Client.isDevelopment) continue;
                ImGui.begin(category.getName());

                for (Module module : Client.instance.getModuleManager().get(category)) {
                    renderModule(module);
                }

                ImGui.end();

                x += 155;
            }

            clientSettings();
        });
    }

    private void theme() {
        ImGuiStyle style = ImGui.getStyle();
        style.setColor(ImGuiCol.WindowBg, 0.1f, 0.1f, 0.13f, 1.0f);
        style.setColor(ImGuiCol.MenuBarBg, 0.16f, 0.16f, 0.21f, 1.0f);

        style.setColor(ImGuiCol.Border, 0.44f, 0.37f, 0.61f, 0.29f);
        style.setColor(ImGuiCol.BorderShadow, 0.0f, 0.0f, 0.0f, 0.24f);

        style.setColor(ImGuiCol.Text, 1.0f, 1.0f, 1.0f, 1.0f);
        style.setColor(ImGuiCol.TextDisabled, 0.5f, 0.5f, 0.5f, 1.0f);

        style.setColor(ImGuiCol.Header, 0.13f, 0.13f, 0.17F, 1.0f);
        style.setColor(ImGuiCol.HeaderHovered, 0.19f, 0.2f, 0.25f, 1.0f);
        style.setColor(ImGuiCol.HeaderActive, 0.16f, 0.16f, 0.21f, 1.0f);

        style.setColor(ImGuiCol.Button, 0.13f, 0.13f, 0.17f, 1.0f);
        style.setColor(ImGuiCol.ButtonHovered, 0.19f, 0.2f, 0.25f, 1.0f);
        style.setColor(ImGuiCol.ButtonActive, 0.16f, 0.16f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.CheckMark, 0.74f, 0.58f, 0.98f, 1.0f);

        style.setColor(ImGuiCol.PopupBg, 0.1f, 0.1f, 0.13f, 0.92f);

        style.setColor(ImGuiCol.SliderGrab, 0.44f, 0.37f, 0.61f, 0.54f);
        style.setColor(ImGuiCol.SliderGrabActive, 0.74f, 0.58f, 0.98f, 0.54f);

        style.setColor(ImGuiCol.FrameBg, 0.13F, 0.13F, 0.17F, 1.0F);
        style.setColor(ImGuiCol.FrameBgHovered, 0.19f, 0.2f, 0.25f, 1.0f);
        style.setColor(ImGuiCol.FrameBgActive, 0.16f, 0.16f, 0.21f, 1.0f);

        style.setColor(ImGuiCol.Tab, 0.16f, 0.16f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.TabHovered, 0.24F, 0.24f, 0.32f, 1.0f);
        style.setColor(ImGuiCol.TabActive, 0.2f, 0.22f, 0.27f, 1.0f);
        style.setColor(ImGuiCol.TabUnfocused, 0.16f, 0.16f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.TabUnfocusedActive, 0.16f, 0.16f, 0.21f, 1.0f);

        style.setColor(ImGuiCol.TitleBg, 0.16f, 0.16f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.TitleBgActive, 0.16f, 0.16f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.TitleBgCollapsed, 0.16f, 0.16f, 0.21f, 1.0f);

        style.setColor(ImGuiCol.ScrollbarBg, 0.1f, 0.1f, 0.13f, 1.0f);
        style.setColor(ImGuiCol.ScrollbarGrab, 0.16f, 0.16f, 0.21f, 1.0f);
        style.setColor(ImGuiCol.ScrollbarGrabHovered, 0.19f, 0.2f, 0.25f, 1.0f);
        style.setColor(ImGuiCol.ScrollbarGrabActive, 0.24f, 0.24f, 0.32f, 1.0f);

        style.setColor(ImGuiCol.Separator, 0.44f, 0.37f, 0.61f, 1.0f);
        style.setColor(ImGuiCol.SeparatorHovered, 0.74f, 0.58f, 0.98f, 1.0f);
        style.setColor(ImGuiCol.SeparatorActive, 0.84f, 0.58f, 1.0f, 1.0f);

        style.setColor(ImGuiCol.ResizeGrip, 0.44f, 0.37f, 0.61f, 0.29f);
        style.setColor(ImGuiCol.ResizeGripHovered, 0.74f, 0.58f, 0.98f, 0.29f);
        style.setColor(ImGuiCol.ResizeGripActive, 0.84f, 0.58f, 1.0f, 0.29f);

        style.setColor(ImGuiCol.DockingPreview, 0.44f, 0.37f, 0.61f, 1.0f);

        style.setTabRounding(4);
        style.setScrollbarRounding(9);
        style.setWindowRounding(7);
        style.setGrabRounding(3);
        style.setFrameRounding(3);
        style.setPopupRounding(4);
        style.setChildRounding(4);
    }

    private void clientSettings() {
        ImGui.begin("Main Client Settings");
        Color color = Client.MAIN_COLOR;
        float[] colors = new float[] {color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f};
        ImGui.colorEdit3("Main Color", colors);
        Client.MAIN_COLOR = new Color(Math.round(colors[0] * 255.0f), Math.round(colors[1] * 255.0f), Math.round(colors[2] * 255.0f));;

        Color color1 = Client.ALT_COLOR;
        float[] colors1 = new float[] {color1.getRed() / 255.0f, color1.getGreen() / 255.0f, color1.getBlue() / 255.0f};
        ImGui.colorEdit3("Alt Color", colors1);
        Client.ALT_COLOR = new Color(Math.round(colors1[0] * 255.0f), Math.round(colors1[1] * 255.0f), Math.round(colors1[2] * 255.0f));

        ImGui.end();
    }
    
    private void renderModule(Module module) {
        if (ImGui.collapsingHeader(module.getName())) {
            ImGui.text(module.getDescription());
            defaultCheckbox(module);

            for (Value<?> val : module.getValues()) {
                if (val.shouldDisplay()) {
                    if (val instanceof BooleanValue) {
                        booleanValue(module, (BooleanValue) val);
                    }
                    if (val instanceof NumberValue) {
                        numberValue(module, (NumberValue) val);
                    }
                    if (val instanceof RangeValue) {
                        rangeValue(module, (RangeValue) val);
                    }
                    if (val instanceof ModeValue) {
                        modeValue(module, (ModeValue) val);
                    }
                    if (val instanceof ColorValue) {
                        colorValue(module, (ColorValue) val);
                    }
                    if (val instanceof ListModeValue) {
                        modeListValue(module, (ListModeValue) val);
                    }
                }
            }
        }
    }

    private void defaultCheckbox(Module module) {
        if (ImGui.checkbox("Enabled##" + module.getName(), module.isEnable())) {
            module.setEnable(!module.isEnable());
        }
        ImGui.sameLine();
        if (ImGui.checkbox("Hidden##" + module.getName(), module.isHidden())) {
            module.setHidden(!module.isHidden());
        }
    }

    private String handleName(Value<?> value) {
        return value.getDisplayName();
    }

    private void colorValue(Module module, ColorValue value) {
        Color color = value.getColor();
        float[] colors = new float[] {color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f};
        ImGui.colorEdit3(handleName(value) + "##" + module.getName(), colors);
        Color newColor = new Color(Math.round(colors[0] * 255.0f), Math.round(colors[1] * 255.0f), Math.round(colors[2] * 255.0f));
        if (!newColor.equals(color)) {
            value.setColor(newColor);
        }
    }

    private void modeListValue(Module module, ListModeValue lmv) {
        ImGui.text(lmv.getDisplayName());
        if (ImGui.beginChild(lmv.getDisplayName() + "##" + module.getName(), 500, 150, true, ImGuiWindowFlags.HorizontalScrollbar)) {
            for (int x = 0; x < lmv.getModes().size(); x++) {
                boolean updated = lmv.getModes().get(x).getState();
                if(ImGui.checkbox(lmv.getModes().get(x).getMode() + "##" + module.getName(), updated)) {
                    lmv.getModes().get(x).setState(!lmv.getModes().get(x).getState());
                }
            }
        }

        ImGui.endChild();
    }

    private void booleanValue(Module module, BooleanValue bv) {
        boolean b = bv.isEnabled();
        if(ImGui.checkbox(handleName(bv) + "##" + module.getName(), b)) {
            bv.setEnabled(!bv.isEnabled());
        }
    }

    private void rangeValue(Module module, RangeValue nv) {
        float[] nValue = {(float) nv.getFirst(), (float) nv.getSecond()};
        double lastValue1 = nv.getFirst(), lastValue2 = nv.getSecond();
        ImGui.sliderFloat2(handleName(nv) + "##" + module.getName(), nValue, (float) nv.getMin(), (float) nv.getMax());
        if (lastValue1 != nValue[0]) {
            nv.setFirst(nValue[0]);
        }

        if (lastValue2 != nValue[1]) {
            nv.setSecond(nValue[1]);
        }
    }

    private void numberValue(Module module, NumberValue nv) {
        float[] nValue = {(float) nv.getValue()};
        double lastValue = nv.getValue();
        ImGui.sliderFloat(handleName(nv) + "##" + module.getName(), nValue, (float) nv.getMin(), (float) nv.getMax());
        if (lastValue != nValue[0]) {
            nv.setValue(nValue[0]);
        }
    }

    private void modeValue(Module module, ModeValue mv) {
        String currentSelect = mv.getMode();
        String lastValue = currentSelect;

        if (ImGui.beginCombo(handleName(mv) + "##" + module.getName(), currentSelect)) {
            for (int n = 0; n < mv.getModeList().size(); n++) {
                boolean isSelected = (currentSelect.equals(mv.getMode()));
                if (ImGui.selectable(mv.getModeList().get(n), isSelected)) {
                    currentSelect = mv.getModeList().get(n);
                }
                if (isSelected) {
                    ImGui.setItemDefaultFocus();
                }
            }
            if (lastValue != currentSelect) {
                mv.setMode(currentSelect);
            }
            ImGui.endCombo();
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

}
