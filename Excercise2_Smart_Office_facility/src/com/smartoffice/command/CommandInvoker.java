package com.smartoffice.command;

public class CommandInvoker {
    public void execute(Command command) {
        command.execute();
    }
}
