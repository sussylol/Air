package com.dev.air.value;

import com.dev.air.value.impl.BooleanValue;
import com.dev.air.value.impl.ModeValue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class Value<T extends Value<?>> {

    private final List<Supplier<Boolean>> displayReqs = new ArrayList<>();

    private String name, description;
    private final String displayName;

    public Value(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public T setName(String name) {
        this.name = name;
        return (T) this;
    }

    public T addDisplay(Supplier<Boolean> display) {
        displayReqs.add(display);
        return (T) this;
    }

    public T requires(ModeValue modeOption, String... mode) {
        addDisplay(() -> modeOption.is(mode));
        if (mode.length > 0)
            setName(getName() + "_REQ_" + mode[0]);
        return (T) this;
    }

    public T requires(BooleanValue booleanValue) {
        addDisplay(booleanValue::isEnabled);
        setName(getName() + "_REQ_" + booleanValue.getName());
        return (T) this;
    }

    public List<Supplier<Boolean>> getDisplayReqs() {
        return displayReqs;
    }

    public boolean shouldDisplay() {
        if (!getDisplayReqs().isEmpty()) {
            for (Supplier<Boolean> s : getDisplayReqs()) {
                if (!s.get()) {
                    return false;
                }
            }
        }
        return true;
    }
}
