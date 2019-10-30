package com.company.restcalculator.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Calculator {
    @NotNull(message = "You must supply a value for operand1")
    private int operand1;
    @NotNull(message = "You must supply a value for operand2")
    private int operand2;

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operant2) {
        this.operand2 = operant2;
    }

    //takes in two integers, calculates the sum, and prints out the equation
    public int add(int a, int b){
        int sum = a + b;
        return sum;
    }

    //takes in two integers, calculates the difference, and prints out the equation
    public int subtract(int a, int b){
        int difference = a - b;
        return difference;
    }


    //takes in two integers, calculates the product, and prints out the equation.
    public int multiply(int a, int b){
        int product = a * b;
        return product;
    }

    //takes in two integers, divides a by b, and prints out the equation.
    public float divide(int a, int b){
        float quotient = a / b;
        return quotient;
    }
}
