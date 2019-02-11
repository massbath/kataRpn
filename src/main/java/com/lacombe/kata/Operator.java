package com.lacombe.kata;

import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (a, b) -> a + b),
    SUBSTRACTION("-", (a, b) -> a - b),
    DIVISION("/", (a, b) -> a / b);

    private final String operator;
    public final BiFunction<Integer, Integer, Integer> operate;

    Operator(String operator, BiFunction<Integer, Integer, Integer> operate) {
        this.operator = operator;
        this.operate = operate;
    }

    static Optional<Operator> fromValue(String value) {
        for (Operator operator : Operator.values()) {
            if (operator.operator.equals(value))
                return Optional.of(operator);
        }
        return Optional.empty();
    }
}
