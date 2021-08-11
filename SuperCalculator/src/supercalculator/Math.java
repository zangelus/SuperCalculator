package supercalculator;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This is the implementation of all additional functions needed for assigned function calculation
 * @author Zbigniew Angelus, Nneamaka Adirika, Haitham Abdel-Salam, Leandro Rodrigues
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
     * Calculates power of a double
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
     * Calculates negative power of a double
     *@param value  number
     * @param n power
     */
    public static double negativePower( double value, double n) {
        double power = 1;
        double n2 = n;
        if(n < 0)
            n2 = -1 * n;
        for (int i = 0; i < n2; i++) {
            power = power * value;
        }
        if(n < 0)
            return 1.0 / power;
        if(n == 0)
            return 1;
        return power;
    }

    /**
     * Calculates power of a integers that are only positive
     *@param value  number
     * @param n power
     */
    public static int calculatePower(final int value, final int n) {

        while (true) {
            if (n < 0) {
                System.out.println("Only Positive Numbers Please");
                continue;
            }
            break;
        }

        int power = 1;

        for (int i = 0; i < n; i++) {
            power = power * value;
        }

        return power;
    }

    /**
     * Validates if a number is numeric
     *@param string  the numeric value in string format to be checked on
     */
    public static boolean isValueNumericDouble(final String string) {
        double value;

        if (string == null || string.equals("")) {
            return false;
        }

        try {
            value = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            System.err.println(" your input can't be parsed to a number");
        }
        return false;
    }

    /**
     * Validates if a number is numeric
     *@param string  the numeric value in string format to be checked on
     */
    public static boolean isValueNumericInteger(final String string) {
        double value;

        if (string == null || string.equals("")) {
            return false;
        }

        try {
            value = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.err.println(" your input can't be parsed to a number");
        }
        return false;
    }

    /**
     * Validates if a number is numeric
     *@param num  the value to be rounded
     * @param  places decimal places
     */
    public static double roundToDecimalPlaces(double num, int places) {
        if (places < 0) throw new IllegalArgumentException();

        String formattedNumber = String.format("%."+places+"f", num);

        return Double.parseDouble(formattedNumber);
    }

    /**
     * Calculates the sine of a double
     * @param x the number to be calculated
     * @return sine value of the double
     */
    public static double sine(double x){
        int startingValue = 3;
        double calculatedValue = Math.convertDegToRad(x);
        final int iterations = 20;
        int multiplier = 1;
        double total = calculatedValue;

        for (int i = startingValue; i < iterations; i += 2) {
            multiplier *= -1;
            double nextTerm = Math.negativePower(calculatedValue, i) / Math.calculateFactorial(i);
            total += multiplier * nextTerm;
        }

        return total;
    }
    /**
     * Calculates the square root of a double
     * @param number the number to be calculated
     * @return square root of the double
     */
    public static double squareRoot(double number) {
        double t;

        double sqrt = number / 2;

        do {
            t = sqrt;
            sqrt = (t + (number / t)) / 2;
        } while ((t - sqrt) != 0);

        return sqrt;
    }
}

