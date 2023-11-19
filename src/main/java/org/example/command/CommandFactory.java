package org.example.command;

import org.example.OutputPrinter;
import org.example.exception.InvalidCommandException;
import org.example.model.Command;
import org.example.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<String, CommandExecutor> commandMapping = new HashMap<>() ;
    public CommandFactory(ParkingLotService parkingLotService) {
        OutputPrinter outputPrinter = new OutputPrinter();

        commandMapping.put(CreateParkingLotCommand.COMMAND_NAME, new CreateParkingLotCommand(parkingLotService, outputPrinter)) ;
        commandMapping.put(ExitCommandExecutor.COMMAND_NAME, new ExitCommandExecutor(parkingLotService, outputPrinter));
        commandMapping.put(ParkCarCommand.COMMAND_NAME, new ParkCarCommand(parkingLotService, outputPrinter));
        commandMapping.put(RemoveCarCommand.COMMAND_NAME, new RemoveCarCommand(parkingLotService, outputPrinter));
        commandMapping.put(GetSlotFromRegistrationCommand.COMMAND_NAME, new GetSlotFromRegistrationCommand(parkingLotService, outputPrinter));
        commandMapping.put(ParkingLotStatusExecutor.COMMAND_NAME, new ParkingLotStatusExecutor(parkingLotService, outputPrinter));
        commandMapping.put(ColorToRegNoCommand.COMMAND_NAME, new ColorToRegNoCommand(parkingLotService, outputPrinter));
        commandMapping.put(ColorToSlotNoCommand.COMMAND_NAME, new ColorToSlotNoCommand(parkingLotService, outputPrinter));


    }

    public CommandExecutor getCommandExecutor(Command command) {
        CommandExecutor commandExecutor = commandMapping.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        } else {
            return commandExecutor ;
        }

    }



}
