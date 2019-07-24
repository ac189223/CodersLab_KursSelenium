package com.kurs.selenium.CarRental;

public class Vehicle {
    protected String owner;
    private boolean isRented;
    private boolean isRunning;
    protected String color;

    public void StartEngine() {
        this.isRunning = true;
        System.out.println("Pyr pyr. Silnik jest w pozycji: " + this.isRunning);
    }

    public void StopEngine() {
        this.isRunning = false;
        System.out.println("Prrrrr. Silnik jest w pozycji: " + this.isRunning);
    }

    public void Crash() {
        System.out.println("Wypadek !");
    }
}