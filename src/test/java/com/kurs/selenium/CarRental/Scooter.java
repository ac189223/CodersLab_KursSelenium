package com.kurs.selenium.CarRental;

public class Scooter extends Vehicle {
    public Scooter(String owner, String color){
        this.owner = owner;
        this.color = color;
    }

    public void Crash() {
        System.out.println("Hulajnogi nie mają wypadków");
    }
}