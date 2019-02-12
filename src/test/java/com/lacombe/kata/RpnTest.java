package com.lacombe.kata;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RpnTest {

    @Test
    public void given_a_simple_number_should_return_the_given_simple_number() {
        assertThat("1").isEqualTo(Rpn.calculate("1"));
    }

    @Test
    public void given_multiple_simple_numbers_with_white_space_separator_should_return_the_expression() {
        assertThat("1 2").isEqualTo(Rpn.calculate("1 2"));
    }

    @Test
    @Parameters({"1 2 +, 3",
            "1 3 +, 4",
            "1 5 +, 6",
            "2 2 +, 4"
    })
    public void given_multiple_simple_numbers_with_plus_operator_should_return_the_sum_of_simple_numbers(String input, String expected) {
        assertThat(Rpn.calculate(input)).isEqualTo(expected);
    }


    @Test
    public void given_multiple_simple_numbers_with_minus_operator_should_return_the_substract_of_simple_numbers() {
        assertThat(Rpn.calculate("2 1 -")).isEqualTo(Rpn.calculate("1"));
    }

    @Test
    @Parameters({"4 2 /,2",
            "10 20 /,0"
    })
    public void given_multiple_simple_numbers_with_divisor_operator_should_return_the_division_of_simple_numbers(String expression, String resultExpected) {
        assertThat(Rpn.calculate(expression)).isEqualTo(resultExpected);
    }

    @Test
    public void given_simple_numbers_with_impossible_divisor_operator_should_return_the_division_of_simple_numbers() {
        assertThat(Rpn.calculate("4 0 /")).isEqualTo(Rpn.calculate("4 0 /"));
    }

    @Test
    @Parameters({"120 10 5 + -,105",
            "5 14 / 5 /,0",
            "10 10 10 + + 20 -,10",
            "15 7 1 1 + - / 3 +,6"
    })
    public void given_expression_with_more_operation_should_return_the_result_of_all(String expression, String resultExpected) {
        assertThat(Rpn.calculate(expression)).isEqualTo(resultExpected);
    }
}
