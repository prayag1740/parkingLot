package org.example.mode;

import org.example.OutputPrinter;
import org.example.command.CommandFactory;
import org.example.command.ExitCommandExecutor;
import org.example.model.Command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMode extends Mode {

    public static final String MODE = "file" ;


    private final String fileName ;
    OutputPrinter outputPrinter ;

    public FileMode(CommandFactory commandFactory, String fileName) {
        super(commandFactory) ;
        this.fileName = fileName ;
        this.outputPrinter = new OutputPrinter();

    }

    @Override
    public void processCommands() throws IOException {
        File file = new File(fileName) ;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file)) ;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            this.outputPrinter.invalidFile();
            return ;
        }
        String input = reader.readLine();
        while (input != null) {
            Command command = new Command(input);
            runCommand(command);
            input = reader.readLine();
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
            System.out.println("***********************************************************************");
        }
    }
}
