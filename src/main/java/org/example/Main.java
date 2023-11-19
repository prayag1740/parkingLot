package org.example;

import org.example.command.CommandFactory;
import org.example.exception.InvalidCommandException;
import org.example.exception.InvalidFileModeException;
import org.example.mode.FileMode;
import org.example.mode.InteractiveMode;
import org.example.service.ParkingLotService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        OutputPrinter outputPrinter = new OutputPrinter();
        ParkingLotService parkingLotService = new ParkingLotService();

        CommandFactory commandFactory = new CommandFactory(parkingLotService);
        outputPrinter.welcome();

        List<String> inputModeParams = getMode();
        String fileMode = inputModeParams.get(0);

        if (fileMode.equals(FileMode.MODE)) {
            String fileName = inputModeParams.get(1);
            try {
                new FileMode(commandFactory, fileName).processCommands();
            } catch (IOException e) {
                System.out.println("caught an error " + e.getMessage());
            }
        } else {
            try {
                new InteractiveMode(commandFactory).processCommands();
            } catch (IOException e) {
                System.out.println("caught an error " + e.getMessage());
            }
        }
    }

    public static List<String> getMode() {
        Scanner scanner = new Scanner(System.in);
        String params = scanner.nextLine();
        List<String> tokens = new ArrayList<>(Arrays.asList(params.split(" "))) ;
        if (tokens.size() == 0 || tokens.size() > 2) {
            throw new InvalidCommandException();
        }
        String mode = tokens.get(0);
        System.out.println(mode);
        if (!mode.equals(FileMode.MODE) && !mode.equals(InteractiveMode.MODE)) {
            throw new InvalidFileModeException();
        }
        return tokens ;
    }
}