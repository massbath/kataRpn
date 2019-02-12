package com.lacombe.kata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.lacombe.kata.Operator.fromValue;

public class Rpn {


    private static final String SEPARATOR = " ";
    private static final String REGEX = "[-]?[0-9]+ [-]?[0-9]+ [+-/]";
    private static final String REGEX_MULTIPLE_OPERATION = "[-]?[0-9]+ [-]?[0-9]+ [-]?[0-9]+ [+-/] [+-/]";
    public static final int FIRST_OPERAND_INDEX = 0;
    public static final int SECOND_OPERAND_INDEX = 1;
    public static final int OPERATOR_INDEX = 2;


    public static String calculate(String input) {

        List<String> parts = Stream.of(input.split(SEPARATOR)).collect(Collectors.toList());
        int indexFirstOperator = 0;
        for (int i = 0; i < parts.size(); i++) {
            String part = parts.get(i);
            if (part.matches("[+/-]")) {
                indexFirstOperator = i;
                String subOperation = parts.get(indexFirstOperator - 2) + " " + parts.get(indexFirstOperator - 1) + " " + parts.get(indexFirstOperator);
                String subResult = calculateSingleOperation(subOperation);


                parts.set(indexFirstOperator, subResult);
                parts.remove(indexFirstOperator - 1);
                parts.remove(indexFirstOperator - 2);
                input = String.join(SEPARATOR, parts);

                i -= 2;
            }


        }


        return input;

    }

    private static String calculateSingleOperation(String input) {
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
