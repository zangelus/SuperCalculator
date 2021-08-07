/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalculator;

/**
 *
 * @author za, Haitham Abdel-Salam
 */
public final class Math {

    private Math() {

    }
    /**
     *@PI Fixed PI value
     */
    public static final double PI = 3.141592653589793;

    /**
     *@PI_DEG Fixed PI value in degree
     */
    public static final double PI_DEG = 180;

    /**
     * Function calculates factorial of a givien integer
     *@param n integer to calculate its factorial
     */
    public static double calculateFactorial(final int n) {
        if (n == 0 || n == 1) {
            return 1.0d;
        }
        
        double result = n * calculateFactorial(n - 1);
        return result;
    }

    /**
     * Converts Radian to Degree
     *@param degreeValue value in degrees
     */
    public static double convertDegToRad(final double degreeValue) {
        return degreeValue * (PI / PI_DEG);
    }

    /**
     * Calculates power of a number
     *@param value  number
     * @param n power
     */
    public static double calculatePower(final double value, final double n) {
        double power = 1;

        for (int i = 0; i < n; i++) {
            power = power * value;
        }

        return power;
    }

    /**
     * Validates if a number is numeric
     *@param string  the numeric value in string format to be checked on
     */
    public static boolean isValueNumeric(final String string) {
        double value;

        if (string == null || string.equals("")) {
            return false;
        }

        try {
            value = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(" your input can't be parsed to a number");
        }
        return false;
    }
}
