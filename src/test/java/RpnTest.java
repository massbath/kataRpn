import com.lacombe.kata.Rpn;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnTest {

    @Test
    public void given_a_simple_number_should_return_the_given_simple_number() {
        Rpn rpn = new Rpn("1");
        assertThat("1").isEqualTo(rpn.calcultate());
    }


}
