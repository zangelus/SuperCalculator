/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalculator;

import java.util.Scanner;

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
                        
                        int values[] = new int[2];
                        int i = 0;
                        int x; 
                        int y;
                        
                        x = scanner.nextInt();
                        y = scanner.nextInt();

                        F6 f6 = new F6(x,y);
                        f6.isValidDomain();
                        double result = f6.calculate();
                        System.out.println(result);
                        
                    } catch (Exception ex) {
                        scanner.next();
                    }
                    break;
                default:
                    break;

            }

        }

    }

}
