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
        Boolean run = true;
        while (run) {

            System.out.println("Enter a function number");
            System.out.println("1 Tan(x)");
            System.out.println("3 F3");
            System.out.println("6 Beta(x,y)");
            System.out.println("7 Power(x,y)");
            System.out.println("0 to exit");

            try {
                scanner = new Scanner(System.in);
                selection = scanner.nextInt();

            } catch (Exception ex) {
                scanner.next();
            }

            switch (selection) {
                case 0:
                    run = false;
                    break;
                case 1:
                    Tan tanFunc = new Tan();
                    tanFunc.getInput(scanner);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    throw new Exception("function not implmented");
                case 6:
                    
                    Beta beta = new Beta();
                    beta.getInput(scanner);
                    beta.calculateInUi();
                    break;
                case 7:
                	Power power = new Power();
                	power.getInput(scanner);
                	break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
