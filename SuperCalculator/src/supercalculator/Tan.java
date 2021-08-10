
package supercalculator;

import java.util.Scanner;
/*
 * Tangent class
 *
 *
 *
 * 2021-08-07
 *
 * Tangent function for super calculator SOEN 6011
 */

public class Tan {

    /**
     * Default constructor
     */
    public Tan() { }


    /**
     * helper class that calculates cos. Wasn't added to the Math class since it's exclusively used in the tangent
     * @param  value value in question get cosine
     * @param isRad Check if value is Radian or Degree
     */
    private double cos(final double value, final boolean isRad) {
        double calculatedValue = (isRad) ? value : Math.convertDegToRad(value);
        return calculateTaylorsSeries(calculatedValue, 1, 2);
    }

    /**
     * helper class that calculates cos. Wasn't added to the Math class since it's exclusively used in the tangent
     * @param  value value in question get Sine
     * @param isRad Check if value is Radian or Degree
     */
    private double sin(final double value, final boolean isRad) {
        int sinStartingValue = 3;
        double calculatedValue = (isRad) ? value : Math.convertDegToRad(value);
        return calculateTaylorsSeries(calculatedValue, calculatedValue, sinStartingValue);
    }

    /**
     * Calculates Taylors Series up to the 10th term as it's the most reasonable accurate term
     * @param  calculatedValue The value to be calculated
     * @param n starting value in taylor series before the first term
     * @param  startingValue the exponent and factorial base in the first term
     */
    public double calculateTaylorsSeries(final double calculatedValue,
                                         final double n, final int startingValue) {
        final int iterations = 20;
        int multiplier = 1;
        double total = n;

        for (int i = startingValue; i < iterations; i += 2) {
            multiplier *= -1;
            double nextTerm = Math.calculatePower(calculatedValue, i) / Math.calculateFactorial(i);
            total += multiplier * nextTerm;
        }

        return total;
    }

    /**
     * Executes the tangent function by dividing cosine/sine
     * @param isRad Whether it's Radian or Degree
     */
    public double calculate(double x ,boolean isRad) {

        if ((!isRad && x == 90) || (isRad && x == Math.PI / 2)) {

            return Double.POSITIVE_INFINITY;
        }

        return sin(x, isRad) / cos(x, isRad);
    }

    /**
     * Gets Input and produces prompts and checks for the user
     */
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        boolean isRadian;
        String answer = "";
        String msg = "";

        while (true) {
            System.out.println("Please enter the value type. Is it Radian (R) or Degree (D)");
            try {
                answer = scanner.nextLine();

                if (!(answer.equalsIgnoreCase("r") || answer.equalsIgnoreCase("d"))) {
                    System.err.println("Please Enter R or D only");
                    continue;
                }

                isRadian = (answer.equalsIgnoreCase("r"));
                break;

            } catch (Exception ex) {
                scanner.next();
            }
        }

        msg = answer.equalsIgnoreCase("d") ? "Must be between  [ 0 and 360 ]" : "Must be between[ 0 and \u03C0 ]";
        while (true) {

            double result = 0d;
            double x = 0d;
            String input = "";

            System.out.println("Please enter value x for the Tangent function " + msg);
            try {
                input = scanner.nextLine();

                if (!Math.isValueNumericDouble(input)) {
                    System.err.println("Please enter a valid number");
                    continue;
                }

                x = Double.parseDouble(input);

                //checking if input is within limit
                if ( (!isRadian && x > 360) || (!isRadian && x< 0)
                                            || (isRadian && x > 360)
                                            || (isRadian && x > 2 * Math.PI)) {

                    System.err.println("Please enter a number between the constrains");
                    continue;
                }
                result = calculate(x, isRadian);
                CalculatorUtils.getOutput(result);
                break;

            } catch (Exception ex) {
                scanner.next();
            }
        }
    }
}
