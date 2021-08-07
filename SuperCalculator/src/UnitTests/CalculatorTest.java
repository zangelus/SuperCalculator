import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import supercalculator.Tan;

/**
 *
 * @author Haitham Abdel-Salam
 */
class CalculatorTest {

    private Tan tan;

    @BeforeEach
    void setup() {
        tan = new Tan();
    }

    @Test
    @DisplayName("Tan 45 Degrees should work")
    void testTanX() {

        assertEquals(1, tan.calculate(45, false),
                "Tan function with value as degree should work");
    }

    @Test
    @DisplayName("Tan 0.25 (radian) should work")
    void testTanXRadian() {

        assertEquals(0.25534192122103627, tan.calculate(0.25, true),
                "Tan function with value as degree should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of INFINITY")
    @Test
    void testTanInfinityDegree() {
        assertEquals(Double.POSITIVE_INFINITY, tan.calculate(90, false), "Tan 90 should be Infinity/Error");
    }


}
