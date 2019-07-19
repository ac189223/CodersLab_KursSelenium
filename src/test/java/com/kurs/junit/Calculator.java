package com.kurs.junit;

public class Calculator {

//    public int add(String numbers) {
//        return 2;
//    }

    public int add(String numbers) {

        String[] signs = numbers.split("\\+");
        int a = Integer.parseInt(signs[0]);
        int b = Integer.parseInt(signs[1]);
        return a + b;
    }

}
