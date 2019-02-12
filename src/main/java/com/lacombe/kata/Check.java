package com.lacombe.kata;

public class Check {
    public static boolean isValidOperation(Operation operation) {
        if (operation.getOperator() == Operator.DIVISION && operation.getSecondOperand().equals(0))
            return false;
        return true;
    }
}
