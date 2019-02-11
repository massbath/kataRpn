import com.lacombe.kata.Rpn;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void given_multiple_simple_numbers_with_plus_operator_should_return_the_sum_of_simple_numbers() {
        Rpn rpn = new Rpn("1 2 +");
        assertThat("3").isEqualTo(rpn.calculate());

        rpn = new Rpn("1 3 +");
        assertThat("4").isEqualTo(rpn.calculate());

        rpn = new Rpn("1 5 +");
        assertThat("6").isEqualTo(rpn.calculate());
    }
}
