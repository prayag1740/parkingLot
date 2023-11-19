package org.example.mode;

import org.example.command.CommandExecutor;
import org.example.command.CommandFactory;
import org.example.exception.InvalidCommandException;
import org.example.model.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Mode {

    private final CommandFactory commandFactory;

    public List<String> validFileModes ;
    public Mode(CommandFactory commandFactory){
        this.commandFactory = commandFactory;
        this.validFileModes = new ArrayList<>() ;
        this.validFileModes.add("file");
        this.validFileModes.add("interactive") ;
    }

    public List<String> getValidFileModes() {
        return validFileModes;
    }

    public void runCommand(Command command) {

        CommandExecutor commandExecutor = commandFactory.getCommandExecutor(command);

        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException();
        }
    }

    public abstract void processCommands () throws IOException;

}
