package org.example.model;

import org.example.exception.InvalidCommandException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

    private final String commandName ;
    private final List<String> params ;

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }

    public Command(String input) {
        List<String> tokens = new ArrayList<>(Arrays.asList(input.split(" "))) ;
        if (tokens.size() == 0) {
            throw new InvalidCommandException();
        }
        commandName = tokens.get(0).toLowerCase();
        tokens.remove(0);
        params = tokens ;
    }
}
