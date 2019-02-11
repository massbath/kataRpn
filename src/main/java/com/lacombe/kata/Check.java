package com.lacombe.kata;

public class Check {
    public static boolean isValidOperation(Integer firstOperand, Integer secondOperand, String operator) {
        if (operator.equals("/") && secondOperand.equals(0))
            return false;
        return true;
    }
}
