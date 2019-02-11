package com.lacombe.kata;

public class Operation {
    private final Integer firstOperand;
    private final Integer secondOperand;
    private final String operator;

    public Operation(Integer firstOperand, Integer secondOperand, String operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public Integer getFirstOperand() {
        return firstOperand;
    }

    public Integer getSecondOperand() {
        return secondOperand;
    }

    public String getOperator() {
        return operator;
    }
}
