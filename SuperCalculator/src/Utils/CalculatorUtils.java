package Utils;

import java.awt.*;
import java.util.Scanner;

/**
* 
*@author Zbigniew Angelus, Nneamaka Adirika, Haitham Abdel-Salam, Leandro Rodrigues
*/
public class CalculatorUtils {

    /**
     * Gets standard function to prompt the user for rounding decimal across all functions and prints result, whith error check
     *@param result  final result that a function produces
     */
    public  static void getOutput(double result)
    {
        while(true) {

            printMessege("Please enter the number of decimal places. (n) for No. Value must be > 0", Colors.YELLOW);
            Scanner scannerInput = new Scanner(System.in);
            String choice = scannerInput.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }
            else
            {
                try {
                    if (Integer.parseInt(choice) < 0  || choice.matches("^\\d+\\.\\d+") ) {
                        printMessege(" Please enter an Integer bigger than 0", Colors.YELLOW);
                        continue;
                    }
                }catch(NumberFormatException ex){
                    printMessege(" Please enter an Integer bigger than 0", Colors.RED);
                    continue;
                }

                result = Math.roundToDecimalPlaces(result, Integer.parseInt(choice));
                break;
            }
        }
        printOutputMessage("The result is: " + result, Colors.GREEN);

    }
    
    public static void printOutputMessage(String message, Colors color){

        System.out.print(color);
        System.out.println("___________________________________");
        System.out.println(message);
        System.out.println("___________________________________");
        System.out.println();
        System.out.print(color.RESET);
        
    }
    /**
    * modified output function to be able to print complex number values for the gamma function
    *@param result  final result that a function produces
    *@return double truncated to desired decimal place
    */
    public static double getOutputDouble(double result)
    {
        while(true) {

            printMessege("Please enter the number of decimal places. (n) for No. Value must be > 0", Colors.YELLOW);
            Scanner scannerInput = new Scanner(System.in);
            String choice = scannerInput.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }
            else
            {
                try {
                    if (Integer.parseInt(choice) < 0  || choice.matches("^\\d+\\.\\d+") ) {
                        printMessege(" Please enter an Integer bigger than 0", Colors.RED);
                        continue;
                    }
                }catch(NumberFormatException ex){
                    printMessege(" Please enter an Integer bigger than 0", Colors.RED);
                    continue;
                }

                result = Math.roundToDecimalPlaces(result, Integer.parseInt(choice));
                break;
            }
        }
        return result;
    }

    public static void printMessege(String msg, Colors color)
    {
        System.out.print(color);
        System.out.println(msg);
        System.out.print(color.RESET);
    }

}
