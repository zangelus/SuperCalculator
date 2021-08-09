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
        /* TODO: Must add condition for if the base is zero (handle in input)*/
        /* TODO: Also must add unit tests */
        double result = 1; // Holds the result over the steps
        double b = base; // Keeps control of base multiplications

        /* Any number to the power of 0 is 1 */
        if(power == 0)
            return 1;

        while (power > 0) {
            if(power & 1 == 1)
                result = result * b;

            b = b * b;
            power >>= 1;
        }

        return result;
    }

    /**
     * Handles user input and output
     */
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        double inputBase = 0;
        double inputPower = 0;

        
    }
}