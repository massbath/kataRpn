package com.lacombe.kata;

public class Rpn {


    public static final String PLUS_OPERATOR = "+";
    public static final String MINUS_OPERATOR = "-";
    public static final String SEPARATOR = " ";
    private static final String REGEX = "[0-9]+ [0-9]+ [+-]";
    private final String input;

    public Rpn(String input) {

        this.input = input;
    }

    public String calculate() {


     /*   if(!isValidInput(input))
            return input;*/

        String[] tmp = input.split(SEPARATOR);


        if (tmp.length == 3) {

            Integer firstOperand = Integer.valueOf(tmp[0]);
            Integer secondOperand = Integer.valueOf(tmp[1]);
            String operator = tmp[2];
            int result = doCalculation(firstOperand, secondOperand, operator);
            return String.valueOf(result);
        }


        return input;
    }

    private int doCalculation(Integer firstOperand, Integer secondOperand, String operator) {
        if (operator.equals(PLUS_OPERATOR))
            return firstOperand + secondOperand;

        return firstOperand - secondOperand;

    }

    private boolean isValidInput(String input) {
        return REGEX.matches(input);
    }
}
