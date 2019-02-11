package com.lacombe.kata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitQuickcheck.class)
public class RpnTestPBT {

    @Property
    public void given_a_simple_number_should_return_the_given_simple_number(int input) {
        String stringValueOfInput = String.valueOf(input);
        assertThat(Rpn.calculate(stringValueOfInput)).isEqualTo(stringValueOfInput);
    }

    @Property
    public void given_a_random_string_should_return_the_given_simple_number(String input) {
        assertThat(Rpn.calculate(input)).isEqualTo(input);
    }


    @Property
    public void given_multiple_simple_numbers_with_white_space_separator_should_return_the_expression(int firstOperand, int secondOperand) {
        assertThat(Rpn.calculate(firstOperand + " " + secondOperand)).isEqualTo(firstOperand + " " + secondOperand);
    }

    @Property
    public void given_multiple_simple_numbers_with_plus_operator_should_return_the_sum_of_simple_numbers(int firstOperand, int secondOperand) {
        assertThat(Rpn.calculate(firstOperand + " " + secondOperand + " +")).isEqualTo(String.valueOf(firstOperand + secondOperand));
    }

    @Property
    public void given_multiple_simple_numbers_with_minus_operator_should_return_the_substract_of_simple_numbers(int firstOperand, int secondOperand) {
        assertThat(Rpn.calculate(firstOperand + " " + secondOperand + " -")).isEqualTo(String.valueOf(firstOperand - secondOperand));
    }
}
