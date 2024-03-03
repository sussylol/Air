package com.dev.air.value.impl;

import com.dev.air.value.Value;

import java.util.ArrayList;
import java.util.List;

public class ListModeValue extends Value {

    private List<ModeState> modes;
    private List<String> enabledModes = new ArrayList<>();

    public ListModeValue(String displayName, String... modes) {
        super(displayName.replace(" ", "_").toLowerCase() + "_range", displayName);
        this.modes = new ArrayList<>();

        for(String s : modes) {
            this.modes.add(new ModeState(this, s));
        }
    }

    public ListModeValue(String displayName) {
        super(displayName.replace(" ", "_").toLowerCase() + "_range", displayName);
        this.modes = new ArrayList<>();
    }

    public List<ModeState> getModes() {
        return modes;
    }

    public ModeState getMode(String name) {
        for (ModeState mode : modes) {
            if(mode.getMode().equalsIgnoreCase(name)) return mode;
        }

        return null;
    }

    public List<String> getEnabledModes() {
        return enabledModes;
    }

    public static class ModeState {
        private final ListModeValue parent;
        private final String mode;
        private boolean state;

        public ModeState(ListModeValue parent, String mode) {
            this.parent = parent;
            this.mode = mode;
            this.state = false;
        }

        public void setState(boolean state) {
            this.state = state;
            if (this.state) parent.enabledModes.add(mode);
            else parent.enabledModes.remove(mode);
        }

        public boolean getState() {
            return state;
        }

        public String getMode() {
            return mode;
        }

    }

}
