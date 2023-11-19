package org.example;

public class OutputPrinter {

    public void printWithNewLine(String msg){
        System.out.println(msg);
    }

    public void welcome(){
        printWithNewLine("Welcome to our parking lot");
    }

    public void endParking() {
        printWithNewLine("Thanks for using our parking services");
    }

    public void parkingLotFull() {printWithNewLine("Sorry || Parking is full.");}

    public void invalidFile() {printWithNewLine("Invalid file .. try again");}

}
