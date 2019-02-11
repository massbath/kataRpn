import com.lacombe.kata.Rpn;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RpnTest {

    @Test
    public void given_a_simple_number_should_return_the_given_simple_number() {
        Rpn rpn = new Rpn("1");
        assertThat("1").isEqualTo(rpn.calculate());
    }

    @Test
    public void given_multiple_simple_numbers_with_white_space_separator_should_return_the_expression() {
        Rpn rpn = new Rpn("1 2");
        assertThat("1 2").isEqualTo(rpn.calculate());
    }

    @Test
    @Parameters({"1 2 +, 3",
            "1 3 +, 4",
            "1 5 +, 6",
            "2 2 +, 4"
    })
    public void given_multiple_simple_numbers_with_plus_operator_should_return_the_sum_of_simple_numbers(String input, String expected) {
        Rpn rpn = new Rpn(input);
        assertThat(rpn.calculate()).isEqualTo(expected);
    }


    @Test
    public void given_multiple_simple_numbers_with_minus_operator_should_return_the_substract_of_simple_numbers() {
        Rpn rpn = new Rpn("2 1 -");

        assertThat("1").isEqualTo(rpn.calculate());
    }
}
