package com.lacombe.kata;

import static com.lacombe.kata.Operator.fromValue;

public class Rpn {


    private static final String PLUS_OPERATOR = "+";
    private static final String DIVISION_OPERATOR = "/";
    private static final String SEPARATOR = " ";
    private static final String REGEX = "[-]?[0-9]+ [-]?[0-9]+ [+-/]";
    public static final int FIRST_OPERAND_INDEX = 0;
    public static final int SECOND_OPERAND_INDEX = 1;
    public static final int OPERATOR_INDEX = 2;


    public static String calculate(String input) {


        if (!isValidInput(input))
            return input;

        String[] tmp = input.split(SEPARATOR);


        Integer firstOperand = Integer.valueOf(tmp[FIRST_OPERAND_INDEX]);
        Integer secondOperand = Integer.valueOf(tmp[SECOND_OPERAND_INDEX]);
        String operator = tmp[OPERATOR_INDEX];

        Operation operation = new Operation(firstOperand, secondOperand, operator);
        if (!Check.isValidOperation(operation))
            return input;
        int result = doCalculation(operation);
        return String.valueOf(result);


    }

    private static int doCalculation(Operation operation) {
        Operator operatorEnum = fromValue(operation.getOperator()).get();
        return operatorEnum.operate.apply(operation.getFirstOperand(), operation.getSecondOperand());
    }

    private static boolean isValidInput(String input) {
        return input.matches(REGEX);
    }
}
