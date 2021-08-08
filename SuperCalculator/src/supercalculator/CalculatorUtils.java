package supercalculator;

import java.util.Scanner;

public final class CalculatorUtils {

    /**
     * Gets standard function to prompt the user for rounding decimal across all functions and prints result, whith error check
     *@param result  final result that a function produces
     */
    public  static void getOutput(double result)
    {
        while(true) {

            System.out.println("Would you like to round the result to a given number of Decimal" +
                    " places? please enter the number or (n) for No value must be > 0");
            Scanner scannerInput = new Scanner(System.in);
            String choice = scannerInput.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }
            else
            {
                try {
                    if (Integer.parseInt(choice) < 0  || choice.matches("^\\d+\\.\\d+") ) {
                        System.err.println("Please enter a number > 0 and not a decimal number");
                        continue;
                    }
                }catch(NumberFormatException ex){
                    System.err.println("Please enter a number > 0 and not an decimal number");
                    continue;
                    //request for well-formatted string
                }

                result = Math.roundToDecimalPlaces(result, Integer.parseInt(choice));
                break;
            }
        }
        System.out.println("___________________________________");
        System.out.println(" You answer is " + result);
        System.out.println("___________________________________");
        System.out.println();

    }

}
