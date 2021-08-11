
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Nneamaka Chrysa Adirika
 */
public class GammaTest {

    
    @Test
    public void TestSimpleGammaFunctionRealNumbers(){
        Gamma gamma = new Gamma(20, 0);
        assertEquals(3.7981343012008717E17, gamma.simpleGamma(),0);
    }

    @Test
    public void TestSimpleGammaFunctionHelperComplexNumbers(){
        Gamma gamma = new Gamma(13, 2);
        assertEquals("1.2829420172378185E9 + 2.0i", gamma.simpleGammaHelper());
    }

    @Test
    public void TestSimpleGammaFunctionHelperNumbersNotInDomain(){
        Gamma gamma = new Gamma(0, 0);
        assertEquals("0 is not in the domain of the Gamma function", gamma.simpleGammaHelper());

        //test for negative numbers
        gamma = new Gamma(-2, 0);
        assertEquals("Negative numbers are not in the domain of Gamma", gamma.simpleGammaHelper());

    }

}
