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

    @Test
    void testExponent(){
        assertEquals(8, Calculator.exponent(2,3));
    }

    @Test
    void testPowerZeroExponent(){
        assertEquals(1, Calculator.exponent(5,0));
    }

    @Test
    void testPowerNegativeExponent(){
        assertEquals(0.25, Calculator.exponent(2,-2));
    }

    @Test
    void testSquareRoot(){
        assertEquals(4, Calculator.squareRoot(16));
    }

    @Test
    void testSquareRootZero(){
        assertEquals(0, Calculator.squareRoot(0));
    }

    @Test
    void testSquareRootNegative(){
        assertThrows(ArithmeticException.class, () -> {
            Calculator.squareRoot(-4);
        });
    }
}