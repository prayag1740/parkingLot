package org.example.model;

public class Car {

    String color ;
    String registrationNo ;

    public Car(String color, String registrationNo) {
        this.color = color ;
        this.registrationNo = registrationNo ;
    }

    public String getColor() {
        return color;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }
}
