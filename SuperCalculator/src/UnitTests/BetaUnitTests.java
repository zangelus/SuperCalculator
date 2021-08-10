/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import supercalculator.Beta;
import supercalculator.InvalidDomainException;
import supercalculator.Math;

/**
 *
 * @author za
 */
public class BetaUnitTests {

    @Test
    public void TestBetaValuesWithinTheDomainMapToCorrespondingValuesInTheCoDomain() throws InvalidDomainException {
        
        Beta beta = new Beta(1, 2);
        assertEquals(0.5d, beta.calculate(), java.lang.Math.pow(1, -15));

        beta = new Beta(15, 19);
        assertEquals(6.4278e-11, beta.calculate(), java.lang.Math.pow(1, -15));
        
        beta = new Beta(2, 2);
        assertEquals(0.16667, beta.calculate(), java.lang.Math.pow(1, -5));
        
    }

    @Test
    public void TestBetaFunctionSymmetry() throws Exception {
        Beta beta1 = new Beta(1, 2);
        Beta beta2 = new Beta(2, 1);

        assertEquals(0.5d, beta1.calculate(), java.lang.Math.pow(1, -1));
        assertEquals(beta1.calculate(), beta2.calculate(), java.lang.Math.pow(1, -15));
    }

    @Test(expected = InvalidDomainException.class)
    public void TestThatBetaDoesNotAcceptNegativeIntegersAndThatAnExceptionIsThrow() throws InvalidDomainException {
        Beta beta = new Beta(-1, 1);
        beta.calculate();
    }

    @Test
    public void TestThatBetaReturnsInvalidNumbersInPartOfTheDomain() throws InvalidDomainException {
        Beta beta = new Beta(0, 1);
        assertEquals(Double.NaN, beta.calculate(), java.lang.Math.pow(1, -15));
    }

    @Test
    public void TestFactorialLowerBound() {
        assertEquals(1.0d, Math.calculateFactorial(0), 0.001);
        assertEquals(1.0d, Math.calculateFactorial(1), 0.001);
        assertEquals(Double.NaN, Math.calculateFactorial(-1), 0.001);
    }

    @Test
    public void TestFactorialInvalidDomain() {
        assertEquals(Double.NaN, Math.calculateFactorial(-1), 0.001);
    }
}