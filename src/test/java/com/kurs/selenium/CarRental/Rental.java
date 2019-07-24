package com.kurs.selenium.CarRental;

public class Rental {

    public static void main(String[] args) {
        String owner = "CodersLab";
        Car car1 = new Car(owner, "ruszofy", 3);
        Car car2 = new Car(owner, "blue", 3);
        Scooter scooter = new Scooter(owner, "white");

        car1.StartEngine();
        car1.StopEngine();
        System.out.println(car1.color);
        car2.Crash();
        scooter.Crash();
    }
}