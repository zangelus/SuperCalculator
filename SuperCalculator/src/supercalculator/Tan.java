
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
        var calculatedValue = (isRad) ? value : Math.convertDegToRad(value);
        return calculateTaylorsSeries(calculatedValue, 1, 2);
    }

    /**
     * helper class that calculates cos. Wasn't added to the Math class since it's exclusively used in the tangent
     * @param  value value in question get Sine
     * @param isRad Check if value is Radian or Degree
     */
    private double sin(final double value, final boolean isRad) {
        var sinStartingValue = 3;
        var calculatedValue = (isRad) ? value : Math.convertDegToRad(value);
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
        final var iterations = 20;
        var multiplier = 1;
        var total = n;

        for (int i = startingValue; i < iterations; i += 2) {
            multiplier *= -1;
            var nextTerm = Math.calculatePower(calculatedValue, i) / Math.calculateFactorial(i);
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
        boolean isRadian = false;
        String answer;
        while (true) {
            System.out.println("Please enter the value type. Is it Radian (R) or Degree (D)");
            try {
                answer = scanner.nextLine();
                answer.toLowerCase();

                if (!(answer.equals("r") || answer.equals("d"))) {
                    System.out.println("Please Enter R or D only");
                    continue;
                }

                isRadian = (answer.toLowerCase().equals("r"));
                break;

            } catch (Exception ex) {
                scanner.next();
            }
        }

        String msg = answer.equals("d") ? "Must be between  [ 0 and 360 ]" : "Must be between[ 0 and \u03C0 ]";
        while (true) {

            System.out.println("Please enter value x for the Tangent function " + msg);
            try {
                String input = scanner.nextLine();

                if (!Math.isValueNumeric(input)) {
                    System.out.println("Please enter a valid number");
                    continue;
                }

                var x = Double.parseDouble(input);

                //checking if input is within limit
                if ( (!isRadian && x > 360) || (isRadian && x > 2 * Math.PI)) {
                    continue;
                }

                String result = String.format(" You answer is " + calculate(x, isRadian));

                System.out.println(result);
                System.lineSeparator();
                System.lineSeparator();
                break;

            } catch (Exception ex) {
                scanner.next();
            }
        }
    }
}
