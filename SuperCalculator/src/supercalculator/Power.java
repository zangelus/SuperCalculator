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
    public double calculate(double base, int power) {
        double result = 1; // Holds the result over the steps
        double b = base; // Keeps control of base multiplications

        /* 0 elevated to any number greater than zero is 0 */
        if(base == 0) {
            return 0;
        }

        /* Any number to the power of 0 is 1 */
        if(power == 0) {
            return 1;
        }

        while (power > 0) {
            if((power & 1) == 1) {
                result = result * b;
            }

            b = b * b;
            power >>= 1;
        }

        return result;
    }

    /**
     * Handles user input and output
     */
    public void getInput(Scanner scanner) {
        double inputBase = 0;
        int inputPower = 0;
        double result = 0;

        /* Prompt user for the base number */
        while(true) {
            System.out.println("Please enter the value of the base");
            try {
                inputBase = scanner.nextDouble();
            } catch (Exception ex) {
                System.out.println("ERROR! Make sure you type a number!");
                continue;
            }

            break;
        }

        /* Prompt user for the power number */
        while(true) {
            System.out.println("Please enter the value of the exponent (must be a positive integer or zero)");
            try {
                inputPower = scanner.nextInt();
            } catch (Exception ex) {
                System.out.println("ERROR! Make sure you type a positive integer or zero!");
                continue;
            }

            if(inputPower < 0) {
                System.out.println("ERROR! Make sure you type a positive integer or zero!");
                continue;
            }

            break;
        }

        /* Handle 0 to the power of 0 special case */
        if(inputBase == 0 && inputPower == 0) {
            CalculatorUtils.printOutputMessage(" The answer is indeterminate");
            
        } else {
            result = calculate(inputBase, inputPower);
            CalculatorUtils.getOutput(result);
        }
    }
}