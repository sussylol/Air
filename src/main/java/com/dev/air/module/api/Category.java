package com.dev.air.module.api;

public enum Category {

    COMBAT("Combat"), MOVEMENT("Movement"), PLAYER("Player"), RENDER("Render"), WORLD("World"), EXPLOIT("Exploit"),
    OTHER("Other"), TEST("Test");

    String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
