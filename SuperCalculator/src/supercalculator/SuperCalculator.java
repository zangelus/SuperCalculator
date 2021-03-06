package supercalculator;

import java.util.Scanner;

/**
 * This is the main driver class for all the functions of all group members
 * @author Zbigniew Angelus, Nneamaka Adirika, Haitham Abdel-Salam, Leandro Rodrigues 
 */
public class SuperCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Init();
    }

    private  static  void Init()
    {
        Scanner scanner = null;
        int selection = 0;
        Boolean run = true;
        while (run) {

            System.out.println("Enter a function number");
            System.out.println("1. Tan(x)");
            System.out.println("2. Gamma(x)");
            System.out.println("3. Beta(x,y)");
            System.out.println("4. Power(x,y)");
            System.out.println("0. Exit application");

            try {
                scanner = new Scanner(System.in);
                selection = scanner.nextInt();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
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
                    Gamma gammaFunc = new Gamma();
                    gammaFunc.getInput(scanner);
                    break;
                case 3:
                    Beta beta = new Beta();
                    beta.getInput(scanner);
                    break;
                case 4:
                    Power power = new Power();
                    power.getInput(scanner);
                    break;
                default:
                    break;
            }
        }
        if(scanner !=null){
            scanner.close();
        }
    }

}
