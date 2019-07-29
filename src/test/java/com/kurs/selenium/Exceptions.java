package com.kurs.selenium;

public class Exceptions {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        try {
            int c = a/b;
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("Nie dziel przez zero !");
            e.printStackTrace();
        }
        System.out.println("Hurra !");
    }
}
