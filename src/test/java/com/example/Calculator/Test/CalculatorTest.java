package com.example.Calculator.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
    @InjectMocks
    Calculator calculator;
    @Mock
    CalculatorService calculatorService;
    @BeforeEach
    void setUp(){
        calculator= new Calculator(calculatorService);
    }
    @Test
    public void testAdd(){
        when( calculatorService.add(6,24)).thenReturn(30);
        assertEquals(30,calculator.add(6,24));
        verify(calculatorService).add(6,24);
    }
    @Test
    public void testSubtract(){
        when(calculatorService.subtract(6,24)).thenReturn(-18);
        assertEquals(-18,calculator.subtract(6,24));
        verify(calculatorService).subtract(6,24);
    }
    @Test
    public void testMultiply(){
        when(calculatorService.multiply(6,24)).thenReturn(144);
        assertEquals(144,calculator.multiply(6,24));
        verify(calculatorService).multiply(6,24);
    }
    @Test
    public void testDivide(){
        when(calculatorService.divide(24 ,6)).thenReturn(4);
        assertEquals(4,calculator.divide(24,6));
        verify(calculatorService).divide(24,6);
    }
    @Test
    public void testDivideByZeroThrowsException(){
        assertThrows(IllegalArgumentException.class,()->calculator.divide(24,0));
    }
}
