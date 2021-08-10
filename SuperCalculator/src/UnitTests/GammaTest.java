package UnitTests;

import org.junit.Test;
import supercalculator.Gamma;
import static org.junit.Assert.assertEquals;

/**
 * @author Nneamaka Chrysa Adirika
 */
public class GammaTest {

@Test
    public void TestSimpleGammaFunctionAccuracy(){
    Gamma gamma = new Gamma(20, 0);
        assertEquals(1.21645100408832224E17, gamma.simpleGamma());
    }

}