/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import static supercalculator.CalculatorUtils.printInvalidDomain;

/**
 *
 * @author za
 */
public class SuperCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        Scanner scanner = null;
        int selection = 0;
            
        while (true) {

            System.out.println("Enter a function numer");
            System.out.println("1 F1");
            System.out.println("3 F3");
            System.out.println("6 Beta(x,y)");
            System.out.println("0 to exit");

            try {
                scanner = new Scanner(System.in);
                selection = scanner.nextInt();

            } catch(Exception ex){
                scanner.next();
            }
            
            switch (selection) {
                case 0:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    throw new Exception("function not implmented");
                case 6:
                    System.out.println("Entr values x and y separated by a whitespace");
                    try {
                        int x; 
                        int y;
                        
                        x = scanner.nextInt();
                        y = scanner.nextInt();

                        Beta beta = new Beta(x,y);
                        beta.calculateInUi();
                        
                    } catch (InputMismatchException e) {
                        
                        printInvalidDomain("Only integers can be use, please try again");
                        
                    } catch (Exception e) {
                        
                        System.out.println(e.getMessage());
                        scanner.next();
                    }
                    break;
                default:
                    break;

            }

        }

    }

}
