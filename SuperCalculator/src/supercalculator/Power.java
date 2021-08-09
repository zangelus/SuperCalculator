/*
 * Power class
 *
 * August 9th 2021
 *
 */

package supercalculator;

import java.util.Scanner;

/**
 * Power function for super calculator SOEN 6011
 */
public class Power {

    /**
    * Default constructor
    */
    public Power() { }

    /**
     * Calculates the result of the base elevated to the given power using the binary exponentiation algorithm
     * @param base The number that is the base for the operation
     * @param power The number to which the base is elevated to
     */
    public double calculate(double base, double power) {
        double result = 1; // Holds the result over the steps
        double b = base; // Keeps control of base multiplications

        while (power > 0) {
            if(power & 1 == 1)
                result = result * base;

            b = b * b;
            power >>= 1;
        }

        return result;
    }
}