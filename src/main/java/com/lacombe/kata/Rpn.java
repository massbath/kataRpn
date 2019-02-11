package com.lacombe.kata;

public class Rpn {


    private static final String PLUS_OPERATOR = "+";
    private static final String DIVISION_OPERATOR = "/";
    private static final String SEPARATOR = " ";
    private static final String REGEX = "[-]?[0-9]+ [-]?[0-9]+ [+-/]";


    public static String calculate(String input) {


        if (!isValidInput(input))
            return input;

        String[] tmp = input.split(SEPARATOR);


        Integer firstOperand = Integer.valueOf(tmp[0]);
        Integer secondOperand = Integer.valueOf(tmp[1]);
        String operator = tmp[2];
        if (!Check.isValidOperation(firstOperand, secondOperand, operator))
            return input;
        int result = doCalculation(firstOperand, secondOperand, operator);
        return String.valueOf(result);


    }

    private static int doCalculation(Integer firstOperand, Integer secondOperand, String operator) {
        if (operator.equals(PLUS_OPERATOR))
            return firstOperand + secondOperand;

        if (operator.equals(DIVISION_OPERATOR))
            return firstOperand / secondOperand;

        return firstOperand - secondOperand;

    }

    private static boolean isValidInput(String input) {
        return input.matches(REGEX);
    }
}
