package com.lacombe.kata;

public class Check {
    public static boolean isValidOperation(Operation operation) {
        if (operation.getOperator().equals("/") && operation.getSecondOperand().equals(0))
            return false;
        return true;
    }
}
