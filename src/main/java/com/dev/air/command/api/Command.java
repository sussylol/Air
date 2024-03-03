package com.dev.air.command.api;

public abstract class Command {

    private final String name;

    public Command(String name) {
        this.name = name;
    }

    public abstract void handleCommand(String args[]);

    public String getName() {
        return name;
    }

}
