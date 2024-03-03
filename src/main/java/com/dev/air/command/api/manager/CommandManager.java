package com.dev.air.command.api.manager;

import com.dev.air.command.api.Command;
import com.dev.air.command.impl.BindCommand;

import java.util.ArrayList;

public class CommandManager extends ArrayList<Command> {

    public CommandManager() {
        this.add(new BindCommand("bind"));
    }

}
