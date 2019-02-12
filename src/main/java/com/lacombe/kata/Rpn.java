package com.lacombe.kata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rpn {


    private static final String SEPARATOR = " ";
    private static final String REGEX = "[-]?[0-9]+ [-]?[0-9]+ [+-/]";
    public static final int FIRST_OPERAND_INDEX = 0;
    public static final int SECOND_OPERAND_INDEX = 1;
    public static final int OPERATOR_INDEX = 2;
    public static final int FIRST_OPERAND_POSITION = 2;
    public static final int SECOND_OPERAND_POSITION = 1;


    public static String calculate(String input) {

        List<String> parts = Stream.of(input.split(SEPARATOR)).collect(Collectors.toList());
        int indexFirstOperator = 0;
        for (int i = 0; i < parts.size(); i++) {
            String part = parts.get(i);
            if (part.matches("[+/-]")) {
                indexFirstOperator = i;
                String firstOperand = parts.get(indexFirstOperator - FIRST_OPERAND_POSITION);
                String secondOperand = parts.get(indexFirstOperator - SECOND_OPERAND_POSITION);
                String operator = parts.get(indexFirstOperator);

                String subResult = calculateSingleOperation(buildOperationExpression(firstOperand, secondOperand, operator));
                input = replaceOperationExpressionByResult(parts, indexFirstOperator, subResult);

                i -= FIRST_OPERAND_POSITION;
            }
        }
        return input;
    }

    private static String replaceOperationExpressionByResult(List<String> parts, int indexFirstOperator, String subResult) {
        String input;
        parts.set(indexFirstOperator, subResult);
        parts.remove(indexFirstOperator - SECOND_OPERAND_POSITION);
        parts.remove(indexFirstOperator - FIRST_OPERAND_POSITION);
        input = String.join(SEPARATOR, parts);
        return input;
    }

    private static String buildOperationExpression(String firstOperand, String secondOperand, String operator) {
        return firstOperand + " " + secondOperand + " " + operator;
    }

    private static String calculateSingleOperation(String input) {
        if (!isValidInput(input))
            return input;
        String[] tmp = input.split(SEPARATOR);
        Integer firstOperand = Integer.valueOf(tmp[FIRST_OPERAND_INDEX]);
        Integer secondOperand = Integer.valueOf(tmp[SECOND_OPERAND_INDEX]);
        String operator = tmp[OPERATOR_INDEX];
        Operation operation = new Operation.OperationBuilder().withFirstOperand(firstOperand).withSecondOperand(secondOperand).withOperator(operator).build();
        if (!Check.isValidOperation(operation)) {
            return input;
        }
        int result = operation.doCalculation();
        return String.valueOf(result);
    }


    private static boolean isValidInput(String input) {
        return input.matches(REGEX);
    }
}
