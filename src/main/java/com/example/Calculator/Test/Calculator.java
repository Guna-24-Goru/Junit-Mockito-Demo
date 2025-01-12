package com.example.Calculator.Test;

import org.springframework.context.annotation.Primary;

public class Calculator {

    private  final CalculatorService calculatorService;
    public Calculator(CalculatorService calculatorService){
        this.calculatorService =calculatorService;
    }
    public  int add(int a, int b){
        return calculatorService.add(a,b);
    }
    public int subtract(int a ,int b){
        return calculatorService.subtract(a,b);
    }
    public int multiply(int a ,int b){
        return calculatorService.multiply(a,b);
    }
    public int divide (int a , int b){
        if(b==0){
            throw  new IllegalArgumentException("Division by Zero is not allowed-->");
        }
        return calculatorService.divide(a,b);
    }

}
