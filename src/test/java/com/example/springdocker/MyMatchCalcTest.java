package com.example.springdocker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMatchCalcTest {

    MyMatchCalc myMathCalc;

    @BeforeEach
    void init(){
        myMathCalc = new MyMatchCalc();
    }

    @Test
    void addTest() {
        assertEquals(myMathCalc.add(2,2),4);
        assertEquals(myMathCalc.add(1,2),3);
        assertNotEquals(myMathCalc.add(2,2), 3);
    }

    @Test
    void multiplyTest() {
        assertEquals(myMathCalc.multiply(1,1), 1);
        assertEquals(myMathCalc.multiply(2,2), 4);
        assertNotEquals(myMathCalc.multiply(3,3), 8);
    }

    @Test
    void divideTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            myMathCalc.divide(1,0);
        });

        String expectedMessage = "Can not divide by zero.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));

        assertEquals(myMathCalc.divide(4,2), 2);
        assertEquals(myMathCalc.divide(5,1), 5);
    }
}