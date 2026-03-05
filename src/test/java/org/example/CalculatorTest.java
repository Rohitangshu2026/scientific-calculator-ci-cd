package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition(){
        assertEquals(5, Calculator.add(2,3));
    }

    @Test
    void testSubtraction(){
        assertEquals(2, Calculator.subtract(5,3));
    }

    @Test
    void testMultiplication(){
        assertEquals(15, Calculator.multiply(5,3));
    }

    @Test
    void testDivision(){
        assertEquals(2, Calculator.divide(10,5));
    }

    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(10,0);
        });
    }
}