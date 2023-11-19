package org.example.command;

import org.example.OutputPrinter;
import org.example.model.Command;
import org.example.model.ParkingLot;
import org.example.model.parking.strategy.NaturalOrderParkingStrategy;
import org.example.service.ParkingLotService;
import org.example.validator.IntegerValidator;

import java.util.List;

public class CreateParkingLotCommand extends CommandExecutor {

     public static String COMMAND_NAME = "create_parking_lot" ;

     CreateParkingLotCommand(ParkingLotService parkingLotService , OutputPrinter outputPrinter) {
         super(parkingLotService, outputPrinter) ;
     }

    @Override
    public boolean validate(Command command) {
        List<String> params = command.getParams();
        if (params.size() != 1) {
            return false ;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public void execute(Command command) {
         int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderParkingStrategy());
        outputPrinter.printWithNewLine("Created a parking lot with " + parkingLot.getCapacity() + " slots");
    }
}
