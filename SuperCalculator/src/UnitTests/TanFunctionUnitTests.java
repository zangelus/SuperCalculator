package UnitTests;

import supercalculator.Tan;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Haitham Abdel-Salam
 */
public class TanFunctionUnitTests {

    private static final double DELTA = 1e-15;
    private Tan tan;

    @Before
    public void setup() {
        tan = new Tan();
    }

    @Test
    public void testTanX() {

        assertEquals("Tan 45 should work",1, tan.calculate(45, false), DELTA);
    }

    @Test
    public void testTanXRadian() {

        assertEquals("Tan 0.25 should work",0.25534192122103627, tan.calculate(0.25, true), DELTA);
    }

    @Test
    public void testTanInfinityDegree() {
        assertEquals("Ensuring handling infinity",Double.POSITIVE_INFINITY, tan.calculate(90, false), DELTA);
    }


}
