package org.example.command;

import org.example.OutputPrinter;
import org.example.model.Command;
import org.example.service.ParkingLotService;

import java.util.Map;

public class ParkingLotStatusExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "parking_lot_status";

    ParkingLotStatusExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        Map<String, String> slotStatus = parkingLotService.getCurrentSlotStatus();

        for (Map.Entry<String, String> entry : slotStatus.entrySet() ) {
            String key = entry.getKey();
            String value = entry.getValue();
            outputPrinter.printWithNewLine("slot -- " + key + " " + value );
        }
    }
}
