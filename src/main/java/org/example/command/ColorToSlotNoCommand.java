package org.example.command;

import org.example.OutputPrinter;
import org.example.model.Command;
import org.example.service.ParkingLotService;

import java.util.List;

public class ColorToSlotNoCommand extends CommandExecutor {
    public static String COMMAND_NAME = "color_to_slot_no" ;

    ColorToSlotNoCommand(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        String color = command.getParams().get(0);
        List<Integer> slotNos = parkingLotService.getSlotNoFromColor(color) ;
        outputPrinter.printWithNewLine("Slot no with color " + color + " are as follows :");
        outputPrinter.printWithNewLine(slotNos.toString());
    }
}
