package com.kurs.selenium.CarRental;

public class Car extends Vehicle{
    private int doorsNumber;

    public Car(String owner, String color, int doorsNumber) {
        this.owner = owner;

        if (color=="ruszofy") {
            System.out.println("Sam jestes ruszofy. Ustawiam kolor na niebieski.");
            this.color = "blue";
        } else {
            this.color = color;
        }

        this.doorsNumber = doorsNumber;
    }
}
