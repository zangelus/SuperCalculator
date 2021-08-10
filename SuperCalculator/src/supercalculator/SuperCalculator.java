package supercalculator;

import java.util.InputMismatchException;
import java.util.Scanner;
//import static supercalculator.supercalculator.CalculatorUtils.printInvalidDomain;

/**
 *
 * @author Nneamaka Adirika
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
            System.out.println("3 Gamma(x)");
            System.out.println("6 Beta(x,y)");
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
                case 2:
                case 3:
                    Gamma gammaFunc = new Gamma();
                    gammaFunc.getInput(scanner);
                    break;
                case 4:
                case 5:
                    throw new Exception("function not implemented");
                case 6:
                default:
                    break;
            }
        }
        scanner.close();
    }
}
