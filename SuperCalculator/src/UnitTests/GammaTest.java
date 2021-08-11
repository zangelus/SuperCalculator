package supercalculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import supercalculator.Gamma;
import supercalculator.Math;

/**
 * @author Nneamaka Chrysa Adirika
 */
public class GammaTest {

    @Test
    public void TestSimpleGammaFunctionRealNumbers(){
        Gamma gamma = new Gamma(20, 0);
        assertEquals(2.020790672522353E29, gamma.simpleGamma(),0);
    }
    @Test
    public void TestSimpleGammaFunctionImaginaryNumbers(){
        Gamma gamma = new Gamma(0, 0.5);
        assertEquals(Double.POSITIVE_INFINITY, gamma.simpleGamma(),0);
    }

    @Test
    public void TestSimpleGammaFunctionComplexNumbers(){
        Gamma gamma = new Gamma(13, 2);
        assertEquals(6.2243881449240858E17, gamma.simpleGamma(),0);
    }

}
