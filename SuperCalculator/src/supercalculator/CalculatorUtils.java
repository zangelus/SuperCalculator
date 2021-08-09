package supercalculator;

import java.util.Scanner;

public class CalculatorUtils {

    /**
     * Gets standard function to prompt the user for rounding decimal across all functions and prints result, whith error check
     *@param result  final result that a function produces
     */
    public  static void getOutput(double result)
    {
        while(true) {

            System.out.println("Please enter the number of decimal places. (n) for No. Value must be > 0");
            Scanner scannerInput = new Scanner(System.in);
            String choice = scannerInput.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }
            else
            {
                try {
                    if (Integer.parseInt(choice) < 0  || choice.matches("^\\d+\\.\\d+") ) {
                        System.err.println(" Please enter an Integer bigger than 0");
                        continue;
                    }
                }catch(NumberFormatException ex){
                    System.err.println(" Please enter an Integer bigger than 0");
                    continue;
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
    
    public  static void printInvalidDomain(String message){
        
        System.out.println("___________________________________");
        System.out.println(message);
        System.out.println("___________________________________");
        System.out.println();
        
    }
}
