package org.example.command;

import org.example.OutputPrinter;
import org.example.exception.VehicleNotFoundException;
import org.example.model.Command;
import org.example.service.ParkingLotService;

public class GetSlotFromRegistrationCommand extends CommandExecutor {
    public static String COMMAND_NAME = "slot_number_for_reg_number" ;

    GetSlotFromRegistrationCommand(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1 ;
    }

    @Override
    public void execute(Command command) {
        String regNo = command.getParams().get(0);
        Integer slotNo = parkingLotService.getSLotFromRegistrationNo(regNo);
        if (slotNo == -1) {
            outputPrinter.printWithNewLine("Sorry slot not found for vehicle no " + regNo);
        } else {
            outputPrinter.printWithNewLine("Slot for " + regNo + " is " + slotNo);
        }
    }
}
