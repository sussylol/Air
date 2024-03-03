package com.dev.air.module.api;

import com.dev.air.module.api.annotation.ModuleInfo;
import com.dev.air.util.MinecraftInstance;
import com.dev.air.util.ValueInstance;
import net.lenni0451.asmevents.EventManager;

public class Module extends ValueInstance implements MinecraftInstance {

    private final String name = this.getClass().getDeclaredAnnotation(ModuleInfo.class).name();
    private final String description = this.getClass().getDeclaredAnnotation(ModuleInfo.class).description();
    private final Category category = this.getClass().getDeclaredAnnotation(ModuleInfo.class).category();
    private int key = this.getClass().getDeclaredAnnotation(ModuleInfo.class).key();
    private boolean hidden = false;
    private boolean enable;

    public void setup() {
        setEnable(this.getClass().getDeclaredAnnotation(ModuleInfo.class).autoEnable());
    }

    public void setEnable(boolean enable) {
        if (this.enable == enable) return;
        this.enable = enable;

        EventManager.regOrUnreg(this, enable);
        if (enable) onEnable();
        else onDisable();
    }

    public void onEnable() {

    }
    public void onDisable() {}

    public String getPrefix() {
        return "";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnable() {
        return enable;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

}
