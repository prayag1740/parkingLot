package org.example.command;

import org.example.OutputPrinter;
import org.example.exception.NoFreeSlotException;
import org.example.model.Car;
import org.example.model.Command;
import org.example.service.ParkingLotService;

import java.util.List;

public class ParkCarCommand extends CommandExecutor {

    public static String COMMAND_NAME = "park";

    public ParkCarCommand(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2 ;
    }

    @Override
    public void execute(Command command) {
        List<String> params = command.getParams();
        Car car = new Car(params.get(0), params.get(1));
        try {
            Integer slot = parkingLotService.parkCar(car);
            outputPrinter.printWithNewLine("Allocated slot number " + slot);
        } catch (NoFreeSlotException e) {
            outputPrinter.parkingLotFull();
        }
    }
}
