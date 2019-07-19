package com.kurs.junit;

import static org.junit.Assert.*;
import org.junit.Test;

public class FirstTest {

    @Test
    public void test1() {
        assertEquals(4, 2*2);
    }

    @Test
    public void test2() {
        assertEquals(5, 2*2);
    }

    @Test
    public void test3_doubleNumber() {
        assertEquals(3.33, 10.0/3.0, 0.1);
    }

}
