package com.dev.air.value.impl;

import com.dev.air.event.impl.client.ValueUpdateEvent;
import com.dev.air.value.Value;
import net.lenni0451.asmevents.EventManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ModeValue extends Value<ModeValue> {

    private Consumer<String> setCallback = s -> { };

    private final List<String> modeList = new ArrayList<>();
    private String mode;

    public ModeValue(String displayName, String mode, String... modes) {
        super(displayName.replace(" ", "_").toLowerCase() + "_mode", displayName);
        modeList.addAll(Arrays.asList(modes));
        this.mode = modeList.get(modeList.indexOf(mode));
    }

    public boolean is(String mode) {
        return this.get().equalsIgnoreCase(mode);
    }

    public boolean is(String... modes) {
        for (String s : modes) {
            if (this.getMode().equalsIgnoreCase(s))
                return true;
        }

        return false;
    }

    public String get() {
        return getMode().toLowerCase();
    }

    public String getMode() {
        return mode;
    }

    public ModeValue setMode(String mode) {
        this.mode = mode;
        setCallback.accept(mode);

        EventManager.call(new ValueUpdateEvent(this));
        return this;
    }

    public List<String> getModeList() {
        return modeList;
    }

    public Consumer<String> getSetCallback() {
        return setCallback;
    }

    public ModeValue setSetCallback(Consumer<String> setCallback) {
        this.setCallback = setCallback;
        return this;
    }
}
