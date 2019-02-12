package com.lacombe.kata;

public class Operation {
    private final Integer firstOperand;
    private final Integer secondOperand;
    private final Operator operatorEnum;


    Operation(Integer firstOperand, Integer secondOperand, Operator operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operatorEnum = operator;
    }

    int doCalculation() {
        return operatorEnum.operate.apply(getFirstOperand(), getSecondOperand());
    }

    private Integer getFirstOperand() {
        return firstOperand;
    }

    Integer getSecondOperand() {
        return secondOperand;
    }

    public Operator getOperator() {
        return operatorEnum;
    }


    public static class OperationBuilder {
        private Integer firstOperand;
        private Integer secondOperand;
        private Operator operator;

        static OperationBuilder anOperation() {
            return new OperationBuilder();
        }

        public OperationBuilder withFirstOperand(Integer firstOperand) {
            this.firstOperand = firstOperand;
            return this;
        }

        public OperationBuilder withSecondOperand(Integer secondOperand) {
            this.secondOperand = secondOperand;
            return this;
        }

        public OperationBuilder withOperator(String operator) {
            this.operator = Operator.fromValue(operator).get();
            return this;
        }

        public Operation build() {
            return new Operation(firstOperand, secondOperand, operator);
        }
    }
}
