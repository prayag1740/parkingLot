package org.example.command;

import org.example.OutputPrinter;
import org.example.model.Command;
import org.example.service.ParkingLotService;

import java.util.List;

public class ColorToRegNoCommand extends CommandExecutor {
    public static String COMMAND_NAME = "color_to_reg_no" ;

    ColorToRegNoCommand(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }
    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        String color = command.getParams().get(0);
        List <String> regNos = parkingLotService.getRegNoFromColor(color) ;
        outputPrinter.printWithNewLine("Registration no with color " + color + " are as follows :");
        outputPrinter.printWithNewLine(regNos.toString());
    }
}
