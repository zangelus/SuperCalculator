package supercalculator;

import Utils.CalculatorUtils;
import Utils.Colors;
import Utils.Math;

import java.util.*;
/**
 * Gamma class
 * @author Nneamaka Adirika
 *
 *
 * 2021-08-09
 *
 * Gamma function for super calculator SOEN 6011
 */
public class Gamma {
    public static final double[] p = {676.5203681218851
            ,-1259.1392167224028
            ,771.32342877765313
            ,-176.61502916214059
            ,12.507343278686905
            ,-0.13857109526572012
            ,9.9843695780195716e-6
            ,1.5056327351493116e-7};
    public static final double EPSILON = 1e-07;
    public static final double PI = 3.141592653589793;
    public static final double E = 2.718281828459;
    public static double real;
    public static double imaginary;

    /**
     * Default constructor
     */
    public Gamma(){}

    /**
     * Parameterized constructor
     */
    public Gamma(double r, double i){
        real = r;
        imaginary = i;
    }

    /**
     * This function calculates the gamma value for a real or complex number from user.
     * This is calculated by applying Lanczos approximation
     * It is invoked in the getInput method below
     * @return A double representing the gamma of the input value
     */
    public static double simpleGamma(){

        double y;
        if(real < 0.5){
            //reflection formula according to Lanczos approximation
            real -= 1;
            y = PI / (Math.sine(PI*real) * simpleGamma());
        }
        else {
            real -= 1;
            double x = 0.99999999999980993;
            for (int i = 0; i < p.length; i++) {
                x += p[i] / (real + i + 1);
            }
            double t = real + p.length - 0.5;
            y = Math.squareRoot(2 * PI) * Math.negativePower(t,real + 0.5) * Math.negativePower(E,-t) * x;
        }
        return y;
    }

    /**
     * this function helps in the testing the gamma function by calling the main function above
     * @return a string input that can be unit tested for edge cases
     */
    public static String simpleGammaHelper(){
        if(real == 0){
            return "0 is not in the domain of the Gamma function";
        }
        if(real > 0){
            if(imaginary > EPSILON){
                double res = simpleGamma();
                return res + " + " + imaginary + 'i';
            }
        }
        return "Negative numbers are not in the domain of Gamma";
    }

    /**
     * This method is invoked from the supercalculator.SuperCalculator class
     * It then collects user value for a number, calculates the gamma value and displays the result to the user.
     * @param in Scanner class initiated in the supercalculator.SuperCalculator class.
     */
    public static void getInput(Scanner in) {
        double result;
        try {
            while (true) {
                System.out.println("Select one of the following options for the type of number: \n" +
                        "1. real number\n" +
                        "2. complex number\n" +
                        "3. Back to Main Menu");
                int option = in.nextInt();
                if(option < 1 || option > 3) {
                    CalculatorUtils.printOutputMessage("Number has to be between 1 and 3", Colors.RED);
                    continue;
                }
                switch (option) {
                    case 1:
                        System.out.println("Enter a real number:");
                        real = in.nextDouble();
                        imaginary = 0;
                        break;
                    case 2:
                        System.out.println("Enter the real part of the number:");
                        real = in.nextDouble();
                        System.out.println("Enter the imaginary part of the number:");
                        imaginary = in.nextDouble();
                        break;
                    case 3:
                        return;
                }

                if (real <= 0)
                    CalculatorUtils.printMessege("Number has to be a positive real or complex number greater than 0", Colors.RED);

                else {
                    result = simpleGamma();
                    result = CalculatorUtils.getOutputDouble(result);

                    if (imaginary <= EPSILON) {
                        CalculatorUtils.printOutputMessage(result + "", Colors.GREEN);
                    }
                    else {
                        CalculatorUtils.printOutputMessage(result + " + " + imaginary + "i", Colors.GREEN);
                    }

                }
            }
        }catch (InputMismatchException e){
            CalculatorUtils.printOutputMessage("Input not allowed, it has to be a positive number.", Colors.RED);
        }
    }


}
