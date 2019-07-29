package com.kurs.selenium;

import org.junit.Test;

public class ExceptionTest {

    @Test(expected = ArithmeticException.class)
    public void testException() {
        int c = 1/0;
    }

// Ten test przechodzi
// Test 2/4 nie przejdzie, bo nie ma błędu, a się go spodziewamy

}
