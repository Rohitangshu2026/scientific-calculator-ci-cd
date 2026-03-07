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

    @Test
    void testNaturalLog(){
        assertEquals(1, Calculator.naturalLog(Math.E), 0.0001);
    }

    @Test
    void testNaturalLogOne(){
        assertEquals(0, Calculator.naturalLog(1), 0.0001);
    }

    @Test
    void testNaturalLogNegative(){
        assertThrows(ArithmeticException.class, () -> {
            Calculator.naturalLog(-1);
        });
    }

    @Test
    void testFactorial(){
        assertEquals(120, Calculator.factorial(5));
    }

    @Test
    void testFactorialZero(){
        assertEquals(1, Calculator.factorial(0));
    }

    @Test
    void testFactorialNegative(){
        assertThrows(ArithmeticException.class, () -> {
            Calculator.factorial(-3);
        });
    }
}