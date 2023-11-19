package org.example.command;

import org.example.OutputPrinter;
import org.example.model.Command;
import org.example.service.ParkingLotService;
import org.example.validator.IntegerValidator;

public class RemoveCarCommand extends CommandExecutor {

    public static String COMMAND_NAME = "remove_car" ;

    RemoveCarCommand(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public void execute(Command command) {
        Integer slotNum = Integer.parseInt(command.getParams().get(0));
        parkingLotService.unParkCar(slotNum);
        outputPrinter.printWithNewLine("Slot number " + slotNum + " is free "  );

    }

    @Override
    public boolean validate(Command command) {
        if (command.getParams().size() != 1) {
            return false ;
        }
        return IntegerValidator.isInteger(command.getParams().get(0));
    }
}
