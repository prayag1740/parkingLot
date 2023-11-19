package org.example.mode;

import org.example.command.CommandFactory;
import org.example.command.ExitCommandExecutor;
import org.example.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode {

    public static final String MODE = "interactive" ;

    public InteractiveMode(CommandFactory commandFactory) {
        super(commandFactory) ;
    }

    @Override
    public void processCommands() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();
            Command command = new Command(input);
            runCommand(command);
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}
